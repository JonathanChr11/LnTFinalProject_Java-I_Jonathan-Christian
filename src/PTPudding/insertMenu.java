package PTPudding;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class insertMenu extends JFrame  implements ActionListener {

	 Vector<Data> data;

	    JPanel topPanel, midPanel, botPanel;
	    JLabel insertLbl, idLbl, nameLbl, priceLbl, stockLbl;
	    JTextField idText, nameText, priceText, stockText;
	    JPanel idLblP, nameLblP, priceLblP, stockLblP,
	            idTextP, nameTextP, priceTextP, stockTextP;
	    JButton insertBtn, backBtn;
	
	public insertMenu(Vector<Data> data) {
		
		 String id = "";

	        //2 random char
	        for(int x=0;x<2;x++) {
	            int rand = (int) (Math.random() * 26);
	            id += (char)(rand + 'A');
	        }

	        //strip
	        id += '-';
	        
	        //4 random int
	        for(int x=0;x<3;x++) {
	            int rand = (int) (Math.random() * 10);
	            id += rand;
	        }
		
		
		//populate vector
        this.data = data;        

        Dimension box = new Dimension(130, 30);
        Color colorBG = Color.white;

        /*Top Panel */
        JPanel topPanel = new JPanel();
        JLabel insertLbl = new JLabel("Insert Data");
        topPanel.setBorder(new EmptyBorder(10, 0, 30, 0));
        topPanel.add(insertLbl);


        /*Mid Panel */
        JPanel midPanel = new JPanel();
        midPanel.setLayout(new GridLayout(5, 2));
        
        //Id
        idLblP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idLblP.setBorder(new EmptyBorder(0, 90, 0, 0));
        idTextP = new JPanel();
        
        idLbl = new JLabel("ID");
        idText = new JTextField(id);
        idText.setPreferredSize(box);
        idText.setEnabled(false);

        idLblP.add(idLbl);
        idTextP.add(idText);

        //Nama Menu
        nameLblP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameLblP.setBorder(new EmptyBorder(0, 90, 0, 0));
        nameTextP = new JPanel();
        
        nameLbl = new JLabel("Nama Menu");
        nameText = new JTextField();
        nameText.setPreferredSize(box);

        nameLblP.add(nameLbl);
        nameTextP.add(nameText);

        //Price
        priceLblP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        priceLblP.setBorder(new EmptyBorder(0, 90, 0, 0));
        priceTextP = new JPanel();
        
        priceLbl = new JLabel("Harga Menu (Rp.)");
        priceText = new JTextField();
        priceText.setPreferredSize(box);

        priceLblP.add(priceLbl);
        priceTextP.add(priceText);
        
      //Stock
        stockLblP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        stockLblP.setBorder(new EmptyBorder(0, 90, 0, 0));
        stockTextP = new JPanel();
        
        stockLbl = new JLabel("Stock Menu");
        stockText = new JTextField();
        stockText.setPreferredSize(box);

        stockLblP.add(stockLbl);
        stockTextP.add(stockText);
        
        //add all to mid panel
        midPanel.add(idLblP);
        midPanel.add(idTextP);
        midPanel.add(nameLblP);
        midPanel.add(nameTextP);
        midPanel.add(priceLblP);
        midPanel.add(priceTextP);
        midPanel.add(stockLblP);
        midPanel.add(stockTextP);

        /*Bottom Panel */
        JPanel botPanel = new JPanel();

        insertBtn = new JButton("Insert Data");
        insertBtn.addActionListener(this);
        insertBtn.setPreferredSize(new Dimension(120, 30));
        
        backBtn = new JButton("Back");
        backBtn.setPreferredSize(new Dimension(90, 30));
        backBtn.addActionListener(this);

        botPanel.add(insertBtn);
        botPanel.add(backBtn);
    
        /*Add all panel */
        add(topPanel, BorderLayout.NORTH);
        add(midPanel, BorderLayout.CENTER);
        add(botPanel, BorderLayout.SOUTH);

        setup();
	}
	
	 void setup() {
	        setVisible(true);
	        setSize(400, 450);
	        setResizable(false);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setTitle("Insert Data");
	    }

	@Override
	public void actionPerformed(ActionEvent e) {
if(e.getSource() == insertBtn) {
            
            //get current data
			String id = idText.getText();
            String name = nameText.getText();
            String price = priceText.getText();
            String stock = stockText.getText();

            // kasi logic sebelum add ke vector & kasi joptionpane
            if(checkValidUser(name, price, stock)) {
             
                //add to vector
                data.add(new Data(id, name, price, stock));

                this.dispose();
                
                new viewMenu(data);
                
            }
        }
        else if(e.getSource() == backBtn) {
            this.dispose();

            new Home(data);
        }
	}

	boolean checkValidUser(String name, String price, String stock) {
        if(name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name must be filled!", "Register Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if(price.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Price must be filled!", "Register Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(stock.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Stock must be filled!", "Register Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
}
