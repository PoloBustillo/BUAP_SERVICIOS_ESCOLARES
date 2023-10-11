package buap.intro_programacion;

import javax.swing.*;
import java.awt.*;

public class SistemaEscolarUI extends JFrame {

    private JPanel Hola;
    private JButton XD;

    public SistemaEscolarUI(String title) throws HeadlessException {
        super(title);
        setVisible(true);
        setSize(700,500);
    }

    public static void main(String[] args) {
        new SistemaEscolarUI("Proyecto Programación");
    }
}
