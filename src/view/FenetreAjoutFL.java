package view;

import java.awt.Dimension;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import controles.BRService;
import controles.ControleTestField;
import controles.FlibreService;
import modeles.BonReception;
import modeles.FactureFLibre;
import modeles.ProduitBR;

public class FenetreAjoutFL extends JFrame {
	public JPanel contentPane;
	public JTextField tfCode;
	public JTextField tffournisseur;
	public JCalendar tfDateBon;
	public JCalendar tfDateReception;
	public JTextField tfAdress;
	public JTextArea tfInfoRelative;
	public JTable jtable;
	public Vector<ProduitBR> vp;
	public JButton btnValider;
	

	public FenetreAjoutFL() {
		vp=new Vector<ProduitBR>();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 568, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane=(JPanel)getContentPane();
		contentPane.setLayout(null);		
		tfCode=new JTextField();
		  tffournisseur=new JTextField();
		  tfDateBon=new JCalendar();
		  tfDateReception=new JCalendar();
		  tfAdress=new JTextField();
		  tfInfoRelative=new JTextArea();
		  tfCode.setPreferredSize(new Dimension(100,30));
		  tffournisseur.setPreferredSize(new Dimension(100,30));
		  tfDateBon.setPreferredSize(new Dimension(100,30));
		  tfDateReception.setPreferredSize(new Dimension(100,30));
		  tfAdress.setPreferredSize(new Dimension(100,30));
		  tfInfoRelative.setPreferredSize(new Dimension(150, 40));
		  Vector<String> col=new Vector<String>();
		  col.add("ref");
		  col.add("quantite");
		  Vector<Vector<String>>data=new Vector<Vector<String>>();
		  for (ProduitBR p : vp) {
			  Vector<String> line=new Vector<String>();
			  line.add(p.getReference());
			  line.add(String.valueOf(p.getQuantite()));
			  data.add(line);
		}
		  
		jtable=new JTable(data, col);
		  JScrollPane sp=new JScrollPane(jtable);
		  jtable.setBounds(0, 266, 479, 354);
		  
		  
		  
		  JPanel jp1=new JPanel();
		  jp1.setBounds(0, 0, 267, 40);
		  JPanel jp2=new JPanel();
		  jp2.setBounds(267, 0, 267, 40);
		  JPanel jp3=new JPanel();
		  jp3.setBounds(0, 95, 267, 160);
		  JPanel jp4=new JPanel();
		  jp4.setBounds(267, 95, 275, 160);
		  JPanel jp5=new JPanel();
		  jp5.setBounds(0, 42, 267, 52);
		  JPanel jp6=new JPanel();
		  jp6.setBounds(267, 42, 267, 52);
		  JPanel jp7=new JPanel();
		  jp7.setBounds(0, 266, 479, 354);
		  jp1.add(new JLabel("code"));
		  jp2.add(new JLabel(""));
		  jp3.add(new JLabel("dateEmission"));
		  jp4.add(new JLabel("datereception"));
		  jp5.add(new JLabel("adress"));
		  jp6.add(new JLabel("inforelative"));
		  jp1.add(tfCode);
		  jp2.add(tffournisseur);
		  tffournisseur.setVisible(false);
		  jp3.add(tfDateBon);
		  jp4.add(tfDateReception);
		  jp5.add(tfAdress);
		  jp6.add(tfInfoRelative);
		  jp7.add(sp);
		  tfDateBon.setPreferredSize(new Dimension(180,150));
		  tfDateReception.setPreferredSize(new Dimension(180,150));
		  contentPane.add(jp1);
		  contentPane.add(jp2);
		  contentPane.add(jp5);
		  contentPane.add(jp6);		  
		  contentPane.add(jp3);
		  contentPane.add(jp4);
		  contentPane.add(jp7);
		  
		  JButton btnAjout = new JButton("ajout");
		  btnAjout.setBounds(489, 386, 73, 23);
		 contentPane.add(btnAjout);
		  btnAjout.addActionListener((e)->{
			  
			  FenetreAjoutProuduitBR ff=new FenetreAjoutProuduitBR(this.vp);
			  ff.setVisible(true);
			  
		  });
		  
		  JButton btnSupp = new JButton("supp");
		  btnSupp.setBounds(489, 434, 73, 23);
		  contentPane.add(btnSupp);
		  btnSupp.addActionListener((e)->{
			String sup =String.valueOf(jtable.getValueAt(jtable.getSelectedRow(), jtable.getSelectedColumn()));
				vp.removeIf(p->p.getReference().equalsIgnoreCase(sup));
				  data.removeAllElements();
				  for (ProduitBR p : vp) {
					  Vector<String> line=new Vector<String>();
					  line.add(p.getReference());
					  line.add(String.valueOf(p.getQuantite()));
					  data.add(line);
				}
				  DefaultTableModel dm = (DefaultTableModel)jtable.getModel();
				  dm.fireTableDataChanged();
				
			
			  
		  });

		  
		  btnValider = new JButton("Valider");
		  btnValider.setBounds(428, 631, 89, 23);
		  contentPane.add(btnValider);	
		  btnValider.addActionListener((e)->{
			  FlibreService brs=new FlibreService();
			  if(btnValider.getText().equalsIgnoreCase("valider")) {
				  brs.ajoutFl(getFL());
			  }else {
				  brs.updateFL(getFL());
			  }
			  
			  
			dispose();  
			  
		  });
		  
		  JButton btnRefrech = new JButton("refrech");
		  btnRefrech.setBounds(479, 296, 83, 23);
		  getContentPane().add(btnRefrech);
		  btnRefrech.addActionListener((e)->{
			  data.removeAllElements();
			  for (ProduitBR p : vp) {
				  Vector<String> line=new Vector<String>();
				  line.add(p.getReference());
				  line.add(String.valueOf(p.getQuantite()));
				  data.add(line);
			}
			  DefaultTableModel dm = (DefaultTableModel)jtable.getModel();
			  dm.fireTableDataChanged();

		
		  });
		  
		  
		   
		  
			  

		 
		  

	}
	public FactureFLibre getFL(){
		String code=tfCode.getText();//ControleTestField.verifierchaine(this, code);
		///String fournisseur=tffournisseur.getText();//ControleTestField.verifierchaine(this, fournisseur);
		Date dateBon=tfDateBon.getDate();
		 Date dateReception=tfDateReception.getDate();
		 String infoRelative=tfInfoRelative.getText();//ControleTestField.verifierchaine(this, infoRelative);
		 String adress=tfAdress.getText();	//ControleTestField.verifierchaine(this, adress);
		 FactureFLibre br=new FactureFLibre(code, dateBon, dateReception, adress, infoRelative, vp);
		return br;
		
	}
	public void remplirFL(FactureFLibre br) {
		this.vp=br.getListeProduit();
		tfCode.setText(br.getCode());
		//tffournisseur.setText(br.getFournisseur());
		tfDateBon.setDate(br.getDateBon());
		tfDateReception.setDate(br.getDateReception());
		tfAdress.setText(br.getAdress());
		tfInfoRelative.setText(br.getInfoRelative());
	}
}
