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
        setBounds(880, 20, 1000, 1000);

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
        rightSidebar.setBounds(660, 70, 270, 540);
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




        JButton addButton = new JButton("ADD PRODUCT");
        addButton.setBounds(15, 465, 210, 30);
        rightSidebar.add(addButton);



        JButton updateButton = new JButton("UPDATE PRODUCT");
        updateButton.setBounds(15, 500, 210, 30);
        rightSidebar.add(updateButton);

        JButton deleteButton=new JButton("DELETE PRODUCT");
        deleteButton.setBounds(15,535,210,30);
        rightSidebar.add(deleteButton);
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
                }
            }
        });


        deleteButton.addActionListener(e ->{
            try{
            String sqldelete="delete from product where PRODUCT_ID= ?";
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Inventory","root","Vikram@300978");

            int id_to_be_deleted=Integer.parseInt(ProductId.getText());

            PreparedStatement stmtt=conn.prepareStatement(sqldelete);
            stmtt.setInt(1,id_to_be_deleted);
            int r=stmtt.executeUpdate();
            if(r>0)
            {
                JOptionPane.showMessageDialog(this,"PRODUCT DELETED");
            }
            else{
                JOptionPane.showMessageDialog(this,"PRODUCT NOT DELETED");
            }
            }
            catch(Exception epp)
            {

            }

        })

       
addButton.addActionListener(e -> {
    try {
        String sql = "INSERT INTO product " +
            "(PRODUCT_ID, PRODUCT_NAME, SUPPLIER, " +
            "PURCHASE_PRICE, SELLING_PRICE) " +
            "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(
                 "jdbc:mysql://localhost:3306/Inventory",
                 "root",
                 "Vikram@300978");
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, Integer.parseInt(ProductId.getText().trim()));
            ps.setString(2, ProductName.getText().trim());
            ps.setString(3, Supplier.getText().trim());
            ps.setInt(4, Integer.parseInt(PurchasePrice.getText().trim()));
            ps.setInt(5, Integer.parseInt(SellingPrice.getText().trim()));
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Product added successfully!");
            loadTable();
        }

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this,
            "Product ID, prices and quantity must be valid integers.");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this,
            "Could not add product: " + ex.getMessage());
    }
});


updateButton.addActionListener(e -> {
    int row = table.getSelectedRow();

    if (row == -1) {
        JOptionPane.showMessageDialog(
            this, "Please select a product from the table first."
        );
        return;
    }

    try {
        String sql = "UPDATE product SET PRODUCT_NAME=?, SUPPLIER=?, " +
            "PURCHASE_PRICE=?, SELLING_PRICE=? " +
            "WHERE PRODUCT_ID=?";

        try (Connection con = DriverManager.getConnection(
                 "jdbc:mysql://localhost:3306/Inventory",
                 "root",
                 "Vikram@300978");
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, ProductName.getText().trim());
            ps.setString(2, Supplier.getText().trim());
            ps.setInt(3, Integer.parseInt(PurchasePrice.getText().trim()));
            ps.setInt(4, Integer.parseInt(SellingPrice.getText().trim()));
            // Use the original ID of the selected database row
            ps.setInt(5, Integer.parseInt(
                model.getValueAt(row, 0).toString()
            ));

            int updated = ps.executeUpdate();

            if (updated > 0) {
                JOptionPane.showMessageDialog(
                    this, "Product updated successfully!"
                );
                loadTable();
                table.clearSelection();
            } else {
                JOptionPane.showMessageDialog(
                    this, "Product was not found."
                );
            }
        }

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(
            this, "Prices and quantity must be valid integers."
        );
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(
            this, "Could not update product: " + ex.getMessage()
        );
    }
});


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
        "PURCHASE_PRICE, SELLING_PRICE "+"FROM product";

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
                "PURCHASE_PRICE", "SELLING_PRICE"
            };

            for (String column : columns) {
                model.addColumn(column);
            }

            while (rs.next()) {
                Object[] row = new Object[5];

                for (int i = 1; i <= 5; i++) {
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
