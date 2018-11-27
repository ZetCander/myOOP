package library;

//import library.general;

public class publ extends general {
    private String shortname;
    
    publ(Integer code, String name, String shortname) {
        super(code, name);   
        this.setShortname(shortname);
    }
    
    void setShortname(String value) {
        this.shortname = value;
    }
    
    String getShortname() {
        return this.shortname;
    }
}
