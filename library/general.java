package library;

import java.util.ArrayList;

public class general {
    protected Integer code;
    protected String name;
    
    // конструкторы, в java нет параметров по-умолчанию :(
    protected general(Integer code, String name) {
        this.setCode(code);
        this.setName(name);
    }
    
    protected general(Integer code) {
        this(code, "");
    }

    protected general() {
        this(0, "");
    }

    void setCode(Integer value) {
        this.code = value;
    }
    
    void setName(String value) {
        this.name = value;
    }
    
    Integer getCode() {
        return this.code;
    }
    
    String getName() {
        return this.name;
    }
    
    String getSurname() {
        return "";
    }
    
    String getSecname() {
        return "";
    }
    
    String getShortname() {
        return "";
    }
    
    String getShortsecname() {
        return "";
    }
    
    void setSurname(String value) {}
    void setSecname(String value) {}
    void setShortname(String value) {}
    void setShortsecname(String value) {}
    void setImg(String value) {}
    void setPubl(publ value) {} 
    void setPages(Integer value) {}
    void setYear(Integer value) {}
    void appendAuthor(author value) {}
    void removeAuthor(Integer code) {}
    void clearAuthors() {}
    String getImg() {return "";}
    Integer getPublCode() {return -1;}
    String getPublName() {return "";}
    String getPublShortname() {return "";}
    Integer getPages() {return 0;}
    Integer getYear() {return 0;}
    String getAuthorSurname(Integer code) {return "";}
    String getAuthorName(Integer code) {return "";}
    String getAuthorSecname(Integer code) {return "";}
    String getAuthorShortname(Integer code) {return "";}
    String getAuthorShortsecname(Integer code) {return "";}
    ArrayList<Integer> getAuthorCodes() {return new ArrayList<Integer>();}
    String getAuthorsBibliostr() {return "";}
    String getBibliostr() {return "";}
}
