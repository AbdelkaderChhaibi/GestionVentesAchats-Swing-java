package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import modeles.CompteBancaire;

public class FenetreConsulterCompte extends JFrame {
	
	private static final long serialVersionUID = -5276378686905736884L;
		private JPanel contentPane;
		private Vector<CompteBancaire> vb;
	 

	public FenetreConsulterCompte(Vector<CompteBancaire> vb) {	
		this.vb=vb;
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
				setBounds(100, 100, 450, 300);				
				setLocationRelativeTo(null);
				//setResizable(false);
				 contentPane=(JPanel)this.getContentPane();
				contentPane.setLayout(new GridLayout(4,1));
int choix=0;
				for (CompteBancaire c : vb) {
					createComptePanel(c,choix%2);
					choix++;
				}
				
				 
				
				
				
				
				
	}


	private void createComptePanel(CompteBancaire c,int choix) {
	 JPanel jp0=new JPanel();
	 JPanel jp1=new JPanel();
	 JPanel jp2=new JPanel();
	 JPanel jp3=new JPanel();
	 JPanel jp4=new JPanel();
	 jp0.setLayout(new GridLayout(1,3));
	 jp1.setLayout(new GridLayout(2,1));
	 jp2.setLayout(new GridLayout(2,1));
	 jp3.setLayout(new GridLayout(2,1));
	 modifcolorjpanel(jp0, choix);
	 modifcolorjpanel(jp1, choix);
	 modifcolorjpanel(jp2, choix);
	 modifcolorjpanel(jp3, choix);
	 modifcolorjpanel(jp4, choix);
	 jp4.setLayout(new FlowLayout(FlowLayout.RIGHT));
     JLabel l1 = new JLabel("Banque:");
     l1.setFont(new Font("Verdana", Font.PLAIN, 18));
     l1.setForeground(new Color(20, 20, 200));			
     JLabel l2 = new JLabel("Agence:");
     l2.setFont(new Font("Verdana", Font.PLAIN, 18));
     l2.setForeground(new Color(20, 20, 200));		
     JLabel l3 = new JLabel("RIB");
     l3.setFont(new Font("Verdana", Font.PLAIN, 18));
     jp1.add(l1);
     jp1.add(new JLabel(""+c.getBanque()));
     jp2.add(l2);
     jp2.add(new JLabel(""+c.getAgence()));
     jp3.add(l3);
     jp3.add(new JLabel(""+c.getRIB()));
     JButton btnsup=new JButton("supp");
     btnsup.addActionListener((e)->{
    	 vb.removeIf(l->(l.getRIB()==c.getRIB()));
    	 dispose();
     });
     jp4.add(btnsup);
     jp0.add(jp1);
     jp0.add(jp2);
     jp0.add(jp3);
     jp0.add(jp4);
     contentPane.add(jp0);
     
		
		
		
		
		
	}
public void modifcolorjpanel(JPanel jp,int choix) {
		
		if(choix==1) {
			jp.setBackground(new Color(179, 255, 255));
		}else {
			jp.setBackground(new Color(204, 204, 255));
		}
		
	}

}
