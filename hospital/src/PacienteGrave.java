/**
 * 
 * @author Diego Camargo
 *
 */

public class PacienteGrave extends Paciente
{
	/**Clase que contiene la informacion y los metodos relacionados con los pacientes de cierta gravedad
	 * 
	 * @param gravedad		gravedad actual del paciente
	 */
    private TipoGravedad gravedad; 

    /** Constructor del paciente grave
     * 
     * @param nombre		nombre del paciente
     * @param gravedad		gravedad del paciente
     */
    public PacienteGrave(String nombre, TipoGravedad gravedad)
    {
        super(nombre);
        this.gravedad = gravedad;
    }
    
    /**Metodo getter para obtener la gravedad del paciente
     * 
     * @return la gravedad del paciente
     */
    public TipoGravedad getGravedad() {
    	return this.gravedad;
    }

    /**Metodo toString que genera una cadena a partir de la info del paciente grave
     * 
     */
    @Override
    public String toString()
    {
        return super.toString() + " " + this.gravedad;
    }
}