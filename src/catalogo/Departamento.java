package catalogo;

import java.util.ArrayList;

import java.util.Iterator;

/**
 * Clase que simula un departemento(seccion) de la tienda
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public class Departamento extends ComponenteCatalogo{

    /**
     * Nombre del departamento
     */
    private String nombre;

    /**
     * Lista de productos en el departamento
     */
    private ArrayList<Producto> listaProductos;


    /**
     *  Constructor de departamento
     * @param nombre nombre del departamento
     */
    public Departamento(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que regresa el nombre del departamento
     * @return nombre del departamento
     */
    public String getNombre(){
        return nombre;
    }

    @Override
    public String informacion(){
        Iterator iterador = getIterador();
        String informacion = "*****" + getNombre() + "*****\n";
        while (iterador.hasNext()) {
            Producto p = (Producto) iterador.next();
            informacion += p.informacion() + "\n";
        }
        return informacion;
    }

    @Override
    public void agregarProducto(Producto producto){
        listaProductos.add(producto);
        producto.setDepartamento(this);
    }
    
    @Override
    public Iterator getIterador(){
        return listaProductos.iterator();
    }
    
}
