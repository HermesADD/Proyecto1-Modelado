package cliente;

/**
 *  Clase que simula un cliente ademas se utiliza patron Observer
 * 
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */

public class Cliente implements ClienteInterfaz, Observador{

    /**
     * Nombre de usuario del cliente
     */
    private String nombreUsuario;

    /**
     * Contrasena del cliente
     */
    private String contrasena;

    /**
     * Nombre del cliente
     */
    private String nombre;

    /**
     * Telefono del cliente
     */
    private String telefono;

    /**
     * Direccion del cliente
     */
    private String direccion;

    /**
     * Cuenta de Banco del cliente
     */
    private String cuentaBanco;

    /**
     * Nacionalidad del cliente
     */
    private String nacionalidad;

    /**
     * Saldo en la cuenta del banco del cliente
     */
    private double saldo;


    /**
    * Cadena con la promocion que puede aprovechar el cliente
    */
    private String promocion;
    

    /**
     * Constructor del cliente
     * 
     * @param nombreUsuario Nombre de usuario del cliente
     * @param contrasena Contrasena del cliente
     * @param nombre Nombre del cliente
     * @param telefono Telefono del cliente
     * @param direccion Direccion del cliente
     * @param cuentaBanco Cuenta Bancaria del cliente
     * @param nacionalidad Nacionalidad del cliente
     * @param saldo Saldo en la cuenta de banco del cliente
     */
    public Cliente(String nombreUsuario, String contrasena, String nombre, String telefono, 
        String direccion, String cuentaBanco, String nacionalidad, double saldo) {

        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cuentaBanco = cuentaBanco;
        this.nacionalidad = nacionalidad;
        this.saldo = saldo;

    }

    /**
     * Metodo que confirma si en usuario y contrasena son correctos e iniciar sesion
     * 
     * @param nombreUsuario nombre de usuario del cliente
     * @param contrasena contrasena del cliente
     * @return true - si el nombre de usuario ingresado es el mismo que el del cliente y 
     *                la contrasena ingresada es igual a la del cliente
     *         false- si alguna de las dos es distinta o las dos distintas 
     */ 
    public boolean inicioSesion(String nombreUsuario, String contrasena){
        return nombreUsuario.equals(this.nombreUsuario) && contrasena.equals(this.contrasena);
    } 

    @Override
    public boolean compraSegura(String cuentaBanco) {
        return cuentaBanco.equals(this.cuentaBanco);
    }

    /**
     * Metodo que regresa el nombre del cliente
     * @return nombre del cliente
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Metodo que regresa el telefono del cliente
     * @return telefono del cliente
     */
    public String getTelefono(){
        return telefono;
    }

    /**
     * Metodo que regresa la direccion del cliente
     * @return direccion del cliente
     */
    public String getDireccion(){
        return direccion;
    }

    /**
     * Metodo que regresa la nacionalidad del cliente
     * @return nacionalidad del cliente
     */
    public String getNacionalidad(){
        return nacionalidad;
    }

    /**
     * Metodo que regresa el saldo de la cuenta de banco del cliente
     * @return saldo del cliente
     */
    public double getSaldo(){
        return saldo;
    }

    /**
     * Metodo que modifica el saldo de la cuenta de banco del cliente
     * @param saldo saldo nuevo
     */
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    /**
     * Metodo que regresa la promocion aplicada al cliente
     * @return promocion al cliente
     */
    public String getPromocion(){
        return promocion;
    }

    @Override
    public void actualizar(String mensaje){
        actualizarPromocion(mensaje);
    }

    /**
     * Metodo que actualiza la promocion del cliente
     * @param promocion nueva promocion al cliente
     */
    public void actualizarPromocion(String promocion){
        this.promocion = promocion;
    }
}
