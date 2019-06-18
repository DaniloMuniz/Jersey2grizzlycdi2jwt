/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.service;

import br.com.danilowrm.Jersey2grizzly.dto.ProductDTO;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author washington-muniz
 */
@Named
@ApplicationScoped
public class ProductServiceImpl implements ProductService {

    @Override
    public ProductDTO getById(Integer id) {
        return new ProductDTO(1, "ball");
    }

}
