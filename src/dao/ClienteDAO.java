package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.ConectaBD;
import vo.ClienteVO;

public class ClienteDAO {
    private static final String SELECT
            = "SELECT * FROM Cliente WHERE codigoCliente = ?";
    private static final String SELECTALL
            = "SELECT * FROM Cliente";
    private static final String INSERT
            = "INSERT INTO Cliente "
            + "(codigoCliente, senhaCliente, nomeCliente, telefoneCliente, emailCliente, codigoEndereco) "
            + "VALUES(?,?,?,?,?,?)";
    private static final String UPDATE
            = "UPDATE Cliente SET codigoCliente = ?, senhaCliente = ?, nomeCliente = ?, telefoneCliente = ?, emailCliente = ?, codigoEndereco = ? "
            + "WHERE codigoCliente = ?";
    private static final String DELETE
            = "DELETE from Cliente " + "WHERE codigoCliente = ?";
    private static final String CODIGOMAX
            = "SELECT MAX(codigoCliente) FROM Cliente";
    
    public int codigoClienteMax() throws ClassNotFoundException, SQLException {
            int retorno;
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(CODIGOMAX);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            retorno = resultSet.getInt("MAX(codigoCliente)");
            resultSet.close();
            statement.close();
            connection.close();
            return retorno;
    }
    
    public ClienteVO buscarCliente(ClienteVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setInt(1, vo.getCodigoCliente());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            vo.setCodigoCliente(resultSet.getInt("codigoCliente"));
            vo.setCodigoEndereco(resultSet.getInt("codigoEndereco"));
            vo.setSenhaCliente(resultSet.getString("senhaCliente"));
            vo.setEmailCliente(resultSet.getString("emailCliente"));
            vo.setNomeCliente(resultSet.getString("nomeCliente"));
            vo.setTelefoneCliente(resultSet.getString("telefoneCliente"));
            resultSet.close();
            statement.close();
            connection.close();
            return vo;
	}
    
    public ClienteVO buscarCliente(int codigo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            ClienteVO vo = new ClienteVO();
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setInt(1, codigo);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            vo.setCodigoCliente(resultSet.getInt("codigoCliente"));
            vo.setCodigoEndereco(resultSet.getInt("codigoEndereco"));
            vo.setSenhaCliente(resultSet.getString("senhaCliente"));
            vo.setEmailCliente(resultSet.getString("emailCliente"));
            vo.setNomeCliente(resultSet.getString("nomeCliente"));
            vo.setTelefoneCliente(resultSet.getString("telefoneCliente"));
            resultSet.close();
            statement.close();
            connection.close();
            return vo;
	}
    
    public ArrayList<ClienteVO> buscarClienteAll() throws SQLException, ClassNotFoundException{
            ArrayList<ClienteVO> retorno = new ArrayList<ClienteVO>();
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECTALL);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                ClienteVO vo = new ClienteVO(resultSet.getInt("codigoCliente"),
                    resultSet.getInt("codigoEndereco"),
                    resultSet.getString("senhaCliente"),
                    resultSet.getString("emailCliente"),
                    resultSet.getString("nomeCliente"),
                    resultSet.getString("telefoneCliente"));
                retorno.add(vo);
            }
            resultSet.close();
            statement.close();
            connection.close();
            return retorno;
	}
    
     public ClienteVO criarCliente(ClienteVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setInt(1, vo.getCodigoCliente());
            statement.setString(2, vo.getSenhaCliente());
            statement.setString(3, vo.getNomeCliente());
            statement.setString(4, vo.getTelefoneCliente());
            statement.setString(5, vo.getEmailCliente());
            statement.setInt(6, vo.getCodigoEndereco());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
	}
     
    public ClienteVO alterarCliente(ClienteVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setInt(1, vo.getCodigoCliente());
            statement.setString(2, vo.getSenhaCliente());
            statement.setString(3, vo.getNomeCliente());
            statement.setString(4, vo.getTelefoneCliente());
            statement.setString(5, vo.getEmailCliente());
            statement.setInt(6, vo.getCodigoEndereco());
            statement.setInt(7, vo.getCodigoCliente());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
    }
    
    public ClienteVO excluirCliente(ClienteVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setInt(1, vo.getCodigoCliente());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
    }
    
    public void excluirCliente(int cod) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setInt(1, cod);
            statement.executeUpdate();
            statement.close();
            connection.close();
    }
}
