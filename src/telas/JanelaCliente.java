/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.CompraDAO;
import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import vo.ClienteVO;
import vo.ProdutoVO;

/**
 *
 * @author 05200121
 */
public class JanelaCliente extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2350084456702019845L;
	private ArrayList <ProdutoVO> produtos;
    private ArrayList <Integer> codProd;
    private ArrayList <Integer> qntProd;
    private CompraDAO cDao;
    private ProdutoDAO pDao;
    private DefaultTableModel dm;
    private float valorTotal;
    private int qntComprada;
    private int codCli;
    private int codComp;
    private TableRowSorter <DefaultTableModel> trs;
    
    /**
     * Creates new form JanelaCliente
     * @param cVo
     */
    public JanelaCliente(ClienteVO cVo) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.codCli = cVo.getCodigoCliente();
        this.qntComprada = 0;
        this.valorTotal = 0;
        this.codProd = new ArrayList<Integer>();
        this.qntProd = new ArrayList<Integer>();
        this.cDao = new CompraDAO();
        this.pDao = new ProdutoDAO();
        this.labelOla.setText("<html>Olá, " + cVo.getNomeCliente() + ", seja bem-vindo!<br><br>Código do cliente: " + cVo.getCodigoCliente() + "</html>");
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
        try {
            this.produtos = this.pDao.buscarProdutoAll();
        } catch (SQLException ex) {
            Logger.getLogger(JanelaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível mostrar os produtos!\nSQLException", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JanelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível mostrar os produtos!\nClassNotFoundException", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            this.codComp = this.cDao.codigoClienteMax() + 1;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JanelaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possivel criar um código para a compra!\nClassNotFoundException", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(JanelaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possivel criar um código para a compra!\nSQLException", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        Object [] tituloColunas = {"Código do produto", "Nome do produto", "Valor unitário"};
        this.dm = new DefaultTableModel(){
            /**
			 * 
			 */
			private static final long serialVersionUID = -1264440101110677L;

			@Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {  
                return false;  
            }
        };
        this.dm.setDataVector(this.fazTabelProduto(), tituloColunas);
        this.tabela.setModel(dm);
        this.trs = new TableRowSorter<DefaultTableModel>(this.dm);
        this.tabela.setRowSorter(trs);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelOla = new javax.swing.JLabel();
        butHistorico = new javax.swing.JButton();
        painelCarrinho = new javax.swing.JPanel();
        labelItensAd = new javax.swing.JLabel();
        labelQtdItensAd = new javax.swing.JLabel();
        labelValorTotal = new javax.swing.JLabel();
        labelValorTotalVariavel = new javax.swing.JLabel();
        butComprar = new javax.swing.JButton();
        butLimpar = new javax.swing.JButton();
        scrollTabela = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        butDetalhesProduto = new javax.swing.JButton();
        butSair = new javax.swing.JButton();
        textFiltrar = new javax.swing.JTextField();
        labFiltrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente");

        butHistorico.setText("Ver Histórico de Compras");
        butHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butHistoricoActionPerformed(evt);
            }
        });

        painelCarrinho.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelItensAd.setText("Itens Adquiridos:");

        labelValorTotal.setText("Valor Total:");

        butComprar.setText("Comprar");
        butComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butComprarActionPerformed(evt);
            }
        });

        butLimpar.setText("Limpar");
        butLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelCarrinhoLayout = new javax.swing.GroupLayout(painelCarrinho);
        painelCarrinho.setLayout(painelCarrinhoLayout);
        painelCarrinhoLayout.setHorizontalGroup(
            painelCarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCarrinhoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelCarrinhoLayout.createSequentialGroup()
                        .addComponent(butComprar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(butLimpar))
                    .addGroup(painelCarrinhoLayout.createSequentialGroup()
                        .addComponent(labelItensAd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelQtdItensAd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(painelCarrinhoLayout.createSequentialGroup()
                        .addComponent(labelValorTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelValorTotalVariavel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        painelCarrinhoLayout.setVerticalGroup(
            painelCarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCarrinhoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelItensAd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelQtdItensAd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelCarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelValorTotalVariavel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(painelCarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butComprar)
                    .addComponent(butLimpar))
                .addContainerGap())
        );

        tabela.setModel(new DefaultTableModel());
        tabela.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollTabela.setViewportView(tabela);

        butDetalhesProduto.setText("Detalhes do Produto");
        butDetalhesProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butDetalhesProdutoActionPerformed(evt);
            }
        });

        butSair.setText("Sair");
        butSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSairActionPerformed(evt);
            }
        });

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(butHistorico)
                                .addGap(18, 18, 18)
                                .addComponent(labFiltrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFiltrar))
                            .addComponent(labelOla, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(butDetalhesProduto)
                            .addComponent(butSair))
                        .addGap(0, 40, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelOla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(butHistorico)
                                    .addComponent(labFiltrar)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(textFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(painelCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(butDetalhesProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(butSair))
                    .addComponent(scrollTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSairActionPerformed
        JanelaPrincipal jp = new JanelaPrincipal();
        jp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_butSairActionPerformed

    private void butDetalhesProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butDetalhesProdutoActionPerformed
        try{
            int produtoSelecionado = (Integer)this.tabela.getValueAt(this.tabela.getSelectedRow(), 0);
            ProdutoVO pVoSelecionado = null;
            for (ProdutoVO produto : this.produtos) {
                if (produtoSelecionado == produto.getCodigoProduto()) {
                    pVoSelecionado = produto;
                }
            }
            DetalheProdutoCliente dp = new DetalheProdutoCliente(pVoSelecionado, JanelaCliente.this);
            dp.setVisible(true);
        } catch(java.lang.IndexOutOfBoundsException ex){
            Logger.getLogger(JanelaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Você deve selecionar um produto primeiro!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_butDetalhesProdutoActionPerformed

    private void butLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLimparActionPerformed
       this.labelQtdItensAd.setText("");
       this.labelValorTotalVariavel.setText("");
       this.valorTotal = 0;
       this.qntComprada = 0;
       this.codProd.clear();
       this.qntProd.clear();
    }//GEN-LAST:event_butLimparActionPerformed

    private void butHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butHistoricoActionPerformed
        Historico h = new Historico(this.codCli);
        h.setVisible(true);
    }//GEN-LAST:event_butHistoricoActionPerformed

    private void butComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butComprarActionPerformed
        ConfirmaCompra cc = new ConfirmaCompra(this.codCli, this.codComp, this.produtos, this.codProd, this.qntProd);
        cc.setVisible(true);
    }//GEN-LAST:event_butComprarActionPerformed

    private void textFiltrarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFiltrarKeyReleased
        RowFilter<DefaultTableModel, Object> regexFilter = RowFilter.regexFilter(this.textFiltrar.getText() + "");
        this.trs.setRowFilter(regexFilter);
    }//GEN-LAST:event_textFiltrarKeyReleased

    private Object[][] fazTabelProduto(){
        Object[][] dados = new Object[this.produtos.size()][3];
        for (int i = 0; i < this.produtos.size(); i++) {
            dados[i][0] = this.produtos.get(i).getCodigoProduto();
            dados[i][1] = this.produtos.get(i).getNomeProduto();
            String valor = ("R$ " + this.produtos.get(i).getValorUnitario() + "0").replace(".", ",");
            dados[i][2] = valor;
        }
        return dados;
    }
    
    public void atualizaCarrinho (String qnt, String valor){
        this.labelQtdItensAd.setText(qnt);
        this.labelValorTotalVariavel.setText(valor);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butComprar;
    private javax.swing.JButton butDetalhesProduto;
    private javax.swing.JButton butHistorico;
    private javax.swing.JButton butLimpar;
    private javax.swing.JButton butSair;
    private javax.swing.JLabel labFiltrar;
    private javax.swing.JLabel labelItensAd;
    private javax.swing.JLabel labelOla;
    private javax.swing.JLabel labelQtdItensAd;
    private javax.swing.JLabel labelValorTotal;
    private javax.swing.JLabel labelValorTotalVariavel;
    private javax.swing.JPanel painelCarrinho;
    private javax.swing.JScrollPane scrollTabela;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField textFiltrar;
    // End of variables declaration//GEN-END:variables

    public void atualizaValorTotal(float valorTotal, int qntProd) {
        this.valorTotal += valorTotal * qntProd;
    }

    public void atualizaValorTotal(float valorTotal) {
        this.valorTotal += valorTotal;
    }
    
    public void atualizaQntComprada(int qntComprada) {
        this.qntComprada += qntComprada;
    }
    
    public void arrayQntCodProd(int codProd, int qntProd){
        this.codProd.add(codProd);
        this.qntProd.add(qntProd);
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public int getQntComprada() {
        return qntComprada;
    }
}
