package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.ConectaBD;
import vo.SecaoVO;

public class SecaoDAO {
    private static final String SELECT
            = "SELECT * FROM Secao WHERE codigoSecao = ?";
    private static final String SELECTALL
            = "SELECT * FROM Secao";
    private static final String INSERT
            = "INSERT INTO Secao "
            + "(codigoSecao, nomeSecao) "
            + "VALUES(?,?)";
    private static final String UPDATE
            = "UPDATE Secao SET codigoSecao = ?, nomeSecao = ? "
            + "WHERE codigoSecao = ?";
    private static final String DELETE
            = "DELETE from Secao " + "WHERE codigoSecao = ?";
     private static final String CODIGOMAX
            = "SELECT MAX(codigoSecao) FROM Secao";
    
    public int codigoSecaoMax() throws ClassNotFoundException, SQLException {
            int retorno;
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(CODIGOMAX);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            retorno = resultSet.getInt("MAX(codigoSecao)");
            resultSet.close();
            statement.close();
            connection.close();
            return retorno;
    }
    
    public SecaoVO buscarSecao(SecaoVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setInt(1, vo.getCodigoSecao());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            vo.setCodigoSecao(resultSet.getInt("codigoSecao"));
            vo.setNomeSecao(resultSet.getString("nomeSecao"));
            resultSet.close();
            statement.close();
            connection.close();
            return vo;
	}
    
    public SecaoVO buscarSecao(int codigo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            SecaoVO vo = new SecaoVO(1, "");
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setInt(1, codigo);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            vo.setCodigoSecao(resultSet.getInt("codigoSecao"));
            vo.setNomeSecao(resultSet.getString("nomeSecao"));
            resultSet.close();
            statement.close();
            connection.close();
            return vo;
	}
    
    public ArrayList buscarSecaoAll() throws SQLException, ClassNotFoundException{
            ArrayList retorno = new ArrayList();
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECTALL);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                SecaoVO vo = new SecaoVO(resultSet.getInt("codigoSecao"),
                    resultSet.getString("nomeSecao"));
                retorno.add(vo);
            }
            resultSet.close();
            statement.close();
            connection.close();
            return retorno;
	}
    
     public SecaoVO criarSecao(SecaoVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setInt(1, vo.getCodigoSecao());
            statement.setString(2, vo.getNomeSecao());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
	}
     
    public SecaoVO alterarSecao(SecaoVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setInt(1, vo.getCodigoSecao());
            statement.setString(2, vo.getNomeSecao());
            statement.setInt(3, vo.getCodigoSecao());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
    }
    
    public void excluirSecao(SecaoVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setInt(1, vo.getCodigoSecao());
            statement.executeUpdate();
            statement.close();
            connection.close();
    }
    public void excluirSecao(int codigo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setInt(1, codigo);
            statement.executeUpdate();
            statement.close();
            connection.close();
    }
}
