import java.util.*;

public class ConjuntoCaminos {

	private Map<String, ArrayList<camino>> Caminos = new HashMap<String, ArrayList<camino>>();
	
	//crear un camino con capacidad
	public void crearCaminoCapacidad(String ciudadOrigen, String ciudadDestino, int capacidad, medioTransporte transporte){
		ArrayList<camino> listAux = new ArrayList<camino>();  //creo una lista auxiliar para insertarle el camino 
		boolean existe = false; // booleno para comprovar si ya existe el camino
		if (Caminos.containsKey(ciudadOrigen)) { //primer miro si hi ha algun cami amb ciutatorigen
			camino auxCamino = new camino(ciudadOrigen,ciudadDestino, capacidad, transporte); 
			if (Camninos.get(ciudadOrigen).contains(auxCamino)){
				throw new Exception("El Camino ya existe");   
			}
			
			
			
			
			
			listAux = Caminos.get(ciudadOrigen);  //arraylist existente
			Iterator<camino> it = listAux.iterator();
			while (it.hasNext() && !existe){ //recorro els caminos per mira si ja existeix
				camino aux2Camino = it.next();
				if(aux2Camino.consultarDestino() == ciudadDestino && aux2Camino.consultarTransporte() == transporte){ 
					existe = true;
				}
			}
			if (!existe){
				camino auxCamino = new camino(ciudadOrigen,ciudadDestino, capacidad, transporte); //camino auxiliar
				listAux.add(auxCamino); //anado el camino creado en el auxiliar
				Caminos.put(ciudadOrigen, listAux); // subtituyo el array por el auxiliar que ya contiene el nuevo camino
			}
			
		}
		else{ //sino ja el puc crear
			camino auxCamino = new camino(ciudadOrigen,ciudadDestino, capacidad,transporte); //camino auxiliar
			listAux.add(auxCamino); //anado el camino creado en el auxiliar
			Caminos.put(ciudadOrigen, listAux); // subtituyo el array por el auxiliar que ya contiene el nuevo camino
		}
	}
	
	//crear un camino sin capcidad, 1 por defecto
	public void crearCamino(String ciudadOrigen, String ciudadDestino, medioTransporte transporte){
		ArrayList<camino> listAux = new ArrayList<camino>();  //creo una lista auxiliar para insertarle el camino 
		boolean existe = false; // booleno para comprovar si ya existe el camino
		if (Caminos.containsKey(ciudadOrigen)) { //primer miro si hi ha algun cami amb ciutatorigen
			listAux = Caminos.get(ciudadOrigen);  //arraylist existente
			Iterator<camino> it = listAux.iterator();
			while (it.hasNext() && !existe){ //recorro els caminos per mira si ja existeix
				camino aux2Camino = it.next();
				if(aux2Camino.consultarDestino() == ciudadDestino && aux2Camino.consultarTransporte() == transporte){ 
					existe = true;
				}
			}
			if (!existe){
				camino auxCamino = new camino(ciudadOrigen,ciudadDestino,transporte); //camino auxiliar
				listAux.add(auxCamino); //anado el camino creado en el auxiliar
				Caminos.put(ciudadOrigen, listAux); // subtituyo el array por el auxiliar que ya contiene el nuevo camino
			}
			
		}
		else{ //sino ja el puc crear
			camino auxCamino = new camino(ciudadOrigen,ciudadDestino,transporte); //camino auxiliar
			listAux.add(auxCamino); //anado el camino creado en el auxiliar
			Caminos.put(ciudadOrigen, listAux); // subtituyo el array por el auxiliar que ya contiene el nuevo camino
		}
	}
	
	//post:devuelve -1 en caso de que no exista el camino
	public int consultarCapacidad (String ciudadOrigen, String ciudadDestino, medioTransporte transporte){
		ArrayList<camino> listAux;  //creo una lista auxiliar para insertarle el camino 
		boolean existe = false; // booleno para comprovar que pare una vez encuentre el camino pare
		if (Caminos.containsKey(ciudadOrigen) && !existe) {
			listAux = Caminos.get(ciudadOrigen);  //arraylist existente
			Iterator<camino> it = listAux.iterator();
			while (it.hasNext()){
				camino auxCamino = it.next();
				if(auxCamino.consultarDestino() == ciudadDestino && auxCamino.consultarTransporte() == transporte){
					existe = true;
					return auxCamino.consultarCapacidad();
				}
			}
		}
		if (!existe) { ; }// ex:camino no existente
		return -1;
	}
		
	public int consultarNumCamnimos(){
			return Caminos.size();
	}
	
	public void borrarCamino (String ciudadOrigen, String ciudadDestino, medioTransporte transporte){
		ArrayList<camino> listAux;  //creo una lista auxiliar para insertarle el camino 
		boolean existe = false; 
		if (Caminos.containsKey(ciudadOrigen)) { //mirar si existe algun camino con ciudad origen
			listAux = Caminos.get(ciudadOrigen);  //arraylist existente
			Iterator<camino> it = listAux.iterator();
			while (it.hasNext()){
				camino auxCamino = it.next();
				if(auxCamino.consultarDestino() == ciudadDestino && auxCamino.consultarTransporte() == transporte){ //recorro hasta encontrarlo
					existe = true; //ya puede puede parar de recorrer
					listAux.remove(auxCamino); //lo borro de auxliar
					Caminos.put(ciudadOrigen, listAux); // subtituyo el array por el auxiliar que ya contiene el nuevo camino
				}
			}
		}
		if (!existe) { ; }// ex:camino no existente
	}
	
	public ArrayList<camino> consultarCiudadOrigen (String ciudadOrigen){
		if (Caminos.containsKey(ciudadOrigen)) {
			return Caminos.get(ciudadOrigen);
		}
		else return null; //ex: no hay ningun camino con ciudadOrigen
	}



	
	
	
	
	
	
	
	
	
	
	
	/*
	

	consultar_caminos_con_ciudad_origen(string ciudad_origen)
	consultar_caminos_con_ciudad_destino(string ciudad_destino) //comentar grup
	modificar_medio(string ciudad_origen, string ciudad_destino, string medio) // comentar amb el grup


	*/
	
	
	
	
}
