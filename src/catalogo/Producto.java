package catalogo;

/**
 * Clase que simula un producto de la tienda
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public class Producto extends ComponenteCatalogo{

    /**
     * Nombre del producto
     */
    private String nombre;

    /**
     * Codigo de Barras del producto
     */
    private int codigoBarras;

    /**
     * Precio del producto
     */
    private double precio;

    /**
     * Departamento al que pertenece
     */
    private Departamento departamento;

    /**
     * Constructor de producto
     * @param nombre nombre del producto
     * @param codigoBarras codigo de barras del producto
     * @param precio precio del producto
     */
    public Producto(String nombre, int codigoBarras, double precio) {
        this.nombre = nombre;
        this.codigoBarras = codigoBarras;
        this.precio = precio;
    }

    /**
     * Metodo que regresa el nombre del producto
     * @return nombre del producto
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Metodo que regresa el codigo de barras del producto
     * @return codigo de barras del producto
     */
    public int getCodigoBarras(){
        return codigoBarras;
    }

    /**
     * Metodo que regresa el precio del producto
     * @return precio del producto
     */
    public double getPrecio(){
        return precio;
    }

    /**
     * Metodo que regresa el nombre del departamento donde pertenece el producto
     * @return nombre de departamento
     */
    public String getNombreDepartamento(){
        return departamento.getNombre();
    }

    /**
     * Metodo que cambia el deparmento del producto
     * @param departamento nuevo departamento
     */
    public void setDepartamento(Departamento departamento){
        this.departamento = departamento;
    }

    @Override
    public String informacion(){
        return getCodigoBarras() + " - " + getNombre() + ", $" + getPrecio();
    }





    
}
