/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.dao;

import br.com.danilowrm.Jersey2grizzly.model.Book;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author washington-muniz
 */
public interface BookDao {

    Optional<Book> get(int id);

    List<Book> getAll();

    Book add(Book book);

    int update(Book book);

    int delete(int id);

}
