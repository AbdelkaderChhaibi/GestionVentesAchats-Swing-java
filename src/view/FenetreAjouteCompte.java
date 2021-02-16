package view;

import java.awt.Container;
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
import modeles.CompteBancaire;

public class FenetreAjouteCompte extends JFrame {

	private static final long serialVersionUID = 7469139299985300675L;

	public JLabel lAjout, lBanque,lAgence,lRIB;
	public JTextField tfBanque,tfAgence,tfRIB;
	public JButton btnAjouter;


	private String code;
	

	
	public FenetreAjouteCompte(Vector<CompteBancaire> vb,String code) {
		this.code=code;
		//reglage fenetre
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		setLocationRelativeTo(null);
		setResizable(false);
		//declaration de jlabel
		JPanel contentPane=(JPanel)this.getContentPane();
		contentPane.setLayout(new GridLayout(5,1));
		contentPane.setBorder(new EmptyBorder(20, 0, 0, 0));
		JPanel jp1=new JPanel();	
		JPanel jp2=new JPanel();
		JPanel jp3=new JPanel();
		JPanel jp4=new JPanel();
		JPanel jp5=new JPanel();
		//reglage de composant
		lAjout=new JLabel("Ajout compte");
		lBanque=new JLabel("Banque");
		lAgence=new JLabel("Agence");
		lRIB=new JLabel("RIB");
		tfBanque=new JTextField();
		tfAgence=new JTextField();
		tfRIB=new JTextField();
		btnAjouter=new JButton("Ajouter");
		tfBanque.setPreferredSize(new Dimension(100,30));
		tfAgence.setPreferredSize(new Dimension(100,30));
		tfRIB.setPreferredSize(new Dimension(100,30));
		tfRIB.setColumns(20);
		//ajout de composant
		jp1.add(lAjout);
		jp2.add(lBanque);
		jp2.add(tfBanque);
		jp3.add(lAgence);
		jp3.add(tfAgence);
		jp4.add(lRIB);
		jp4.add(tfRIB);
		jp5.add(btnAjouter);
		btnAjouter.addActionListener((e)->{		
			String banque ,agence ,rib;
		banque=tfBanque.getText().trim();
		agence=tfAgence.getText().trim();
		rib=tfRIB.getText().trim();
		if((banque.compareTo("")==0)&&(rib.compareTo("")==0)) {
			JOptionPane.showMessageDialog(this,
					 " remplir les champ obligatoire", 
					 "erreur",JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		
			vb.add(new CompteBancaire(banque, agence, rib, code));
			dispose();
		});
		contentPane.add(jp1);
		contentPane.add(jp2);
		contentPane.add(jp3);
		contentPane.add(jp4);
		contentPane.add(jp5);
						
		setVisible(true);
		
		ControleTestField.accepteChiffres(tfRIB);
		ControleTestField.limterTaille(tfRIB,20);
		
		
		
		
	}
	
	

}
