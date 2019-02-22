package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.ConectaBD;
import vo.ProdutoVO;

public class ProdutoDAO {
    private static final String SELECT
            = "SELECT * FROM Produto WHERE codigoProduto = ?";
    private static final String SELECTALL
            = "SELECT * FROM Produto";
    private static final String INSERT
            = "INSERT INTO Produto "
            + "(codigoProduto, codigoFornecedor, codigoSecao, codigoImagem, nomeProduto, valorUnitario) "
            + "VALUES(?,?,?,?,?,?)";
    private static final String UPDATE
            = "UPDATE Produto SET codigoProduto = ?, codigoFornecedor = ?, codigoSecao = ?, codigoImagem = ?, nomeProduto = ?, valorUnitario = ? "
            + "WHERE codigoProduto = ?";
    private static final String DELETE
            = "DELETE from Produto " + "WHERE codigoProduto = ?";
    private static final String CODIGOMAX
            = "SELECT MAX(codigoProduto) FROM Produto";
    
    public int codigoProdutoMax() throws ClassNotFoundException, SQLException {
            int retorno;
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(CODIGOMAX);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            retorno = resultSet.getInt("MAX(codigoProduto)");
            resultSet.close();
            statement.close();
            connection.close();
            return retorno;
    }
    
    public ProdutoVO buscarProduto(ProdutoVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setInt(1, vo.getCodigoProduto());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            vo.setCodigoProduto(resultSet.getInt("codigoProduto"));
            vo.setCodigoFornecedor(resultSet.getInt("codigoFornecedor"));
            vo.setCodigoSecao(resultSet.getInt("codigoSecao"));
            vo.setCodigoImagem(resultSet.getInt("codigoImagem"));
            vo.setNomeProduto(resultSet.getString("nomeProduto"));
            vo.setValorUnitario(resultSet.getFloat("valorUnitario"));
            resultSet.close();
            statement.close();
            return vo;
	}
    
    public ProdutoVO buscarProduto(int codigo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            ProdutoVO vo = new ProdutoVO(1,1,1,1,"",2);
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setInt(1, codigo);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            vo.setCodigoProduto(resultSet.getInt("codigoProduto"));
            vo.setCodigoFornecedor(resultSet.getInt("codigoFornecedor"));
            vo.setCodigoSecao(resultSet.getInt("codigoSecao"));
            vo.setNomeProduto(resultSet.getString("nomeProduto"));
            vo.setValorUnitario(resultSet.getFloat("valorUnitario"));
            resultSet.close();
            statement.close();
            return vo;
	}
    
    public ArrayList buscarProdutoAll() throws SQLException, ClassNotFoundException{
            ArrayList <ProdutoVO> retorno = new ArrayList();
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECTALL);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                ProdutoVO vo = new ProdutoVO(resultSet.getInt("codigoFornecedor"),
                    resultSet.getInt("codigoProduto"),
                    resultSet.getInt("codigoSecao"),
                    resultSet.getInt("codigoImagem"),
                    resultSet.getString("nomeProduto"),
                    resultSet.getFloat("valorUnitario"));
                retorno.add(vo);
            }
            resultSet.close();
            statement.close();
            return retorno;
	}
    
     public ProdutoVO criarProduto(ProdutoVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setInt(1, vo.getCodigoProduto());
            statement.setInt(2, vo.getCodigoFornecedor());
            statement.setInt(3, vo.getCodigoSecao());
            statement.setInt(4, vo.getCodigoImagem());
            statement.setString(5, vo.getNomeProduto());
            statement.setFloat(6, vo.getValorUnitario());
            statement.executeUpdate();
            statement.close();
            return vo;
	}
     
    public ProdutoVO alterarProduto(ProdutoVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setInt(1, vo.getCodigoProduto());
            statement.setInt(2, vo.getCodigoFornecedor());
            statement.setInt(3, vo.getCodigoSecao());
            statement.setInt(4, vo.getCodigoImagem());
            statement.setString(5, vo.getNomeProduto());
            statement.setFloat(6, vo.getValorUnitario());
            statement.setInt(7, vo.getCodigoProduto());
            statement.executeUpdate();
            statement.close();
            return vo;
    }
    
    public void alterarProdutoS(int cod) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE Produto SET codigoSecao = 0 WHERE codigoSecao = ?");
            statement.setInt(1, cod);
            statement.executeUpdate();
            statement.close();
    }
    
    public ProdutoVO excluirProduto(ProdutoVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setInt(1, vo.getCodigoProduto());
            statement.executeUpdate();
            statement.close();
            return vo;
    }
    
    public void excluirProdutoF(int codigoForn) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE from Produto " + "WHERE codigoFornecedor = ?");
            statement.setInt(1, codigoForn);
            statement.executeUpdate();
            statement.close();
    }
    
    public void excluirProduto(int codigo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setInt(1, codigo);
            statement.executeUpdate();
            statement.close();
    }
    
}