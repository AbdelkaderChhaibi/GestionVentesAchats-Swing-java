package view;

import java.text.ParseException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controles.FlibreService;
import modeles.BonReception;
import modeles.FactureFLibre;

public class FenetreGestionFF extends JFrame {

	private JPanel contentPane;
	public Vector<FactureFLibre> vbr=new Vector<FactureFLibre>();

	
	public FenetreGestionFF() {
		FlibreService brs=new FlibreService();
		try {
			vbr=brs.getAllFL();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 568, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane=(JPanel)getContentPane();
		Vector<String> col=new Vector<String>();
		  col.add("code");
		  //col.add("fourniseur");
		  col.add("datebon");
		  col.add("daterecep");
		  col.add("adress");
		  Vector<Vector<String>>data=new Vector<Vector<String>>();
		  for (FactureFLibre p : vbr) {
			  Vector<String> line=new Vector<String>();
			  line.add(p.getCode());
			  line.add(String.valueOf(p.getDateBon()));
			  line.add(String.valueOf(p.getDateReception()));
			  line.add(p.getAdress());
			  data.add(line);
		}
		contentPane.setLayout(null);
		JTable jtable=new JTable(data,col);
		JScrollPane sp=new JScrollPane(jtable);
		
		JPanel jp=new JPanel();
		jp.setBounds(0, 0, 562, 461);
		jp.add(sp);
		contentPane.add(jp);
		
		JButton btnSupp = new JButton("supp");
		btnSupp.setBounds(21, 574, 89, 23);
		contentPane.add(btnSupp);
		btnSupp.addActionListener((e)->{
			 
			try {
			String	sup = String.valueOf(jtable.getValueAt(jtable.getSelectedRow(), jtable.getSelectedColumn()));
			
			vbr.removeIf(p->p.getCode().equalsIgnoreCase(sup));
			brs.deleteFR(sup);
			data.removeAllElements();
			  for (FactureFLibre p : vbr) {
				  Vector<String> line=new Vector<String>();
				  line.add(p.getCode());
				  ///line.add(p.getFournisseur());
				  line.add(String.valueOf(p.getDateBon()));
				  line.add(String.valueOf(p.getDateReception()));
				  line.add(p.getAdress());
				  data.add(line);
			}
			  DefaultTableModel dm = (DefaultTableModel)jtable.getModel();
			  dm.fireTableDataChanged();
			
			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this,
						 "Merci de selectionner le code", 
						 "erreur",JOptionPane.WARNING_MESSAGE);
				
			}

		});
		
		JButton btnModif = new JButton("modif");
		btnModif.setBounds(295, 574, 89, 23);
		contentPane.add(btnModif);
		btnModif.addActionListener((e)->{
			FenetreAjoutFL f=new FenetreAjoutFL();
			FactureFLibre p2=new FactureFLibre();
			String s="2";
			try {
				s = String.valueOf(jtable.getValueAt(jtable.getSelectedRow(), jtable.getSelectedColumn()));
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this,
						 "Merci de selectionner le code", 
						 "erreur",JOptionPane.WARNING_MESSAGE);
			}
			for (FactureFLibre p : vbr) {
				if(p.getCode().equalsIgnoreCase(s)) {
					p2=p;
				}
				
			}
			f.remplirFL(p2);
			f.btnValider.setText("modifier");
			f.setVisible(true);
		});
		
		
		JButton btnAjout = new JButton("ajout");
		btnAjout.setBounds(441, 574, 89, 23);
		contentPane.add(btnAjout);
		btnAjout.addActionListener((e)->{
			FenetreAjoutFL f=new FenetreAjoutFL();
			f.setVisible(true);
		});
		
		JButton btnRefrech = new JButton("refrech");
		btnRefrech.setBounds(227, 490, 89, 23);
		contentPane.add(btnRefrech);
		
		JButton btnAfficheFacture = new JButton("Affiche Facture");
		btnAfficheFacture.addActionListener((e)-> {
			try {
				String s = String.valueOf(jtable.getValueAt(jtable.getSelectedRow(), jtable.getSelectedColumn()));
				
				FactureFLibre p2=new FactureFLibre();
				
				for (FactureFLibre p : vbr) {
					if(p.getCode().equalsIgnoreCase(s)) {
						p2=p;
					}
					
				}
				AfficheFactureL f=new AfficheFactureL(p2);
				f.setVisible(true);
			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this,
						 "Merci de selectionner le code", 
						 "erreur",JOptionPane.WARNING_MESSAGE);
			}
				
			
		});
		btnAfficheFacture.setBounds(146, 574, 107, 23);
		getContentPane().add(btnAfficheFacture);
		btnRefrech.addActionListener((e)->{
			data.removeAllElements();
			  for (FactureFLibre p : vbr) {
				  Vector<String> line=new Vector<String>();
				  line.add(p.getCode());
				  //line.add(p.getFournisseur());
				  line.add(String.valueOf(p.getDateBon()));
				  line.add(String.valueOf(p.getDateReception()));
				  line.add(p.getAdress());
				  data.add(line);
			}
			  DefaultTableModel dm = (DefaultTableModel)jtable.getModel();
			  dm.fireTableDataChanged();
		});
		
		
		
		
		
		
	}
}
