package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controles.ControleTestField;
import controles.FornisseurService;
import controles.ProduitService;
import modeles.FamilleProduit;
import modeles.Fournisseur;
import modeles.Produit;

public class FenetreAjoutProduit extends JFrame {


	private static final long serialVersionUID = 243300149532548207L;
	public JPanel contentPane;
	public JTextField tfReference;
	public JTextField tfDesignation;
	public JTextField tfUniteMesure;
	public JTextField tfFournisseur;
	public JTextField tfFamilleProduit;
	public JTextField tfStoke;
	public JTextField tfStokeMin;
	public JTextField tfPrixUnitaireHorsTaxe;
	public JTextField tfTaxeTva;
	public JButton btnAjouter;

	

	public FenetreAjoutProduit() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = (JPanel)getContentPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(10,1));
	
			JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		JPanel jp3=new JPanel();
		JPanel jp4=new JPanel();
		JPanel jp5=new JPanel();
		JPanel jp6=new JPanel();
		JPanel jp7=new JPanel();
		JPanel jp8=new JPanel();
		JPanel jp9=new JPanel();
		
		tfReference=new JTextField();
		tfReference.setPreferredSize(new Dimension(100,30));
		tfDesignation=new JTextField();
		tfDesignation.setPreferredSize(new Dimension(100,30));
		tfUniteMesure=new JTextField();
		tfUniteMesure.setPreferredSize(new Dimension(100,30));
		tfFournisseur=new JTextField();
		tfFournisseur.setPreferredSize(new Dimension(100,30));
		tfFamilleProduit=new JTextField();
		tfFamilleProduit.setPreferredSize(new Dimension(100,30));
		tfStoke=new JTextField();
		tfStoke.setPreferredSize(new Dimension(100,30));
		tfStokeMin=new JTextField();
		tfStokeMin.setPreferredSize(new Dimension(100,30));
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
		jp4.add(new JLabel("Fournisseur"));
		jp4.add(tfFournisseur);
		jp5.add(new JLabel("FamilleProduit"));
		jp5.add(tfFamilleProduit);
		jp6.add(new JLabel("Stoke"));
		jp6.add(tfStoke);
		jp7.add(new JLabel("StokeMin"));
		jp7.add(tfStokeMin);
		jp8.add(new JLabel("PrixUnitaireHorsTaxe"));
		jp8.add(tfPrixUnitaireHorsTaxe);
		jp9.add(new JLabel("TaxeTva"));
		jp9.add(tfTaxeTva);
		JPanel jp10=new JPanel();
		jp10.add(btnAjouter);
		btnAjouter.addActionListener((e)->{
			if((tfReference.getText().trim().compareTo("")==0)&&(tfPrixUnitaireHorsTaxe.getText().trim().compareTo("")==0)) {
				JOptionPane.showMessageDialog(this,
						 " remplir les champ obligatoire", 
						 "erreur",JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			ProduitService ps=new ProduitService();			 						
				Produit p=this.getproduit();
				if (btnAjouter.getText().equalsIgnoreCase("Ajouter")) {
					ps.ajoutProduit(p);
				
				}else {
					ps.modifProduit(p);
				
				}
				this.dispose();
				
		
			
			
			
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
		
		
		
		ControleTestField.accepteChiffres(tfStoke);
		ControleTestField.accepteChiffres(tfStokeMin);
		ControleTestField.accepteChiffresDicimal(tfPrixUnitaireHorsTaxe);
		ControleTestField.accepteChiffresDicimal(tfTaxeTva);
		
		

		

	}
	public void remplirproduit(Produit p) {
	tfReference.setText(p.getReference());;
	 tfDesignation.setText(p.getDesignation());
	tfUniteMesure.setText(p.getUniteMesure());
	tfFournisseur.setText(p.getFournisseur());
	tfFamilleProduit.setText(p.getFamilleproduit());
	tfStoke.setText(String.valueOf(p.getStoke()));
	tfStokeMin.setText(String.valueOf(p.getStokeMin()));
	tfPrixUnitaireHorsTaxe.setText(String.valueOf(p.getPrixUnitaireHorsTaxe()));
	tfTaxeTva.setText(String.valueOf(p.getTaxeTva()));	
	}
  public Produit getproduit(){
		 String reference=tfReference.getText();
		 String designation=tfDesignation.getText();
		 String uniteMesure=tfUniteMesure.getText();
		 String familleproduit=tfFamilleProduit.getText();
		 String fourniseur=tfFournisseur.getText();
		 int Stoke=Integer.parseInt(tfStoke.getText());
		 int StokeMin=Integer.parseInt(tfStokeMin.getText());
		 double prixUnitaireHorsTaxe=Double.parseDouble(tfPrixUnitaireHorsTaxe.getText());
		 double taxeTva=Double.parseDouble(tfTaxeTva.getText());
		 Produit p=new Produit(reference, designation, uniteMesure,fourniseur, familleproduit, Stoke, StokeMin, prixUnitaireHorsTaxe, taxeTva);
		 return p;
  }
}
