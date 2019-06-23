/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.dao.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Optional;
import org.postgresql.ds.PGPoolingDataSource;

/**
 *
 * @author washington-muniz
 */
public class PostgresqlConnectionDatabase implements IConnectionDatabase {

    @Override
    public Optional<Connection> connection(InformationDatabase informationDatabase) {
        Optional<Connection> connection = Optional.empty();
        try {
            //Class.forName("org.postgresql.Driver"); it is not necessary...
            connection = Optional.of(DriverManager.getConnection(
                    "jdbc:postgresql://" + informationDatabase.getServerName() + ":"
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
        PGPoolingDataSource dataSource = new PGPoolingDataSource();
        Optional<Connection> connection = Optional.empty();
        try {
            dataSource.setServerName(informationDatabase.getServerName());
            dataSource.setPortNumber(informationDatabase.getPortNumber());
            dataSource.setDatabaseName(informationDatabase.getDatabaseName());
            dataSource.setUser(informationDatabase.getUser());
            dataSource.setPassword(informationDatabase.getPassword());
            dataSource.setConnectTimeout(300);
            dataSource.setApplicationName("Jersey2grizzly");
            dataSource.setInitialConnections(1);
            dataSource.setMaxConnections(100);
            connection = Optional.of(dataSource.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;

    }

}
