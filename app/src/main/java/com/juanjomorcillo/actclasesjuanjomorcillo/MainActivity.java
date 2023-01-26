package com.juanjomorcillo.actclasesjuanjomorcillo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etnombre;
    EditText etcalificacion;
    EditText etcurso;
    EditText etguardar;

    TextView tvAproSusp;
    TextView tvInsufSuf;

    Alumno alumno1;
    Alumno alumno2;
    Alumno alumno3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);                 // Asigno todos los Widgets y creo las 3 instancias de alumno
        etnombre = (EditText)findViewById(R.id.editTextNombre);
        etcalificacion = (EditText)findViewById(R.id.editTextCalificacion);
        etcurso = (EditText)findViewById(R.id.editTextCurso);
        etguardar = (EditText)findViewById(R.id.editTextGuardar);

        alumno1 = new Alumno();
        alumno2 = new Alumno();
        alumno3 = new Alumno();

        tvAproSusp = (TextView)findViewById(R.id.textViewAproSusp);
        tvInsufSuf = (TextView)findViewById(R.id.TextViewInsuficienteSuficiente);

    }
    public void funcionvaciar(View view) {  // Vacío los EditText de nombre, calificación y curso
        etnombre.setText("");
        etcalificacion.setText("");
        etcurso.setText("");
    }


    public void funcionguardar(View view) {

        String nombre = etnombre.getText().toString(); // Guardo en un String el EditText nombre
        int calificacion =  Integer.parseInt(etcalificacion.getText().toString());  // Guardo en 2 enteros los EditText de calificación y curso
        int curso =  Integer.parseInt(etcurso.getText().toString());

        if(nombre.isEmpty()){   // Si nombre está vacío:

            Toast.makeText(this, "Esta vacio", Toast.LENGTH_SHORT).show(); // Lo muestro con un Toast

        }else if(calificacion<0 || calificacion>10){ // Si nombre está lleno, pero la calificación está fuera del rango indicado

            Toast.makeText(this, "Calificacion incorrecta", Toast.LENGTH_SHORT).show(); // Lo muestro con un Toast

        }else if(curso<0){  // Y si se cumplen las condiciones anteriores pero el curso es menor que 0

            Toast.makeText(this, "No puede haber un curso menor que 0", Toast.LENGTH_SHORT).show();  // Lo muestro con otro Toast

        }else{              // Si en cambio, están bien todas las condiciones:

            int guardar=Integer.parseInt(etguardar.getText().toString());   // Me guarda en un entero el EditText guardar

            if(guardar==1)  // Si guardar es 1, lo guarda en el alumno 1, si guardar es 2 lo guarda en el alumno 2, etc
            {
                alumno1.setNombre(nombre);
                alumno1.setCalificacion(calificacion);
                alumno1.setCurso(curso);

                Toast.makeText(this, nombre+"\n"+calificacion+"\n"+curso, Toast.LENGTH_SHORT).show(); // Y lo muestro en un Toast en cada caso
            }
            if(guardar==2)
            {
                alumno2.setNombre(nombre);
                alumno2.setCalificacion(calificacion);
                alumno2.setCurso(curso);
                Toast.makeText(this, nombre+"\n"+calificacion+"\n"+curso, Toast.LENGTH_SHORT).show();
            }
            if(guardar==3)
            {
                alumno3.setNombre(nombre);
                alumno3.setCalificacion(calificacion);
                alumno3.setCurso(curso);
                Toast.makeText(this, nombre+"\n"+calificacion+"\n"+curso, Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void funcionalumno1(View view) {
        // Lo que haya puesto en la clase de alumno1 me lo pone en los EditText de sus atributos correspondientes
        etnombre.setText(alumno1.getNombre());
        etcalificacion.setText(String.valueOf(alumno1.getCalificacion()));
        etcurso.setText(String.valueOf(alumno1.getCurso()));

        tvAproSusp.setText(alumno1.estado()); // Cambio el String del TextView AproSusp según el que me devuelva la función estado() en la clase alumno para alumno1
        tvInsufSuf.setText(alumno1.valoracion());   // Cambio el String del TextView InsufSuf según el que me devuelva la función valoracion() en la clase alumno para alumno1

        // Compruebo todas las combinaciones entre alumnno1 y los otros dos para mostrar el número de alumnos del mismo curso que dicho alumno1
        if  (alumno1.getCurso()==alumno2.getCurso() && alumno1.getCurso()==alumno3.getCurso() && alumno2.getCurso()==alumno3.getCurso())
        {
            Toast.makeText(this, "3 Alumnos", Toast.LENGTH_SHORT).show();
        }
        else if (alumno1.getCurso()==alumno2.getCurso())
        {
            Toast.makeText(this, "2 alumnos", Toast.LENGTH_SHORT).show();
        }
        else if (alumno1.getCurso()==alumno3.getCurso())
        {
            Toast.makeText(this, "2 alumnos", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "1 alumno", Toast.LENGTH_SHORT).show();
        }
    }

    public void funcionalumno2(View view) {
        // Lo que haya puesto en la clase de alumno2 me lo pone en los EditText de sus atributos correspondientes
        etnombre.setText(alumno2.getNombre());
        etcalificacion.setText(String.valueOf(alumno2.getCalificacion()));
        etcurso.setText(String.valueOf(alumno2.getCurso()));

        tvAproSusp.setText(alumno2.estado());  // Cambio el String del TextView AproSusp según el que me devuelva la función estado() en la clase alumno para alumno2
        tvInsufSuf.setText(alumno2.valoracion());   // Cambio el String del TextView InsufSuf según el que me devuelva la función valoracion() en la clase alumno para alumno2

        // Compruebo todas las combinaciones entre alumnno2 y los otros dos para mostrar el número de alumnos del mismo curso que dicho alumno2
        if  (alumno2.getCurso()==alumno1.getCurso() && alumno2.getCurso()==alumno3.getCurso() && alumno1.getCurso()==alumno3.getCurso())
        {
            Toast.makeText(this, "3 Alumnos", Toast.LENGTH_SHORT).show();
        }
        else if (alumno2.getCurso()==alumno1.getCurso())
        {
            Toast.makeText(this, "2 alumnos", Toast.LENGTH_SHORT).show();
        }
        else if (alumno2.getCurso()==alumno3.getCurso())
        {
            Toast.makeText(this, "2 alumnos", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "1 alumno", Toast.LENGTH_SHORT).show();
        }
    }

    public void funcionalumno3(View view) {
        // Lo que haya puesto en la clase de alumno3 me lo pone en los EditText de sus atributos correspondientes
        etnombre.setText(alumno3.getNombre());
        etcalificacion.setText(String.valueOf(alumno3.getCalificacion()));
        etcurso.setText(String.valueOf(alumno3.getCurso()));

        tvAproSusp.setText(alumno3.estado());   // Cambio el String del TextView AproSusp según el que me devuelva la función estado() en la clase alumno para alumno3
        tvInsufSuf.setText(alumno3.valoracion());   // Cambio el String del TextView InsufSuf según el que me devuelva la función valoracion() en la clase alumno para alumno3

        // Compruebo todas las combinaciones entre alumnno3 y los otros dos para mostrar el número de alumnos del mismo curso que dicho alumno3
        if  (alumno3.getCurso()==alumno1.getCurso() && alumno3.getCurso()==alumno2.getCurso() && alumno2.getCurso()==alumno1.getCurso())
        {
            Toast.makeText(this, "3 Alumnos", Toast.LENGTH_SHORT).show();
        }
        else if (alumno3.getCurso()==alumno1.getCurso())
        {
            Toast.makeText(this, "2 alumnos", Toast.LENGTH_SHORT).show();
        }
        else if (alumno3.getCurso()==alumno2.getCurso())
        {
            Toast.makeText(this, "2 alumnos", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "1 alumno", Toast.LENGTH_SHORT).show();
        }
    }
}