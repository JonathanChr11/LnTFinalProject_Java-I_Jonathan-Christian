package PTPudding;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.*;

public class Home extends JFrame implements ActionListener {
	
	 Vector<Data> data;
	
	JPanel topPanel, midPanel, botPanel,
			midLblP;
	JLabel homeLbl, midLbl;
	JButton insertBtn, viewBtn, updateBtn, deleteBtn;

	
	public Home(Vector<Data> data) {
		
		this.data = data;
		
		Dimension dimensionSize = new Dimension(130, 30);
		
		// Top Panel
		topPanel = new JPanel();
		homeLbl = new JLabel("Home");
		topPanel.add(homeLbl);
		
		// Mid Panel
		midPanel = new JPanel();
		
		midLblP = new JPanel();
		midLblP.setBorder(new EmptyBorder(100, 0, 0, 0));
		
		midLbl = new JLabel("Please Choose 1 option!");
		
		midLblP.add(midLbl);
		
		// Add all panel to midpanel
		midPanel.add(midLblP);
		
		// Bot Panel
		botPanel = new JPanel(new GridLayout(2, 2));
		insertBtn = new JButton("Insert Data");
		insertBtn.addActionListener(this);
		
		viewBtn = new JButton("View Data");
		viewBtn.addActionListener(this);
		
		updateBtn = new JButton("Update Data");
		updateBtn.addActionListener(this);
		
		deleteBtn = new JButton("Delete Data");
		deleteBtn.addActionListener(this);
		
		botPanel.add(insertBtn);
		botPanel.add(viewBtn);
		botPanel.add(updateBtn);
		botPanel.add(deleteBtn);
		
		
		// Add all panel to Frame
		add(topPanel, BorderLayout.NORTH);
		add(midPanel, BorderLayout.CENTER);
		add(botPanel, BorderLayout.SOUTH);
		setup();
	}
	
	void setup() {
		setVisible(true);
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Home");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == insertBtn) {
			 this.dispose();
			 
             new insertMenu(data);
		}
		 else if(e.getSource() == viewBtn) {
	            this.dispose();

	            new viewMenu(data);
	        }
		 else if(e.getSource() == updateBtn) {
	            this.dispose();
	            
	            new updateMenu(data);
	            
	        }
		 else if(e.getSource() == deleteBtn) {
	            this.dispose();

	            new deleteMenu(data);
	            
	        }
	}
}
