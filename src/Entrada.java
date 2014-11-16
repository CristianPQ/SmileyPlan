import java.util.*;

public class Entrada {
		private GrafoAntiguo g;
		private int source;
		private int sink;
		private int numeroAgentesSyT;
		
		public Entrada(GrafoAntiguo G, int s, int t, int numAgentes) throws Exception{
				g = G;
				source = s;
				sink = t;
				numeroAgentesSyT = numAgentes;
		}
		
		public GrafoAntiguo consultarGrafo(){
			return g;
		}
		
		public void modificarGrafo(GrafoAntiguo G){
			g = G;
		}
		
		public void modificarSource(int s){
			source = s;
		}
		
		public int consultarSource(){
			return source;
		}
		
		public void modificarSink(int t){
			sink = t;
		}
		
		public int consultarSink(){
			return sink;
		}
		
		public int consultarNumeroAgentes(){
			return numeroAgentesSyT;
		}
		
		public void modificarNumeroAgentes(int numAg){
			numeroAgentesSyT = numAg;
		}
		
		

	}


