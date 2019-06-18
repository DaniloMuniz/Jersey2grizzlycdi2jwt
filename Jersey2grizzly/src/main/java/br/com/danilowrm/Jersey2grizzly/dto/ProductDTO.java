/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.dto;

import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author washington-muniz
 */
@XmlRootElement
public class ProductDTO {

    private Integer id;
    private String name;

    public ProductDTO() {
    }

    public ProductDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductDTO{" + "id=" + id + ", name=" + name + '}';
    }

}
