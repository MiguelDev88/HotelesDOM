package hotelesdom;
import funciones.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.w3c.dom.Document;


// @author Miguel
 
public class HotelesDOM {

    public static void main(String[] args) {
        
        BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
        byte op;
        
        System.out.println("HOLA KE ASE");
        System.out.println("bien bien");
        try{
            Document documento  = XML.cargarXML();
            do{
                
                op=Menu.menuPrincipal(leer);
                switch(op){
                    case 1:
                        Altas.altas(documento, leer);
                        break;
                    case 2:
                        Bajas.bajas(documento, leer);
                        break;
                    case 3:
                        Modificaciones.modificar(documento, leer);
                        break;
                    case 4:
                        Consultas.consultas(documento, leer);
                        break;
                    case 0:
                        System.out.println("\n - FIN DEL PROGRAMA - \n");
                        System.exit(0);
                }
            
            }while(op!=0);
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
