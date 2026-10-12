import java.awt.*;
import javax.swing.*;
class InventoryFrame extends JFrame
{
    InventoryFrame()
    {

    setSize(1000,1000);
    setLayout(null);

    
    // crating buttons for the navigation
    JButton product,inventory,sales,purchase,bill,supplier;
    // panel for side bar
    JPanel sidebar=new JPanel();
    // positioning the sidebar
    sidebar.setBounds(0,0,200,1000);
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
    
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
}
