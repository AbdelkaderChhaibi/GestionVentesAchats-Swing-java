package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controles.ProduitService;
import modeles.Produit;

public class FenetreConsulterProduit extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3377570868041657323L;
	public JPanel contentPane;
	public Vector<Produit> vp;
	public JScrollPane js;
	public JPanel jpr;



	public FenetreConsulterProduit(Vector<Produit> vp) {
		this.vp=vp;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = (JPanel)getContentPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		jpr=new JPanel();
		jpr.setLayout(new BoxLayout(jpr, BoxLayout.Y_AXIS));
		js=new JScrollPane(jpr);
		contentPane.add(js);
		int choix=1;
		for (Produit p : vp) {
			 createJpanelProduit(p, choix);
			
		}
	
	}
	void createJpanelProduit(Produit p,int choix) {
		JPanel jp0 =new JPanel();
		BoxLayout  bl=new BoxLayout(jp0, BoxLayout.Y_AXIS);
		GridLayout gl=new GridLayout(1,2);
		jp0.setLayout(bl);
		modifcolorjpanel(jp0, choix);
		JPanel jp1 =new JPanel(gl);
		JPanel jp2 =new JPanel(gl);
		JPanel jp3 =new JPanel(gl);
		JPanel jp4 =new JPanel(gl);
		JPanel jp5 =new JPanel(gl);
		JPanel jp6 =new JPanel(gl);
		JPanel jp7 =new JPanel(gl);
		JPanel jp8 =new JPanel(gl);		
		JPanel jp9 =new JPanel(gl);
		JPanel jp10 =new JPanel(gl);
		JPanel jp11 =new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel jp =new JPanel(gl);
		modifcolorjpanel(jp1, choix);
		modifcolorjpanel(jp2, choix);
		modifcolorjpanel(jp3, choix);
		modifcolorjpanel(jp4, choix);
		modifcolorjpanel(jp5, choix);
		modifcolorjpanel(jp6, choix);
		modifcolorjpanel(jp7, choix);
		modifcolorjpanel(jp8, choix);
		modifcolorjpanel(jp9, choix);
		modifcolorjpanel(jp10, choix);

	      JLabel l1 = new JLabel("reference:");
	      l1.setFont(new Font("Verdana", Font.PLAIN, 18));
	      l1.setForeground(new Color(20, 20, 200));			
	      JLabel l2 = new JLabel("designation:");
	      l2.setFont(new Font("Verdana", Font.PLAIN, 18));
	      l2.setForeground(new Color(20, 20, 200));		
	      JLabel l3 = new JLabel("uniteMesure");
	      l3.setFont(new Font("Verdana", Font.PLAIN, 18));
	      l3.setForeground(new Color(20, 20, 200));		
	      JLabel l4 = new JLabel("fourniseur");
	      l4.setFont(new Font("Verdana", Font.PLAIN, 18));
	      l4.setForeground(new Color(20, 20, 200));		
	      JLabel l5 = new JLabel("famille produit");
	      l5.setFont(new Font("Verdana", Font.PLAIN, 18));
	      l5.setForeground(new Color(20, 20, 200));		
	      JLabel l6= new JLabel("Stoke");
	      l6.setFont(new Font("Verdana", Font.PLAIN, 18));
	      l6.setForeground(new Color(20, 20, 200));		
	      JLabel l7 = new JLabel("StokeMin");
	      l7.setFont(new Font("Verdana", Font.PLAIN, 18));
	      l7.setForeground(new Color(20, 20, 200));		
	      JLabel l8 = new JLabel("Prix hors taxe");
	      l8.setFont(new Font("Verdana", Font.PLAIN, 18));
	      l8.setForeground(new Color(20, 20, 200));		
	      JLabel l9 = new JLabel("taxeTva");
	      l9.setFont(new Font("Verdana", Font.PLAIN, 18));
	      l9.setForeground(new Color(20, 20, 200));		
	      JLabel l10 = new JLabel("action");
	      l10.setFont(new Font("Verdana", Font.PLAIN, 18));
	      l10.setForeground(new Color(20, 20, 200));
	     JButton btnsup=new JButton("supp");
	     
	     JButton btnedit=new JButton("edit");
	     btnsup.addActionListener((e)->{
		    	vp.removeIf(prod->(prod.getReference()==p.getReference()));
		    	ProduitService ps=new ProduitService();
		    	ps.deleteProduit(p.getReference());
		    	this.repaint(100);
	    	 
	     });
	     btnedit.addActionListener((e)->{
	    	 FenetreAjoutProduit fpp=new FenetreAjoutProduit();
	    	 fpp.remplirproduit(p);
	    	 fpp.btnAjouter.setText("modifier");
	    	 fpp.tfReference.setEditable(false);
	    	 fpp.setVisible(true);
	    	
	    	 
	    	 
	     });
	     
		jp1.add(l1);
		jp2.add(l2);
		jp3.add(l3);
		jp4.add(l4);
		jp5.add(l5);
		jp6.add(l6);
		jp7.add(l7);
		jp8.add(l8);
		jp9.add(l9);
		jp10.add(l10);		
		jp11.add(btnsup);
		jp11.add(btnedit);
		jp1.add(new JLabel(p.getReference()));
		jp2.add(new JLabel(p.getDesignation()));
		jp3.add(new JLabel(p.getUniteMesure()));
		jp4.add(new JLabel(p.getFournisseur()));
		jp5.add(new JLabel(p.getFamilleproduit()));
		
		jp6.add(new JLabel(String.valueOf(p.getStoke())));
		jp7.add(new JLabel(String.valueOf(p.getStokeMin())));
		jp8.add(new JLabel(String.valueOf(p.getPrixUnitaireHorsTaxe())));
		jp9.add(new JLabel(String.valueOf(p.getTaxeTva())));
		jp10.add(jp11);
		jp0.add(jp1);jp0.add(jp2);jp0.add(jp3);jp0.add(jp4);jp0.add(jp5);jp0.add(jp6);jp0.add(jp7);jp0.add(jp8);jp0.add(jp9);jp0.add(jp10);
		jpr.add(jp0);
		setVisible(true);
		
		
	}
	public void modifcolorjpanel(JPanel jp,int choix) {
		
		if(choix==1) {
			jp.setBackground(new Color(179, 255, 255));
		}else {
			jp.setBackground(new Color(204, 204, 255));
		}
		
	}

 	

}
