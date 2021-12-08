package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.ConectaBD;
import vo.CompraProdutoVO;

public class CompraProdutoDAO {
    private static final String SELECTC
             = "SELECT * FROM CompraProduto WHERE codigoCompra = ?";
    private static final String SELECTP
            = "SELECT * FROM CompraProduto WHERE codigoProduto = ?";
    private static final String SELECT
            = "SELECT * FROM CompraProduto WHERE codigoCompra = ? AND codigoProduto = ?";
    private static final String SELECTALL
            = "SELECT * FROM CompraProduto";
    private static final String INSERT
            = "INSERT INTO CompraProduto "
            + "(codigoCompra, codigoProduto, quantidadeProduto) "
            + "VALUES(?,?,?)";
    private static final String UPDATEC
            = "UPDATE CompraProduto SET codigoCompra = ?, codigoProduto = ?, quantidadeProduto = ? "
            + "WHERE codigoCompra = ?";
    private static final String UPDATEP
            = "UPDATE CompraProduto SET codigoCompra = ?, codigoProduto = ?, quantidadeProduto = ? "
            + "WHERE codigoProduto = ?";
    private static final String UPDATE
            = "UPDATE CompraProduto SET codigoCompra = ?, codigoProduto = ?, quantidadeProduto = ? "
            + "WHERE codigoCompra = ? AND codigoProduto = ?";
    private static final String DELETEC
            = "DELETE from CompraProduto " + "WHERE codigoCompra = ?";
    private static final String DELETEP
            = "DELETE from CompraProduto " + "WHERE codigoProduto = ?";
    private static final String DELETE
            = "DELETE from CompraProduto " + "WHERE codigoCompra = ? AND codigoProduto = ?";
    @SuppressWarnings("unused")
	private static final String QNTTOTAL
            = "SELECT SUM(quantidadeProduto) FROM CompraProduto GROUP BY codigoCompra";
    
    public CompraProdutoVO buscarCompraProdutoC(CompraProdutoVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECTC);
            statement.setInt(1, vo.getCodigoCompra());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            vo.setCodigoCompra(resultSet.getInt("codigoCompra"));
            vo.setCodigoProduto(resultSet.getInt("codigoProduto"));
            vo.setQuantidadeProduto(resultSet.getInt("quantidadeProduto"));
            resultSet.close();
            statement.close();
            connection.close();
            return vo;
	}
    
    public CompraProdutoVO buscarCompraProdutoP(CompraProdutoVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECTP);
            statement.setInt(1, vo.getCodigoProduto());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            vo.setCodigoCompra(resultSet.getInt("codigoCompra"));
            vo.setCodigoProduto(resultSet.getInt("codigoProduto"));
            vo.setQuantidadeProduto(resultSet.getInt("quantidadeProduto"));
            resultSet.close();
            statement.close();
            connection.close();
            return vo;
	}
    
    public CompraProdutoVO buscarCompraProduto(CompraProdutoVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setInt(1, vo.getCodigoCompra());
            statement.setInt(2, vo.getCodigoProduto());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            vo.setCodigoCompra(resultSet.getInt("codigoCompra"));
            vo.setCodigoProduto(resultSet.getInt("codigoProduto"));
            vo.setQuantidadeProduto(resultSet.getInt("quantidadeProduto"));
            resultSet.close();
            statement.close();
            connection.close();
            return vo;
	}
    
    public ArrayList<CompraProdutoVO> buscarCompraProdutoAll() throws SQLException, ClassNotFoundException{
            ArrayList<CompraProdutoVO> retorno = new ArrayList<CompraProdutoVO>();
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECTALL);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                CompraProdutoVO vo = new CompraProdutoVO(resultSet.getInt("codigoCompra"),
                    resultSet.getInt("codigoProduto"),
                    resultSet.getInt("quantidadeProduto"));
                retorno.add(vo);
            }
            resultSet.close();
            statement.close();
            connection.close();
            return retorno;
	}
    
     public CompraProdutoVO criarCompraProduto(CompraProdutoVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setInt(1, vo.getCodigoCompra());
            statement.setInt(2, vo.getCodigoProduto());
            statement.setInt(3, vo.getQuantidadeProduto());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
	}
     
    public CompraProdutoVO alterarCompraProdutoC(CompraProdutoVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATEC);
            statement.setInt(1, vo.getCodigoCompra());
            statement.setInt(2, vo.getCodigoProduto());
            statement.setInt(3, vo.getQuantidadeProduto());
            statement.setInt(4, vo.getCodigoCompra());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
    }
    
    public CompraProdutoVO alterarCompraProdutoP(CompraProdutoVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATEP);
            statement.setInt(1, vo.getCodigoCompra());
            statement.setInt(2, vo.getCodigoProduto());
            statement.setInt(3, vo.getQuantidadeProduto());
            statement.setInt(4, vo.getCodigoProduto());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
    }
    
    public CompraProdutoVO alterarCompraProduto(CompraProdutoVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setInt(1, vo.getCodigoCompra());
            statement.setInt(2, vo.getCodigoProduto());
            statement.setInt(3, vo.getQuantidadeProduto());
            statement.setInt(4, vo.getCodigoCompra());
            statement.setInt(5, vo.getCodigoProduto());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
    }
    
    public CompraProdutoVO excluirCompraProdutoC(CompraProdutoVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETEC);
            statement.setInt(1, vo.getCodigoCompra());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
    }
    
    public CompraProdutoVO excluirCompraProdutoP(CompraProdutoVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETEP);
            statement.setInt(1, vo.getCodigoProduto());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
    }
    
    public CompraProdutoVO excluirCompraProduto(CompraProdutoVO vo) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setInt(1, vo.getCodigoCompra());
            statement.setInt(2, vo.getCodigoProduto());
            statement.executeUpdate();
            statement.close();
            connection.close();
            return vo;
    }
    
    public void excluirCompraProdutoP(int cod) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETEP);
            statement.setInt(1, cod);
            statement.executeUpdate();
            statement.close();
            connection.close();
    }
    
    public void excluirCompraProdutoC(int cod) throws ClassNotFoundException, SQLException {
            Connection connection = ConectaBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETEC);
            statement.setInt(1, cod);
            statement.executeUpdate();
            statement.close();
            connection.close();
    }
}
