import catalogo.*;
import cliente.*;
import colors.*;
import idiomas.*;
import tienda.*;
import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;

/** Clase principal para simular la tienda CheemsMart!!!
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public class Main {
    
    /**
     * Metodo main 
     */
    public static void main(String[] args) {

        CheemsMart cheemsMart = new CheemsMart();
        Scanner scn = new Scanner(System.in);

        int opcioninicial;

        do{
            //-----------------------------------------------
            while(!cheemsMart.sesionIniciada()){
                Colors.print("Usuario: ", Colors.MAGENTA);
                String usuario = scn.nextLine();
                Colors.print("Contrasena: ",Colors.MAGENTA);
                String contrasena = scn.nextLine();
                cheemsMart.iniciarSesion(usuario, contrasena);
                if(!cheemsMart.sesionIniciada()){
                    Colors.println("Usuario y/o contrasena incorrecta", Colors.RED);
                }
            }
            //------------------------------------------------
            cheemsMart.saludar();
            
            do{
                cheemsMart.menuInicial();
                while(true){
                    try{
                        String opcionUsuario1 = scn.nextLine();
                        opcioninicial = Integer.parseInt(opcionUsuario1);
                        break;
                    }catch(NumberFormatException e){
                        cheemsMart.opcionInvalida();
                        cheemsMart.menuInicial();
                    }
                }

                switch(opcioninicial){
                    case 1:
                        cheemsMart.catalogo();
                        break;
                    case 2:
                        int opcionCompra;
                        cheemsMart.catalogo();
                        do{
                            cheemsMart.menuCompra();
                            while(true){
                                try{
                                    String opcionUsuario2 = scn.nextLine();
                                    opcionCompra = Integer.parseInt(opcionUsuario2);
                                    break;
                                }catch(NumberFormatException e){
                                    cheemsMart.opcionInvalida();
                                    cheemsMart.menuCompra();
                                }
                            }
                            
                            //----------------------------
                            switch(opcionCompra){
                                case 1:
                                    cheemsMart.catalogo();
                                    cheemsMart.agregarAlCarrito();
                                    break;
                                case 2:
                                    cheemsMart.pagar();
                                    opcionCompra = 0;
                                    break;
                                case 0: 
                                    cheemsMart.borrarCarrito();
                                    break;
                                default:
                                    cheemsMart.opcionInvalida();
                                    break;
                            }
                        }while(opcionCompra != 0);
                        break;

                    case 3:
                        cheemsMart.cerrarSesion();
                        break;

                    case 0:
                        cheemsMart.cerrarSesion();
                        cheemsMart.despedirse();
                        break;
                    default:
                        cheemsMart.opcionInvalida();
                        break;
                }
            }while(opcioninicial !=0 && opcioninicial !=3);

        }while(opcioninicial !=0);
    
    }
}
