package PTPudding;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import PTPudding_Database.config.DBConnection;

public class updateMenu extends JFrame implements ActionListener, MouseListener, MenuListener {
	
	Vector<Data> data;
	DBConnection dbConnection;

	 JPanel topPanel, midPanel, midLeftPanel, midRightPanel, botPanel;
	 JLabel insertLbl, idLbl, nameLbl, priceLbl, stockLbl;
	 JTextField idText, nameText, priceText, stockText;
	 JPanel idLblP, nameLblP, priceLblP, stockLblP,
	            idTextP, nameTextP, priceTextP, stockTextP, userTableP;
	JButton updateBtn, clearBtn, backBtn;
	JTable userTable;
	JScrollPane tableScrollPane;

	public updateMenu(Vector<Data> data) {
		/*populate the vector user*/
		this.data = data;
		
		 Dimension box = new Dimension(130, 30);
		
		/*MidPanel*/
		midPanel = new JPanel(new GridLayout(1, 2));
		
		/*MidLeftPanel*/
		midLeftPanel = new JPanel(new GridLayout(4, 2));
		
		 //Id
        idLblP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idLblP.setBorder(new EmptyBorder(0, 90, 0, 0));
        idTextP = new JPanel();
        
        idLbl = new JLabel("ID");
        idText = new JTextField();
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

		
		midLeftPanel.add(idLblP);
		midLeftPanel.add(idTextP);
		midLeftPanel.add(nameLblP);
		midLeftPanel.add(nameTextP);
		midLeftPanel.add(priceLblP);
		midLeftPanel.add(priceTextP);
		midLeftPanel.add(stockLblP);
		midLeftPanel.add(stockTextP);
		/*MidRightPanel*/

		/*Table*/
		midRightPanel = new JPanel();
		
		//take column
		Vector<Object> column = new Vector<>();
		column.add("ID");
		column.add("Name");
		column.add("Price");
		column.add("Stock");
	
		//take row
		Vector<Vector<Object>> row = new Vector<Vector<Object>>();
		for(Data x : data) {
			Vector<Object> curr = new Vector<>();
			curr.add(x.getId());
			curr.add(x.getName());    
			curr.add(x.getPrice());
			curr.add(x.getStock());
			
			row.add(curr);
		}
		
		userTable = new JTable(row, column);
		userTable.addMouseListener(this);
		tableScrollPane = new JScrollPane(userTable);
		tableScrollPane.setPreferredSize(new Dimension(350, 300));
		userTableP = new JPanel();
		userTableP.add(tableScrollPane);
		
		midPanel.add(midLeftPanel);
		midPanel.add(userTableP);
		
		/*BotPanel*/
		JPanel botPanel = new JPanel();
		
		updateBtn = new JButton("Update");
        updateBtn.setPreferredSize(new Dimension(90, 30));
        updateBtn.addActionListener(this);
		
		clearBtn = new JButton("Clear");
        clearBtn.setPreferredSize(new Dimension(90, 30));
        clearBtn.addActionListener(this);
        
        backBtn = new JButton("Back");
        backBtn.setPreferredSize(new Dimension(90, 30));
        backBtn.addActionListener(this);

        botPanel.add(updateBtn);
        botPanel.add(clearBtn);
        botPanel.add(backBtn);


		/*Add to Frame*/
		add(midPanel, BorderLayout.CENTER);
		add(botPanel, BorderLayout.SOUTH);
		
		setup();
	}
	
	void setup() {
		setVisible(true);
		setSize(900, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Update Data");
	}

	@Override
	public void menuSelected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == userTable) {
			int row = userTable.getSelectedRow();

			idText.setText(String.valueOf(userTable.getValueAt(row, 0)));
			nameText.setText(String.valueOf(userTable.getValueAt(row, 1)));
			priceText.setText(String.valueOf(userTable.getValueAt(row, 2)));
			stockText.setText(String.valueOf(userTable.getValueAt(row, 3)));
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == updateBtn) {
			String id = idText.getText();
			 String name = nameText.getText();
	         String price = priceText.getText();
	         String stock = stockText.getText();
	         
	         if(checkValidUser(name, price, stock)) {
	             for (int x = 0; x < data.size(); x++) {
	            	 if (data.get(x).getId().equals(id)) {
	            		 data.set(x, new Data (id, name, price, stock));
	            		 break;
	            	 }
	             }
	                this.dispose();
	                new viewMenu(data);
	            }
		}
		
		if (e.getSource() == clearBtn) {
			idText.setText("");
			nameText.setText("");
			priceText.setText("");
			stockText.setText("");
		}
		
		if(e.getSource() == backBtn) {
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
