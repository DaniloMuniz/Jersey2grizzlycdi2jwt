/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.util;

import br.com.danilowrm.Jersey2grizzly.dao.factory.ConnectionFactoryProducer;
import br.com.danilowrm.Jersey2grizzly.dao.factory.Database;
import br.com.danilowrm.Jersey2grizzly.dao.factory.InformationDatabase;
import java.sql.Connection;
import java.util.Optional;
import javax.enterprise.inject.Produces;

/**
 *
 * @author washington-muniz
 */
public class ConnectionUtil {

    private InformationDatabase informationDatabase;

    @Produces
    public Connection getConnection() {
        boolean enabledConnectionPooling = true;
        Database database = Database.from("mysql");
        informationDatabase = new InformationDatabase("127.0.0.1", 3306, "appws", "root", "RootMysql123@");
        Optional<Connection> connection = ConnectionFactoryProducer
                .getFactory(enabledConnectionPooling)
                .getConnection(database, informationDatabase);
        return connection.orElseThrow(() -> new RuntimeException("Error while trying to connect to database."));
    }

}
