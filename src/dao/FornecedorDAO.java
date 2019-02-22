package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.ConectaBD;
import vo.FornecedorVO;

public class FornecedorDAO {
    private static final String SELECT
            = "SELECT * FROM Fornecedor WHERE codigoFornecedor = ?";
    private static final String SELECTALL
            = "SELECT * FROM Fornecedor";
    private static final String INSERT
            = "INSERT INTO Fornecedor "
            + "(codigoFornecedor, codigoEndereco, emailFornecedor, nomeFornecedor, telefoneFornecedor) "
            + "VALUES(?,?,?,?,?)";
    private static final String UPDATE
            = "UPDATE Fornecedor SET codigoFornecedor = ?, codigoEndereco = ?, emailFornecedor = ?, nomeFornecedor = ?, telefoneFornecedor = ? "
            + "WHERE codigoFornecedor = ?";
    private static final String DELETE
            = "DELETE from Fornecedor " + "WHERE codigoFornecedor = ?";
    private static final String CODIGOMAX
            = "SELECT MAX(codigoFornecedor) FROM Fornecedor";
    
    public int codigoFornecedorMax() throws ClassNotFoundException, SQLException {
            int retorno;
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(CODIGOMAX);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            retorno = resultSet.getInt("MAX(codigoFornecedor)");
            resultSet.close();
            statement.close();
            connection.close();
            return retorno;
    }
    
    public FornecedorVO buscarFornecedor(FornecedorVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setInt(1, vo.getCodigoFornecedor());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            vo.setCodigoFornecedor(resultSet.getInt("codigoFornecedor"));
            vo.setCodigoEndereco(resultSet.getInt("codigoEndereco"));
            vo.setEmailFornecedor(resultSet.getString("emailFornecedor"));
            vo.setNomeFornecedor(resultSet.getString("nomeFornecedor"));
            vo.setTelefoneFornecedor(resultSet.getString("telefoneFornecedor"));
            resultSet.close();
            statement.close();
            connection.close();
            return vo;
	}
    
    public FornecedorVO buscarFornecedor(int codigo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            FornecedorVO vo = new FornecedorVO(1,1,"","","");
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setInt(1, codigo);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            vo.setCodigoFornecedor(resultSet.getInt("codigoFornecedor"));
            vo.setCodigoEndereco(resultSet.getInt("codigoEndereco"));
            vo.setEmailFornecedor(resultSet.getString("emailFornecedor"));
            vo.setNomeFornecedor(resultSet.getString("nomeFornecedor"));
            vo.setTelefoneFornecedor(resultSet.getString("telefoneFornecedor"));
            resultSet.close();
            statement.close();
            connection.close();
            return vo;
	}
    
    public ArrayList buscarFornecedorAll() throws SQLException, ClassNotFoundException{
            ArrayList retorno = new ArrayList();
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECTALL);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                FornecedorVO vo = new FornecedorVO(resultSet.getInt("codigoEndereco"),
                    resultSet.getInt("codigoFornecedor"),
                    resultSet.getString("emailFornecedor"),
                    resultSet.getString("nomeFornecedor"),
                    resultSet.getString("telefoneFornecedor"));
                retorno.add(vo);
            }
            resultSet.close();
            statement.close();
            connection.close();
            return retorno;
	}
    
     public FornecedorVO criarFornecedor(FornecedorVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setInt(1, vo.getCodigoFornecedor());
            statement.setInt(2, vo.getCodigoEndereco());
            statement.setString(3, vo.getEmailFornecedor());
            statement.setString(4, vo.getNomeFornecedor());
            statement.setString(5, vo.getTelefoneFornecedor());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
	}
     
    public FornecedorVO alterarFornecedor(FornecedorVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setInt(1, vo.getCodigoFornecedor());
            statement.setInt(2, vo.getCodigoEndereco());
            statement.setString(3, vo.getEmailFornecedor());
            statement.setString(4, vo.getNomeFornecedor());
            statement.setString(5, vo.getTelefoneFornecedor());
            statement.setInt(6, vo.getCodigoFornecedor());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
    }
    
    public FornecedorVO excluirFornecedor(FornecedorVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setInt(1, vo.getCodigoFornecedor());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
    }
    public void excluirFornecedor(int cod) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setInt(1, cod);
            statement.executeUpdate();
            statement.close();
            connection.close();
    }
}
