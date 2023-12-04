package buap.intro_programacion;

import buap.intro_programacion.models.*;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Objects;

import static buap.intro_programacion.Utils.NIVELES;

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
        HistorialAcademico[] historialesAcademicos = new HistorialAcademico[Utils.MAX_OBJETOS];
        int historialesAcademicosIndex = 0;

        //Guarde la opción que elija el usuario
        String opcionElegidaPorElUsuario;


        //Muestra los menus hasta que se alcance la siguiente condiciones
        //1. El usuario no cancele
        //2. opcionElegidaPorElUsuario sea diferente de la opción salir
        do {
            //Hacer la pantalla más grande para más comodidad al elegir
            UIManager.put("OptionPane.minimumSize", new Dimension(900, 600));
            //Recupera la opcionElegidaPorElUsuario desde un menu desplegable(dropdown)
            opcionElegidaPorElUsuario = (String) Utils.creaPreguntaDesplegable(Utils.INIT_QUESTION, Utils.MAIN_MENU);

            //Si el usuario no cancelo el menu, entonces entra a un switch
            if (opcionElegidaPorElUsuario != null) {
                //El switch te permite realizar una acción por cada option del menu
                switch (opcionElegidaPorElUsuario) {
                    //CREA ESCUELA
                    case Utils.OPCION_UNO -> {
                        UIManager.put("OptionPane.minimumSize", new Dimension(300, 200));
                        //almacena una nueva escuela en la posición escuelasIndex
                        String nombreDeEscuela = Utils.creaPregunta(Utils.QUESTION_NOMBRE);

                        //Crear un lista para seleccionar multiples niveles de la escuela
                        JList<String> list = new JList<>(NIVELES);
                        JOptionPane.showMessageDialog(
                                null, list, Utils.QUESTION_NIVEL, JOptionPane.PLAIN_MESSAGE);
                        String[] nivelesArray = new String[3];


                        if (!list.getSelectedValuesList().isEmpty())
                            nivelesArray = list.getSelectedValuesList().toArray(nivelesArray);
                        escuelasArray[escuelasIndex] = new Escuela(
                                nombreDeEscuela,
                                Utils.creaDireccion(), nivelesArray

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
                                    Integer.parseInt(Utils.creaPregunta(Utils.QUESTION_AFORO)),
                                    Utils.creaPregunta(Utils.QUESTION_SALON),
                                    (String) Utils.creaPreguntaDesplegable(Utils.QUESTION_HORARIO, Utils.HORARIOS),
                                    Utils.creaPregunta("Nombre del Curso:")
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
                    case Utils.OPCION_CINCO -> {
                        UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
                        //Si al menos existe un empleado y un curso
                        if (empleadosArray[0] != null && cursosArray[0] != null) {
                            Empleado empleado = (Empleado) Utils.creaPreguntaDesplegable(Utils.QUESTION_EMPLEADO, empleadosArray);
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

                            Empleado[] empleadoArraySinNull = Arrays.stream(empleadosArray)
                                    .filter(Objects::nonNull)
                                    .toArray(Empleado[]::new);

                            Utils.mostrarInfoArray("Nominas", empleadoArraySinNull, "Pagando Nomina para:");
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "ERROR Necesita que empleados y cursos sea mayor que 0",
                                    Utils.PROYECT_TITLE,
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    //ASIGNAR CURSO A ESTUDIANTE
                    case Utils.OPCION_SIETE -> {
                        UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
                        //Si al menos existe un estudiante y un curso
                        if (estudiantesArray[0] != null && cursosArray[0] != null) {

                            Estudiante estudiante = (Estudiante) Utils.creaPreguntaDesplegable(Utils.QUESTION_ESTUDIANTE, estudiantesArray);
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
                        if (empleadosArray[0] != null && cursosArray[0] != null && estudiantesArray[0] != null) {
                            Curso cursoSeleccionado = (Curso) Utils.creaPreguntaDesplegable(Utils.QUESTION_CURSO, cursosArray);

                            for (Estudiante estudiante : cursoSeleccionado.getEstudiantes()) {
                                if (estudiante != null) {
                                    float calificacion = Float.parseFloat(JOptionPane.showInputDialog(
                                            null,
                                            "Asignar calificacion para alumno " + estudiante.getNombre() +
                                                    " - Matricula: " + estudiante.getMatricula(),
                                            "Curso: " + cursoSeleccionado.getNombreCurso(),
                                            JOptionPane.QUESTION_MESSAGE));
                                    if (estudiante.getHistorialAcademico() != null) {
                                        Curso[] cursos = estudiante.getHistorialAcademico().getCursos();
                                        int indice = Arrays.asList(cursos).indexOf(cursoSeleccionado);
                                        if (indice != -1) {
                                            estudiante.getHistorialAcademico().getCalificaciones()[indice] = calificacion;
                                        } else {
                                            int newIndice = estudiante.getHistorialAcademico().addCurso(cursoSeleccionado);
                                            estudiante.getHistorialAcademico().getCalificaciones()[newIndice] = calificacion;
                                        }
                                    } else {
                                        HistorialAcademico historialAcademico = new HistorialAcademico(estudiante);
                                        int newIndice = historialAcademico.addCurso(cursoSeleccionado);
                                        historialAcademico.getCalificaciones()[newIndice] = calificacion;
                                        estudiante.setHistorialAcademico(historialAcademico);
                                        historialesAcademicos[historialesAcademicosIndex] = historialAcademico;
                                        historialesAcademicosIndex = historialesAcademicosIndex + 1;
                                    }
                                } else {
                                    break;
                                }
                            }

                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "ERROR Necesitas que estudiantes y cursos sean mayor que 0",
                                    Utils.PROYECT_TITLE,
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    //MOSTRAR ESCUELAS
                    case Utils.OPCION_NUEVE -> {
                        //Elimina todos los nulos del arreglo para no imprimirlos
                        //Ejemplo: string de 4 posiciones [Escuela] [Escuela] [null] [null] solo debe mostrar datos.
                        Escuela[] escuelasArraySinNull = Arrays.stream(escuelasArray)
                                .filter(Objects::nonNull)
                                .toArray(Escuela[]::new);
                        Utils.mostrarInfoArray("Mostrar Todas las Escuelas", escuelasArraySinNull, "Escuela seleccionada:");

                    }
                    //MOSTRAR EMPLEADOS
                    case Utils.OPCION_DIEZ -> {
                        Empleado[] empleadosArraySinNull = Arrays.stream(empleadosArray)
                                .filter(Objects::nonNull)
                                .toArray(Empleado[]::new);
                        Utils.mostrarInfoArray("Mostrar Todos los Empleados", empleadosArraySinNull, "Empleado seleccionado:");

                    }
                    //MOSTRAR ESTUDIANTES
                    case Utils.OPCION_ONCE -> {
                        Estudiante[] estudiantesArraySinNull = Arrays.stream(estudiantesArray)
                                .filter(Objects::nonNull)
                                .toArray(Estudiante[]::new);
                        Utils.mostrarInfoArray("Mostrar Todos los Estudiantes", estudiantesArraySinNull, "Estudiante seleccionado:");

                    }
                    //MOSTRAR CURSOS
                    case Utils.OPCION_DOCE -> {
                        Curso[] cursosArraySinNull = Arrays.stream(cursosArray)
                                .filter(Objects::nonNull)
                                .toArray(Curso[]::new);
                        Utils.mostrarInfoArray("Mostrar Todos los Cursos", cursosArraySinNull, "Curso seleccionado:");

                    }
                    //MOSTRAR HISTORIAL ACADEMICO
                    case Utils.OPCION_TRECE -> {
                        System.out.println(Arrays.toString(historialesAcademicos));
                        Estudiante estudianteSeleccionado = (Estudiante) Utils.creaPreguntaDesplegable(Utils.QUESTION_ESTUDIANTE, estudiantesArray);
                        HistorialAcademico historialAcademico = estudianteSeleccionado.getHistorialAcademico();
                        Curso[] cursos =
                                Arrays.stream(historialAcademico.getCursos())
                                        .filter(Objects::nonNull)
                                        .toArray(Curso[]::new);
                        String[] calificaciones = new String[cursos.length];
                        for (int i = 0; i < cursos.length; i++) {

                            calificaciones[i] = cursos[i].toString() + "  Calificación: " + historialAcademico.getCalificaciones()[i];

                        }
                        Utils.mostrarInfoArray("Mostrar Historial Académico de " + estudianteSeleccionado.getNombre(), calificaciones, "Curso seleccionado:");
                        UIManager.put("OptionPane.minimumSize", new Dimension(300, 200));
                        JOptionPane.showConfirmDialog(null,
                                "Promedio Final: " + historialAcademico.getCalificacionPromedio(),
                                "Calificación del semestre",
                                JOptionPane.OK_CANCEL_OPTION);

                    }
                    //ACTUALIZA ESCUELAS
                    case Utils.OPCION_CATORCE -> {
                        UIManager.put("OptionPane.minimumSize", new Dimension(300, 200));
                        Escuela escuela = (Escuela) Utils.creaPreguntaDesplegable(Utils.QUESTION_ESCUELA, escuelasArray);
                        if (escuela != null) {
                            //almacena una nueva escuela en la posición escuelasIndex
                            String nombreDeEscuela = Utils.creaPreguntaConValorInicial(Utils.QUESTION_NOMBRE, escuela.getNombre());
                            escuela.setNombre(nombreDeEscuela);
                        }
                    }
                    //ACTUALIZA CURSO
                    case Utils.OPCION_UNO_SEIS -> {
                        UIManager.put("OptionPane.minimumSize", new Dimension(300, 200));
                        Curso curso = (Curso) Utils.creaPreguntaDesplegable(Utils.QUESTION_CURSO, cursosArray);
                        if (curso != null) {
                            //almacena una nueva escuela en la posición escuelasIndex
                            String nombreCurso = Utils.creaPreguntaConValorInicial(Utils.QUESTION_NOMBRE, curso.getNombreCurso());
                            curso.setNombreCurso(nombreCurso);
                            int aforo = Integer.parseInt(Utils.creaPreguntaConValorInicial(Utils.QUESTION_AFORO, curso.getAforo()));
                            curso.setAforo(aforo);
                            String salon = Utils.creaPreguntaConValorInicial(Utils.QUESTION_SALON, curso.getSalon());
                            curso.setSalon(salon);
                            String horario = (String) Utils.creaPreguntaDesplegable(Utils.QUESTION_HORARIO, Utils.HORARIOS);
                            curso.setSalon(horario);
                        }
                    }
                    //ACTUALIZA EMPLEADO
                    case Utils.OPCION_UNO_SIETE -> {
                        UIManager.put("OptionPane.minimumSize", new Dimension(300, 200));
                        Empleado empleado = (Empleado) Utils.creaPreguntaDesplegable(Utils.QUESTION_EMPLEADO, empleadosArray);
                        if (empleado != null) {
                            //almacena una nueva escuela en la posición escuelasIndex
                            String nombre = Utils.creaPreguntaConValorInicial(Utils.QUESTION_NOMBRE, empleado.getNombre());
                            empleado.setNombre(nombre);
                            String rfc = Utils.creaPreguntaConValorInicial(Utils.QUESTION_RFC, empleado.getRFC());
                            empleado.setRFC(rfc);
                            String cuenta = Utils.creaPreguntaConValorInicial(Utils.QUESTION_CUENTA, empleado.getCuenta());
                            empleado.setCuenta(cuenta);
                            Float sueldo = Float.parseFloat(Utils.creaPreguntaConValorInicial(Utils.QUESTION_SUELDO, empleado.getSueldo()));
                            empleado.setSueldo(sueldo);
                            Utils.creaDireccionConValorInicial(empleado.getDireccion());

                        }
                    }
                    //ACTUALIZA ESTUDIANTES
                    case Utils.OPCION_UNO_OCHO -> {
                        UIManager.put("OptionPane.minimumSize", new Dimension(300, 200));
                        Estudiante estudiante = (Estudiante) Utils.creaPreguntaDesplegable(Utils.QUESTION_ESTUDIANTE, estudiantesArray);
                        if (estudiante != null) {
                            //almacena una nueva escuela en la posición escuelasIndex
                            String nombre = Utils.creaPreguntaConValorInicial(Utils.QUESTION_NOMBRE, estudiante.getNombre());
                            estudiante.setNombre(nombre);
                            String telefono = Utils.creaPreguntaConValorInicial(Utils.QUESTION_TELEFONO, estudiante.getTelefono());
                            estudiante.setTelefono(telefono);
                            String matricula = Utils.creaPreguntaConValorInicial(Utils.QUESTION_MATRICULA, estudiante.getMatricula());
                            estudiante.setMatricula(matricula);
                            Utils.creaDireccionConValorInicial(estudiante.getDireccionEstudiante());

                        }
                    }
                }
            }
        }
        while (
                opcionElegidaPorElUsuario != null &&
                        !opcionElegidaPorElUsuario.equalsIgnoreCase(Utils.OPCION_SALIR)
        );


    }
}
