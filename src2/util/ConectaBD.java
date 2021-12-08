package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBD {
    public static Connection getConnection() throws SQLException, ClassNotFoundException
    {
        @SuppressWarnings("unused")
		Connection con;
        //Class.forName("com.mysql.jdbc.Driver");

        String fonte = "jdbc:mysql://localhost"  /*endereço do banco*/
                 + ":" + "3306"       /*porta*/
                 + "/" + "Bregaboys"        /*nome do banco*/
                 + "?user=" + "Bregaboys"
                 + "&password=" + "Zxk,bb";   
        @SuppressWarnings("unused")
		String fonte_externa = "jdbc:mysql://200.132.7.1"  /*endereço do banco*/
                 + ":" + "1080"       /*porta*/
                 + "/" + "Bregaboys"        /*nome do banco*/
                 + "?user=" + "Bregaboys"
                 + "&password=" + "Zxk,bb";          
        /*javax.swing.JOptionPane.showMessageDialog(null, fonte);*/
        return DriverManager.getConnection(fonte);
    }
}
