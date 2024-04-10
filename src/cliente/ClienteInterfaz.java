package cliente;

/**
 * Interfaz cliente
 * 
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public interface ClienteInterfaz{

    /**
     * Indica si los datos de la cuenta de banco son correctos
     * @param cuentaBanco Cuenta de banco
     * @return true - si los datos son correctos
     *         false - si no son correctos
     */
    boolean compraSegura(String cuentaBanco);

}