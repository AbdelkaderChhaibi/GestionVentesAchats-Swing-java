package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controles.Connexion;

public class FenetreLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -787318670218136102L;
	public JLabel lLogin,lUser,lPass,lvide;
	public JTextField tfUser;
	public JPasswordField tfPass;
	public JButton bCon;
	

	
	
	public FenetreLogin() {
		//reglage de fenetre
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100,100,400,300);
		
		setLocationRelativeTo(null);
		
		//declaration de jlabel
		JPanel contentPane=(JPanel)this.getContentPane();
		contentPane.setLayout(new GridLayout(5,1));


		JPanel jp1=new JPanel();	
		JPanel jp2=new JPanel();
		JPanel jp3=new JPanel();
		JPanel jp4=new JPanel();
		JPanel jp5=new JPanel();
				
		jp2.setLayout(new FlowLayout(1,50,0));
		jp3.setLayout(new FlowLayout(1,20,0));

		
		
		//reglage des composants
		lLogin=new JLabel("LOGIN");
		lUser=new JLabel("Admin:");
		lPass=new JLabel("Mot de pass:");
		bCon=new JButton("Connexion");
		lvide=new JLabel("");
		tfUser=new JTextField();
		tfPass =new JPasswordField();
		tfPass.setPreferredSize(new Dimension(100,30));
		tfUser.setPreferredSize(new Dimension(100,30));


		
	
		
		//ajout de composants
		jp1.add(lLogin);
		jp2.add(lUser);
		jp2.add(tfUser);
		jp3.add(lPass);
		jp3.add(tfPass);
		jp4.add(bCon);
		jp5.add(lvide);
		
		contentPane.add(jp1);
		contentPane.add(jp2);
		contentPane.add(jp3);
		contentPane.add(jp4);
		contentPane.add(jp5);
		
		//action sur le boutton
		bCon.addActionListener((e)->{try {
			actionBtnConnexion(e);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}}) ;
	
		
		

		
		
		setVisible(true);


	}
	public void actionBtnConnexion(ActionEvent e) throws ClassNotFoundException, SQLException {
		String user,pass;
		
		user=tfUser.getText();
		pass=tfPass.getText();
		 if (user.isEmpty()||pass.isEmpty()) {
			 lvide.setText("remplir tout les champs");
			
		}else {
			
				Connexion m=new Connexion();
				Statement st=m.getCon().createStatement();
				String req="select * from admin where user='"+user+"'"+" and pass='"+pass+"'";
				 ResultSet rez=st.executeQuery(req);
				 if(rez.next()) {
					 FenetrePrincipale fa=new FenetrePrincipale();
					 dispose();
				 }else {
					 JOptionPane.showMessageDialog(this,
							 "mot de pass ou login inccorecte", 
							 "erreur",JOptionPane.WARNING_MESSAGE);
				 }
				
				
				
			
			
		}
		
		
	}	
	

}
