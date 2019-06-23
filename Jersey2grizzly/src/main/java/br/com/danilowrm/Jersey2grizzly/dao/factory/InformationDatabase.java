/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.dao.factory;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author washington-muniz
 */
@Getter
@AllArgsConstructor
public class InformationDatabase {

    private String serverName;
    private int portNumber;
    private String databaseName;
    private String user;
    private String password;

}
