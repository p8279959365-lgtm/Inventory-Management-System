import java.awt.*;
import javax.swing.*;
class ProductFrame extends JFrame 
{

    public ProductFrame()
    {
    setLayout(null);
    setBackground(new Color(241, 245, 249));
    JPanel body=new JPanel();
    body.setBounds(200,50,950,650);
    add(body);
    JLabel heading=new JLabel("PRODUCT MANAGEMENT");
    heading.setFont(new Font("Arial", Font.BOLD, 24));
    heading.setBounds(20, 20, 400, 40);
    
    }
    



    
}
