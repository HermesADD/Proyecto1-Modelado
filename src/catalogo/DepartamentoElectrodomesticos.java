package catalogo;

/**
 * Clase que simula el departamento de electrodomesticos
 * 
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public class DepartamentoElectrodomesticos extends Departamento {

    /**
     * Constructor del departamento de electrodomesticos
     * @param nombre nombre del departamento
     */
    public DepartamentoElectrodomesticos() {
        super("Electrodomesticos");
        agregarProducto();
    }

    /**
     * Metodo que agrega productos al departamento
     */
    public void agregarProducto(){
        Producto producto1 = new Producto("Freidora", 20001, 2700);
        Producto producto2 = new Producto("Lavadora", 20002, 5000);
        Producto producto3 = new Producto("Estufa", 20003, 3500);
        Producto producto4 = new Producto("Microondas", 20004, 2500);
        Producto producto5 = new Producto("Horno", 20005, 3000);
        Producto producto6 = new Producto("Cafetera", 20006, 1700);

        this.agregarProducto(producto1);
        this.agregarProducto(producto2);
        this.agregarProducto(producto3);
        this.agregarProducto(producto4);
        this.agregarProducto(producto5);
        this.agregarProducto(producto6);
    }
    
}
