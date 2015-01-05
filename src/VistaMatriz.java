import java.awt.Color;
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
	ControladorPresentacionMapa contpm;
	ArrayList<Integer> horizontal;
	ArrayList<Integer> vertical;
	
	
	
	public VistaMatriz(int X, int Y) {
		super();
		x = X;
		y = Y;
		horizontal = new ArrayList<Integer>();
		vertical = new ArrayList<Integer>();
	}
	
	public VistaMatriz() {
		super();
		x = 2;
		y = 2;
		horizontal = new ArrayList<Integer>();
		vertical = new ArrayList<Integer>();
	}
	
	protected void controlador(ControladorPresentacionMapa cpm) {
		contpm = cpm;
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
    public void paintComponent(Graphics g) {
        
        //super.paintComponent(g);
    	this.addMouseListener(this);
    	Graphics2D g2 = (Graphics2D) g;
    	g2.setColor(Color.white);
        g2.fillRect(0, 0, 350, 350);
        
        if(!vertical.isEmpty() && !horizontal.isEmpty()) {
        	g2.setColor(Color.red);
        	for(int i = 0; i < vertical.size() && i < horizontal.size(); ++i) {
    			g2.fillRect(((horizontal.get(i)*300/x)+25), ((vertical.get(i)*300/y)+25), 300/x, 300/y);
        	}
        	
        }
        
        
    	g2.setColor(Color.black);
    	
    	//HORIZONTALES
        for(int i = 25; i <= 325; i += 300/x) {
        	
        	g2.drawLine(25, i, 325, i);
        }
        
        //VERTICALES
        for(int j = 25; j <= 325; j += 300/y) {
        	
        	g2.drawLine(j, 25, j, 325);
        }
        
        
        
    }
    
    
    public void initUI(JFrame lines) {
        
        //lines.setTitle("Lines");
        //lines.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lines.add(this);
        
        lines.setSize(510, 530);
        //lines.setLocationRelativeTo(null);        
    }
    
    public void main(String[] args) {

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
		// TODO Auto-generated method stub
		System.out.println("Entrar en mouseClicked"
				+ "\n button: " + e.getButton() + "\n X: " + e.getX() + "\n Y: " + e.getY() + "\n");
		if ((e.getButton() == 1) && (e.getX() >= 25) && (e.getX() <= 325) && (e.getY() >= 25) && (e.getY() <= 325)) {
			int xPos = (e.getX() - 25)/(300/x);
			int yPos = (e.getY() - 25)/(300/y);
			boolean exist = false;
			
			for(int i = 0; i < horizontal.size() && i< vertical.size(); ++i) {
				if(horizontal.get(i).equals(xPos) && vertical.get(i).equals(yPos)){
					exist = true;
					horizontal.remove(i);
					vertical.remove(i);
					break;
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

