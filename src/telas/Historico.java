/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.TabelaHistorico;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Vinicius Meng
 */
public class Historico extends javax.swing.JFrame {

    private DefaultTableModel dm;
    private TabelaHistorico th;
    private TableRowSorter <DefaultTableModel> trs;
    
    /**
     * Creates new form Historico
     */
    public Historico(int codigoCliente){
        initComponents();
        this.setLocationRelativeTo(null);
        this.dm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {  
                return false;  
            }
        };
        th = new TabelaHistorico(codigoCliente);
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JanelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível definir o look and feel do Windows!\nClassNotFoundException", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (InstantiationException ex) {
            Logger.getLogger(JanelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível definir o look and feel do Windows!\nInstantiationException", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JanelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível definir o look and feel do Windows!\nIllegalAccessException", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(JanelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível definir o look and feel do Windows!\nUnsupportedLookAndFeelException", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        Object [] tituloColunas = {"Código cliente", "Código compra", "Código Transportadora", "Código Produto", "Nome Produto", "Quantidade produto", "Valor unitário", "Quantidade total", "Valor Total" };
        this.dm.setDataVector(th.fazTabelHist(), tituloColunas);
        this.tabela.setModel(dm);
        this.trs = new TableRowSorter(this.dm);
        this.tabela.setRowSorter(trs);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollTabela = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        butOk = new javax.swing.JButton();
        labFiltrar = new javax.swing.JLabel();
        textFiltrar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Histórico");

        tabela.setModel(new DefaultTableModel());
        scrollTabela.setViewportView(tabela);

        butOk.setText("Ok");
        butOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butOkActionPerformed(evt);
            }
        });

        labFiltrar.setText("Filtrar:");

        textFiltrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFiltrarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labFiltrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(butOk))
                    .addComponent(scrollTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butOk)
                    .addComponent(labFiltrar)
                    .addComponent(textFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butOkActionPerformed
        this.dispose();
    }//GEN-LAST:event_butOkActionPerformed

    private void textFiltrarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFiltrarKeyReleased
        RowFilter<DefaultTableModel, Object> regexFilter = RowFilter.regexFilter(this.textFiltrar.getText() + "");
        this.trs.setRowFilter(regexFilter);
    }//GEN-LAST:event_textFiltrarKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butOk;
    private javax.swing.JLabel labFiltrar;
    private javax.swing.JScrollPane scrollTabela;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField textFiltrar;
    // End of variables declaration//GEN-END:variables
}
