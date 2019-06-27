/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.service;

import br.com.danilowrm.Jersey2grizzly.dao.BookDao;
import br.com.danilowrm.Jersey2grizzly.model.Book;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author washington-muniz
 */
@ApplicationScoped
public class BookServiceImpl implements BookService {

    @Inject
    BookDao bookDao;

    @Override
    public Book getById(int id) {
        return this.bookDao.get(id).orElse(new Book());
    }

    @Override
    public List<Book> getAll() {
        return this.bookDao.getAll();
    }

    @Override
    public int add(Book book) {
        book = this.bookDao.add(book);
        return book.getId();
    }

    @Override
    public void update(Book book) {
        this.bookDao.update(book);
    }

    @Override
    public void delete(int id) {
        this.bookDao.delete(id);
    }

}
