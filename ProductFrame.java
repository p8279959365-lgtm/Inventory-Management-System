// // import java.awt.*;
// // import javax.swing.*;
// // class ProductFrame extends JFrame 
// // {

// //     public ProductFrame()
// //     {
// //     setLayout(null);
// //     setBackground(new Color(241, 245, 249));
// //     JPanel body=new JPanel();
// //     body.setBounds(200,50,950,650);
// //     add(body);
// //     JLabel heading=new JLabel("PRODUCT MANAGEMENT");
// //     heading.setFont(new Font("Arial", Font.BOLD, 24));
// //     heading.setBounds(20, 20, 400, 40);

// //     }
    



    
// // }

// import java.awt.*;
// import java.sql.*;
// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;

// class ProductFrame extends JPanel {

//     JTable table;
//     DefaultTableModel model;

//     JTextField ProductName;
//     JTextField ProductId;
//     JTextField Supplier;
//     JTextField PurchasePrice;
//     JTextField SellingPrice;
//     JTextField Quantity;
//     JTextField TotalCost;

//     JPanel rightSidebar;

//     public ProductFrame() {

//         setLayout(null);
//         setBackground(new Color(241, 245, 249));
//         setBounds(880, 20, 1000, 1000);

//         // Heading
//         JLabel heading = new JLabel("PRODUCT MANAGEMENT");
//         heading.setFont(new Font("Arial", Font.BOLD, 24));
//         heading.setBounds(20, 15, 400, 40);
//         add(heading);

//         // Product table
//         model = new DefaultTableModel();
//         table = new JTable(model);
//         table.setRowHeight(28);
//         table.setFont(new Font("Arial", Font.PLAIN, 13));
//         table.getTableHeader().setFont(
//             new Font("Arial", Font.BOLD, 13)
//         );

//         JScrollPane scrollPane = new JScrollPane(table);
//         scrollPane.setBounds(20, 70, 650, 540);
//         add(scrollPane);

//         // Right sidebar
//         rightSidebar = new JPanel();
//         rightSidebar.setLayout(null);
//         rightSidebar.setBackground(Color.WHITE);
//         rightSidebar.setBounds(660, 70, 270, 540);
//         add(rightSidebar);

//         JLabel formHeading = new JLabel("Product Details");
//         formHeading.setFont(new Font("Arial", Font.BOLD, 18));
//         formHeading.setBounds(15, 10, 210, 30);
//         rightSidebar.add(formHeading);

//         ProductName = addField("Product Name", 50);
//         ProductId = addField("Product ID", 110);
//         Supplier = addField("Supplier", 170);
//         PurchasePrice = addField("Purchase Price", 230);
//         SellingPrice = addField("Selling Price", 290);




//         JButton addButton = new JButton("ADD PRODUCT");
//         addButton.setBounds(15, 430, 210, 30);
//         rightSidebar.add(addButton);



//         JButton updateButton = new JButton("UPDATE PRODUCT");
//         updateButton.setBounds(15, 465, 210, 30);
//         rightSidebar.add(updateButton);

//         JButton deleteButton=new JButton("DELETE PRODUCT");
//         deleteButton.setBounds(15,500,210,30);
//         rightSidebar.add(deleteButton);
//         // Load table when the screen opens
//         loadTable();

//         // Select a table row to fill the form
//         table.getSelectionModel().addListSelectionListener(e -> {
//             if (!e.getValueIsAdjusting()) {
//                 int row = table.getSelectedRow();

//                 if (row >= 0) {
//                     ProductName.setText(
//                         String.valueOf(model.getValueAt(row, 1))
//                     );
//                     ProductId.setText(
//                         String.valueOf(model.getValueAt(row, 0))
//                     );
//                     Supplier.setText(
//                         String.valueOf(model.getValueAt(row, 2))
//                     );
//                     PurchasePrice.setText(
//                         String.valueOf(model.getValueAt(row, 3))
//                     );
//                     SellingPrice.setText(
//                         String.valueOf(model.getValueAt(row, 4))
//                     );
//                 }
//             }
//         });


//         deleteButton.addActionListener(e ->{
//             try{
//             String sqldelete="delete from product where PRODUCT_ID= ?";
//             Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Inventory","root","Vikram@300978");

//             int id_to_be_deleted=Integer.parseInt(ProductId.getText());

//             PreparedStatement stmtt=conn.prepareStatement(sqldelete);
//             stmtt.setInt(1,id_to_be_deleted);
//             int r=stmtt.executeUpdate();
//             if(r>0)
//             {
//                 JOptionPane.showMessageDialog(this,"PRODUCT DELETED");
//             }
//             else{
//                 JOptionPane.showMessageDialog(this,"PRODUCT NOT DELETED");
//             }
//             ProductName.setText("");
//             ProductId.setText("");
//             Supplier.setText("");
//             PurchasePrice.setText("");
//             SellingPrice.setText("");
//             loadTable();
//             }
//             catch(Exception epp)
//             {

//                 JOptionPane.showMessageDialog(this,"error is there "+epp);
//             }

//         });

       
// addButton.addActionListener(e -> {
//     try {
//         String sql = "INSERT INTO product " +
//             "(PRODUCT_ID, PRODUCT_NAME, SUPPLIER, " +
//             "PURCHASE_PRICE, SELLING_PRICE) " +
//             "VALUES (?, ?, ?, ?, ?)";

//         try (Connection con = DriverManager.getConnection(
//                  "jdbc:mysql://localhost:3306/Inventory",
//                  "root",
//                  "Vikram@300978");
//              PreparedStatement ps = con.prepareStatement(sql)) {

//             ps.setInt(1, Integer.parseInt(ProductId.getText().trim()));
//             ps.setString(2, ProductName.getText().trim());
//             ps.setString(3, Supplier.getText().trim());
//             ps.setInt(4, Integer.parseInt(PurchasePrice.getText().trim()));
//             ps.setInt(5, Integer.parseInt(SellingPrice.getText().trim()));
//             ps.executeUpdate();

//             JOptionPane.showMessageDialog(this, "Product added successfully!");
//             loadTable();
//         }

//     } catch (NumberFormatException ex) {
//         JOptionPane.showMessageDialog(this,
//             "Product ID, prices and quantity must be valid integers.");
//     } catch (SQLException ex) {
//         JOptionPane.showMessageDialog(this,
//             "Could not add product: " + ex.getMessage());
//     }
// });


// updateButton.addActionListener(e -> {
//     int row = table.getSelectedRow();

//     if (row == -1) {
//         JOptionPane.showMessageDialog(
//             this, "Please select a product from the table first."
//         );
//         return;
//     }

//     try {
//         String sql = "UPDATE product SET PRODUCT_NAME=?, SUPPLIER=?, " +
//             "PURCHASE_PRICE=?, SELLING_PRICE=? " +
//             "WHERE PRODUCT_ID=?";

//         try (Connection con = DriverManager.getConnection(
//                  "jdbc:mysql://localhost:3306/Inventory",
//                  "root",
//                  "Vikram@300978");
//              PreparedStatement ps = con.prepareStatement(sql)) {

//             ps.setString(1, ProductName.getText().trim());
//             ps.setString(2, Supplier.getText().trim());
//             ps.setInt(3, Integer.parseInt(PurchasePrice.getText().trim()));
//             ps.setInt(4, Integer.parseInt(SellingPrice.getText().trim()));
//             // Use the original ID of the selected database row
//             ps.setInt(5, Integer.parseInt(
//                 model.getValueAt(row, 0).toString()
//             ));

//             int updated = ps.executeUpdate();

//             if (updated > 0) {
//                 JOptionPane.showMessageDialog(
//                     this, "Product updated successfully!"
//                 );
//                 loadTable();
//                 table.clearSelection();
//             } else {
//                 JOptionPane.showMessageDialog(
//                     this, "Product was not found."
//                 );
//             }
//         }

//     } catch (NumberFormatException ex) {
//         JOptionPane.showMessageDialog(
//             this, "Prices and quantity must be valid integers."
//         );
//     } catch (SQLException ex) {
//         JOptionPane.showMessageDialog(
//             this, "Could not update product: " + ex.getMessage()
//         );
//     }
// });


//     }

//     private JTextField addField(String labelText, int y) {
//         JLabel label = new JLabel(labelText);
//         label.setBounds(15, y, 210, 18);
//         rightSidebar.add(label);

//         JTextField field = new JTextField();
//         field.setBounds(15, y + 20, 210, 27);
//         rightSidebar.add(field);

//         return field;
//     }


    
// private void loadTable() {
//     String query =
//         "SELECT PRODUCT_ID, PRODUCT_NAME, SUPPLIER, " +
//         "PURCHASE_PRICE, SELLING_PRICE "+"FROM product";

//     try {
//         Class.forName("com.mysql.cj.jdbc.Driver");

//         try (Connection con =
//                  DriverManager.getConnection("jdbc:mysql://localhost:3306/Inventory","root","Vikram@300978");
//              Statement st = con.createStatement();
//              ResultSet rs = st.executeQuery(query)) {

//             model.setRowCount(0);
//             model.setColumnCount(0);

//             String[] columns = {
//                 "PRODUCT_ID", "PRODUCT_NAME", "SUPPLIER",
//                 "PURCHASE_PRICE", "SELLING_PRICE"
//             };

//             for (String column : columns) {
//                 model.addColumn(column);
//             }

//             while (rs.next()) {
//                 Object[] row = new Object[5];

//                 for (int i = 1; i <= 5; i++) {
//                     row[i - 1] = rs.getObject(i);
//                 }

//                 model.addRow(row);
//             }
//         }

//     } catch (Exception ex) {
//         JOptionPane.showMessageDialog(
//             this, "Could not load products: " + ex.getMessage()
//         );
//     }
// }

   
// }





import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

public class ProductFrame extends JPanel {

    private JTable table;
    private DefaultTableModel model;

    private JTextField productIdField;
    private JTextField productNameField;
    private JTextField supplierField;
    private JTextField purchasePriceField;
    private JTextField sellingPriceField;
    private JTextField searchField;

    private final Color background = new Color(241, 245, 249);
    private final Color navy = new Color(15, 23, 42);
    private final Color blue = new Color(37, 99, 235);
    private final Color muted = new Color(100, 116, 139);
    private final Color borderColor = new Color(226, 232, 240);

    public ProductFrame() {
        setLayout(new BorderLayout(18, 18));
        setBackground(background);
        setBorder(new EmptyBorder(24, 24, 24, 24));

        add(createHeader(), BorderLayout.NORTH);
        add(createContent(), BorderLayout.CENTER);

        loadTable();
    }

    private JPanel createHeader() {
        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(false);

        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Product Management");
        title.setFont(new Font("Segoe UI", Font.BOLD, 27));
        title.setForeground(navy);

        JLabel subtitle = new JLabel(
            "Manage products, pricing and supplier details"
        );
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitle.setForeground(muted);

        titlePanel.add(title);
        titlePanel.add(Box.createVerticalStrut(5));
        titlePanel.add(subtitle);

        JLabel tag = new JLabel(" INVENTORY  /  PRODUCTS ");
        tag.setFont(new Font("Segoe UI", Font.BOLD, 11));
        tag.setForeground(blue);
        tag.setOpaque(true);
        tag.setBackground(new Color(219, 234, 254));
        tag.setBorder(new EmptyBorder(10, 12, 10, 12));

        header.add(titlePanel, BorderLayout.WEST);
        header.add(tag, BorderLayout.EAST);

        return header;
    }

    private JPanel createContent() {
        JPanel content = new JPanel(new BorderLayout(18, 0));
        content.setOpaque(false);

        JPanel tableCard = createCard();
        tableCard.setLayout(new BorderLayout(0, 14));

        JPanel tableTop = new JPanel(new BorderLayout(10, 10));
        tableTop.setOpaque(false);

        JLabel tableTitle = new JLabel("Product Catalogue");
        tableTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        tableTitle.setForeground(navy);

        JPanel searchPanel = new JPanel(new BorderLayout(8, 0));
        searchPanel.setOpaque(false);

        searchField = new JTextField();
        searchField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        searchField.setToolTipText("Search products");
        searchField.setBorder(new CompoundBorder(
            new LineBorder(borderColor),
            new EmptyBorder(8, 10, 8, 10)
        ));

        JButton refreshButton = new JButton("Refresh");
        styleButton(refreshButton, new Color(241, 245, 249), navy);
        refreshButton.addActionListener(e -> loadTable());

        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(refreshButton, BorderLayout.EAST);

        tableTop.add(tableTitle, BorderLayout.NORTH);
        tableTop.add(searchPanel, BorderLayout.CENTER);

        model = new DefaultTableModel(
            new Object[]{
                "Product ID", "Product Name", "Supplier",
                "Purchase Price (₹)", "Selling Price (₹)"
            }, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(model);
        table.setRowHeight(34);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table.setForeground(new Color(51, 65, 85));
        table.setSelectionBackground(new Color(219, 234, 254));
        table.setSelectionForeground(navy);
        table.setShowVerticalLines(false);
        table.setGridColor(new Color(241, 245, 249));
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);

        table.getTableHeader().setFont(
            new Font("Segoe UI", Font.BOLD, 12)
        );
        table.getTableHeader().setBackground(
            new Color(248, 250, 252)
        );
        table.getTableHeader().setForeground(
            new Color(71, 85, 105)
        );
        table.getTableHeader().setPreferredSize(
            new Dimension(0, 38)
        );

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(new LineBorder(borderColor));

        JLabel tip = new JLabel(
            "Select a product row to edit or delete it."
        );
        tip.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        tip.setForeground(muted);

        tableCard.add(tableTop, BorderLayout.NORTH);
        tableCard.add(scrollPane, BorderLayout.CENTER);
        tableCard.add(tip, BorderLayout.SOUTH);

        JPanel formCard = createCard();
        formCard.setPreferredSize(new Dimension(285, 0));
        formCard.setLayout(new BorderLayout(0, 15));

        JPanel formHeading = new JPanel();
        formHeading.setOpaque(false);
        formHeading.setLayout(new BoxLayout(
            formHeading, BoxLayout.Y_AXIS
        ));

        JLabel formTitle = new JLabel("Product Details");
        formTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        formTitle.setForeground(navy);

        JLabel formSubtitle = new JLabel("Add or edit product");
        formSubtitle.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        formSubtitle.setForeground(muted);

        formHeading.add(formTitle);
        formHeading.add(Box.createVerticalStrut(5));
        formHeading.add(formSubtitle);

        JPanel fields = new JPanel(new GridLayout(0, 1, 0, 10));
        fields.setOpaque(false);

        productIdField = addField(fields, "Product ID");
        productNameField = addField(fields, "Product Name");
        supplierField = addField(fields, "Supplier");
        purchasePriceField = addField(fields, "Purchase Price (₹)");
        sellingPriceField = addField(fields, "Selling Price (₹)");

        JPanel buttons = new JPanel(new GridLayout(4, 1, 0, 9));
        buttons.setOpaque(false);

        JButton addButton = new JButton("＋  Add Product");
        JButton updateButton = new JButton("Update Product");
        JButton deleteButton = new JButton("Delete Product");
        JButton clearButton = new JButton("Clear Form");

        styleButton(addButton, blue, Color.WHITE);
        styleButton(
            updateButton,
            new Color(219, 234, 254),
            new Color(30, 64, 175)
        );
        styleButton(
            deleteButton,
            new Color(254, 226, 226),
            new Color(185, 28, 28)
        );
        styleButton(clearButton, Color.WHITE, muted);

        clearButton.setBorder(new LineBorder(borderColor));

        addButton.addActionListener(e -> addProduct());
        updateButton.addActionListener(e -> updateProduct());
        deleteButton.addActionListener(e -> deleteProduct());
        clearButton.addActionListener(e -> {
            table.clearSelection();
            clearForm();
        });

        buttons.add(addButton);
        buttons.add(updateButton);
        buttons.add(deleteButton);
        buttons.add(clearButton);

        formCard.add(formHeading, BorderLayout.NORTH);
        formCard.add(fields, BorderLayout.CENTER);
        formCard.add(buttons, BorderLayout.SOUTH);

        content.add(tableCard, BorderLayout.CENTER);
        content.add(formCard, BorderLayout.EAST);

        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int viewRow = table.getSelectedRow();

                if (viewRow >= 0) {
                    int row = table.convertRowIndexToModel(viewRow);

                    productIdField.setText(
                        model.getValueAt(row, 0).toString()
                    );
                    productNameField.setText(
                        model.getValueAt(row, 1).toString()
                    );
                    supplierField.setText(
                        model.getValueAt(row, 2).toString()
                    );
                    purchasePriceField.setText(
                        model.getValueAt(row, 3).toString()
                    );
                    sellingPriceField.setText(
                        model.getValueAt(row, 4).toString()
                    );

                    productIdField.setEditable(false);
                }
            }
        });

        searchField.getDocument().addDocumentListener(
            new javax.swing.event.DocumentListener() {
                private void filter() {
                    String query = searchField.getText()
                        .trim().toLowerCase();

                    javax.swing.table.TableRowSorter<DefaultTableModel>
                        sorter = new javax.swing.table.TableRowSorter<>(model);

                    table.setRowSorter(sorter);

                    if (query.isEmpty()) {
                        sorter.setRowFilter(null);
                    } else {
                        sorter.setRowFilter(
                            javax.swing.RowFilter.regexFilter(
                                "(?i)" + java.util.regex.Pattern.quote(query)
                            )
                        );
                    }
                }

                @Override
                public void insertUpdate(
                    javax.swing.event.DocumentEvent e
                ) {
                    filter();
                }

                @Override
                public void removeUpdate(
                    javax.swing.event.DocumentEvent e
                ) {
                    filter();
                }

                @Override
                public void changedUpdate(
                    javax.swing.event.DocumentEvent e
                ) {
                    filter();
                }
            }
        );

        return content;
    }

    private JPanel createCard() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(new CompoundBorder(
            new LineBorder(borderColor),
            new EmptyBorder(18, 18, 18, 18)
        ));
        return panel;
    }

    private JTextField addField(JPanel parent, String labelText) {
        JPanel wrapper = new JPanel(new BorderLayout(0, 5));
        wrapper.setOpaque(false);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label.setForeground(new Color(71, 85, 105));

        JTextField field = new JTextField();
        field.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        field.setPreferredSize(new Dimension(100, 36));
        field.setBorder(new CompoundBorder(
            new LineBorder(borderColor),
            new EmptyBorder(7, 9, 7, 9)
        ));

        wrapper.add(label, BorderLayout.NORTH);
        wrapper.add(field, BorderLayout.CENTER);
        parent.add(wrapper);

        return field;
    }

    private void styleButton(
        JButton button, Color bg, Color fg
    ) {
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setBackground(bg);
        button.setForeground(fg);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setCursor(
            Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
        );
        button.setBorder(new EmptyBorder(10, 12, 10, 12));
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/Inventory",
            "root",
            "Vikram@300978"
        );
    }

    private void addProduct() {
        if (!validateForm(true)) {
            return;
        }

        String sql = "INSERT INTO product " +
            "(PRODUCT_ID, PRODUCT_NAME, SUPPLIER, " +
            "PURCHASE_PRICE, SELLING_PRICE) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, Integer.parseInt(
                productIdField.getText().trim()
            ));
            ps.setString(2, productNameField.getText().trim());
            ps.setString(3, supplierField.getText().trim());
            ps.setBigDecimal(4, new java.math.BigDecimal(
                purchasePriceField.getText().trim()
            ));
            ps.setBigDecimal(5, new java.math.BigDecimal(
                sellingPriceField.getText().trim()
            ));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                this, "Product added successfully!"
            );

            clearForm();
            loadTable();

        } catch (SQLException ex) {
            showDatabaseError("add product", ex);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this, "Enter a valid product ID and prices."
            );
        }
    }

    private void updateProduct() {
        int viewRow = table.getSelectedRow();

        if (viewRow < 0) {
            JOptionPane.showMessageDialog(
                this, "Please select a product first."
            );
            return;
        }

        if (!validateForm(false)) {
            return;
        }

        int row = table.convertRowIndexToModel(viewRow);
        int originalId = Integer.parseInt(
            model.getValueAt(row, 0).toString()
        );

        String sql = "UPDATE product SET PRODUCT_NAME=?, SUPPLIER=?, " +
            "PURCHASE_PRICE=?, SELLING_PRICE=? WHERE PRODUCT_ID=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, productNameField.getText().trim());
            ps.setString(2, supplierField.getText().trim());
            ps.setBigDecimal(3, new java.math.BigDecimal(
                purchasePriceField.getText().trim()
            ));
            ps.setBigDecimal(4, new java.math.BigDecimal(
                sellingPriceField.getText().trim()
            ));
            ps.setInt(5, originalId);

            int updated = ps.executeUpdate();

            if (updated > 0) {
                JOptionPane.showMessageDialog(
                    this, "Product updated successfully!"
                );
                loadTable();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(
                    this, "Product was not found."
                );
            }

        } catch (SQLException ex) {
            showDatabaseError("update product", ex);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this, "Enter valid prices."
            );
        }
    }

    private void deleteProduct() {
        int viewRow = table.getSelectedRow();

        if (viewRow < 0) {
            JOptionPane.showMessageDialog(
                this, "Please select a product to delete."
            );
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to delete this product?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        int row = table.convertRowIndexToModel(viewRow);
        int id = Integer.parseInt(
            model.getValueAt(row, 0).toString()
        );

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(
                 "DELETE FROM product WHERE PRODUCT_ID=?"
             )) {

            ps.setInt(1, id);
            int deleted = ps.executeUpdate();

            if (deleted > 0) {
                JOptionPane.showMessageDialog(
                    this, "Product deleted successfully!"
                );
                clearForm();
                loadTable();
            } else {
                JOptionPane.showMessageDialog(
                    this, "Product was not found."
                );
            }

        } catch (SQLException ex) {
            showDatabaseError("delete product", ex);
        }
    }

    private boolean validateForm(boolean requireId) {
        if (productNameField.getText().trim().isEmpty()
            || supplierField.getText().trim().isEmpty()
            || purchasePriceField.getText().trim().isEmpty()
            || sellingPriceField.getText().trim().isEmpty()
            || (requireId && productIdField.getText().trim().isEmpty())) {

            JOptionPane.showMessageDialog(
                this, "Please fill in all required fields."
            );
            return false;
        }

        try {
            if (requireId) {
                int id = Integer.parseInt(
                    productIdField.getText().trim()
                );
                if (id <= 0) {
                    throw new NumberFormatException();
                }
            }

            java.math.BigDecimal purchase =
                new java.math.BigDecimal(
                    purchasePriceField.getText().trim()
                );

            java.math.BigDecimal selling =
                new java.math.BigDecimal(
                    sellingPriceField.getText().trim()
                );

            if (purchase.signum() < 0 || selling.signum() < 0) {
                JOptionPane.showMessageDialog(
                    this, "Prices cannot be negative."
                );
                return false;
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Product ID must be an integer and prices must be valid numbers."
            );
            return false;
        }

        return true;
    }

    private void clearForm() {
        productIdField.setText("");
        productNameField.setText("");
        supplierField.setText("");
        purchasePriceField.setText("");
        sellingPriceField.setText("");
        productIdField.setEditable(true);
    }

    private void loadTable() {
        String sql = "SELECT PRODUCT_ID, PRODUCT_NAME, SUPPLIER, " +
            "PURCHASE_PRICE, SELLING_PRICE FROM product";

        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new Object[] {
                    rs.getObject("PRODUCT_ID"),
                    rs.getObject("PRODUCT_NAME"),
                    rs.getObject("SUPPLIER"),
                    rs.getObject("PURCHASE_PRICE"),
                    rs.getObject("SELLING_PRICE")
                });
            }

        } catch (SQLException ex) {
            showDatabaseError("load products", ex);
        }
    }

    private void showDatabaseError(
        String action, SQLException ex
    ) {
        JOptionPane.showMessageDialog(
            this,
            "Could not " + action + ".\n" + ex.getMessage(),
            "Database Error",
            JOptionPane.ERROR_MESSAGE
        );
    }
}
