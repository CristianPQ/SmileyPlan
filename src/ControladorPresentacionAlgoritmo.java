
public class ControladorPresentacionAlgoritmo {
	
		private static ControladorAlgoritmo ca; 
		private static VistaAlgoritmo va;
		
		public ControladorPresentacionAlgoritmo() {
			ca = new ControladorAlgoritmo(); 
			va = new VistaAlgoritmo(this);
		}
		
		
		public VistaAlgoritmo getVista(){
			return va; 
		}
}
