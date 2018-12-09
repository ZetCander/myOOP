package library;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.SAXException;


public class dataxml {

    public void read(String inp, library lib) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева.
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Запарсили XML, создав структуру Document. Теперь у нас есть доступ ко всем элементам, каким нам нужно.
        Document dom = builder.parse(new File(inp));
        
        for (Node node:XmlUtil.asList(dom.getDocumentElement().getChildNodes())) {
            if (node.getNodeType() == Node.ELEMENT_NODE && "author".equals(node.getNodeName())) {
                Integer code = 0;
                String surname = "", name = "", secname = "", shortname = "", shortsecname = "";
                for (int i = 0; i < node.getAttributes().getLength(); i++) {
                    Node t = node.getAttributes().item(i);
                    switch (t.getNodeName()) {
                        case "code": code = Integer.parseInt(t.getNodeValue());
                            break;
                        case "name": name = t.getNodeValue();
                            break;
                        case "surname": surname = t.getNodeValue();
                            break;
                        case "secname": secname = t.getNodeValue();
                            break;
                        case "shortname": shortname = t.getNodeValue();
                            break;
                        case "shortsecname": shortsecname = t.getNodeValue();
                            break;
                    }
                }
                lib.newAuthor(code, surname, name, secname, shortname, shortsecname);
            }
            
            if (node.getNodeType() == Node.ELEMENT_NODE && "publ".equals(node.getNodeName())) {
                Integer code = 0;
                String shortname = "", name = "";
                for (int i = 0; i < node.getAttributes().getLength(); i++) {
                    Node t = node.getAttributes().item(i);
                    switch (t.getNodeName()) {
                        case "code": code = Integer.parseInt(t.getNodeValue());
                            break;
                        case "name": name = t.getNodeValue();
                            break;
                        case "shortname": shortname = t.getNodeValue();
                            break;
                    }
                }
                lib.newPubl(code, name, shortname);
            }
            
            if (node.getNodeType() == Node.ELEMENT_NODE && "book".equals(node.getNodeName())) {
                Integer code = 0, year = 0, pages = 0;
                String name = "", img = "";
                publ publ = null;
                for (int i = 0; i < node.getAttributes().getLength(); i++) {
                    Node t = node.getAttributes().item(i);
                    switch (t.getNodeName()) {
                      case "code": code = Integer.parseInt(t.getNodeValue());
                            break;
                        case "name": name = t.getNodeValue();
                            break;
                        case "img": img = t.getNodeValue();
                            break;
                        case "year": year = Integer.parseInt(t.getNodeValue());
                            break;
                        case "pages": pages = Integer.parseInt(t.getNodeValue());
                            break;
                        case "publ": publ = (publ)lib.findPublByCode(Integer.parseInt(t.getNodeValue()));
                            break;
                    }
                }
                lib.newBook(code, name, img, publ, year, pages);
                for (Node n:XmlUtil.asList(node.getChildNodes())) {
                    if ("author".equals(n.getNodeName())) {
                        author author;
                        for (int j = 0; j < n.getAttributes().getLength(); j++) {
                            Node t = n.getAttributes().item(j);
                            if ("code".equals(t.getNodeName())) {
                                author = (author)lib.findAuthorByCode(Integer.parseInt(t.getNodeValue()));
                                lib.appendBookAuthor(code, author);
                            }
                        }
                    }
                }
            }
        }
    }
    
    void write(String out, library lib) throws ParserConfigurationException, TransformerConfigurationException, TransformerException {
        
        try{
            
            Document dom = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

            Element root = dom.createElement("library");
            dom.appendChild(root);

            for (Integer c:lib.getAuthorCodes()) {
                Element aut = dom.createElement("author");
                aut.setAttribute("code", c.toString());
                aut.setAttribute("surname", lib.getAuthorSurname(c));
                aut.setAttribute("name", lib.getAuthorName(c));
                aut.setAttribute("secname", lib.getAuthorSecname(c));
                aut.setAttribute("shortname", lib.getAuthorShortname(c));
                aut.setAttribute("shortsecname", lib.getAuthorShortsecname(c));
                root.appendChild(aut);
            }

            for (Integer c:lib.getPublCodes()) {
                Element pub = dom.createElement("publ");
                pub.setAttribute("code", c.toString());
                pub.setAttribute("name", lib.getPublName(c));
                pub.setAttribute("shortname", lib.getPublShortname(c));
                root.appendChild(pub);
            }

            for (Integer c:lib.getBookCodes()) {
                Element bk = dom.createElement("book");
                bk.setAttribute("code", c.toString());
                bk.setAttribute("name", lib.getBookName(c));
                bk.setAttribute("img", lib.getBookImg(c));
                bk.setAttribute("year", lib.getBookYear(c).toString());
                bk.setAttribute("pages", lib.getBookPages(c).toString());
                bk.setAttribute("publ", lib.getBookPublCode(c).toString());

                for (Integer ac:lib.getBookAuthorCodes(c)) {
                    Element aut = dom.createElement("author");
                    aut.setAttribute("code", ac.toString());
                    bk.appendChild(aut);
                }
                root.appendChild(bk);
            }

            // Сохранить текстовое представление XML документа в файл
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(dom);
            StreamResult result = new StreamResult(new File(out));
//            transformer.transform(source, result);
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
             
        } catch (ParserConfigurationException | TransformerConfigurationException ex) {
            Logger.getLogger(CreateXMLFileDOMExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(CreateXMLFileDOMExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
