package util;

import java.sql.*;
import java.net.*;

public class ConectaBD {
    public static Connection getConnection() throws SQLException, ClassNotFoundException
    {
        Connection con;
        Class.forName("com.mysql.jdbc.Driver");

        String fonte = "jdbc:mysql://192.168.2.19"  /*endereço do banco*/
                 + ":" + "3306"       /*porta*/
                 + "/" + "Bregaboys"        /*nome do banco*/
                 + "?user=" + "Bregaboys"
                 + "&password=" + "Zxk,bb";   
        String fonte_externa = "jdbc:mysql://200.132.7.1"  /*endereço do banco*/
                 + ":" + "1080"       /*porta*/
                 + "/" + "Bregaboys"        /*nome do banco*/
                 + "?user=" + "Bregaboys"
                 + "&password=" + "Zxk,bb";          
        /*javax.swing.JOptionPane.showMessageDialog(null, fonte);*/
        return DriverManager.getConnection(fonte);
    }
}
