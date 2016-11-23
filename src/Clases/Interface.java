/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Iterator;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;

/**
 *
 * @author LuisEstuardo
 */
public class Interface extends javax.swing.JFrame {

    
    //Atributos
    private Node user;
    private Node user2;
    private String Tipo_J;
    private Vector<Node> friends;
    private Vector<String> name;
    private Vector<Node> recommendations;
    private Vector<String> channel = new Vector();
    private Metodos database;
    
    /**
     * Creates new form Interface
     */
    public Interface(Node user) {
        initComponents();
        this.user = user;
    }
    public Interface(){}
    
    
    
    private static enum NodeType implements Label{

        USER,JUEGO,TIPO_JUEGO;

    }
    
    private static enum RelType implements RelationshipType{
        ES_TIPO,Play,Interesado;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Accion = new javax.swing.JRadioButton();
        Shooter = new javax.swing.JRadioButton();
        Salir = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        enviar = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Accion.setText("Accion");
        Accion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccionActionPerformed(evt);
            }
        });
        getContentPane().add(Accion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        Shooter.setText("Shooter");
        Shooter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShooterActionPerformed(evt);
            }
        });
        getContentPane().add(Shooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, -1, -1));

        Salir.setText("Exit?");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        getContentPane().add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        Reset.setText("Reset?");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });
        getContentPane().add(Reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, -1, -1));

        enviar.setText("Enviar?");
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });
        getContentPane().add(enviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, -1, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/2PARTE.png"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 380));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        Accion.setSelected(false);
        Shooter.setSelected(false);
    }//GEN-LAST:event_ResetActionPerformed

    private void AccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccionActionPerformed
        if (Accion.isSelected()){
            Shooter.setSelected(false);
        }
    }//GEN-LAST:event_AccionActionPerformed

    private void ShooterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShooterActionPerformed
        if (Shooter.isSelected()){
            Accion.setSelected(false);
        }
    }//GEN-LAST:event_ShooterActionPerformed

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed

        if(Accion.isSelected()){
            System.out.println("Accion Seleccionado");
            try (Transaction tx = database.getGraphDatabaseService().beginTx()) {
                
                Metodos met = new Metodos();
                Tipo_J = "Accion";
                //Tome el nodo de la persona   
                //Tome el nodo seleccionado
                //Crear relacion entre los 2 nodos
                met.Relacionar(user, Tipo_J);
                
                
                
                //Buscar nodos que tengan la misma relacion que arriba
                
                //Mandarlo a dezplegar en la interfaz,
                
                //Si el usuario le da click algun nodo que aparecio
                
                //Crear relacion, esta interesado
                
                tx.success();
            }
            database.shutdown();

        }
        else if(Shooter.isSelected()){
            System.out.println("Shooter Seleccionado");
        }
        else{
            System.out.println("Seleccione uno");
        }
    }//GEN-LAST:event_enviarActionPerformed

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
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }
    
    
    /*
    *Metodo tomar base de Datos
    */
    public Metodos getDatabase() {
    return database;
    }
    
    /**
     * @param database the database to set
     */
     public void setDatabase(Metodos database) {
        this.database = database;
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Accion;
    private javax.swing.JButton Reset;
    private javax.swing.JButton Salir;
    private javax.swing.JRadioButton Shooter;
    private javax.swing.JButton enviar;
    private javax.swing.JLabel jLabelFondo;
    // End of variables declaration//GEN-END:variables
}
