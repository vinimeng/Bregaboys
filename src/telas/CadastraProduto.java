/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

import dao.FornecedorDAO;
import dao.ProdutoDAO;
import dao.SecaoDAO;
import excecoes.CampoVazioException;
import vo.FornecedorVO;
import vo.ProdutoVO;
import vo.SecaoVO;

/**
 *
 * @author Vinicius Meng
 */
public class CadastraProduto extends javax.swing.JFrame {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 2211634111275059401L;
	private String nome;
    private int codigoProduto, codigoFornecedor, codigoSecao, codigoImagem;
    float valorUnitario;
    private ProdutoDAO c;
    
    @SuppressWarnings("unchecked")
	public CadastraProduto() {
        initComponents();
        this.setLocationRelativeTo(null);
        c = new ProdutoDAO();
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
        this.comboSecao.setModel(this.secCombo());
        this.comboForn.setModel(this.fornCombo());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelCadastrar = new javax.swing.JPanel();
        labelCodigo = new javax.swing.JLabel();
        labelCodigoGerado = new javax.swing.JLabel();
        butGerar = new javax.swing.JButton();
        labelNome = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        butCadastrar = new javax.swing.JButton();
        butLimpar = new javax.swing.JButton();
        labSec = new javax.swing.JLabel();
        comboSecao = new javax.swing.JComboBox();
        labValorUnit = new javax.swing.JLabel();
        textValorUnit = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        comboForn = new javax.swing.JComboBox();
        butImg = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro");

        labelCodigo.setText("C�digo:");

        butGerar.setText("Gerar");
        butGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butGerarActionPerformed(evt);
            }
        });

        labelNome.setText("Nome:");

        butCadastrar.setText("Cadastrar");
        butCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCadastrarActionPerformed(evt);
            }
        });

        butLimpar.setText("Limpar");
        butLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLimparActionPerformed(evt);
            }
        });

        labSec.setText("Se��o:");

        labValorUnit.setText("Valor Unit�rio: R$");

        textValorUnit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textValorUnitKeyTyped(evt);
            }
        });

        jLabel1.setText("Fornecedor:");

        comboForn.setModel(new DefaultComboBoxModel());

        butImg.setText("Adicionar Imagem");
        butImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butImgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelCadastrarLayout = new javax.swing.GroupLayout(painelCadastrar);
        painelCadastrar.setLayout(painelCadastrarLayout);
        painelCadastrarLayout.setHorizontalGroup(
            painelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastrarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCadastrarLayout.createSequentialGroup()
                        .addComponent(butImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(painelCadastrarLayout.createSequentialGroup()
                        .addGroup(painelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCodigo)
                            .addGroup(painelCadastrarLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(labelCodigoGerado, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(butGerar)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(painelCadastrarLayout.createSequentialGroup()
                        .addGroup(painelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelCadastrarLayout.createSequentialGroup()
                                .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(painelCadastrarLayout.createSequentialGroup()
                                .addComponent(labValorUnit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textValorUnit)))
                        .addGap(10, 10, 10))
                    .addGroup(painelCadastrarLayout.createSequentialGroup()
                        .addComponent(labSec)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboSecao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(painelCadastrarLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboForn, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(painelCadastrarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butCadastrar)
                .addContainerGap())
        );
        painelCadastrarLayout.setVerticalGroup(
            painelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastrarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCodigoGerado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butGerar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labValorUnit)
                    .addComponent(textValorUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labSec)
                    .addComponent(comboSecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboForn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butImg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butLimpar)
                    .addComponent(butCadastrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelCadastrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLimparActionPerformed
        this.limparCampos();
    }//GEN-LAST:event_butLimparActionPerformed

    private void butCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCadastrarActionPerformed
        try {
            this.preencheCampo();
            ProdutoVO cVo = new ProdutoVO(codigoFornecedor, codigoProduto, codigoSecao, codigoImagem, nome, valorUnitario);
            c.criarProduto(cVo);
            JOptionPane.showMessageDialog(null, "O produto foi cadastrado com sucesso!", "Confirma��o", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (CampoVazioException ex) {
            Logger.getLogger(CadastraProduto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            this.limparCampos();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CadastraProduto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "N�o foi poss�vel cadastrar o produto!\nNoSuchAlgorithmException", "Erro", JOptionPane.ERROR_MESSAGE);
            this.limparCampos();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CadastraProduto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "N�o foi poss�vel cadastrar o produto!\nUnsupportedEncodingException", "Erro", JOptionPane.ERROR_MESSAGE);
            this.limparCampos();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastraProduto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "N�o foi poss�vel cadastrar o produto!\nClassNotFoundException", "Erro", JOptionPane.ERROR_MESSAGE);
            this.limparCampos();
        } catch (SQLException ex) {
            Logger.getLogger(CadastraProduto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "N�o foi poss�vel cadastrar o produto!\nSQLException", "Erro", JOptionPane.ERROR_MESSAGE);
            this.limparCampos();
        }
    }//GEN-LAST:event_butCadastrarActionPerformed

    private void butGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butGerarActionPerformed
        try {
            int codigo = c.codigoProdutoMax() + 1;
            this.labelCodigoGerado.setText("" + codigo);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastraProduto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "N�o foi poss�vel gerar o c�digo!\nClassNotFoundException", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(CadastraProduto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "N�o foi poss�vel gerar o c�digo!\nSQLException", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_butGerarActionPerformed

    private void textValorUnitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textValorUnitKeyTyped
        String caracteres = "0987654321,";
        if(!caracteres.contains(evt.getKeyChar() + "")){
            evt.consume();
        }
    }//GEN-LAST:event_textValorUnitKeyTyped

    private void butImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butImgActionPerformed
        SalvaImagens s = new SalvaImagens(this);
        s.setVisible(true);
    }//GEN-LAST:event_butImgActionPerformed

    private void limparCampos(){
        this.labelCodigoGerado.setText("");
        this.textNome.setText("");
        this.textValorUnit.setText("");
    }
    
    private void preencheCampo() throws CampoVazioException, NoSuchAlgorithmException, UnsupportedEncodingException, ClassNotFoundException, SQLException {
        if(this.labelCodigoGerado.getText().equals("")
                || this.textNome.getText().equals("")
                || this.textValorUnit.getText().equals("")){
            throw new CampoVazioException();
        }
        else{
            codigoProduto = Integer.parseInt(this.labelCodigoGerado.getText());
            nome = this.textNome.getText();
            valorUnitario = Float.parseFloat(this.textValorUnit.getText().replace(",", "."));
            String[] s = ((String)this.comboForn.getSelectedItem()).split(" ");
            codigoFornecedor = Integer.parseInt(s[0]);
            s = ((String)this.comboSecao.getSelectedItem()).split(" ");
            codigoSecao = Integer.parseInt(s[0]);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butCadastrar;
    private javax.swing.JButton butGerar;
    private javax.swing.JButton butImg;
    private javax.swing.JButton butLimpar;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox comboForn;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox comboSecao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labSec;
    private javax.swing.JLabel labValorUnit;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelCodigoGerado;
    private javax.swing.JLabel labelNome;
    private javax.swing.JPanel painelCadastrar;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textValorUnit;
    // End of variables declaration//GEN-END:variables

    @SuppressWarnings({ "rawtypes", "unchecked" })
	private DefaultComboBoxModel secCombo(){
        SecaoDAO sDao = new SecaoDAO();
        DefaultComboBoxModel ret;
        ArrayList <SecaoVO> lista = null;
        Object [] es = null;
        try {
            lista = sDao.buscarSecaoAll();
            es = new Object [lista.size()];
            for(int j = 0; j < lista.size(); j++){
                es[j] = (String)(lista.get(j).getCodigoSecao() + " - " + lista.get(j).getNomeSecao());
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastraFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        ret = new DefaultComboBoxModel(es);
        return ret; 
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private DefaultComboBoxModel fornCombo(){
        FornecedorDAO sDao = new FornecedorDAO();
        DefaultComboBoxModel ret;
        ArrayList <FornecedorVO> lista = null;
        Object [] es = null;
        try {
            lista = sDao.buscarFornecedorAll();
            es = new Object [lista.size()];
            for(int j = 0; j < lista.size(); j++){
                es[j] = (String)(lista.get(j).getCodigoFornecedor() + " - " + lista.get(j).getNomeFornecedor());
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastraFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        ret = new DefaultComboBoxModel(es);
        return ret; 
    }

    public int getCodigoImagem() {
        return codigoImagem;
    }

    public void setCodigoImagem(int codigoImagem) {
        this.codigoImagem = codigoImagem;
    }

}
