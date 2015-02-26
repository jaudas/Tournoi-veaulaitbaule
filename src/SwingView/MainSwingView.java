package SwingView;

import java.security.Principal;

public class MainSwingView {
	public static void main(String[] args) {
		
		try {   
			  javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");               
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
			  java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			}
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() { Menus.menuBienvenue(); }
		});
	}
}


