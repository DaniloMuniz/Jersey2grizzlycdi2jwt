/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.dao;

import br.com.danilowrm.Jersey2grizzly.model.Student;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author washington-muniz
 */
public interface StudentDao {

    Optional<Student> get(int id);

    List<Student> getAll();

    Student add(Student student);

    int update(Student student);

    int delete(int id);

}
