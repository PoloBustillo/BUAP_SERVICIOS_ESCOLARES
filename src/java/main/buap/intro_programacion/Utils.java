package buap.intro_programacion;

import buap.intro_programacion.models.Direccion;

import javax.swing.*;

public final class Utils {

    //CONSTANTES
    public static final String OPCION_UNO = "Crear Escuela";
    public static final String OPCION_DOS = "Crear Curso";
    public static final String OPCION_TRES = "Crear Empleado";
    public static final String OPCION_CUATRO = "Crear Estudiante";
    public static final String OPCION_SALIR = "Salir";
    public static final String QUESTION_NOMBRE = "Por favor, Introduce nombre:";
    public static final String QUESTION_ESCUELA = "Por favor, Introduce escuela:";
    public static final String QUESTION_CALLE = "Por favor, Introduce calle:";
    public static final String QUESTION_COLONIA = "Por favor, Introduce colonia:";
    public static final String QUESTION_CODIGO_POSTAL = "Por favor, Introduce código postal:";
    public static final String QUESTION_CIUDAD = "Por favor, Introduce ciudad:";
    public static final String QUESTION_NIVEL = "Por favor, Selecciona nivel:";
    public static final String[] NIVELES = {"Primaria", "Secundaria", "Preparatoria"};
    public static int MAX_OBJETOS = 20;
    public static String PROYECT_TITLE = "BUAP - PROGRAMACIÓN - SISTEMA ESCOLAR";
    public static String[] MAIN_MENU = {OPCION_UNO, OPCION_DOS, OPCION_TRES, OPCION_CUATRO, OPCION_SALIR};
    public static String INIT_QUESTION = "SELECCIONA UNA ACCIÓN";


    //METODOS DE UTILIDAD

    /**
     * @param Question String de la pregunta a realizar por ejemplo: Utils.QUESTION_ETC
     * @return
     */
    public static String creaPregunta(String Question) {
        return JOptionPane.showInputDialog(null,
                Question,
                Utils.PROYECT_TITLE,
                JOptionPane.QUESTION_MESSAGE);
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
                Utils.PROYECT_TITLE,
                JOptionPane.QUESTION_MESSAGE,
                null,
                data,
                data[0]);
    }

    /**
     * @return Crea un objeto Direccion desde varias ventanas de preguntas, que el usuario responde.
     */
    public static Direccion creaDireccion() {
        //try-catch permite el manejo de errores durante el programa
        try {

            //Realizar las preguntas a través de las ventanas.
            String calle = creaPregunta(Utils.QUESTION_CALLE);
            String colonia = creaPregunta(Utils.QUESTION_COLONIA);
            Integer cp = Integer.parseInt(creaPregunta(Utils.QUESTION_CODIGO_POSTAL));
            String ciudad = creaPregunta(Utils.QUESTION_CIUDAD);

            //Creo y retorno un objeto tipo Direccion, con los datos obtenidos del usuario.
            return new Direccion(calle, colonia, cp, ciudad);


        } catch (NumberFormatException e) {

            //Mensaje de error generado si el usuario manda un CP que no es un número.
            JOptionPane.showMessageDialog(null,
                    "ERROR en Código Postal: Dirección no creada!!",
                    Utils.PROYECT_TITLE,
                    JOptionPane.ERROR_MESSAGE);

            //La dirección no se crea y mando un Objeto vacío
            return null;

        }
    }

}
