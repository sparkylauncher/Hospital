import java.util.Arrays;

/**
 * 
 * @author Diego Camargo
 * 
 */
public class Hospital
{ 
	/**Clase Hospital, implementa los metodos para operar con pacientes
	 * (ingresos,altas,busqueda, obtencion del paciente mas urgente)
	 * 
	 * @param tpacientes		tabla de pacientes del hospital
	 * @param cantPacientes		cantidad de pacientes actualmente en el hospital
	 */
    private Paciente tpacientes[];
    int cantPacientes;

    /**
     * Constructor del hospital
     * 
     * @param numpacientes		cantidad de pacientes maximos que se admiten en este hospital
     */
    public Hospital(int numpacientes)
    {
        tpacientes = new Paciente[numpacientes];
        cantPacientes=0;
    }

    /**
     *  Ingreso de un paciente al hospital
     * @param p					Paciente que realiza el ingreso al hospital
     * @return					true si el ingreso se realiza correctamente, falso en caso contrario
     * 							(el hospital está lleno)
     */
    public boolean ingreso(Paciente p)
    {
        if (tpacientes.length == cantPacientes)
        	return false;
        tpacientes[cantPacientes]=p;
        cantPacientes++;
        return true;
    }
    
    /** Alta del paciente - se borra de la tabla
     * 
     * @param id_paciente		id del paciente que se quiere dar de alta
     * @return					true si el alta se produce correctamente, false en caso contrario
     * 							(el paciente no se encuentra actualmente en el hospital)
     */
    public boolean alta ( int id_paciente){
    if (this.cantPacientes == 0) return false;
    //busco el paciente
     for(int i = 0; i < this.cantPacientes; i++) {
    	 if(this.tpacientes[i].getId() == id_paciente) {
    		 //si lo encuentro agrupo los pacientes para eliminar el hueco
    		 for (int j = i; j < this.cantPacientes; j++) {
    			 this.tpacientes[j] = this.tpacientes[j + 1];
    		 }
    		 //reduzco el numero de pacientes y pongo el hueco libre a null
    		 this.cantPacientes--;
    		 this.tpacientes[this.cantPacientes] = null;
    		 return true;
    	 }
     }
     return false;
    }    
    
    /** Devuelve el paciente con el identidador indicado o null si no existe
     * 
     * @param id				el id del paciente a buscar en el hospital
     * @return					el objeto paciente si lo ha encontrado, null en caso contrario
     */
    public Paciente buscar(int id){    	
    	if (this.cantPacientes == 0) return null;
        //busco el paciente
         for(int i = 0; i < this.cantPacientes; i++) {
        	 if(this.tpacientes[i].getId() == id) {
        		 return this.tpacientes[i];
        	 }
         }
         return null;
    }
    
    /** Imprime por consola la lista de pacientes ORDENADO POR NOMBRE de pacientes
     * 
     */
    public void listapacientes (){
    	if (this.cantPacientes == 0) return;
    	String nombres[] = new String[this.cantPacientes];
    	for (int i = 0; i < this.cantPacientes; i++) {
    		nombres[i] = this.tpacientes[i].getNombre();	
    	}
    	Arrays.sort(nombres,String.CASE_INSENSITIVE_ORDER);
    	System.out.println("Lista ordenada por nombre de pacientes:");
    	for (String nombre: nombres)
    		System.out.println(nombre);
     
    }    
       
    /** Devuelve el mas grave o el caso de paciente con la misma gravedad el
     *  que su identificador sea mas bajo.
     *  
     * @return El objeto paciente con la mayor gravedad y, en caso de empate, menor id
     */
    public Paciente pacienteMasUrgente(){
    	if (this.cantPacientes == 0) return null;
    	Paciente result = this.tpacientes[0];
    	int gravedad = Integer.MAX_VALUE;
    	int gravAux = Integer.MAX_VALUE;
    	if (this.tpacientes[0] instanceof PacienteGrave) {
    		gravedad = ((PacienteGrave) this.tpacientes[0]).getGravedad().ordinal();
    	}
    	for (int i = 1; i < this.cantPacientes; i++) {
        	if (this.tpacientes[i] instanceof PacienteGrave) {
        		gravAux = ((PacienteGrave) this.tpacientes[i]).getGravedad().ordinal();
        		if (gravAux < gravedad) {
        			if (gravedad == 0)
        				return this.tpacientes[i];
        			else
        				gravedad = gravAux;
        				result = this.tpacientes[i];
        		}		
        	}
    	}
    	return result;
    
        
    }    
}
