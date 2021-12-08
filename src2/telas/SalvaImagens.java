/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

import util.ConectaBD;

/**
 *
 * @author Vinicius Meng
 */
public class SalvaImagens extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3582555700020362911L;
	private int cod;
    private FileInputStream inputStream;
    private File arquivo;
    private int codigoImagem;
    private JFrame jf;
    
    /**
     * Creates new form SalvaImagens
     */
    
    public SalvaImagens(DetalhesGerenciamento cp) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.jf = cp;
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
        FileNameExtensionFilter filtro =  new FileNameExtensionFilter(".png", "png");
        this.fileChooser.setFileFilter(filtro);
        this.fileChooser.setAcceptAllFileFilterUsed(false);
        try {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT MAX(codigoImagem) FROM Imagem");
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            this.codigoImagem = resultSet.getInt("MAX(codigoImagem)") + 1;
            DetalhesGerenciamento cp2 = (DetalhesGerenciamento) this.jf;
            cp2.setCodigoImagem(this.codigoImagem);
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
    }
    
    public SalvaImagens(CadastraProduto cp) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.jf = cp;
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
        FileNameExtensionFilter filtro =  new FileNameExtensionFilter(".png", "png");
        this.fileChooser.setFileFilter(filtro);
        this.fileChooser.setAcceptAllFileFilterUsed(false);
        try {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT MAX(codigoImagem) FROM Imagem");
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            this.codigoImagem = resultSet.getInt("MAX(codigoImagem)") + 1;
            CadastraProduto cp2 = (CadastraProduto) this.jf;
            cp2.setCodigoImagem(codigoImagem);
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
    }
    
    public SalvaImagens() {
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
        FileNameExtensionFilter filtro =  new FileNameExtensionFilter(".png", "png");
        this.fileChooser.setFileFilter(filtro);
        this.fileChooser.setAcceptAllFileFilterUsed(false);
        try {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT MAX(codigoImagem) FROM Imagem");
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            this.codigoImagem = resultSet.getInt("MAX(codigoImagem)") + 1;
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
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        labInfo = new javax.swing.JLabel();
        butSalvar = new javax.swing.JButton();
        labImagem = new javax.swing.JLabel();
        butAbrir = new javax.swing.JButton();

        fileChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labInfo.setText("Adicione apenas imagens com a extensão .png e com resolução de 75 x125");

        butSalvar.setText("Salvar imagem");
        butSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSalvarActionPerformed(evt);
            }
        });

        butAbrir.setText("Abrir Imagem");
        butAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAbrirActionPerformed(evt);
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
                        .addComponent(labInfo)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(butSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(butAbrir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(butAbrir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butSalvar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSalvarActionPerformed
        if(cod == JFileChooser.APPROVE_OPTION){
            this.SalvaImagem();
            this.dispose();
        }
    }//GEN-LAST:event_butSalvarActionPerformed

    private void butAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAbrirActionPerformed
        this.cod = this.fileChooser.showOpenDialog(this);
        String foto = "" + fileChooser.getSelectedFile().getPath();
        this.labImagem.setIcon((new ImageIcon(foto)));
        this.arquivo = this.fileChooser.getSelectedFile();
        try {
            this.inputStream = new FileInputStream(arquivo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SalvaImagens.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível abrir a imagem!\nFileNotFoundException", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_butAbrirActionPerformed

    private void SalvaImagem(){
        try{
            Connection connection = ConectaBD.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Imagem "
            + "(codigoImagem, nomeImagem, imagem) "
            + "VALUES(?,?,?)");
            pstmt.setInt(1,this.codigoImagem);
            pstmt.setString(2, this.arquivo.getName());
            pstmt.setBinaryStream(3,inputStream,(int)this.arquivo.length());
            pstmt.executeUpdate();
            pstmt.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Imagem salva com sucesso", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(SalvaImagens.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível salvar a imagem!\nSQLException", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SalvaImagens.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível salvar a imagem!\nClassNotFoundException", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAbrir;
    private javax.swing.JButton butSalvar;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel labImagem;
    private javax.swing.JLabel labInfo;
    // End of variables declaration//GEN-END:variables
}
