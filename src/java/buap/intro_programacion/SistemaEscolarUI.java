package buap.intro_programacion;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

//TODOS
public class SistemaEscolarUI extends JFrame {

    private JPanel mainPanel;


    public SistemaEscolarUI(String title) throws HeadlessException {
        super(title);

        add(mainPanel);
        centerFrame(this);
        createMenu(this);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        new SistemaEscolarUI("Proyecto Programación");
    }

    private void centerFrame(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        setSize(new Dimension((int) (width - 200), (int) (height - 200)));
        int x = (int) ((screenSize.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - frame.getHeight()) / 2);
        setLocation(x, y);
    }

    private JMenu createSubMenuArrow(String title) {
        JMenu subMenu;
        subMenu = new JMenu(title);
        subMenu.setBorder(new EmptyBorder(5, 15, 5, 10));
        return subMenu;
    }

    private JMenuItem createSubMenu(String title) {
        JMenuItem subMenu;
        subMenu = new JMenuItem(title);
        subMenu.setBorder(new EmptyBorder(5, 15, 5, 10));
        //subMenu.addActionListener((ActionListener) this);
        return subMenu;
    }

    private JMenu createTopMenu(String title) {
        JMenu topMenu;
        topMenu = new JMenu(title);
        topMenu.setBorder(new EmptyBorder(0, 10, 0, 10));
        return topMenu;
    }

    private void createMenu(JFrame frame) {
        JMenuBar menuBar;
        JMenu menuAltasBajaYVisualizar;
        JMenu menuCalculos;

        menuBar = new JMenuBar();


        menuAltasBajaYVisualizar = createTopMenu("Altas/Bajas/Visualizar");
        menuAltasBajaYVisualizar.add(createSubMenuArrow("Crea Item"));
        menuAltasBajaYVisualizar.add(createSubMenuArrow("Visualiza Item"));
        menuAltasBajaYVisualizar.add(createSubMenuArrow("Elimina Item"));
        menuCalculos = createTopMenu("Calculos");
        menuCalculos.add(createSubMenu("Salario"));
        menuBar.add(Box.createHorizontalStrut(10));
        menuBar.add(menuAltasBajaYVisualizar);
        menuBar.add(Box.createHorizontalStrut(10));
        menuBar.add(menuCalculos);
        setJMenuBar(menuBar);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("CLCIK");
    }


}
