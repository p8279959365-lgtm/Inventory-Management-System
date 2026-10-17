import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class InventoryFrame extends JFrame
{
    InventoryFrame()
    {

    setSize(1000,1000);
    setLayout(null);





    

    
    // crating buttons for the navigation
    JButton product,sales,purchase,billing,supplier,stock,customer;
    // panel for side bar
    JPanel sidebar=new JPanel();
    // positioning the sidebar
    sidebar.setBounds(0, 0, 180, 950);
    sidebar.setLayout(null);
    // sidebar.setOpaque(true);
    // coloring the sidebar
    sidebar.setBackground(Color.BLUE);


    // adding sidebar to the inventory frame
    add(sidebar);

    //
    


    // adding the label of inventory management system
    JLabel lheading=new JLabel("INVENTORY MANAGEMENT SYSTEM");
    lheading.setFont(new Font("Arial", Font.BOLD, 24));
    lheading.setBounds(500,0,1000,50);
    add(lheading);






















    
    // NOW WORKING IN THE MAIN AREA 
    JPanel body=new JPanel();
    body.setBounds(200, 50, 950, 650);
    add(body);
    body.setLayout(null);
    

    // adding the right sidebar
    JPanel RightSideBar=new JPanel();
    RightSideBar.setBounds(1200, 40, 350, 580);
    RightSideBar.setVisible(true);
    add(RightSideBar);




    // adding the total cost at the bottom of the table

    JPanel lowerbar=new JPanel();
    lowerbar.setBounds(180, 620, 820, 80);
    lowerbar.setVisible(true);
    add(lowerbar);


    // adding the product
    product=new JButton("PRODUCT");
    product.setBounds(20,40,120,30);
    // adding the product to the sidebar
    sidebar.add(product);

    // adding the sale
    sales=new JButton("SALES");
    sales.setBounds(20,80,120,30);
    sidebar.add(sales);

    // adding the purchase button
    purchase=new JButton("PURCHASE");
    purchase.setBounds(20,120,120,30);
    sidebar.add(purchase);



    // adding the stock button button
    stock=new JButton("STOCK");
    stock.setBounds(20,160,120,30);
    sidebar.add(stock);

    // adding the customer button
    customer=new JButton("CUSTOMER");
    customer.setBounds(20,200,120,30);
    sidebar.add(customer);

    // adding the suppier button
    supplier=new JButton("SUPPLIERS");
    supplier.setBounds(20,240,120,30);
    sidebar.add(supplier);

    // adding the billing button
    billing=new JButton("BILLING");
    billing.setBounds(20,280,120,30);
    sidebar.add(billing);



    // Sidebar
sidebar.setBackground(new Color(30, 41, 59));

// Main body
body.setBackground(new Color(241, 245, 249));
RightSideBar.setBackground(Color.WHITE);



stock.addActionListener(e -> {

    body.removeAll();
    RightSideBar.removeAll();
    RightSideBar.setLayout(null);

    // Create stock table
    JTable table1 = new JTable();
    JScrollPane sp = new JScrollPane(table1);
    sp.setBounds(0, 0, body.getWidth(), body.getHeight());
    body.add(sp);

    // Add Product Name label
    JLabel proname = new JLabel("Product Name");
    proname.setBounds(20, 20, 120, 25);
    RightSideBar.add(proname);

    JTextField name = new JTextField();
    name.setBounds(120, 20, 130, 30);
    RightSideBar.add(name);

    // Add product id 
    JLabel proid = new JLabel("Product Id");
    proid.setBounds(20, 60, 120, 25);
    RightSideBar.add(proid);

     JTextField id = new JTextField();
    id.setBounds(120, 60, 130, 30);
    RightSideBar.add(id);


    // Add product id 
    JLabel proSupplier = new JLabel("Supplier");
    proSupplier.setBounds(20, 100, 120, 25);
    RightSideBar.add(proSupplier);

     JTextField Supplier = new JTextField();
    Supplier.setBounds(120, 100, 130, 30);
    RightSideBar.add(Supplier);


     // add the Purchase cost 
    JLabel propurchasePrice = new JLabel("Purchase Price");
    propurchasePrice.setBounds(20, 140, 120, 25);
    RightSideBar.add(propurchasePrice);

     JTextField purchasePrice = new JTextField();
    purchasePrice.setBounds(120, 140, 130, 30);
    RightSideBar.add(purchasePrice);

    // add the Selling cost 
    JLabel prosellingPrice = new JLabel("Selling Price");
    prosellingPrice.setBounds(20, 180, 120, 25);
    RightSideBar.add(prosellingPrice);

     JTextField sellingPrice = new JTextField();
    sellingPrice.setBounds(120, 180, 130, 30);
    RightSideBar.add(sellingPrice);

    // adding the quantity
    JLabel proQuantity = new JLabel("QUANTITY");
    proQuantity.setBounds(20, 220, 120, 25);
    RightSideBar.add(proQuantity);

     JTextField Quantity = new JTextField();
    Quantity.setBounds(120, 220, 130, 30);
    RightSideBar.add(Quantity);


    // adding the totalcost
    JLabel proTotalCost = new JLabel("TOTAL COST");
    proTotalCost.setBounds(20, 260, 120, 25);
    RightSideBar.add(proTotalCost);

     JTextField TotalCost= new JTextField();
    TotalCost.setBounds(120, 260, 130, 30);
    RightSideBar.add(TotalCost);


     try{
    Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c=DriverManager.getConnection("jdbc:mysql://localHost:3306/Inventory","root","Vikram@300978");


            String sql = "SELECT COALESCE(SUM(total), 0) AS total_inventory_cost FROM stock";

PreparedStatement ps = c.prepareStatement(sql);
ResultSet rs = ps.executeQuery();

if (rs.next()) {
    JLabel costLabel=new JLabel("total Inventory : ");
    costLabel.setFont(new Font("Arial", Font.BOLD, 22));
    costLabel.setForeground(new Color(22, 163, 74));
    costLabel.setBounds(500,780,200,50);
    lowerbar.add(costLabel);
    double totalCost = rs.getDouble("total_inventory_cost");
    costLabel.setText("Total Inventory Cost: ₹" + totalCost);
}
    }
    catch(Exception exp)
    {

        JOptionPane.showMessageDialog(this,"the inventory cost cannot be displayed");

    }   



    // Calculate total cost automatically
purchasePrice.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {

    public void insertUpdate(javax.swing.event.DocumentEvent e) {
        calculateTotalCost();
    }

    public void removeUpdate(javax.swing.event.DocumentEvent e) {
        calculateTotalCost();
    }

    public void changedUpdate(javax.swing.event.DocumentEvent e) {
        calculateTotalCost();
    }

    private void calculateTotalCost() {
        try {
            double price = Double.parseDouble(purchasePrice.getText());
            int qty = Integer.parseInt(Quantity.getText());

            TotalCost.setText(String.valueOf(price * qty));

        } catch (NumberFormatException ex) {
            TotalCost.setText("");
        }
    }
});

Quantity.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {

    public void insertUpdate(javax.swing.event.DocumentEvent e) {
        calculateTotalCost();
    }

    public void removeUpdate(javax.swing.event.DocumentEvent e) {
        calculateTotalCost();
    }

    public void changedUpdate(javax.swing.event.DocumentEvent e) {
        calculateTotalCost();
    }

    private void calculateTotalCost() {
        try {
            double price = Double.parseDouble(purchasePrice.getText());
            int qty = Integer.parseInt(Quantity.getText());

            TotalCost.setText(String.valueOf(price * qty));

        } catch (NumberFormatException ex) {
            TotalCost.setText("");
        }
    }
});
    
    JButton addStock = new JButton("ADD STOCK");
    addStock.setBounds(20, 370, 130, 35);
    RightSideBar.add(addStock);
    
    JButton updateStock = new JButton("UPDATE STOCK");
    updateStock.setBounds(170, 370, 150, 35);
    RightSideBar.add(updateStock);
    
    JButton deleteStock = new JButton("DELETE STOCK");
    deleteStock.setBounds(20, 420, 130, 35);
    RightSideBar.add(deleteStock);
    
    JButton clearFields = new JButton("CLEAR FIELDS");
    clearFields.setBounds(170, 420, 150, 35);
    RightSideBar.add(clearFields);
    
    JButton refreshTable = new JButton("REFRESH TABLE");
    refreshTable.setBounds(20, 470, 300, 35);
    RightSideBar.add(refreshTable);

    String[] originalProductId = {null};








//total_cost




    addStock.addActionListener(ep ->{

        String Product_name=name.getText();
        int product_id=Integer.parseInt(id.getText());
        String product_supplier=Supplier.getText();
        int product_purchase_price=Integer.parseInt(purchasePrice.getText());
        int product_selling_price=Integer.parseInt(sellingPrice.getText());
        int product_Quantity=Integer.parseInt(Quantity.getText());
        float product_total_cost=Float.parseFloat(TotalCost.getText());



        


        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c=DriverManager.getConnection("jdbc:mysql://localHost:3306/Inventory","root","Vikram@300978");
            
            // Check whether Product ID already exists
String checkSql = "SELECT product_id FROM stock WHERE product_id = ?";

try (PreparedStatement checkStmt = c.prepareStatement(checkSql)) {

    checkStmt.setInt(1, product_id);

    try (ResultSet rs = checkStmt.executeQuery()) {

        if (rs.next()) {
            JOptionPane.showMessageDialog(
                this,
                "Product with this ID already exists!"
            );
            return; // Stop insertion
        }
    }
}

// If ID does not exist, continue with your INSERT query
            

            String sql1="insert into stock values (?,?,?,?,?,?,?)";
            PreparedStatement stmt2=c.prepareStatement(sql1);
            stmt2.setInt(1,product_id);
            stmt2.setString(2,Product_name);
            stmt2.setString(3,product_supplier);
            stmt2.setInt(4,product_purchase_price);
            stmt2.setInt(5,product_selling_price);
            stmt2.setInt(6,product_Quantity);
            stmt2.setFloat(7,product_total_cost);

            int r=stmt2.executeUpdate();
            // setting the value of the textbox as empty after the insertion in database 
            name.setText("");
            id.setText("");
            Supplier.setText("");
            purchasePrice.setText("");
            sellingPrice.setText("");
            Quantity.setText("");
            TotalCost.setText("");


            if(r>0)
            {
                JOptionPane.showMessageDialog(body,"item added ");
                loadTable(table1);

            }

            else{
                JOptionPane.showMessageDialog(body,"item not added");
            }

            c.close();


            
        }
        catch(Exception p)
        {


        p.printStackTrace();

        JOptionPane.showMessageDialog(null,"Error in adding stock: " + p.getMessage());

        }
    }
    );
















    deleteStock.addActionListener(eppp ->{
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Inventory","root","Vikram@300978");

            int id_to_be_deleted=Integer.parseInt(id.getText());

            PreparedStatement stmt1=conn.prepareStatement("delete from stock where PRODUCT_ID= ? ");

            stmt1.setInt(1,id_to_be_deleted);

            int del=stmt1.executeUpdate();

            if(del>0)
            {
                JOptionPane.showMessageDialog(this," ITEM DELETED");
            }
            else
            {
                JOptionPane.showMessageDialog(this," ITEM NOT DELETED");
            }
            loadTable(table1);

            conn.close();


        }
        catch(Exception exp)
        {
            JOptionPane.showMessageDialog(this,"the stock cannot be deleted there was some error");
        }
    });


















    updateStock.addActionListener(epp -> {

    if (originalProductId[0] == null) {
        JOptionPane.showMessageDialog(
            this, "Please select a product from the table first."
        );
        return;
    }

    try {
        String productName = name.getText().trim();
        String productId = id.getText().trim();
        String productSupplier = Supplier.getText().trim();

        int purchasee = Integer.parseInt(purchasePrice.getText().trim());
        int selling = Integer.parseInt(sellingPrice.getText().trim());
        int qty = Integer.parseInt(Quantity.getText().trim());
        Float total = Float.parseFloat(TotalCost.getText().trim());

        String sql = "UPDATE stock SET "
                + "product_name = ?, "
                + "product_id = ?, "
                + "supplier = ?, "
                + "purchase_price = ?, "
                + "selling_price = ?, "
                + "quantity = ?, "
                + "total = ? "
                + "WHERE product_id = ?";


        try (Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Inventory",
                    "root",
                    "Vikram@300978");
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, productName);
            ps.setString(2, productId);
            ps.setString(3, productSupplier);
            ps.setInt(4, purchasee);
            ps.setInt(5, selling);
            ps.setInt(6, qty);
            ps.setFloat(7, total);

            // Find the original record, even if its ID was edited
            ps.setString(8, originalProductId[0]);

            int result = ps.executeUpdate();

            name.setText("");
            id.setText("");
            Supplier.setText("");
            purchasePrice.setText("");
            sellingPrice.setText("");
            Quantity.setText("");
            TotalCost.setText("");


            if (result > 0) {
                JOptionPane.showMessageDialog(
                    this, "Stock updated successfully!"
                );

                originalProductId[0] = productId;

                // Show the updated values immediately
                loadTable(table1);
            } else {
                JOptionPane.showMessageDialog(
                    this, "No matching product was found."
                );
            }
        }

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(
            this, "Enter valid numeric values for prices and quantity."
        );
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(
            this, "Database error: " + ex.getMessage()
        );
        ex.printStackTrace();
    }
});
















clearFields.addActionListener(clf ->{

     name.setText("");
            id.setText("");
            Supplier.setText("");
            purchasePrice.setText("");
            sellingPrice.setText("");
            Quantity.setText("");
            TotalCost.setText("");

});

refreshTable.addActionListener(reft ->{
    loadTable(table1);
    JOptionPane.showMessageDialog(this,"Table refreshed");
});



    









    // Refresh the interface
    body.revalidate();
    body.repaint();

    RightSideBar.revalidate();
    RightSideBar.repaint();


    // Load database records
    loadTable(table1);
    table1.getSelectionModel().addListSelectionListener(epp-> {

        

    if (epp.getValueIsAdjusting()) {
        return;
    }

    int selectedRow = table1.getSelectedRow();

    if (selectedRow != -1) {

        int row = table1.convertRowIndexToModel(selectedRow);

        javax.swing.table.TableModel model = table1.getModel();

        name.setText(getColumnValue(model, row, "product_name"));
        id.setText(getColumnValue(model, row, "product_id"));
        Supplier.setText(getColumnValue(model, row, "supplier"));
        purchasePrice.setText(getColumnValue(model, row, "purchase_price"));
        sellingPrice.setText(getColumnValue(model, row, "selling_price"));
        Quantity.setText(getColumnValue(model, row, "quantity"));
        TotalCost.setText(getColumnValue(model, row, "total"));

    originalProductId[0] =
    getColumnValue(model, row, "product_id");
    }
});

});

    product.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(body,"WELCOME TO PRODUCT SECTION");
            body.removeAll();
            body.add(new ProductFrame());
            body.revalidate();
            body.repaint();

            RightSideBar.removeAll();
            RightSideBar.revalidate();
            RightSideBar.repaint();
        }
    });




    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    // add how to read the table ie table "STOCK " from the data base using the statement 

    static String getColumnValue(
        javax.swing.table.TableModel model,
        int row,
        String columnName) {

    for (int col = 0; col < model.getColumnCount(); col++) {

        if (model.getColumnName(col).equalsIgnoreCase(columnName)) {

            Object value = model.getValueAt(row, col);

            return value == null ? "" : value.toString();
        }
    }

    return "";
}
    static void loadTable(JTable table1)
    {

        table1.setFont(new Font("Arial", Font.PLAIN, 14));
        table1.setRowHeight(30);

        table1.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        // loadd the driver class establish
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            // connection establish 
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Inventory","root","Vikram@300978");

            Statement stmt=con.createStatement();
            ResultSet res=stmt.executeQuery("select * from stock");


            //adding the columns heading to the table
            ResultSetMetaData rsmd=res.getMetaData();
            int i;
            javax.swing.table.DefaultTableModel model =
            new javax.swing.table.DefaultTableModel();
            int countCol=rsmd.getColumnCount();
            for(i=1;i<=countCol;i++)
            {
                model.addColumn(rsmd.getColumnLabel(i));
            }

            while(res.next())
            {
                Object[] row=new Object[countCol];
                for(i=1;i<=countCol;i++)
                {
                    row[i-1]=res.getObject(i);
                }
                model.addRow(row);
            }
            table1.setModel(model);
            res.close();
        stmt.close();
        con.close();
    }
    catch (Exception e)
    {
        e.printStackTrace();

        JOptionPane.showMessageDialog(null,"Error loading stock: " + e.getMessage()
        );
        }
    }


}






