/*Universidad del Valle de Guatemala
*Luis Abadía
*Carnet 13300
* Clase Vista2
*Fecha de creacion la clase vista2, fue de lunes 21/11/2016
*Descripcion: en esta clase se ingresa el usuario y ademas se crea uno nuevo, si el usuario existe pasa a la siguiente ventana 
*/
package Clases;

import javax.swing.JOptionPane;
import org.neo4j.graphdb.Node;

/**
 *
 * @author LuisEstuardo
 */
public class Vista2 extends javax.swing.JFrame {

    //Atributos
    private Node user;
    private Metodos database;
    
    
    /**
     * Creates new form Vista2
     */
    public Vista2() {
        initComponents();
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnSalir = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextUsuario2 = new javax.swing.JTextField();
        jPasswordContra = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextUsuario = new javax.swing.JTextField();
        jPasswordContra2 = new javax.swing.JPasswordField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtnSalir.setText("Exit?");
        jbtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 20));

        btnOk.setText("Entrar");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        getContentPane().add(btnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 110, -1));

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nueva Contraseña :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 120, -1));

        jLabel2.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nuevo Usuario :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 100, -1));
        getContentPane().add(jTextUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 140, -1));
        getContentPane().add(jPasswordContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 140, -1));

        jButton1.setText("Nuevo?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, -1, -1));

        jLabel3.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuario :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 100, -1));

        jLabel4.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contraseña :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 100, -1));
        getContentPane().add(jTextUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 140, -1));
        getContentPane().add(jPasswordContra2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 140, -1));
        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 80, 60));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/2PARTE.png"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 409));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Boton Salir
    private void jbtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbtnSalirActionPerformed

    
    //Ingresar con usuario y contraseña, Sign IN
    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        
        String username = jTextUsuario.getText();//Agrego los datos a una variables

        String password = jPasswordContra.getText();//Agrego los datos de la contraseña en la variable
        
        if (!username.equals("") && !password.equals("")){//comparo que hayan datos

            database = new Metodos(username,password);//instancio database

            database.openDatabase(0);//ejecuto OpenDatabase con parametro 0

            this.user = database.getUser();//a mi variable local le agrego lo que me devuelva openDatabase, el nodo usuario

            jTextUsuario.setText("");//pongo mis casillas en blanco
            jPasswordContra.setText("");
            
            if (this.user != null){//si el usuario que devolvio fue diferente de null

                Interface userInterface = new Interface(this.user);//Instancio la ventana de relaciones

                userInterface.setDatabase(database);//mando mi database al metodo que recibe mi database
                
                userInterface.setVisible(true);// pongo la pantalla en modo visible
                this.setVisible(false);// y esta la desaparezco

                //jDesktopPane1.add(userInterface);

                userInterface.show();
                
                
              System.out.println("Funciona");

            } else {

                jTextUsuario.setText("");

                jPasswordContra.setText("");

            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Faltan datos");
            jTextUsuario.setText("");
            jPasswordContra.setText("");
        }
    }//GEN-LAST:event_btnOkActionPerformed

    //Para crear nuevos Usuarios, Sign Up
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //es casi igual al metodo de arriba
        String username = jTextUsuario2.getText();//Agrego los datos en las variables
        String password = jPasswordContra2.getText();//contraseña
        if (!username.equals("") && !password.equals("")){
            
            database = new Metodos(username,password);

            database.openDatabase(1);//aca paso uno para que se ejecute el guardado de nodos

            JOptionPane.showMessageDialog(rootPane, "Usuario creado");

            this.user = database.getUser();

            jTextUsuario2.setText("");//Pongo en blanco mis casillas
            jPasswordContra2.setText("");

            if (this.user != null){
                System.out.println("Funciona y Creado");
            }else {

            JOptionPane.showMessageDialog(rootPane, "Faltan datos");

            jTextUsuario2.setText("");//Pongo casillas en blanco
            jPasswordContra2.setText("");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JPasswordField jPasswordContra;
    private javax.swing.JPasswordField jPasswordContra2;
    private javax.swing.JTextField jTextUsuario;
    private javax.swing.JTextField jTextUsuario2;
    private javax.swing.JButton jbtnSalir;
    // End of variables declaration//GEN-END:variables
}
