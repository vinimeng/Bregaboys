/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.ConectaBD;
import vo.*;

/**
 *
 * @author Thiago
 */
public class DetalhesGerenciamento extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7638695571266646604L;
	private ClienteVO clvo;
    private FuncionarioVO fuvo;
    private ProdutoVO prvo;
    private TransportadoraVO trvo;
    private CategoriaSalarioVO csvo;
    private FornecedorVO fovo;
    private SecaoVO sevo;
    private ImagemVO ivo;
    private int quale;
    private ClienteDAO cldao;
    private EnderecoDAO eddao;
    private FuncionarioDAO fudao;
    private ProdutoDAO prdao;
    private TransportadoraDAO trdao;
    private CategoriaSalarioDAO csdao;
    private FornecedorDAO fodao;
    private SecaoDAO sedao;
    private int codImg;
    
   
    
    public DetalhesGerenciamento(ClienteVO vo) throws SQLException, ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.cldao = new ClienteDAO();
        this.eddao = new EnderecoDAO();
        this.clvo = vo;
        EnderecoVO evo = new EnderecoDAO().buscarEndereco(new EnderecoVO("","",vo.getCodigoEndereco(),"",1,"",""));
        this.campo1.setText(vo.getCodigoCliente() + "");this.campo1.setEnabled(false);this.campo1.setVisible(true);
        this.campo2.setText(vo.getNomeCliente());this.campo2.setEnabled(true);this.campo2.setVisible(true);
        this.campo3.setText(vo.getEmailCliente());this.campo3.setEnabled(true);this.campo3.setVisible(true);
        this.campo4.setText(vo.getTelefoneCliente());this.campo4.setEnabled(true);this.campo4.setVisible(true);
        this.campo5.setEnabled(false);this.campo5.setVisible(false);
        this.label5.setVisible(false);
        this.campoNumero.setText(evo.getNumeroCasa()+"");this.campoNumero.setEnabled(true);this.campoNumero.setVisible(true);
        this.campoRua.setText(evo.getRua()+"");this.campoRua.setEnabled(true);this.campoRua.setVisible(true);
        this.campoBairro.setText(evo.getBairro()+"");this.campoBairro.setEnabled(true);this.campoBairro.setVisible(true);
        this.campoCidade.setText(evo.getCidade()+"");this.campoCidade.setEnabled(true);this.campoCidade.setVisible(true);
        this.campoEstado.setText(evo.getEstado()+"");this.campoEstado.setEnabled(true);this.campoEstado.setVisible(true);
        this.campoPais.setText(evo.getPais()+"");this.campoPais.setEnabled(true);this.campoPais.setVisible(true);
        this.campo6.setVisible(false);
        this.campo7.setVisible(false);
        this.quale = 1;
        this.butIMG.setVisible(false);
    }
    
    public DetalhesGerenciamento(FuncionarioVO vo) throws SQLException, ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.fudao = new FuncionarioDAO();
        this.eddao = new EnderecoDAO();
        this.fuvo = vo;
        EnderecoVO evo = new EnderecoDAO().buscarEndereco(new EnderecoVO("","",vo.getCodigoEndereco(),"",1,"",""));
        this.campo1.setText(vo.getCodigoFuncionario()+ "");this.campo1.setEnabled(false);this.campo1.setVisible(true);
        this.campo2.setText(vo.getNomeFuncionario());this.campo2.setEnabled(true);this.campo2.setVisible(true);
        this.campo3.setText(vo.getEmailFuncionario());this.campo3.setEnabled(true);this.campo3.setVisible(true);
        this.campo4.setText(vo.getTelefoneFuncionario());this.campo4.setEnabled(true);this.campo4.setVisible(true);
        this.campo5.setEnabled(true);this.campo5.setVisible(true);this.label5.setVisible(true);this.label5.setText("Seção:");
        this.campo5.setText(vo.getCodigoSecao()+"");
        this.campo6.setEnabled(true);this.campo6.setVisible(true);this.label6.setText("Categoria Salario:");this.campo6.setText(vo.getCodigoCategoriaSalario()+"");
        this.campoNumero.setText(evo.getNumeroCasa()+"");this.campoNumero.setEnabled(true);this.campoNumero.setVisible(true);
        this.campoRua.setText(evo.getRua()+"");this.campoRua.setEnabled(true);this.campoRua.setVisible(true);
        this.campoBairro.setText(evo.getBairro()+"");this.campoBairro.setEnabled(true);this.campoBairro.setVisible(true);
        this.campoCidade.setText(evo.getCidade()+"");this.campoCidade.setEnabled(true);this.campoCidade.setVisible(true);
        this.campoEstado.setText(evo.getEstado()+"");this.campoEstado.setEnabled(true);this.campoEstado.setVisible(true);
        this.campoPais.setText(evo.getPais()+"");this.campoPais.setEnabled(true);this.campoPais.setVisible(true);
        this.campo7.setVisible(true); this.label7.setText("Gerente:");this.campo7.setEnabled(true);this.campo7.setText(vo.getCodigoGerente()+"");
        this.quale = 2;
        this.butIMG.setVisible(false);
    }
    
    public DetalhesGerenciamento(ProdutoVO vo) throws SQLException, ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.prdao = new ProdutoDAO();
        this.eddao = new EnderecoDAO();
        this.setSize(250, 267);
        this.prvo = vo;
        this.codImg = this.prvo.getCodigoImagem();
        this.label3.setText("Fornecedor:");
        this.label4.setText("Seção:");
        this.label5.setText("Preço: R$");
        this.campo1.setText(vo.getCodigoProduto() + "");this.campo1.setEnabled(false);this.campo1.setVisible(true);
        this.campo2.setText(vo.getNomeProduto());this.campo2.setEnabled(true);this.campo2.setVisible(true);
        this.campo3.setText(vo.getCodigoFornecedor()+"");this.campo3.setEnabled(true);this.campo3.setVisible(true);
        this.campo4.setText(vo.getCodigoSecao()+"");this.campo4.setEnabled(true);this.campo4.setVisible(true);
        this.campo5.setText((vo.getValorUnitario() + "0").replace(".", ","));this.campo5.setVisible(true);
        this.numero.setVisible(false);
        this.rua.setVisible(false);
        this.bairro.setVisible(false);
        this.cidade.setVisible(false);
        this.estado.setVisible(false);
        this.pais.setVisible(false);
        this.campoNumero.setVisible(false);
        this.campoRua.setVisible(false);
        this.campoBairro.setVisible(false);
        this.campoCidade.setVisible(false);
        this.campoEstado.setVisible(false);
        this.campoPais.setVisible(false);
        this.campo6.setVisible(false);
        this.campo7.setVisible(false);
        this.quale = 3;
    }
    
    public DetalhesGerenciamento(TransportadoraVO vo) throws SQLException, ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.trdao = new TransportadoraDAO();
        this.eddao = new EnderecoDAO();
        this.trvo = vo;
        EnderecoVO evo = new EnderecoDAO().buscarEndereco(new EnderecoVO("","",vo.getCodigoEndereco(),"",1,"",""));
        this.campo1.setText(vo.getCodigoTransportadora() + "");this.campo1.setEnabled(false);this.campo1.setVisible(true);
        this.campo2.setText(vo.getNomeTransportadora());this.campo2.setEnabled(true);this.campo2.setVisible(true);
        this.campo3.setText(vo.getEmailTransportadora());this.campo3.setEnabled(true);this.campo3.setVisible(true);
        this.campo4.setText(vo.getTelefoneTransportadora());this.campo4.setEnabled(true);this.campo4.setVisible(true);
        this.label5.setVisible(false);this.campo5.setVisible(false);
        this.campoNumero.setText(evo.getNumeroCasa()+"");this.campoNumero.setEnabled(true);this.campoNumero.setVisible(true);
        this.campoRua.setText(evo.getRua());this.campoRua.setEnabled(true);this.campoRua.setVisible(true);
        this.campoBairro.setText(evo.getBairro()+"");this.campoBairro.setEnabled(true);this.campoBairro.setVisible(true);
        this.campoCidade.setText(evo.getCidade()+"");this.campoCidade.setEnabled(true);this.campoCidade.setVisible(true);
        this.campoEstado.setText(evo.getEstado()+"");this.campoEstado.setEnabled(true);this.campoEstado.setVisible(true);
        this.campoPais.setText(evo.getPais()+"");this.campoPais.setEnabled(true);this.campoPais.setVisible(true);
        this.campo6.setVisible(false);
        this.campo7.setVisible(false);
        this.quale = 4;
        this.butIMG.setVisible(false);
    }
    
    public DetalhesGerenciamento(CategoriaSalarioVO vo) throws SQLException, ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(250, 267);
        this.csdao = new CategoriaSalarioDAO();
        this.eddao = new EnderecoDAO();
        this.csvo = vo;        
        this.campo1.setText(vo.getCodigoCategoriaSalario() + "");this.campo1.setEnabled(false);this.campo1.setVisible(true);
        this.label2.setVisible(false);this.campo2.setVisible(false);
        this.label3.setVisible(false);this.campo3.setVisible(false);
        this.campo4.setText((vo.getValorCategoriaSalario()+ "0").replace(",", "."));this.campo4.setEnabled(true);
        this.campo4.setVisible(true); this.label4.setText("Valor:");
        this.label5.setVisible(false);this.campo5.setVisible(false);
        this.numero.setVisible(false);
        this.rua.setVisible(false);
        this.bairro.setVisible(false);
        this.cidade.setVisible(false);
        this.estado.setVisible(false);
        this.pais.setVisible(false);
        this.campoNumero.setVisible(false);
        this.campoRua.setVisible(false);
        this.campoBairro.setVisible(false);
        this.campoCidade.setVisible(false);
        this.campoEstado.setVisible(false);
        this.campoPais.setVisible(false);
        this.campo6.setVisible(false);
        this.campo7.setVisible(false);
        this.quale = 5;
        this.butIMG.setVisible(false);
    }
    
    public DetalhesGerenciamento(FornecedorVO vo) throws SQLException, ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.fodao = new FornecedorDAO();
        this.eddao = new EnderecoDAO();
        this.fovo = vo;
        EnderecoVO evo = new EnderecoDAO().buscarEndereco(new EnderecoVO("","",vo.getCodigoEndereco(),"",1,"",""));
        this.campo1.setText(vo.getCodigoFornecedor() + "");this.campo1.setEnabled(false);this.campo1.setVisible(true);
        this.campo2.setText(vo.getNomeFornecedor());this.campo2.setEnabled(true);this.campo2.setVisible(true);
        this.campo3.setText(vo.getEmailFornecedor());this.campo3.setEnabled(true);this.campo3.setVisible(true);
        this.campo4.setText(vo.getTelefoneFornecedor());this.campo4.setEnabled(true);this.campo4.setVisible(true);
        this.label5.setVisible(false);this.campo5.setVisible(false);
        this.campoNumero.setText(evo.getNumeroCasa()+"");this.campoNumero.setEnabled(true);this.campoNumero.setVisible(true);
        this.campoRua.setText(evo.getRua()+"");this.campoRua.setEnabled(true);this.campoRua.setVisible(true);
        this.campoBairro.setText(evo.getBairro()+"");this.campoBairro.setEnabled(true);this.campoBairro.setVisible(true);
        this.campoCidade.setText(evo.getCidade()+"");this.campoCidade.setEnabled(true);this.campoCidade.setVisible(true);
        this.campoEstado.setText(evo.getEstado()+"");this.campoEstado.setEnabled(true);this.campoEstado.setVisible(true);
        this.campoPais.setText(evo.getPais()+"");this.campoPais.setEnabled(true);this.campoPais.setVisible(true);
        this.campo6.setVisible(false);
        this.campo7.setVisible(false);
        this.quale = 6;
        this.butIMG.setVisible(false);
    }
    
    public DetalhesGerenciamento(SecaoVO vo) throws SQLException, ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.sedao = new SecaoDAO();
        this.eddao = new EnderecoDAO();
        this.sevo = vo;
        this.setSize(250, 267);
        this.campo4.setText("Nome:");
        this.campo1.setText(vo.getCodigoSecao() + "");this.campo1.setEnabled(false);this.campo1.setVisible(true);
        this.label2.setVisible(false);this.campo2.setVisible(false);
        this.label3.setVisible(false);this.campo3.setVisible(false);
        this.campo4.setText("" + vo.getNomeSecao());this.campo4.setEnabled(true);this.campo4.setVisible(true);this.label4.setText("Nome:");
        this.label5.setVisible(false);this.campo5.setVisible(false);
        this.numero.setVisible(false);
        this.rua.setVisible(false);
        this.bairro.setVisible(false);
        this.cidade.setVisible(false);
        this.estado.setVisible(false);
        this.pais.setVisible(false);
        this.campoNumero.setVisible(false);
        this.campoRua.setVisible(false);
        this.campoBairro.setVisible(false);
        this.campoCidade.setVisible(false);
        this.campoEstado.setVisible(false);
        this.campoPais.setVisible(false);
        this.campo6.setVisible(false);
        this.campo7.setVisible(false);
        this.quale = 7;
        this.butIMG.setVisible(false);
    }
    
    public DetalhesGerenciamento(ImagemVO vo) throws SQLException, ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.sedao = new SecaoDAO();
        this.eddao = new EnderecoDAO();
        this.ivo = vo;
        this.setSize(250, 267);
        this.campo4.setText("Nome:");
        this.campo1.setText(vo.getCodigoImagem()+ "");this.campo1.setEnabled(false);this.campo1.setVisible(true);
        this.label2.setVisible(false);this.campo2.setVisible(false);
        this.label3.setVisible(false);this.campo3.setVisible(false);
        this.campo4.setText("" + vo.getNomeImagem());this.campo4.setEnabled(true);this.campo4.setVisible(true);this.label4.setText("Nome:");
        this.label5.setVisible(false);this.campo5.setVisible(false);
        this.numero.setVisible(false);
        this.rua.setVisible(false);
        this.bairro.setVisible(false);
        this.cidade.setVisible(false);
        this.estado.setVisible(false);
        this.pais.setVisible(false);
        this.campoNumero.setVisible(false);
        this.campoRua.setVisible(false);
        this.campoBairro.setVisible(false);
        this.campoCidade.setVisible(false);
        this.campoEstado.setVisible(false);
        this.campoPais.setVisible(false);
        this.campo6.setVisible(false);
        this.campo7.setVisible(false);
        this.quale = 8;
        this.butIMG.setVisible(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        campo1 = new javax.swing.JTextField();
        campo2 = new javax.swing.JTextField();
        campo3 = new javax.swing.JTextField();
        campo4 = new javax.swing.JTextField();
        campo5 = new javax.swing.JTextField();
        campo6 = new javax.swing.JTextField();
        campo7 = new javax.swing.JTextField();
        cancelar = new javax.swing.JButton();
        salvar = new javax.swing.JButton();
        numero = new javax.swing.JLabel();
        rua = new javax.swing.JLabel();
        bairro = new javax.swing.JLabel();
        cidade = new javax.swing.JLabel();
        estado = new javax.swing.JLabel();
        pais = new javax.swing.JLabel();
        campoNumero = new javax.swing.JTextField();
        campoRua = new javax.swing.JTextField();
        campoBairro = new javax.swing.JTextField();
        campoCidade = new javax.swing.JTextField();
        campoEstado = new javax.swing.JTextField();
        campoPais = new javax.swing.JTextField();
        butIMG = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        label1.setText("Código:");

        label2.setText("Nome:");

        label3.setText("E-mail:");

        label4.setText("Telefone:");

        label5.setText("Senha:");

        campo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo1ActionPerformed(evt);
            }
        });

        campo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo3ActionPerformed(evt);
            }
        });

        campo5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo5ActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.setMaximumSize(new java.awt.Dimension(75, 50));
        cancelar.setMinimumSize(new java.awt.Dimension(75, 20));
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        salvar.setText("Salvar");
        salvar.setMaximumSize(new java.awt.Dimension(75, 50));
        salvar.setMinimumSize(new java.awt.Dimension(75, 20));
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        numero.setText("Número:");

        rua.setText("Rua:");

        bairro.setText("Bairro:");

        cidade.setText("Cidade:");

        estado.setText("Estado:");

        pais.setText("País:");

        butIMG.setText("Alterar Imagem");
        butIMG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butIMGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(label6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label4, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(label5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label7, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campo7)
                            .addComponent(campo6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campo1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(campo2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(campo3, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(campo4, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(campo5, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cidade)
                            .addComponent(bairro)
                            .addComponent(rua))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoBairro, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(campoRua, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(campoCidade)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(numero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(estado)
                            .addComponent(pais))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(campoPais))))
                .addGap(58, 58, 58))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(butIMG)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label1)
                    .addComponent(campo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numero)
                    .addComponent(campoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rua, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoRua, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label3)
                    .addComponent(campo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bairro)
                    .addComponent(campoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label4)
                    .addComponent(campo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cidade)
                    .addComponent(campoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label5)
                    .addComponent(campo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estado)
                    .addComponent(campoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pais)
                    .addComponent(campoPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campo7)
                    .addComponent(label7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butIMG)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        campoCidade.getAccessibleContext().setAccessibleName("75");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo1ActionPerformed

    private void campo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo3ActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void campo5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo5ActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        switch(this.quale){
            case 1:
                try {
                        EnderecoVO eVo = new EnderecoVO(this.campoBairro.getText(), this.campoCidade.getText() , this.clvo.getCodigoEndereco(), this.campoEstado.getText(), Integer.parseInt(this.campoNumero.getText()), this.campoPais.getText(), this.campoRua.getText());
                        ClienteVO cVo = new ClienteVO(this.clvo.getCodigoCliente(), this.clvo.getCodigoEndereco(), this.clvo.getSenhaCliente(), this.campo3.getText(), this.campo2.getText(), this.campo4.getText());
                        this.eddao.alterarEndereco(eVo);
                        this.cldao.alterarCliente(cVo);
                        JOptionPane.showMessageDialog(null, "O cliente foi recadastrado com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    } catch (ClassNotFoundException ex) {
                       Logger.getLogger(DetalhesGerenciamento.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Não foi possível recadastrar o cliente!\nClassNotFoundException", "Erro", JOptionPane.ERROR_MESSAGE);
                    } catch (SQLException ex) {
                        Logger.getLogger(DetalhesGerenciamento.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Não foi possível recadastrar o cliente!\nSQLException", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                break;
            case 2:
                try {
                        EnderecoVO eVo = new EnderecoVO(this.campoBairro.getText(), this.campoCidade.getText() , this.fuvo.getCodigoEndereco(), this.campoEstado.getText(), Integer.parseInt(this.campoNumero.getText()), this.campoPais.getText(), this.campoRua.getText());
                        FuncionarioVO fvo = new FuncionarioVO(Integer.parseInt(this.campo6.getText()), this.fuvo.getCodigoEndereco(), this.fuvo.getCodigoFuncionario(), Integer.parseInt(this.campo7.getText()), Integer.parseInt(this.campo5.getText()), this.fuvo.getSenhaFuncionario(), this.campo3.getText(), this.campo2.getText(), this.campo4.getText());
                        this.eddao.alterarEndereco(eVo);
                        this.fudao.alterarFuncionario(fvo);
                        JOptionPane.showMessageDialog(null, "O funcionário foi recadastrado com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(DetalhesGerenciamento.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Não foi possível recadastrar o funcionário!\nClassNotFoundException", "Erro", JOptionPane.ERROR_MESSAGE);
                    } catch (SQLException ex) {
                        Logger.getLogger(DetalhesGerenciamento.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Não foi possível recadastrar o funcionário!\nSQLException", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                break;
            case 3:
                try {
                        ProdutoVO pvo = new ProdutoVO(Integer.parseInt(this.campo3.getText()), this.getPrvo().getCodigoProduto(), Integer.parseInt(this.campo4.getText()), this.codImg, this.campo2.getText(), Float.parseFloat(this.campo5.getText().replace(",", ".")));
                        this.prdao.alterarProduto(pvo);
                        JOptionPane.showMessageDialog(null, "O produto foi recadastrado com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(DetalhesGerenciamento.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Não foi possível recadastrar o produto!\nClassNotFoundException", "Erro", JOptionPane.ERROR_MESSAGE);
                    } catch (SQLException ex) {
                        Logger.getLogger(DetalhesGerenciamento.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Não foi possível recadastrar o produto!\nSQLException", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                break;
            case 4:
                    try{
                        EnderecoVO eVo = new EnderecoVO(this.campoBairro.getText(), this.campoCidade.getText() , this.trvo.getCodigoEndereco(), this.campoEstado.getText(), Integer.parseInt(this.campoNumero.getText()), this.campoPais.getText(), this.campoRua.getText());
                        TransportadoraVO trVo = new TransportadoraVO(this.trvo.getCodigoEndereco(), this.trvo.getCodigoTransportadora(), this.campo3.getText(), this.campo2.getText(), this.campo4.getText());
                        this.eddao.alterarEndereco(eVo);
                        this.trdao.alterarTransportadora(trVo);
                        JOptionPane.showMessageDialog(null, "A transportadora foi recadastrado com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(DetalhesGerenciamento.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Não foi possível recadastrar a transportadora!\nClassNotFoundException", "Erro", JOptionPane.ERROR_MESSAGE);
                    } catch (SQLException ex) {
                        Logger.getLogger(DetalhesGerenciamento.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Não foi possível recadastrar a transportadora!\nSQLException", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                break;
            case 5:
                try{
                        CategoriaSalarioVO CSvo = new CategoriaSalarioVO(this.csvo.getCodigoCategoriaSalario(), Float.parseFloat(this.campo4.getText()));
                        this.csdao.alterarCategoriaSalario(CSvo);
                        JOptionPane.showMessageDialog(null, "A categoria de salário foi recadastrado com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(DetalhesGerenciamento.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Não foi possível recadastrar a categoria de salário!\nClassNotFoundException", "Erro", JOptionPane.ERROR_MESSAGE);
                    } catch (SQLException ex) {
                        Logger.getLogger(DetalhesGerenciamento.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Não foi possível recadastrar a categoria de salário!\nSQLException", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                break;
            case 6:
                try{
                        EnderecoVO eVo = new EnderecoVO(this.campoBairro.getText(), this.campoCidade.getText() , this.fovo.getCodigoEndereco(), this.campoEstado.getText(), Integer.parseInt(this.campoNumero.getText()), this.campoPais.getText(), this.campoRua.getText());
                        FornecedorVO foVo = new FornecedorVO(this.fovo.getCodigoEndereco(), this.fovo.getCodigoFornecedor(), this.campo3.getText(), this.campo2.getText(), this.campo4.getText());
                        this.eddao.alterarEndereco(eVo);
                        this.fodao.alterarFornecedor(foVo);
                        JOptionPane.showMessageDialog(null, "O fornecedor foi recadastrado com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(DetalhesGerenciamento.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Não foi possível recadastrar o fornecedor!\nClassNotFoundException", "Erro", JOptionPane.ERROR_MESSAGE);
                    } catch (SQLException ex) {
                        Logger.getLogger(DetalhesGerenciamento.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Não foi possível recadastrar o fornecedor!\nSQLException", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                break;
            case 7:
                try{
                        SecaoVO svo = new SecaoVO(this.sevo.getCodigoSecao(), this.campo4.getText());
                        this.sedao.alterarSecao(svo);
                        JOptionPane.showMessageDialog(null, "A seção foi recadastrado com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(DetalhesGerenciamento.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Não foi possível recadastrar o fornecedor!\nClassNotFoundException", "Erro", JOptionPane.ERROR_MESSAGE);
                    } catch (SQLException ex) {
                        Logger.getLogger(DetalhesGerenciamento.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Não foi possível recadastrar o fornecedor!\nSQLException", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                break;
            case 8:
                try{
                        ImagemVO ivo = new ImagemVO(this.ivo.getCodigoImagem(), this.campo4.getText());
                        Connection connection = ConectaBD.getConnection();
                        PreparedStatement statement = connection.prepareStatement("UPDATE Imagem SET codigoImagem = ?, nomeImagem = ? " + "WHERE codigoImagem = ?");
                        statement.setInt(1, ivo.getCodigoImagem());
                        statement.setString(2, ivo.getNomeImagem());
                        statement.setInt(3, ivo.getCodigoImagem());
                        statement.executeUpdate();
                        statement.close();
                        connection.close();
                        JOptionPane.showMessageDialog(null, "A imagem foi recadastrado com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(DetalhesGerenciamento.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Não foi possível recadastrar o fornecedor!\nClassNotFoundException", "Erro", JOptionPane.ERROR_MESSAGE);
                    } catch (SQLException ex) {
                        Logger.getLogger(DetalhesGerenciamento.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Não foi possível recadastrar o fornecedor!\nSQLException", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
        }
    }//GEN-LAST:event_salvarActionPerformed

    public void setCodigoImagem(int i){
        this.codImg = i;
    }
    
    private void butIMGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butIMGActionPerformed
        SalvaImagens s = new SalvaImagens(this);
        s.setVisible(true);
    }//GEN-LAST:event_butIMGActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bairro;
    private javax.swing.JButton butIMG;
    private javax.swing.JTextField campo1;
    private javax.swing.JTextField campo2;
    private javax.swing.JTextField campo3;
    private javax.swing.JTextField campo4;
    private javax.swing.JTextField campo5;
    private javax.swing.JTextField campo6;
    private javax.swing.JTextField campo7;
    private javax.swing.JTextField campoBairro;
    private javax.swing.JTextField campoCidade;
    private javax.swing.JTextField campoEstado;
    private javax.swing.JTextField campoNumero;
    private javax.swing.JTextField campoPais;
    private javax.swing.JTextField campoRua;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel cidade;
    private javax.swing.JLabel estado;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel numero;
    private javax.swing.JLabel pais;
    private javax.swing.JLabel rua;
    private javax.swing.JButton salvar;
    // End of variables declaration//GEN-END:variables

    public ProdutoVO getPrvo() {
        return prvo;
    }
}
