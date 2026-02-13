package com.devsenior.jorgerodriguez.curseservices.model;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//POJO - Plain Old Java Objet
//JavaBean
//DTO - Data Transfer Objet
@Schema(description = "Representa un curso academico")
public class Course {
    @Schema(description = "Identificador unico generado automaticamente", example = "1")
    private Long id;

    @Schema(description = "Nombre completo del curso",example = "Programacion Basica en java")
    @NotBlank(message = "El campo 'name' es obligatorio")
    private String name;

    @Schema(description = "Codigo unico del curso", example = "Java101")
    @NotBlank(message = "El campo 'code' es obligatorio")
    @Size(min = 5, message = "El campo 'code' debe tener por lo menos 5 caracteres")
    @Size(max = 10, message = "El campo code debe tener maximo 10 caracteres")
    private String code;

    @Schema(description = "Descripcion del curso", example = "Este curso esta orientado a la programacion basica en java")
    private String description;

    @Schema(description = "Fecha inicial de curso ", example ="2026-01-01")
    @FutureOrPresent(message = "La fecha inicial no puede ser anterior a la fecha actual")
    private LocalDate initialDate;
    
    @Schema(description = "Fecha final del curso", example = "2026-01-02")
    @Future(message = "La fecha final debe ser posterior a la fecha actual")
    private LocalDate finalDate;

    @Schema(description = "Creditos del curso",example = "3")
    @Min(value = 1, message = "El campo 'credits' debe tener un valor superior o igual a 1 ")
    @Max(value = 5, message = "El campo 'credits' debe tener un valor inferior o igual a 5")
    private Integer credits;

    public Course() {
    }

    public Course(Long id, String name, String code, String description, LocalDate inicitalDate,LocalDate finalDate, Integer credits) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.initialDate = inicitalDate;
        this.finalDate = finalDate;
        this.credits = credits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDate inicitalDate) {
        this.initialDate = inicitalDate;
    }

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(LocalDate fianlDate) {
        this.finalDate = fianlDate;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((initialDate == null) ? 0 : initialDate.hashCode());
        result = prime * result + ((finalDate == null) ? 0 : finalDate.hashCode());
        result = prime * result + ((credits == null) ? 0 : credits.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Course other = (Course) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (initialDate == null) {
            if (other.initialDate != null)
                return false;
        } else if (!initialDate.equals(other.initialDate))
            return false;
        if (finalDate == null) {
            if (other.finalDate != null)
                return false;
        } else if (!finalDate.equals(other.finalDate))
            return false;
        if (credits == null) {
            if (other.credits != null)
                return false;
        } else if (!credits.equals(other.credits))
            return false;
        return true;
    }

    

}
