package funciones;
import hotelesdom.Menu;
import hotelesdom.XML;
import java.io.BufferedReader;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


// @author Miguel

public class Bajas {
    
    public static void bajas (Document documento, BufferedReader leer) {
        
        Element Ehotel;
        String nombre;
        
        try {
            System.out.println("Introducir nombre del Hotel a eliminar:");
            nombre=leer.readLine();
            
            NodeList listaHoteles = documento.getElementsByTagName("hotel");
            
            for( int i = 0; i < listaHoteles.getLength(); i++ ){
                
                Ehotel = (Element)listaHoteles.item(i);
                
                if( Ehotel.getElementsByTagName("nombre").item(0).getTextContent().compareToIgnoreCase(nombre) == 0 ){
                    
                    Visualizar.verHotel(Ehotel);
                    
                    if(Menu.menuConfirmar(leer)==1){
                        documento.getFirstChild().removeChild(Ehotel);
                        XML.guardarXML(documento);
                        System.out.println("\n - Hotel Eliminado - \n");
                        i=listaHoteles.getLength();
                    }
                }
            }
        
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
            
    }

}
