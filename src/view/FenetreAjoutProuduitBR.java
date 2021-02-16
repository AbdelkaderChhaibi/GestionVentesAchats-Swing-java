package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controles.ControleTestField;
import controles.FornisseurService;
import controles.ProduitBRService;
import controles.ProduitService;
import modeles.Produit;
import modeles.ProduitBR;

public class FenetreAjoutProuduitBR extends JFrame {


	private static final long serialVersionUID = 243300149532548207L;
	public JPanel contentPane;
	public JTextField tfReference;
	public JTextField tfDesignation;
	public JTextField tfUniteMesure;
	public JTextField tfQuantite;
	public JTextField tfPrixUnitaireHorsTaxe;
	public JTextField tfTaxeTva;
	public JButton btnAjouter;
	public String codebr;

	

	public FenetreAjoutProuduitBR(Vector<ProduitBR> vp) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = (JPanel)getContentPane();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(10,1));
	
			JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		JPanel jp3=new JPanel();
		JPanel jp4=new JPanel();
		JPanel jp5=new JPanel();
		JPanel jp6=new JPanel();

		
		tfReference=new JTextField();
		tfReference.setPreferredSize(new Dimension(100,30));
		tfDesignation=new JTextField();
		tfDesignation.setPreferredSize(new Dimension(100,30));
		tfUniteMesure=new JTextField();
		tfUniteMesure.setPreferredSize(new Dimension(100,30));
		tfQuantite=new JTextField();
		tfQuantite.setPreferredSize(new Dimension(100,30));
		tfPrixUnitaireHorsTaxe=new JTextField();
		tfPrixUnitaireHorsTaxe.setPreferredSize(new Dimension(100,30));
		tfTaxeTva=new JTextField();
		tfTaxeTva.setPreferredSize(new Dimension(100,30));
		btnAjouter=new JButton("Ajouter");
		
		jp1.add(new JLabel("Reference"));
		jp1.add(tfReference);
		jp2.add(new JLabel("Designation"));
		jp2.add(tfDesignation);
		jp3.add(new JLabel("UniteMesure"));
		jp3.add(tfUniteMesure);
		jp4.add(new JLabel("quantite"));
		jp4.add(tfQuantite);
		jp5.add(new JLabel("PrixUnitaireHorsTaxe"));
		jp5.add(tfPrixUnitaireHorsTaxe);
		jp6.add(new JLabel("TaxeTva"));
		jp6.add(tfTaxeTva);
		JPanel jp7=new JPanel();
		jp7.add(btnAjouter);
		btnAjouter.addActionListener((e)->{
			
			if((tfReference.getText().trim().compareTo("")==0)&&(tfPrixUnitaireHorsTaxe.getText().trim().compareTo("")==0)) {
				JOptionPane.showMessageDialog(this,
						 " remplir les champ obligatoire", 
						 "erreur",JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			vp.add(getproduit());
				
				this.dispose();
				
		
			
			
			
		});
		contentPane.add(jp1);
		contentPane.add(jp2);
		contentPane.add(jp3);
		contentPane.add(jp4);
		contentPane.add(jp5);
		contentPane.add(jp6);
		contentPane.add(jp7);
	
		
		
		
		ControleTestField.accepteChiffres(tfQuantite);		
		ControleTestField.accepteChiffresDicimal(tfPrixUnitaireHorsTaxe);
		ControleTestField.accepteChiffresDicimal(tfTaxeTva);
		
		

		

	}
	public void remplirproduit(ProduitBR p) {
	tfReference.setText(p.getReference());;
	 tfDesignation.setText(p.getDesignation());
	tfUniteMesure.setText(p.getUniteMesure());
	tfQuantite.setText(String.valueOf(p.getQuantite()));
	tfPrixUnitaireHorsTaxe.setText(String.valueOf(p.getPrixUnitaireHorsTaxe()));
	tfTaxeTva.setText(String.valueOf(p.getTaxeTva()));	
	}
  public ProduitBR getproduit(){
		 String reference=tfReference.getText();
		 //ControleTestField.verifierchaine(this, reference);
		 String designation=tfDesignation.getText();
		 //ControleTestField.verifierchaine(this, designation);
		 String uniteMesure=tfUniteMesure.getText();
		 ///ControleTestField.verifierchaine(this, uniteMesure);
		 int quantite=Integer.parseInt(tfQuantite.getText());
		 //ControleTestField.verifierchaine(this, tfQuantite.getText());
		 double prixUnitaireHorsTaxe=Double.parseDouble(tfPrixUnitaireHorsTaxe.getText());
		 //ControleTestField.verifierchaine(this, tfPrixUnitaireHorsTaxe.getText());
		 double taxeTva=Double.parseDouble(tfTaxeTva.getText());
		 //ControleTestField.verifierchaine(this, tfTaxeTva.getText());
		 ProduitBR p=new ProduitBR(reference, designation, uniteMesure,quantite, prixUnitaireHorsTaxe, taxeTva);
		 return p;
  }
}
