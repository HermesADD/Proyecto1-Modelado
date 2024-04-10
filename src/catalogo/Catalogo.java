package catalogo;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * Clase que simula un catalogo utilizando el patron singleton
 * 
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public class Catalogo {

    /**
     * Lista de departamentos del catalogo
     */
    private static ArrayList<Departamento> listaDepartamentos = new ArrayList<>();

    /**
     * Unico catalogo
     */
    private static Catalogo unicoCatalogo;

    /**
     * Constructor del catalogo
     */
    private Catalogo(){
        Departamento alimentos = new DepartamentoAlimentos();
        Departamento electrodomesticos = new DepartamentoElectrodomesticos();
        Departamento electronica = new DepartamentoElectronica();
        agregarDepartamento(alimentos);
        agregarDepartamento(electrodomesticos);
        agregarDepartamento(electronica);
    }

    /**
     * Metodo que regresa la misma instancia del catalogo
     * @return unicoCatalogo, la unica instancia del catalogo
     */
    public static Catalogo getInstance(){
        if(unicoCatalogo == null){
            unicoCatalogo = new Catalogo();
        }
        return unicoCatalogo;
    }

    /**
     * Metodo que regresa la informacion del catalogo
     * @return informacion del catalago
     */
    public String informacion(){
        Iterator iterador = getIterador();
        String informacion = "*****CATALOGO*****\n\n";
        while (iterador.hasNext()) {
            Departamento d = (Departamento) iterador.next();
            informacion += d.informacion() + "\n";
        }
        return informacion;
    }

    /**
     * Metodo estatico que agrega departamento al catalogo
     * @param departamento departamento a agregar
     */
    private static void agregarDepartamento(Departamento departamento){
        listaDepartamentos.add(departamento);
    }

    /**
    * Crea un iterador de la lista de departamentos del catalogo
    *
    * @return Iterator de los departamentos
    */
    public Iterator getIterador(){
        return listaDepartamentos.iterator();
    }

    /**
    * Busca y devuelve un producto en el catalogo a partir
    * de su codigo de barras, en caso de no existir el codigo
    * en el catalogo, regresa null
    *
    * @param codigoBarras Codigo de barras del producto deseado
    *
    * @return Producto deseado o null en caso de no existir
    */
    public Producto getProducto(int codigoBarras){
        Iterator iteradorDepartamentos = getIterador();
        while (iteradorDepartamentos.hasNext()) {
            Departamento d = (Departamento) iteradorDepartamentos.next();
            Iterator iteradorProductos = d.getIterador();
            while (iteradorProductos.hasNext()) {
                Producto p = (Producto) iteradorProductos.next();
                if (codigoBarras == p.getCodigoBarras()) {
                    return p;
                }
            }
        }
        return null;
    }

}
