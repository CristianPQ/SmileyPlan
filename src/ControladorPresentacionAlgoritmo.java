
public class ControladorPresentacionAlgoritmo {
	
		private static ControladorAlgoritmo ca; 
		private static VistaAlgoritmo va;
		private static ControladorItinerarios citi; 
		
		public ControladorPresentacionAlgoritmo() {
			citi = new ControladorItinerarios(); 
			ca = new ControladorAlgoritmo(); 
			va = new VistaAlgoritmo(this);
		}
		
		
		public VistaAlgoritmo getVista(){
			return va; 
		}
}
