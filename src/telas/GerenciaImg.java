/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.ProdutoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import util.ConectaBD;
import vo.ImagemVO;
import vo.ProdutoVO;

/**
 *
 * @author 05200121
 */
public class GerenciaImg extends javax.swing.JFrame {
    
    private ArrayList <ImagemVO> retorno;
    private DefaultTableModel dm;
    private TableRowSorter <DefaultTableModel> trs;
    
    /**
     * Creates new form GerenciaImg
     */
    public GerenciaImg() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        this.retorno = new ArrayList();
        try {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Imagem");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                ImagemVO vo = new ImagemVO(resultSet.getInt("codigoImagem"),
                    resultSet.getString("nomeImagem"));
                retorno.add(vo);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SalvaImagens.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível resgastar o código!\nClassNotFoundException", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(SalvaImagens.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível resgastar o código!\nSQLException", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        this.dm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {  
                return false;  
            }
        };
        Object[] nomeColunas = {"Código da imagem", "Nome da Imagem"};
        this.dm.setDataVector(this.fazTabela(), nomeColunas);
        this.tabela.setModel(dm);
        this.trs = new TableRowSorter(this.dm);
        this.tabela.setRowSorter(trs);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labFiltrar = new javax.swing.JLabel();
        textFiltrar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        butAlterar = new javax.swing.JButton();
        butDeletar = new javax.swing.JButton();
        butSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Imagem");

        labFiltrar.setText("Filtrar:");

        textFiltrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFiltrarKeyReleased(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        butAlterar.setText("Alterar");
        butAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAlterarActionPerformed(evt);
            }
        });

        butDeletar.setText("Deletar");
        butDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butDeletarActionPerformed(evt);
            }
        });

        butSair.setText("Sair");
        butSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSairActionPerformed(evt);
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
                        .addComponent(textFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butAlterar)
                    .addComponent(butDeletar)
                    .addComponent(butSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labFiltrar)
                    .addComponent(textFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(butAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butDeletar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(butSair)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFiltrarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFiltrarKeyReleased
        RowFilter<DefaultTableModel, Object> regexFilter = RowFilter.regexFilter(this.textFiltrar.getText() + "");
        this.trs.setRowFilter(regexFilter);
    }//GEN-LAST:event_textFiltrarKeyReleased

    private void butSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_butSairActionPerformed

    private void butDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butDeletarActionPerformed
        if(tabela.getSelectedRow() != -1){
            try {
                ArrayList <ProdutoVO> a = new ProdutoDAO().buscarProdutoAll();
                int imgSelecionado = (Integer)this.tabela.getValueAt(this.tabela.getSelectedRow(), 0);
                for(int i = 0; i < a.size(); i++){
                    if(a.get(i).getCodigoImagem() == imgSelecionado){
                        new ProdutoDAO().alterarProduto(new ProdutoVO(a.get(i).getCodigoFornecedor(), a.get(i).getCodigoProduto(), a.get(i).getCodigoSecao(), 1, a.get(i).getNomeProduto(), a.get(i).getValorUnitario()));
                    }
                }
                Connection connection = ConectaBD.getConnection();
                PreparedStatement statement = connection.prepareStatement("DELETE from Imagem " + "WHERE codigoImagem = ?");
                statement.setInt(1, imgSelecionado);
                statement.executeUpdate();
                statement.close();
                connection.close();
                JOptionPane.showMessageDialog(this, "Imagem deletada!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(GerenciaImg.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GerenciaImg.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_butDeletarActionPerformed

    private void butAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAlterarActionPerformed
        if(tabela.getSelectedRow() != -1){
            try{
                Connection connection;
                connection = ConectaBD.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM Imagem WHERE codigoImagem = ?");
                statement.setInt(1, ((Integer)this.tabela.getValueAt(this.tabela.getSelectedRow(), 0)));
                ResultSet resultSet = statement.executeQuery();
                resultSet.next();
                ImagemVO vo = new ImagemVO(resultSet.getInt("codigoImagem"),
                    resultSet.getString("nomeImagem"));
                resultSet.close();
                statement.close();
                connection.close();
                new DetalhesGerenciamento(vo).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(GerenciaImg.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GerenciaImg.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_butAlterarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAlterar;
    private javax.swing.JButton butDeletar;
    private javax.swing.JButton butSair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labFiltrar;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField textFiltrar;
    // End of variables declaration//GEN-END:variables

    private Object[][] fazTabela(){
        Object[][] dados = new Object[this.retorno.size()][2];
        for (int i = 0; i < this.retorno.size(); i++) {
            dados[i][0] = this.retorno.get(i).getCodigoImagem();
            dados[i][1] = this.retorno.get(i).getNomeImagem();
        }
        return dados;
    }
            
}
