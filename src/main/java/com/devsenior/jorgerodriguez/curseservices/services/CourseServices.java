package com.devsenior.jorgerodriguez.curseservices.services;

import java.util.List;

import com.devsenior.jorgerodriguez.curseservices.model.Course;

//JAVADOC
/**
 * Clase de logica de negocio para gestionar cursos.
 */

public interface CourseServices {

    /**
     * Listar los cursos existentes en el sistema
     * @return Todos los cursos existentes. En caso que no haya ningun curso, devuelve una lista vacia.
     */
    List<Course> getAll();

    /**
     * Consulta el curso que tenga asignado el id dado.
     * @param id el identificador del curso a buscar.
     * @return La informacion del curso que tiene el id dado. 
     * @throws IllegalArgumentException si el id es nulo o menor o igual a 0;
     * @throws CourseNotFoundException Si no se encuentra el id en los cursos del sistema
     */    
    Course getOneById(Long id);

    /**
     * Listar los cursos existentes en el sistema
     * @return
     */
    List<Course> getAllThatContaisName(String name);

    /**
     * Listar los cursos existentes en el sistema
     * @return
     */
    Course create(Course course);

    /**
     * Listar los cursos existentes en el sistema
     * @return
     */
    Course update(Long id, Course course);

    /**
     * Listar los cursos existentes en el sistema
     * @return
     */
    void delete(Long id);
   
}
