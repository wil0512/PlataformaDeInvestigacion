/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.umss.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.umss.model.Usuario;

/**
 *
 * @author wilson
 */
public class BD {

    Connection conection = null;
    Statement getStatement = null;
    PreparedStatement statement = null;
    ResultSet result = null;
    ResultSet userID = null;

    String url = "jdbc:postgresql://localhost:5432/seguridad";
    String user = "postgres";
    String password = "123";
    int id;

    public BD() throws SQLException {
        conection = DriverManager.getConnection(url, user, password);
    }

    public String getPid(String name, String pass) {
        try {
            getStatement = conection.createStatement();
            result = getStatement.executeQuery(String
                    .format("SELECT verificar_usuario('%s','%s')", name, pass));

            if (result.next()) {
                return result.getString(1);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(BD.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;
    }

    public Usuario getUsuario(String nickname, String password) {
        try {
            getStatement = conection.createStatement();
            result = getStatement.executeQuery(String
                    .format("SELECT * FROM user_2 WHERE nombre = %d AND password_2 = %d", nickname, password));

            if (result.next()) {//crear objeto usuario
                
                return null;
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(BD.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;
    }
}
