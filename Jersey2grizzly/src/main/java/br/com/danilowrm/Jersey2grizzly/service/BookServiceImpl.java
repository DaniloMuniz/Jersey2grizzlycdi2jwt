/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.service;

import br.com.danilowrm.Jersey2grizzly.model.Book;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author washington-muniz
 */
@Named
@ApplicationScoped
public class BookServiceImpl implements BookService {

    @Override
    public Book getById(Integer id) {
        return new Book();
    }

}
