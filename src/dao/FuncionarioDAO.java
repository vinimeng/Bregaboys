package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.ConectaBD;
import vo.FuncionarioVO;

public class FuncionarioDAO {
    private static final String SELECT
            = "SELECT * FROM Funcionario WHERE codigoFuncionario = ?";
    private static final String SELECTALL
            = "SELECT * FROM Funcionario";
    private static final String INSERT
            = "INSERT INTO Funcionario "
            + "(codigoFuncionario, codigoCategoriaSalario, codigoEndereco, codigoGerente, codigoSecao, senhaFuncionario, emailFuncionario, nomeFuncionario, telefoneFuncionario) "
            + "VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE
            = "UPDATE Funcionario SET codigoFuncionario = ?, codigoCategoriaSalario = ?, codigoEndereco = ?, codigoGerente = ?, codigoSecao = ?, senhaFuncionario = ?, emailFuncionario = ?, nomeFuncionario = ?, telefoneFuncionario = ? "
            + "WHERE codigoFuncionario = ?";
    private static final String DELETE
            = "DELETE from Funcionario " + "WHERE codigoFuncionario = ?";
    private static final String CODIGOMAX
            = "SELECT MAX(codigoFuncionario) FROM Funcionario";
    
    public int codigoFuncionarioMax() throws ClassNotFoundException, SQLException {
            int retorno;
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(CODIGOMAX);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            retorno = resultSet.getInt("MAX(codigoFuncionario)");
            resultSet.close();
            statement.close();
            connection.close();
            return retorno;
    }
    
    public FuncionarioVO buscarFuncionario(FuncionarioVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setInt(1, vo.getCodigoFuncionario());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            vo.setCodigoFuncionario(resultSet.getInt("codigoFuncionario"));
            vo.setCodigoEndereco(resultSet.getInt("codigoEndereco"));
            vo.setCodigoCategoriaSalario(resultSet.getInt("codigoCategoriaSalario"));
            vo.setCodigoGerente(resultSet.getInt("codigoGerente"));
            vo.setCodigoSecao(resultSet.getInt("codigoSecao"));
            vo.setSenhaFuncionario(resultSet.getString("senhaFuncionario"));
            vo.setEmailFuncionario(resultSet.getString("emailFuncionario"));
            vo.setNomeFuncionario(resultSet.getString("nomeFuncionario"));
            vo.setTelefoneFuncionario(resultSet.getString("telefoneFuncionario"));
            resultSet.close();
            statement.close();
            connection.close();
            return vo;
	}
    
    public FuncionarioVO buscarFuncionario(int codigo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            FuncionarioVO vo = new FuncionarioVO();
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setInt(1, codigo);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            vo.setCodigoFuncionario(resultSet.getInt("codigoFuncionario"));
            vo.setCodigoEndereco(resultSet.getInt("codigoEndereco"));
            vo.setCodigoCategoriaSalario(resultSet.getInt("codigoCategoriaSalario"));
            vo.setCodigoGerente(resultSet.getInt("codigoGerente"));
            vo.setCodigoSecao(resultSet.getInt("codigoSecao"));
            vo.setSenhaFuncionario(resultSet.getString("senhaFuncionario"));
            vo.setEmailFuncionario(resultSet.getString("emailFuncionario"));
            vo.setNomeFuncionario(resultSet.getString("nomeFuncionario"));
            vo.setTelefoneFuncionario(resultSet.getString("telefoneFuncionario"));
            resultSet.close();
            statement.close();
            connection.close();
            return vo;
	}
    
    public ArrayList buscarFuncionarioAll() throws SQLException, ClassNotFoundException{
            ArrayList retorno = new ArrayList();
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECTALL);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                FuncionarioVO vo = new FuncionarioVO(resultSet.getInt("codigoCategoriaSalario"),
                    resultSet.getInt("codigoEndereco"),
                    resultSet.getInt("codigoFuncionario"),
                    resultSet.getInt("codigoGerente"),
                    resultSet.getInt("codigoSecao"),
                    resultSet.getString("senhaFuncionario"),
                    resultSet.getString("emailFuncionario"),
                    resultSet.getString("nomeFuncionario"),
                    resultSet.getString("telefoneFuncionario"));
                retorno.add(vo);
            }
            resultSet.close();
            statement.close();
            connection.close();
            return retorno;
	}
    
     public FuncionarioVO criarFuncionario(FuncionarioVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setInt(1, vo.getCodigoFuncionario());
            statement.setInt(2, vo.getCodigoCategoriaSalario());
            statement.setInt(3, vo.getCodigoEndereco());
            statement.setInt(4, vo.getCodigoGerente());
            statement.setInt(5, vo.getCodigoSecao());
            statement.setString(6, vo.getSenhaFuncionario());
            statement.setString(7, vo.getEmailFuncionario());
            statement.setString(8, vo.getNomeFuncionario());
            statement.setString(9, vo.getTelefoneFuncionario());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
	}
     
    public FuncionarioVO alterarFuncionario(FuncionarioVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setInt(1, vo.getCodigoFuncionario());
            statement.setInt(2, vo.getCodigoCategoriaSalario());
            statement.setInt(3, vo.getCodigoEndereco());
            statement.setInt(4, vo.getCodigoGerente());
            statement.setInt(5, vo.getCodigoSecao());
            statement.setString(6, vo.getSenhaFuncionario());
            statement.setString(7, vo.getEmailFuncionario());
            statement.setString(8, vo.getNomeFuncionario());
            statement.setString(9, vo.getTelefoneFuncionario());
            statement.setInt(10, vo.getCodigoFuncionario());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
    }
    
    public void alterarFuncionarioCS(int cod) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE Funcionario SET codigoCategoriaSalario = 0 WHERE codigoCategoriaSalario = ?");
            statement.setInt(1, cod);
            statement.executeUpdate();
            statement.close();
            connection.close();
    }
    
    public void alterarFuncionarioS(int cod) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE Funcionario SET codigoSecao = 0 WHERE codigoSecao = ?");
            statement.setInt(1, cod);
            statement.executeUpdate();
            statement.close();
            connection.close();
    }
    
    public FuncionarioVO excluirFuncionario(FuncionarioVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setInt(1, vo.getCodigoFuncionario());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
    }
    
    public void excluirFuncionario(int cod) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setInt(1, cod);
            statement.executeUpdate();
            statement.close();
            connection.close();
    }
    
}
