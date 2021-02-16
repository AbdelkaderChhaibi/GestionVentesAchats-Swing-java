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

import controles.ControleTestField;
import controles.ServiceEnterprise;
import modeles.CompteBancaire;
import modeles.Enterprise;
import modeles.Personne;

public class FenetreConsulterEnterprise extends JFrame {

	


	/**
	 * 
	 */
	private static final long serialVersionUID = -8444123002675619167L;
	public static JLabel lMatricule,lRaison,lType,lDescription,lComptes,
	lAdress,lNumFixe,lNumPortable,lFax,lEmail,lSiteWeb,letatFiscale,lNumrue,lrue,lville,lCodePostale,lgov,lpays;
	public static JTextField tfMatricule,tfRaison,tfNumRue,tfrue,tfville,tfcodePostale,tfgov,tfpays,tfNumFixe,tfNumPortable,
	tfFax,tfEmail,tfSiteWeb;
	public static JTextArea tfDescription;
	public static JRadioButton rbPPhy,rbpmor,rbTvaOui,rbTvaNon;
	public static ButtonGroup typeGroupe,etatGroupe;
	public static JButton btnAjoutCompte ,btnModif,btnConsulterComptes;
	public Vector<CompteBancaire> vComptes=new Vector<CompteBancaire>();
	
	
	

	public FenetreConsulterEnterprise() {
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
		lMatricule=new JLabel("Matricule:");
		lRaison=new JLabel("Raison sciale:");
		lType=new JLabel("Type:");
		lDescription=new JLabel("Desciption:");
		lComptes=new JLabel("Comptes bancaires:");
		lAdress=new JLabel("Address:");
		lNumFixe=new JLabel("TelFixe:");
		lNumPortable=new JLabel("telPortable");
		lFax=new JLabel("Fax:");
		lEmail=new JLabel("E_mail:");
		lSiteWeb=new JLabel("site web:");
		letatFiscale=new JLabel("etat fiscale:");
		lNumrue =new JLabel("numRue");
		lrue=new JLabel("rue");
		lville=new JLabel("ville");
		lCodePostale=new JLabel("codePostale");
		lgov=new JLabel("governot");
		lpays=new JLabel("pays");
		tfMatricule=new JTextField();	
		tfMatricule.setPreferredSize(new Dimension(100,30));
		tfMatricule.setEditable(false);
		tfRaison=new JTextField();
		tfRaison.setPreferredSize(new Dimension(100,30));
		tfRaison.setEditable(false);
		tfNumFixe=new JTextField();		
		tfNumFixe.setPreferredSize(new Dimension(100,30));
		tfNumFixe.setEditable(false);
		tfNumPortable=new JTextField(); 
		tfNumPortable.setPreferredSize(new Dimension(100,30));
		tfNumPortable.setEditable(false);
		tfFax=new JTextField(); 		
		tfFax.setPreferredSize(new Dimension(100,30));
		tfFax.setEditable(false);
		tfEmail=new JTextField();		
		tfEmail.setPreferredSize(new Dimension(100,30));
		tfEmail.setEditable(false);
		tfSiteWeb=new JTextField();     
		tfSiteWeb.setPreferredSize(new Dimension(100,30));
		tfSiteWeb.setEditable(false);
		tfDescription=new JTextArea();	
		tfDescription.setPreferredSize(new Dimension(100,30));
		tfDescription.setEditable(false);
		tfNumRue=new JTextField();		
		tfNumRue.setPreferredSize(new Dimension(20,30));
		tfNumRue.setEditable(false);
		tfrue=new JTextField();			
		tfrue.setPreferredSize(new Dimension(40,30));
		tfrue.setEditable(false);
		tfville=new JTextField();		
		tfville.setPreferredSize(new Dimension(40,30));
		tfville.setEditable(false);
		tfcodePostale=new JTextField();	
		tfcodePostale.setPreferredSize(new Dimension(30,30));
		tfcodePostale.setEditable(false);
		tfgov=new JTextField();			
		tfgov.setPreferredSize(new Dimension(40,30));
		tfgov.setEditable(false);
		tfpays=new JTextField();		
		tfpays.setPreferredSize(new Dimension(40,30));
		tfpays.setEditable(false);
		rbpmor=new JRadioButton("Morale",true); 
		rbPPhy=new JRadioButton("phisique");
		rbTvaOui=new JRadioButton("oui",true); 
		rbTvaNon=new JRadioButton("non");
		typeGroupe=new ButtonGroup(); 
		typeGroupe.add(rbPPhy);
		typeGroupe.add(rbpmor);
		etatGroupe=new ButtonGroup(); 
		etatGroupe.add(rbTvaOui); 
		etatGroupe.add(rbTvaNon);
		
		
		btnAjoutCompte=new JButton("Ajout");
		btnAjoutCompte.addActionListener((e)->{
			FenetreAjouteCompte f=new FenetreAjouteCompte(vComptes,tfMatricule.getText());
			f.setVisible(true);
			
		});
		
		
		
		
		btnConsulterComptes=new JButton("consulter");
		btnConsulterComptes.addActionListener((e)->{
			if(vComptes.size()==0) {
			JOptionPane.showMessageDialog(this,
					 " remplir les champ obligatoire", 
					 "erreur",JOptionPane.WARNING_MESSAGE);
			return;}
		FenetreConsulterCompte f=new FenetreConsulterCompte(vComptes);
		f.setVisible(true);
		
		
		});
		btnModif=new JButton("Modifier");	
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
		jpAdress.add(lNumrue);
		jpAdress.add(tfNumRue);
		jpAdress.add(lrue);
		jpAdress.add(tfrue);
		jpAdress.add(lville);
		jpAdress.add(tfville);
		jpAdress.add(lCodePostale);
		jpAdress.add(tfcodePostale);
		jpAdress.add(lgov);
		jpAdress.add(tfgov);
		jpAdress.add(lpays);
		jpAdress.add(tfpays);
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
		jp15.add(btnModif);
		btnModif.addActionListener((e)->{
			
			if(btnModif.getText().equalsIgnoreCase("modifier")) {
				btnModif.setText("Enregistrer");
				this.setModifiable();
				
			}
			else {
				ServiceEnterprise se=new ServiceEnterprise();
				se.modifEnterprise(this.getEnterprise());
				this.dispose();
			}
			
			
		});
		
		
		contentPane.add(jp1);	
		contentPane.add(jp2);
		contentPane.add(jp3);   
		contentPane.add(jp4);
		contentPane.add(jp5);	
		contentPane.add(jp6);
		contentPane.add(jp7);	
		contentPane.add(jp8);
		contentPane.add(jp9);	
		contentPane.add(jp10);
		contentPane.add(jp11);   
		contentPane.add(jp12);
		contentPane.add(jp13);	
		contentPane.add(jp14);
		contentPane.add(jp15);
    	
    	ServiceEnterprise se=new ServiceEnterprise();
    	Enterprise e1=se.getEnterprise();
    	remplir(e1);
	}
	
	
	private Enterprise getEnterprise() {
		
		
		
		
		

		String matricule=tfMatricule.getText();
		String raison=tfRaison.getText();
		String type;
		String desecription=tfDescription.getText();
		int numRue=Integer.parseInt(tfNumRue.getText());
		String rue=tfrue.getText();
		String ville=tfville.getText();
		int codePostale=Integer.parseInt(tfcodePostale.getText());
		String gov=tfgov.getText();
		String pays=tfpays.getText();
		String adress=numRue+" "+rue+" "+ville+" "+codePostale+" "+gov+" "+pays;
		String numfixe=tfNumFixe.getText();
		String numportable=tfNumPortable.getText();
		String fax=tfFax.getText();
		String email=tfEmail.getText();
		String siteWeb=tfSiteWeb.getText();
		String etatFiscale;
		
		if(typeGroupe.getSelection()==rbPPhy) { type="phisique";}
		else {type = "morale";}
		if(typeGroupe.getSelection()==rbTvaNon) { etatFiscale="Nom";}
		else {etatFiscale = "oui";}
		Enterprise e=new Enterprise( matricule, raison, type, desecription, vComptes, adress, numfixe, numportable, fax, email, siteWeb, etatFiscale);
		
		
		
		
		
		
		
		
		return e;
	}


	public void remplir(Enterprise c) {
		

	tfMatricule.setText(c.getMatriculeFiscale());
	vComptes=c.getComptebancaire();
	if(c.getType().equalsIgnoreCase("physique")) {
		rbPPhy.setSelected(true);
		rbpmor.setSelected(false);
		
	}else {
		rbpmor.setSelected(true);
		rbPPhy.setSelected(false);
	}
	tfRaison.setText(c.getRaisonSociale());
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
	
	public void setModifiable() {
		tfMatricule.setEditable(false);
		tfRaison.setEditable(true);
		tfrue.setEditable(true);
		tfNumRue.setEditable(true);
		tfville.setEditable(true);
		tfcodePostale.setEditable(true);
		tfgov.setEditable(true);
		tfpays.setEditable(true);
		tfNumFixe.setEditable(true);
		tfNumPortable.setEditable(true);
		tfFax.setEditable(true);
		tfEmail.setEditable(true);
		tfSiteWeb.setEditable(true);
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
	   		btnAjoutCompte.addActionListener((e)->{
				FenetreAjouteCompte f=new FenetreAjouteCompte(vComptes, tfMatricule.getText() );
			});
		
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


