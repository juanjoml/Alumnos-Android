package com.juanjomorcillo.actclasesjuanjomorcillo;

public class Alumno {
    protected String nombre;
    protected int calificacion;
    protected int curso;

    Alumno() {
        nombre = "";
        calificacion = 1;   // Los campos calificación y curso, por defecto serán 1
        curso = 1;
    }

    Alumno(String nombre, int calificacion, int curso) {
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public String estado() {    // Si la nota es inferior a 5 devuelve el String Suspenso, si no, el String Aprobado
        if (calificacion < 5) {
            return "Suspenso";
        } else {
            return "Aprobado";
        }
    }

    public String valoracion() {    // Según cada intervalo de notas, devuelve un String de calificación diferente
        if (calificacion < 5) {
            return "Insuficiente";
        } else if (calificacion == 5 && calificacion < 6) {
            return "Suficiente";
        } else if (calificacion == 6 && calificacion < 7) {
            return "Bien";
        } else if (calificacion == 7 && calificacion < 9) {
            return "Notable";
        } else  {
            return "Sobresaliente";
        }
    }
}