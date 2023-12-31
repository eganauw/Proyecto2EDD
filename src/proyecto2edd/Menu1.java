/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto2edd;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import static proyecto2edd.Proyecto2EDD.hashtable;
import static proyecto2edd.Proyecto2EDD.arbolcedulas;
import static proyecto2edd.Proyecto2EDD.arbolhistorial;
import static proyecto2edd.Proyecto2EDD.roomslist;
import static proyecto2edd.Proyecto2EDD.clienteshospedadoslist;
/**
 *
 * @author rodri
 */
public class Menu1 extends javax.swing.JFrame {

    /**
     * Creates new form Menu1
     */
    public Menu1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        RegistroClientes = new javax.swing.JButton();
        BuscarReserva = new javax.swing.JButton();
        HistorialHab = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei Light", 3, 36)); // NOI18N
        jLabel1.setText("HOTEL UNIMET");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 280, -1));

        RegistroClientes.setText("Buscar Clientes");
        RegistroClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistroClientesActionPerformed(evt);
            }
        });
        getContentPane().add(RegistroClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 140, -1));

        BuscarReserva.setText("Buscar Reserva");
        BuscarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarReservaActionPerformed(evt);
            }
        });
        getContentPane().add(BuscarReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        HistorialHab.setText("Historial de habitaciones");
        HistorialHab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistorialHabActionPerformed(evt);
            }
        });
        getContentPane().add(HistorialHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        getContentPane().add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 60, -1));

        jLabel2.setText("------------------------------------------ o ---------------------------------------------");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 370, -1));

        jButton1.setText("Check-in");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 140, -1));

        jButton2.setText("Check-out");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 130, 100, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegistroClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistroClientesActionPerformed
        // TODO add your handling code here:
        String nombre = capitalizeFirstLetter(JOptionPane.showInputDialog("Ingrese el primer nombre del huesped: "));
        String apellido = capitalizeFirstLetter(JOptionPane.showInputDialog("Ingrese el apellido del huesped: "));
         hashtable.buscarhab(nombre,apellido);
    }//GEN-LAST:event_RegistroClientesActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_SalirActionPerformed

    private void BuscarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarReservaActionPerformed
        // TODO add your handling code here:
        String cedula1 = JOptionPane.showInputDialog("Ingrese la cedula de la persona que desea buscar su reserva: ");
        cedula1 = cedula1.replace(".","");
        try{
        int cedula = Integer.parseInt(cedula1);
        TreeNode aux = arbolcedulas.getRoot();
        if(arbolcedulas.isInTheTree(aux, cedula)){
        JOptionPane.showMessageDialog(null, arbolcedulas.search(aux,cedula).getData());
        }else{
            JOptionPane.showMessageDialog(null, "La cédula ingresada no se encuentra en la lista de reservas.");
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error, ingrese una cédula válida.");
        }
    }//GEN-LAST:event_BuscarReservaActionPerformed

    public static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        
        String firstLetter = input.substring(0, 1).toUpperCase();
        String restOfTheString = input.substring(1).toLowerCase();
        
        return firstLetter + restOfTheString;
    }
    private void HistorialHabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistorialHabActionPerformed
        // TODO add your handling code here:
        String habS = JOptionPane.showInputDialog("Ingrese el número de la habitación: ");
        try{
        int hab = Integer.parseInt(habS);
        Habitacion aux = arbolhistorial.getRoot();
        if(arbolhistorial.isInTheTree(aux, hab)){
        JOptionPane.showMessageDialog(null, "Habitacion "+habS+":\n"+arbolhistorial.search(aux,hab).getHistorial());
        }else{
            JOptionPane.showMessageDialog(null, "La habitación "+habS+" no fue encontrada.");
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error, ingrese una habitación válida.");
        }
    }//GEN-LAST:event_HistorialHabActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String scedula = JOptionPane.showInputDialog("Ingrese la cédula del huésped: ");
        scedula = scedula.replace(".", "");
        try{
        int cedula = Integer.parseInt(scedula);
        TreeNode aux = arbolcedulas.getRoot();
        if(arbolcedulas.isInTheTree(aux, cedula)){
            TreeNode cliente = arbolcedulas.search(aux, cedula);
            String[] datoss = cliente.getData().split("/");
            String nombre = datoss[0].replace(" ","");
            String correo = datoss[1];
            String genero = datoss[2];
            String celular = datoss[3];
            String llegada = datoss[4]; 
            clientehospedado clienteh = new clientehospedado(nombre,correo,genero,celular,llegada);
             ClienteHospedado2 clienteh2 = new ClienteHospedado2(nombre,correo,genero,celular,llegada);
            clienteshospedadoslist.insert(clienteh2);
            if(hashtable.getRoomNumber(nombre)==-1){
            arbolcedulas.delete(aux, cedula);
            JDialog.setDefaultLookAndFeelDecorated(true);
            String[] selectionValues = { "Simple", "Doble", "Triple","Suite" };
            String initialSelection = "Simple";
            String habitacion = (String) JOptionPane.showInputDialog(null, "Bienvenido/a "+nombre+", porfavor elija el tipo de habitación que desea: ",
        "Habitación", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
                Room room = roomslist.findFreeRoom(habitacion);
                if(room == null){
                 JOptionPane.showMessageDialog(null, "Lo sentimos, no se encontró ninguna habitación disponible.");
                }else{ 
                int roomNumber = room.numero;
                hashtable.addGuest(clienteh, roomNumber);
                JOptionPane.showMessageDialog(null, "Al cliente "+nombre+" se le ha asignado la habitación "+room.tipo+" #"+Integer.toString(roomNumber)+" , en el piso "+Integer.toString(room.piso));
                room.ocupada = true;
                }
            }else{
                JOptionPane.showMessageDialog(null,"El cliente ya se encuentra hospedado.");
            }    
        }else{
            JOptionPane.showMessageDialog(null, "No existen reservaciones bajo ese número de cédula.");
        }
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error, ingrese una cédula válida.");
                }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
        String nombre = capitalizeFirstLetter(JOptionPane.showInputDialog("Ingrese el primer nombre del huésped que va a salir: "));
        String apellido = capitalizeFirstLetter(JOptionPane.showInputDialog("Ingrese el apellido del huesped que va a salir: "));
        String nombrecompleto = nombre+apellido;
        int numhab = hashtable.getRoomNumber(nombrecompleto);
        String datoscliente = "";
        if(numhab==-1){
            JOptionPane.showMessageDialog(null, "No se encuentra lojado actualmente en el hotel.");
        }else{
            Room aux = roomslist.pFirst;
            while(aux!=null){
                if(numhab==aux.numero){
                    aux.ocupada = false;
                    JOptionPane.showMessageDialog(null,"La habitacion "+numhab+" ha sido desocupada.");
                    break;
                }else{
                    aux = aux.getPnext();
                }
            }
              Habitacion habaux = arbolhistorial.getRoot();
              Habitacion habitacionencontrada = arbolhistorial.search(habaux,numhab);
              ClienteHospedado2 claux = clienteshospedadoslist.pFirst;
              while(claux!=null){
                  if(claux.getNombre().equals(nombrecompleto.replace(" ", ""))){
                      datoscliente = "Nombre: "+claux.getNombre()+" Correo: "+claux.getCorreo()+" Genero: "+claux.getGenero()+" Celular: "+claux.getCelular()+ "Llegada: "+claux.getLlegada();
                      arbolhistorial.search(habaux,numhab).setHistorial(habitacionencontrada.getHistorial()+"\n"+datoscliente); 
                      break;
                  }else{
                      claux = claux.getPnext();
                  }
              }
              hashtable.removeGuest(nombrecompleto);
            }
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null, "Error, ingrese un nombre válido.");
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarReserva;
    private javax.swing.JButton HistorialHab;
    private javax.swing.JButton RegistroClientes;
    private javax.swing.JButton Salir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
