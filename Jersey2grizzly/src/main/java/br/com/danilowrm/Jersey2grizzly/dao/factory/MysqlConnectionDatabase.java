/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.dao.factory;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Optional;
import javax.inject.Inject;

/**
 *
 * @author washington-muniz
 */
public class MysqlConnectionDatabase implements IConnectionDatabase {

    @Override
    public Optional<Connection> connection(InformationDatabase informationDatabase) {
        Optional<Connection> connection = Optional.empty();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = Optional.of(DriverManager.getConnection(
                    "jdbc:mysql://" + informationDatabase.getServerName() + ":"
                    + informationDatabase.getPortNumber() + "/"
                    + informationDatabase.getDatabaseName(),
                    informationDatabase.getServerName(),
                    informationDatabase.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public Optional<Connection> connectionPool(InformationDatabase informationDatabase) {
        MysqlDataSource dataSource = new MysqlDataSource();
        Optional<Connection> connection = Optional.empty();
        try {
            dataSource.setServerName(informationDatabase.getServerName());
            dataSource.setPortNumber(informationDatabase.getPortNumber());
            dataSource.setDatabaseName(informationDatabase.getDatabaseName());
            dataSource.setUser(informationDatabase.getUser());
            dataSource.setPassword(informationDatabase.getPassword());
            dataSource.setConnectTimeout(300);
            connection = Optional.of(dataSource.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

}
