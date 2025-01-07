package es.juliogtrenard.listadopaises.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

/**
 * Clase para la conexion con la BBDD
 */
public class DBConnect {
    /**
     * La conexion
     */
    private final Connection connection;

    /**
     * Lanza la conexión
     *
     * @throws SQLException Controla errores de SQL
     */
    public DBConnect() throws SQLException {
        Properties configuracion = getConfiguration();

        Properties connConfig = new Properties();
        connConfig.setProperty("user", configuracion.getProperty("user"));
        connConfig.setProperty("password", configuracion.getProperty("password"));

        connection = DriverManager.getConnection("jdbc:mariadb://" + configuracion.getProperty("address") + ":" + configuracion.getProperty("port") + "/" + configuracion.getProperty("database") + "?serverTimezone=Europe/Madrid", connConfig);
        connection.setAutoCommit(true);
        DatabaseMetaData databaseMetaData = connection.getMetaData();

        connection.setAutoCommit(true);
    }

    /**
     * Obtiene la configuración para la conexión a la base de datos
     *
     * @return objeto Properties con los datos de conexión a la base de datos
     */
    public static Properties getConfiguration() {
        HashMap<String,String> map = new HashMap<String,String>();
        File f = new File("configuration.properties");
        Properties properties;
        try {
            FileInputStream configFileReader=new FileInputStream(f);
            properties = new Properties();
            try {
                properties.load(configFileReader);
                configFileReader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("configuration.properties not found at config file path " + f.getPath());
        }
        return properties;
    }

    /**
     * Devuelve la conexión creada
     *
     * @return una conexión a la BBDD
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Cierra la conexion con la base de datos
     *
     * @return La conexión cerrada.
     * @throws SQLException Se lanza en caso de errores de SQL al cerrar la conexión.
     */
    public Connection closeConnection() throws SQLException{
        connection.close();
        return connection;
    }
}