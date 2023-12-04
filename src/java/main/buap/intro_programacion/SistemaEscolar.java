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

        //INICIALIZACIÓN DE ARREGLOS USADOS DURANTE ADQUISICIÓN DE INFORMACIÓN
        //CREAR arreglos e índices que los van a manipular
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
            //Regresa el tamaño de la ventana para que no sea tan grande
            UIManager.put("OptionPane.minimumSize", new Dimension(300, 200));

            //Si el usuario no cancelo el menu, entonces entra a un switch
            if (opcionElegidaPorElUsuario != null) {
                //El switch te permite realizar una acción por cada option del menu
                switch (opcionElegidaPorElUsuario) {
                    //CREA ESCUELA
                    case Utils.OPCION_UNO -> {
                        //Pregunta por el nombre de la Escuela y lo almacena en una variable String
                        String nombreDeEscuela = Utils.creaPregunta(Utils.QUESTION_NOMBRE);

                        //Crear un lista para seleccionar multiples niveles de la escuela
                        JList<String> list = new JList<>(NIVELES);
                        //La lista es de multiples opciones con tres opciones principales
                        JOptionPane.showMessageDialog(
                                null, list, Utils.QUESTION_NIVEL, JOptionPane.PLAIN_MESSAGE);
                        //Obtiene los elementos seleccionados en la lista
                        String[] nivelesArray = new String[3];
                        if (!list.getSelectedValuesList().isEmpty()) {
                            nivelesArray = list.getSelectedValuesList().toArray(nivelesArray);
                        }

                        //! Almacena una nueva escuela en la posición escuelasIndex
                        escuelasArray[escuelasIndex] = new Escuela(
                                nombreDeEscuela,
                                Utils.creaDireccion(),
                                nivelesArray
                        );
                        //! Almacena una nueva escuela en la posición escuelasIndex


                        //Aumento mi índice de la escuela más uno
                        escuelasIndex = escuelasIndex + 1;
                    }
                    //CREA CURSO
                    case Utils.OPCION_DOS -> {
                        //Tiene al menos que existir una escuela y un maestro
                        if (escuelasArray[0] != null) {
                            //Selecciona una escuela de una ventana desplegable.
                            Escuela escuela = (Escuela) Utils.creaPreguntaDesplegable(Utils.QUESTION_ESCUELA, escuelasArray);

                            //! Crea el curso a partir de las preguntas del usuario.
                            cursosArray[cursosIndex] = new Curso(
                                    Integer.parseInt(Utils.creaPregunta(Utils.QUESTION_AFORO)),
                                    Utils.creaPregunta(Utils.QUESTION_SALON),
                                    (String) Utils.creaPreguntaDesplegable(Utils.QUESTION_HORARIO, Utils.HORARIOS),
                                    Utils.creaPregunta("Nombre del Curso:")
                            );
                            //! Crea el curso a partir de las preguntas del usuario.


                            //Añade el curso a la escuela
                            escuela.addCurso(cursosArray[cursosIndex]);
                            //Aumenta el contador de cursos para no sobreescribir la posición en el arreglo.
                            cursosIndex++;
                        } else {
                            //Si no existe escuelas manda mensaje de error
                            JOptionPane.showMessageDialog(null,
                                    "ERROR: Necesita que escuelas sea mayor que 0",
                                    Utils.PROYECT_TITLE,
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    //CREA EMPLEADO
                    case Utils.OPCION_TRES -> {
                        //Si al menos existe una escuela
                        if (escuelasArray[0] != null) {
                            //Selecciona una escuela de una ventana desplegable.
                            Escuela escuela = (Escuela) Utils.creaPreguntaDesplegable(Utils.QUESTION_ESCUELA, escuelasArray);
                            //Selecciona el tipo de empleado de una ventana desplegable.
                            String tipoEmpleado = (String) Utils.creaPreguntaDesplegable(Utils.QUESTION_TIPO_EMPLEADOS, Utils.TIPO_EMPLEADOS);

                            //! Crea un empleado genérico, que se usara como base para crear un empleado en específico.
                            Empleado empleadoGenerico = new Empleado(
                                    Utils.creaPregunta(Utils.QUESTION_NOMBRE),
                                    Utils.creaDireccion(),
                                    Utils.creaPregunta(Utils.QUESTION_RFC),
                                    Utils.creaPregunta(Utils.QUESTION_CUENTA),
                                    Float.parseFloat(Utils.creaPregunta(Utils.QUESTION_SUELDO))
                            );
                            //! Crea un empleado genérico, que se usara como base para crear un empleado en específico.

                            //Si el tipo seleccionado es Auxiliar
                            if (tipoEmpleado.equalsIgnoreCase(Utils.EMPLEADO_AUXILIAR)) {

                                //! Si la selección es Auxiliar. Crea un nuevo empleado a partir del empleado genérico
                                empleadosArray[empleadosIndex] = new E_NoAdministrativo(
                                        empleadoGenerico,
                                        (String) Utils.creaPreguntaDesplegable(Utils.QUESTION_TURNO, Utils.TURNOS),
                                        (String) Utils.creaPreguntaDesplegable(Utils.QUESTION_AREA, Utils.AREAS)
                                );
                                //! Si la selección es Auxiliar. Crea un nuevo empleado a partir del empleado genérico
                            }
                            //Si el tipo seleccionado es Académico
                            if (tipoEmpleado.equalsIgnoreCase(Utils.EMPLEADO_ACADEMICO)) {

                                //! Si la selección es Académico. Crea un nuevo empleado a partir del empleado genérico
                                empleadosArray[empleadosIndex] = new E_Academico(
                                        empleadoGenerico,
                                        Utils.creaPregunta(Utils.QUESTION_MATERIA),
                                        (String) Utils.creaPreguntaDesplegable(Utils.QUESTION_TURNO, Utils.TURNOS)
                                );
                                //! Si la selección es Académico. Crea un nuevo empleado a partir del empleado genérico

                            }
                            //Si el tipo seleccionado es Admin
                            if (tipoEmpleado.equalsIgnoreCase(Utils.EMPLEADO_ADMIN)) {

                                //! Si la selección es Admin. Crea un nuevo empleado a partir del empleado genérico
                                empleadosArray[empleadosIndex] = new E_Administrativo(
                                        empleadoGenerico,
                                        (String) Utils.creaPreguntaDesplegable(Utils.QUESTION_TURNO, Utils.TURNOS),
                                        (String) Utils.creaPreguntaDesplegable(Utils.QUESTION_AREA, Utils.AREAS));
                                //! Si la selección es Admin. Crea un nuevo empleado a partir del empleado genérico

                            }
                            //Añade empleado a la escuela que le corresponda
                            escuela.addEmpleado(empleadosArray[empleadosIndex]);
                            //Aumenta el contador de empleados para no sobreescribir la posición en el arreglo.
                            empleadosIndex = empleadosIndex + 1;
                        } else {
                            //Si no existe escuelas manda mensaje de error
                            JOptionPane.showMessageDialog(null,
                                    "ERROR Necesita que escuelasArray sea mayor que 0",
                                    Utils.PROYECT_TITLE,
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    //CREA ESTUDIANTE
                    case Utils.OPCION_CUATRO -> {
                        //Si al menos existe una escuela
                        if (escuelasArray[0] != null) {
                            //Selecciona una escuela de una ventana desplegable.
                            Escuela escuela = (Escuela) Utils.creaPreguntaDesplegable(Utils.QUESTION_ESCUELA, escuelasArray);

                            //!Crea un nuevo estudiante desde las respuestas del usuario.
                            estudiantesArray[estudiantesIndex] = new Estudiante(
                                    Utils.creaPregunta(Utils.QUESTION_NOMBRE),
                                    Utils.creaPregunta(Utils.QUESTION_MATRICULA),
                                    Utils.creaPregunta(Utils.QUESTION_TELEFONO),
                                    Utils.creaDireccion());
                            //!Crea un nuevo estudiante desde las respuestas del usuario.

                            //Añade el estudiante a la escuela que le corresponda
                            escuela.addEstudiante(estudiantesArray[empleadosIndex]);
                            //Aumenta el contador de estudiantes para no sobreescribir la posición en el arreglo.
                            estudiantesIndex = estudiantesIndex + 1;
                        } else {
                            //Si no existe la escuela manda mensaje de error
                            JOptionPane.showMessageDialog(null,
                                    "ERROR Necesita que escuelasArray sea mayor que 0",
                                    Utils.PROYECT_TITLE,
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    //ASIGNA CURSO A PROFESOR
                    case Utils.OPCION_CINCO -> {
                        //Si al menos existe un empleado y un curso
                        if (empleadosArray[0] != null && cursosArray[0] != null) {
                            //Recupera un maestro de un menu desplegable.
                            Empleado empleado = (Empleado) Utils.creaPreguntaDesplegable(Utils.QUESTION_EMPLEADO, empleadosArray);
                            //Si el empleado es académico, puede ser elegible para dar clases.
                            if (empleado instanceof E_Academico empleadoAcademico) {
                                //Recupera el curso de un menu desplegable.
                                Curso curso = (Curso) Utils.creaPreguntaDesplegable(Utils.QUESTION_CURSO, cursosArray);


                                //!AÑADE EL CURSO AL EMPLEADO ACADÉMICO.
                                empleadoAcademico.asignarCurso(curso);
                                //!AÑADE EL CURSO AL EMPLEADO ACADÉMICO.


                            } else {
                                //Si el empleado no es maestro, entonces manda mensaje de error
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
                        //Regresa el tamaño de la ventana para que no sea tan grande
                        UIManager.put("OptionPane.minimumSize", new Dimension(300, 200));
                        //Si al menos existe un empleado
                        if (empleadosArray[0] != null) {

                            //Elimina nulos del arreglo
                            Empleado[] empleadoArraySinNull = Arrays.stream(empleadosArray)
                                    .filter(Objects::nonNull)
                                    .toArray(Empleado[]::new);


                            //! Muestra la información de los empleados sin nulos, la nómina se calcula adentro del método mostrarInfoArray
                            Utils.mostrarInfoArray("Nominas", empleadoArraySinNull, "Pagando Nomina para:");
                            //! Muestra la información de los empleados sin nulos, la nómina se calcula adentro del método mostrarInfoArray

                        } else {
                            //Si no hay empleados manda error
                            JOptionPane.showMessageDialog(null,
                                    "ERROR Necesita que empleados sea mayor que 0",
                                    Utils.PROYECT_TITLE,
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    //ASIGNAR CURSO A ESTUDIANTE
                    case Utils.OPCION_SIETE -> {
                        //Regresa el tamaño de la ventana para que no sea tan grande
                        UIManager.put("OptionPane.minimumSize", new Dimension(300, 200));
                        //Si al menos existe un estudiante y un curso
                        if (estudiantesArray[0] != null && cursosArray[0] != null) {

                            //Recupera estudiante y curso de un menu desplegable
                            Estudiante estudiante = (Estudiante) Utils.creaPreguntaDesplegable(Utils.QUESTION_ESTUDIANTE, estudiantesArray);
                            Curso curso = (Curso) Utils.creaPreguntaDesplegable(Utils.QUESTION_CURSO, cursosArray);

                            //! Asigna curso a estudiante
                            estudiante.asignarCurso(curso);
                            //! Asigna curso a estudiante

                        } else {
                            //Mensaje de error si no existen datos
                            JOptionPane.showMessageDialog(null,
                                    "ERROR Necesitas que estudiantes y cursos sean mayor que 0",
                                    Utils.PROYECT_TITLE,
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    //GENERAR HISTORIAL ACADÉMICO
                    case Utils.OPCION_OCHO -> {
                        //Si al menos existe un estudiante y un curso
                        if (cursosArray[0] != null && estudiantesArray[0] != null) {

                            //Selecciona el curso para subir calificaciones
                            Curso cursoSeleccionado = (Curso) Utils.creaPreguntaDesplegable(Utils.QUESTION_CURSO, cursosArray);

                            //! Localiza a todos los estudiantes que tengan ese curso asignado
                            for (Estudiante estudiante : cursoSeleccionado.getEstudiantes()) {
                                //Si el estudiante no ha sido llenado has un break y corta el for
                                if (estudiante != null) {

                                    //Pide al usuario asignar la calificación al estudiante en el curso seleccionado
                                    float calificacion = Float.parseFloat(JOptionPane.showInputDialog(
                                            null,
                                            "Asignar calificacion para alumno " + estudiante.getNombre() +
                                                    " - Matricula: " + estudiante.getMatricula(),
                                            "Curso: " + cursoSeleccionado.getNombreCurso(),
                                            JOptionPane.QUESTION_MESSAGE));

                                    //! Si el estudiante ya cuenta con un historial académico
                                    if (estudiante.getHistorialAcademico() != null) {
                                        //Busca en el historial académico si el curso ya está calificado, para no repetir cursos en el historial.
                                        Curso[] cursos = estudiante.getHistorialAcademico().getCursos();

                                        int indice = Arrays.asList(cursos).indexOf(cursoSeleccionado);
                                        //Si el curso no existe en el historial académico
                                        if (indice != -1) {

                                            //! Asigna la calificación a un curso nuevo del historial académico
                                            estudiante.getHistorialAcademico().getCalificaciones()[indice] = calificacion;
                                            //! Asigna la calificación a un curso nuevo del historial académico

                                        } else {

                                            //! Añade el curso al historial y Asigna la calificación a un curso nuevo del historial académico
                                            int newIndice = estudiante.getHistorialAcademico().addCurso(cursoSeleccionado);
                                            estudiante.getHistorialAcademico().getCalificaciones()[newIndice] = calificacion;
                                            //! Añade el curso al historial y Asigna la calificación a un curso nuevo del historial académico
                                        }
                                    } else {
                                        //! Si el historial académico no existe, crea uno nuevo para el estudiante
                                        HistorialAcademico historialAcademico = new HistorialAcademico(estudiante);
                                        //Añade la calificación al historial académico con índice correcto
                                        int newIndice = historialAcademico.addCurso(cursoSeleccionado);
                                        historialAcademico.getCalificaciones()[newIndice] = calificacion;

                                        //Agrega el historial académico al estudiante.
                                        estudiante.setHistorialAcademico(historialAcademico);
                                        //Agrega el historial al arreglo general
                                        historialesAcademicos[historialesAcademicosIndex] = historialAcademico;
                                        historialesAcademicosIndex = historialesAcademicosIndex + 1;
                                    }
                                } else {
                                    break;
                                }
                            }
                            //! Localiza a todos los estudiantes que tengan ese curso asignado

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

                        //! Imprime escuelas
                        Utils.mostrarInfoArray("Mostrar Todas las Escuelas", escuelasArraySinNull, "Escuela seleccionada:");
                        //! Imprime escuelas

                    }
                    //MOSTRAR EMPLEADOS
                    case Utils.OPCION_DIEZ -> {
                        //Elimina todos los nulos del arreglo para no imprimirlos
                        Empleado[] empleadosArraySinNull = Arrays.stream(empleadosArray)
                                .filter(Objects::nonNull)
                                .toArray(Empleado[]::new);

                        //! Imprime empleados
                        Utils.mostrarInfoArray("Mostrar Todos los Empleados", empleadosArraySinNull, "Empleado seleccionado:");
                        //! Imprime empleados

                    }
                    //MOSTRAR ESTUDIANTES
                    case Utils.OPCION_ONCE -> {
                        //Elimina todos los nulos del arreglo para no imprimirlos
                        Estudiante[] estudiantesArraySinNull = Arrays.stream(estudiantesArray)
                                .filter(Objects::nonNull)
                                .toArray(Estudiante[]::new);

                        //! Imprime estudiantes
                        Utils.mostrarInfoArray("Mostrar Todos los Estudiantes", estudiantesArraySinNull, "Estudiante seleccionado:");
                        //! Imprime estudiantes

                    }
                    //MOSTRAR CURSOS
                    case Utils.OPCION_DOCE -> {
                        //Elimina todos los nulos del arreglo para no imprimirlos
                        Curso[] cursosArraySinNull = Arrays.stream(cursosArray)
                                .filter(Objects::nonNull)
                                .toArray(Curso[]::new);

                        //! Imprime cursos
                        Utils.mostrarInfoArray("Mostrar Todos los Cursos", cursosArraySinNull, "Curso seleccionado:");
                        //! Imprime cursos

                    }
                    //MOSTRAR HISTORIAL ACADEMICO
                    case Utils.OPCION_TRECE -> {
                        //Obtiene un estudiante del menu desplegable.
                        Estudiante estudianteSeleccionado = (Estudiante) Utils.creaPreguntaDesplegable(Utils.QUESTION_ESTUDIANTE, estudiantesArray);
                        //Obtiene el historial académico del estudiante
                        HistorialAcademico historialAcademico = estudianteSeleccionado.getHistorialAcademico();

                        //Obtiene todos los cursos y las calificaciones
                        Curso[] cursos =
                                Arrays.stream(historialAcademico.getCursos())
                                        .filter(Objects::nonNull)
                                        .toArray(Curso[]::new);
                        String[] calificaciones = new String[cursos.length];

                        //! Construye un arreglo con los cursos y las calificaciones
                        for (int i = 0; i < cursos.length; i++) {
                            calificaciones[i] = cursos[i].toString() + "  Calificación: " + historialAcademico.getCalificaciones()[i];
                        }
                        //! Construye un arreglo con los cursos y las calificaciones

                        //Muestra el arreglo construido en el paso anterior
                        Utils.mostrarInfoArray("Mostrar Historial Académico de " + estudianteSeleccionado.getNombre(), calificaciones, "Curso seleccionado:");


                        //Regresa el tamaño de la ventana para que no sea tan grande
                        UIManager.put("OptionPane.minimumSize", new Dimension(300, 200));
                        //Al final muestra el promedio final del estudiante.
                        JOptionPane.showConfirmDialog(null,
                                "Promedio Final: " + historialAcademico.getCalificacionPromedio(),
                                "Calificación del semestre",
                                JOptionPane.OK_CANCEL_OPTION);

                    }
                    //ACTUALIZA ESCUELAS
                    case Utils.OPCION_CATORCE -> {
                        //Obtiene la escuela a actualizar del menu desplegable.
                        Escuela escuela = (Escuela) Utils.creaPreguntaDesplegable(Utils.QUESTION_ESCUELA, escuelasArray);

                        if (escuela != null) {

                            //! Para la escuela por cuestiones legales solo se permite cambiar el nombre.
                            String nombreDeEscuela = Utils.creaPreguntaConValorInicial(Utils.QUESTION_NOMBRE, escuela.getNombre());
                            escuela.setNombre(nombreDeEscuela);
                            //! Para la escuela por cuestiones legales solo se permite cambiar el nombre.

                        }
                    }
                    //ACTUALIZA CURSO
                    case Utils.OPCION_UNO_SEIS -> {
                        //Obtiene el curso a actualizar del menu desplegable.
                        Curso curso = (Curso) Utils.creaPreguntaDesplegable(Utils.QUESTION_CURSO, cursosArray);

                        if (curso != null) {

                            //Crea preguntas con el valor inicial obtenido del curso seleccionado
                            String nombreCurso = Utils.creaPreguntaConValorInicial(Utils.QUESTION_NOMBRE, curso.getNombreCurso());
                            int aforo = Integer.parseInt(Utils.creaPreguntaConValorInicial(Utils.QUESTION_AFORO, curso.getAforo()));
                            String salon = Utils.creaPreguntaConValorInicial(Utils.QUESTION_SALON, curso.getSalon());
                            String horario = (String) Utils.creaPreguntaDesplegable(Utils.QUESTION_HORARIO, Utils.HORARIOS);

                            //! A partir de los nuevos valores obtenidos, modifica el objeto usando SETTERS
                            curso.setNombreCurso(nombreCurso);
                            curso.setSalon(horario);
                            curso.setSalon(salon);
                            curso.setAforo(aforo);
                            //! A partir de los nuevos valores obtenidos, modifica el objeto usando SETTERS

                        }
                    }
                    //ACTUALIZA EMPLEADO
                    case Utils.OPCION_UNO_SIETE -> {

                        //Obtiene el empleado a actualizar del menu desplegable.
                        Empleado empleado = (Empleado) Utils.creaPreguntaDesplegable(Utils.QUESTION_EMPLEADO, empleadosArray);

                        if (empleado != null) {

                            //Crea preguntas con el valor inicial obtenido del curso seleccionado
                            String nombre = Utils.creaPreguntaConValorInicial(Utils.QUESTION_NOMBRE, empleado.getNombre());
                            String rfc = Utils.creaPreguntaConValorInicial(Utils.QUESTION_RFC, empleado.getRFC());
                            String cuenta = Utils.creaPreguntaConValorInicial(Utils.QUESTION_CUENTA, empleado.getCuenta());
                            Float sueldo = Float.parseFloat(Utils.creaPreguntaConValorInicial(Utils.QUESTION_SUELDO, empleado.getSueldo()));

                            //! A partir de los nuevos valores obtenidos, modifica el objeto usando SETTERS
                            Utils.creaDireccionConValorInicial(empleado.getDireccion());
                            empleado.setSueldo(sueldo);
                            empleado.setNombre(nombre);
                            empleado.setCuenta(cuenta);
                            empleado.setRFC(rfc);
                            //! A partir de los nuevos valores obtenidos, modifica el objeto usando SETTERS

                        }
                    }
                    //ACTUALIZA ESTUDIANTES
                    case Utils.OPCION_UNO_OCHO -> {
                        //Obtiene el estudiante a actualizar del menu desplegable.
                        Estudiante estudiante = (Estudiante) Utils.creaPreguntaDesplegable(Utils.QUESTION_ESTUDIANTE, estudiantesArray);
                        if (estudiante != null) {

                            //Crea preguntas con el valor inicial obtenido del curso seleccionado
                            String nombre = Utils.creaPreguntaConValorInicial(Utils.QUESTION_NOMBRE, estudiante.getNombre());
                            String telefono = Utils.creaPreguntaConValorInicial(Utils.QUESTION_TELEFONO, estudiante.getTelefono());
                            String matricula = Utils.creaPreguntaConValorInicial(Utils.QUESTION_MATRICULA, estudiante.getMatricula());

                            //! A partir de los nuevos valores obtenidos, modifica el objeto usando SETTERS
                            Utils.creaDireccionConValorInicial(estudiante.getDireccionEstudiante());
                            estudiante.setMatricula(matricula);
                            estudiante.setTelefono(telefono);
                            estudiante.setNombre(nombre);
                            //! A partir de los nuevos valores obtenidos, modifica el objeto usando SETTERS

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
