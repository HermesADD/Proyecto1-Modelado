package tienda;

import catalogo.*;
import cliente.*;
import colors.*;
import idiomas.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.net.*;
import java.io.*;

/**
 * Clase donde se hara todo el proceso de compra en la tienda, que utiliza el patron Observer
 * 
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public class CheemsMart  implements Sujeto{

    /**
     * Idioma de la tienda dependiendo de la nacionalidad del cliente
     */
    private Idioma idioma;

    /**
     * Lista de clientes de la tienda
     */
    private ArrayList<Cliente> clientes = new ArrayList<>();

    /**
     * Cliente con sesion iniciada
     */
    private ClienteProxy usuario;

    /**
     * Indica si hay oferta en Mexico
     */
    private boolean ofertaEnMexico = false;

    /**
     * Indica si hay oferta en Espana
     */
    private boolean ofertaEnEspana = false;

    /**
     * Indica si hay oferta en Estado Unidos
     */
    private boolean ofertaEnEUA = false;

    /**
     * Descuento que tendra el producto 
     * dependiendo del la nacionalidad 
     * del cliente
     */
    private int descuento = 0;
    
    public CheemsMart() {
        clientes.add(new Cliente("Hermes319B", "hermes", "Hermes Alberto", "55-2885-2875", "Calle 29 CDMX 26","MX39494JF","Mexico",29793.0,1));
        clientes.add(new Cliente("Steve318J", "steve", "Kevin Steve", "55-3692-1857", "Calle 17 EDOMEX 21","ES28946DM","Espana",32500.0,2));
        clientes.add(new Cliente("Emiliano320T", "emiliano", "Emiliano Sebastian", "67-1974-8357", "Street 29 California 20","EU85201KW","EUA",18900.0,3));
        generarOferta();
        ofertaNacional();
        notificar();
    }

    /**
     * Metodo que da la bienvenida al cliente en su idioma
     */
    public void saludar(){
        idioma.saludar();
        if(!"".equals(usuario.getPromocion())){
            Colors.println(usuario.getPromocion(), Colors.MAGENTA);
        }
    }

    /**
     * Metodo que muetra al cliente el menu inicial en su idioma
     */
    public void menuInicial(){
        idioma.menuInicial();
    }

    /**
     * Metodo que muestra el catalogo en idioma predeterminado(espanol) 
     */
    public void catalogo(){
        Catalogo catalogo = Catalogo.getInstance();
        Colors.println(catalogo.informacion(), Colors.BLUE);
        Colors.println(idioma.verSaldo(usuario), Colors.YELLOW);
    }

    /**
     * Metodo que muestra al cliente el menu de compra en su idioma
     */
    public void menuCompra(){
        idioma.menuCompra();
    }

    /**
     * Metodo que agrega el producto al carrito del cliente en su idioma 
     */
    public void agregarAlCarrito(){
        idioma.agregarAlCarrito(usuario);
    }

    /**
     * Metodo para que el cliente pague el producto en su idioma
     */
    public void pagar(){
        Producto produco = usuario.getCarrito();
        if(produco != null){
            double precio = produco.getPrecio();
            
            if(aplicaOferta()){
                precio = precio - (precio * (double) descuento /100);
            }

            if(usuario.getSaldo() < precio ){
                idioma.alerta(4);
                usuario.vaciarCarrito();
            }else{
                idioma.compraSegura(usuario);
                ticket();
                usuario.setSaldo(usuario.getSaldo()-precio);
                usuario.vaciarCarrito();
            }
        }else{
            idioma.alerta(2);
        }
    }

    /**
     * Metodo que imprime ticket de compra
     */
    public void ticket(){
        Producto producto = usuario.getCarrito();
        Colors.println("****TICKET****", Colors.BLUE);
        Colors.println(producto.getNombre() + "\t - \t" + producto.getPrecio(), Colors.BLUE);
        Colors.println("subtotal: $" +producto.getPrecio(),Colors.BLUE);
        if(aplicaOferta()){
            Colors.println(descuento + "% DESCUENTO", Colors.BLUE);
            Colors.println("Total: $" + (producto.getPrecio() - ((double) descuento / 100) * producto.getPrecio()), Colors.BLUE);
        }else{
            Colors.println("Total: $" + producto.getPrecio(),Colors.BLUE);
        }
        fechaEntrega();
    }

    /**
     * Metodo que indica la fecha de entrega
     */
    public void fechaEntrega(){
        idioma.fechaEntrega();
    }

    /**
     * Metodo que despide al usuario
     */
    public void despedirse(){
        idioma.despedirse();
    }

    /**
     * Metodo que indica si la opcion es invalida
     */
    public void opcionInvalida(){
        idioma.opcionInvalida();

    }

    @Override
    public void registrar(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void remover(Cliente cliente) {
        clientes.remove(cliente);
    }

    @Override
    public void notificar() {
        for(Cliente cliente : clientes){
            String mensaje = "";

            if("Mexico".equals(cliente.getNacionalidad()) && ofertaEnMexico){
                mensaje = "Tienes " + descuento + "% de descuento en el depantamento de alimentos";
            }else if("Espana".equals(cliente.getNacionalidad()) && ofertaEnEspana){
                mensaje = "Teneis  " + descuento + "% de descuento en el departamento de electrodomesticos";
            }else if("EUA".equals(cliente.getNacionalidad()) && ofertaEnEUA){
                mensaje = "You have " + descuento + "% OFF in electronic department";
            }
            cliente.actualizar(mensaje);
        }
    }

    /**
     * Metodo que inicia sesion en la tienda, si los datos son correctos
     * @param nombreUsuario nombre de usuario 
     * @param contrasena contrasena de usuario
     */
    public void iniciarSesion(String nombreUsuario, String contrasena){
        for(Cliente cliente : clientes){
            if(cliente.inicioSesion(nombreUsuario, contrasena)){
                usuario = new ClienteProxy(cliente);
                if("Mexico".equals(usuario.getNacionalidad())){
                    idioma = new EspanolMexico();
                }else if("Espana".equals(usuario.getNacionalidad())){
                    idioma =  new EspanolEspana();
                }else if("EUA".equals(usuario.getNacionalidad())){
                    idioma = new Ingles();
                }
                return ;
            }
        }
    }

    /**
     * Metodo que cierra sesion del usuario
     */
    public void cerrarSesion(){
        usuario = null;

    }

    /**
     * Metodo que indica si hay sesion iniciada
     * @return true - si hay sesion iniciada
     *         false - si no hay sesion iniciada
     */
    public boolean sesionIniciada(){
        return usuario != null;
    }

    /**
     * Metodo que genera una oferta random 
     */
    public void generarOferta(){
        Random random = new Random();
        int desc = random.nextInt(50);

        if(desc <= 20){
            descuento = 20;
        }else if(desc > 20 || desc <= 40){
            descuento = 30;
        }else{
            descuento = 40;
        }
    }

    /**
     * Metodo que selecciona que nacionalidades tienen oferta,
     * consiferando los 7 casos que pueden existir en combinacion de paises
     */
    public void ofertaNacional(){
        Random random = new Random();
        int combinacion = random.nextInt(7);

        switch(combinacion){
            case 0:
                ofertaEnMexico = true;
                break;
            case 1:
                ofertaEnEspana = true;
                break;
            case 2:
                ofertaEnEUA = true;
                break;
            case 3:
                ofertaEnMexico = true;
                ofertaEnEspana = true;
                break;
            case 4:
                ofertaEnMexico = true;
                ofertaEnEUA = true;
                break;
            case 5:
                ofertaEnEspana = true;
                ofertaEnEUA = true;
                break;
            case 6:
                ofertaEnMexico = true;
                ofertaEnEspana = true;
                ofertaEnEUA = true;
                break;
            default:
                break;                
        }
    }

    /**
     * Metodo que indica si se aplica oferta del producto al usuario
     * @return true - Si el usuario es de Mexico, tiene oferta y el producto es de alimentos
     *              - Si el usuario es de Espana, tiene oferta y el producto es de electrodomesticos
     *              - Si el usuario es de EUA, tiene oferta y el producto es de electronica
     *         false - Si no se cumplen los casos, o no hay producto en el carrito
     */
    public boolean aplicaOferta(){
        Producto producto = usuario.getCarrito();
        if(producto == null){
            return false;
        }else if("Mexico".equals(usuario.getNacionalidad()) 
                && ofertaEnMexico
                && "Alimentos".equals(producto.getNombreDepartamento())){
            return true;
        }else if("Espana".equals(usuario.getNacionalidad()) 
                && ofertaEnEspana
                && "Electrodomesticos".equals(producto.getNombreDepartamento())){
            return true;
        }else if("EUA".equals(usuario.getNacionalidad()) 
                && ofertaEnEUA
                && "Electronica".equals(producto.getNombreDepartamento())){
            return true;
        }
        return false;
    }

    /**
     * Metodo que borra(reinicia) el carrito del usuario
     */
    public void borrarCarrito(){
        Producto producto = usuario.getCarrito();
        if(producto != null){
            idioma.alerta(3);
            usuario.vaciarCarrito();
        }

    }
}
