package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;

import javafx.event.ActionEvent;

public class HeurePanel extends JPanel 
{
   private JLabel horloge;
   public HeurePanel() {
     setLayout(new BorderLayout());
     horloge = new JLabel();
     horloge.setHorizontalAlignment(JLabel.CENTER);
     horloge.setFont(
       UIManager.getFont("Label.font").deriveFont(Font.BOLD, 50f)
     );
     horloge.setText(
       DateFormat.getDateTimeInstance().format(new Date())
     );
     add(new JLabel("welcame"),BorderLayout.NORTH);
     add(horloge,BorderLayout.CENTER);
     Timer t = new Timer(500, new ActionListener() {
		@Override
		public void actionPerformed(java.awt.event.ActionEvent arg0) {
			// TODO Auto-generated method stub
	          horloge.setText(
	                  DateFormat.getDateTimeInstance().format(new Date())
	               );
		}
     });
     t.setRepeats(true);
     t.setCoalesce(true);
     t.setInitialDelay(0);
     t.start();
   }
}