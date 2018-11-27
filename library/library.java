package library;

import java.util.ArrayList;

public class library {
    protected authorListEdit authors;
    protected publListEdit publs;
    protected bookListEdit books;
    
    library() {
        this.authors = new authorListEdit();
        this.publs = new publListEdit();
        this.books = new bookListEdit();
    }
    
    void removeAuthor(Integer code) {
        this.authors.removeList(code);
        for(Integer c:this.books.getCodes()) {
            this.books.removeAuthor(c, code);
        }
    }
    
    void removePubl(Integer code) {
        this.publs.removeList(code);
        for(Integer c:this.books.getCodes()) {
            this.books.setPubl(c, null);
        }
    }
    
    void clear() {
        this.books.clear();
        this.publs.clear();
        this.authors.clear();
    }
    
    void newAuthor(Integer code, String surname, String name, String secname, String shortname, String shortsecname) {
        this.authors.newRec(code, surname, name, secname, shortname, shortsecname);
    }
    
    general findAuthorByCode(Integer code) {
        return this.authors.findByCode(code);
    }
    
    Integer getAuthorNewCode() {
        return this.authors.getNewCode();
    }
    
    ArrayList<Integer> getAuthorCodes() {
       return this.authors.getCodes();
    }
    
    String getAuthorName(Integer code) {
        return this.authors.getName(code);
    }
    
    String getAuthorSurname(Integer code) {
        return this.authors.getSurname(code);
    }
    
    String getAuthorSecname(Integer code) {
        return this.authors.getSecname(code);
    }
    
    String getAuthorShortname(Integer code) {
        return this.authors.getShortname(code);
    }
    
    String getAuthorShortsecname(Integer code) {
        return this.authors.getShortsecname(code);
    }
    
    String getAuthorBibliostr(Integer code) {
        return this.authors.getBibliostr(code);
    }
    
    void setAuthorName(Integer code, String value) {
        this.authors.setName(code, value);
    }
    
    void setAuthorSurname(Integer code, String value) {
        this.authors.setSurname(code, value);
    }
    
    void setAuthorSecname(Integer code, String value) {
        this.authors.setSecname(code, value);
    }
    
    void setAuthorShortname(Integer code, String value) {
        this.authors.setShortname(code, value);
    }
    
    void setAuthorShortsecname(Integer code, String value) {
        this.authors.setShortsecname(code, value);
    }
    
    void newPubl(Integer code, String name, String shortname) {
        this.publs.newRec(code, name, shortname);
    }
    
    general findPublByCode(Integer code) {
        return this.publs.findByCode(code);
    }
    
    Integer getPublNewCode() {
        return this.publs.getNewCode();
    }
    
    ArrayList<Integer> getPublCodes() {
        return this.publs.getCodes();
    }
    
    String getPublName(Integer code) {
        return this.publs.getName(code);
    }
    
    String getPublShortname(Integer code) {
        return this.publs.getShortname(code);
    }
    
    void setPublName(Integer code, String value) {
        this.publs.setName(code, value);
    }
    
    void setPublShortname(Integer code, String value) {
        this.publs.setShortname(code, value);
    }
    
    void removeBook(Integer code) {
        this.books.removeList(code);
    }
    
    void newBook(Integer code, String name, String img, publ publ, Integer year, Integer pages) {
        this.books.newRec(code, name, img, publ, year, pages);
    }
    
    general findBookByCode(Integer code) {
        return this.books.findByCode(code);
    }
    
    void appendBookAuthor(Integer bcode, author value) {
        this.books.appendAuthor(bcode, value);
    }
    
    void removeBookAuthor(Integer bcode, Integer acode) {
        this.books.removeAuthor(bcode, acode);
    }
    
    void clearBookAuthors(Integer bcode) {
        this.books.clearAuthors(bcode);
    }
    
    void setBookName (Integer code, String value) {
        this.books.setName(code, value);
    }
    
    void setBookImg (Integer code, String value) {
        this.books.setImg(code, value);
    }
    
    void setBookPubl(Integer code, Integer pcode) {
        this.books.setPubl(code, (publ)this.findPublByCode(pcode));
    }
    
    void setBookPages(Integer code, Integer value) {
        this.books.setPages(code, value);
    }
    
    void setBookYear(Integer code, Integer value) {
        this.books.setYear(code, value);
    }
    
    ArrayList<Integer> getBookCodes() {
        return this.books.getCodes();
    }
    
    Integer getBookNewCode() {
        return this.books.getNewCode();
    }
    
    String getBookName(Integer code) {
        return this.books.getName(code);
    }
    
    String getBookImg(Integer code) {
        return this.books.getImg(code);
    }
    
    Integer getBookPublCode(Integer code) {
        return this.books.getPublCode(code);
    }
    
    String getBookPublName(Integer code) {
        return this.books.getPublName(code);
    }
    
    String getBookPublShortname(Integer code) {
        return this.books.getPublShortname(code);
    }
    
    Integer getBookPages(Integer code) {
        return this.books.getPages(code);
    }
    
    Integer getBookYear(Integer code) {
        return this.books.getYear(code);
    }
    
    String getBookAuthorSurname(Integer bcode, Integer acode) {
        return this.books.getAuthorShortname(bcode, acode);
    }
    
    String getBookAuthorName(Integer bcode, Integer acode) {
        return this.books.getAuthorName(bcode, acode);
    }
    
    String getBookAuthorSecname(Integer bcode, Integer acode) {
        return this.books.getAuthorSecname(bcode, acode);
    }
    
    String getBookAuthorShortname(Integer bcode, Integer acode) {
        return this.books.getAuthorShortname(bcode, acode);
    }
    
    String getBookAuthorShortsecname(Integer bcode, Integer acode) {
        return this.books.getAuthorShortsecname(bcode, acode);
    }
    
    ArrayList<Integer> getBookAuthorCodes(Integer code) {
        return this.books.getAuthorCodes(code);
    }
    
    ArrayList<Integer> getAuthorCodes(Integer code) {
        return this.books.getAuthorCodes(code);
    }
    
    String getBookAuthorsBibliostr(Integer code) {
        return this.books.getAuthorsBibliostr(code);
    }
    
    ArrayList<String> getBibliostrs() {
        
        ArrayList<String> bibs = new ArrayList();
        
        for (Integer c:this.getBookCodes()) {
            bibs.add(this.getBookBibliostr(c));
        }
        
        return bibs;
    }
    
    String getBookBibliostr(Integer code) {
        return this.books.getBibliostr(code);
    }
    
    void newBook(Integer code, String name, String img, publ publ) {
        this.newBook(code, name, img, publ, 0, 0);
    }
    
    void newBook(Integer code, String name, String img) {
        this.newBook(code, name, img, null, 0, 0);
    }
    
    void newBook(Integer code, String name) {
        this.newBook(code, name, "", null, 0, 0);
    }
    
    void newBook(Integer code) {
        this.newBook(code, "", "", null, 0, 0);
    }
    
    void newBook() {
        this.newBook(0, "", "", null, 0, 0);
    }
    
    void newPubl(Integer code, String name) {
        this.newPubl(code, name, "");
    }
    
    void newPubl(Integer code) {
        this.newPubl(code, "", "");
    }
    
    void newPubl() {
        this.newPubl(0, "", "");
    }
    
    void newAuthor(Integer code, String surname, String name, String secname, String shortname) {
        this.newAuthor(code, surname, name, secname, shortname, "");
    }
    
    void newAuthor(Integer code, String surname, String name, String secname) {
        this.newAuthor(code, surname, name, secname, "", "");
    }
    
    void newAuthor(Integer code, String surname, String name) {
        this.newAuthor(code, surname, name, "", "", "");
    }
    
    void newAuthor(Integer code, String surname) {
        this.newAuthor(code, surname, "", "", "", "");
    }
    
    void newAuthor(Integer code) {
        this.newAuthor(code, "", "", "", "", "");
    }
    
    void newAuthor() {
        this.newAuthor(0, "", "", "", "", "");
    }
}
