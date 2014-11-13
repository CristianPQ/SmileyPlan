import java.util.*;

public class Entrada {
		Grafo g;
		Ciudad[] ciudades; //obtener todas las ciudades, entonces tendremos
							//las posiciones q ocuparan en el grafo
		TST <Integer> relacCiudades;  //nombre -> vertex
		
		
		public Grafo Entrada(Mapa m, ControladorAgentes ca, ControladorMedioTransporte cm){
			ciudades = new Ciudad[m.numeroCiudades()];
			//iterar ciudades y meterlas en el vector
			relacCiudades = new TST<Integer>();
			for (int i = 0; i < ciudades.length; ++i)
				relacCiudades.insert(ciudades[i].consultarNombre(), i);

			//para cada Ciudad
			//obtener los caminos
			//para cada camino, 
			
			return g;
		}
		
		public TST <Integer >obtenerRelacCiudades(){
			return relacCiudades;
		}
 //crearAristas

		
}
