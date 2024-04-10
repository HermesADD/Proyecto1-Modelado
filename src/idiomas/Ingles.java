package idiomas;

import java.util.Scanner;
import catalogo.*;
import cliente.*;
import colors.*;
import java.time.LocalDate;
import java.util.Random;

/**
 * Clase que muestra la ejecucion en el idioma ingles(americano)
 * 
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */

public class Ingles implements Idioma{

    @Override
    public void saludar() {
        Colors.println("Welcome to CheemsMart friend!!!", Colors.GREEN);
    }

    @Override
    public void menuInicial() {
        Colors.println("Please select an option"
                        + "\n1. See catalog"
                        + "\n2. Make purchase"
                        + "\n3. Log out"
                        + "\n0. Leave the store", Colors.CYAN);
    }

    @Override
    public void menuCompra() {
        Colors.println("Please select an option"
                        + "\n1. Add to cart"
                        + "\n2. Pay"
                        + "\n0. Cancel purchase", Colors.CYAN);
    }

    @Override
    public void agregarAlCarrito(ClienteProxy usuario) {
        if(usuario.getCarrito() != null){
            Colors.println("There is already a product in the cart, sorry ", Colors.RED);
            return ;
        }

        Scanner scn = new Scanner(System.in);
        Colors.println("Please enter the barcode of the product", Colors.CYAN);
        int codigoBarras;

        while(true){
            try{
                String opcion = scn.nextLine();
                codigoBarras = Integer.parseInt(opcion);
                break;
            }catch(NumberFormatException e){
                opcionInvalida();
                Colors.println("Please enter the barcode of the product", Colors.CYAN);
            }
        }

        Catalogo catalogo = Catalogo.getInstance();
        Producto compra = catalogo.getProducto(codigoBarras);

        if(compra == null){
            Colors.println("Product not found sorry", Colors.RED);
            return ;
        }

        usuario.agregarAlCarrito(compra);
    }

    @Override
    public void compraSegura(ClienteProxy usuario) {
        Scanner scn = new Scanner(System.in);
        
        Colors.println("**** VERIFICATION****", Colors.BLINK);
        Colors.println("For verification and secure purchase, "
                        + "please enter your bank account number", Colors.CYAN);
        Colors.println("You only have one chance", Colors.HIGH_INTENSITY);
        
        String cuenta = scn.nextLine();
        
        if(!usuario.compraSegura(cuenta)){
            Colors.println("Error", Colors.RED);
            System.exit(1);
        }

        Colors.println("Successful transaction, thank you!!", Colors.CYAN);
    }

    @Override
    public void fechaEntrega() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(2024, 4, 20).toEpochDay();
        int maxDay = (int) LocalDate.of(2024, 5, 30).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);

        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);

        Colors.println("Your product will be delivered on the day " + randomDate , Colors.GREEN);
    }

    @Override
    public void despedirse() {
        Colors.println("See you, take care friend!", Colors.GREEN);
    }

    @Override
    public void opcionInvalida() {
        Colors.println("Invalid option", Colors.RED);
    }

    @Override
    public void alerta(int opcion) {
        switch (opcion) {
            case 1:
                Colors.println("You can only purchase one product at a time", Colors.RED);
                break;
            case 2:
                Colors.println("You have not added anything to cart", Colors.RED);
                break;
            case 3:
                Colors.println("We will delete your cart", Colors.RED);
                break;
            case 4:
                Colors.println("You do not have enough balance", Colors.RED);
                break;
            default:
                break;
        }
    }

    @Override
    public String verSaldo(ClienteProxy usuario) {
        return "Friend" + usuario.getNombre() + ", your balance is: $" + usuario.getSaldo(); 
    }
    
}
