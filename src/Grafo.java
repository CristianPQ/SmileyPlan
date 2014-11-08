import java.util.*;
public class Grafo {

private class Arista{
private int verticeDestino;
private int flujo;
private int capacidad;
private int coste;

public int consultarVerticeDestino(){
	return verticeDestino;
}

public void modificarVerticeDestino(int targetVertex){
	verticeDestino = targetVertex;
}

public int consultarFlujo() {
	return flujo;
}
public void modificarFlujo(int flow) {
	flujo = flow;
}

public int consultarCapacidad() {
	return capacidad;
}

public void modificarCapacidad(int capacity) {
	capacidad = capacity;
}

public int consultarCoste() {
	return coste;
}

public void ModificarCoste(int cost) {
	coste = cost;
}

};

private class Grafo{
	

public int consultarFlujoArista(int vertex){
	
	
	
//	return flujo;
}

public void modificarFlujoArista(int flow) {
//	flujo = flow;
}

public int consultarCapacidadArista() {
//	return capacidad;
}

public void modificarCapacidadArista(int capacity) {
//	capacidad = capacity;
}

public int consultarCosteArista() {
	
//	return coste;
}

public void ModificarCosteArista(int cost) {
//	coste = cost;
}


};




}