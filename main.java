import java.sql.*;
import javax.swing.*;
class main
{
    public static void main(String[] args)
    {



        JFrame obj=new JFrame("inventory management system");
        obj.setSize(1000,1000);
        obj.setLayout(null);
        
        JLabel heading=new JLabel("INVENTORY MANAGENEMT SYSTEM ");
        heading.setBounds(520, 270, 500, 40);
        heading.setFont(new java.awt.Font("Arial",java.awt.Font.BOLD,24));
        obj.add(heading);


        JLabel name=new JLabel("User id");
        name.setBounds(600,350,100,20);
        obj.add(name);

        JTextField enterid=new JTextField("");
        enterid.setBounds(700,350,200,20);
        obj.add(enterid);


        JLabel password=new JLabel("Password");
        password.setBounds(600,385,100,20);
        obj.add(password);

        JPasswordField entrypassword=new JPasswordField("");
        entrypassword.setBounds(700,385,200,20);
        obj.add(entrypassword);


        JButton login = new JButton("LOGIN");
        login.setBounds(650, 440, 120, 35);
        obj.add(login);



        // BORDER TO THE LOGIN PAGE// 
        
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBounds(450, 230, 550, 280);
        loginPanel.setBorder(
            BorderFactory.createTitledBorder("")
        );
        
        obj.add(loginPanel);















        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","Vikram@300978");
        }
        catch(Exception e)
        {
        }

    }
}