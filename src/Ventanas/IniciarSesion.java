/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

//import Clases.Usuario;
import diputacionAlava.Main;
import javax.swing.JOptionPane;

/**
 *
 * @author iBaD
 */
public class IniciarSesion extends javax.swing.JFrame {

   int opcion=0;
   //Usuario u;
    public IniciarSesion() {
        initComponents();
        setLocationRelativeTo(null);
        incorrectUser.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        eUsuario = new javax.swing.JLabel();
        tUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        incorrectUser = new javax.swing.JLabel();
        Acceder = new javax.swing.JButton();
        tPass = new javax.swing.JPasswordField();
        Registrar = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        eUsuario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        eUsuario.setText("Usuario:");

        tUsuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Contraseña:");

        incorrectUser.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        incorrectUser.setForeground(new java.awt.Color(255, 0, 0));
        incorrectUser.setText("*Usuario o contraseña incorrecta");

        Acceder.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Acceder.setText("Acceder");
        Acceder.setMaximumSize(new java.awt.Dimension(103, 45));
        Acceder.setMinimumSize(new java.awt.Dimension(103, 45));
        Acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccederActionPerformed(evt);
            }
        });

        Registrar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Registrar.setText("Registrar usuario");
        Registrar.setMaximumSize(new java.awt.Dimension(180, 45));
        Registrar.setMinimumSize(new java.awt.Dimension(180, 45));
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });

        Salir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Salir.setText("Salir");
        Salir.setMaximumSize(new java.awt.Dimension(103, 45));
        Salir.setMinimumSize(new java.awt.Dimension(103, 45));
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LOGIN");
        jLabel3.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(eUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(incorrectUser)
                            .addComponent(tPass, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Acceder, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(Registrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eUsuario)
                    .addComponent(tUsuario))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tPass, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(incorrectUser)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Registrar, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(Acceder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccederActionPerformed
        incorrectUser.setVisible(false);
        if(tUsuario.getText().equals("admin") && tPass.getText().equals("admin")){
            JOptionPane.showMessageDialog(null, "Has iniciado");
        }else{
            incorrectUser.setVisible(true);
        }
        /*NoUsuario.setVisible(false);
        NoPass.setVisible(false); 
        try{
            u = Main.BuscarUsuario(tUsuario.getText()); 
        }catch (Exception ex) {
               System.out.println("Ha ocurrido un error al buscar el usuario:\n\n" + ex.getMessage());
            } 
        if(u==null){
                NoUsuario.setVisible(true);
            }else{
           if(opcion==0){
              AccederOpcion0();
            }
           else if(opcion==1){
               AccederOpcion1();
            }
           else if(opcion==2){
                AccederOpcion2();
            } 
        } */
    }//GEN-LAST:event_AccederActionPerformed

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
         if(opcion==0){
            JOptionPane.showMessageDialog(this, "Deberá iniciar sesión con una cuenta con permisos de jefe/administrador");
           //Main.AbrirIniciarSesionAdmin(1);
        } else{
           // Main.ReiniciarIniciarSesion();
        }  
    }//GEN-LAST:event_RegistrarActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        Main.CerrarPrograma();
    }//GEN-LAST:event_SalirActionPerformed

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
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IniciarSesion().setVisible(true);
            }
        });
    }
    
    public void IniciarAdmin(int op){
        opcion=op;
        Registrar.setText("Cancelar");
        eUsuario.setText("Admin:");
        //Permisos.setVisible(false);
    }
    
    public void AccederOpcion0(){
         if(ComprobarPass()){
                //Main.IniciarAplicacion();
            }
    }
    
    public void AccederOpcion1(){
            if(ComprobarAdmin()&&ComprobarPass()){
                //Main.AbrirRegistrarUsuario();
             }
    }
    
    public void AccederOpcion2(){
        if(ComprobarAdmin()&&ComprobarPass()){
                //Main.AbrirDarPermisos();
            }
    }

    public boolean ComprobarPass(){
        /*if(!u.getPass().equals(passEncriptada)){
            NoPass.setVisible(true);
             return false;
        }else{
            NoPass.setVisible(false);
            return true;
        }*/
        return false;
    }
    
    public boolean ComprobarAdmin(){
        /*if(u.isAdmin()){
            NoUsuario.setVisible(false);
            return true;
        }else{
            NoUsuario.setText("*Usuario no admin");
            NoUsuario.setVisible(true);
            return false;
         } */
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Acceder;
    private javax.swing.JButton Registrar;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel eUsuario;
    private javax.swing.JLabel incorrectUser;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField tPass;
    private javax.swing.JTextField tUsuario;
    // End of variables declaration//GEN-END:variables
}
