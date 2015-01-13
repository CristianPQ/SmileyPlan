import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
	
	
public class VistaMatriz extends JPanel implements MouseListener{
	int x;
	int y;
	//ControladorPresentacionMapa contpm;
	private ArrayList<Integer> horizontal;
	private ArrayList<Integer> vertical;
	
	public void reset() {
		horizontal.clear();
		vertical.clear();
		x = 1;
		y = 1;
		repaint();
	}
	
	public VistaMatriz(int X, int Y) {
		super();
		x = X;
		y = Y;
		horizontal = new ArrayList<Integer>();
		vertical = new ArrayList<Integer>();
		//this.setSize(350, 350);
		this.addMouseListener(this);
	}
	
	public VistaMatriz() {
		super();
		x = 1;
		y = 1;
		horizontal = new ArrayList<Integer>();
		vertical = new ArrayList<Integer>();
		this.addMouseListener(this);
	}
	
	void definirOcupadas(ArrayList<Integer> horiz, ArrayList<Integer> vert) {
		horizontal = horiz;
		vertical = vert;
	}
	
	public void definirMedidas(int X, int Y) {
		x = X;
		y = Y;
	}
	
	/*protected void controlador(ControladorPresentacionMapa cpm) {
		contpm = cpm;
	}*/
	
	public String consultarContinente() {
		String cont = new String();
		
		int hpre = horizontal.get(0);
		int vpre = vertical.get(0);
		cont = cont + Integer.toString(hpre) + " " + Integer.toString(vpre) + " ";
		horizontal.remove(0);
		vertical.remove(0);
		boolean validez = true;
		while(!horizontal.isEmpty() && !vertical.isEmpty() && validez) {
			int i;
			boolean encontrado = false;
				//System.out.println("antes del for de consultarContinente");
			for(i = 0; i < horizontal.size() && i < vertical.size() && !encontrado; ++i) {
				int h = horizontal.get(i);
				int v = vertical.get(i);
				if((hpre == h && vpre-1 == v) ||
						(hpre+1 == h && vpre-1 == v) ||
						(hpre+1 == h && vpre == v) ||
						(hpre+1 == h && vpre+1 == v) ||
						(hpre == h && vpre+1 == v) ||
						(hpre-1 == h && vpre+1 == v) ||
						(hpre-1 == h && vpre == v) ||
						(hpre-1 == h && vpre-1 == v)) {
					cont = cont + Integer.toString(h) + " " + Integer.toString(v) + " ";
					hpre = h;
					vpre = v;
					encontrado = true;
					horizontal.remove(i);
					vertical.remove(i);
				}
			}
				//System.out.println("despues del for de consultarContinente");
			if(!encontrado) validez = false;
		}
			//System.out.println("despues del while");
		
		return cont;
	}
	    
    /*private void doDrawing(Graphics g) {

        Graphics g2d = (Graphics2D) g;
        
        
        //HORIZONTALES
        for(int i = 0; i <= 300; i += 300/x) {
        	g2d.drawLine(0, i, 300, i);
        }
        
        //VERTICALES
        for(int j = 0; j <= 300; j += 300/y) {
        	g2d.drawLine(j, 0, j, 300);
        }
        

   } */
	
	
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(350, 350);
		//return new Dimension(600, 600);
    }

    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
    	//this.addMouseListener(this);
    	Graphics2D g2 = (Graphics2D) g;
    	//g2.setColor(Color.white);
    	g2.setColor(Color.GRAY);
        g2.fillRect(0, 0, 350, 350);
        
        if(!vertical.isEmpty() && !horizontal.isEmpty()) {
        	g2.setColor(Color.red);
        	for(int i = 0; i < vertical.size() && i < horizontal.size(); ++i) {
    			g2.fillRect(((horizontal.get(i)*300/x)+25), ((vertical.get(i)*300/y)+25), 300/x, 300/y);
        	}
        	
        }
        
        
    	g2.setColor(Color.black);
    	
    	//HORIZONTALES
        for(int i = 25; i <= 325; i += 300/y) {
        		//System.out.println("Linea horizontal");
        	g2.drawLine(25, i, 325, i);
        }
        
        //VERTICALES
        for(int j = 25; j <= 325; j += 300/x) {
        		//System.out.println("Linea vertical");
        	g2.drawLine(j, 25, j, 325);
        }
        
        
        
    }
    
    
    public static void initUI(JFrame lines) {
        
        //lines.setTitle("Lines");
        //lines.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lines.add(new VistaMatriz());
        
        lines.setSize(510, 530);
        //lines.setLocationRelativeTo(null);        
    }
    
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                
                JFrame lines = new JFrame();
                initUI(lines);
                lines.setVisible(true);
            }
        });
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Entrar en mouseClicked"
				+ /*"\n button: " + e.getButton() +*/ "\n X: " + e.getX() + "\n Y: " + e.getY() + "\n");
		if ((e.getButton() == 1) && (e.getX() >= 25) && (e.getX() <= 325) && (e.getY() >= 25) && (e.getY() <= 325)) {
			int xPos = (e.getX() - 25)/(300/x);
			int yPos = (e.getY() - 25)/(300/y);
			boolean exist = false;
			
			for(int i = 0; i < horizontal.size() && i< vertical.size(); ++i) {
				if(horizontal.get(i).equals(xPos) && vertical.get(i).equals(yPos)){
					exist = true;
					horizontal.remove(i);
					vertical.remove(i);
					//break;
				}
			}
			if(!exist) {
				horizontal.add(xPos);
					System.out.println("anadido a hrizontal");
				vertical.add(yPos);
				/*g2.setColor(Color.red);
				g2.fillRect((xPos*x)+25, (yPos*y+25), x, y);*/
			}
				System.out.println("elementos listas: ");
				for(int i = 0; i<horizontal.size() && i<vertical.size(); ++i) {
					System.out.println("x: " + horizontal.get(i) + "     y: " + vertical.get(i));
				}
			repaint();
			//this.paintComponent(this.getGraphics());
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

