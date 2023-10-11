package buap.intro_programacion;

import buap.intro_programacion.models.Estudiante;

import javax.swing.*;

class SaludosCliente {
    static String createSaludo(String msg) {
        String saludo = JOptionPane.showInputDialog(null, msg);
        System.out.println(saludo);
        return saludo;
    }
}

public class SistemaEscolar {

    public static void main(String[] args) {
        Estudiante estudianteDePrueba;
        estudianteDePrueba = new Estudiante();
        String saludo = SaludosCliente.createSaludo("Hola Buenos Dias!");

        System.out.println(saludo);
    }
}
