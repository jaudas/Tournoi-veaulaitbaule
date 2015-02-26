package SwingView;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class PanelImagen1 extends JPanel {

	private static final long serialVersionUID = 1L;
	public PanelImagen1(){
			this.setSize(400,280);
		}
	@Override
	public void paintComponent (Graphics g){
		Dimension tamanio = getSize();
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/images/Volleyball.jpg"));
		g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}
