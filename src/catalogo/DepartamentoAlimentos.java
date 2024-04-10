package catalogo;

/**
 * Clase que simula el departamento de alimentos
 * 
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public class DepartamentoAlimentos extends Departamento {
 
    /**
     * Constructor del departamento de alimentos
     * @param nombre nombre del departamento
     */
    public DepartamentoAlimentos() {
        super("Alimentos");
        agregarProducto();
    }

    /**
     * Metodo que agrega productos al departamento
     */
    public void agregarProducto(){
        Producto producto1 = new Producto("Pan", 10001, 40);
        Producto producto2 = new Producto("Leche", 10002, 28);
        Producto producto3 = new Producto("Queso", 10003, 20);
        Producto producto4 = new Producto("Galletas", 10004, 30);
        Producto producto5 = new Producto("Jamon", 10005, 30);
        Producto producto6 = new Producto("Mayonesa", 10006, 25);

        this.agregarProducto(producto1);
        this.agregarProducto(producto2);
        this.agregarProducto(producto3);
        this.agregarProducto(producto4);
        this.agregarProducto(producto5);
        this.agregarProducto(producto6);
    }
}
