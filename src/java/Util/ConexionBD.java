package Util;

import java.sql.*;

public class ConexionBD {

    //Cadena de coneccion de mysql
    public static Connection getConexion() {
        String url = "jdbc:mysql://localhost:3306/db_registro?useSSL=false";
        Connection cn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, "root", "admin");
            System.out.println("Conectado");
            Statement instruccion = cn.createStatement();

            String sql = "select codigo, nombre, apellido, usuario, clave from usuario ";

            ResultSet result = instruccion.executeQuery(sql);

       

         
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return cn;
    }

    public static void main(String[] args) {
        getConexion();
    }

}
