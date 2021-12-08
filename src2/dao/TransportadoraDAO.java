package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.ConectaBD;
import vo.TransportadoraVO;

public class TransportadoraDAO {
    private static final String SELECT
            = "SELECT * FROM Transportadora WHERE codigoTransportadora = ?";
    private static final String SELECTALL
            = "SELECT * FROM Transportadora";
    private static final String INSERT
            = "INSERT INTO Transportadora "
            + "(codigoTransportadora, codigoEndereco, emailTransportadora, nomeTransportadora, telefoneTransportadora) "
            + "VALUES(?,?,?,?,?)";
    private static final String UPDATE
            = "UPDATE Transportadora SET codigoTransportadora = ?, codigoEndereco = ?, emailTransportadora = ?, nomeTransportadora = ?, telefoneTransportadora = ? "
            + "WHERE codigoTransportadora = ?";
    private static final String DELETE
            = "DELETE from Transportadora " + "WHERE codigoTransportadora = ?";
    private static final String CODIGOMAX
            = "SELECT MAX(codigoTransportadora) FROM Transportadora";
    
    public int codigoTransportadoraMax() throws ClassNotFoundException, SQLException {
            int retorno;
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(CODIGOMAX);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            retorno = resultSet.getInt("MAX(codigoTransportadora)");
            resultSet.close();
            statement.close();
            connection.close();
            return retorno;
    }
    
    public TransportadoraVO buscarTransportadora(TransportadoraVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setInt(1, vo.getCodigoTransportadora());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            vo.setCodigoTransportadora(resultSet.getInt("codigoTransportadora"));
            vo.setCodigoEndereco(resultSet.getInt("codigoEndereco"));
            vo.setEmailTransportadora(resultSet.getString("emailTransportadora"));
            vo.setNomeTransportadora(resultSet.getString("nomeTransportadora"));
            vo.setTelefoneTransportadora(resultSet.getString("telefoneTransportadora"));
            resultSet.close();
            statement.close();
            connection.close();
            return vo;
	}
    
    public TransportadoraVO buscarTransportadora(int codigo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            TransportadoraVO vo = new TransportadoraVO(1,1,"","","");
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setInt(1, codigo);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            vo.setCodigoTransportadora(resultSet.getInt("codigoTransportadora"));
            vo.setCodigoEndereco(resultSet.getInt("codigoEndereco"));
            vo.setEmailTransportadora(resultSet.getString("emailTransportadora"));
            vo.setNomeTransportadora(resultSet.getString("nomeTransportadora"));
            vo.setTelefoneTransportadora(resultSet.getString("telefoneTransportadora"));
            resultSet.close();
            statement.close();
            connection.close();
            return vo;
	}
    
    public ArrayList<TransportadoraVO> buscarTransportadoraAll() throws SQLException, ClassNotFoundException{
            ArrayList<TransportadoraVO> retorno = new ArrayList<TransportadoraVO>();
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECTALL);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                TransportadoraVO vo = new TransportadoraVO(resultSet.getInt("codigoEndereco"),
                    resultSet.getInt("codigoTransportadora"),
                    resultSet.getString("emailTransportadora"),
                    resultSet.getString("nomeTransportadora"),
                    resultSet.getString("telefoneTransportadora"));
                retorno.add(vo);
            }
            resultSet.close();
            statement.close();
            connection.close();
            return retorno;
	}
    
     public TransportadoraVO criarTransportadora(TransportadoraVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setInt(1, vo.getCodigoTransportadora());
            statement.setInt(2, vo.getCodigoEndereco());
            statement.setString(3, vo.getEmailTransportadora());
            statement.setString(4, vo.getNomeTransportadora());
            statement.setString(5, vo.getTelefoneTransportadora());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
	}
     
    public TransportadoraVO alterarTransportadora(TransportadoraVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setInt(1, vo.getCodigoTransportadora());
            statement.setInt(2, vo.getCodigoEndereco());
            statement.setString(3, vo.getEmailTransportadora());
            statement.setString(4, vo.getNomeTransportadora());
            statement.setString(5, vo.getTelefoneTransportadora());
            statement.setInt(6, vo.getCodigoTransportadora());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
    }
    
    public TransportadoraVO excluirTransportadora(TransportadoraVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setInt(1, vo.getCodigoTransportadora());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
    }
    public void excluirTransportadora(int codigo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setInt(1, codigo);
            statement.executeUpdate();
            statement.close();
            connection.close();
    }
}
