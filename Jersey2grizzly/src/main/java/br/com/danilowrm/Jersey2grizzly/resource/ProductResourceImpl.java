/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.resource;

import br.com.danilowrm.Jersey2grizzly.dto.ProductDTO;
import br.com.danilowrm.Jersey2grizzly.service.ProductService;
import java.net.URI;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author washington-muniz
 */
//@Named
//@RequestScoped
@Path("v1/products")
public class ProductResourceImpl implements ProductResource {

    @Inject
    ProductService productService;

    @Override
    public Response get(Integer id) {
        ProductDTO product = this.productService.getById(1);
        return Response.ok(product).build();
    }

    @Override
    public Response create() {
        URI location = URI.create("http://localhost:8080/api/v1/products/1");
        return Response.created(location).build();
    }

    @Override
    public Response update(String name) {
        return Response.ok().build();
    }

    @Override
    public Response delete() {
        return Response.noContent().build();
    }

}
