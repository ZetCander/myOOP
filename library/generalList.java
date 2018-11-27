package library;

import java.util.ArrayList;

public class generalList {
    protected ArrayList<general> list;
    
    generalList() {
        this.list = new ArrayList<>();
    }
    
    void clear() {
        this.list = new ArrayList<>();
    }
    
    general findByCode(Integer code) {
        
        for (general l:this.list) {
            if (l.getCode().intValue() == code.intValue()) {
                return l;
            }
        }
        
        return null;
    }
    
    ArrayList<Integer> getCodes() {
        ArrayList<Integer> ret = new ArrayList<>(); 
        for (general s:this.list) {
            ret.add(s.getCode());
        }
        
        return ret;
    }
    
    void appendList(general value) {
        this.list.add(value);
    }
    
    void removeList(Integer code) {
        for (general s:this.list) {
            if (s.getCode().intValue() == code.intValue()) {
                this.list.remove(s);
            }
        }
    }
    
    String getName(Integer code) {
        return this.findByCode(code).getName();
    }
}
