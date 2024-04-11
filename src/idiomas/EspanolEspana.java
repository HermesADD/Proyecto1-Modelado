package idiomas;

import java.util.Scanner;
import catalogo.*;
import cliente.*;
import colors.*;
import java.time.LocalDate;
import java.util.Random;

/**
 * Clase que muestra la ejecucion en el idioma espanol Espana
 *  
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */

public class EspanolEspana implements Idioma{

    @Override
    public void saludar() {
        Colors.println("Bienvenido a CheemsMart ti@!!", Colors.GREEN);
    }

    @Override
    public void menuInicial() {
        Colors.println("Selecciona una opcion porfavor"
                        + "\n1. Ver catalogo"
                        + "\n2. Hacer compra"
                        + "\n3. Cerrar sesion"
                        + "\n0. Salir de la tienda", Colors.CYAN);
    }

    @Override
    public void menuCompra() {
        Colors.println("Selecciona una opcion porfavor"
                        + "\n1. Agregar al carrito"
                        + "\n2. Pagar"
                        + "\n0. Cancelar compra", Colors.CYAN);
    }

    @Override
    public void agregarAlCarrito(ClienteProxy usuario) {
        if(usuario.getCarrito() != null){
            Colors.println("Ya hay un producto en el carrito, lo siento", Colors.RED);
            return ;
        }

        Scanner scn = new Scanner(System.in);
        Colors.println("Ingresa el codigo de barras del producto porfavor", Colors.CYAN);
        int codigoBarras;

        while(true){
            try{
                String opcion = scn.nextLine();
                codigoBarras = Integer.parseInt(opcion);
                break;
            }catch(NumberFormatException e){
                opcionInvalida();
                Colors.println("Ingresa el codigo de barras del producto porfavor", Colors.CYAN);
            }
        }

        Catalogo catalogo = Catalogo.getInstance();
        Producto compra = catalogo.getProducto(codigoBarras);

        if(compra == null){
            Colors.println("Producto no encontrado lo siento", Colors.RED);
            return ;
        }

        usuario.agregarAlCarrito(compra);
    }

    @Override
    public void compraSegura(ClienteProxy usuario) {
        Scanner scn = new Scanner(System.in);
        
        Colors.println("**** VERIFICACION****", Colors.BLINK);
        Colors.println("Para la verificacion y asegurar la compra, "
                        + "porfavor ingresa su numero de cuenta bancaria", Colors.CYAN);
        Colors.println("Solo teneis una oportunidad", Colors.HIGH_INTENSITY);
        
        String cuenta = scn.nextLine();
        
        if(!usuario.compraSegura(cuenta)){
            Colors.println("Error", Colors.RED);
            System.exit(1);
        }

        Colors.println("Transaccion exitosa, gracias!!", Colors.CYAN);
    }

    @Override
    public void fechaEntrega() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(2024, 4, 20).toEpochDay();
        int maxDay = (int) LocalDate.of(2024, 5, 30).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);

        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);

        Colors.println("Tu producto sera entregado el dia(Anio,Mes,Dia): " + randomDate , Colors.GREEN);
    }

    @Override
    public void despedirse() {
        Colors.println("Nos vemos, cuidate ti@!", Colors.GREEN);
    }

    @Override
    public void opcionInvalida() {
        Colors.println("Opcion invalida", Colors.RED);
    }

    @Override
    public void alerta(int opcion) {
        switch (opcion) {
            case 1:
                Colors.println("Solo puedes comprar un producto a la vez", Colors.RED);
                break;
            case 2:
                Colors.println("No has agregado nada al carrito ", Colors.RED);
                break;
            case 3:
                Colors.println("Borraremos tu carrito", Colors.RED);
                break;
            case 4:
                Colors.println("No teneis suficiente saldo", Colors.RED);
                break;
            default:
                break;
        }
    }

    @Override
    public String verSaldo(ClienteProxy usuario) {
        return "Ti@ " + usuario.getNombre() + ", tu saldo es de: $" + usuario.getSaldo(); 
    }

}
