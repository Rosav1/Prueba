package Modelo.DAO;

import Modelo.Bean.UsuarioBean;
import Util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDAO {

    Connection cn = null;
    PreparedStatement pt = null;
    ResultSet rs = null;
    UsuarioBean objUsuarioBean = null;
    ArrayList<UsuarioBean> lista = null;

    public boolean ValidarUsuario(UsuarioBean obj) {

        boolean estado = false;
        try {
            cn = ConexionBD.getConexion();
            pt = cn.prepareStatement("select * from usuario where usuario=? and clave=?;");
            System.out.println(pt);
            pt.setString(1, obj.getUsuario());
            System.out.println(obj.getUsuario());
            pt.setString(2, obj.getClave());
            System.out.println(obj.getClave());

            rs = pt.executeQuery();

            if (rs.next()) {
                estado = true;
            }
            pt.close();
            rs.close();
            cn.close();
        } catch (Exception e) {
            estado = false;
        }

        return estado;
    }
    public static void main(String[] args) {
                      
   


    }

}
