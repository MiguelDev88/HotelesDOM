package hotelesdom;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


// @author Miguel
 
public class XML {
    
    
    public static Document cargarXML () throws ParserConfigurationException, SAXException, IOException {
        
        File fichero = new File("hoteles.xml");
        Document documento;
        
        
        if(!fichero.exists()){
            //No Existe
            documento=DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            
            Element raiz = documento.createElement("listaHoteles");
            documento.appendChild(raiz);
        }
        
        else{
            //Si Existe
            documento=DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new FileInputStream(fichero)));
        }
    
        return documento;

    }
    
    public static void guardarXML (Document documento) {
        
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");            
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3"); 
            
            DOMSource origen = new DOMSource(documento);            
            StreamResult destino = new StreamResult("hoteles.xml");
                  
            transformer.transform(origen, destino);
     
        }
        catch(TransformerConfigurationException e){
            System.out.println("Error en la transformación:" + e.getMessage());
        }
        catch(TransformerException e){
            System.out.println("Error en la transformación:" + e.getMessage());            
        }
    }

}
