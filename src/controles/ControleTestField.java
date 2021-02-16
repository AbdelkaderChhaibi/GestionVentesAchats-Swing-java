package controles;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ControleTestField {

	public ControleTestField() {
	}
	public static void accepteChiffres(JTextField tf) {
		tf.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
		            e.consume();  // ignorer l'événement
		        }
		     }
		});
	}
	public static void accepteChiffresDicimal(JTextField tf) {
		tf.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) &&(c!='.')) {
		            e.consume();  // ignorer l'événement
		        }
		     }
		});
	}
 public static void limterTaille(JTextField tF ,int t) {
	 tF.addKeyListener(new KeyAdapter() {
	       public void keyTyped(KeyEvent e) { 
	           if (tF.getText().length() >= t ) // limit jtextfield to t  characters
	               e.consume(); 
	       }  
	});
 }
	public static void delEspace(JTextField tf) {
		tf.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if ((c ==' ' )) {
		            e.consume();
		        }
		     }
		});
 
 }
	public static Boolean verifierchaine(JFrame f,Vector<String> s) {
		
		for (String a : s) {
			if(a.isEmpty()) {
				return true;				
			}
			
		}
		
		return false;
		
	}

	
	
}
