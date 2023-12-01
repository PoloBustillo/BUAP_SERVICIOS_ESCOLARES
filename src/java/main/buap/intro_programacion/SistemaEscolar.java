package buap.intro_programacion;

import buap.intro_programacion.models.*;

import javax.swing.*;


public class SistemaEscolar {

    private static String creaPregunta(String Question) {
        return JOptionPane.showInputDialog(null,
                Question,
                Utils.PROYECT_TITLE,
                JOptionPane.QUESTION_MESSAGE);


    }

    private static Object creaDropDownPregunta(String Question, Object[] data) {
        return JOptionPane.showInputDialog(null,
                Question,
                Utils.PROYECT_TITLE,
                JOptionPane.QUESTION_MESSAGE, null,
                data,
                data[0]);
    }

    private static Direccion createDireccion() {
        try {
            String calle = creaPregunta(Utils.QUESTION_CALLE);
            String colonia = creaPregunta(Utils.QUESTION_COLONIA);
            Integer cp = Integer.valueOf(creaPregunta(Utils.QUESTION_CODIGO_POSTAL));
            String ciudad = creaPregunta(Utils.QUESTION_CIUDAD);
            return new Direccion(calle, colonia, cp, ciudad);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "ERROR CP no es numero!!",
                    Utils.PROYECT_TITLE,
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public static void main(String[] args) {

        //CREAR arreglos e indexes que los van a manipular
        //Escuelas - Cursos - Empleados - Alumnos
        Escuela[] escuelas = new Escuela[Utils.MAX_OBJETOS];
        int escuelasIndex = 0;
        Curso[] cursos = new Curso[Utils.MAX_OBJETOS];
        int cursosIndex = 0;
        Empleado[] empleados = new Empleado[Utils.MAX_OBJETOS];
        int empleadosIndex = 0;
        Estudiante[] estudiantes = new Estudiante[Utils.MAX_OBJETOS];
        int estudiantesIndex = 0;


        String opcion;
        do {
            opcion = (String) JOptionPane.showInputDialog(null,
                    Utils.INIT_QUESTION,
                    Utils.PROYECT_TITLE,
                    JOptionPane.QUESTION_MESSAGE, null,
                    Utils.MAIN_MENU,
                    Utils.MAIN_MENU[0]);

            if (opcion != null) {
                switch (opcion) {
                    case Utils.OPCION_UNO -> {
                        escuelas[escuelasIndex] = new Escuela(
                                creaPregunta(Utils.QUESTION_NOMBRE),
                                createDireccion(),
                                (String) creaDropDownPregunta(Utils.QUESTION_NIVEL, Utils.NIVELES)
                        );
                        escuelasIndex++;
                    }
                    case Utils.OPCION_DOS -> {
                        if (escuelas.length != 0) {
                            Escuela escuela = (Escuela) creaDropDownPregunta(Utils.QUESTION_ESCUELA, escuelas);

                            System.out.println(escuela.getNombre());

                            cursosIndex++;
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "ERROR Necesitas escuelas sea mayor que 0",
                                    Utils.PROYECT_TITLE,
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    case Utils.OPCION_TRES -> {
                        if (escuelas.length != 0) {
                            Escuela escuela = (Escuela) creaDropDownPregunta(Utils.QUESTION_ESCUELA, escuelas);

                            System.out.println(escuela.getNombre());

                            empleadosIndex++;
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "ERROR Necesitas escuelas sea mayor que 0",
                                    Utils.PROYECT_TITLE,
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    case Utils.OPCION_CUATRO -> {
                        if (escuelas.length != 0) {
                            Escuela escuela = (Escuela) creaDropDownPregunta(Utils.QUESTION_ESCUELA, escuelas);
                            System.out.println(escuela.getNombre());
                            estudiantesIndex++;
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "ERROR Necesitas escuelas sea mayor que 0",
                                    Utils.PROYECT_TITLE,
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }


                }
            }
        } while (opcion != null && !opcion.equalsIgnoreCase("SALIR"));


    }
}
