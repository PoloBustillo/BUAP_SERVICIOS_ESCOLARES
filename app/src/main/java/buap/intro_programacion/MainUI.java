/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package buap.intro_programacion;

import buap.intro_programacion.models.Curso;
import buap.intro_programacion.models.E_Academico;
import buap.intro_programacion.models.E_Administrativo;
import buap.intro_programacion.models.E_Auxiliar;
import buap.intro_programacion.models.Empleado;
import buap.intro_programacion.models.Escuela;
import buap.intro_programacion.models.Estudiante;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author leopo
 */
public class MainUI extends javax.swing.JFrame {

    //Se prefiere ArrayList porque tiene metodos de utilidad como contains
    //Lista de las escuelas creadas
    static ArrayList<Escuela> escuelas = new ArrayList<>();

    //JList utiliza modelos en lugar de arrays para poblar la lista
    ArrayList<DefaultListModel> empleadosListas = new ArrayList<>();
    ArrayList<DefaultListModel> estudiantesListas = new ArrayList<>();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    //usado para centrar el frame inicial y tener un tama�o adecuado
    private void centerFrame() {
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        setSize(new Dimension((int) (width - 200), (int) (height - 200)));
        int x = (int) ((screenSize.getWidth() - this.getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - this.getHeight()) / 2);
        setLocation(x, y);
    }

    /**
     * Creates new form MainUI
     */
    public MainUI() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (Utils.LOOK_AND_FEEL.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            initComponents();
            this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            this.addWindowListener(new WindowAdapter() {

                @Override
                public void windowClosing(WindowEvent e) {
                    int i = JOptionPane.showConfirmDialog(null, "Seguro que quiere salir?");
                    if (i == 0) {
                        System.exit(0);//cierra aplicacion
                    }
                }
            });
            centerFrame();
            setTitle("PROYECTO PROGRAMACION - SISTEMA ESCOLAR ");
            ActualizaBtn.setEnabled(false);
            EliminaBtn.setEnabled(false);
            ActualizaBtn1.setEnabled(false);
            EliminaBtn1.setEnabled(false);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jPopupMenu4 = new javax.swing.JPopupMenu();
        TabPanel = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        EliminaBtn = new javax.swing.JButton();
        ActualizaBtn = new javax.swing.JButton();
        EliminaBtn1 = new javax.swing.JButton();
        ActualizaBtn1 = new javax.swing.JButton();
        javax.swing.JMenuBar MenuBar = new javax.swing.JMenuBar();
        MenuAcciones = new javax.swing.JMenu();
        CrearMenuSub = new javax.swing.JMenu();
        escuelaMenuItem = new javax.swing.JMenuItem();
        empleadoMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        cursoMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        ExitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TabPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Escuelas"));
        TabPanel.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        TabPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                componentMovedListener(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion"));

        jList1.setBackground(new java.awt.Color(255, 204, 204));
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addContainerGap())
        );

        EliminaBtn.setBackground(new java.awt.Color(255, 204, 204));
        EliminaBtn.setText("Elimina Empleado");
        EliminaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminaBtnActionPerformed(evt);
            }
        });

        ActualizaBtn.setBackground(new java.awt.Color(255, 255, 204));
        ActualizaBtn.setText("Actualiza Empleado");
        ActualizaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizaBtnActionPerformed(evt);
            }
        });

        EliminaBtn1.setBackground(new java.awt.Color(255, 204, 204));
        EliminaBtn1.setText("Elimina Alumno");
        EliminaBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminaBtn1ActionPerformed(evt);
            }
        });

        ActualizaBtn1.setBackground(new java.awt.Color(255, 255, 204));
        ActualizaBtn1.setText("Actualiza Alumno");
        ActualizaBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizaBtn1ActionPerformed(evt);
            }
        });

        MenuBar.setBackground(new java.awt.Color(255, 153, 153));
        MenuBar.setToolTipText("");

        MenuAcciones.setForeground(new java.awt.Color(51, 51, 51));
        MenuAcciones.setText("Acciones");
        MenuAcciones.setMargin(new java.awt.Insets(3, 15, 3, 15));

        CrearMenuSub.setText("Crear");

        escuelaMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        escuelaMenuItem.setText("Escuela");
        escuelaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escuelaMenuItemActionPerformed(evt);
            }
        });
        CrearMenuSub.add(escuelaMenuItem);

        empleadoMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        empleadoMenuItem.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        empleadoMenuItem.setText("Empleado");
        empleadoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empleadoMenuItemActionPerformed(evt);
            }
        });
        CrearMenuSub.add(empleadoMenuItem);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem1.setText("Estudiante");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        CrearMenuSub.add(jMenuItem1);

        cursoMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        cursoMenuItem.setText("Curso");
        cursoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cursoMenuItemActionPerformed(evt);
            }
        });
        CrearMenuSub.add(cursoMenuItem);

        MenuAcciones.add(CrearMenuSub);
        MenuAcciones.add(jSeparator1);

        ExitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        ExitMenuItem.setText("Salir");
        ExitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMenuItemActionPerformed(evt);
            }
        });
        MenuAcciones.add(ExitMenuItem);

        MenuBar.add(MenuAcciones);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(TabPanel)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(ActualizaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EliminaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(ActualizaBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EliminaBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(296, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TabPanel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EliminaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ActualizaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(EliminaBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ActualizaBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void escuelaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escuelaMenuItemActionPerformed
        //Cuando el usuario de click en Crear Escuela o Shift + E

        //Si el maximo de escuelas es superado -> mensaje de error
        if (Utils.MAX_SCHOOLS >= escuelas.size()) {
            //Se crea un objeto escuela
            Escuela escuela = new Escuela();

            //Pide al usuario el nombre de la escuela
            String name = JOptionPane.showInputDialog(this, "NOMBRE DE LA ESCUELA", Utils.CREATE_ESCUELA_FLOW_NAME, JOptionPane.QUESTION_MESSAGE);

            //Si el usuario da un nombre valido
            if (name != null && !"".equals(name)) {

                //A�ade la escuela al arraylist con el nombre valido
                escuela.setNombre(name);
                escuelas.add(escuela);

                //Dos modelos para crear las listas de empleados y estudiantes
                //TODO: checar cursos
                DefaultListModel empleadoModel = new DefaultListModel();
                DefaultListModel estudianteModel = new DefaultListModel();

                empleadoModel.add(0, Utils.EMPLEADOS_LABEL);
                estudianteModel.add(0, Utils.ESTUDIANTES_LABEL);
                empleadosListas.add(empleadoModel);
                estudiantesListas.add(estudianteModel);

                //Crea dos listas con los modelos
                JList<String> listaEmpleados = new JList<>(empleadoModel) {
                    @Override
                    public String getToolTipText(MouseEvent event) {
                        int row = locationToIndex(event.getPoint());
                        Empleado emp = (Empleado) getModel().getElementAt(row);
                        return "Empleado: " + emp.getNombre() + " --- " + emp.getDireccion() + " --- RFC:" + emp.getRFC();
                    }
                };
                listaEmpleados.setFont(new Font("Tahoma", 1, 16));
                JList<String> listaEstudiantes = new JList<>(estudianteModel) {
                    @Override
                    public String getToolTipText(MouseEvent event) {
                        int row = locationToIndex(event.getPoint());
                        Estudiante est = (Estudiante) getModel().getElementAt(row);
                        return "Estudiante: " + est.getNombre() + " --- " + est.getMiGrado() + " --- " + est.getDireccionEstudiante();
                    }
                };
                listaEstudiantes.setFont(new java.awt.Font("Tahoma", 1, 16));

                //Crear Listeners para cada lista, escucharan la selecci�n de algun elemento en la lista
                listaEmpleados.addListSelectionListener((ListSelectionEvent event) -> {
                    if (!event.getValueIsAdjusting()) {
                        //Obtiene componente lista a partir del evento (click en una posici�n)
                        JList source = (JList) event.getSource();

                        //Si el elemento seleccionado es el primero, crea una UI para actualizar la escuela
                        int selected = source.getSelectedIndex();

                        if (selected == 0) {
                            EscuelaUI escuelaUI = new EscuelaUI(escuela);
                            //Cuando se cierre la ventana de actualizar escuela no se terminara el programa
                            escuelaUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            escuelaUI.setVisible(true);
                        } else if (selected != -1) {
//                            EmpleadoUI empleadoUI = new EmpleadoUI((Empleado) empleadoModel.get(selected));
//                            empleadoUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                            empleadoUI.setVisible(true);

                            ActualizaBtn.setEnabled(true);
                            EliminaBtn.setEnabled(true);

                        }
                    }
                }
                );
                listaEstudiantes.addListSelectionListener((ListSelectionEvent event) -> {
                    if (!event.getValueIsAdjusting()) {
                        JList source = (JList) event.getSource();
                        int selected = source.getSelectedIndex();
                        if (selected == 0) {
                            EscuelaUI escuelaUI = new EscuelaUI(escuela);
                            escuelaUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            escuelaUI.setVisible(true);
                        } else if (selected != -1) {
                            EstudianteUI empleadoUI = new EstudianteUI((Estudiante) estudianteModel.get(selected));
                            empleadoUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            empleadoUI.setVisible(true);
                        }
                    }
                });
                listaEmpleados.setBackground(Color.LIGHT_GRAY);
                listaEstudiantes.setBackground(Color.PINK);
                //Crea un componente con division para las dos listas
                JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                        listaEmpleados, listaEstudiantes);

                splitPane.setDividerLocation((int) (screenSize.getWidth() / 3));

                //Agrega el componente de division al Tab en la ultima posici�n, cambia el focus a esa posicion
                TabPanel.addTab(name, splitPane);
                TabPanel.setSelectedIndex(escuelas.size() - 1);
            }
        } else {
            JOptionPane.showMessageDialog(this, "NUMERO MAXIMO DE ESCUELAS ALCANZADO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_escuelaMenuItemActionPerformed

    private void ExitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuItemActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitMenuItemActionPerformed

    private void empleadoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empleadoMenuItemActionPerformed

        //Si no hay niguna escuela no puedo crear un empleado, manda mensaje de ERROR
        if (escuelas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se necesita almenos una escuela", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            //Tipos de empleados
            Object[] tiposEmpleados = Utils.EMPLEADOS_TYPES;

            //Dropdown para seleccionar un tipo
            Object selectionObject = JOptionPane.showInputDialog(this, "Elige un tipo de empleado", "Menu", JOptionPane.PLAIN_MESSAGE, null, tiposEmpleados, tiposEmpleados[0]);
            String empleadoType = selectionObject.toString();

            //Obten la escuela a la que esta asignado
            Escuela selectionEscuela = (Escuela) JOptionPane.showInputDialog(this, "A que escuela esta asignado", "Menu", JOptionPane.PLAIN_MESSAGE, null, escuelas.toArray(), escuelas.toArray()[0]);

            //Obten el nombre del empleado
            String nombreEmpleado = JOptionPane.showInputDialog(this, "Nombre del empleado", Utils.CREATE_EMPLEADO_FLOW_NAME, JOptionPane.QUESTION_MESSAGE);

            //Recupera el indice de la escuela que es el mismo que la TAB
            Integer escuelaIndex = escuelas.indexOf(selectionEscuela);

            //SI ES EMPLEADO AUXILIAR
            if (empleadoType.equals(Utils.EMPLEADO_AUXILIAR)) {
                E_Auxiliar empleado = new E_Auxiliar();
                empleado.setNombre(nombreEmpleado);
                //recupero la lista de la escuela y a�ado el empleado creado
                DefaultListModel modelo = empleadosListas.get(escuelaIndex);
                modelo.addElement(empleado);
                selectionEscuela.getEmpleados().add(empleado);
            }

            //SI ES EMPLEADO ADMINISTRATIVO
            if (empleadoType.equals(Utils.EMPLEADO_ADMINISTRATIVO)) {
                E_Administrativo empleado = new E_Administrativo();
                empleado.setNombre(nombreEmpleado);
                //recupero la lista de la escuela y a�ado el empleado creado
                DefaultListModel modelo = empleadosListas.get(escuelaIndex);
                modelo.addElement(empleado);
                selectionEscuela.getEmpleados().add(empleado);
            }

            //SI ES EMPLEADO ADMINISTRATIVO
            if (empleadoType.equals(Utils.EMPLEADO_ACADEMICO)) {
                E_Academico empleado = new E_Academico();
                empleado.setNombre(nombreEmpleado);
                //recupero la lista de la escuela y a�ado el empleado creado
                DefaultListModel modelo = empleadosListas.get(escuelaIndex);
                modelo.addElement(empleado);
                selectionEscuela.getEmpleados().add(empleado);
            }

        }
    }//GEN-LAST:event_empleadoMenuItemActionPerformed

    private void cursoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cursoMenuItemActionPerformed
        Curso curso = new Curso();
        String salon = JOptionPane.showInputDialog(this, "Salon de la escuela", Utils.CREATE_CURSO_FLOW_NAME, JOptionPane.QUESTION_MESSAGE);
        curso.setSalon(salon);
    }//GEN-LAST:event_cursoMenuItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //Si no hay niguna escuela no puedo crear un empleado, manda mensaje de ERROR
        if (escuelas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se necesita almenos una escuela", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            Estudiante estudiante = new Estudiante();
            //Obten el nombre del estudiante
            String nombre = JOptionPane.showInputDialog(this, "Nombre del estudiante", Utils.CREATE_ESTUDIANTE_FLOW_NAME, JOptionPane.QUESTION_MESSAGE);
            estudiante.setNombre(nombre);
            estudiante.setTelefono(JOptionPane.showInputDialog(
                    this,
                    "Telefono del estudiante",
                    Utils.CREATE_ESTUDIANTE_FLOW_NAME,
                    JOptionPane.QUESTION_MESSAGE
            ));
            estudiante.setMatricula(JOptionPane.showInputDialog(
                    this,
                    "Matricula del estudiante",
                    Utils.CREATE_ESTUDIANTE_FLOW_NAME,
                    JOptionPane.QUESTION_MESSAGE
            ));

            Escuela selectionEscuela = (Escuela) JOptionPane.showInputDialog(this,
                    "A que escuela esta asignado",
                    "Menu",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    escuelas.toArray(),
                    escuelas.toArray()[0]);
            Integer escuelaIndex = escuelas.indexOf(selectionEscuela);
            DefaultListModel modelo = estudiantesListas.get(escuelaIndex);
            modelo.addElement(estudiante);
            //Obten la escuela a la que esta asignado

            selectionEscuela.getEstudiantes().add(estudiante);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void componentMovedListener(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_componentMovedListener
        // TODO add your handling code here:]
        System.out.println("buap.intro_programacion.MainUI.componentMovedListener()");
    }//GEN-LAST:event_componentMovedListener

    private void EliminaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EliminaBtnActionPerformed

    private void ActualizaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActualizaBtnActionPerformed

    private void EliminaBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminaBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EliminaBtn1ActionPerformed

    private void ActualizaBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizaBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActualizaBtn1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizaBtn;
    private javax.swing.JButton ActualizaBtn1;
    private javax.swing.JMenu CrearMenuSub;
    private javax.swing.JButton EliminaBtn;
    private javax.swing.JButton EliminaBtn1;
    private javax.swing.JMenuItem ExitMenuItem;
    private javax.swing.JMenu MenuAcciones;
    public static javax.swing.JTabbedPane TabPanel;
    private javax.swing.JMenuItem cursoMenuItem;
    private javax.swing.JMenuItem empleadoMenuItem;
    private javax.swing.JMenuItem escuelaMenuItem;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
