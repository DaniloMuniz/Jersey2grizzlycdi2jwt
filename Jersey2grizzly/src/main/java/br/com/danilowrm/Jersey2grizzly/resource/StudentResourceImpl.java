/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.resource;

import br.com.danilowrm.Jersey2grizzly.model.Book;
import br.com.danilowrm.Jersey2grizzly.model.Student;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Response;

/**
 *
 * @author washington-muniz
 */
@RequestScoped
public class StudentResourceImpl implements StudentResource {

    @Override
    public Response get(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response create(Student student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response update(Integer id, Student student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
