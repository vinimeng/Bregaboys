package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import telas.Historico;
import util.ConectaBD;

/**
 *
 * @author Vinicius Meng
 */
public class TabelaHistorico {
    private static final String HISTORICO = "SELECT codigoCliente, codigoCompra, codigoProduto, codigoTransportadora, nomeProduto, valorUnitario, quantidadeProduto FROM CompraProduto NATURAL JOIN Compra NATURAL JOIN Produto NATURAL JOIN Cliente "
                                            + "WHERE codigoCliente = ?";

    public static String getHISTORICO() {
        return HISTORICO;
    }
    private int codigoCliente;
    private int codigoCompra;
    private int codigoProduto;
    private int codigoTransportadora;
    private String nomeProduto;
    private float valorUnitario;
    private int quantidadeProduto;
    private ArrayList <TabelaHistorico> dados;
    
    public TabelaHistorico(int codigoCliente, int codigoCompra, int codigoProduto, int codigoTransportadora, String nomeProduto, float valorUnitario, int quantidadeProduto){
        this.codigoCliente = codigoCliente;
        this.codigoCompra = codigoCompra;
        this.codigoProduto = codigoProduto;
        this.codigoTransportadora = codigoTransportadora;
        this.nomeProduto = nomeProduto;
        this.valorUnitario = valorUnitario;
        this.quantidadeProduto = quantidadeProduto;
    }
    
    public TabelaHistorico(int codigoCliente){
        this.dados = new ArrayList<TabelaHistorico>();
        Connection connection;
        try {
            connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(HISTORICO);
            statement.setInt(1, codigoCliente);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                TabelaHistorico th = new TabelaHistorico(resultSet.getInt("codigoCliente"),
                                     resultSet.getInt("codigoCompra"),
                                     resultSet.getInt("codigoProduto"),
                                     resultSet.getInt("codigoTransportadora"),
                                     resultSet.getString("nomeProduto"),
                                     resultSet.getFloat("valorUnitario"),
                                     resultSet.getInt("quantidadeProduto"));
                this.dados.add(th);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Historico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Object [][] fazTabelHist (){
        int auxCodCom = -1;
        Object [][] dadosT = new Object[this.dados.size()][9];
        for(int i = 0; i < this.dados.size(); i++){
            if(auxCodCom != this.dados.get(i).codigoCompra){
                auxCodCom = this.dados.get(i).codigoCompra;
                dadosT[i][0] = this.dados.get(i).codigoCliente;
                dadosT[i][1] = this.dados.get(i).codigoCompra;
                dadosT[i][2] = this.dados.get(i).codigoTransportadora;
                dadosT[i][3] = this.dados.get(i).codigoProduto;
                dadosT[i][4] = this.dados.get(i).nomeProduto;
                dadosT[i][5] = this.dados.get(i).quantidadeProduto;
                dadosT[i][6] = ("R$ " + this.dados.get(i).valorUnitario + "0").replace(".", ",");
                dadosT[i][7] = this.dados.get(i).qntTotalCom(this.dados, auxCodCom);
                dadosT[i][8] = ("R$ " + this.valorTotalCom(this.dados, auxCodCom) + "0").replace(".", ",");
            }
            else{
                dadosT[i][0] = "";
                dadosT[i][1] = "";
                dadosT[i][2] = "";
                dadosT[i][3] = this.dados.get(i).codigoProduto;
                dadosT[i][4] = this.dados.get(i).nomeProduto;
                dadosT[i][5] = this.dados.get(i).quantidadeProduto;
                dadosT[i][6] = ("R$ " + this.dados.get(i).valorUnitario + "0").replace(".", ",");
                dadosT[i][7] = "";
                dadosT[i][8] = "";
            }
        }  
        return dadosT;
    }
    
    private float valorTotalCom(ArrayList <TabelaHistorico> dados, int codigoCompra){
        float res = 0;
        for (TabelaHistorico dado : dados) {
            if(dado.codigoCompra == codigoCompra){
                res += (dado.valorUnitario) * (dado.quantidadeProduto);
            }
        }
        return res;
    }
    
    private int qntTotalCom(ArrayList <TabelaHistorico> dados, int codigoCompra){
        int res = 0;
        for (TabelaHistorico dado : dados) {
            if(dado.codigoCompra == codigoCompra){
                res += dado.quantidadeProduto;
            }
        }
        return res;
    }
    
    @SuppressWarnings("unused")
	private int auxTabela(ArrayList <TabelaHistorico> a){
        int auxCodCom = -1;
        int res = 0;
        for(int i = 0; i < this.dados.size(); i++){
            if(auxCodCom != this.dados.get(i).codigoCompra){
                auxCodCom = this.dados.get(i).codigoCompra;
                res += 1;
            }
        }
        return res;       
    }
}
