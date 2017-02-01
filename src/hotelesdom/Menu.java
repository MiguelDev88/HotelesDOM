package hotelesdom;
import java.io.BufferedReader;
import java.io.IOException;


// @author Miguel

public class Menu {
    
    public static byte menuPrincipal (BufferedReader leer) throws IOException {
        
        byte op;
        
        System.out.println("Seleccione una opción:"
                + "\n1.Altas"
                + "\n2.Bajas"
                + "\n3.Modificaciones"
                + "\n4.Consultas"
                + "\n0.Finalizar");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
        
    }
    
    public static byte menuConsultas (BufferedReader leer) throws IOException {
        
        byte op;
        
        System.out.println("¿Qué desea consultar?"
                + "\n1.Listado de todos los hoteles registrados"
                + "\n2.Listado de hoteles con categoría 'superior' "
                + "\n0.Finalizar");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
        
    }
    
    public static byte menuConfirmar (BufferedReader leer) throws IOException {
        
        byte op;
        System.out.println("¿Seguro que desea eliminar este registro?"
                + "\n1.SI"
                + "\n2.NO");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
    }
    
    public static byte menuConfirmarModificacion (BufferedReader leer) throws IOException {
        
        byte op;
        System.out.println("¿Está conforme con los cambios?"
                + "\n1.SI"
                + "\n2.NO");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
    }

}
