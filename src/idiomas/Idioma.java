package idiomas;

import cliente.ClienteProxy;

/**
 * Interface que servira para cambiar el idioma de la tienda,
 * dependiendo de la nacionalidad del cliente
 * 
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public interface Idioma{

    /**
     * Metodo que da el saludo de bienvenida
     */
    void saludar();

    /**
     * Metodo que muestra el menu inicial
     */
    void menuInicial();

    /**
     * Metodo que muestra el menu de compra
     */
    void menuCompra();

    /**
     * Metodo que agrega un producto al carrito del usuario a partir del codigo de barras
     * @param usuario  Usuario que agregara el producto a su carrito
     */
    void agregarAlCarrito(ClienteProxy usuario);

    /**
     * Metodo que muestra compra segura
     * @param usuario Usuario que quiere realizar la compra
     */
    void compraSegura(ClienteProxy usuario);

    /**
     * Metodo que muestra la fecha de entrega del producto
     */
    void fechaEntrega();

    /**
     * Metodo que da la despedid de la tienda
     */
    void despedirse();

    /**
     * Metodo que indica si la opcion ingresada es invalida
     */
    void opcionInvalida();
    
    /**
     * Metodo que indica una alerta de algo que no se puede realizar durante la ejecucion
     * @param opcion Tipo de alerta
     */
    void alerta(int opcion);

    /**
     * Metodo que indica el saldo del usuario
     * @param usuario Usuario que se le mostrara su saldo
     * @return Saldo del usuario
     */
    String verSaldo(ClienteProxy usuario);


}