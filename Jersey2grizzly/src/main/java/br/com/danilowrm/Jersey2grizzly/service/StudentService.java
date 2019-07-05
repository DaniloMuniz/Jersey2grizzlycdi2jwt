/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.service;

import br.com.danilowrm.Jersey2grizzly.model.Student;
import java.util.List;

/**
 *
 * @author washington-muniz
 */
public interface StudentService {

    Student getById(int id);

    List<Student> getAll();

    int add(Student student);

    void update(Student student);

    void delete(int id);

}
