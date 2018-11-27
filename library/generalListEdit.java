package library;

public class generalListEdit extends generalList {
    
    Integer getNewCode() {
        Integer m = 0;
        for (Integer c:getCodes()) {
            if (c > m) {
                m = c;
            }
        }
        return m + 1;
    }
    
    void setName(Integer code, String value) {
        this.findByCode(code).setName(value);
    }
}
