// import java.awt.*;
// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// class BillingFrame extends JPanel {


// BillingFrame() 
// {
// setLayout(null);
// setBackground(new Color(241,245,249));
// // Customer Details Card
// JPanel card1 = new JPanel();
// card1.setLayout(null);

// // CARD1 BOUND 
// card1.setBounds(20, 50, 800, 140);
// card1.setBackground(Color.WHITE);

// card1.setBorder(
//     BorderFactory.createLineBorder(
//         new Color(220, 226, 235)
//     )
// );

// // Heading
// JLabel heading = new JLabel("Customer Details");
// heading.setFont(new Font("Arial", Font.BOLD, 18));
// heading.setBounds(15, 10, 250, 30);
// card1.add(heading);

// // Customer ID
// JLabel idLabel = new JLabel("Customer Id");
// idLabel.setBounds(15, 50, 150, 25);
// card1.add(idLabel);

// JTextField idField = new JTextField();
// idField.setBounds(15, 80, 70, 30);
// card1.add(idField);

// // customer name
// JLabel nameLabel = new JLabel("Customer Name");
// nameLabel.setBounds(120, 50, 150, 25);
// card1.add(nameLabel);

// JTextField namefield = new JTextField();
// namefield.setBounds(120, 80, 150, 30);
// card1.add(namefield);

// // CUSTOMER PHONE NUMBER PRIMARY KEY
// JLabel phoneLabel = new JLabel("Phone Number");
// phoneLabel.setBounds(290, 50, 150, 25);
// card1.add(phoneLabel);

// JTextField phoneField = new JTextField();
// phoneField.setBounds(290, 80, 150, 30);
// card1.add(phoneField);


// // CUSTOMER EMAIL
// JLabel emailLabel = new JLabel("Email ");
// emailLabel.setBounds(450, 50, 150, 25);
// card1.add(emailLabel);

// JTextField emailField = new JTextField();
// emailField.setBounds(450, 80, 150, 30);
// card1.add(emailField);

// // ADDING THE ADDNEW CUSTOMER BUTTON
// JButton addcustomer=new JButton("Add Customer");
// addcustomer.setBounds(620,80,130,30);
// card1.add(addcustomer);



// add(card1);







// // NOW WE ARE ADDING THE PRODUCT ADDING CARD

// JPanel card2=new JPanel();
// card2.setBounds(20,200,800,140);
// card2.setLayout(null);
// card2.setBackground(Color.white);



// JLabel heading2 = new JLabel("Product Details");
// heading2.setFont(new Font("Arial", Font.BOLD, 18));
// heading2.setBounds(15, 10, 250, 30);
// card2.add(heading2);

// // added the product id
// JLabel productid=new JLabel("Product Id");
// productid.setBounds(15,40,100,30);
// card2.add(productid);

// JTextField productfield=new JTextField();
// productfield.setBounds(15,70,70,30);
// card2.add(productfield);



// // adding the product name
// JLabel productname=new JLabel("Product Name");
// productname.setBounds(115,40,100,30);
// card2.add(productname);

// JTextField productnamefield=new JTextField();
// productnamefield.setBounds(115,70,130,30);
// card2.add(productnamefield);

// // adding the Available stock
// JLabel availablestockLabel=new JLabel("Available Stock");
// availablestockLabel.setBounds(265,40,100,30);
// card2.add(availablestockLabel);

// JTextField availablestockfield=new JTextField();
// availablestockfield.setBounds(265,70,100,30);
// card2.add(availablestockfield);


// // selling price lable
// JLabel sellingpriceLabel=new JLabel("Selling Price");
// sellingpriceLabel.setBounds(380,40,100,30);
// card2.add(sellingpriceLabel);

// JTextField sellingpricefield=new JTextField();
// sellingpricefield.setBounds(380,70,100,30);
// card2.add(sellingpricefield);

// // total cost label
// JLabel quantity=new JLabel("Quantity");
// quantity.setBounds(490,40,100,30);
// card2.add(quantity);


// JTextField quantityfield=new JTextField();
// quantityfield.setBounds(490,70,50,30);
// card2.add(quantityfield);



// // total cost label
// JLabel totalcost=new JLabel("Total Cost");
// totalcost.setBounds(555,40,100,30);
// card2.add(totalcost);


// JTextField totalcostfield=new JTextField();
// totalcostfield.setBounds(555,70,100,30);
// card2.add(totalcostfield);


// // adding button to add the product
// JButton addproduct=new JButton("Add Product");
// addproduct.setBounds(665,70,130,30);
// card2.add(addproduct);



// add(card2);




// // new card for add products 


// JPanel card3=new JPanel();
// card3.setLayout(null);
// card3.setBounds(20,360,800,450);
// card3.setBackground(Color.white);

// JLabel heading3 = new JLabel("Bill Items");
// heading3.setFont(new Font("Arial", Font.BOLD, 18));
// heading3.setBounds(15, 20, 250, 30);
// card3.add(heading3);


// // now will be loading the table we have to create it

// String[] columns = {
//     "Product ID",
//     "Product Name",
//     "Price",
//     "Quantity",
//     "Total"
// };

// DefaultTableModel model = new DefaultTableModel(columns, 0);

// JTable billTable = new JTable(model);
// billTable.setRowHeight(25);

// JScrollPane scrollPane = new JScrollPane(billTable);
// scrollPane.setBounds(15, 65, 770, 300);

// card3.add(scrollPane);

// add(card3);
// }
// }














// whats app pe pdf abhi bacha hai baad mei krte hai use 
// import org.apache.pdfbox.pdmodel.PDDocument;
// import org.apache.pdfbox.pdmodel.PDPage;
// import org.apache.pdfbox.pdmodel.PDPageContentStream;
// import org.apache.pdfbox.pdmodel.font.PDType1Font;
// import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class BillingFrame extends JPanel {

    private JTextField idField;
    private JTextField nameField;
    private JTextField phoneField;
    private JTextField emailField;

    private JTextField productIdField;
    private JTextField productNameField;
    private JTextField availableStockField;
    private JTextField sellingPriceField;
    private JTextField quantityField;
    private JTextField totalCostField;

    private JTable billTable;
    private DefaultTableModel model;
    private JTable recentBillsTable;
    private DefaultTableModel recentBillsModel;

    public BillingFrame() {

        setLayout(null);
        setBackground(new Color(241, 245, 249));

        // Customer Details Card
        JPanel card1 = new JPanel(null);
        card1.setBounds(20, 50, 800, 140);
        card1.setBackground(Color.WHITE);
        card1.setBorder(BorderFactory.createLineBorder(
            new Color(220, 226, 235)
        ));

        JLabel heading = new JLabel("Customer Details");
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        heading.setBounds(15, 10, 250, 30);
        card1.add(heading);

        JLabel idLabel = new JLabel("Customer ID");
        idLabel.setBounds(15, 50, 100, 25);
        card1.add(idLabel);

        idField = new JTextField();
        idField.setBounds(15, 80, 70, 30);
        card1.add(idField);

        JLabel nameLabel = new JLabel("Customer Name");
        nameLabel.setBounds(100, 50, 150, 25);
        card1.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(100, 80, 150, 30);
        card1.add(nameField);

        JLabel phoneLabel = new JLabel("Phone Number");
        phoneLabel.setBounds(265, 50, 150, 25);
        card1.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(265, 80, 150, 30);
        card1.add(phoneField);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(430, 50, 150, 25);
        card1.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(430, 80, 150, 30);
        card1.add(emailField);

        JButton addCustomerButton = new JButton("Add Customer");
        addCustomerButton.setBounds(620, 80, 130, 30);
        card1.add(addCustomerButton);

        add(card1);

        // Product Details Card
        JPanel card2 = new JPanel(null);
        card2.setBounds(20, 200, 800, 140);
        card2.setBackground(Color.WHITE);
        card2.setBorder(BorderFactory.createLineBorder(
            new Color(220, 226, 235)
        ));

        JLabel heading2 = new JLabel("Product Details");
        heading2.setFont(new Font("Arial", Font.BOLD, 18));
        heading2.setBounds(15, 10, 250, 30);
        card2.add(heading2);

        JLabel productIdLabel = new JLabel("Product ID");
        productIdLabel.setBounds(15, 40, 100, 25);
        card2.add(productIdLabel);

        productIdField = new JTextField();
        productIdField.setBounds(15, 70, 70, 30);
        card2.add(productIdField);

        JLabel productNameLabel = new JLabel("Product Name");
        productNameLabel.setBounds(100, 40, 120, 25);
        card2.add(productNameLabel);

        productNameField = new JTextField();
        productNameField.setBounds(100, 70, 130, 30);
        card2.add(productNameField);

        JLabel stockLabel = new JLabel("Available Stock");
        stockLabel.setBounds(240, 40, 110, 25);
        card2.add(stockLabel);

        availableStockField = new JTextField();
        availableStockField.setBounds(240, 70, 100, 30);
        card2.add(availableStockField);

        JLabel priceLabel = new JLabel("Selling Price");
        priceLabel.setBounds(350, 40, 100, 25);
        card2.add(priceLabel);

        sellingPriceField = new JTextField();
        sellingPriceField.setBounds(350, 70, 100, 30);
        card2.add(sellingPriceField);

        JLabel quantityLabel = new JLabel("Quantity");
        quantityLabel.setBounds(480, 40, 80, 25);
        card2.add(quantityLabel);

        quantityField = new JTextField();
        quantityField.setBounds(480, 70, 45, 30);
        card2.add(quantityField);

        JButton minusButton = new JButton("");
JButton plusButton = new JButton("");

minusButton.setBounds(470, 70, 10, 30);
plusButton.setBounds(524, 70, 10, 30);
card2.add(minusButton);
card2.add(plusButton);

minusButton.addActionListener(e -> {
    try {
        int quantity = Integer.parseInt(
            quantityField.getText().trim()
        );

        if (quantity > 1) {
            quantityField.setText(String.valueOf(quantity - 1));
        }
    } catch (NumberFormatException ex) {
        quantityField.setText("1");
    }
});

plusButton.addActionListener(e -> {
    try {
        int quantity = Integer.parseInt(
            quantityField.getText().trim()
        );

        quantityField.setText(String.valueOf(quantity + 1));

    } catch (NumberFormatException ex) {
        quantityField.setText("1");
    }
});

        JLabel totalLabel = new JLabel("Total Cost");
        totalLabel.setBounds(560, 40, 90, 25);
        card2.add(totalLabel);

        totalCostField = new JTextField();
        totalCostField.setBounds(560, 70, 60, 30);
        totalCostField.setEditable(true);
        card2.add(totalCostField);

        JButton addProductButton = new JButton("Add Product");
        addProductButton.setBounds(645, 70, 140, 30);
        card2.add(addProductButton);

        add(card2);

        // Bill Items Card
        JPanel card3 = new JPanel(null);
        card3.setBounds(20, 350, 800, 310);
        card3.setBackground(Color.WHITE);
        card3.setBorder(BorderFactory.createLineBorder(
            new Color(220, 226, 235)
        ));

        JLabel heading3 = new JLabel("Bill Items");
        heading3.setFont(new Font("Arial", Font.BOLD, 18));
        heading3.setBounds(15, 10, 250, 30);
        card3.add(heading3);

        String[] columns = {
            "Product ID",
            "Product Name",
            "Selling Price",
            "Quantity",
            "Total"
        };

        model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        billTable = new JTable(model);
        billTable.setRowHeight(25);
        billTable.setFont(new Font("Arial", Font.PLAIN, 13));
        billTable.getTableHeader().setFont(
            new Font("Arial", Font.BOLD, 13)
        );

        JScrollPane scrollPane = new JScrollPane(billTable);
        scrollPane.setBounds(15, 50, 770, 190);
        card3.add(scrollPane);

        JButton removeButton = new JButton("Remove Selected");
        removeButton.setBounds(15, 255, 160, 30);
        card3.add(removeButton);

        JLabel grandTotalText = new JLabel("Grand Total:");
        grandTotalText.setFont(new Font("Arial", Font.BOLD, 16));
        grandTotalText.setBounds(450, 255, 120, 30);
        card3.add(grandTotalText);

        JLabel grandTotalLabel = new JLabel("Rs. 0.00");
        grandTotalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        grandTotalLabel.setForeground(new Color(0, 103, 184));
        grandTotalLabel.setBounds(575, 255, 200, 30);
        card3.add(grandTotalLabel);

        add(card3);

        javax.swing.event.DocumentListener listener =
    new javax.swing.event.DocumentListener() {

        @Override
        public void insertUpdate(javax.swing.event.DocumentEvent e) {
            calculateItemTotal();
        }

        @Override
        public void removeUpdate(javax.swing.event.DocumentEvent e) {
            calculateItemTotal();
        }

        @Override
        public void changedUpdate(javax.swing.event.DocumentEvent e) {
            calculateItemTotal();
        }
    };

quantityField.getDocument().addDocumentListener(listener);
sellingPriceField.getDocument().addDocumentListener(listener);
        // Add product to bill
        addProductButton.addActionListener(e -> {

            try {
                int productId = Integer.parseInt(
                    productIdField.getText().trim()
                );

                String productName =
                    productNameField.getText().trim();

                int availableStock = Integer.parseInt(
                    availableStockField.getText().trim()
                );

                double sellingPrice = Double.parseDouble(
                    sellingPriceField.getText().trim()
                );

                int quantity = Integer.parseInt(
                    quantityField.getText().trim()
                );

                if (productName.isEmpty()) {
                    JOptionPane.showMessageDialog(
                        this, "Enter product name."
                    );
                    return;
                }

                if (availableStock < 0 || sellingPrice < 0) {
                    JOptionPane.showMessageDialog(
                        this, "Stock and price cannot be negative."
                    );
                    return;
                }

                if (quantity <= 0) {
                    JOptionPane.showMessageDialog(
                        this, "Quantity must be greater than zero."
                    );
                    return;
                }

                if (quantity > availableStock) {
                    JOptionPane.showMessageDialog(
                        this, "Insufficient stock available."
                    );
                    return;
                }

                double total = sellingPrice * quantity;

                model.addRow(new Object[] {
                    productId,
                    productName,
                    sellingPrice,
                    quantity,
                    total
                });

                calculateGrandTotal(grandTotalLabel);

                productIdField.setText("");
                productNameField.setText("");
                availableStockField.setText("");
                sellingPriceField.setText("");
                quantityField.setText("");
                totalCostField.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                    this,
                    "Enter valid numeric values for ID, stock, price and quantity."
                );
            }
        });

        // Remove selected product
        removeButton.addActionListener(e -> {

            int selectedRow = billTable.getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(
                    this, "Please select an item to remove."
                );
                return;
            }

            model.removeRow(selectedRow);
            calculateGrandTotal(grandTotalLabel);
        });

        // Add customer button placeholder
        addCustomerButton.addActionListener(e ->
            JOptionPane.showMessageDialog(
                this,
                "Customer database integration is pending."
            )
        );

        // adding the new card for showing the bill summary  the fields of discount, discount amt, tax, tax amt  then the grand total 


        JPanel billSummary=new JPanel();
        billSummary.setBounds(830,50,500,420);
        billSummary.setLayout(null);
        add(billSummary);
        billSummary.setBackground(Color.WHITE);

        JLabel billsummary=new JLabel("BILL SUMMARY");
        billsummary.setBounds(20,10,200,50);
        billsummary.setFont(new Font("Arial", Font.BOLD, 18));
        billSummary.add(billsummary);


        JLabel subtotal=new JLabel("Sub Total (₹) :");
        subtotal.setBounds(20,80,100,20);
        subtotal.setFont(new Font("Arial",Font.BOLD, 14));
        billSummary.add(subtotal);

        JTextField subtotalField=new JTextField();
        subtotalField.setBounds(130,80,200,30);
        billSummary.add(subtotalField);

        JLabel discount=new JLabel("Discount %  :");
        discount.setBounds(20,120,100,20);
        discount.setFont(new Font("Arial",Font.BOLD,14));
        billSummary.add(discount);

        JTextField discountField=new JTextField();
        discountField.setBounds(130,120,200,30);
        billSummary.add(discountField);

        JLabel damt=new JLabel("Amount:");
        damt.setBounds(340,120,100,30);
        damt.setFont(new Font("Arial",Font.BOLD,14));
        billSummary.add(damt);

        JTextField discountamt=new JTextField();
        discountamt.setBounds(410,120,80,30);
        billSummary.add(discountamt);


        // ADDED THE TAX FIELD


        JLabel tax=new JLabel("Tax %           :");
        tax.setBounds(20,160,100,20);
        tax.setFont(new Font("Arial",Font.BOLD,14));
        billSummary.add(tax);

        JTextField taxField=new JTextField();
        taxField.setBounds(130,160,200,30);
        billSummary.add(taxField);

        // GET THE TAX % FROM Taxfield and fill it in the taxamt

         JLabel tamt=new JLabel("Amount:");
        tamt.setBounds(340,160,100,30);
        tamt.setFont(new Font("Arial",Font.BOLD,14));
        billSummary.add(tamt);

        JTextField taxamt=new JTextField();
        taxamt.setBounds(410,160,80,30);
        billSummary.add(taxamt);



        // for the total amt;


        JPanel tcpanel=new JPanel();
        tcpanel.setBounds(50,220,400,40);
        tcpanel.setBackground((new Color(252, 231, 243,225)));
        tcpanel.setLayout(null);
        billSummary.add(tcpanel);


        JLabel payableamt=new JLabel("Payalble Amt :");
        payableamt.setFont(new Font("Arial",Font.BOLD,18));
        payableamt.setBounds(2,10,200,30);
        tcpanel.add(payableamt);


        //now we will be adding the generate bill button

        JButton generateBillButton=new JButton("Generate Bill");
         generateBillButton.setBounds(50,280,400,40);
        // generatebill.setBackground(Color.RED);
        // billSummary.add(generatebill);
        generateBillButton.setBackground(new Color(220, 38, 38));
        generateBillButton.setForeground(Color.WHITE);
        generateBillButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        generateBillButton.setFocusPainted(false);
        generateBillButton.setBorderPainted(false);
        generateBillButton.setOpaque(true);
        billSummary.add(generateBillButton);


        // adding the function for generating the bill

        generateBillButton.addActionListener(e -> generateBill());
        

        JButton downloadButton = new JButton("Download Bill");
        downloadButton.setBounds(50,340,400,40);
        downloadButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        downloadButton.setBackground(new Color(22, 163, 74));
        downloadButton.setForeground(Color.WHITE);
        downloadButton.setFocusPainted(false);
        downloadButton.setOpaque(true);
        downloadButton.setBorderPainted(false);
        billSummary.add(downloadButton);
        
        downloadButton.addActionListener(e -> generateBill());
        // Recent Bills Card
JPanel recentBillsPanel = new JPanel(new BorderLayout(5, 5));
recentBillsPanel.setBounds(830, 480, 500, 240);
recentBillsPanel.setBackground(Color.WHITE);
recentBillsPanel.setBorder(
    BorderFactory.createLineBorder(new Color(220, 226, 235))
);

JLabel recentBillsHeading = new JLabel("  Recent Bills");
recentBillsHeading.setFont(new Font("Arial", Font.BOLD, 18));
recentBillsPanel.add(recentBillsHeading, BorderLayout.NORTH);

recentBillsModel = new DefaultTableModel(
    new String[]{"Bill No", "Customer Name", "Date", "Total (₹)"}, 0
) {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
};

recentBillsTable = new JTable(recentBillsModel);
recentBillsTable.setRowHeight(25);
recentBillsTable.setFont(new Font("Arial", Font.PLAIN, 12));
recentBillsTable.getTableHeader().setFont(
    new Font("Arial", Font.BOLD, 12)
);

recentBillsPanel.add(
    new JScrollPane(recentBillsTable),
    BorderLayout.CENTER
);

add(recentBillsPanel);

// Load previously saved bills
loadRecentBills();


JButton viewBillButton = new JButton("View Bill Details");
viewBillButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
viewBillButton.setBackground(new Color(37, 99, 235));
viewBillButton.setForeground(Color.WHITE);
viewBillButton.setFocusPainted(false);
viewBillButton.setBorderPainted(false);
viewBillButton.setOpaque(true);

JPanel historyButtonPanel = new JPanel(
    new FlowLayout(FlowLayout.RIGHT)
);
historyButtonPanel.setBackground(Color.WHITE);
historyButtonPanel.add(viewBillButton);

recentBillsPanel.add(historyButtonPanel, BorderLayout.SOUTH);

viewBillButton.addActionListener(e -> viewSelectedBillDetails());

    }







    private void viewSelectedBillDetails() {
    int selectedRow = recentBillsTable.getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(
            this,
            "Please select a bill from Recent Bills first."
        );
        return;
    }

    int billId = Integer.parseInt(
        recentBillsModel.getValueAt(selectedRow, 0)
            .toString().replace("B", "")
    );

    String sql = """
        SELECT product_name, selling_price, quantity, total
        FROM bill_items
        WHERE bill_id = ?
        """;

    StringBuilder details = new StringBuilder();

    details.append("BILL DETAILS\n");
    details.append("------------------------------------------\n");
    details.append("Bill No: B")
           .append(String.format("%03d", billId))
           .append("\n");

    details.append("Customer: ")
           .append(recentBillsModel.getValueAt(selectedRow, 1))
           .append("\n");

    details.append("Date: ")
           .append(recentBillsModel.getValueAt(selectedRow, 2))
           .append("\n\n");

    details.append(String.format(
        "%-18s %8s %5s %10s%n",
        "Product", "Price", "Qty", "Total"
    ));

    details.append("------------------------------------------\n");

    try (Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/Inventory",
            "root",
            "Vikram@300978");
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, billId);

        double grandTotal = 0;

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String productName = rs.getString("product_name");
                double price = rs.getDouble("selling_price");
                int quantity = rs.getInt("quantity");
                double total = rs.getDouble("total");

                details.append(String.format(
                    "%-18s %8.2f %5d %10.2f%n",
                    productName, price, quantity, total
                ));

                grandTotal += total;
            }
        }

        details.append("------------------------------------------\n");
        details.append(String.format(
            "ITEMS TOTAL: Rs. %.2f", grandTotal
        ));

        JTextArea textArea = new JTextArea(details.toString());
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));

        JOptionPane.showMessageDialog(
            this,
            new JScrollPane(textArea),
            "Bill Details",
            JOptionPane.INFORMATION_MESSAGE
        );

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(
            this,
            "Could not load bill details: " + ex.getMessage(),
            "Database Error",
            JOptionPane.ERROR_MESSAGE
        );
    }
}




private void loadRecentBills() {
    recentBillsModel.setRowCount(0);

    String sql = """
        SELECT bill_id, customer_name, bill_date, grand_total
        FROM bills
        ORDER BY bill_id DESC
        LIMIT 5
        """;

    try (Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/Inventory",
            "root",
            "Vikram@300978");
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            recentBillsModel.addRow(new Object[]{
                "B" + String.format("%03d", rs.getInt("bill_id")),
                rs.getString("customer_name"),
                rs.getTimestamp("bill_date"),
                rs.getBigDecimal("grand_total")
            });
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(
            this,
            "Unable to load recent bills: " + ex.getMessage(),
            "Database Error",
            JOptionPane.ERROR_MESSAGE
        );
    }



    
}












































   private void calculateItemTotal() {
    try {
        double price = Double.parseDouble(
            sellingPriceField.getText().trim()
        );

        int quantity = Integer.parseInt(
            quantityField.getText().trim()
        );

        if (price >= 0 && quantity >= 0) {
            double total = price * quantity;
            totalCostField.setText(String.format("%.2f", total));
        } else {
            totalCostField.setText("");
        }

    } catch (NumberFormatException e) {
        totalCostField.setText("");
    }
}

    private void calculateGrandTotal(JLabel grandTotalLabel) {

        double grandTotal = 0;

        for (int i = 0; i < model.getRowCount(); i++) {
            grandTotal += Double.parseDouble(
                model.getValueAt(i, 4).toString()
            );
        }

        grandTotalLabel.setText(
            String.format("Rs. %.2f", grandTotal)
        );
    }
    private void generateBill() {

    if (model.getRowCount() == 0) {
        JOptionPane.showMessageDialog(
            this,
            "Please add products before generating the bill."
        );
        return;
    }

    if (nameField.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(
            this,
            "Please enter customer name."
        );
        return;
    }

    StringBuilder bill = new StringBuilder();

    bill.append("       INVENTORY MANAGEMENT SYSTEM\n");
    bill.append("----------------------------------------\n");
    bill.append("                 CUSTOMER BILL\n");
    bill.append("----------------------------------------\n");
    bill.append("Customer Name: ")
        .append(nameField.getText()).append("\n");
    bill.append("Phone: ")
        .append(phoneField.getText()).append("\n");
    bill.append("----------------------------------------\n");

    double grandTotal = 0;

    for (int i = 0; i < model.getRowCount(); i++) {

        String productName =
            model.getValueAt(i, 1).toString();

        double price = Double.parseDouble(
            model.getValueAt(i, 2).toString()
        );

        int quantity = Integer.parseInt(
            model.getValueAt(i, 3).toString()
        );

        double total = Double.parseDouble(
            model.getValueAt(i, 4).toString()
        );

        bill.append(productName)
            .append(" | ₹").append(String.format("%.2f", price))
            .append(" x ").append(quantity)
            .append(" = ₹").append(String.format("%.2f", total))
            .append("\n");

        grandTotal += total;
    }

    bill.append("----------------------------------------\n");
    bill.append("GRAND TOTAL: ₹")
        .append(String.format("%.2f", grandTotal))
        .append("\n");
    bill.append("----------------------------------------\n");
    bill.append("         Thank you for shopping!");

    JTextArea billArea = new JTextArea(bill.toString());
    billArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
    billArea.setEditable(false);

    int choice = JOptionPane.showConfirmDialog(
        this,
        new JScrollPane(billArea),
        "Generated Bill",
        JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.PLAIN_MESSAGE
    );

    try {
    int billId = saveBillToDatabase(grandTotal);
    loadRecentBills();

    JOptionPane.showMessageDialog(
        this,
        "Bill saved successfully! Bill ID: " + billId
    );

    showBillScreen(bill.toString());

} catch (SQLException ex) {
    JOptionPane.showMessageDialog(
        this,
        "Failed to save bill: " + ex.getMessage(),
        "Database Error",
        JOptionPane.ERROR_MESSAGE
    );
    ex.printStackTrace();
}
}

private int saveBillToDatabase(double grandTotal) throws SQLException {
    String billSql = """
        INSERT INTO bills
        (customer_name, phone, email, grand_total)
        VALUES (?, ?, ?, ?)
        """;

    String itemSql = """
        INSERT INTO bill_items
        (bill_id, product_id, product_name,
         selling_price, quantity, total)
        VALUES (?, ?, ?, ?, ?, ?)
        """;

    try (Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/Inventory",
            "root",
            "Vikram@300978")) {

        conn.setAutoCommit(false);

        try {
            int billId;

            try (PreparedStatement billStmt =
                     conn.prepareStatement(
                         billSql,
                         Statement.RETURN_GENERATED_KEYS)) {

                billStmt.setString(1, nameField.getText().trim());
                billStmt.setString(2, phoneField.getText().trim());

                String email = emailField.getText().trim();
                billStmt.setString(3, email);
                billStmt.setDouble(4, grandTotal);

                billStmt.executeUpdate();

                try (ResultSet keys = billStmt.getGeneratedKeys()) {
                    if (!keys.next()) {
                        throw new SQLException("Bill ID was not generated.");
                    }
                    billId = keys.getInt(1);
                }
            }

            try (PreparedStatement itemStmt =
                     conn.prepareStatement(itemSql)) {

                for (int i = 0; i < model.getRowCount(); i++) {
                    itemStmt.setInt(1, billId);

                    Object productId =
                        model.getValueAt(i, 0);

                    if (productId == null ||
                        productId.toString().trim().isEmpty()) {
                        itemStmt.setNull(2, java.sql.Types.INTEGER);
                    } else {
                        itemStmt.setInt(
                            2, Integer.parseInt(productId.toString())
                        );
                    }

                    itemStmt.setString(
                        3, model.getValueAt(i, 1).toString()
                    );
                    itemStmt.setDouble(
                        4, Double.parseDouble(
                            model.getValueAt(i, 2).toString()
                        )
                    );
                    itemStmt.setInt(
                        5, Integer.parseInt(
                            model.getValueAt(i, 3).toString()
                        )
                    );
                    itemStmt.setDouble(
                        6, Double.parseDouble(
                            model.getValueAt(i, 4).toString()
                        )
                    );

                    itemStmt.addBatch();
                }

                itemStmt.executeBatch();
            }

            conn.commit();
            return billId;

        } catch (SQLException | RuntimeException ex) {
            conn.rollback();
            throw ex;
        }
    }
}

private void showBillScreen(String billText) {

    JFrame billFrame = new JFrame("Generated Bill");
    billFrame.setSize(650, 720);
    billFrame.setLocationRelativeTo(this);
    billFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    billFrame.setLayout(new BorderLayout(15, 15));
    billFrame.getContentPane().setBackground(
        new Color(241, 245, 249)
    );

    // Header
    JPanel header = new JPanel(new GridLayout(2, 1));
    header.setBackground(new Color(153, 27, 27));
    header.setBorder(
        BorderFactory.createEmptyBorder(15, 20, 15, 20)
    );

    JLabel title = new JLabel(
        "INVENTORY MANAGEMENT SYSTEM",
        SwingConstants.CENTER
    );
    title.setFont(new Font("Segoe UI", Font.BOLD, 22));
    title.setForeground(Color.WHITE);

    JLabel subtitle = new JLabel(
        "CUSTOMER INVOICE",
        SwingConstants.CENTER
    );
    subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    subtitle.setForeground(Color.WHITE);

    header.add(title);
    header.add(subtitle);

    // Receipt area
    JTextArea receipt = new JTextArea(billText);
    receipt.setFont(new Font("Monospaced", Font.PLAIN, 14));
    receipt.setEditable(false);
    receipt.setBackground(Color.WHITE);
    receipt.setMargin(new Insets(20, 20, 20, 20));
    receipt.setLineWrap(false);

    JScrollPane scrollPane = new JScrollPane(receipt);
    scrollPane.setBorder(
        BorderFactory.createEmptyBorder(15, 20, 5, 20)
    );

    // Buttons
    JPanel buttonPanel = new JPanel(
        new FlowLayout(FlowLayout.CENTER, 20, 15)
    );
    buttonPanel.setBackground(new Color(241, 245, 249));

    JButton printButton = new JButton("Print Bill");
    printButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
    printButton.setBackground(new Color(220, 38, 38));
    printButton.setForeground(Color.WHITE);
    printButton.setFocusPainted(false);
    printButton.setOpaque(true);
    printButton.setBorderPainted(false);

    JButton closeButton = new JButton("Close");
    JButton downloadButton = new JButton("Download Bill");
    downloadButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
    downloadButton.setBackground(new Color(22, 163, 74));
    downloadButton.setForeground(Color.WHITE);
    downloadButton.setFocusPainted(false);
    downloadButton.setOpaque(true);
    downloadButton.setBorderPainted(false);
    closeButton.setFont(new Font("Segoe UI", Font.BOLD, 14));

    JButton whatsappButton = new JButton("Share on WhatsApp");
JButton emailButton = new JButton("Share via Email");

whatsappButton.setFont(
    new Font("Segoe UI", Font.BOLD, 14)
);
whatsappButton.setBackground(new Color(22, 163, 74));
whatsappButton.setForeground(Color.WHITE);
whatsappButton.setFocusPainted(false);

emailButton.setFont(
    new Font("Segoe UI", Font.BOLD, 14)
);

    printButton.addActionListener(e -> {
        try {
            receipt.print();
        } catch (java.awt.print.PrinterException ex) {
            JOptionPane.showMessageDialog(
                billFrame,
                "Printing failed: " + ex.getMessage()
            );
        }
    });

    closeButton.addActionListener(e -> billFrame.dispose());
    downloadButton.addActionListener(e -> {
    JFileChooser chooser = new JFileChooser();
    chooser.setDialogTitle("Download Bill");
    chooser.setSelectedFile(
        new java.io.File("Customer_Bill.txt")
    );




    whatsappButton.addActionListener(epp -> {

    String phone = phoneField.getText().trim();

    if (phone.isEmpty()) {
        JOptionPane.showMessageDialog(
            billFrame,
            "Please enter customer phone number."
        );
        return;
    }

    phone = phone.replaceAll("[^0-9]", "");

    if (phone.length() == 10) {
        phone = "91" + phone;
    }

    try {
        String message = java.net.URLEncoder.encode(
            billText,
            java.nio.charset.StandardCharsets.UTF_8
        );

        String url = "https://wa.me/" + phone + "?text=" + message;

        java.awt.Desktop.getDesktop().browse(
            new java.net.URI(url)
        );

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(
            billFrame,
            "Unable to open WhatsApp: " + ex.getMessage()
        );
    }
});
    int result = chooser.showSaveDialog(billFrame);

    if (result == JFileChooser.APPROVE_OPTION) {
        java.io.File file = chooser.getSelectedFile();

        if (!file.getName().toLowerCase().endsWith(".txt")) {
            file = new java.io.File(
                file.getAbsolutePath() + ".txt"
            );
        }

        if (file.exists()) {
            int choice = JOptionPane.showConfirmDialog(
                billFrame,
                "File already exists. Replace it?",
                "Confirm Save",
                JOptionPane.YES_NO_OPTION
            );

            if (choice != JOptionPane.YES_OPTION) {
                return;
            }
        }

        try (java.io.BufferedWriter writer =
                 new java.io.BufferedWriter(
                     new java.io.FileWriter(file))) {

            writer.write(billText);

            JOptionPane.showMessageDialog(
                billFrame,
                "Bill downloaded successfully!\n" +
                file.getAbsolutePath()
            );

        } catch (java.io.IOException ex) {
            JOptionPane.showMessageDialog(
                billFrame,
                "Error saving bill: " + ex.getMessage()
            );
        }
    }
});


buttonPanel.add(downloadButton);
buttonPanel.add(whatsappButton);
buttonPanel.add(emailButton);
buttonPanel.add(printButton);
buttonPanel.add(closeButton);

    billFrame.add(header, BorderLayout.NORTH);
    billFrame.add(scrollPane, BorderLayout.CENTER);
    billFrame.add(buttonPanel, BorderLayout.SOUTH);

    billFrame.setVisible(true);
}


}
