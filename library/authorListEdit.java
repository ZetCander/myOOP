package library;

import java.util.ArrayList;

public class authorListEdit extends generalListEdit{
    protected ArrayList<author> list;
    private authorList authorList;
    
    
    void newRec(Integer code, String surname, String name, String secname, String shortname, String shortsecname) {
        this.appendList(new author(code, surname, name, secname, shortname, shortsecname));
    }
    
    void setSurname(Integer code, String value) {
        this.findByCode(code).setSurname(value);
    }
    
    String getSurname(Integer code) {
        return this.findByCode(code).getSurname();
    }
    
//  уже есть объявление в родительском классе  
//    void setName(Integer code, String value) {
//        this.findByCode(code).setName(value);
//    }
    
    void setSecname(Integer code, String value) {
        this.findByCode(code).setSecname(value);
    }
    
    String getSecname(Integer code) {
        return this.findByCode(code).getSecname();
    }
    
    void setShortname(Integer code, String value) {
        this.findByCode(code).setShortname(value);
    }
    
    String getShortname(Integer code) {
        return this.findByCode(code).getShortname();
    }
    
    void setShortsecname(Integer code, String value) {
        this.findByCode(code).setShortsecname(value);
    }
    
    String getShortsecname(Integer code) {
        return this.findByCode(code).getShortsecname();
    }
    
    String getBibliostr(Integer code) {
        return this.authorList.getBibliostr(code);
    }
    
    void newRec(Integer code, String surname, String name, String secname, String shortname) {
        this.newRec(code, surname, name, secname, shortname, "");
    }
    
    void newRec(Integer code, String surname, String name, String secname) {
        this.newRec(code, surname, name, secname, "", "");
    }
    
    void newRec(Integer code, String surname, String name) {
        this.newRec(code, surname, name, "", "", "");
    }
    
    void newRec(Integer code, String surname) {
        this.newRec(code, surname, "", "", "", "");
    }
    
    void newRec(Integer code) {
        this.newRec(code, "", "", "", "", "");
    }
    
    void newRec() {
        this.newRec(0, "", "", "", "", "");
    }
}
