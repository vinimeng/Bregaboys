package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.ConectaBD;
import vo.CompraVO;

public class CompraDAO {
    private static final String SELECT
            = "SELECT * FROM Compra WHERE codigoCompra = ?";
    private static final String SELECTALL
            = "SELECT * FROM Compra";
    private static final String INSERT
            = "INSERT INTO Compra "
            + "(codigoCompra, codigoCliente, codigoTransportadora) "
            + "VALUES(?,?,?)";
    private static final String UPDATE
            = "UPDATE Compra SET codigoCompra = ?, codigoCliente = ?, codigoTransportadora = ? "
            + "WHERE codigoCompra = ?";
    private static final String DELETE
            = "DELETE from Compra " + "WHERE codigoCompra = ?";
    private static final String CODIGOMAX
            = "SELECT MAX(codigoCompra) FROM Compra";
    
    public int codigoClienteMax() throws ClassNotFoundException, SQLException {
            int retorno;
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(CODIGOMAX);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            retorno = resultSet.getInt("MAX(codigoCompra)");
            resultSet.close();
            statement.close();
            connection.close();
            return retorno;
    }
    
    public CompraVO buscarCompra(CompraVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setInt(1, vo.getCodigoCompra());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            vo.setCodigoCompra(resultSet.getInt("codigoCompra"));
            vo.setCodigoCliente(resultSet.getInt("codigoCliente"));
            resultSet.close();
            statement.close();
            connection.close();
            return vo;
	}
    
    public CompraVO buscarCompraCli(int cod) throws ClassNotFoundException, SQLException {
            CompraVO vo = new CompraVO();
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Compra WHERE codigoCliente = ?");
            statement.setInt(1, cod);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            vo.setCodigoCompra(resultSet.getInt("codigoCompra"));
            vo.setCodigoCliente(resultSet.getInt("codigoCliente"));
            resultSet.close();
            statement.close();
            connection.close();
            return vo;
	}
    
    public ArrayList buscarCompraAll() throws SQLException, ClassNotFoundException{
            ArrayList retorno = new ArrayList();
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECTALL);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                CompraVO vo = new CompraVO(resultSet.getInt("codigoCliente"),
                    resultSet.getInt("codigoCompra"),
                    resultSet.getInt("codigoTransportadora"));
                retorno.add(vo);
            }
            resultSet.close();
            statement.close();
            connection.close();
            return retorno;
	}
    
     public CompraVO criarCompra(CompraVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setInt(1, vo.getCodigoCompra());
            statement.setInt(2, vo.getCodigoCliente());
            statement.setInt(3, vo.getCodigoTransportadora());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
	}
     
    public CompraVO alterarCompra(CompraVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setInt(1, vo.getCodigoCompra());
            statement.setInt(2, vo.getCodigoCliente());
            statement.setInt(3, vo.getCodigoTransportadora());
            statement.setInt(4, vo.getCodigoCompra());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
    }
    
    public CompraVO excluirCompra(CompraVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setInt(1, vo.getCodigoCompra());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
    }
    
    public void excluirCompraT(int cod) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE from Compra " + "WHERE codigoTransportadora = ?");
            statement.setInt(1, cod);
            statement.executeUpdate();
            statement.close();
            connection.close();
    }
    
    public void excluirCompraCli(int cod) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE from Compra " + "WHERE codigoCliente = ?");
            statement.setInt(1, cod);
            statement.executeUpdate();
            statement.close();
            connection.close();
    }
}
