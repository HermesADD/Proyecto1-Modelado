package cliente;

/**
 * Interfaz observador que sirve para actualizar la informacion que veran los clientes
 * 
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public interface Observador{

    /**
     * Actualiza la informacion que veran los clientes
     * 
     * @param mensaje Mensaje que se enviara al cliente
     */
    void actualizar(String mensaje); 

}