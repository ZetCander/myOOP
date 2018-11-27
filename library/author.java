package library;

//import library.general;

public class author extends general{
    private String surname;
    private String secname;
    private String shortname;
    private String shortsecname;
    
    author(Integer code, String surname, String name, String secname, String shortname, String shortsecname) {
        super(code, name);
        this.setSurname(surname);
        this.setSecname(secname);
        this.setShortname(shortname);
        this.setShortsecname(shortsecname);
    }
    
    public void setSurname(String value) {
        this.surname = value;
    }
    
    public void setSecname(String value) {
        this.secname = value;
    }
    public void setShortname(String value) {
        this.shortname = value;
    }
    public void setShortsecname(String value) {
        this.shortsecname = value;
    }
    
    public String getSurname() {
        return this.surname;
    }
    
    public String getSecname() {
        return this.secname;
    }
    public String getShortname() {
        return this.shortname;
    }
    public String getShortsecname() {
        return this.shortsecname;
    }
    
    public String getBibliostr() {
        String s = this.getSurname();
        
        if (!this.getShortname().isEmpty()) {
            s += " " + this.getShortname() + ".";
        }
        if (!this.getShortsecname().isEmpty()) {
            s += " " + this.getShortsecname() + ".";
        }
        
        return s;
    }
    
    author(Integer code, String surname, String name, String secname, String shortname) {
        this(code, surname, name, secname, shortname, "");
    }
    
    author(Integer code, String surname, String name, String secname) {
        this(code, surname, name, secname, "", "");
    }
    
    author(Integer code, String surname, String name) {
        this(code, surname, name, "", "", "");
    }
    
    author(Integer code, String surname) {
        this(code, surname, "", "", "", "");
    }
    
    author(Integer code) {
        this(code, "", "", "", "", "");
    }
    
    author() {
        this(0, "", "", "", "", "");
    }
    
}
