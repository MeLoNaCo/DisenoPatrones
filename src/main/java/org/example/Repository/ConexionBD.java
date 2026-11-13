package org.example.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static Connection conexion;

    private ConexionBD(){}

    public static Connection getConexion() {
        try {
            if(conexion == null || conexion.isClosed()) {
                conexion = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/restaurante",
                        "postgres",
                        "200301"
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conexion;
    }
}