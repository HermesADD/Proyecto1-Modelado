package catalogo;

/**
 * Clase que simula el departamento de electronica
 * 
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public class DepartamentoElectronica extends Departamento {

    /**
     * Constructor del departamento de electronica
     * @param nombre nombre del departamento
     */
    public DepartamentoElectronica() {
        super("Electronica");
        agregarProducto();
    }

    /**
     * Metodo que agrega productos al departamento
     */
    public void agregarProducto(){
        Producto producto1 = new Producto("Laptop", 30001, 13000);
        Producto producto2 = new Producto("Celular", 30002, 8000);
        Producto producto3 = new Producto("TV", 30003, 9000);
        Producto producto4 = new Producto("Audifonos", 30004, 2500);
        Producto producto5 = new Producto("Bocina", 30005, 2000);
        Producto producto6 = new Producto("Tablet", 30006, 11500);

        this.agregarProducto(producto1);
        this.agregarProducto(producto2);
        this.agregarProducto(producto3);
        this.agregarProducto(producto4);
        this.agregarProducto(producto5);
        this.agregarProducto(producto6);
    }
}
