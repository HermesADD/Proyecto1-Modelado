package tienda;

import cliente.*;
import catalogo.*;
import idiomas.*;
import colors.*;
/**
 * Interfaz Sujeto para controlar la info que veran los usuarios
 * 
 * @author Hermes 
 * @author Steve
 * @author Emiliano
 */
public interface Sujeto {
    
    /**
     * Metodo que agrega usuarios a la lista correspondiente
     * @param cliente- usuario a agregar
     */
    void registrar(Cliente cliente);

    /**
     * Metodo que remueve usuario de la lista correspondiente
     * @param cliente usuario a remover
     */
    void remover(Cliente cliente);

    /**
     * Metodo que notifica a los usuarios cuando haya una actualizacion
     */
    void notificar();
}
