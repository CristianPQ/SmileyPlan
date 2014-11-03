import java.util.*;

public class ConjuntoCaminos {

	private Map<String, ArrayList<Camino>> Caminos = new HashMap<String, ArrayList<Camino>>();
	
	//crear un Camino con capacidad
	public void agregarCaminoCapacidad(String ciudadOrigen, String ciudadDestino, int capacidad, String transporte) throws Exception{
		ArrayList<Camino> listAux = new ArrayList<Camino>();  //creo una lista auxiliar para insertarle el Camino 
		Camino auxCamino = new Camino(ciudadOrigen,ciudadDestino, capacidad, transporte); //Camino auxiliar
		if (Caminos.containsKey(ciudadOrigen)) { //primer miro si hi ha algun cami amb ciutatorigen
			if (Caminos.get(ciudadOrigen).contains(auxCamino)){ //miro si existe ese camino en concreto
				throw new Exception("El Camino ya existe");   
			}
			else {
				listAux = Caminos.get(ciudadOrigen); //mira si es pot fer sense treure la llista
				listAux.add(auxCamino);
				Caminos.put(ciudadOrigen, listAux);
			}
		}	
		else { 
			listAux = Caminos.get(ciudadOrigen);
			listAux.add(auxCamino);
			Caminos.put(ciudadOrigen, listAux);
		}
	}
			

	//crear un Camino sin capcidad, 1 por defecto
	public void agregarCamino(String ciudadOrigen, String ciudadDestino, String transporte) throws Exception{
		ArrayList<Camino> listAux = new ArrayList<Camino>();  //creo una lista auxiliar para insertarle el Camino 
		Camino auxCamino = new Camino(ciudadOrigen,ciudadDestino, transporte); //Camino auxiliar
		if (Caminos.containsKey(ciudadOrigen)) { //primer miro si hi ha algun cami amb ciutatorigen
			if (Caminos.get(ciudadOrigen).contains(auxCamino)){ //miro si existe ese camino en concreto
				throw new Exception("El Camino ya existe");   
			}
			else {
				listAux = Caminos.get(ciudadOrigen); //mira si es pot fer sense treure la llista
				listAux.add(auxCamino);
				Caminos.put(ciudadOrigen, listAux);
			}
		}	
		else { 
			listAux = Caminos.get(ciudadOrigen);
			listAux.add(auxCamino);
			Caminos.put(ciudadOrigen, listAux);
		}
	}
		
	public int getCapacidad (String ciudadOrigen, String ciudadDestino, String transporte) throws Exception{
		Camino auxCamino = new Camino(ciudadOrigen,ciudadDestino, transporte); //Camino auxiliar
		if (Caminos.containsKey(ciudadOrigen)) { //primer miro si hi ha algun cami amb ciutatorigen
			if (Caminos.get(ciudadOrigen).contains(auxCamino)){ //miro si existe ese camino en concreto
				int pos = Caminos.get(ciudadOrigen).indexOf(auxCamino); //posicion donde esta el elemento
				return Caminos.get(ciudadOrigen).get(pos).getCapacidad(); //del mapa trec el vector, del array trec el cami, del cami consultu la capacitat
			}
			else {
				throw new Exception("El Camino NO existe");   
			}
		}	
		else { 
			throw new Exception("El Camino NO existe");   
		}
	}
		
		
		
	public int getNumCamnimos(){
			return Caminos.size();
	}
	
	public void borrarCamino (String ciudadOrigen, String ciudadDestino, String transporte) throws Exception{
		ArrayList<Camino> listAux = new ArrayList<Camino>();  //creo una lista auxiliar para borrar el Camino 
		Camino auxCamino = new Camino(ciudadOrigen,ciudadDestino, transporte); //Camino auxiliar
		if (Caminos.containsKey(ciudadOrigen)) { //primer miro si hi ha algun cami amb ciutatorigen
			if (Caminos.get(ciudadOrigen).contains(auxCamino)){ //miro si existe ese camino en concreto
				listAux = Caminos.get(ciudadOrigen); //mira si es pot fer sense treure la llista
				listAux.remove(auxCamino); //borro
				Caminos.put(ciudadOrigen, listAux); //inserto la nova llista axtualitzada
			}
			else {
				throw new Exception("El Camino NO existe");   
			}
		}	
		else { 
			throw new Exception("El Camino NO existe");   
		}
	}	
	//devuelve todos los caminos existentes con que tengan ciudad origen, ciudadOrigen, en caso de no existir devuelve null
	public ArrayList<Camino> getCiudadOrigen (String ciudadOrigen){
		if (Caminos.containsKey(ciudadOrigen)) {
			return Caminos.get(ciudadOrigen);
		}
		else return null; 
	}

    public void setCapacidad(String ciudadOrigen, String ciudadDestino, String transporte, int capacidad) throws Exception{
		Camino auxCamino = new Camino(ciudadOrigen,ciudadDestino, transporte); //Camino auxiliar
		if (Caminos.containsKey(ciudadOrigen)) { //primer miro si hi ha algun cami amb ciutatorigen
			if (Caminos.get(ciudadOrigen).contains(auxCamino)){ //miro si existe ese camino en concreto
				int pos = Caminos.get(ciudadOrigen).indexOf(auxCamino); //posicion donde esta el elemento
				Caminos.get(ciudadOrigen).get(pos).setCapacidad(capacidad); //del mapa trec el vector, del array trec el cami, del cami consultu la capacitat
			}
			else {
				throw new Exception("El Camino NO existe");   
			}
		}	
		else { 
			throw new Exception("El Camino NO existe");   
		}
	}
		
    
	
}
