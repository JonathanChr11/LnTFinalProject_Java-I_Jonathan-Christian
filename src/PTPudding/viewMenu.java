package PTPudding;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;

public class viewMenu extends JFrame implements ActionListener, MouseListener, MenuListener {
	
	Vector<Data> data;

	JPanel midPanel, botPanel, userTableP;
	JLabel idLbl, nameLbl, priceLbl, stockLbl;
	JButton backBtn;
	JTable userTable;
	JScrollPane tableScrollPane;

	public viewMenu(Vector<Data> data) {
		/*populate the vector user*/
		this.data = data;

		/*get current user*/
		int counter = 0;
		
		String id, name, price, stock;
		
		for(int x=0;x<data.size();x++) {
			id = data.get(x).getId();
			name = data.get(x).getName();
			price = data.get(x).getPrice();
			stock = data.get(x).getStock();
			counter++;
		}

		
		/*MidPanel*/
//		midPanel = new JPanel(new GridLayout(5,1));
//
//		idLbl = new JLabel(id);
//		nameLbl = new JLabel(name);
//		priceLbl = new JLabel(price);
//		stockLbl = new JLabel(stock);
//		
//		midPanel.add(idLbl);
//		midPanel.add(nameLbl);
//		midPanel.add(priceLbl);
//		midPanel.add(stockLbl);

		/*Table*/
		userTableP = new JPanel();
		
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
		userTableP.add(tableScrollPane);
		
		/*BotPanel*/
		JPanel botPanel = new JPanel();
        
        backBtn = new JButton("Back");
        backBtn.setPreferredSize(new Dimension(90, 30));
        backBtn.addActionListener(this);

        botPanel.add(backBtn);


		/*Add to Frame*/
//		add(midPanel, BorderLayout.NORTH);
		add(userTableP, BorderLayout.CENTER);
		add(botPanel, BorderLayout.SOUTH);
		

		setup();
	}
	
	void setup() {
		setVisible(true);
		setSize(400, 450);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("View Data");
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

			idLbl.setText(String.valueOf(userTable.getValueAt(row, 0)));
			nameLbl.setText(String.valueOf(userTable.getValueAt(row, 1)));
			priceLbl.setText(String.valueOf(userTable.getValueAt(row, 2)));
			stockLbl.setText(String.valueOf(userTable.getValueAt(row, 3)));
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
		if(e.getSource() == backBtn) {
			this.dispose();
			new Home(data);
		}
	}

	
}
