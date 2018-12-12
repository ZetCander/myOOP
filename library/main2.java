package library;

import java.io.IOException;
import java.sql.SQLException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

public class Main2 {
    
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException, SQLException {

        library lib1 = new library();
        dataxml dat1 = new dataxml();
        dat1.read("old.xml", lib1);
        dat1.write("new.xml", lib1);
		
		library lib2 = new library();
        datasql dat2 = new datasql();
        dat2.read("old.sqlite", lib2);
        dat2.write("new.sqlite", lib2);
		
		// datasql dat2 = new datasql();
		// dat2.dropTables("new.sqlite");
        
		//library lib3 = new library();
        //dataxml datXml = new dataxml();
        //datXml.read("old.xml", lib3);
		//datasql datSql = new datasql();
        //datSql.write("new.sqlite", lib3);
        
		
        for (String s:lib1.getBibliostrs()) {
			System.out.println(s);
        }
    }
    
}
