package buap.intro_programacion;

import buap.intro_programacion.models.*;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Calendar;

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
            //Hacer la pantalla más grande para más comodidad al elegir
            UIManager.put("OptionPane.minimumSize", new Dimension(900, 400));
            //Recupera la opcionElegidaPorElUsuario desde un menu desplegable(dropdown)
            opcionElegidaPorElUsuario = (String) Utils.creaPreguntaDesplegable(Utils.INIT_QUESTION, Utils.MAIN_MENU);

            //Si el usuario no cancelo el menu, entonces entra a un switch
            if (opcionElegidaPorElUsuario != null) {
                //El switch te permite realizar una acción por cada option del menu
                switch (opcionElegidaPorElUsuario) {
                    //CREA ESCUELA
                    case Utils.OPCION_UNO -> {
                        UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
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
                        UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
                        //Si almenos existe una escuela y un maestro
                        if (escuelasArray[0] != null && empleadosArray[0] != null) {
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
                                    "ERROR: Necesita que escuelas y profesores sean mayor que 0",
                                    Utils.PROYECT_TITLE,
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    //CREA EMPLEADO
                    case Utils.OPCION_TRES -> {
                        UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
                        //Si al menos existe una escuela
                        if (escuelasArray[0] != null) {
                            //Selecciona una escuela de una ventana desplegable.
                            Escuela escuela = (Escuela) Utils.creaPreguntaDesplegable(Utils.QUESTION_ESCUELA, escuelasArray);
                            //Selecciona una escuela de una ventana desplegable.
                            String tipoEmpleado = (String) Utils.creaPreguntaDesplegable(Utils.QUESTION_TIPO_EMPLEADOS, Utils.TIPO_EMPLEADOS);
                            //Crea un empleado genérico, que se usara como base para crear un empleado en específico.
                            Empleado empleadoGenerico = new Empleado(
                                    Utils.creaPregunta(Utils.QUESTION_NOMBRE),
                                    Utils.creaDireccion(),
                                    Utils.creaPregunta(Utils.QUESTION_RFC),
                                    Utils.creaPregunta(Utils.QUESTION_CUENTA),
                                    Float.parseFloat(Utils.creaPregunta(Utils.QUESTION_SUELDO))
                            );

                            if (tipoEmpleado.equalsIgnoreCase(Utils.EMPLEADO_AUXILIAR)) {
                                //Crea un nuevo empleado
                                empleadosArray[empleadosIndex] = new E_NoAdministrativo(
                                        empleadoGenerico,
                                        (String) Utils.creaPreguntaDesplegable(Utils.QUESTION_TURNO, Utils.TURNOS),
                                        (String) Utils.creaPreguntaDesplegable(Utils.QUESTION_AREA, Utils.AREAS)
                                );
                            }
                            if (tipoEmpleado.equalsIgnoreCase(Utils.EMPLEADO_ACADEMICO)) {
                                //Crea un nuevo empleado
                                empleadosArray[empleadosIndex] = new E_Academico(
                                        empleadoGenerico,
                                        Utils.creaPregunta(Utils.QUESTION_MATERIA),
                                        (String) Utils.creaPreguntaDesplegable(Utils.QUESTION_TURNO, Utils.TURNOS)
                                );

                            }
                            if (tipoEmpleado.equalsIgnoreCase(Utils.EMPLEADO_ADMIN)) {
                                //Crea un nuevo empleado
                                empleadosArray[empleadosIndex] = new E_Administrativo(
                                        empleadoGenerico,
                                        (String) Utils.creaPreguntaDesplegable(Utils.QUESTION_TURNO, Utils.TURNOS),
                                        (String) Utils.creaPreguntaDesplegable(Utils.QUESTION_AREA, Utils.AREAS));
                            }
                            //Añade empleado a la escuela que le corresponda
                            escuela.addEmpleado(empleadosArray[empleadosIndex]);
                            //Aumenta el contador de empleados para no sobreescribir la posición en el arreglo.
                            empleadosIndex = empleadosIndex + 1;
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "ERROR Necesita que escuelasArray sea mayor que 0",
                                    Utils.PROYECT_TITLE,
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    //CREA ESTUDIANTE
                    case Utils.OPCION_CUATRO -> {
                        UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
                        //Si al menos existe una escuela
                        if (escuelasArray[0] != null) {
                            //Selecciona una escuela de una ventana desplegable.
                            Escuela escuela = (Escuela) Utils.creaPreguntaDesplegable(Utils.QUESTION_ESCUELA, escuelasArray);
                            //Crea un nuevo empleado
                            estudiantesArray[estudiantesIndex] = new Estudiante(
                                    Utils.creaPregunta(Utils.QUESTION_NOMBRE),
                                    Utils.creaPregunta(Utils.QUESTION_MATRICULA),
                                    Utils.creaPregunta(Utils.QUESTION_TELEFONO),
                                    Utils.creaDireccion());
                            //Añade empleado a la escuela que le corresponda
                            escuela.addEstudiante(estudiantesArray[empleadosIndex]);
                            //Aumenta el contador de empleados para no sobreescribir la posición en el arreglo.
                            estudiantesIndex = estudiantesIndex + 1;
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "ERROR Necesita que escuelasArray sea mayor que 0",
                                    Utils.PROYECT_TITLE,
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    //ASIGNA CURSO A PROFESOR
                    //TODO:CHECAR POR CURSO DUPLICADO EN PROFESOR
                    case Utils.OPCION_CINCO -> {
                        UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
                        //Si al menos existe un empleado y un curso
                        if (empleadosArray[0] != null && cursosArray[0] != null) {

                            Empleado empleado = (Empleado) Utils.creaPreguntaDesplegable(Utils.QUESTION_ESCUELA, empleadosArray);
                            if (empleado instanceof E_Academico empleadoAcademico) {
                                Curso curso = (Curso) Utils.creaPreguntaDesplegable(Utils.QUESTION_CURSO, cursosArray);
                                empleadoAcademico.asignarCurso(curso);
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "ERROR No es maestro",
                                        Utils.PROYECT_TITLE,
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "ERROR Necesita que empleados y cursos sea mayor que 0",
                                    Utils.PROYECT_TITLE,
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    //CALCULAR NOMINA
                    case Utils.OPCION_SEIS -> {
                        UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
                        //Si al menos existe un empleado
                        if (empleadosArray[0] != null) {
                            //Calcular dia del mes
                            Calendar cal = Calendar.getInstance();
                            int diaDelMes = cal.get(Calendar.DAY_OF_MONTH);

                            Empleado[] empleadoArraySinNull = Arrays.stream(empleadosArray)
                                    .filter(s -> (s != null))
                                    .toArray(Empleado[]::new);

                            //Crea mensajes para mostrar las nóminas.
                            String[] nominas = new String[empleadoArraySinNull.length];
                            for (int i = 0; i < empleadoArraySinNull.length; i++) {
                                nominas[i] = Utils.formateaNomina(empleadoArraySinNull[i], diaDelMes);
                            }

                            Utils.mostrarInfoArray("Nominas", nominas, "Pagando Nomina para:");
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "ERROR Necesita que empleados y cursos sea mayor que 0",
                                    Utils.PROYECT_TITLE,
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    //ASIGNAR CURSO A ESTUDIANTE
                    //TODO:CHECAR POR CURSO DUPLICADO EN ESTUDIANTE
                    case Utils.OPCION_SIETE -> {
                        UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
                        //Si al menos existe un estudiante y un curso
                        System.out.println(Arrays.toString(estudiantesArray));
                        System.out.println(Arrays.toString(cursosArray));
                        if (estudiantesArray[0] != null && cursosArray[0] != null) {

                            Estudiante estudiante = (Estudiante) Utils.creaPreguntaDesplegable(Utils.QUESTION_ESCUELA, estudiantesArray);
                            Curso curso = (Curso) Utils.creaPreguntaDesplegable(Utils.QUESTION_CURSO, cursosArray);
                            estudiante.asignarCurso(curso);

                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "ERROR Necesitas que estudiantes y cursos sean mayor que 0",
                                    Utils.PROYECT_TITLE,
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    //GENERAR HISTORIAL ACADÉMICO
                    case Utils.OPCION_OCHO -> {
                        UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
                        //Si al menos existe un estudiante y un curso
                        Estudiante[] estudiantesConElCursoInscrito = new Estudiante[Utils.MAX_OBJETOS];
                        int indexCursosInscritos = 0;
                        if (empleadosArray[0] != null && cursosArray[0] != null && estudiantesArray[0] != null) {
                            Curso cursoSeleccionado = (Curso) Utils.creaPreguntaDesplegable(Utils.QUESTION_CURSO, cursosArray);
                            for (int i = 0; i < estudiantesArray.length; i++) {
                                Curso[] cursosDelEstudianteNth = estudiantesArray[i].getCursos();
                                for (int j = 0; j < cursosDelEstudianteNth.length; j++) {
                                    if (cursoSeleccionado.getId().equals(cursosDelEstudianteNth[j].getId())) {
                                        estudiantesConElCursoInscrito[indexCursosInscritos] = estudiantesArray[i];
                                        indexCursosInscritos = indexCursosInscritos + 1;
                                        break;
                                    }
                                }
                            }

                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "ERROR Necesitas que estudiantes y cursos sean mayor que 0",
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
        Escuela[] escuelasArraySinNull = Arrays.stream(escuelasArray)
                .filter(s -> (s != null))
                .toArray(Escuela[]::new);
        //Muestra el arreglo de escuelas en un menu desplegable.
        Utils.mostrarInfoArray("Mostrar Escuelas", escuelasArraySinNull, "Escuela seleccionada:");
    }
}
