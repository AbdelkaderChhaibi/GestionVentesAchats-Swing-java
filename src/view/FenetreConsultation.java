package view;

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

import controles.ClientService;
import controles.FornisseurService;
import javafx.event.ActionEvent;
import modeles.CompteBancaire;
import modeles.Personne;

public class FenetreConsultation extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8012402386115336757L;
	public JPanel contentpane;
	public JPanel jpr;
	public String cLientOuFourniseur;
	public Vector<Personne> vPersonne;
	public JScrollPane js;
	
	
	public FenetreConsultation(Vector<Personne> vPersonne, String cLientOuFourniseur) {
		this. vPersonne=vPersonne;
		this.cLientOuFourniseur=cLientOuFourniseur;
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100,100,750,700);
		setLocationRelativeTo(null);

		
		contentpane=(JPanel)getContentPane();
		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));

		jpr=new JPanel();
		jpr.setLayout(new BoxLayout(jpr, BoxLayout.Y_AXIS));
		js=new JScrollPane(jpr);
		contentpane.add(js);
		
		
int choix=1 ;
		for (Personne personne : vPersonne) {
			
			choix%=2;
			createJpanelPerson(personne,choix);
			choix++;
		}
		this.setVisible(true);
		
	}
	void createJpanelPerson(Personne person,int choix) {
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
		JPanel jpcomte=new JPanel();
		jpcomte.setLayout(new BoxLayout(jpcomte, BoxLayout.Y_AXIS));
		JPanel jp11=new JPanel(new FlowLayout(2));
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
		modifcolorjpanel(jp11, choix);
		modifcolorjpanel(jpcomte, choix);
	      JLabel l1 = new JLabel("code:");
	      l1.setFont(new Font("Verdana", Font.PLAIN, 18));
	      l1.setForeground(new Color(20, 20, 200));			
	      JLabel l2 = new JLabel("Matricule");
	      l2.setFont(new Font("Verdana", Font.PLAIN, 18));
	      l2.setForeground(new Color(20, 20, 200));		
	      JLabel l3 = new JLabel("Raison");
	      l3.setFont(new Font("Verdana", Font.PLAIN, 18));
	      l3.setForeground(new Color(20, 20, 200));		
	      JLabel l4 = new JLabel("type");
	      l4.setFont(new Font("Verdana", Font.PLAIN, 18));
	      l4.setForeground(new Color(20, 20, 200));		
	      JLabel l5 = new JLabel("description");
	      l5.setFont(new Font("Verdana", Font.PLAIN, 18));
	      l5.setForeground(new Color(20, 20, 200));		
	      JLabel l6= new JLabel("comptes");
	      l6.setFont(new Font("Verdana", Font.PLAIN, 18));
	      l6.setForeground(new Color(20, 20, 200));		
	      JLabel l7 = new JLabel("Adresse");
	      l7.setFont(new Font("Verdana", Font.PLAIN, 18));
	      l7.setForeground(new Color(20, 20, 200));		
	      JLabel l8 = new JLabel("contacts");
	      l8.setFont(new Font("Verdana", Font.PLAIN, 18));
	      l8.setForeground(new Color(20, 20, 200));		
	      JLabel l9 = new JLabel("etatFiscal");
	      l9.setFont(new Font("Verdana", Font.PLAIN, 18));
	      l9.setForeground(new Color(20, 20, 200));		
	      JLabel l10 = new JLabel("action");
	      l10.setFont(new Font("Verdana", Font.PLAIN, 18));
	      l10.setForeground(new Color(20, 20, 200));
	     JButton btnsup=new JButton("supp");
	     JButton btnedit=new JButton("edit");
	     btnsup.addActionListener((e)->{
	    	 if (cLientOuFourniseur.equalsIgnoreCase("client")) {
				ClientService cs=new ClientService();
	    	cs.deleteClient(person.getCode());
			}else {
				FornisseurService cs=new FornisseurService();
		    	cs.deleteFournisseur(person.getCode());
			}
	    	
	    	vPersonne.removeIf(p->(p.getCode()==person.getCode()));
	    	this.setContentPane(new FenetreConsultation(vPersonne, cLientOuFourniseur).getContentPane());
	     });
	     btnedit.addActionListener((e)->{
	      	 FenetreAjoutPersonne f=new FenetreAjoutPersonne(cLientOuFourniseur);
	      	f.btnAjoutPersonne.setText("modifier");
	      	 f.remplirClient(person);
	      	 f.setVisible(true);
	      	 if(!f.isEnabled())
	 	    	this.setContentPane(new FenetreConsultation(vPersonne, cLientOuFourniseur).getContentPane());
	      		 
	      	 
	      	 
	    	 
	    	 
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
		jp1.add(new JLabel(person.getCode()));
		jp2.add(new JLabel(person.getMatriculeFiscale()));
		jp3.add(new JLabel(person.getRaisonSocial()));
		jp4.add(new JLabel(person.getType()));
		jp5.add(new JLabel(person.getDescriptionActivite()));
		for (CompteBancaire compte : person.getComptebancaire()) {
			jpcomte.add(new JLabel(compte.toString()));
		}
		jp6.add(jpcomte);
		jp7.add(new JLabel(person.getAddress()));
		jp8.add(new JLabel(person.getContactToString()));
		jp9.add(new JLabel(person.getEtatFiscale()));
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
