/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.TransportadoraDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import vo.TransportadoraVO;

/**
 *
 * @author Vinicius Meng
 */
public class EscolheTransportadora extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8935523780236728554L;
	private TransportadoraDAO tDao;
    private ArrayList <TransportadoraVO> tVo;
    private DefaultTableModel dm;
    private JFrame cC;
    private TableRowSorter <DefaultTableModel> trs;
    
    /**
     * Creates new form EscolheTransportadora
     */
    public EscolheTransportadora(JFrame cC) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.cC = cC;
        this.tDao = new TransportadoraDAO();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JanelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "N�o foi poss�vel definir o look and feel do Windows!\nClassNotFoundException", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (InstantiationException ex) {
            Logger.getLogger(JanelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "N�o foi poss�vel definir o look and feel do Windows!\nInstantiationException", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JanelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "N�o foi poss�vel definir o look and feel do Windows!\nIllegalAccessException", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(JanelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "N�o foi poss�vel definir o look and feel do Windows!\nUnsupportedLookAndFeelException", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            this.tVo = this.tDao.buscarTransportadoraAll();
        } catch (SQLException ex) {
            Logger.getLogger(JanelaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "N�o foi poss�vel mostrar as transportadoras!\nSQLException", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JanelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "N�o foi poss�vel mostrar as transportadoras!\nClassNotFoundException", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        Object [] tituloColunas = {"C�digo da Transportadora", "Nome", "Telefone", "Email"};
        this.dm = new DefaultTableModel(){
            /**
			 * 
			 */
			private static final long serialVersionUID = 1510403183639919794L;

			@Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {  
                return false;  
            }
        };
        this.dm.setDataVector(this.fazTabelTrans(), tituloColunas);
        this.tabelaTrans.setModel(dm);
        this.trs = new TableRowSorter<DefaultTableModel>(this.dm);
        this.tabelaTrans.setRowSorter(trs);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaTrans = new javax.swing.JTable();
        butCancel = new javax.swing.JButton();
        butOk = new javax.swing.JButton();
        labFiltrar = new javax.swing.JLabel();
        textFiltrar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabelaTrans.setModel(new DefaultTableModel());
        tabelaTrans.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabelaTrans);

        butCancel.setText("Cancelar");
        butCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCancelActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labFiltrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFiltrar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butOk)
                    .addComponent(butCancel))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labFiltrar)
                    .addComponent(textFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(butOk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butCancel))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butOkActionPerformed
        int codTrans = (Integer)this.tabelaTrans.getValueAt(this.tabelaTrans.getSelectedRow(), 0);
        ConfirmaCompra janelCc = (ConfirmaCompra) this.cC;
        janelCc.setCodTrans(codTrans);
        this.dispose();
    }//GEN-LAST:event_butOkActionPerformed

    private void butCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_butCancelActionPerformed

    private void textFiltrarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFiltrarKeyReleased
        RowFilter<DefaultTableModel, Object> regexFilter = RowFilter.regexFilter(this.textFiltrar.getText() + "");
        this.trs.setRowFilter(regexFilter);
    }//GEN-LAST:event_textFiltrarKeyReleased

    private Object[][] fazTabelTrans(){
        Object[][] dados = new Object[this.tVo.size()][4];
        for (int i = 0; i < this.tVo.size(); i++) {
            dados[i][0] = this.tVo.get(i).getCodigoTransportadora();
            dados[i][1] = this.tVo.get(i).getNomeTransportadora();
            dados[i][2] = this.tVo.get(i).getTelefoneTransportadora();
            dados[i][3] = this.tVo.get(i).getEmailTransportadora();
        }
        return dados;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butCancel;
    private javax.swing.JButton butOk;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labFiltrar;
    private javax.swing.JTable tabelaTrans;
    private javax.swing.JTextField textFiltrar;
    // End of variables declaration//GEN-END:variables
}
