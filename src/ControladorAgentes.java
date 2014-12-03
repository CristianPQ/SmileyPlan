
/**
 * @author Daniel Villanueva 
 */
import java.util.*;
public class ControladorAgentes {
		private TST<Agente> Agentes;
		private int numAgentes; 
		
		private final static int BUFFER_SIZE = 3250; 
		private int CARGA_MAX = 250; 
		public String buffer = null; 
		
		private static Exception NombreYaExiste = new Exception ("El agente ya existe");
		private static Exception NoExiste = new Exception ("El agente no existe");
		private static Exception NoInicial = new Exception("No existe la ciudadInicial");
		private static Exception NoObjetivo = new Exception("No existe la ciudadInicial");
		private static Exception Iguales = new Exception("La ciudadInicial y la ciudadObjetivo deben ser distintas");

		/**
		 * Constructora del controlador
		 */

		public ControladorAgentes(){
			Agentes = new TST<Agente>();
			numAgentes = 0;
		}
		
		
	/**
	 * Vaciar todo el contenedor de agentes
	 */
		
		public void eliminarTodo(){ 
			Agentes.makeEmpty();
            numAgentes = 0;
		}


		/**
		 * Consulta la existencia o no de un agente
		 */
		
		public boolean existeAgente(String nombre){
			return Agentes.existe(nombre);
		}
		
		/**
		 * Anadir un agente AUX
		 * @param nombre nombre del agente que se quiere anadir
		 * @param ciudadInicial ciudad donde empieza el recorrido del agente
		 * @param ciudadObjetivo ciudad que quiere alcanzar el agente
		 * @throws Exception si ya existe agente con este nombre
		 */
		private void anadirAgenteInterna(String nombre, String ciudadInicial, String ciudadObjetivo) 
		throws Exception{
		if (!existeAgente(nombre)){//si no existe, Exception
			Agente a = new Agente(nombre, ciudadInicial, ciudadObjetivo);
			Agentes.insert(nombre,a);
			++numAgentes;
		}	
		else throw NombreYaExiste;	
	}
		
		/**
		 * Anadir un agente
		 * @param nombre nombre del agente que se quiere anadir
		 * @param ciudadInicial ciudad donde empieza el recorrido del agente
		 * @param ciudadObjetivo ciudad que quiere alcanzar el agente
		 * @param m controladorMapa para verificar que existen las ciudades
		 * @throws Exception si no existe una de las ciudades
		 */

		public void anadirAgente(String nombre, String ciudadInicial, String ciudadObjetivo,
				ControladorMapa m)
				throws Exception{ 
				if (ciudadInicial.equals(ciudadObjetivo)) throw Iguales;
				if(!m.existeCiudad(ciudadInicial)) throw NoInicial; //si no existe, saltara excepcion de ctrlmapa
				if(!m.existeCiudad(ciudadObjetivo)) throw NoObjetivo;//si no existe, saltara la excepcion de ctrlmapa
				anadirAgenteInterna(nombre, ciudadInicial,ciudadObjetivo);
		}
		
		/**
		 * Eliminar un agente
		 * @param nombre nombre del agente que se quiere eliminar
		 * @throws Exception si no existe el agente a eliminar
		 */
		
		public void eliminarAgente(String nombre) throws Exception{ 
		
			if (existeAgente(nombre)){//si no existe, Exception
				Agentes.delete(nombre);
				--numAgentes;
			}
			else throw NoExiste;

			}

		/**
		 * Consultora de la ciudadInicial de un agente
		 * @param nombre nombre del agente del que se quiere saber la ciudadInicial
		 * @reurn
		 * @throws Exception si no existe el agente solicitado
		 */
		
		public String consultarCiudadInicialAgente(String nombre) throws Exception{
			
			if (existeAgente(nombre)){//si no existe, Exception
				return Agentes.consultar(nombre).consultarCiudadInicial();
			}
			else throw NoExiste;
		}
		
		/**
		 * Consultora de la ciudadObjetivo de un agente
		 * @param nombre nombre del agente del que se quiere saber la ciudadObjetivo
		 * @throws Exception si no existe el agente solicitado
		 */
		
		public String consultarCiudadObjetivoAgente(String nombre) throws Exception{
			
			if (existeAgente(nombre)){//si no existe, Exception
				return Agentes.consultar(nombre).consultarCiudadObjetivo();
			}
			else throw NoExiste;	

		}
		
		/**
		 * Modificadora del nombre de un agente (si existe)
		 * @param nombreAntiguo nombre del agente al que se le quiere cambiar el nombre
		 * @param nombreNuevo nombre nuevo que se le quiere dar al agente
		 * @throws Exception si no existe el agente solicitado o si ya existe uno con el nuevo nombre
		 */
		
		public void modificarNombreAgente(String nombreAntiguo, String nombreNuevo)throws Exception{
			
			if (existeAgente(nombreAntiguo)){ //si no existe, Exception
				Agente a = Agentes.consultar(nombreAntiguo);
				a.modificarNombre(nombreNuevo);
				if (!existeAgente(nombreNuevo)) {
					Agentes.delete(nombreAntiguo);
					Agentes.insert(nombreNuevo,a);	
				}
				else throw NombreYaExiste;
			}
			else throw NoExiste;
			
		}

		
		/**
		 * Modificadora de la ciudadInicial de un agente
		 * @param nombre nombre del agente a modificar
		 * @param ciudadInicial nueva ciudadInicial
		 * @throws Exception si no existe el agente a modificar
		 */
        public void modificarCiudadInicialAgente(String nombre, String ciudadInicial)throws Exception{//NO CREO 8
	
			if (existeAgente(nombre)){ //si no existe, Exception
				Agente a = Agentes.consultar(nombre);
				if (ciudadInicial.equals(a.consultarCiudadObjetivo())) throw Iguales;
				a.modificarCiudadInicial(ciudadInicial);
				Agentes.modificar(nombre, a);
					//Agentes.delete(nombre);
					//Agentes.insert(nombre,a);	
			}
			else throw NoExiste;
			
		}

		
		/**
		 * Modificadora de la ciudadObjetivo de un agente
		 * @param nombre nombre del agente a modificar
    	 * @param ciudadObjetivo nueva ciudadObjetivo
    	 * @throws Exception si no existe el agente a modificar
		 */
		
        public void modificarCiudadObjetivoAgente(String nombre, String ciudadObjetivo)throws Exception{
	
			if (existeAgente(nombre)){//si no existe, Exception
				Agente a = Agentes.consultar(nombre);
				if (ciudadObjetivo.equals(a.consultarCiudadInicial())) throw Iguales;
				a.modificarCiudadObjetivo(ciudadObjetivo);
				Agentes.modificar(nombre, a);
					//Agentes.delete(nombre);
					//Agentes.insert(nombre,a);	
			}
			else throw NoExiste;
		}
        
		/**
		 * Consultora del numero de agentes contenidos
		 * @return el numero de agentes que hay
		 */
        
        public int getNumeroDeAgentes(){ 
		return numAgentes;
		}
        
		/** 
		 * Consultora de los nombres de los agentes
		 * @return Lista de String con los nombres de los agentes
		 */
        public ArrayList<String> consultarNombresAgentes()
        {
        	return Agentes.consultar();
        }
        

        
        public ArrayList<String> consultarAgentesOrigenObjetivo(String ciudadInicial, String ciudadObjetivo)
            	throws Exception{
            	ArrayList<String> nombres = consultarNombresAgentes();
            	for (int i = 0; i < nombres.size(); ++i){
            		if (!consultarCiudadInicialAgente(nombres.get(i)).equals(ciudadInicial) ||
            				!consultarCiudadObjetivoAgente(nombres.get(i)).equals(ciudadObjetivo)){
            					nombres.remove(nombres.get(i));
            					--i;
            				}
            			}
            		return nombres;
            }
        
        
        
        public int numeroAgentesOrigenObjetivo(String ciudadInicial, String ciudadObjetivo) throws Exception{
        	return consultarAgentesOrigenObjetivo(ciudadInicial, ciudadObjetivo).size();
        }
        
        public ArrayList<String[]> casosDiferentes() throws Exception{
        	ArrayList<String[]> retorno = new ArrayList <String[]>();
        	for (int i = 0; i < consultarNombresAgentes().size();++i) {
        		String[] caso = new String[2];
        		caso[0] = consultarCiudadInicialAgente(consultarNombresAgentes().get(i));
        		caso[1] = consultarCiudadObjetivoAgente(consultarNombresAgentes().get(i));
        		boolean existe = false;
        		for (int j = 0; j < retorno.size() && !existe; ++j ) {
        			String[] chequeo = retorno.get(j);
        			if (caso[0].equals(chequeo[0])&& caso[1].equals(chequeo[1])) existe = true;
        		}
        		if (!existe) retorno.add(caso);
        	}
        	return retorno;
        }
   //     public ArrayList<String, String> casosDiferentes(){
        	
        //}
        
        /**
    	 * Cargar agentes
    	 * @param path donde esta el archivo
    	 * @param file donde esta la informacion que queremos cargar
    	 * @throws Exception si el fichero esta vacio 
    	 */
    	public void Cargar(String path, String file) throws Exception{
    		
    		GestorDatos gd = new GestorDatos(path,file); 
    		
    		gd.createFile();
    		gd.openFile("read"); 
    		
    		int num = Integer.parseInt(gd.readLine()); 
    		
    		buffer = gd.readBuffer(num); 
    		if(buffer == null) throw new Exception("fichero vacio"); 
    		
    		String[] lineas = buffer.split("\n"); 
    		int i = 0; 
    		
    		if (num <= CARGA_MAX) {
    			while(i < num) {
    				String[] cortarstring = lineas[i].split(" "); 
    				String nombre = cortarstring[0];
    				String ci = cortarstring[1];
    				String co = cortarstring[2]; 
    				anadirAgenteInterna(nombre,ci,co); 
    				
    				/////////////per comprovar ////////////////
    				System.out.print(nombre + " "+ ci + " "+ co + "\n"); 
    				/////////////////////////////////////////////
    				i++; 
    			}
    		} 
    		else {
    			while(num >= CARGA_MAX) {
    				buffer = gd.readBuffer(CARGA_MAX); 
    				num = num - CARGA_MAX; 
    				while(i < CARGA_MAX) {
    					String[] cortarstring = lineas[i].split(" "); 
    					String nombre = cortarstring[0];
        				String ci = cortarstring[1];
        				String co = cortarstring[2]; 
        				anadirAgenteInterna(nombre,ci,co); 
        				
        				/////////////per comprovar ////////////////
        				System.out.print(nombre + " "+ ci + " "+ co + "\n"); 
        				/////////////////////////////////////////////
        				i++;  
    				}
    			}
    		}
    		gd.closeFile(); 
    	}
        
        
        
    	
    	/**
    	 * Guardar agentes
    	 * @param path donde vamos a guardar el arhivo
    	 * @param file donde vamos a guardar la informacion
    	 * @Exception al crear archivo 
    	 */
    	public void Guardar(String path, String file) throws Exception {
    		GestorDatos gd = new GestorDatos(path,file);
    		
    		gd.createFile(); 
    		gd.openFile("write"); 
    		
    		
    		ArrayList<String> lista = new ArrayList<String>();
    		lista = Agentes.consultar(); //obtenim un array ordenada amb els ident de TST
    		
    		String linea = Integer.toString(lista.size()) + "\n"; 
    		buffer = linea; 
    		
    		
    		
    		for(int i = 0; i < lista.size(); ++i){
    			String s = lista.get(i); 
    			linea = s + " " + consultarCiudadInicialAgente(s)+ " " + consultarCiudadObjetivoAgente(s); 
    			buffer = buffer + linea + "\n"; 
    			
    			if(buffer.length() > BUFFER_SIZE) {
    				gd.writeBuffer(buffer); 
    				buffer = null; 
    			}
    		}
    		
    		if(buffer != null) {
    			gd.writeBuffer(buffer);
    		}
    		
    		gd.closeFile(); 

    	}
    	
    	
      
		


}
