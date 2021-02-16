package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controles.ClientService;
import controles.FornisseurService;
import controles.ProduitService;

public class FenetrePrincipale extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2763126166599040878L;
	JButton gestionClient,gestionFournisseur,gestionEnterprise,gestionProduit,gestionAchat,gestionVente;
	private JPanel jpCentre;
	/**
	 * Create the frame.
	 */
	public FenetrePrincipale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		this.setLocationRelativeTo(null);
		
		JPanel contentPane=(JPanel)this.getContentPane();
		JPanel jpGauche=new JPanel();
		jpGauche.setLayout(new GridLayout(6,1));
		jpGauche.setBorder(new EmptyBorder(20,20,20,20));
		
		 jpCentre=new JPanel();
		HeurePanel heurePanel = new HeurePanel();
		contentPane.add(heurePanel,BorderLayout.NORTH);
		gestionClient=new JButton("gesstion client");
		gestionFournisseur=new JButton("Gestion Fourniseur");		
		gestionEnterprise=new JButton("gestionEnterprise");
		gestionProduit=new JButton("gestion Produit");
		gestionAchat=new JButton("gestionAchat");
		gestionVente=new JButton("gestionVente");

		gestionClient.setMaximumSize(new Dimension(50,150));
		
		jpGauche.add(gestionClient);
		jpGauche.add(gestionFournisseur);
		jpGauche.add(gestionEnterprise);
		jpGauche.add(gestionProduit);
		jpGauche.add(gestionAchat);
		jpGauche.add(gestionVente);

		
		contentPane.add(jpGauche,BorderLayout.WEST);
		contentPane.add(jpCentre,BorderLayout.CENTER);
		gestionClient.addActionListener((e)->actionBtnClient());
		gestionFournisseur.addActionListener((e)->actionBtnFournisseur());
		gestionEnterprise.addActionListener((e)->actionBtnEnterprise());
		gestionProduit.addActionListener((e)->actionBtnProduit());
		gestionAchat.addActionListener((e)->actionBtnAchats());
		gestionVente.addActionListener((e)->{
			JOptionPane.showMessageDialog(this,
					 "Cette Fonctionalite n'est pas encore disponible", 
					 "erreur",JOptionPane.ERROR_MESSAGE);
			
		});



		
		
		
		
		
		setVisible(true);
		
	}

	private void actionBtnAchats() {
		
		jpCentre.removeAll();
		JButton btnGestionBr=new JButton("GestionBr");
		JButton btnGestionFacture=new JButton("GestionFacturel");
		JPanel jpCentre1=new JPanel();
		jpCentre1.setLayout(new GridLayout(2,1));
		jpCentre1.setBorder(new EmptyBorder(jpCentre.getSize().height/5,20,jpCentre.getSize().height/5,20));
		jpCentre1.add(btnGestionBr);
		jpCentre1.add(btnGestionFacture);
		jpCentre.add(jpCentre1);
		btnGestionBr.addActionListener((e)->{
			FenetreGestionBR f=new FenetreGestionBR();
			f.setVisible(true);

			
			
		});
		btnGestionFacture.addActionListener((e)->{
			FenetreGestionFF f=new FenetreGestionFF();			
			f.setVisible(true);
			
			
			
		});
		
		
		setVisible(true);
		
	}
		
		
		


	private void actionBtnFournisseur() {
		jpCentre.removeAll();
		JButton btnAjout=new JButton("Ajout Fourniseur");
		JButton btnConsult=new JButton("consult Fourniseur");
		JPanel jpCentre1=new JPanel();
		jpCentre1.setLayout(new GridLayout(2,1));
		jpCentre1.setBorder(new EmptyBorder(jpCentre.getSize().height/5,20,jpCentre.getSize().height/5,20));
		jpCentre1.add(btnAjout);
		jpCentre1.add(btnConsult);
		jpCentre.add(jpCentre1);
		btnAjout.addActionListener((e)->{
			FenetreAjoutPersonne f=new FenetreAjoutPersonne("fournisseur");
			f.setVisible(true);

			
			
		});
		btnConsult.addActionListener((e)->{
			FornisseurService fs=new FornisseurService();
			FenetreConsultation f=new FenetreConsultation(fs.getAllfournisseur(),"fournisseur");
			
			
			
			
			
		});
		
		
		setVisible(true);
		
	}
	private void actionBtnClient() {
		jpCentre.removeAll();
		JButton btnAjout=new JButton("Ajout clients");
		JButton btnConsult=new JButton("consult Clients");
		JPanel jpCentre1=new JPanel();
		jpCentre1.setLayout(new GridLayout(2,1));
		jpCentre1.setBorder(new EmptyBorder(jpCentre.getSize().height/5,20,jpCentre.getSize().height/5,20));
		jpCentre1.add(btnAjout);
		jpCentre1.add(btnConsult);
		jpCentre.add(jpCentre1);
		btnAjout.addActionListener((e)->{
			FenetreAjoutPersonne f=new FenetreAjoutPersonne("client");
			f.setVisible(true);

			
			
		});
		
		btnConsult.addActionListener((e)->{
			ClientService fs=new ClientService();
			FenetreConsultation f=new FenetreConsultation(fs.getAllClient(),"client");
			
			
			
			
			
		});
		
		
		
		setVisible(true);
		
	}
	private void actionBtnProduit() {
		jpCentre.removeAll();
		JButton btnAjout=new JButton("AjoutProduit");
		JButton btnConsult=new JButton("consult Produit");
		JPanel jpCentre1=new JPanel();
		jpCentre1.setLayout(new GridLayout(2,1));
		jpCentre1.setBorder(new EmptyBorder(jpCentre.getSize().height/5,20,jpCentre.getSize().height/5,20));
		jpCentre1.add(btnAjout);
		jpCentre1.add(btnConsult);
		jpCentre.add(jpCentre1);
		btnAjout.addActionListener((e)->{
			FenetreAjoutProduit f=new FenetreAjoutProduit();
			f.setVisible(true);

			
			
		});
		btnConsult.addActionListener((e)->{
			ProduitService ps=new ProduitService();
			FenetreConsulterProduit f=new FenetreConsulterProduit(ps.getAllProduit());
			
			
			
			
			
		});
		
		
		
		setVisible(true);
		
	}
	private void actionBtnEnterprise() {
		
		jpCentre.removeAll();
		setVisible(true);
 new FenetreConsulterEnterprise();
 		
 		
		
		
		
	}
		
		
		
	}


