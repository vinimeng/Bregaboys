/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.CategoriaSalarioDAO;
import dao.EnderecoDAO;
import dao.FornecedorDAO;
import dao.SecaoDAO;
import excecoes.CampoVazioException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import vo.CategoriaSalarioVO;
import vo.EnderecoVO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import vo.FornecedorVO;
import vo.SecaoVO;

/**
 *
 * @author Vinicius Meng
 */
public class CadastraCategoriaSalario extends javax.swing.JFrame {
    
    private int codigoCategoriaSalario;
    float valorCategoriaSalario;
    private CategoriaSalarioDAO c;
    
    public CadastraCategoriaSalario() {
        initComponents();
        this.setLocationRelativeTo(null);
        c = new CategoriaSalarioDAO();
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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelCadastrar = new javax.swing.JPanel();
        labelCodigo = new javax.swing.JLabel();
        labelCodigoGerado = new javax.swing.JLabel();
        butGerar = new javax.swing.JButton();
        butCadastrar = new javax.swing.JButton();
        butLimpar = new javax.swing.JButton();
        labValorUnit = new javax.swing.JLabel();
        textValorUnit = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro");

        labelCodigo.setText("Código:");

        butGerar.setText("Gerar");
        butGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butGerarActionPerformed(evt);
            }
        });

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

        labValorUnit.setText("Valor: R$");

        textValorUnit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textValorUnitKeyTyped(evt);
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
                        .addGroup(painelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCodigo)
                            .addGroup(painelCadastrarLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(labelCodigoGerado, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(butGerar)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painelCadastrarLayout.createSequentialGroup()
                        .addComponent(labValorUnit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelCadastrarLayout.createSequentialGroup()
                                .addComponent(butLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(butCadastrar))
                            .addComponent(textValorUnit))))
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
                    .addComponent(labValorUnit)
                    .addComponent(textValorUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(painelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butLimpar)
                    .addComponent(butCadastrar)))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painelCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLimparActionPerformed
        this.limparCampos();
    }//GEN-LAST:event_butLimparActionPerformed

    private void butCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCadastrarActionPerformed
        try {
            this.preencheCampo();
            CategoriaSalarioVO cVo = new CategoriaSalarioVO(codigoCategoriaSalario, valorCategoriaSalario);
            c.criarCategoriaSalario(cVo);
            JOptionPane.showMessageDialog(null, "A categoria de salário foi cadastrado com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (CampoVazioException ex) {
            Logger.getLogger(CadastraCategoriaSalario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            this.limparCampos();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CadastraCategoriaSalario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a categoria de salário!\nNoSuchAlgorithmException", "Erro", JOptionPane.ERROR_MESSAGE);
            this.limparCampos();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CadastraCategoriaSalario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a categoria de salário!\nUnsupportedEncodingException", "Erro", JOptionPane.ERROR_MESSAGE);
            this.limparCampos();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastraCategoriaSalario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a categoria de salário!\nClassNotFoundException", "Erro", JOptionPane.ERROR_MESSAGE);
            this.limparCampos();
        } catch (SQLException ex) {
            Logger.getLogger(CadastraCategoriaSalario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a categoria de salário!\nSQLException", "Erro", JOptionPane.ERROR_MESSAGE);
            this.limparCampos();
        }
    }//GEN-LAST:event_butCadastrarActionPerformed

    private void butGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butGerarActionPerformed
        try {
            int codigo = c.codigoCategoriaSalarioMax() + 1;
            this.labelCodigoGerado.setText("" + codigo);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastraCategoriaSalario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível gerar o código!\nClassNotFoundException", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(CadastraCategoriaSalario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível gerar o código!\nSQLException", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_butGerarActionPerformed

    private void textValorUnitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textValorUnitKeyTyped
        String caracteres = "0987654321,";
        if(!caracteres.contains(evt.getKeyChar() + "")){
            evt.consume();
        }
    }//GEN-LAST:event_textValorUnitKeyTyped

    private void limparCampos(){
        this.labelCodigoGerado.setText("");
        this.textValorUnit.setText("");
    }
    
    private void preencheCampo() throws CampoVazioException, NoSuchAlgorithmException, UnsupportedEncodingException, ClassNotFoundException, SQLException {
        if(this.labelCodigoGerado.getText().equals("")
                || this.textValorUnit.getText().equals("")){
            throw new CampoVazioException();
        }
        else{
            codigoCategoriaSalario = Integer.parseInt(this.labelCodigoGerado.getText());
            valorCategoriaSalario = Float.parseFloat(this.textValorUnit.getText().replace(",", "."));
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butCadastrar;
    private javax.swing.JButton butGerar;
    private javax.swing.JButton butLimpar;
    private javax.swing.JLabel labValorUnit;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelCodigoGerado;
    private javax.swing.JPanel painelCadastrar;
    private javax.swing.JTextField textValorUnit;
    // End of variables declaration//GEN-END:variables


}
