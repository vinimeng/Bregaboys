/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.CompraDAO;
import dao.CompraProdutoDAO;
import excecoes.NEscTrnasportadoraException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import vo.CompraProdutoVO;
import vo.CompraVO;
import vo.ProdutoVO;

/**
 *
 * @author Vinicius Meng
 */
public class ConfirmaCompra extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1162654050685086140L;
	private ArrayList <ProdutoVO> produtos;
    private CompraVO cVo;
    private CompraDAO cDao;
    private CompraProdutoDAO cPDao;
    private ArrayList <Integer> codProd; 
    private ArrayList <Integer> qntProd;
    private DefaultTableModel dm;
    
    /**
     * Creates new form ConfirmaCompra
     */
    public ConfirmaCompra(int codCli, int codComp, ArrayList <ProdutoVO> produtos, ArrayList <Integer> codProd, ArrayList <Integer> qntProd){
        initComponents();
        this.setLocationRelativeTo(null);
        this.produtos = produtos;
        this.cVo = new CompraVO();
        this.cVo.setCodigoCliente(codCli);
        this.cVo.setCodigoCompra(codComp);
        this.cVo.setCodigoTransportadora(-1);
        this.codProd = codProd;
        this.qntProd = qntProd;
        this.cDao = new CompraDAO();
        this.cPDao = new CompraProdutoDAO();
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
        Object [] tituloColunas = {"Codigo Compra", "C�digo do produto", "Nome do produto", "Quantidade", "Valor unit�rio"};
        this.dm = new DefaultTableModel(){
            /**
			 * 
			 */
			private static final long serialVersionUID = 6281342499347755273L;

			@Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {  
                return false;  
            }
        };
        this.dm.setDataVector(this.fazTabelCC(codComp), tituloColunas);
        this.tabelaCompras.setModel(dm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelLista = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCompras = new javax.swing.JTable();
        butConfirmar = new javax.swing.JButton();
        butCancelar = new javax.swing.JButton();
        butEscTransportadora = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Confirmar Compra");

        labelLista.setText("Lista de itens comprados:");

        tabelaCompras.setModel(new DefaultTableModel());
        jScrollPane1.setViewportView(tabelaCompras);

        butConfirmar.setText("Confirmar Compra");
        butConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butConfirmarActionPerformed(evt);
            }
        });

        butCancelar.setText("Cancelar");
        butCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCancelarActionPerformed(evt);
            }
        });

        butEscTransportadora.setText("Escolher Transportadora");
        butEscTransportadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butEscTransportadoraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelLista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 347, Short.MAX_VALUE)
                        .addComponent(butEscTransportadora))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(butCancelar)
                            .addComponent(butConfirmar))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butEscTransportadora)
                    .addComponent(labelLista))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(butConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butCancelar)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butEscTransportadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEscTransportadoraActionPerformed
        EscolheTransportadora et = new EscolheTransportadora(ConfirmaCompra.this);
        et.setVisible(true);
    }//GEN-LAST:event_butEscTransportadoraActionPerformed

    private void butCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_butCancelarActionPerformed

    private void butConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butConfirmarActionPerformed
        try {
            if(this.cVo.getCodigoTransportadora() == -1){
                throw new NEscTrnasportadoraException();
            }
            else{
               this.cDao.criarCompra(this.cVo);
               for(int i = 0; i < this.codProd.size(); i++){
                   CompraProdutoVO cPVo = new CompraProdutoVO(this.cVo.getCodigoCompra(), this.codProd.get(i), this.qntProd.get(i));
                   this.cPDao.criarCompraProduto(cPVo);
               }
               JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
               this.dispose();
            }
        }  catch (NEscTrnasportadoraException ex) {
            Logger.getLogger(ConfirmaCompra.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConfirmaCompra.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "N�o foi poss�vel efetuar a compra!\nClassNotFoundException", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(ConfirmaCompra.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "N�o foi poss�vel efetuar a compra!\nSQLException", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_butConfirmarActionPerformed

    private Object[][] fazTabelCC(int codComp){
        Object [][] dados = new Object[this.codProd.size()][5];
        for (int i = 0; i < this.codProd.size(); i++) {
            for(int j = 0; j < this.produtos.size(); j++){
                if(this.produtos.get(j).getCodigoProduto() == this.codProd.get(i)){
                    dados[i][0] = codComp;
                    dados[i][1] = this.codProd.get(i);
                    dados[i][2] = this.produtos.get(j).getNomeProduto();
                    dados[i][3] = this.codProd.get(i);
                    String valor = ("R$ " + this.produtos.get(i).getValorUnitario() + "0").replace(".", ",");
                    dados[i][4] = valor;
                }
            }
        }
        return dados;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butCancelar;
    private javax.swing.JButton butConfirmar;
    private javax.swing.JButton butEscTransportadora;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelLista;
    private javax.swing.JTable tabelaCompras;
    // End of variables declaration//GEN-END:variables

    public void setCodTrans(int codTrans) {
        this.cVo.setCodigoTransportadora(codTrans);
    }
}
