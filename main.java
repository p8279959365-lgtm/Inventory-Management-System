import java.awt.event.*;
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

        JPasswordField enterpassword=new JPasswordField("");
        enterpassword.setBounds(700,385,200,20);
        obj.add(enterpassword);


        JButton login = new JButton("LOGIN");
        login.setBounds(650, 440, 120, 35);
        obj.add(login);



        // BORDER TO THE LOGIN PAGE// 

        // JPanel loginPanel = new JPanel();
        // loginPanel.setLayout(null);
        // loginPanel.setBounds(450, 230, 550, 280);
        // loginPanel.setBorder(
        //     BorderFactory.createTitledBorder("")
        // );
        // obj.add(loginPanel);


        

        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Inventory","root","Vikram@300978");

        // id is of int type and password is of string ype
        // pasword will be stored in the varchar type
        // database inventory table  is authentication





        // add action listner to the login button
        login.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
               
                try{
                 int nm=Integer.parseInt(enterid.getText());
                String pass=new String(enterpassword.getPassword());
                String q1="SELECT password from authentication WHERE user_id= ?  ";
                PreparedStatement stmt=con.prepareStatement(q1);
                stmt.setInt(1,nm);
                ResultSet res=stmt.executeQuery();

                if(res.next())
                {
                    String pas=res.getString("password");
                    if(pass.equals(pas))
                    {
                        JOptionPane.showMessageDialog(obj,"Login Succesful !!");
                        InventoryFrame inventory = new InventoryFrame();
                        inventory.setLocationRelativeTo(null);
                        inventory.setVisible(true);
                        obj.dispose();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(obj,"Incorrect Password");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(obj,"user id not found");
                }
                }
                catch(Exception ep)
                {
                   ep.printStackTrace();
                   JOptionPane.showMessageDialog(
                    obj,"Error: " + ep.getMessage());
                }

            }
        });
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        catch(Exception e)
        {
             e.printStackTrace();
        }

    }
}