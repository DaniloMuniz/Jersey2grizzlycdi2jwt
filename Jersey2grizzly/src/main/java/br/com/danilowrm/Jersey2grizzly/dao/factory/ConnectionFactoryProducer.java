/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.dao.factory;

/**
 *
 * @author washington-muniz
 */
public class ConnectionFactoryProducer {

    public static AbstractFactoryConnectionDatabase getFactory(boolean connectionPooling) {
        if (connectionPooling) {
            return new ConnectionFactory();
        } else {
            return new ConnectionPoolFactory();
        }
    }
}
