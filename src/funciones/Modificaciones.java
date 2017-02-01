package funciones;
import hotelesdom.Menu;
import hotelesdom.XML;
import java.io.BufferedReader;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


// @author Miguel

public class Modificaciones {
    
    public static void modificar (Document documento, BufferedReader leer) throws ParserConfigurationException, SAXException {
        
        Element Ehotel;
        String nombre;
        
        try {
            System.out.println("Introducir nombre del Hotel a eliminar:");
            nombre=leer.readLine();
            
            NodeList listaHoteles = documento.getElementsByTagName("hotel");
            
            for( int i = 0; i < listaHoteles.getLength(); i++ ){
                
                Ehotel = (Element)listaHoteles.item(i);
                if( Ehotel.getElementsByTagName("nombre").item(0).getTextContent().compareToIgnoreCase(nombre) == 0 ){
                    modificarHotel(Ehotel, documento, leer);
                    i=listaHoteles.getLength();
                }
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
            
    }
    
    public static void modificarHotel (Element Ehotel, Document documento, BufferedReader leer) throws IOException, ParserConfigurationException, SAXException {
        
        byte op=1,b;
        String categoria,precio;
        boolean guardar=false;
        
        
        while(op!=0){
            Visualizar.verHotel(Ehotel);
            
            System.out.println("¿Qué desea modificar?"
                    + "\n1.Categoría"
                    + "\n2.Precio"
                    + "\n0.Finalizar");
            op=Byte.parseByte(leer.readLine());

            switch(op){
                case 1:
                    System.out.println("Introduzca nueva categoría:");
                    categoria=leer.readLine();
                    System.out.println("NUEVA CATEGORÍA: "+categoria);
                    if( Menu.menuConfirmarModificacion(leer) == 1 ){ 
                        Ehotel.setAttribute("categoría", categoria);
                        guardar=true;
                    }
                    break;
                case 2:
                    System.out.println("Introduzca nuevo precio:");
                    precio=leer.readLine();
                    System.out.println("NUEVO PRECIO: "+precio);
                    if( Menu.menuConfirmarModificacion(leer) == 1 ) {
                        Ehotel.getElementsByTagName("precio").item(0).setTextContent(precio);
                        guardar=true;
                    }
                    break;
                case 0:
                    if(guardar==true){
                        documento.getFirstChild().replaceChild(Ehotel, Ehotel);
                        XML.guardarXML(documento);
                        System.out.println("\n - Hotel Modificado - \n");
                    }
                    else
                        System.out.println("\n - Cambios Descartados - \n");
                    break;
            }
        }
    }
    
}
