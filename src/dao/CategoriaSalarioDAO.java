package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.ConectaBD;
import vo.CategoriaSalarioVO;

public class CategoriaSalarioDAO {
    private static final String SELECT
            = "SELECT * FROM CategoriaSalario WHERE codigoCategoriaSalario = ?";
    private static final String SELECTALL
            = "SELECT * FROM CategoriaSalario";
    private static final String INSERT
            = "INSERT INTO CategoriaSalario "
            + "(codigoCategoriaSalario, valorCategoriaSalario) "
            + "VALUES(?,?)";
    private static final String UPDATE
            = "UPDATE CategoriaSalario SET codigoCategoriaSalario = ?, valorCategoriaSalario = ? "
            + "WHERE codigoCategoriaSalario = ?";
    private static final String DELETE
            = "DELETE from CategoriaSalario " + "WHERE codigoCategoriaSalario = ?";
     private static final String CODIGOMAX
            = "SELECT MAX(codigoCategoriaSalario) FROM CategoriaSalario";
    
    public int codigoCategoriaSalarioMax() throws ClassNotFoundException, SQLException {
            int retorno;
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(CODIGOMAX);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            retorno = resultSet.getInt("MAX(codigoCategoriaSalario)");
            resultSet.close();
            statement.close();
            connection.close();
            return retorno;
    }
    
    public CategoriaSalarioVO buscarCategoriaSalario(CategoriaSalarioVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setInt(1, vo.getCodigoCategoriaSalario());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            vo.setCodigoCategoriaSalario(resultSet.getInt("codigoCategoriaSalario"));
            vo.setValorCategoriaSalario(resultSet.getFloat("valorCategoriaSalario"));
            resultSet.close();
            statement.close();
            connection.close();
            return vo;
	}
    
    public CategoriaSalarioVO buscarCategoriaSalario(int codigo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            CategoriaSalarioVO vo = new CategoriaSalarioVO();
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setInt(1, codigo);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            vo.setCodigoCategoriaSalario(resultSet.getInt("codigoCategoriaSalario"));
            vo.setValorCategoriaSalario(resultSet.getFloat("valorCategoriaSalario"));
            resultSet.close();
            statement.close();
            connection.close();
            return vo;
	}
    
    public ArrayList<CategoriaSalarioVO> buscarCategoriaSalarioAll() throws SQLException, ClassNotFoundException{
            ArrayList<CategoriaSalarioVO> retorno = new ArrayList<CategoriaSalarioVO>();
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECTALL);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                CategoriaSalarioVO vo = new CategoriaSalarioVO(resultSet.getInt("codigoCategoriaSalario"),
                    resultSet.getFloat("valorCategoriaSalario"));
                retorno.add(vo);
            }
            resultSet.close();
            statement.close();
            connection.close();
            return retorno;
	}
    
     public CategoriaSalarioVO criarCategoriaSalario(CategoriaSalarioVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setInt(1, vo.getCodigoCategoriaSalario());
            statement.setFloat(2, vo.getValorCategoriaSalario());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
	}
     
    public CategoriaSalarioVO alterarCategoriaSalario(CategoriaSalarioVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setInt(1, vo.getCodigoCategoriaSalario());
            statement.setFloat(2, vo.getValorCategoriaSalario());
            statement.setInt(3, vo.getCodigoCategoriaSalario());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
    }
    
    public void excluirCategoriaSalario(CategoriaSalarioVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setInt(1, vo.getCodigoCategoriaSalario());
            statement.executeUpdate();
            statement.close();
            connection.close();
    }
    
    public void excluirCategoriaSalario(int codigo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setInt(1, codigo);
            statement.executeUpdate();
            statement.close();
            connection.close();
    }
}
