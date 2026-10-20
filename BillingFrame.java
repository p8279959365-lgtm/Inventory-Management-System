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
        
    }
}