package vista;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import modelo.EmpleadosCompletos;
import servicios.Exportar;
import servicios.Nomina;

public class PanelEmpleadosCompleto extends javax.swing.JPanel {

    private JPanel panelContenedor;
    private CardLayout cardLayout;
    private final Nomina nominaManager;

    public PanelEmpleadosCompleto(JPanel panelContenedor, CardLayout cardLayout, Nomina nominaManager) {
        initComponents();
        this.panelContenedor = panelContenedor;
        this.cardLayout = cardLayout;
        this.nominaManager = nominaManager;
    }


    public void llenarTabla(Nomina nominaManager) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        // Limpia la tabla para evitar datos duplicados
        modelo.setRowCount(0); 

        for (Empleado empleado : nominaManager.getListaEmpleados()) {
            if (empleado instanceof EmpleadosCompletos) { // o EmpleadoParcial
                EmpleadosCompletos empleadoCompleto = (EmpleadosCompletos) empleado;
                // Añade los datos del empleado a la tabla
                Object[] fila = {
                    empleadoCompleto.getNombre(),
                    empleadoCompleto.getId(),
                    "Tiempo Completo",
                };
                modelo.addRow(fila);
            }
        }
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible && nominaManager != null) {
            llenarTabla(nominaManager);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        exportarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel1.setText("Empleados Término Fijo - Nóminas Calculadas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(jLabel1)
                .addContainerGap(276, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 270;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jPanel1, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Dubai", 0, 24)); // NOI18N
        jLabel2.setText("Para exportar nomina selecciona al empleado y presiona el boton");

        exportarBtn.setFont(new java.awt.Font("Dubai", 0, 24)); // NOI18N
        exportarBtn.setText("Exportar");
        exportarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exportarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(exportarBtn))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.ipady = 23;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 0, 0);
        add(jPanel2, gridBagConstraints);

        tabla.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Identificación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 434;
        gridBagConstraints.ipady = 276;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(34, 6, 112, 0);
        add(jScrollPane1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void exportarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportarBtnActionPerformed
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona un empleado para exportar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        
        String idEmpleado = (String) tabla.getValueAt(filaSeleccionada, 1);

        // Busca el objeto id en la lista de la clase Nomina
        Empleado empleadoAExportar = null;
        for (Empleado empleado : nominaManager.getListaEmpleados()) {
            if (empleado.getId().equals(idEmpleado)) {
                empleadoAExportar = empleado;
                break;
            }
        }        

        if (empleadoAExportar != null) {
            // Asegúrate de que la clase Exportar esté en el paquete 'servicios'
            Exportar exportar = new Exportar();
            exportar.generarTXT(empleadoAExportar);
            JOptionPane.showMessageDialog(null, "Archivo TXT generado con éxito para " + idEmpleado, "Exportación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_exportarBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exportarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
