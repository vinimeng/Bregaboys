/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dao.ClienteDAO;
import vo.ClienteVO;

/**
 *
 * @author 05200004
 */
public class SelecionarCliente extends javax.swing.JFrame {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 4892815475635260955L;
	private JanelaFuncionario jf;
    private ClienteDAO cDao;
    private ArrayList <ClienteVO> listaCli;
    private DefaultTableModel dm;
    private TableRowSorter <DefaultTableModel> trs;
    
    public SelecionarCliente() {
        initComponents();
    }

    public SelecionarCliente(JanelaFuncionario jf) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.jf = jf;
        this.cDao = new ClienteDAO();
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
            this.listaCli = cDao.buscarClienteAll();
        } catch (SQLException ex) {
            Logger.getLogger(JanelaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "N�o foi poss�vel mostrar os clientes!\nSQLException", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JanelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "N�o foi poss�vel mostrar os clientes!\nClassNotFoundException", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        Object [] tituloColunas = {"C�digo Cliente", "Nome Cliente"};
        this.dm = new DefaultTableModel(){
            /**
			 * 
			 */
			private static final long serialVersionUID = -6376642242344000262L;

			@Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {  
                return false;  
            }
        };
        this.dm.setDataVector(this.fazTabelCliente(), tituloColunas);
        this.tabelaClientes.setModel(dm);
        this.trs = new TableRowSorter<DefaultTableModel>(this.dm);
        this.tabelaClientes.setRowSorter(trs);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        butOk = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        textFiltrar = new javax.swing.JTextField();
        labFiltrar = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        butOk.setText("Ok");
        butOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butOkActionPerformed(evt);
            }
        });

        tabelaClientes.setModel(new DefaultTableModel());
        tabelaClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabelaClientes);

        textFiltrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFiltrarKeyReleased(evt);
            }
        });

        labFiltrar.setText("Filtrar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(butOk, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labFiltrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFiltrar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labFiltrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butOk)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Object[][] fazTabelCliente(){
        Object[][] dados = new Object[this.listaCli.size()][3];
        for (int i = 0; i < this.listaCli.size(); i++) {
            dados[i][0] = this.listaCli.get(i).getCodigoCliente();
            dados[i][1] = this.listaCli.get(i).getNomeCliente();
        }
        return dados;
    }
    
    private void butOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butOkActionPerformed
        String nome = (String) this.tabelaClientes.getValueAt(this.tabelaClientes.getSelectedRow(), 1);
        int cod = (Integer) this.tabelaClientes.getValueAt(this.tabelaClientes.getSelectedRow(), 0);
        jf.setNomeCliente(nome, cod);
        dispose();
    }//GEN-LAST:event_butOkActionPerformed

    private void textFiltrarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFiltrarKeyReleased
        RowFilter<DefaultTableModel, Object> regexFilter = RowFilter.regexFilter(this.textFiltrar.getText() + "");
        this.trs.setRowFilter(regexFilter);
    }//GEN-LAST:event_textFiltrarKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butOk;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labFiltrar;
    private javax.swing.JTable tabelaClientes;
    private javax.swing.JTextField textFiltrar;
    // End of variables declaration//GEN-END:variables
}