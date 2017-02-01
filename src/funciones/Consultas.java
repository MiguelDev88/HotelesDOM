package funciones;
import hotelesdom.Menu;
import java.io.BufferedReader;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


// @author Miguel

public class Consultas {
    
    public static void consultas (Document documento, BufferedReader leer) throws IOException {
        
        byte op=1;
        
        
        while(op!=0){
            op=Menu.menuConsultas(leer);
            switch(op){
                case 1:
                    consultaTotalHoteles(documento);
                    break;
                case 2:
                    consultaCategoriaSuperior(documento);
                    break;
            }  
        } 
    }
    
    public static void consultaTotalHoteles (Document documento) {
        
        Element Ehotel;
        
        
        try {
            
            NodeList listaHoteles = documento.getElementsByTagName("hotel");
            
            for( int i = 0; i < listaHoteles.getLength(); i++ ){
                Ehotel = (Element)listaHoteles.item(i);   
                Visualizar.verHotel(Ehotel);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void consultaCategoriaSuperior (Document documento) {
        
        Element Ehotel;
        
        
        try {
            
            NodeList listaHoteles = documento.getElementsByTagName("hotel");
            
            for( int i = 0; i < listaHoteles.getLength(); i++ ){
                
                Ehotel = (Element)listaHoteles.item(i);
                if( Ehotel.getAttribute("categoría").compareToIgnoreCase("superior") ==0 ){
                    Visualizar.verHotel(Ehotel); 
                }
            }
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
