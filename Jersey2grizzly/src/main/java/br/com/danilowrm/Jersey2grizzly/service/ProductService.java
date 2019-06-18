/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.service;

import br.com.danilowrm.Jersey2grizzly.dto.ProductDTO;

/**
 *
 * @author washington-muniz
 */
public interface ProductService {

    ProductDTO getById(Integer id);

}
