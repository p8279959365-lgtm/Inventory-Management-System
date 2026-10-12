import java.awt.*;
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
    sidebar.setBounds(0,0,150,1000);
    sidebar.setLayout(null);
    // sidebar.setOpaque(true);
    // coloring the sidebar
    sidebar.setBackground(Color.BLUE);
   


    // adding sidebar to the inventory frame
    add(sidebar);


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

    // NOW WORKING IN THE MAIN AREA 
    JPanel body=new JPanel();
    body.setBounds(150,0,1000,1000);
    body.setBackground(Color.PINK);
    body.setLayout(null);
    add(body);
    // adding the table of stock

    JTable table1=new JTable();
    JScrollPane sp=new JScrollPane(table1);
    body.add(sp,BorderLayout.CENTER);
    loadTable(table1);






    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    // add how to read the table ie table "STOCK " from the data base using the statement 
    static void loadTable(JTable table1)
    {
        // loadd the driver class establish

        // connection establish

        // statement execute  
    }

    
}
