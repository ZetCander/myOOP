package library;

import java.io.IOException;
import java.sql.SQLException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

public class main2 {
    
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException, SQLException {

        library lib1 = new library();
//        dataxml dat1 = new dataxml();
//        dat1.read("old.xml", lib1);
//        dat1.write("new.xml", lib1);
        datasql dat1 = new datasql();
        dat1.read("old.sqlite", lib1);
        dat1.write("new.sqlite", lib1);
        
        for (String s:lib1.getBibliostrs()) {
            System.out.println(s);
        }
    }
    
}
