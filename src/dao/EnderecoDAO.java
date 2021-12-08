package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.ConectaBD;
import vo.EnderecoVO;

public class EnderecoDAO {
    private static final String SELECT
            = "SELECT * FROM Endereco WHERE codigoEndereco = ?";
    private static final String SELECTALL
            = "SELECT * FROM Endereco";
    private static final String INSERT
            = "INSERT INTO Endereco "
            + "(codigoEndereco, bairro, cidade, estado, numeroCasa, pais, rua) "
            + "VALUES(?,?,?,?,?,?,?)";
    private static final String UPDATE
            = "UPDATE Endereco SET codigoEndereco = ?, bairro = ?, cidade = ?, estado = ?, numeroCasa = ?, pais = ?, rua = ? "
            + "WHERE codigoEndereco = ?";
    private static final String DELETE
            = "DELETE from Endereco " + "WHERE codigoEndereco = ?";
    private static final String CODIGOMAX
            = "SELECT MAX(codigoEndereco) FROM Endereco";
    
    public int codigoEnderecoMax() throws ClassNotFoundException, SQLException {
            int retorno;
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(CODIGOMAX);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            retorno = resultSet.getInt("MAX(codigoEndereco)");
            resultSet.close();
            statement.close();
            connection.close();
            return retorno;
    }
    
    public EnderecoVO buscarEndereco(EnderecoVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setInt(1, vo.getCodigoEndereco());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            vo.setCodigoEndereco(resultSet.getInt("codigoEndereco"));
            vo.setBairro(resultSet.getString("bairro"));
            vo.setCidade(resultSet.getString("cidade"));
            vo.setEstado(resultSet.getString("estado"));
            vo.setNumeroCasa(resultSet.getInt("numeroCasa"));
            vo.setPais(resultSet.getString("pais"));
            vo.setRua(resultSet.getString("rua"));
            resultSet.close();
            statement.close();
            connection.close();
            return vo;
	}
    
    public ArrayList<EnderecoVO> buscarEnderecoAll() throws SQLException, ClassNotFoundException{
            ArrayList<EnderecoVO> retorno = new ArrayList<EnderecoVO>();
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECTALL);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                EnderecoVO vo = new EnderecoVO(resultSet.getString("bairro"),
                    resultSet.getString("cidade"),
                    resultSet.getInt("codigoEndereco"),
                    resultSet.getString("estado"),
                    resultSet.getInt("numeroCasa"),
                    resultSet.getString("pais"),
                    resultSet.getString("rua"));
                retorno.add(vo);
            }
            resultSet.close();
            statement.close();
            connection.close();
            return retorno;
	}
    
     public EnderecoVO criarEndereco(EnderecoVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setInt(1, vo.getCodigoEndereco());
            statement.setString(2, vo.getBairro());
            statement.setString(3, vo.getCidade());
            statement.setString(4, vo.getEstado());
            statement.setInt(5, vo.getNumeroCasa());
            statement.setString(6, vo.getPais());
            statement.setString(7, vo.getRua());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
	}
     
    public EnderecoVO alterarEndereco(EnderecoVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setInt(1, vo.getCodigoEndereco());
            statement.setString(2, vo.getBairro());
            statement.setString(3, vo.getCidade());
            statement.setString(4, vo.getEstado());
            statement.setInt(5, vo.getNumeroCasa());
            statement.setString(6, vo.getPais());
            statement.setString(7, vo.getRua());
            statement.setInt(8, vo.getCodigoEndereco());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
    }
    
    public EnderecoVO excluirEndereco(EnderecoVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setInt(1, vo.getCodigoEndereco());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
    }
    
    public void excluirEndereco(int codigo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setInt(1, codigo);
            statement.executeUpdate();
            statement.close();
            connection.close();
    }
}
