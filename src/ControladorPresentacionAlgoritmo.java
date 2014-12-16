
public class ControladorPresentacionAlgoritmo {
	
		private static ControladorAlgoritmo ca; 
		private static VistaAlgoritmo va;
		private static ControladorItinerarios citi; 
		
		public ControladorPresentacionAlgoritmo() {
			citi = new ControladorItinerarios(); 
			ca = new ControladorAlgoritmo(); 
			va = new VistaAlgoritmo(this);
		}
		
		public String escribirItinearios(){
			return citi.escribirItinerarios(); 
		}
		
		public void guardarSeq(String file){
			try {
				ca.guardarSeq(file);
			} catch (Exception e) {
				va.setError(e.getMessage()); 
			}
		}
		
		public void ejecutar(int i) {
			try {
				ca.ejecutar(i);
			} catch (Exception e) {
				va.setError(e.getMessage()); 
			}
		}
		
		public VistaAlgoritmo getVista(){
			return va; 
		}
}
