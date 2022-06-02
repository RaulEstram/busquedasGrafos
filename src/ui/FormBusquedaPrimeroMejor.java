package ui;

import data.ReadFileCSV;
import java.awt.Color;
import javax.swing.JOptionPane;
import search.BestFirst;

public class FormBusquedaPrimeroMejor extends javax.swing.JPanel {

    public FormBusquedaPrimeroMejor() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonCalcular = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        numNode = new javax.swing.JTextField();
        numEnd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextArea = new javax.swing.JTextArea();
        ButtonClear = new javax.swing.JLabel();

        setBackground(new java.awt.Color(253, 253, 253));

        ButtonCalcular.setBackground(new java.awt.Color(201, 214, 223));
        ButtonCalcular.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ButtonCalcular.setText("Calcular por Primero Mejor");
        ButtonCalcular.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonCalcular.setOpaque(true);
        ButtonCalcular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonCalcularMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonCalcularMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonCalcularMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ButtonCalcularMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButtonCalcularMouseReleased(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horario", "Antihorario"}));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel1.setText("Nodo Inicial");

        jLabel2.setText("Nodo Final");

        TextArea.setColumns(20);
        TextArea.setRows(5);
        jScrollPane1.setViewportView(TextArea);

        ButtonClear.setBackground(new java.awt.Color(201, 214, 223));
        ButtonClear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ButtonClear.setText("Limpiar");
        ButtonClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonClear.setOpaque(true);
        ButtonClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonClearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonClearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonClearMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ButtonClearMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButtonClearMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ButtonCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numNode, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ButtonCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(numEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(numNode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonCalcularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCalcularMouseClicked
        try {

            try {
                // se comprueba que los nodos digitados sean validos
                int firts = Integer.parseInt(numNode.getText().replace(" ", ""));
                int end = Integer.parseInt(numEnd.getText().replace(" ", ""));
                // se comprueba que se seleccionaron los archivos necesarios
                if ("".equals(main.nodesPath) || "".equals(main.distancesPath)) {
                    JOptionPane.showMessageDialog(null, "Se tienen que seleccionar los archivos cvs con la informacion necesaria para realizar este tipo de busqueda", "Error seleccionar archivo", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // se procede a realizar la busqueda con este metodo
                ReadFileCSV nodos = new ReadFileCSV(main.nodesPath);
                ReadFileCSV distancias = new ReadFileCSV(main.distancesPath);
                BestFirst dfs = new BestFirst(nodos.getData(), distancias.getData());
                dfs.search(firts, end, jComboBox1.getItemAt(jComboBox1.getSelectedIndex()));
                // se muestran los pasos al usuario
                TextArea.setText(dfs.getSteps() + "\n\n\n\n" + dfs.getRute());

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Se tienen que digitar numeros", "Error al definir los nodos", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error: \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ButtonCalcularMouseClicked

    private void ButtonCalcularMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCalcularMouseEntered
        ButtonCalcular.setBackground(new Color(82, 97, 107));
        ButtonCalcular.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_ButtonCalcularMouseEntered

    private void ButtonCalcularMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCalcularMouseExited
        ButtonCalcular.setBackground(new Color(201, 214, 223));
        ButtonCalcular.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_ButtonCalcularMouseExited

    private void ButtonCalcularMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCalcularMousePressed
        ButtonCalcular.setBackground(new Color(30, 32, 34));
    }//GEN-LAST:event_ButtonCalcularMousePressed

    private void ButtonCalcularMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCalcularMouseReleased
        ButtonCalcular.setBackground(new Color(82, 97, 107));
    }//GEN-LAST:event_ButtonCalcularMouseReleased

    private void ButtonClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonClearMouseClicked
        TextArea.setText("");
    }//GEN-LAST:event_ButtonClearMouseClicked

    private void ButtonClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonClearMouseEntered
        ButtonClear.setBackground(new Color(82, 97, 107));
        ButtonClear.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_ButtonClearMouseEntered

    private void ButtonClearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonClearMouseExited
        ButtonClear.setBackground(new Color(201, 214, 223));
        ButtonClear.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_ButtonClearMouseExited

    private void ButtonClearMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonClearMousePressed
        ButtonClear.setBackground(new Color(30, 32, 34));
    }//GEN-LAST:event_ButtonClearMousePressed

    private void ButtonClearMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonClearMouseReleased
        ButtonClear.setBackground(new Color(82, 97, 107));
    }//GEN-LAST:event_ButtonClearMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ButtonCalcular;
    private javax.swing.JLabel ButtonClear;
    private javax.swing.JTextArea TextArea;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField numEnd;
    private javax.swing.JTextField numNode;
    // End of variables declaration//GEN-END:variables
}
