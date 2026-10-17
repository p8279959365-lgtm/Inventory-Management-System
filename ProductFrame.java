// import java.awt.*;
// import javax.swing.*;
// class ProductFrame extends JFrame 
// {

//     public ProductFrame()
//     {
//     setLayout(null);
//     setBackground(new Color(241, 245, 249));
//     JPanel body=new JPanel();
//     body.setBounds(200,50,950,650);
//     add(body);
//     JLabel heading=new JLabel("PRODUCT MANAGEMENT");
//     heading.setFont(new Font("Arial", Font.BOLD, 24));
//     heading.setBounds(20, 20, 400, 40);

//     }
    



    
// }

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class ProductFrame extends JPanel {

    JTable table;
    DefaultTableModel model;

    JTextField ProductName;
    JTextField ProductId;
    JTextField Supplier;
    JTextField PurchasePrice;
    JTextField SellingPrice;
    JTextField Quantity;
    JTextField TotalCost;

    JPanel rightSidebar;

    public ProductFrame() {

        setLayout(null);
        setBackground(new Color(241, 245, 249));

        // Heading
        JLabel heading = new JLabel("PRODUCT MANAGEMENT");
        heading.setFont(new Font("Arial", Font.BOLD, 24));
        heading.setBounds(20, 15, 400, 40);
        add(heading);

        // Product table
        model = new DefaultTableModel();
        table = new JTable(model);
        table.setRowHeight(28);
        table.setFont(new Font("Arial", Font.PLAIN, 13));
        table.getTableHeader().setFont(
            new Font("Arial", Font.BOLD, 13)
        );

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 70, 650, 540);
        add(scrollPane);

        // Right sidebar
        rightSidebar = new JPanel();
        rightSidebar.setLayout(null);
        rightSidebar.setBackground(Color.WHITE);
        rightSidebar.setBounds(690, 70, 240, 540);
        add(rightSidebar);

        JLabel formHeading = new JLabel("Product Details");
        formHeading.setFont(new Font("Arial", Font.BOLD, 18));
        formHeading.setBounds(15, 10, 210, 30);
        rightSidebar.add(formHeading);

        ProductName = addField("Product Name", 50);
        ProductId = addField("Product ID", 110);
        Supplier = addField("Supplier", 170);
        PurchasePrice = addField("Purchase Price", 230);
        SellingPrice = addField("Selling Price", 290);
        Quantity = addField("Quantity", 350);
        TotalCost = addField("Total Cost", 410);

        TotalCost.setEditable(false);

        JButton addButton = new JButton("ADD PRODUCT");
        addButton.setBounds(15, 465, 210, 30);
        rightSidebar.add(addButton);

        JButton updateButton = new JButton("UPDATE PRODUCT");
        updateButton.setBounds(15, 500, 210, 30);
        rightSidebar.add(updateButton);

        // Load table when the screen opens
        loadTable();

        // Select a table row to fill the form
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = table.getSelectedRow();

                if (row >= 0) {
                    ProductName.setText(
                        String.valueOf(model.getValueAt(row, 0))
                    );
                    ProductId.setText(
                        String.valueOf(model.getValueAt(row, 1))
                    );
                    Supplier.setText(
                        String.valueOf(model.getValueAt(row, 2))
                    );
                    PurchasePrice.setText(
                        String.valueOf(model.getValueAt(row, 3))
                    );
                    SellingPrice.setText(
                        String.valueOf(model.getValueAt(row, 4))
                    );
                    Quantity.setText(
                        String.valueOf(model.getValueAt(row, 5))
                    );
                    TotalCost.setText(
                        String.valueOf(model.getValueAt(row, 6))
                    );
                }
            }
        });

        // Add and update actions will be connected to SQL next.
        addButton.addActionListener(e ->
            JOptionPane.showMessageDialog(
                this, "Next, connect this button to your product INSERT query."
            )
        );

        updateButton.addActionListener(e ->
            JOptionPane.showMessageDialog(
                this, "Select a product row before connecting the UPDATE query."
            )
        );
    }

    private JTextField addField(String labelText, int y) {
        JLabel label = new JLabel(labelText);
        label.setBounds(15, y, 210, 18);
        rightSidebar.add(label);

        JTextField field = new JTextField();
        field.setBounds(15, y + 20, 210, 27);
        rightSidebar.add(field);

        return field;
    }


    
private void loadTable() {
    String query =
        "SELECT PRODUCT_ID, PRODUCT_NAME, SUPPLIER, " +
        "PURCHASE_PRICE, SELLING_PRICE, QUANTITY, " +
        "(PURCHASE_PRICE * QUANTITY) AS TOTAL_COST " +
        "FROM product";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con =
                 DriverManager.getConnection("jdbc:mysql://localhost:3306/Inventory","root","Vikram@300978");
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            model.setRowCount(0);
            model.setColumnCount(0);

            String[] columns = {
                "PRODUCT_ID", "PRODUCT_NAME", "SUPPLIER",
                "PURCHASE_PRICE", "SELLING_PRICE",
                "QUANTITY", "TOTAL_COST"
            };

            for (String column : columns) {
                model.addColumn(column);
            }

            while (rs.next()) {
                Object[] row = new Object[7];

                for (int i = 1; i <= 7; i++) {
                    row[i - 1] = rs.getObject(i);
                }

                model.addRow(row);
            }
        }

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(
            this, "Could not load products: " + ex.getMessage()
        );
    }
}

   
}
