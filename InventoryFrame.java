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
    sidebar.setBounds(0,10,180,1000);
    sidebar.setLayout(null);
    // sidebar.setOpaque(true);
    // coloring the sidebar
    sidebar.setBackground(Color.BLUE);
   


    // adding sidebar to the inventory frame
    add(sidebar);


    // adding the label of inventory management system
    JLabel lheading=new JLabel("INVENTORY MANAGEMENT SYSTEM");
    lheading.setFont(new Font("Arial", Font.BOLD, 24));
    lheading.setBounds(500,0,1000,50);
    add(lheading);


    
    // NOW WORKING IN THE MAIN AREA 
    JPanel body=new JPanel();
    body.setBounds(150,10,1000,1000);
    body.setBackground(Color.PINK);
    add(body);
    body.setLayout(null);

    // adding the right sidebar
    JPanel RightSideBar=new JPanel();
    RightSideBar.setBounds(1150,10,800,1000);
    RightSideBar.setVisible(true);
    add(RightSideBar);


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

    // adding the table of stock
    
    // stock.addActionListener(new ActionListener(){
    //     public void actionPerformed(ActionEvent e)
    //     {
    //         JLabel proname,proid,probrand,prounitprice,proquantity,prototalcost;
    //         JTextField name,id,brand,unitprice,quantity,totalcost;
    //         RightSideBar.removeAll();

    //         proname=new JLabel("Product name");
    //         name=new JTextField("");

    //        proname.setBounds(10, 20, 120, 25);

    //         name.setBounds(10,30,100,30);
    //         RightSideBar.add(proname);
    //         RightSideBar.add(name);

    //          JTable table1=new JTable();
    //         JScrollPane sp=new JScrollPane(table1);
    //         sp.setBounds(100,0,800,1000);
    //         body.add(sp);
    //         loadTable(table1);

            

    //     }
    // });
    


    stock.addActionListener(e -> {

    body.removeAll();
    RightSideBar.removeAll();
    RightSideBar.setLayout(null);

    // Create stock table
    JTable table1 = new JTable();
    JScrollPane sp = new JScrollPane(table1);
    sp.setBounds(80, 30, 900, 850);
    body.add(sp);

    // Add Product Name label
    JLabel proname = new JLabel("Product Name");
    proname.setBounds(20, 20, 120, 25);
    RightSideBar.add(proname);

    // Add text field
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

    addStock.addActionListener(ep ->{

        String Product_name=name.getText();
        String product_id=id.getText();
        String product_supplier_id=supplier.getText();
        int product_supplier=Integer.parseInt(supplier.getText());
        int product_purchase_price=Integer.parseInt(purchase.getText());
        int product_selling_price=Integer.parseInt(sales.getText());
        int product_Quantity=Integer.parseInt(Quantity.getText());
        int product_total_cost=Integer.parseInt(TotalCost.getText());


        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
        }
        catch(Exception p)
        {


        p.printStackTrace();

        JOptionPane.showMessageDialog(null,"Error loading stock: " + p.getMessage());

        }
    }
    );



    









    // Refresh the interface
    body.revalidate();
    body.repaint();

    RightSideBar.revalidate();
    RightSideBar.repaint();


    // Load database records
    loadTable(table1);
});



    product.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            body.removeAll();
            body.add(new ProductFrame());
        }
    });


    






    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    // add how to read the table ie table "STOCK " from the data base using the statement 
    static void loadTable(JTable table1)
    {
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
