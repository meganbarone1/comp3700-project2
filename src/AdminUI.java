import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.google.gson.Gson;

public class AdminUI {
	public JFrame view;
	
	public JButton btnSetupSystem = new JButton("Setup System Configurations");
	public JButton btnAddUser = new JButton("Add New User");
	public JButton btnDeleteUser = new JButton("Delete Existing User");
	public JButton btnAdd = new JButton("Add");
	public JButton btnDelete = new JButton("Delete");
	public JButton btnCancel = new JButton("Cancel");
    
	public JTextField txtUsername = new JTextField(50);
    public JTextField txtPassword = new JTextField(50);
    public JTextField txtFullname = new JTextField(50);
    public JTextField txtUsertype = new JTextField(50);
	
	
	public AdminUI() {
		this.view = new JFrame();
		
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setTitle("Store Management System - Admin View");
        view.setSize(1000, 600);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JLabel title = new JLabel("Store Management System");

        title.setFont (title.getFont ().deriveFont (24.0f));
        view.getContentPane().add(title);

        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnSetupSystem);
        panelButtons.add(btnAddUser);
        panelButtons.add(btnDeleteUser);
        
        view.getContentPane().add(panelButtons);
        
        btnSetupSystem.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent actionEvent) {
        		
                
        	}
        });
        
        btnAddUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            	JPanel line1 = new JPanel(new FlowLayout());
                line1.add(new JLabel("Username "));
                line1.add(txtUsername);
                view.getContentPane().add(line1);

                JPanel line2 = new JPanel(new FlowLayout());
                line2.add(new JLabel("Password "));
                line2.add(txtPassword);
                view.getContentPane().add(line2);

                JPanel line3 = new JPanel(new FlowLayout());
                line3.add(new JLabel("Full Name "));
                line3.add(txtFullname);
                view.getContentPane().add(line3);

                JPanel line4 = new JPanel(new FlowLayout());
                line4.add(new JLabel("User Type "));
                line4.add(txtUsertype);
                view.getContentPane().add(line4);
                

                JPanel panelButtons = new JPanel(new FlowLayout());
                panelButtons.add(btnAdd);
                panelButtons.add(btnCancel);
                
                view.getContentPane().add(panelButtons);
                
                view.setVisible(true);
            }
        });
        
        btnDeleteUser.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent actionEvent) {
        		JPanel line1 = new JPanel(new FlowLayout());
                line1.add(new JLabel("Username "));
                line1.add(txtUsername);
                view.getContentPane().add(line1);

                JPanel line2 = new JPanel(new FlowLayout());
                line2.add(new JLabel("Password "));
                line2.add(txtPassword);
                view.getContentPane().add(line2);

                JPanel line3 = new JPanel(new FlowLayout());
                line3.add(new JLabel("Full Name "));
                line3.add(txtFullname);
                view.getContentPane().add(line3);

                JPanel line4 = new JPanel(new FlowLayout());
                line4.add(new JLabel("User Type "));
                line4.add(txtUsertype);
                view.getContentPane().add(line4);
                
                
                

                JPanel panelButtons = new JPanel(new FlowLayout());
                panelButtons.add(btnDelete);
                panelButtons.add(btnCancel);
                view.getContentPane().add(panelButtons);
                
                view.setVisible(true);
        	}
        });

	}
	
	public static void main(String[] args) {
		int port = 1000;
		AdminUI ui = new AdminUI();
		ui.view.setVisible(true);
	}
	
	
	
}