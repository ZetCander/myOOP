package library;

import java.util.ArrayList;

public class bookListEdit extends generalListEdit {
    protected ArrayList<book> list;
    
    void newRec(Integer code, String name, String img, publ publ, Integer year, Integer pages) {
        this.appendList(new book(code, name, img, publ, year, pages));
    }
    
    void setImg(Integer code, String value) {
        this.findByCode(code).setImg(value);
    }
    
    void setPubl(Integer code, publ value) {
        this.findByCode(code).setPubl(value);
    }
    
    void setPages(Integer code, Integer value) {
        this.findByCode(code).setPages(value);
    }
    
    void setYear(Integer code, Integer value) {
        this.findByCode(code).setYear(value);
    }
    
    void appendAuthor(Integer code, author value) {
        this.findByCode(code).appendAuthor(value);
    }
    
    void removeAuthor(Integer bcode, Integer acode) {
        this.findByCode(bcode).removeAuthor(acode);
    }
    
    void clearAuthors(Integer code) {
        this.findByCode(code).clearAuthors();
    }
    
    String getImg(Integer code) {
        return this.findByCode(code).getImg();
    }
    
    Integer getPublCode(Integer code) {
        return this.findByCode(code).getPublCode();
    }
    
    String getPublName(Integer code) {
        return this.findByCode(code).getPublName();
    }
    
    String getPublShortname(Integer code) {
        return this.findByCode(code).getPublShortname();
    }

    Integer getPages(Integer code) {
        return this.findByCode(code).getPages();
    }
    
    Integer getYear(Integer code) {
        return this.findByCode(code).getYear();
    }
    
    String getAuthorSurname(Integer bcode, Integer acode) {
        return this.findByCode(bcode).getAuthorSurname(acode);
    }
    
    String getAuthorName(Integer bcode, Integer acode) {
        return this.findByCode(bcode).getAuthorName(acode);
    }
    
    String getAuthorSecname(Integer bcode, Integer acode) {
        return this.findByCode(bcode).getAuthorSecname(acode);
    }
    
    String getAuthorShortname(Integer bcode, Integer acode) {
        return this.findByCode(bcode).getAuthorShortname(acode);
    }
    
    String getAuthorShortsecname(Integer bcode, Integer acode) {
        return this.findByCode(bcode).getAuthorShortsecname(acode);
    }
    
    ArrayList<Integer> getAuthorCodes(Integer code) {
        return this.findByCode(code).getAuthorCodes();
    }
    
    String getAuthorsBibliostr(Integer code) {
        return this.findByCode(code).getAuthorsBibliostr();
    }
    
    String getBibliostr(Integer code) {
        return this.findByCode(code).getBibliostr();
    }
    
    void newRec(Integer code, String name, String img, publ publ, Integer year) {
        this.newRec(code, name, img, publ, year, 0);
    }
    
    void newRec(Integer code, String name, String img, publ publ) {
        this.newRec(code, name, img, publ, 0, 0);
    }
    
    void newRec(Integer code, String name, String img) {
        this.newRec(code, name, img, null, 0, 0);
    }
    
    void newRec(Integer code, String name) {
        this.newRec(code, name, "", null, 0, 0);
    }
    
    void newRec(Integer code) {
        this.newRec(code, "", "", null, 0, 0);
    }
    
    void newRec() {
        this.newRec(0, "", "", null, 0, 0);
    }
}
