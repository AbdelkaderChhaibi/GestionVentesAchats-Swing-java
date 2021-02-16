package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controles.ClientService;
import controles.ControleTestField;
import controles.FornisseurService;
import modeles.CompteBancaire;
import modeles.Fournisseur;
import modeles.Personne;

public class FenetreAjoutPersonne extends JFrame {
      /**
	 * 
	 */
	private static final long serialVersionUID = -2720765513035924994L;
	/**
	 * 
	 */
	public  JLabel lnew,lCode,lMatricule,lRaison,lType,lDescription,lComptes,
	lAdress,lNumFixe,lNumPortable,lFax,lEmail,lSiteWeb,letatFiscale,lNumrue,lrue,lville,lCodePostale,lgov,lpays;
	public  JTextField tfCode,tfMatricule,tfRaison,tfNumRue,tfrue,tfville,tfcodePostale,tfgov,tfpays,tfNumFixe,tfNumPortable,
	tfFax,tfEmail,tfSiteWeb;
	public  JTextArea tfDescription;
	public  JRadioButton rbPPhy,rbpmor,rbTvaOui,rbTvaNon;
	public  ButtonGroup typeGroupe,etatGroupe;
	public  JButton btnAjoutCompte ,btnAjoutPersonne,btnConsulterComptes;
	public Vector<CompteBancaire> vComptes=new Vector<CompteBancaire>();
	
	
	

	public FenetreAjoutPersonne(String cOuF) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100,100,750,700);
		
		setVisible(true);
		setLocationRelativeTo(null);
		
		//declaration de jlabel
		JPanel contentPane=(JPanel)this.getContentPane();
		contentPane.setLayout(new GridLayout(15,1));
		contentPane.setBorder(new EmptyBorder(0, 30, 0, 0));
		FlowLayout fl=new FlowLayout(3);
		
		JPanel jp1=new JPanel(fl);	
		JPanel jp2=new JPanel(fl);
		JPanel jp3=new JPanel(fl);
		JPanel jp4=new JPanel(fl);
		JPanel jpAdress=new JPanel(fl);
		JPanel jpComptes=new JPanel(fl);
		JPanel jp5=new JPanel(fl);			
		JPanel jp6=new JPanel(fl);
		JPanel jp7=new JPanel(fl);
		JPanel jp8=new JPanel(fl);
		JPanel jp9=new JPanel(fl);			
		JPanel jp10=new JPanel(fl);
		JPanel jp11=new JPanel(fl);
		JPanel jp12=new JPanel(fl);
		JPanel jp13 =new JPanel(fl);
		JPanel jp14=new JPanel(fl);
		JPanel jp15=new JPanel(new FlowLayout(2));
		
		//reglage de composants
		lnew=new JLabel(cOuF);lCode=new JLabel("Code:");lMatricule=new JLabel("Matricule:");
		lRaison=new JLabel("Raison sciale:");lType=new JLabel("Type:");lDescription=new JLabel("Desciption:");
		lComptes=new JLabel("Comptes bancaires:");lAdress=new JLabel("Address:");lNumFixe=new JLabel("TelFixe:");
		lNumPortable=new JLabel("telPortable");lFax=new JLabel("Fax:");lEmail=new JLabel("E_mail:");
		lSiteWeb=new JLabel("site web:");letatFiscale=new JLabel("etat fiscale:");lNumrue =new JLabel("numRue");
		lrue=new JLabel("rue");lville=new JLabel("ville");lCodePostale=new JLabel("codePostale");
		lgov=new JLabel("governot");lpays=new JLabel("pays");
		tfCode=new JTextField();		tfCode.setPreferredSize(new Dimension(100,30));
		tfMatricule=new JTextField();	tfMatricule.setPreferredSize(new Dimension(100,30));
		tfRaison=new JTextField();		tfRaison.setPreferredSize(new Dimension(100,30));
		tfNumFixe=new JTextField();		tfNumFixe.setPreferredSize(new Dimension(100,30));
		tfNumPortable=new JTextField(); tfNumPortable.setPreferredSize(new Dimension(100,30));
		tfFax=new JTextField(); 		tfFax.setPreferredSize(new Dimension(100,30));
		tfEmail=new JTextField();		tfEmail.setPreferredSize(new Dimension(100,30));
		tfSiteWeb=new JTextField();     tfSiteWeb.setPreferredSize(new Dimension(100,30));
		tfDescription=new JTextArea();	tfDescription.setPreferredSize(new Dimension(100,30));
		tfNumRue=new JTextField();		tfNumRue.setPreferredSize(new Dimension(20,30));
		tfrue=new JTextField();			tfrue.setPreferredSize(new Dimension(40,30));
		tfville=new JTextField();		tfville.setPreferredSize(new Dimension(40,30));
		tfcodePostale=new JTextField();	tfcodePostale.setPreferredSize(new Dimension(30,30));
		tfgov=new JTextField();			tfgov.setPreferredSize(new Dimension(40,30));
		tfpays=new JTextField();		tfpays.setPreferredSize(new Dimension(40,30));
		rbpmor=new JRadioButton("Morale",true); rbPPhy=new JRadioButton("phisique");
		rbTvaOui=new JRadioButton("oui",true); rbTvaNon=new JRadioButton("non");
		typeGroupe=new ButtonGroup(); typeGroupe.add(rbPPhy);typeGroupe.add(rbpmor);
		etatGroupe=new ButtonGroup(); etatGroupe.add(rbTvaOui); etatGroupe.add(rbTvaNon);
		
		
		btnAjoutCompte=new JButton("Ajout"); btnConsulterComptes=new JButton("consulter");
		btnAjoutPersonne=new JButton("Ajouter");
	
		//ajout de comppsant
		jp1.add(lnew);
		jp2.add(lCode);
		jp2.add(tfCode);
		jp3.add(lMatricule);
		jp3.add(tfMatricule);
		jp4.add(lRaison);
		jp4.add(tfRaison);
		jp5.add(lType);
		jp5.add(rbpmor);
		jp5.add(rbPPhy);
		jp6.add(lDescription);
		jp6.add(tfDescription);
		jpComptes.add(btnAjoutCompte);
		jpComptes.add(btnConsulterComptes);
		jp7.add(lComptes);
		jp7.add(jpComptes);
		jpAdress.add(lNumrue);jpAdress.add(tfNumRue);
		jpAdress.add(lrue);jpAdress.add(tfrue);
		jpAdress.add(lville);jpAdress.add(tfville);
		jpAdress.add(lCodePostale);jpAdress.add(tfcodePostale);
		jpAdress.add(lgov);jpAdress.add(tfgov);
		jpAdress.add(lpays);jpAdress.add(tfpays);
		jp8.add(lAdress);
		jp8.add(jpAdress);
		jp9.add(lNumFixe);
		jp9.add(tfNumFixe);		
		jp10.add(lNumPortable);
		jp10.add(tfNumPortable);
		jp11.add(lFax);
		jp11.add(tfFax);
		jp12.add(lEmail);
		jp12.add(tfEmail);
		jp13.add(lSiteWeb);
		jp13.add(tfSiteWeb);
		jp14.add(letatFiscale);
		jp14.add(rbTvaOui);
		jp14.add(rbTvaNon);
		jp15.add(btnAjoutPersonne);
		btnAjoutCompte.addActionListener((e)->{
			String code=tfCode.getText();
			if (code.isEmpty()) {
				JOptionPane.showMessageDialog(this,
						 " le code Doit etre remplir", 
						 "erreur",JOptionPane.WARNING_MESSAGE);
			}else {
			FenetreAjouteCompte fc=new FenetreAjouteCompte(vComptes,code);
			}
			});
		btnConsulterComptes.addActionListener((e)->{
			if(vComptes.size()==0) {
				JOptionPane.showMessageDialog(this,
						 " comptes vide", 
						 "erreur",JOptionPane.WARNING_MESSAGE);
				return;
			}
			FenetreConsulterCompte fc=new FenetreConsulterCompte(vComptes);
			fc.setVisible(true);
		});
		btnAjoutPersonne.addActionListener((e)->{
			if((tfCode.getText().trim().compareTo("")==0)&&(tfRaison.getText().trim().compareTo("")==0)) {
				JOptionPane.showMessageDialog(this,
						 " remplir les champ obligatoire", 
						 "erreur",JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			if(btnAjoutPersonne.getText().equalsIgnoreCase("modifier")) {
				if(cOuF.equalsIgnoreCase("fournisseur")) {
					FornisseurService fs=new FornisseurService();
					fs.updateFournisseur( this.getPersonne());
				}else {
					ClientService cs=new ClientService();
					cs.updateClient(this.getPersonne());
				}
				
			}else {
				if(cOuF.equalsIgnoreCase("fournisseur")) {
					FornisseurService fs=new FornisseurService();
					fs.ajoutFournisseur( this.getPersonne());
				}else {
					ClientService cs=new ClientService();
					cs.ajoutClient( this.getPersonne());
				}
				
				
			}
			dispose();
			
			
		});
		
		
		contentPane.add(jp1);	contentPane.add(jp2);
		contentPane.add(jp3);   contentPane.add(jp4);
		contentPane.add(jp5);	contentPane.add(jp6);
		contentPane.add(jp7);	contentPane.add(jp8);
		contentPane.add(jp9);	contentPane.add(jp10);
		contentPane.add(jp11);   contentPane.add(jp12);
		contentPane.add(jp13);	contentPane.add(jp14);
		contentPane.add(jp15);
		
   		ControleTestField.limterTaille(tfMatricule,15);
		
		
   		tfMatricule.addKeyListener(new KeyAdapter() {
  	       public void keyTyped(KeyEvent e) { 
 	           if ((tfMatricule.getText().length() == 8)||(tfMatricule.getText().length()==11) ) 
 	               tfMatricule.setText(tfMatricule.getText()+"/");
 	       
 	       }
  	       });
   		ControleTestField.limterTaille(tfNumRue,2);
   		ControleTestField.accepteChiffres(tfNumRue);
   		ControleTestField.limterTaille(tfcodePostale,4);
   		ControleTestField.accepteChiffres(tfcodePostale);
   		ControleTestField.limterTaille(tfNumFixe,8);
   		ControleTestField.accepteChiffres(tfNumFixe);
   		ControleTestField.limterTaille(tfNumPortable,8);
   		ControleTestField.accepteChiffres(tfNumPortable);
   		ControleTestField.limterTaille(tfFax,8);
   		ControleTestField.accepteChiffres(tfFax);
   		ControleTestField.delEspace(tfrue);
   		ControleTestField.delEspace(tfville);
   		ControleTestField.delEspace(tfgov);
   		ControleTestField.delEspace(tfpays);
   		
   		
   		
   		
   		
   		
   		}
	
	private Personne getPersonne() {
		
		
		
		
		String code=tfCode.getText();
		//ControleTestField.verifierchaine(this, code);
		String matricule=tfMatricule.getText();
		//ControleTestField.verifierchaine(this, matricule);
		String raison=tfRaison.getText();
		//ControleTestField.verifierchaine(this, raison);
		String type;
		String desecription=tfDescription.getText();
		//ControleTestField.verifierchaine(this, desecription);
		String numRue=tfNumRue.getText();
		//ControleTestField.verifierchaine(this, numRue);
		String rue=tfrue.getText();
		//ControleTestField.verifierchaine(this, rue);
		String ville=tfville.getText();
		//ControleTestField.verifierchaine(this, ville);
		String codePostale=tfcodePostale.getText();
		String gov=tfgov.getText();
		//ControleTestField.verifierchaine(this, gov);
		String pays=tfpays.getText();
		//ControleTestField.verifierchaine(this, pays);
		String adress=numRue+" "+rue+" "+ville+" "+codePostale+" "+gov+" "+pays;
		String numfixe=tfNumFixe.getText();
		//ControleTestField.verifierchaine(this, numfixe);
		String numportable=tfNumPortable.getText();
		String fax=tfFax.getText();
		String email=tfEmail.getText();
		String siteWeb=tfSiteWeb.getText();
		String etatFiscale;
		
		if(typeGroupe.getSelection()==rbPPhy) { type="phisique";}
		else {type = "morale";}
		if(typeGroupe.getSelection()==rbTvaNon) { etatFiscale="Nom";}
		else {etatFiscale = "oui";}
		Personne p=new Personne(code, matricule, raison, type, desecription, vComptes, adress, numfixe, numportable, fax, email, siteWeb, etatFiscale);
		
		
		
	return p;	
	}
	public void remplirClient(Personne c) {
		
	tfCode.setText(c.getCode());
	tfCode.setEditable(false);
	tfMatricule.setText(c.getMatriculeFiscale());
	if(c.getType().equalsIgnoreCase("physique")) {
		rbPPhy.setSelected(true);
		rbpmor.setSelected(false);
		
	}else {
		rbpmor.setSelected(true);
		rbPPhy.setSelected(false);
	}
	tfRaison.setText(c.getRaisonSocial());
	String[]add=c.getAddress().split(" ");
	tfrue.setText(add[0]);
	tfNumRue.setText(add[1]);
	tfville.setText(add[2]);
	tfcodePostale.setText(add[3]);
	tfgov.setText(add[4]);
	tfpays.setText(add[5]);
	
		
	tfDescription.setText(c.getDescriptionActivite());
	tfNumFixe.setText(c.getNumTelFixe());
	tfNumPortable.setText(c.getNumTelPortable());
	tfFax.setText(c.getFax());
	tfEmail.setText(c.geteMail());
	tfSiteWeb.setText(c.getSiteWeb());
	if(c.getEtatFiscale().equalsIgnoreCase("oui")) {
		rbTvaOui.setSelected(true);
		rbTvaNon.setSelected(false);
	}else {
		rbTvaOui.setSelected(false);
		rbTvaNon.setSelected(true);
		
	}}
	public void remplirFournisseur(Fournisseur c) {
		
		tfCode.setText(c.getCode());
		tfCode.setEditable(false);
		tfMatricule.setText(c.getMatriculeFiscale());
		if(c.getType().equalsIgnoreCase("physique")) {
			rbpmor.setSelected(false);
			rbPPhy.setSelected(true);
		}else {
			rbpmor.setSelected(true);
			rbPPhy.setSelected(false);
		}
		String[]add=c.getAddress().split(" ");
		tfrue.setText(add[0]);
		tfNumRue.setText(add[1]);
		tfville.setText(add[2]);
		tfcodePostale.setText(add[3]);
		tfgov.setText(add[4]);
		tfpays.setText(add[5]);
		
			
		tfDescription.setText(c.getDescriptionActivite());
		tfNumFixe.setText(c.getNumTelFixe());
		tfNumPortable.setText(c.getNumTelPortable());
		tfEmail.setText(c.geteMail());
		tfSiteWeb.setText(c.getSiteWeb());
		if(c.getEtatFiscale().equalsIgnoreCase("oui")) {
			rbTvaOui.setSelected(true);
			rbTvaNon.setSelected(false);
		}else {
			rbTvaOui.setSelected(false);
			rbTvaNon.setSelected(true);
			
		}
		
	
		
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


