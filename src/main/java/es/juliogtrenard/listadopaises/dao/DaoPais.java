package es.juliogtrenard.listadopaises.dao;

import es.juliogtrenard.listadopaises.db.DBConnect;
import es.juliogtrenard.listadopaises.model.Pais;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Clase para manejar las operaciones con la base de datos de los paises
 */
public class DaoPais {
    /**
     * Carga los datos de la tabla País
     *
     * @return mapa de país para cargar en un informe
     */
    public static HashMap<String, Object> findAll() {
        DBConnect connection;
        HashMap<String, Object> paises = new HashMap<String, Object>();
        try {
            connection = new DBConnect();
            String consulta = "SELECT id,pais,capital,num_habitantes FROM pais";
            PreparedStatement pstmt = connection.getConnection().prepareStatement(consulta);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String pais_db = rs.getString("pais");
                String capital = rs.getString("capital");
                int num_habitantes = rs.getInt("num_habitantes");
                Pais pais = new Pais(id,pais_db,capital,num_habitantes);
                paises.put(id + "", pais);
            }
            rs.close();
            connection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paises;
    }
}