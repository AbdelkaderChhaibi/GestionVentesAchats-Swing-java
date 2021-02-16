package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modeles.BonReception;
import modeles.ProduitBR;

import javax.swing.JLabel;

public class AfficheFactureBR extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane1=new JPanel();
	
	public BonReception vp;
	public AfficheFactureBR(BonReception vp) {
		this.vp=vp;
		Double c=0.0;Double d=0.0;
		if(vp.getListeProduit().size()!=0) {
			d=vp.getMantontTotaleHorsTva();
			c=vp.getTtc();
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane =(JPanel)getContentPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane1.setLayout(new BoxLayout(contentPane1, BoxLayout.Y_AXIS));
		//contentPane.setLayout(new GridLayout(1,4));
		JPanel j=new JPanel();
		JPanel j0=new JPanel();
		j0.setLayout(new GridLayout(3,1));
		j.setLayout(new GridLayout(1,6));
		j.add(new JLabel("Quantite"));
		j.add(new JLabel("Reference"));
		j.add(new JLabel("PrixUHT"));
		j.add(new JLabel("Tva"));
		j.add(new JLabel("TotalHT"));
		j.add(new JLabel("Total"));
		contentPane.add(j,BorderLayout.NORTH);
		contentPane.add(contentPane1,BorderLayout.CENTER);
		
		
		for (ProduitBR p : vp.getListeProduit()) {
			
		createJpanel(p);
			
			
		}
		j0.add(new JLabel("MTHT:  "+c));
		j0.add(new JLabel("TTC:  "+d));
		JButton ok=new JButton("ok");
		ok.addActionListener((e)->dispose());
		contentPane.add(j0,BorderLayout.SOUTH);
	
		
		
	}
	private void createJpanel(ProduitBR p) {
		JPanel jp=new JPanel();
		jp.setLayout(new GridLayout(1,6));
		jp.add(new JLabel(""+p.getQuantite()+""));
		jp.add(new JLabel(p.getReference()));
		jp.add(new JLabel(p.getPrixUnitaireHorsTaxe()+""));
		jp.add(new JLabel(""+p.getTaxeTva()));
		jp.add(new JLabel(""+p.getPrixUnitaireHorsTaxe()*p.getQuantite()+""));
		jp.add(new JLabel(""+p.getPrixUnitaireHorsTaxe()*p.getQuantite()*(1+p.getTaxeTva())));
		contentPane1.add(jp,BorderLayout.CENTER);
		
		
		
		
		
		
		
	}

}
