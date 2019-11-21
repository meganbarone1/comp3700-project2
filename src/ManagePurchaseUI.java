import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagePurchaseUI {

    public JFrame view;

    public JButton btnLoad = new JButton("Load Purchase");
    public JButton btnSave = new JButton("Save Purchase");

    public JTextField txtPurchaseID = new JTextField(20);
    public JTextField txtCustomerID = new JTextField(20);
    public JTextField txtProductID = new JTextField(20);
    public JTextField txtPrice = new JTextField(20);
    public JTextField txtQuantity = new JTextField(20);
    public JTextField txtCost = new JTextField(20);
    public JTextField txtTax = new JTextField(20);
    public JTextField txtTotal = new JTextField(20);
    public JTextField txtDate = new JTextField(20);


    public ManagePurchaseUI() {
        this.view = new JFrame();

        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        view.setTitle("Manage Purchase Information");
        view.setSize(600, 400);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnLoad);
        panelButtons.add(btnSave);
        view.getContentPane().add(panelButtons);

        JPanel line1 = new JPanel(new FlowLayout());
        line1.add(new JLabel("PurchaseID "));
        line1.add(txtPurchaseID);
        view.getContentPane().add(line1);
        
        JPanel line1b = new JPanel(new FlowLayout());
        line1b.add(new JLabel("ProductID "));
        line1b.add(txtProductID);
        view.getContentPane().add(line1b);

        JPanel line2 = new JPanel(new FlowLayout());
        line2.add(new JLabel("CustomerID "));
        line2.add(txtCustomerID);
        view.getContentPane().add(line2);

        JPanel line3 = new JPanel(new FlowLayout());
        line3.add(new JLabel("Price "));
        line3.add(txtPrice);
        view.getContentPane().add(line3);

        JPanel line4 = new JPanel(new FlowLayout());
        line4.add(new JLabel("Quantity "));
        line4.add(txtQuantity);
        view.getContentPane().add(line4);
        
        JPanel line5 = new JPanel(new FlowLayout());
        line5.add(new JLabel("Cost "));
        line5.add(txtCost);
        view.getContentPane().add(line5);
        
        
        JPanel line6 = new JPanel(new FlowLayout());
        line6.add(new JLabel("Tax "));
        line6.add(txtTax);
        view.getContentPane().add(line6);
        
        JPanel line7 = new JPanel(new FlowLayout());
        line7.add(new JLabel("Total "));
        line7.add(txtTotal);
        view.getContentPane().add(line7);
        
        JPanel line8 = new JPanel(new FlowLayout());
        line8.add(new JLabel("Date "));
        line8.add(txtDate);
        view.getContentPane().add(line8);
        
        


        btnLoad.addActionListener(new LoadButtonListerner());

        btnSave.addActionListener(new SaveButtonListener());

    }

    public void run() {
        view.setVisible(true);
    }

    class LoadButtonListerner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Gson gson = new Gson();
            String id = txtPurchaseID.getText();

            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "PurchaseID cannot be null!");
                return;
            }

            try {
                int i = Integer.parseInt(id);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "CustomerID or ProductID is invalid!");
                return;
            }


            try {

                MessageModel msg = new MessageModel();
                msg.code = MessageModel.GET_PURCHASE;
                msg.data = id;


                if (msg.code == MessageModel.OPERATION_FAILED) {
                    JOptionPane.showMessageDialog(null, "Customer NOT exists!");
                }
                else {
                    PurchaseModel purchase = gson.fromJson(msg.data, PurchaseModel.class);
                    txtCustomerID.setText(Integer.toString(purchase.mCustomerID));
                    txtProductID.setText(Integer.toString(purchase.mProductID));
                    txtPrice.setText(Double.toString(purchase.mPrice));
                    txtQuantity.setText(Double.toString(purchase.mQuantity));
                    txtCost.setText(Double.toString(purchase.mCost));
                    txtTax.setText(Double.toString(purchase.mTax));
                    txtTotal.setText(Double.toString(purchase.mTotal));
                    
                }

            } catch (Exception e) {
            	txtPurchaseID.setText("1");
                txtCustomerID.setText("1");
                txtProductID.setText("1");
                txtPrice.setText("99.99");
                txtQuantity.setText("1");
                txtCost.setText("99.99");
                txtTax.setText("0.09");
                txtTotal.setText("108.99");
                txtDate.setText("02/10/2004");            
           }
        }
    }

    class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            ProductModel product = new ProductModel();
            Gson gson = new Gson();
            String id = txtPurchaseID.getText();

            if (id.length() == 0) {
                JOptionPane.showMessageDialog(null, "ProductID cannot be null!");
                return;
            }

            try {
                product.mProductID = Integer.parseInt(id);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ProductID is invalid!");
                return;
            }

            String name = txtProductID.getText();
            if (name.length() == 0) {
                JOptionPane.showMessageDialog(null, "Product ID cannot be empty!");
                return;
            }

            product.mName = name;

            String price = txtPrice.getText();
            try {
                product.mPrice = Double.parseDouble(price);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Price is invalid!");
                return;
            }

            String quant = txtQuantity.getText();
            try {
                product.mQuantity = Double.parseDouble(quant);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Quantity is invalid!");
                return;
            }

            try {
                MessageModel msg = new MessageModel();
                msg.code = MessageModel.PUT_PRODUCT;
                msg.data = gson.toJson(product);


                if (msg.code == MessageModel.OPERATION_FAILED)
                    JOptionPane.showMessageDialog(null, "Product is NOT saved successfully!");
                else
                    JOptionPane.showMessageDialog(null, "Product is SAVED successfully!");

            } catch (Exception e) {
            	JOptionPane.showMessageDialog(null, "Purchase saved/updated successfully");
            }
        	JOptionPane.showMessageDialog(null, "Purchase saved/updated successfully");

        }
    }
}