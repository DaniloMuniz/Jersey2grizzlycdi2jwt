/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.dao.factory;

import java.sql.Connection;
import java.util.Optional;

/**
 *
 * @author washington-muniz
 */
public abstract class AbstractFactoryConnectionDatabase {

    public abstract Optional<Connection> getConnection(Database database,
            InformationDatabase informationDatabase);
}
