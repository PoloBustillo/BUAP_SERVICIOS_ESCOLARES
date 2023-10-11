package buap.intro_programacion;

import javax.swing.*;
import java.awt.*;
//TODOS
public class SistemaEscolarUI extends JFrame {

    private JPanel mainPanel;

    private void centerFrame(JFrame frame){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        setSize(new Dimension((int) (width-200), (int) (height-200)));
        int x = (int) ((screenSize.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - frame.getHeight()) / 2);
        setLocation(x,y);
    }
    public SistemaEscolarUI(String title) throws HeadlessException {
        super(title);
        centerFrame(this);
        setVisible(true);

    }

    public static void main(String[] args) {
        new SistemaEscolarUI("Proyecto Programación");
    }
}
