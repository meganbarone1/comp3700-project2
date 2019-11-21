import javax.swing.JTextField;

public class PurchaseModel {
    public int mPurchaseID, mProductID, mCustomerID;
    public double mPrice, mQuantity, mCost, mTax, mTotal;
    public String mDate;

    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(mPurchaseID).append(",");
        sb.append(mCustomerID).append(",");
        sb.append(mProductID).append(",");
        sb.append(mPrice).append(",");
        sb.append(mQuantity).append(",");
        sb.append(mCost).append(",");
        sb.append(mTax).append(",");
        sb.append(mTotal).append(",");
        sb.append("\"").append(mDate).append("\"").append(")");
        return sb.toString();
    }

}



public JTextField txtPurchaseID = new JTextField(20);
public JTextField txtCustomerID = new JTextField(20);
public JTextField txtProductID = new JTextField(20);
public JTextField txtPrice = new JTextField(20);
public JTextField txtQuantity = new JTextField(20);
public JTextField txtCost = new JTextField(20);
public JTextField txtTax = new JTextField(20);
public JTextField txtTotal = new JTextField(20);
public JTextField txtDate = new JTextField(20);