package buap.intro_programacion;

import buap.intro_programacion.models.Curso;
import buap.intro_programacion.models.Empleado;
import buap.intro_programacion.models.Escuela;
import buap.intro_programacion.models.Estudiante;

import javax.swing.*;
import java.util.Arrays;

public class SistemaEscolar {

    //Método principal de nuestra aplicación
    public static void main(String[] args) {

        //CREAR arreglos e indexes que los van a manipular
        //index sirve para manipular arrays, se inicializa en 0
        //Escuelas - Cursos - Empleados - Alumnos
        Escuela[] escuelasArray = new Escuela[Utils.MAX_OBJETOS];
        int escuelasIndex = 0;
        Curso[] cursosArray = new Curso[Utils.MAX_OBJETOS];
        int cursosIndex = 0;
        Empleado[] empleadosArray = new Empleado[Utils.MAX_OBJETOS];
        int empleadosIndex = 0;
        Estudiante[] estudiantesArray = new Estudiante[Utils.MAX_OBJETOS];
        int estudiantesIndex = 0;

        //Guarde la opción que elija el usuario
        String opcionElegidaPorElUsuario;


        //Muestra los menus hasta que se alcance la siguiente condiciones
        //1. El usuario no cancele
        //2. opcionElegidaPorElUsuario sea diferente de la opción salir
        do {

            //Recupera la opcionElegidaPorElUsuario desde un menu desplegable(dropdown)
            opcionElegidaPorElUsuario = (String) Utils.creaPreguntaDesplegable(Utils.INIT_QUESTION, Utils.MAIN_MENU);

            //Si el usuario no cancelo el menu, entonces entra a un switch
            if (opcionElegidaPorElUsuario != null) {
                //El switch te permite realizar una acción por cada option del menu
                switch (opcionElegidaPorElUsuario) {
                    //CREA ESCUELA
                    case Utils.OPCION_UNO -> {
                        //almacena una nueva escuela en la posición escuelasIndex
                        escuelasArray[escuelasIndex] = new Escuela(
                                Utils.creaPregunta(Utils.QUESTION_NOMBRE),
                                Utils.creaDireccion(),
                                (String) Utils.creaPreguntaDesplegable(Utils.QUESTION_NIVEL, Utils.NIVELES)
                        );

                        //Aumento mi índice de la escuela más uno
                        escuelasIndex = escuelasIndex + 1;
                    }
                    //CREA CURSO
                    case Utils.OPCION_DOS -> {
                        //Si almenos existe una escuela
                        if (escuelasArray[0] != null) {
                            //Selecciona una escuela de una ventana desplegable.
                            Escuela escuela = (Escuela) Utils.creaPreguntaDesplegable(Utils.QUESTION_ESCUELA, escuelasArray);
                            //Crea el curso a partir de las preguntas del usuario.
                            cursosArray[cursosIndex] = new Curso(
                                    Utils.creaPregunta(Utils.QUESTION_AFORO),
                                    Utils.creaPregunta(Utils.QUESTION_SALON),
                                    (String) Utils.creaPreguntaDesplegable(Utils.QUESTION_HORARIO, Utils.HORARIOS)
                            );
                            //Añade el curso a la escuela
                            escuela.addCurso(cursosArray[cursosIndex]);
                            //Aumenta el contador de cursos para no sobreescribir la posición en el arreglo.
                            cursosIndex++;
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "ERROR Necesitas escuelasArray sea mayor que 0",
                                    Utils.PROYECT_TITLE,
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    //CREA EMPLEADO
                    case Utils.OPCION_TRES -> {
                        //Si al menos existe una escuela
                        if (escuelasArray.length != 0) {
                            //Selecciona una escuela de una ventana desplegable.
                            Escuela escuela = (Escuela) Utils.creaPreguntaDesplegable(Utils.QUESTION_ESCUELA, escuelasArray);
                            //Crea un nuevo empleado
                            empleadosArray[empleadosIndex] = new Empleado();
                            //Añade empleado a la escuela que le corresponda
                            escuela.addEmpleado(empleadosArray[empleadosIndex]);
                            //Aumenta el contador de empleados para no sobreescribir la posición en el arreglo.
                            empleadosIndex++;
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "ERROR Necesitas escuelasArray sea mayor que 0",
                                    Utils.PROYECT_TITLE,
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    //Crea Estudiante
                    case Utils.OPCION_CUATRO -> {
                        //Si al menos existe una escuela
                        if (escuelasArray.length != 0) {
                            //Selecciona una escuela de una ventana desplegable.
                            Escuela escuela = (Escuela) Utils.creaPreguntaDesplegable(Utils.QUESTION_ESCUELA, escuelasArray);
                            //Crea un nuevo empleado
                            estudiantesArray[escuelasIndex] = new Estudiante();
                            //Añade empleado a la escuela que le corresponda
                            escuela.addEstudiante(estudiantesArray[empleadosIndex]);
                            //Aumenta el contador de empleados para no sobreescribir la posición en el arreglo.
                            estudiantesIndex= estudiantesIndex+1;
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "ERROR Necesitas escuelasArray sea mayor que 0",
                                    Utils.PROYECT_TITLE,
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        }
        while (
                opcionElegidaPorElUsuario != null &&
                        !opcionElegidaPorElUsuario.equalsIgnoreCase(Utils.OPCION_SALIR)
        );


        //Elimina todos los nulos del arreglo para no imprimirlos
        //Ejemplo: string de 4 posiciones [Escuela] [Escuela] [null] [null] solo debe mostrar datos.
        Escuela[] escuelasArraySinNull =  Arrays.stream(escuelasArray)
                .filter(s -> (s != null ))
                .toArray(Escuela[]::new);

        //Muestra el arreglo de escuelas en un menu desplegable.
        Utils.mostrarInfoArray("Mostrar Escuelas", escuelasArraySinNull);
    }
}
