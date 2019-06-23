/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.model;

import java.time.LocalDate;
import lombok.Data;

/**
 *
 * @author washington-muniz
 */
@Data
public class Book {

    private int id;
    private String name;
    private LocalDate publication;
    private Autor autor;
    private Category category;

    /**
     * method get safe autor id.
     *
     * @return return -1 if autor null, else id int.
     */
    public int getAutorId() {
        return (this.autor != null) ? this.autor.getId() : -1;
    }

    /**
     * method get safe category id.
     *
     * @return return -1 if category null, else id int.
     */
    public int getCategoryId() {
        return (this.category != null) ? this.category.getId() : -1;
    }
}
