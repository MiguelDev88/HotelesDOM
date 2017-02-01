package funciones;

import org.w3c.dom.Element;


// @author Miguel

public class Visualizar {
    
    public static void verHotel (Element Ehotel) {  
        
        String id=Ehotel.getAttribute("ID");
        String categoria=Ehotel.getAttribute("categoría");
        String nombre=Ehotel.getElementsByTagName("nombre").item(0).getTextContent();
        String idioma=((Element)Ehotel.getElementsByTagName("nombre").item(0)).getAttribute("idioma");
        String poblacion=Ehotel.getElementsByTagName("poblacion").item(0).getTextContent();
        String precio=Ehotel.getElementsByTagName("precio").item(0).getTextContent();
        String cadena=Ehotel.getElementsByTagName("cadena").item(0).getTextContent();
        
        System.out.println("---------------------------");
        System.out.println("HOTEL: ");
        System.out.println("ID: "+id);
        System.out.println("Categoría: "+categoria);
        System.out.println("Idioma: "+idioma);
        System.out.println("Nombre: "+nombre);
        System.out.println("Población "+poblacion);
        System.out.println("Precio: "+precio);
        System.out.println("Cadena: "+cadena);
        System.out.println("---------------------------");
       
        
    }

}
