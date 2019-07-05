/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.service;

import br.com.danilowrm.Jersey2grizzly.dao.StudentDao;
import br.com.danilowrm.Jersey2grizzly.model.Student;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author washington-muniz
 */
@ApplicationScoped
public class StudentServiceImpl implements StudentService {

    @Inject
    StudentDao studentDao;

    @Override
    public Student getById(int id) {
        return this.studentDao.get(id).orElse(new Student());
    }

    @Override
    public List<Student> getAll() {
        return this.studentDao.getAll();
    }

    @Override
    public int add(Student Student) {
        Student = this.studentDao.add(Student);
        return Student.getId();
    }

    @Override
    public void update(Student student) {
        this.studentDao.update(student);
    }

    @Override
    public void delete(int id) {
        this.studentDao.delete(id);
    }

}
