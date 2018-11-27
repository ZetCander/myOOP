package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class datasql {
    
    private final String emptydb = 
            "PRAGMA foreign_keys = ON; \n"
            + "create table author \n"
            + "(code integer primary key, \n"
            + "surname text, \n"
            + "name text, \n"
            + "secname text, \n"
            + "shortname text, \n"
            + "shortsecname text);"
            
            + "create table publ \n"
            + "(code integer primary key, \n"
            + "name text, \n"
            + "shortname text);"
            
            + "create table book \n"
            + "(code integer primary key, \n"
            + "name text, \n"
            + "img text, \n"
            + "year integer, \n"
            + "pages integer, \n"
            + "publ integer references publ(code) on update cascade on delete set null);"
            
            + "create table book_author \n"
            + "(code integer primary key autoincrement, \n"
            + "book integer references book(code) on update cascade on delete cascade, \n"
            + "author integer references author(code) on update cascade on delete cascade, \n"
            + "unique(book,author));";
    
    
    public void read(String inp, library lib) throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:sqlite:" + inp);
        Statement curs = conn.createStatement();

        ResultSet data = curs.executeQuery("select code, surname, name, secname, shortname, shortsecname from author"); 
        while(data.next()) {
            lib.newAuthor(data.getInt(0), data.getString(1), data.getString(2), data.getString(3), data.getString(4), data.getString(5));
        }
        
        data = curs.executeQuery("select code, name, shortname from publ"); 
        while(data.next()) {
            lib.newPubl(data.getInt(0), data.getString(1), data.getString(2));
        }

        data = curs.executeQuery("select code, name, img, year, pages, publ from book"); 
        while(data.next()) {
            lib.newBook(data.getInt(0), data.getString(1), data.getString(2), (publ)lib.findPublByCode(data.getInt(5)), data.getInt(3), data.getInt(4));
        }
        
        data = curs.executeQuery("select book, author from book_author"); 
        while(data.next()) {
            lib.appendBookAuthor(data.getInt(0), (author)lib.findAuthorByCode(data.getInt(1)));
        }
        data.close();
        curs.close();
        conn.close();
    }
    
    public void write(String out, library lib) throws SQLException {
        
        Connection conn = DriverManager.getConnection("jdbc:sqlite:" + out);
        Statement curs = conn.createStatement();
        
        curs.executeUpdate(this.emptydb);
        PreparedStatement insertStmt = null;
                
        for (Integer c:lib.getAuthorCodes()) {
            insertStmt = conn.prepareStatement("insert into author(code, surname, name, secname, shortname, shortsecname) "
                + "values(?, ?, ?, ?, ?, ?)");
            insertStmt.setString(1, c.toString());
            insertStmt.setString(2, lib.getAuthorSurname(c));
            insertStmt.setString(3, lib.getAuthorName(c));
            insertStmt.setString(4, lib.getAuthorSecname(c));
            insertStmt.setString(5, lib.getAuthorShortname(c));
            insertStmt.setString(6, lib.getAuthorShortsecname(c));
            insertStmt.execute();
        }
        
        for (Integer c:lib.getPublCodes()) {
            insertStmt = conn.prepareStatement("insert into publ(code, name, shortname) values(?, ?, ?)");
            insertStmt.setString(1, c.toString());
            insertStmt.setString(2, lib.getPublName(c));
            insertStmt.setString(3, lib.getPublShortname(c));
            insertStmt.execute();
        }

        for (Integer c:lib.getBookCodes()) {
            insertStmt = conn.prepareStatement("insert into book(code, name, img, year, pages, publ) values(?, ?, ?, ?, ?, ?)");
            insertStmt.setString(1, c.toString());
            insertStmt.setString(2, lib.getBookName(c));
            insertStmt.setString(3, lib.getBookImg(c));
            insertStmt.setString(4, lib.getBookYear(c).toString());
            insertStmt.setString(5, lib.getBookPages(c).toString());
            insertStmt.setString(6, lib.getBookPublCode(c).toString());
            insertStmt.execute();
            for (Integer ac:lib.getBookAuthorCodes(c)) {
                insertStmt = conn.prepareStatement("insert into book_author(book, author) values(?, ?)");
                insertStmt.setString(1, c.toString());
                insertStmt.setString(2, ac.toString());
                insertStmt.execute();
            }
        }
        insertStmt.close();
        curs.close();
        conn.close();
    }
}
