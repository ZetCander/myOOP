package library;

import java.util.ArrayList;

public class book extends general{
    private publ publ;
    private String img;
    private Integer year;
    private Integer pages;
    private authorList authors;
    
    book(Integer code, String name, String img, publ publ, Integer year, Integer pages) {
        super(code, name);
        this.authors = new authorList();
        this.setImg(img);
        this.setPubl(publ);
        this.setPages(pages);
        this.setYear(year);
    }
    
    void setImg(String value) {
        this.img = value;
    } 
    
    void setPubl(publ value) {
        this.publ = value;
    }
    
    void setPages(Integer value) {
        this.pages = value;
    }
    
    void setYear(Integer value) {
        this.year = value;
    }
    
    String getImg() {
        return this.img;
    }
    
    Integer getPublCode() {
        if (this.publ != null) {
            return this.publ.getCode();
        }
        else {
            throw new NoClassDefFoundError("Need publ for object");
        }
    }
    
    String getPublName() {
        if (this.publ != null) {
            return this.publ.getName();
        }
        else {
            return "";
        }
    }
    
    String getPublShortName() {
        if (this.publ != null) {
            return this.publ.getShortname();
        }
        else {
            return "";
        }
    }
    
    Integer getPages() {
        return this.pages;
    }
    
    Integer getYear() {
        return this.year;
    }
    
    void appendAuthor(author value) {
        this.authors.appendList(value);
    }
    
    void removeAuthor(Integer code) {
        this.authors.removeList(code);
    }
    
    void clearAuthors() {
        this.authors.clear();
    }
    
    ArrayList<Integer> getAuthorCodes() {
        return this.authors.getCodes();
    }
    
    String getAuthorName(Integer code) {
        return this.authors.findByCode(code).getName();
    }
    
    String getAuthorSurname(Integer code) {
        return this.authors.findByCode(code).getSurname();
    }
    
    String getAuthorSecname(Integer code) {
        return this.authors.findByCode(code).getSecname();
    }
    
    String getAuthorShortname(Integer code) {
        return this.authors.findByCode(code).getShortname();
    }
    
    String getAuthorShortsecname(Integer code) {
        return this.authors.findByCode(code).getShortsecname();
    }
    
    String getAuthorsBibliostr() {
        return this.authors.getListBibliostr();
    }
    
    String getBibliostr() {
        String s = this.getAuthorsBibliostr();
        String spubl = "";
        
        if (this.publ != null) {
            spubl = this.getPublShortName();
        }
        
        s += " " + this.getName() + " - " + spubl + ", " + this.getYear().toString();
        s += ". - " + this.getPages().toString() + " c.";
        
        return s;
    }
    
    book(Integer code, String name, String img, publ publ, Integer year) {
        this(code, name, img, publ, year, 0);
    }
    
    book(Integer code, String name, String img, publ publ) {
        this(code, name, img, publ, 0, 0);
    }
    
    book(Integer code, String name, String img) {
        this(code, name, img, null, 0, 0);
    }
    
    book(Integer code, String name) {
        this(code, name, "", null, 0, 0);
    }
    
    book(Integer code) {
        this(code, "", "", null, 0, 0);
    }
    
    book() {
        this(0, "", "", null, 0, 0);
    }
}
