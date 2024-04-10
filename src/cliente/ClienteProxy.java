package cliente;
import catalogo.*;

/**
 * Clase que simula clienteProxy(copia) aplicando el patron de diseno PROXY
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public class ClienteProxy implements ClienteInterfaz{

    /**
     * Cliente real
     */
    private Cliente cliente;

    /**
     * Carrito de compras donde solo se acepta un producto
     */
    private Producto carrito;
    
    /**
     * Constructor del clienteProxy
     * @param cliente Cliente al que se le aplicara la copia(respaldo)
     */
    public ClienteProxy(Cliente cliente){
        this.cliente = cliente;
    }

    @Override
    public boolean compraSegura(String cuentaBanco){
        return cliente.compraSegura(cuentaBanco);
    }

    /**
    * Agrega un producto al carrito del cliente
    *
    * @param producto Producto a agregar al carrito
    */
    public void agregarAlCarrito(Producto producto){
        this.carrito = producto;
    }

    /**
    * Devuelve el producto en el carrito de compra del cliente
    *
    * @return Único producto en el carrito
    */
    public Producto getCarrito(){
        return carrito;
    }

    /**
    * Vacia el carrito de compra, quita el producto
    */
    public void vaciarCarrito(){
        this.carrito = null;
    }

    /**
    * Devuelve el nombre del cliente
    *
    * @return Cadena con el nombre del cliente
    */
    public String getNombre(){
        return cliente.getNombre();
    }

    /**
    * Devuelve el teléfono del cliente
    *
    * @return Cadena con el teléfono del cliente
    */
    public String getTelefono(){
        return cliente.getTelefono();
    }

    /**
    * Devuelve la dirección del cliente
    *
    * @return Cadena con la dirección del cliente
    */
    public String getDireccion(){
        return cliente.getDireccion();
    }

    /**
    * Devuelve el país de origen del cliente
    *
    * @return Cadena con el país de origen del cliente
    */
    public String getNacionalidad(){
        return cliente.getNacionalidad();
    }

    /**
    * Devuelve el ID del cliente
    *
    * @return Long con el ID del cliente
    */
    public long getID(){
        return cliente.getID();
    }

    /**
     * Método para obtener el saldo del cliente
     *
     * @return saldo - Saldo del cliente
     */
    public double getSaldo(){
        return cliente.getSaldo();
    }

    /**
     * Método para cambiar el saldo del cliente
     *
     * @return saldo - Saldo del cliente
     */
    public void setSaldo(double saldo){
        cliente.setSaldo(saldo);
    }

    /**
    * Devuelve la promoción que aplica para el cliente
    *
    * @return Cadena con la promoción dirigida al cliente
    */
    public String getPromocion(){
        return cliente.getPromocion();
    }

}
