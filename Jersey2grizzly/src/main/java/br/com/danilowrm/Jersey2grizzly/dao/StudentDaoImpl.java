/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.dao;

import br.com.danilowrm.Jersey2grizzly.model.Autor;
import br.com.danilowrm.Jersey2grizzly.model.Book;
import br.com.danilowrm.Jersey2grizzly.model.Category;
import br.com.danilowrm.Jersey2grizzly.model.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author washington-muniz
 */
public class StudentDaoImpl extends AbstractDao implements StudentDao {

    @Override
    public Optional<Student> get(int id) {
        Optional<Student> retornStudent = Optional.empty();
        String sql = "SELECT N04_Student.id,\n"
                + "    N04_Student.name,\n"
                + "    N04_Student.birthday,\n"
                + "    N04_Student.id_school as school_id,\n"
                + "    N03_School.name as school_name\n"
                + "FROM appws.N04_Student\n"
                + "left join appws.N03_School on\n"
                + "   N04_Student.id_school = N03_School.id;";
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Student Student = new Student();
                    Student.setId(rs.getInt("id"));
                    Student.setName(rs.getString("name"));
                    Student.setBirthday(rs.getObject("publication", LocalDate.class));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retornStudent;
    }

    @Override
    public List<Student> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student add(Student student
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Student student
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
