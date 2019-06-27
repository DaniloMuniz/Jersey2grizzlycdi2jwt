/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.dao;

import br.com.danilowrm.Jersey2grizzly.model.Autor;
import br.com.danilowrm.Jersey2grizzly.model.Book;
import br.com.danilowrm.Jersey2grizzly.model.Category;
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
@ApplicationScoped
public class BookDaoImpl extends AbstractDao implements BookDao {

    public Optional<Book> get(int id) {
        Optional<Book> retornBook = Optional.empty();
        String sql = "SELECT N05_Book.id,\n"
                + "    N05_Book.name,\n"
                + "    N05_Book.publication,\n"
                + "    N05_Book.id_autor id_autor,\n"
                + "    N01_Autor.name  as autor_name,\n"
                + "    N05_Book.id_category as id_category,\n"
                + "    N02_Category.name as category_name\n"
                + "FROM appws.N05_Book\n"
                + "left join  appws.N01_Autor on \n"
                + "	N05_Book.id_autor = N01_Autor.id\n"
                + "left join  appws.N02_Category on \n"
                + "	N05_Book.id_category = N02_Category.id\n"
                + "where N05_Book.id = ?";
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Book book = new Book();
                    book.setId(rs.getInt("id"));
                    book.setName(rs.getString("name"));
                    book.setPublication(rs.getObject("publication", LocalDate.class));

                    Autor autor = new Autor();
                    autor.setId(rs.getInt("id_autor"));
                    autor.setName(rs.getString("autor_name"));
                    book.setAutor(autor);

                    Category category = new Category();
                    category.setId(rs.getInt("id_category"));
                    category.setName(rs.getString("category_name"));
                    book.setCategory(category);
                    retornBook = Optional.of(book);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retornBook;
    }

    public List<Book> getAll() {
        List<Book> returnBooks = new ArrayList<>();
        String sql = "SELECT N05_Book.id,\n"
                + "    N05_Book.name,\n"
                + "    N05_Book.publication,\n"
                + "    N05_Book.id_autor id_autor,\n"
                + "    N01_Autor.name  as autor_name,\n"
                + "    N05_Book.id_category as id_category,\n"
                + "    N02_Category.name as category_name\n"
                + "FROM appws.N05_Book\n"
                + "left join  appws.N01_Autor on \n"
                + "	N05_Book.id_autor = N01_Autor.id\n"
                + "left join  appws.N02_Category on \n"
                + "	N05_Book.id_category = N02_Category.id\n";
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Book book = new Book();
                    book.setId(rs.getInt("id"));
                    book.setName(rs.getString("name"));
                    book.setPublication(rs.getObject("publication", LocalDate.class));

                    Autor autor = new Autor();
                    autor.setId(rs.getInt("id_autor"));
                    autor.setName(rs.getString("autor_name"));
                    book.setAutor(autor);

                    Category category = new Category();
                    category.setId(rs.getInt("id_category"));
                    category.setName(rs.getString("category_name"));
                    book.setCategory(category);
                    returnBooks.add(book);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnBooks;
    }

    public Book add(Book book) {
        String sql = "INSERT INTO appws.N05_Book\n"
                + "(name,\n"
                + " publication,\n"
                + " id_autor,\n"
                + " id_category)\n"
                + "VALUES\n"
                + "(  ?,-- name\n"
                + "   ?,-- publication\n"
                + "   ?,-- id_autor\n"
                + "   ? -- id_category\n"
                + ")";
        try (PreparedStatement ps = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, book.getName());
            ps.setObject(2, book.getPublication());
            ps.setInt(3, book.getAutorId());
            ps.setInt(4, book.getCategoryId());

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    book.setId(rs.getInt("id"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return book;
    }

    public int update(Book book) {
        int rowNum = 0;
        String sql = "UPDATE appws.N05_Book\n"
                + "SET name = ?, -- name\n"
                + "publication = ?, -- publication\n"
                + "id_autor = ?, -- id_autor\n"
                + "id_category = ? -- id_category\n"
                + "WHERE id = ? -- id";

        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {

            ps.setString(1, book.getName());
            ps.setObject(2, book.getPublication());
            ps.setInt(3, book.getAutorId());
            ps.setInt(4, book.getCategoryId());
            ps.setInt(5, book.getId());

            rowNum = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowNum;
    }

    public int delete(int id) {
        int rowNum = 0;
        String sql = "DELETE FROM appws.N05_Book\n"
                + "WHERE id = ? -- id";

        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ps.setInt(1, id);

            rowNum = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowNum;
    }

}
