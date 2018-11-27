package library;

public class authorList extends generalList{
    
    String getSurname(Integer code) {
        return this.findByCode(code).getSurname();
    }
    
    String getSecname(Integer code) {
        return this.findByCode(code).getSecname();
    }
    
    String getShortname(Integer code) {
        return this.findByCode(code).getShortname();
    }
    
    String getShortsecname(Integer code) {
        return this.findByCode(code).getShortsecname();
    }
    
    String getBibliostr(Integer code) {
        return this.findByCode(code).getBibliostr();
    }
    
    String getListBibliostr() {
        String s = "";
        
        for(Integer code:this.getCodes()) {
            s += this.getBibliostr(code) + ", ";
        }
        
        if (!s.isEmpty()) {
            s = s.substring(0, s.length() - 2);
        }
        return s;
    }
}
