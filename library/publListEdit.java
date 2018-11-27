package library;

import java.util.ArrayList;

public class publListEdit extends generalListEdit{
    protected ArrayList<publ> list;
    
    void newRec(Integer code, String name, String shortname) {
        this.appendList(new publ(code, name, shortname));
    }
    
    String getShortname(Integer code) {
        return this.findByCode(code).getShortname();
    }
    
    void setShortname(Integer code, String value) {
        this.findByCode(code).setShortname(value);
    }
    
    void newRec(Integer code, String name) {
        this.newRec(code, name, "");
    }
    
    void newRec(Integer code) {
        this.newRec(code, "", "");
    }
    
    void newRec() {
        this.newRec(0, "", "");
    }
}
