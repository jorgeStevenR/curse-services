package com.devsenior.jorgerodriguez.curseservices.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.devsenior.jorgerodriguez.curseservices.exception.CourseNotFoundException;
import com.devsenior.jorgerodriguez.curseservices.model.Course;

@Service
public class CourseServicesInMemory implements CourseServices {

    private AtomicLong consecutive;
    private List<Course> courses;

    public CourseServicesInMemory(){
        courses = new ArrayList<>();
        consecutive = new AtomicLong(1);
    }
 
    @Override
    public List<Course> getAll() {
        return new ArrayList<Course>(courses);
    }

    @Override
    public Course getOneById(Long id)throws IllegalArgumentException{

        validateId(id);
        return courses.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElseThrow( () -> new CourseNotFoundException(
                        String.format("El curso con Id %d no existe!", id)));
    }

    @Override
    public List<Course> getAllThatContaisName(String partialName) {
        if(isBlank(partialName)){
            throw new IllegalArgumentException("no puede estar vacio");
        }

        return courses.stream()
                .filter(c -> c.getName().toLowerCase().contains(partialName.toLowerCase())
                    || c.getDescription().toLowerCase().contains(partialName.toLowerCase()))
                .toList();
    }
    
    @Override
    public Course create(Course course) {
        validateCourse(course);
        //...

        //generamos el id
        course.setId(consecutive.getAndIncrement());

        //agregar el curso a la listar
        courses.add(course);
        return course;
    }

    @Override
    public Course update(Long id, Course course) {
        validateId(id);
        validateCourse(course);

        var existingCourse = getOneById(id);

        existingCourse.setCode(course.getCode());
        existingCourse.setCredits(course.getCredits());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setName(course.getName());
        existingCourse.setInitialDate(course.getInitialDate());
        existingCourse.setFinalDate(course.getFinalDate());
        existingCourse.setId(id);
        
        return existingCourse;
    }

    @Override
    public void delete(Long id) {
        validateId(id);
        var existingCourse = getOneById(id);
        courses.remove(existingCourse);
    }



    private boolean isBlank(String data){
        return data == null || data.isBlank();
    }

    private void validateId(Long id){
        // if(id == null){
        //     throw new IllegalArgumentException("No fue enviado un curso a guardar");
        // }

        // if(id<0){
        //     throw new IllegalArgumentException("El id no puede ser negativo");
        // }
    }

    private void validateCourse(Course course){
        // if(course == null){
        //     throw new IllegalArgumentException("No fue enviado un curso a guardar");
        // }

        // if(isBlank(course.getName())){
        //     throw new IllegalArgumentException("El nombre del curso es obligatorio");
        // }

        // if(course.getCredits() <=0 ){
        //     throw new IllegalArgumentException("Los creditos del curso deben de ser mayores a 0");
        // }

        // if(course.getInitialDate().isAfter(course.getFinalDate())){
        //     throw new IllegalArgumentException("la fecha inicio debe ser anterior a la fecha final..");  
        // }
    }
    
}
