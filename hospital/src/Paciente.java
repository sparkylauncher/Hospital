/**
 * 
 * @author Diego Camargo
 * 
 */

public class Paciente
{
	/** Clase que contiene la informacion y los metodos relacionados con los pacientes normales
	 * 
	 * @param numpaciente	variable autoincremental usada para designar un nuevo id en creacion
	 * @param id			id del paciente
	 * @param nombre		nombre del paciente
	 */
    private static int numpaciente =0;
    private int id;
    private String nombre;

    
    /**Constructor del paciente
     * 
     * @param nombre		nombre del paciente
     */
    public Paciente(String nombre)
    {
        this.nombre = nombre;
        numpaciente++;
        this.id = numpaciente;
    }
    
    /** Metodo toString que genera la cadena a partir del paciente
     *
     * 
     */
    @Override
    public String toString(){
        return id +":"+nombre;
    }    

    /** Metodo getter para obtener el id del paciente
     * 
     * @return		el id del paciente
     */
    public int getId() {
    	return this.id;
    }
    
    /** Metodo getter para obtener el nombre del paciente
     * 
     * @return 		el nombre del paciente
     */
    public String getNombre() {
    	return this.nombre;
    }
    
}
