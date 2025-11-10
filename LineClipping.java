import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class LineClipping extends JFrame implements MouseListener {

    BufferedImage canvas;
    Graphics g;
	int clipX,clipY,clipWidth,clipHeight;
	boolean firstClick;
	
    public LineClipping() {
        setTitle("Point Clipping ");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(this);
        setLocationRelativeTo(null);
        setVisible(true);

        canvas = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        g = canvas.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(clipX,clipY,clipWidth,clipHeight);

        
        g.setColor(Color.BLACK);
        g.fillRect(200, 150, 400, 300);
    }

    public void pointClip(int x1, int y1, int x2, int y2) {
        if ((x1 >= 200 && x1 <= 600 && y1 >= 150 && y1 <= 450) &&
		   (x2 >= 200 && x2 <= 600 && y2 >= 150 && y2 <= 450)){
			   g.setColor(Color.RED);
			   g.drawLine(x1, y1, x2, y2);
        }
    }

  
    public void paint(Graphics gScreen) {
        gScreen.drawImage(canvas, 0, 0, null);
    }

    public void mouseClicked(MouseEvent e) {
		int x1,y1,x2,y2;
       
	   if(firstClick){
		int x1 = e.getX();
        int y1 = e.getY();
		firstClick = false;
		}else{
		x2 = e.getX();
		y2 = e.getY();
		firstClick = true;
		
		lineClip(x1, y1, x2, y2);
		repaint();
		}
	}

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new LineClipping();
    }
}
