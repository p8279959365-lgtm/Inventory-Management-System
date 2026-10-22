import java.awt.*;
import javax.swing.*;
class BillingFrame extends JPanel {


BillingFrame() 
{

setLayout(null);
setBackground(new Color(241,245,249));
// Customer Details Card
JPanel card1 = new JPanel();
card1.setLayout(null);





// CARD1 BOUND 
card1.setBounds(20, 50, 800, 140);
card1.setBackground(Color.WHITE);

card1.setBorder(
    BorderFactory.createLineBorder(
        new Color(220, 226, 235)
    )
);

// Heading
JLabel heading = new JLabel("Customer Details");
heading.setFont(new Font("Arial", Font.BOLD, 18));
heading.setBounds(15, 10, 250, 30);
card1.add(heading);

// Customer ID
JLabel idLabel = new JLabel("Customer Id");
idLabel.setBounds(15, 50, 150, 25);
card1.add(idLabel);

JTextField idField = new JTextField();
idField.setBounds(15, 80, 70, 30);
card1.add(idField);

// customer name
JLabel nameLabel = new JLabel("Customer Name");
nameLabel.setBounds(120, 50, 150, 25);
card1.add(nameLabel);

JTextField namefield = new JTextField();
namefield.setBounds(120, 80, 150, 30);
card1.add(namefield);

// CUSTOMER PHONE NUMBER PRIMARY KEY
JLabel phoneLabel = new JLabel("Phone Number");
phoneLabel.setBounds(290, 50, 150, 25);
card1.add(phoneLabel);

JTextField phoneField = new JTextField();
phoneField.setBounds(290, 80, 150, 30);
card1.add(phoneField);


// CUSTOMER EMAIL
JLabel emailLabel = new JLabel("Email ");
emailLabel.setBounds(450, 50, 150, 25);
card1.add(emailLabel);

JTextField emailField = new JTextField();
emailField.setBounds(450, 80, 150, 30);
card1.add(emailField);

// ADDING THE ADDNEW CUSTOMER BUTTON
JButton addcustomer=new JButton("Add Customer");
addcustomer.setBounds(620,80,130,30);
card1.add(addcustomer);



add(card1);







// NOW WE ARE ADDING THE PRODUCT ADDING CARD

JPanel card2=new JPanel();
card2.setBounds(20,200,800,140);
card2.setLayout(null);
card2.setBackground(Color.white);



JLabel heading2 = new JLabel("Product Details");
heading2.setFont(new Font("Arial", Font.BOLD, 18));
heading2.setBounds(15, 10, 250, 30);
card2.add(heading2);

// added the product id
JLabel productid=new JLabel("Product Id");
productid.setBounds(15,40,100,30);
card2.add(productid);

JTextField productfield=new JTextField();
productfield.setBounds(15,70,70,30);
card2.add(productfield);



// adding the product name
JLabel productname=new JLabel("Product Name");
productname.setBounds(115,40,100,30);
card2.add(productname);

JTextField productnamefield=new JTextField();
productnamefield.setBounds(115,70,130,30);
card2.add(productnamefield);

// adding the Available stock
JLabel availablestockLabel=new JLabel("Available Stock");
availablestockLabel.setBounds(265,40,100,30);
card2.add(availablestockLabel);

JTextField availablestockfield=new JTextField();
availablestockfield.setBounds(265,70,100,30);
card2.add(availablestockfield);


// selling price lable
JLabel sellingpriceLabel=new JLabel("Selling Price");
sellingpriceLabel.setBounds(380,40,100,30);
card2.add(sellingpriceLabel);

JTextField sellingpricefield=new JTextField();
sellingpricefield.setBounds(380,70,100,30);
card2.add(sellingpricefield);

// total cost label
JLabel quantity=new JLabel("Quantity");
quantity.setBounds(490,40,100,30);
card2.add(quantity);


JTextField quantityfield=new JTextField();
quantityfield.setBounds(490,70,50,30);
card2.add(quantityfield);



// total cost label
JLabel totalcost=new JLabel("Total Cost");
totalcost.setBounds(555,40,100,30);
card2.add(totalcost);


JTextField totalcostfield=new JTextField();
totalcostfield.setBounds(555,70,100,30);
card2.add(totalcostfield);


// adding button to add the product
JButton addproduct=new JButton("Add Product");
addproduct.setBounds(665,70,130,30);
card2.add(addproduct);



add(card2);




// new card for add products 


JPanel card3=new JPanel();
card3.setLayout(null);
card3.setBounds(20,360,800,450);
card3.setBackground(Color.white);

JLabel heading3 = new JLabel("Bill Items");
heading3.setFont(new Font("Arial", Font.BOLD, 18));
heading3.setBounds(15, 20, 250, 30);
card3.add(heading3);

// now will be loading the table we have to create it 














add(card3);
}
}