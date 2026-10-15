
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createLoginPage());
    }

    static void createLoginPage() {

        JFrame obj = new JFrame("Inventory Management System");
        obj.setSize(900, 600);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);

        // Main background
        JPanel background = new JPanel(null);
        background.setBackground(new Color(15, 23, 42));
        obj.setContentPane(background);

        // Left branding panel
        JPanel brandPanel = new JPanel(null);
        brandPanel.setBackground(new Color(30, 41, 59));
        brandPanel.setBounds(0, 0, 400, 600);
        background.add(brandPanel);

        JLabel brand = new JLabel(
            "<html>INVENTORY<br>MANAGEMENT<br>SYSTEM</html>"
        );
        brand.setFont(new Font("Arial", Font.BOLD, 30));
        brand.setForeground(Color.WHITE);
        brand.setBounds(45, 175, 320, 130);
        brandPanel.add(brand);

        JLabel tagline = new JLabel(
            "<html>Manage your products.<br>Track your inventory.</html>"
        );
        tagline.setFont(new Font("Arial", Font.PLAIN, 16));
        tagline.setForeground(new Color(203, 213, 225));
        tagline.setBounds(48, 320, 300, 60);
        brandPanel.add(tagline);

        // Login card
        JPanel card = new JPanel(null);
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(
                new Color(226, 232, 240)
            ),
            new EmptyBorder(10, 10, 10, 10)
        ));
        card.setBounds(465, 95, 375, 400);
        background.add(card);

        JLabel welcome = new JLabel("Welcome Back!");
        welcome.setFont(new Font("Arial", Font.BOLD, 27));
        welcome.setForeground(new Color(15, 23, 42));
        welcome.setBounds(30, 30, 310, 40);
        card.add(welcome);

        JLabel subtitle = new JLabel("Login to your account");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 15));
        subtitle.setForeground(new Color(100, 116, 139));
        subtitle.setBounds(32, 72, 300, 25);
        card.add(subtitle);

        JLabel name = new JLabel("User ID");
        name.setFont(new Font("Arial", Font.BOLD, 14));
        name.setBounds(32, 125, 300, 22);
        card.add(name);

        JTextField enterid = new JTextField();
        enterid.setFont(new Font("Arial", Font.PLAIN, 16));
        enterid.setBounds(32, 151, 300, 38);
        enterid.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(
                new Color(203, 213, 225)
            ),
            new EmptyBorder(5, 10, 5, 10)
        ));
        card.add(enterid);

        JLabel password = new JLabel("Password");
        password.setFont(new Font("Arial", Font.BOLD, 14));
        password.setBounds(32, 205, 300, 22);
        card.add(password);

        JPasswordField enterpassword = new JPasswordField();
        enterpassword.setFont(new Font("Arial", Font.PLAIN, 16));
        enterpassword.setBounds(32, 231, 300, 38);
        enterpassword.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(
                new Color(203, 213, 225)
            ),
            new EmptyBorder(5, 10, 5, 10)
        ));
        card.add(enterpassword);

        // Login button
        JButton login = new JButton("LOGIN");
        login.setBounds(32, 300, 300, 43);
        login.setFont(new Font("Arial", Font.BOLD, 15));
        login.setForeground(Color.WHITE);
        login.setBackground(new Color(37, 99, 235));
        login.setFocusPainted(false);
        login.setBorderPainted(false);
        login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        card.add(login);

        // Button hover effect
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) {
                login.setBackground(new Color(29, 78, 216));
            }

            public void mouseExited(java.awt.event.MouseEvent e) {
                login.setBackground(new Color(37, 99, 235));
            }
        });

        // Authentication logic
        login.addActionListener(e -> {

            String userText = enterid.getText().trim();
            String pass = new String(enterpassword.getPassword());

            if (userText.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(
                    obj, "Please enter both User ID and Password."
                );
                return;
            }

            try {
                int nm = Integer.parseInt(userText);

                Class.forName("com.mysql.cj.jdbc.Driver");

                try (Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/Inventory",
                        "root",
                        "Vikram@300978"
                    );
                    PreparedStatement stmt = con.prepareStatement(
                        "SELECT password FROM authentication WHERE user_id = ?"
                    )) {

                    stmt.setInt(1, nm);

                    try (ResultSet res = stmt.executeQuery()) {
                        if (res.next()) {
                            String storedPassword =
                                res.getString("password");

                            if (pass.equals(storedPassword)) {
                                JOptionPane.showMessageDialog(
                                    obj, "Login Successful!"
                                );

                                InventoryFrame inventory =
                                    new InventoryFrame();

                                inventory.setLocationRelativeTo(null);
                                inventory.setVisible(true);
                                obj.dispose();

                            } else {
                                JOptionPane.showMessageDialog(
                                    obj, "Incorrect Password"
                                );
                            }
                        } else {
                            JOptionPane.showMessageDialog(
                                obj, "User ID not found"
                            );
                        }
                    }
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                    obj, "User ID must be a number."
                );
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(
                    obj, "Error: " + ex.getMessage()
                );
            }
        });

        // Press Enter to login
        obj.getRootPane().setDefaultButton(login);

        obj.setVisible(true);
    }
}
