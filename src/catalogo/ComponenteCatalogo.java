package catalogo;

import java.util.Iterator;

/**
 * Clase abstracta que representa un componente catalogo ademas se utliza el patron composite
 * 
 * @author Hermes 
 * @author Steve
 * @author Emiliano
 */
public abstract class ComponenteCatalogo {

    /**
     * Metodo que regresa la informacion del componente
     * @return informacion de componente
     */
    public String informacion(){
       throw new UnsupportedOperationException("Unimplemented method 'informacion'"); 
    }

    /**
     * Metrodo que agrega un producto al componente
     * @param producto Producto a agregar
     */
    public void agregarProducto(Producto producto){
        throw new UnsupportedOperationException("Unimplemented method 'agregarProducto'");
    }

    /**
     * Metodo que regresa un iterador de la lista de componentes
     * @return Iterador de componentes
     */
    public Iterator getIterador(){
        throw new UnsupportedOperationException("Unimplemented method 'getIterator'");
    }

}
