package buap.intro_programacion;

import buap.intro_programacion.models.Curso;
import buap.intro_programacion.models.Empleado;
import buap.intro_programacion.models.Escuela;
import buap.intro_programacion.models.Estudiante;

import javax.swing.*;

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
                    case Utils.OPCION_DOS -> {
                        if (escuelasArray[0] != null) {
                            Escuela escuela = (Escuela) Utils.creaPreguntaDesplegable(Utils.QUESTION_ESCUELA, escuelasArray);
                            cursosArray[cursosIndex] = new Curso(
                                    Utils.creaPregunta(Utils.QUESTION_AFORO),
                                    Utils.creaPregunta(Utils.QUESTION_SALON),
                                    (String) Utils.creaPreguntaDesplegable(Utils.QUESTION_HORARIO, Utils.HORARIOS)
                            );
                            escuela.addCurso(cursosArray[cursosIndex]);
                            cursosIndex++;
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "ERROR Necesitas escuelasArray sea mayor que 0",
                                    Utils.PROYECT_TITLE,
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    case Utils.OPCION_TRES -> {
                        if (escuelasArray.length != 0) {
                            Escuela escuela = (Escuela) Utils.creaPreguntaDesplegable(Utils.QUESTION_ESCUELA, escuelasArray);

                            System.out.println(escuela.getNombre());

                            empleadosIndex++;
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "ERROR Necesitas escuelasArray sea mayor que 0",
                                    Utils.PROYECT_TITLE,
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    case Utils.OPCION_CUATRO -> {
                        if (escuelasArray.length != 0) {
                            Escuela escuela = (Escuela) Utils.creaPreguntaDesplegable(Utils.QUESTION_ESCUELA, escuelasArray);
                            System.out.println(escuela.getNombre());
                            estudiantesIndex++;
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


        Escuela[] escuelasArraySinNull = new Escuela[escuelasIndex];
        for (int i = 0; i < escuelasIndex; i++) {
            escuelasArraySinNull[i] = escuelasArray[i];
        }
        Utils.mostrarInfoArray("Mostrar Escuelas", escuelasArraySinNull);
    }
}
