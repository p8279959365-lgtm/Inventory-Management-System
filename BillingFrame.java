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

card1.setBounds(20, 50, 1300, 160);
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

// Customer Name
JLabel idLabel = new JLabel("Customer Name");
idLabel.setBounds(15, 50, 150, 25);
card1.add(idLabel);

JTextField idField = new JTextField();
idField.setBounds(15, 80, 50, 30);
card1.add(idField);

// Phone Number
JLabel phoneLabel = new JLabel("Phone Number");
phoneLabel.setBounds(300, 50, 150, 25);
card1.add(phoneLabel);

JTextField phoneField = new JTextField();
phoneField.setBounds(300, 80, 250, 30);
card1.add(phoneField);


// JLabel nameLabel = new JLabel("Customer Name");
// nameLabel.setBounds(15, 50, 150, 25);
// card1.add(nameLabel);

// JTextField nameField = new JTextField();
// nameField.setBounds(15, 80, 250, 30);
// card1.add(nameField);

add(card1);
        
    }
}