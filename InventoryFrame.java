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
    sidebar.setBounds(0,10,200,1000);
    sidebar.setLayout(null);
    // sidebar.setOpaque(true);
    // coloring the sidebar
    sidebar.setBackground(Color.BLUE);
   


    // adding sidebar to the inventory frame
    add(sidebar);


    // adding the label of inventory management system
    JLabel lheading=new JLabel("INVENTORY MANAGEMENT SYSTEM");
    lheading.setBounds(500,0,400,50);
    add(lheading);


    
    // NOW WORKING IN THE MAIN AREA 
    JPanel body=new JPanel();
    body.setBounds(150,10,1000,1000);
    body.setBackground(Color.PINK);
    add(body);
    body.setLayout(null);

    // adding the right sidebar
    JPanel RightSideBar=new JPanel();
    RightSideBar.setBounds(1150,10,150,1000);
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
    

    stock.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            JTable table1=new JTable();
            JScrollPane sp=new JScrollPane(table1);
            sp.setBounds(100,0,800,1000);
            body.add(sp);
            loadTable(table1);

        }
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
            for(i=1;i<=5;i++)
            {
                model.addColumn(rsmd.getColumnLabel(i));
            }

            while(res.next())
            {
                Object[] row=new Object[5];
                for(i=1;i<=5;i++)
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
