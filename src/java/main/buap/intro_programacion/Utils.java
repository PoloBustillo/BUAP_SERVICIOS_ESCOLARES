package buap.intro_programacion;

import buap.intro_programacion.models.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public final class Utils {

    //CONSTANTES
    public static final int MAX_OBJETOS = 10;
    public static final String PROYECT_TITLE = "BUAP - PROGRAMACIÓN - SISTEMA ESCOLAR";
    public static final String INIT_QUESTION = "SELECCIONA UNA ACCIÓN";
    public static final String QUESTION_TIPO_EMPLEADOS = "Por favor, Elige el tipo de empleado:";
    public static final String QUESTION_TURNO = "Por favor, Elige el turno del empleado:";
    public static final String[] TURNOS = {"Matutino", "Vespertino", "Nocturno"};
    public static final String QUESTION_AREA = "Por favor, Elige el area del empleado:";
    public static final String[] AREAS = {"Secretarías", "Limpieza", "Vigilancia"};
    public static final String EMPLEADO_AUXILIAR = "Auxiliar";
    public static final String EMPLEADO_ADMIN = "Administrativo";
    public static final String EMPLEADO_ACADEMICO = "Académico";
    public static final String[] TIPO_EMPLEADOS = {EMPLEADO_ACADEMICO, EMPLEADO_AUXILIAR, EMPLEADO_ADMIN};
    public static final String[] HORARIOS = {"Matutino (8-10)", "Matutino (10-12)", "Vespertino (12-2)", "Vespertino (2-4)"};
    public static final String OPCION_UNO = "Crear Escuela";
    public static final String OPCION_DOS = "Crear Curso";
    public static final String OPCION_TRES = "Crear Empleado";
    public static final String OPCION_CUATRO = "Crear Estudiante";
    public static final String OPCION_CINCO = "Asignar cursos a profesor";
    public static final String OPCION_SEIS = "Calcular nomina para empleados";
    public static final String OPCION_SIETE = "Asignar estudiante a curso";
    public static final String OPCION_OCHO = "Generar historial académico";
    public static final String OPCION_NUEVE = "Mostrar Escuelas";
    public static final String OPCION_DIEZ = "Mostrar Empleados";
    public static final String OPCION_ONCE = "Mostrar Estudiantes";
    public static final String OPCION_DOCE = "Mostrar Cursos";
    public static final String OPCION_TRECE = "Mostrar Historial Académico";

    public static final String OPCION_SALIR = "Salir";
    public static final String QUESTION_NOMBRE = "Por favor, Introduce nombre:";
    public static final String QUESTION_AFORO = "Por favor, Introduce aforo máximo:";
    public static final String QUESTION_SALON = "Por favor, Introduce salón:";
    public static final String QUESTION_ESCUELA = "Por favor, Introduce escuela:";
    public static final String QUESTION_CURSO = "Por favor, Introduce curso:";
    public static final String QUESTION_CALLE = "Por favor, Introduce calle:";
    public static final String QUESTION_MATERIA = "Por favor, Introduce materia:";
    public static final String QUESTION_COLONIA = "Por favor, Introduce colonia:";
    public static final String QUESTION_CODIGO_POSTAL = "Por favor, Introduce código postal:";
    public static final String QUESTION_CIUDAD = "Por favor, Introduce ciudad:";
    public static final String QUESTION_NIVEL = "Por favor, Selecciona uno o más nivel:";
    public static final String QUESTION_HORARIO = "Por favor, Selecciona horario:";
    public static final String[] NIVELES = {"Primaria", "Secundaria", "Preparatoria"};
    public static final String QUESTION_MATRICULA = "Por favor, Introduce matricula:";
    public static final String QUESTION_TELEFONO = "Por favor, Introduce telefono:";
    public static final String QUESTION_RFC = "Por favor, Introduce RFC:";
    public static final String QUESTION_CUENTA = "Por favor, Introduce cuenta:";
    public static final String QUESTION_SUELDO = "Por favor, Introduce sueldo:";
    public static final String QUESTION_ESTUDIANTE = "Por favor, selecciona estudiante:";
    public static final String OPCION_CATORCE = "Actualiza Escuela";
    public static final String QUESTION_EMPLEADO = "Elige un Empleado de la nomina:";
    public static final String OPCION_UNO_SEIS = "Actualiza Curso";
    public static final String OPCION_UNO_SIETE = "Actualiza Empleado";
    public static final String OPCION_UNO_OCHO = "Actualiza Estudiante";
    public static final String[] MAIN_MENU = {
            OPCION_UNO, OPCION_DOS, OPCION_TRES, OPCION_CUATRO,
            OPCION_CINCO, OPCION_SEIS, OPCION_SIETE, OPCION_OCHO,
            OPCION_NUEVE, OPCION_DIEZ, OPCION_ONCE, OPCION_DOCE,
            OPCION_TRECE, OPCION_CATORCE, OPCION_UNO_SEIS, OPCION_UNO_SIETE,
            OPCION_UNO_OCHO, OPCION_SALIR};


    //METODOS DE UTILIDAD

    /**
     * Nos ayuda a imprimir arreglos de forma en una ventana JOptionPane
     *
     * @param title
     * @param data
     * @param mensajeClick
     */
    public static void mostrarInfoArray(String title, Object[] data, String mensajeClick) {
        //Nos permite cambiar el tamaño de las ventanas
        UIManager.put("OptionPane.minimumSize", new Dimension(900, 700));
        //Objeto lista donde iran la info.
        JList list = new JList(data);
        //Añade funcionalidad a la selección de algún elemento de la lista
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    System.out.println(mensajeClick);
                    if (list.getSelectedValue() instanceof Escuela)
                        System.out.println(((Escuela) list.getSelectedValue()).imprimeDatos());
                    if (list.getSelectedValue() instanceof Estudiante)
                        System.out.println(((Estudiante) list.getSelectedValue()).imprimeDatos());
                    if (list.getSelectedValue() instanceof Curso)
                        System.out.println(((Curso) list.getSelectedValue()).imprimeDatos());
                    if (list.getSelectedValue() instanceof Empleado empleadoSeleccionado) {
                        if (Objects.equals(title, "Nominas")) {
                            System.out.println("Haciendo transferencia a cuenta: " + empleadoSeleccionado.getCuenta());
                            System.out.println("Sueldo base: " + empleadoSeleccionado.getSueldo());
                            System.out.println("Sueldo al dia de " + new Date().toString() + ": " + empleadoSeleccionado.calcularSueldo());
                        } else {
                            System.out.println(empleadoSeleccionado.imprimeDatos());
                        }
                    }
                    if (title.contains("Historial")) {
                        System.out.println("Email enviado con calificaciones");
                    }
                }
            }
        });
        //Se crea un espacio en la ventana para mostrar la lista
        JScrollPane scrollPane = new JScrollPane(list);
        JOptionPane.showMessageDialog(null, scrollPane, title, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * @param Question String de la pregunta a realizar por ejemplo: Utils.QUESTION_ETC
     * @return
     */
    public static String creaPregunta(String Question) {
        return JOptionPane.showInputDialog(null,
                Question,
                PROYECT_TITLE,
                JOptionPane.QUESTION_MESSAGE);
    }

    public static String creaPreguntaConValorInicial(String Question, Object valorInicial) {
        return JOptionPane.showInputDialog(null,
                Question,
                valorInicial);
    }

    /**
     * @param Question El string de la pregunta que se realizará al usuario.
     * @param data     El arreglo de elementos que se desplegarán en la ventana,
     *                 el arreglo puede ser de cualquier tipo
     * @return Object: Un elemento del arreglo que se proporcionó desde los parámetros.
     */
    public static Object creaPreguntaDesplegable(String Question, Object[] data) {

        return JOptionPane.showInputDialog(null,
                Question,
                PROYECT_TITLE,
                JOptionPane.QUESTION_MESSAGE,
                null,
                Arrays.stream(data)
                        .filter(Objects::nonNull)
                        .toArray(Object[]::new),
                data[0]);
    }

    /**
     * @return Crea un objeto Direccion desde varias ventanas de preguntas, que el usuario responde.
     */
    public static Direccion creaDireccion() {
        //try-catch permite el manejo de errores durante el programa
        try {

            //Realizar las preguntas a través de las ventanas.
            String calle = creaPregunta(QUESTION_CALLE);
            String colonia = creaPregunta(QUESTION_COLONIA);
            Integer cp = Integer.parseInt(creaPregunta(QUESTION_CODIGO_POSTAL));
            String ciudad = creaPregunta(QUESTION_CIUDAD);

            //Creo y retorno un objeto tipo Direccion, con los datos obtenidos del usuario.
            return new Direccion(calle, colonia, cp, ciudad);


        } catch (NumberFormatException e) {

            //Mensaje de error generado si el usuario manda un CP que no es un número.
            JOptionPane.showMessageDialog(null,
                    "ERROR en Código Postal: Dirección no creada!!",
                    PROYECT_TITLE,
                    JOptionPane.ERROR_MESSAGE);

            //La dirección no se crea y mando un Objeto vacío
            return null;

        }
    }

    public static void creaDireccionConValorInicial(Direccion direccion) {
        //try-catch permite el manejo de errores durante el programa
        try {

            //Realizar las preguntas a través de las ventanas.
            String calle = creaPreguntaConValorInicial(QUESTION_CALLE, direccion.getCalle());
            String colonia = creaPreguntaConValorInicial(QUESTION_COLONIA, direccion.getColonia());
            Integer cp = Integer.parseInt(creaPreguntaConValorInicial(QUESTION_CODIGO_POSTAL, direccion.getCodigoPostal()));
            String ciudad = creaPreguntaConValorInicial(QUESTION_CIUDAD, direccion.getCiudad());
            direccion.setCalle(calle);
            direccion.setCiudad(ciudad);
            direccion.setColonia(colonia);
            direccion.setCodigoPostal(cp);


        } catch (NumberFormatException e) {

            //Mensaje de error generado si el usuario manda un CP que no es un número.
            JOptionPane.showMessageDialog(null,
                    "ERROR en actualizar Código Postal: Dirección no creada!!",
                    PROYECT_TITLE,
                    JOptionPane.ERROR_MESSAGE);

        }
    }

    public static String formateaNomina(Empleado empleado, int diaDelMes) {
        return "ID: " + empleado.getIdEmpleado() + "\nNombre: " + empleado.getNombre() + "\nSueldo: " + empleado.getSueldo() * diaDelMes;
    }
}
