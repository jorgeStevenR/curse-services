package com.devsenior.jorgerodriguez.curseservices.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.jorgerodriguez.curseservices.model.Course;
import com.devsenior.jorgerodriguez.curseservices.services.CourseServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

// DRY Don't Repeat Yourself 
@Tag(name = "Curso", description = "API para la gestion de cursos academicos")
@RestController
@RequestMapping("/api/cursos")
public class CourseController {

    private final CourseServices courseServices;

    public CourseController(CourseServices courseServices) {
        this.courseServices = courseServices;
    }

    @Operation(summary = "Listar todos los curos", description = "Retorna informacion de cursos habilitados en el sistema. ")
    @ApiResponse(responseCode = "200", description = "Listado de cursos encontrados de manera exitosa")
    @ApiResponse(responseCode = "205", description = "No hay cursos disponibles actualmente", content = @Content())
    @ApiResponse(responseCode = "404", description = "No hay cursos", content = @Content())
    @GetMapping()
    public List<Course> getAllCourses() {
        return courseServices.getAll();
    }

    @Operation(summary = "Buscar un curso por id", description = "Consulta la informacion del curso con el id dado")
    @ApiResponse(responseCode = "200", description = "Curso encontrado exitosamente")
    @ApiResponse(responseCode = "404", description = "El curso no fue encontrado")
    @GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Course getCourseById(@PathVariable Long id) {
        return courseServices.getOneById(id);
    }

    @GetMapping("/buscar")
    public List<Course> getCourseContaisName(@RequestParam("nombre") String name) {
        return courseServices.getAllThatContaisName(name);
    }


    @Operation(summary = "Crear un nuevo curso", description = "")
    @PostMapping
    public Course createCourse(
        @RequestBody(description = "Datos del nuevo curso a crear", required = true, 
                content = @Content(schema = @Schema(implementation = Course.class)))
        Course course) {
        return courseServices.create(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        return courseServices.update(id, course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@RequestParam Long id) {
        courseServices.delete(id);
    }

}
