/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.dao;

import br.com.danilowrm.Jersey2grizzly.model.Autor;
import br.com.danilowrm.Jersey2grizzly.model.Book;
import br.com.danilowrm.Jersey2grizzly.model.Category;
import br.com.danilowrm.Jersey2grizzly.model.School;
import br.com.danilowrm.Jersey2grizzly.model.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author washington-muniz
 */
//@ApplicationScoped
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
                + "   N04_Student.id_school = N03_School.id\n"
                + "where N04_Student.id = ?";
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setBirthday(rs.getObject("birthday", LocalDate.class));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retornStudent;
    }

    @Override
    public List<Student> getAll() {
        List<Student> returnStudent = new ArrayList<>();
        String sql = "SELECT N04_Student.id,\n"
                + "    N04_Student.name,\n"
                + "    N04_Student.birthday,\n"
                + "    N04_Student.id_school as school_id,\n"
                + "    N03_School.name as school_name\n"
                + "FROM appws.N04_Student\n"
                + "left join appws.N03_School on\n"
                + "   N04_Student.id_school = N03_School.id";
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setBirthday(rs.getObject("birthday", LocalDate.class));

                    School school = new School();
                    school.setId(rs.getInt("school_id"));
                    school.setName(rs.getString("school_name"));
                    student.setSchool(school);
                    returnStudent.add(student);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnStudent;
    }

    @Override
    public Student add(Student student) {
        String sql = "INSERT INTO appws.N04_Student\n"
                + "(name,\n"
                + "birthday,\n"
                + "id_school)\n"
                + "VALUES\n"
                + "(?, -- name\n"
                + "?, -- birthday\n"
                + "? -- id_school\n"
                + ")";
        try (PreparedStatement ps = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, student.getName());
            ps.setObject(2, student.getBirthday());
            ps.setInt(3, student.getSchoolId());

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    student.setId(rs.getInt("id"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return student;
    }

    @Override
    public int update(Student student) {
        int rowNum = 0;
        String sql = "UPDATE appws.N04_Student\n"
                + "SET\n"
                + "name = ?, -- name,\n"
                + "birthday = ?,-- birthday\n"
                + "id_school = ?-- id_school\n"
                + "WHERE id = ?";
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setObject(2, student.getBirthday());
            ps.setInt(3, student.getSchoolId());
            rowNum = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowNum;
    }

    @Override
    public int delete(int id) {
        int rowNum = 0;
        String sql = "DELETE FROM appws.N04_Student\n"
                + "WHERE id = ?";

        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ps.setInt(1, id);

            rowNum = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowNum;
    }

}
