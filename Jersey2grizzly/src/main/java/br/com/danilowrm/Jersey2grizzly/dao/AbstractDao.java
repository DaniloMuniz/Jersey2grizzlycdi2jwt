/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.dao;

import java.sql.Connection;
import javax.inject.Inject;

/**
 *
 * @author washington-muniz
 */
public class AbstractDao {

    @Inject
    private Connection connection;
}
