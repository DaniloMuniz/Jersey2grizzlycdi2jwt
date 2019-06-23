/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.service;

import br.com.danilowrm.Jersey2grizzly.model.Book;

/**
 *
 * @author washington-muniz
 */
public interface BookService {

    Book getById(Integer id);

}
