package funciones;
import hotelesdom.XML;
import java.io.BufferedReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


// @author Miguel
 
public class Altas {
    
    public static void altas (Document documento, BufferedReader leer) {
        
        Element Ehotel, Enombre, Epoblacion, Eprecio, Ecadena;
        String id;
        
        
        try {
            
            Ehotel = documento.createElement("hotel");
            
            System.out.println("Introducir ID del hotel:");
            id = leer.readLine();
            
            if( !comprobarExiste(documento, id) ){
          
                Ehotel.setAttribute("ID", id);
                //Ehotel.setIdAttribute("ID", true);

                System.out.println("Introducir categoría del hotel:");
                Ehotel.setAttribute("categoría", leer.readLine());

                System.out.println("Introducir nombre del hotel:");
                Enombre = documento.createElement("nombre");
                Enombre.setTextContent(leer.readLine());
                System.out.println("Introducir idioma del hotel:");
                Enombre.setAttribute("idioma", leer.readLine());
                Ehotel.appendChild(Enombre);

                System.out.println("Introducir población del hotel:");
                Epoblacion = documento.createElement("poblacion");
                Epoblacion.setTextContent(leer.readLine());
                Ehotel.appendChild(Epoblacion);

                System.out.println("Introducir precio del hotel:");
                Eprecio= documento.createElement("precio");
                Eprecio.setTextContent(leer.readLine());
                Ehotel.appendChild(Eprecio);

                System.out.println("Introducir cadena del hotel:");
                Ecadena= documento.createElement("cadena");
                Ecadena.setTextContent(leer.readLine());
                Ehotel.appendChild(Ecadena);

                documento.getFirstChild().appendChild(Ehotel);

                XML.guardarXML(documento);

                System.out.println("\n - Hotel Registrado - \n");
                
            }
            else
                System.out.println("- ID ya existente!!");
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
            
    }
    
    public static boolean comprobarExiste(Document documento, String id){
        
        NodeList listaHoteles = documento.getElementsByTagName("hotel");
        
        for( int i = 0; i < listaHoteles.getLength(); i++ ){
                
            Element Ehotel = (Element)listaHoteles.item(i);
            if( Ehotel.getAttribute("ID").compareToIgnoreCase(id) ==0 ){
                return true;
            }
        }
        
        return false;

    } 
}
