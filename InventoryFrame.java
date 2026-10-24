// import java.awt.*;
// import java.sql.*;
// import javax.swing.*;
// import javax.swing.event.DocumentEvent;
// import javax.swing.event.DocumentListener;
// import javax.swing.table.DefaultTableModel;

// public class InventoryFrame extends JFrame {

//     // Update these values to match your local MySQL setup.
//     private static final String DB_URL = "jdbc:mysql://localhost:3306/Inventory";
//     private static final String DB_USER = "root";
//     private static final String DB_PASSWORD = "Vikram@300978";

//     private final JPanel navigationPanel = new JPanel(null);
//     private final JPanel body = new JPanel(null);
//     private final JPanel rightSideBar = new JPanel(null);
//     private final JPanel lowerBar = new JPanel(null);

//     private final JButton productButton = new JButton("PRODUCT");
//     private final JButton salesButton = new JButton("SALES");
//     private final JButton purchaseButton = new JButton("PURCHASE");
//     private final JButton stockButton = new JButton("STOCK");
//     private final JButton customerButton = new JButton("CUSTOMER");
//     private final JButton billingHistoryButton = new JButton("BILL HISTORY");
//     private final JButton billingButton = new JButton("BILLING");

//     private JTable stockTable;
//     private DefaultTableModel stockModel;

//     private JTextField nameField;
//     private JTextField idField;
//     private JTextField supplierField;
//     private JTextField purchasePriceField;
//     private JTextField sellingPriceField;
//     private JTextField quantityField;
//     private JTextField totalCostField;

//     private JLabel inventoryCostLabel;
//     private String originalProductId;

//     public InventoryFrame() {
//         setTitle("Inventory Management System");
//         setSize(1600, 950);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLocationRelativeTo(null);
//         setLayout(null);
//         getContentPane().setBackground(new Color(238, 240, 243));

//         createNavigation();
//         createHeading();
//         createMainPanels();
//         createNavigationActions();

//         showStockScreen();
//         setVisible(true);
//     }

//     private void createNavigation() {
//         navigationPanel.setBounds(0, 0, 185, 920);
//         navigationPanel.setBackground(new Color(30, 41, 59));
//         add(navigationPanel);

//         JButton[] buttons = {
//             productButton, salesButton, purchaseButton, stockButton,
//             customerButton, billingHistoryButton, billingButton
//         };

//         int y = 40;
//         for (JButton button : buttons) {
//             button.setBounds(20, y, 125, 32);
//             button.setFocusPainted(false);
//             navigationPanel.add(button);
//             y += 42;
//         }
//     }

//     private void createHeading() {
//         JLabel heading = new JLabel("INVENTORY MANAGEMENT SYSTEM");
//         heading.setFont(new Font("Arial", Font.BOLD, 26));
//         heading.setBounds(500, 0, 650, 50);
//         add(heading);
//     }

//     private void createMainPanels() {
//         // Main content area. ProductFrame is placed here when PRODUCT is clicked.
//         body.setBounds(205, 50, 980, 700);
//         body.setBackground(new Color(241, 245, 249));
//         add(body);

//         // This sidebar belongs to the STOCK screen only.
//         rightSideBar.setBounds(1200, 65, 350, 580);
//         rightSideBar.setBackground(Color.WHITE);
//         add(rightSideBar);

//         lowerBar.setBounds(205, 760, 980, 75);
//         lowerBar.setBackground(new Color(241, 245, 249));
//         add(lowerBar);
//     }

//     private void createNavigationActions() {
//         productButton.addActionListener(e -> showProductScreen());
//         stockButton.addActionListener(e -> showStockScreen());
//         billingHistoryButton.addActionListener(e->{
//              body.removeAll();
//     rightSideBar.setVisible(false);
//     lowerBar.setVisible(false);

//     SalesHistoryPanel salesHistoryPanel = new SalesHistoryPanel();
//     salesHistoryPanel.setBounds(
//         0, 0, body.getWidth(), body.getHeight()
//     );

//     body.add(salesHistoryPanel);
//     body.revalidate();
//     body.repaint();

//         });
//         // Other sections are not implemented in this class yet.
//         salesButton.addActionListener(e -> showNotImplemented("Sales"));
//         purchaseButton.addActionListener(e -> showNotImplemented("Purchase"));
//         customerButton.addActionListener(e -> {
//             body.removeAll();
//             rightSideBar.setVisible(false);
//             lowerBar.setVisible(false);
//             CustomerFrame customerPanel = new CustomerFrame();
//             customerPanel.setBounds(0, 0, body.getWidth(), body.getHeight());body.add(customerPanel);
//             body.revalidate();
//             body.repaint();
// });
//         billingButton.addActionListener(e -> showBillingScreen());
//     }

//     private void showBillingScreen()
//     {

//         body.removeAll();
//         rightSideBar.setVisible(false);
//         lowerBar.setVisible(false);
//         body.setBounds(205, 50, 1500, 900);
//         BillingFrame obj=new BillingFrame();
//         obj.setBounds(0,0,body.getWidth(), body.getHeight());
//         body.add(obj);
//         body.revalidate();
//         body.repaint();
//     }

//     private void showProductScreen() {
//         body.removeAll();

//         // Hide the STOCK sidebar and stock total area.
//         rightSideBar.setVisible(false);
//         lowerBar.setVisible(false);

//         ProductFrame productFrame = new ProductFrame();
//         productFrame.setBounds(0, 0, body.getWidth(), body.getHeight());
//         body.add(productFrame);

//         body.revalidate();
//         body.repaint();
//     }

//     private void showStockScreen() {
//         body.removeAll();
//         rightSideBar.removeAll();
//         lowerBar.removeAll();

//         body.setBounds(205, 50, 980, 700);
//         rightSideBar.setVisible(true);
//         lowerBar.setVisible(true);

//         createStockTable();
//         createStockForm();
//         createStockButtons();
//         createInventoryCostLabel();

//         loadStockTable();
//         body.revalidate();
//         body.repaint();
//         rightSideBar.revalidate();
//         rightSideBar.repaint();
//         lowerBar.revalidate();
//         lowerBar.repaint();
//     }

//     private void createStockTable() {
//         stockModel = new DefaultTableModel() {
//             @Override
//             public boolean isCellEditable(int row, int column) {
//                 return false;
//             }
//         };

//         stockTable = new JTable(stockModel);
//         stockTable.setFont(new Font("Arial", Font.PLAIN, 14));
//         stockTable.setRowHeight(28);
//         stockTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

//         JScrollPane scrollPane = new JScrollPane(stockTable);
//         scrollPane.setBounds(0, 0, body.getWidth(), body.getHeight());
//         body.add(scrollPane);

//         stockTable.getSelectionModel().addListSelectionListener(e -> {
//             if (e.getValueIsAdjusting()) {
//                 return;
//             }

//             int selectedRow = stockTable.getSelectedRow();
//             if (selectedRow < 0) {
//                 return;
//             }

//             int row = stockTable.convertRowIndexToModel(selectedRow);
//             nameField.setText(getValue(row, "product_name"));
//             idField.setText(getValue(row, "product_id"));
//             supplierField.setText(getValue(row, "supplier"));
//             purchasePriceField.setText(getValue(row, "purchase_price"));
//             sellingPriceField.setText(getValue(row, "selling_price"));
//             quantityField.setText(getValue(row, "quantity"));
//             totalCostField.setText(getValue(row, "total"));
//             originalProductId = getValue(row, "product_id");
//         });
//     }

//     private void createStockForm() {
//         rightSideBar.setLayout(null);

//         nameField = addFormField("Product Name", 20);
//         idField = addFormField("Product ID", 65);
//         supplierField = addFormField("Supplier", 110);
//         purchasePriceField = addFormField("Purchase Price", 155);
//         sellingPriceField = addFormField("Selling Price", 200);
//         quantityField = addFormField("Quantity", 245);
//         totalCostField = addFormField("Total Cost", 290);
//         totalCostField.setEditable(true);

//         DocumentListener calculator = new DocumentListener() {
//             @Override public void insertUpdate(DocumentEvent e) { calculateTotalCost(); }
//             @Override public void removeUpdate(DocumentEvent e) { calculateTotalCost(); }
//             @Override public void changedUpdate(DocumentEvent e) { calculateTotalCost(); }
//         };
//         purchasePriceField.getDocument().addDocumentListener(calculator);
//         quantityField.getDocument().addDocumentListener(calculator);
//     }

//     private JTextField addFormField(String labelText, int y) {
//         JLabel label = new JLabel(labelText);
//         label.setFont(new Font("Arial", Font.PLAIN, 13));
//         label.setBounds(20, y, 120, 25);
//         rightSideBar.add(label);

//         JTextField field = new JTextField();
//         field.setBounds(145, y, 180, 28);
//         rightSideBar.add(field);
//         return field;
//     }

//     private void createStockButtons() {
//         JButton addButton = new JButton("ADD STOCK");
//         JButton updateButton = new JButton("UPDATE STOCK");
//         JButton deleteButton = new JButton("DELETE STOCK");
//         JButton clearButton = new JButton("CLEAR FIELDS");
//         JButton refreshButton = new JButton("REFRESH TABLE");

//         addButton.setBounds(20, 355, 145, 35);
//         updateButton.setBounds(175, 355, 150, 35);
//         deleteButton.setBounds(20, 405, 145, 35);
//         clearButton.setBounds(175, 405, 150, 35);
//         refreshButton.setBounds(20, 455, 305, 35);

//         rightSideBar.add(addButton);
//         rightSideBar.add(updateButton);
//         rightSideBar.add(deleteButton);
//         rightSideBar.add(clearButton);
//         rightSideBar.add(refreshButton);

//         addButton.addActionListener(e -> addStock());
//         updateButton.addActionListener(e -> updateStock());
//         deleteButton.addActionListener(e -> deleteStock());
//         clearButton.addActionListener(e -> clearStockFields());
//         refreshButton.addActionListener(e -> {
//             loadStockTable();
//             refreshInventoryCost();
//         });
//     }

//     private void createInventoryCostLabel() {
//         inventoryCostLabel = new JLabel("Total Inventory Cost: ₹0");
//         inventoryCostLabel.setFont(new Font("Arial", Font.BOLD, 22));
//         inventoryCostLabel.setForeground(new Color(22, 163, 74));
//         inventoryCostLabel.setBounds(20, 15, 700, 40);
//         lowerBar.add(inventoryCostLabel);
//         refreshInventoryCost();
//     }

//     private void calculateTotalCost() {
//         try {
//             int price = Integer.parseInt(purchasePriceField.getText().trim());
//             int quantity = Integer.parseInt(quantityField.getText().trim());
//             totalCostField.setText(String.valueOf(price * quantity));
//         } catch (NumberFormatException ex) {
//             totalCostField.setText("");
//         }
//     }

//     private void addStock() {
//         try {
//             String productName = nameField.getText().trim();
//             int productId = Integer.parseInt(idField.getText().trim());
//             String supplier = supplierField.getText().trim();
//             int purchasePrice = Integer.parseInt(purchasePriceField.getText().trim());
//             int sellingPrice = Integer.parseInt(sellingPriceField.getText().trim());
//             int quantity = Integer.parseInt(quantityField.getText().trim());
//             int total = purchasePrice * quantity;

//             if (productName.isEmpty() || supplier.isEmpty()) {
//                 JOptionPane.showMessageDialog(this, "Enter product name and supplier.");
//                 return;
//             }

//             String sql = "INSERT INTO stock " +
//                 "(product_id, product_name, supplier, purchase_price, selling_price, quantity, total) " +
//                 "VALUES (?, ?, ?, ?, ?, ?, ?)";

//             try (Connection con = getConnection();
//                  PreparedStatement check = con.prepareStatement(
//                      "SELECT product_id FROM stock WHERE product_id = ?");
//                  ) {

//                 check.setInt(1, productId);
//                 try (ResultSet rs = check.executeQuery()) {
//                     if (rs.next()) {
//                         JOptionPane.showMessageDialog(this, "Product with this ID already exists!");
//                         return;
//                     }
//                 }

//                 try (PreparedStatement ps = con.prepareStatement(sql)) {
//                     ps.setInt(1, productId);
//                     ps.setString(2, productName);
//                     ps.setString(3, supplier);
//                     ps.setInt(4, purchasePrice);
//                     ps.setInt(5, sellingPrice);
//                     ps.setInt(6, quantity);
//                     ps.setInt(7, total);
//                     ps.executeUpdate();

// /// YEH ADD KIYA HAI 
// /// 
//                     PreparedStatement stmtpre=con.prepareStatement("select * from product where PRODUCT_ID=?");;
//                 stmtpre.setInt(1,productId);
//                 ResultSet result=stmtpre.executeQuery();
//                 if(!result.next())
//                 {                   
//                     String sql2=" INSERT INTO product VALUES(?,?,?,?,?)";
//                     PreparedStatement st=con.prepareStatement(sql2);
//                     st.setString(2, productName);
//                     st.setInt(1, productId);
//                     st.setString(3, supplier);
//                     st.setInt(4, purchasePrice);
//                     st.setInt(5, sellingPrice);
//                     int ress=st.executeUpdate();
//                     if(ress>0)
//                     {
//                         JOptionPane.showMessageDialog(body,"PRODUCT WAS ADDED ");
//                     }
//                     else{

//                         JOptionPane.showMessageDialog(body,"THE PRODUCT WAS NOT ADDED");

//                     }
//                 }
//                 else{
//                     JOptionPane.showMessageDialog(body,"the product cannot be added in product");
//                 }
//                 // YAHA TAK
//                 }
//             }
//             JOptionPane.showMessageDialog(this, "Stock added successfully.");
//             clearStockFields();
//             loadStockTable();
//             refreshInventoryCost();
//         } catch (NumberFormatException ex) {
//             JOptionPane.showMessageDialog(this,
//                 "Product ID, prices and quantity must be valid integers.");
//         } catch (SQLException ex) {
//             showDatabaseError("Could not add stock", ex);
//         }
//     }

//     private void updateStock() {
//         if (originalProductId == null) {
//             JOptionPane.showMessageDialog(this, "Please select a product from the table first.");
//             return;
//         }

//         try {
//             String productName = nameField.getText().trim();
//             int newProductId = Integer.parseInt(idField.getText().trim());
//             String supplier = supplierField.getText().trim();
//             int purchasePrice = Integer.parseInt(purchasePriceField.getText().trim());
//             int sellingPrice = Integer.parseInt(sellingPriceField.getText().trim());
//             int quantity = Integer.parseInt(quantityField.getText().trim());
//             int total = purchasePrice * quantity;

//             String sql = "UPDATE stock SET product_name=?, product_id=?, supplier=?, " +
//                 "purchase_price=?, selling_price=?, quantity=?, total=? WHERE product_id=?";

//             try (Connection con = getConnection();
//                  PreparedStatement ps = con.prepareStatement(sql)) {
//                 ps.setString(1, productName);
//                 ps.setInt(2, newProductId);
//                 ps.setString(3, supplier);
//                 ps.setInt(4, purchasePrice);
//                 ps.setInt(5, sellingPrice);
//                 ps.setInt(6, quantity);
//                 ps.setInt(7, total);
//                 ps.setInt(8, Integer.parseInt(originalProductId));

//                 int updated = ps.executeUpdate();
//                 if (updated > 0) {
//                     JOptionPane.showMessageDialog(this, "Stock updated successfully!");
//                     clearStockFields();
//                     loadStockTable();
//                     refreshInventoryCost();
//                 } else {
//                     JOptionPane.showMessageDialog(this, "No matching product was found.");
//                 }
//             }
//         } catch (NumberFormatException ex) {
//             JOptionPane.showMessageDialog(this, "Enter valid numeric values for ID, prices and quantity.");
//         } catch (SQLException ex) {
//             showDatabaseError("Could not update stock", ex);
//         }
//     }

//     private void deleteStock() {
//         String idText = idField.getText().trim();
//         if (idText.isEmpty()) {
//             JOptionPane.showMessageDialog(this, "Enter or select a Product ID first.");
//             return;
//         }

//         try {
//             int productId = Integer.parseInt(idText);
//             try (Connection con = getConnection();
//                  PreparedStatement ps = con.prepareStatement(
//                      "DELETE FROM stock WHERE product_id = ? ")) {
//                 ps.setInt(1, productId);
//                 int deleted = ps.executeUpdate();

//                 if (deleted > 0) {
//                     JOptionPane.showMessageDialog(this, "Item deleted successfully.");
//                     clearStockFields();
//                     loadStockTable();
//                     refreshInventoryCost();
//                 } else {
//                     JOptionPane.showMessageDialog(this, "Item not found.");
//                 }
//             }
//         } catch (NumberFormatException ex) {
//             JOptionPane.showMessageDialog(this, "Product ID must be an integer.");
//         } catch (SQLException ex) {
//             showDatabaseError("Could not delete stock", ex);
//         }
//     }

//     private void clearStockFields() {
//         nameField.setText("");
//         idField.setText("");
//         supplierField.setText("");
//         purchasePriceField.setText("");
//         sellingPriceField.setText("");
//         quantityField.setText("");
//         totalCostField.setText("");
//         originalProductId = null;
//         if (stockTable != null) {
//             stockTable.clearSelection();
//         }
//     }

//     private void loadStockTable() {
//         String sql = "SELECT * FROM stock";

//         try (Connection con = getConnection();
//              Statement st = con.createStatement();
//              ResultSet rs = st.executeQuery(sql)) {

//             stockModel.setRowCount(0);
//             stockModel.setColumnCount(0);

//             ResultSetMetaData metadata = rs.getMetaData();
//             int columnCount = metadata.getColumnCount();

//             for (int i = 1; i <= columnCount; i++) {
//                 stockModel.addColumn(metadata.getColumnLabel(i));
//             }

//             while (rs.next()) {
//                 Object[] row = new Object[columnCount];
//                 for (int i = 1; i <= columnCount; i++) {
//                     row[i - 1] = rs.getObject(i);
//                 }
//                 stockModel.addRow(row);
//             }

//         } catch (SQLException ex) {
//             showDatabaseError("Error loading stock", ex);
//         }
//     }

//     private void refreshInventoryCost() {
//         if (inventoryCostLabel == null) {
//             return;
//         }

//         String sql = "SELECT COALESCE(SUM(total), 0) AS total_inventory_cost FROM stock";
//         try (Connection con = getConnection();
//              PreparedStatement ps = con.prepareStatement(sql);
//              ResultSet rs = ps.executeQuery()) {

//             if (rs.next()) {
//                 inventoryCostLabel.setText(
//                     "Total Inventory Cost: ₹" + rs.getDouble("total_inventory_cost")
//                 );
//             }
//         } catch (SQLException ex) {
//             showDatabaseError("Could not calculate inventory cost", ex);
//         }
//     }

//     private String getValue(int row, String columnName) {
//         for (int column = 0; column < stockModel.getColumnCount(); column++) {
//             if (stockModel.getColumnName(column).equalsIgnoreCase(columnName)) {
//                 Object value = stockModel.getValueAt(row, column);
//                 return value == null ? "" : value.toString();
//             }
//         }
//         return "";
//     }

//     private Connection getConnection() throws SQLException {
//         if ("YOUR_MYSQL_PASSWORD".equals(DB_PASSWORD)) {
//             throw new SQLException(
//                 "Set DB_PASSWORD in InventoryFrame.java to your local MySQL password."
//             );
//         }
//         return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//     }

//     private void showDatabaseError(String message, SQLException ex) {
//         ex.printStackTrace();
//         JOptionPane.showMessageDialog(this, message + ": " + ex.getMessage());
//     }

//     private void showNotImplemented(String section) {
//         JOptionPane.showMessageDialog(this, section + " section is not implemented yet.");
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(InventoryFrame::new);
//     }
// }



import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class InventoryFrame extends JFrame {

    // Update these values to match your local MySQL setup.
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Inventory";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Vikram@300978";

    private final JPanel navigationPanel = new JPanel(null);
    private final JPanel body = new JPanel(null);
    private final JPanel rightSideBar = new JPanel(null);
    private final JPanel lowerBar = new JPanel(null);

    private final JButton productButton = new JButton("PRODUCT");
    private final JButton salesButton = new JButton("SALES");
    private final JButton purchaseButton = new JButton("PURCHASE");
    private final JButton stockButton = new JButton("STOCK");
    private final JButton customerButton = new JButton("CUSTOMER");
    private final JButton billingHistoryButton = new JButton("BILL HISTORY");
    private final JButton billingButton = new JButton("BILLING");

    private JTable stockTable;
    private DefaultTableModel stockModel;

    private JTextField nameField;
    private JTextField idField;
    private JTextField supplierField;
    private JTextField purchasePriceField;
    private JTextField sellingPriceField;
    private JTextField quantityField;
    private JTextField totalCostField;

    private JLabel inventoryCostLabel;
    private String originalProductId;

    public InventoryFrame() {
        setTitle("Inventory Management System");
        setSize(1600, 950);
        setMinimumSize(new Dimension(1200, 750));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(244, 247, 252));

        createNavigation();
        createHeading();
        createMainPanels();
        createNavigationActions();

        showStockScreen();
        setVisible(true);
    }

    private void createNavigation() {
        navigationPanel.setBounds(0, 0, 185, 920);
        navigationPanel.setBackground(new Color(20, 30, 58));
        add(navigationPanel);

        JButton[] buttons = {
            productButton, salesButton, purchaseButton, stockButton,
            customerButton, billingHistoryButton, billingButton
        };

        int y = 40;
        for (JButton button : buttons) {
            button.setBounds(14, y, 155, 38);
            button.setFont(new Font("Segoe UI", Font.BOLD, 11));
            button.setForeground(new Color(226, 232, 240));
            button.setBackground(new Color(35, 49, 82));
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder(5, 12, 5, 8));
            button.setHorizontalAlignment(SwingConstants.LEFT);
            button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button.setOpaque(true);
            navigationPanel.add(button);
            y += 42;
        }
    }

    private void createHeading() {
        JLabel heading = new JLabel("INVENTORY MANAGEMENT SYSTEM");
        heading.setFont(new Font("Segoe UI", Font.BOLD, 25));
        heading.setForeground(new Color(30, 41, 80));
        heading.setBounds(220, 0, 850, 48);
        add(heading);
    }

    private void createMainPanels() {
        // Main content area. ProductFrame is placed here when PRODUCT is clicked.
        body.setBounds(205, 50, 980, 700);
        body.setBackground(new Color(247, 249, 253));
        add(body);

        // This sidebar belongs to the STOCK screen only.
        rightSideBar.setBounds(1200, 65, 350, 580);
        rightSideBar.setBackground(Color.WHITE);
        rightSideBar.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(222, 230, 242)),
            BorderFactory.createEmptyBorder(8, 8, 8, 8)));
        add(rightSideBar);

        lowerBar.setBounds(205, 760, 980, 75);
        lowerBar.setBackground(new Color(247, 249, 253));
        add(lowerBar);
    }

    private void createNavigationActions() {
        productButton.addActionListener(e -> showProductScreen());
        stockButton.addActionListener(e -> showStockScreen());
        billingHistoryButton.addActionListener(e->{
             body.removeAll();
    rightSideBar.setVisible(false);
    lowerBar.setVisible(false);

    SalesHistoryPanel salesHistoryPanel = new SalesHistoryPanel();
    salesHistoryPanel.setBounds(
    0, 0, body.getWidth(), body.getHeight()
);

    body.add(salesHistoryPanel);
    body.revalidate();
    body.repaint();

        });
        // Other sections are not implemented in this class yet.
        salesButton.addActionListener(e -> showNotImplemented("Sales"));
        purchaseButton.addActionListener(e -> showNotImplemented("Purchase"));
        customerButton.addActionListener(e -> {
    body.removeAll();

    rightSideBar.setVisible(false);
    lowerBar.setVisible(false);

    int contentWidth = getContentPane().getWidth();
    int contentHeight = getContentPane().getHeight();

    body.setBounds(
        195,
        50,
        contentWidth - 215,
        contentHeight - 100
    );

    CustomerFrame customerPanel = new CustomerFrame();
    customerPanel.setBounds(
        0, 0, body.getWidth(), body.getHeight()
    );

    body.add(customerPanel);
    body.revalidate();
    body.repaint();
});
        billingButton.addActionListener(e -> showBillingScreen());
    }

    private void showBillingScreen()
    {

        body.removeAll();
        rightSideBar.setVisible(false);
        lowerBar.setVisible(false);
        body.setBounds(205, 50, 1380, 800);
        BillingFrame obj=new BillingFrame();
        obj.setBounds(0,0,body.getWidth(), body.getHeight());
        body.add(obj);
        body.revalidate();
        body.repaint();
    }

    private void showProductScreen() {
        body.removeAll();

        // Hide the STOCK sidebar and stock total area.
        rightSideBar.setVisible(false);
        lowerBar.setVisible(false);

        ProductFrame productFrame = new ProductFrame();
        productFrame.setBounds(0, 0, body.getWidth(), body.getHeight());
        body.add(productFrame);

        body.revalidate();
        body.repaint();
    }

    private void showStockScreen() {
        body.removeAll();
        rightSideBar.removeAll();
        lowerBar.removeAll();

        body.setBounds(205, 50, 980, 700);
        rightSideBar.setVisible(true);
        lowerBar.setVisible(true);

        createStockTable();
        createStockForm();
        createStockButtons();
        createInventoryCostLabel();

        loadStockTable();
        body.revalidate();
        body.repaint();
        rightSideBar.revalidate();
        rightSideBar.repaint();
        lowerBar.revalidate();
        lowerBar.repaint();
    }

    private void createStockTable() {
        stockModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        stockTable = new JTable(stockModel);
        stockTable.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        stockTable.setRowHeight(34);
        stockTable.setForeground(new Color(43, 54, 75));
        stockTable.setBackground(Color.WHITE);
        stockTable.setSelectionBackground(new Color(219, 234, 254));
        stockTable.setSelectionForeground(new Color(30, 41, 59));
        stockTable.setGridColor(new Color(226, 232, 240));
        stockTable.setShowVerticalLines(false);
        stockTable.setShowHorizontalLines(true);
        stockTable.setFillsViewportHeight(true);
        stockTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        stockTable.getTableHeader().setBackground(new Color(30, 41, 80));
        stockTable.getTableHeader().setForeground(Color.WHITE);
        stockTable.getTableHeader().setPreferredSize(new Dimension(0, 38));
        stockTable.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(stockTable);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(222, 230, 242)));
        scrollPane.setBounds(0, 0, body.getWidth(), body.getHeight());
        body.add(scrollPane);

        stockTable.getSelectionModel().addListSelectionListener(e -> {
            if (e.getValueIsAdjusting()) {
                return;
            }

            int selectedRow = stockTable.getSelectedRow();
            if (selectedRow < 0) {
                return;
            }

            int row = stockTable.convertRowIndexToModel(selectedRow);
            nameField.setText(getValue(row, "product_name"));
            idField.setText(getValue(row, "product_id"));
            supplierField.setText(getValue(row, "supplier"));
            purchasePriceField.setText(getValue(row, "purchase_price"));
            sellingPriceField.setText(getValue(row, "selling_price"));
            quantityField.setText(getValue(row, "quantity"));
            totalCostField.setText(getValue(row, "total"));
            originalProductId = getValue(row, "product_id");
        });
    }

    private void createStockForm() {
        rightSideBar.setLayout(null);

        nameField = addFormField("Product Name", 20);
        idField = addFormField("Product ID", 65);
        supplierField = addFormField("Supplier", 110);
        purchasePriceField = addFormField("Purchase Price", 155);
        sellingPriceField = addFormField("Selling Price", 200);
        quantityField = addFormField("Quantity", 245);
        totalCostField = addFormField("Total Cost", 290);
        totalCostField.setEditable(true);

        DocumentListener calculator = new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) { calculateTotalCost(); }
            @Override public void removeUpdate(DocumentEvent e) { calculateTotalCost(); }
            @Override public void changedUpdate(DocumentEvent e) { calculateTotalCost(); }
        };
        purchasePriceField.getDocument().addDocumentListener(calculator);
        quantityField.getDocument().addDocumentListener(calculator);
    }

    private JTextField addFormField(String labelText, int y) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label.setForeground(new Color(55, 65, 85));
        label.setBounds(20, y, 120, 25);
        rightSideBar.add(label);

        JTextField field = new JTextField();
        field.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        field.setForeground(new Color(30, 41, 59));
        field.setBackground(new Color(250, 252, 255));
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(203, 213, 225)),
            BorderFactory.createEmptyBorder(4, 7, 4, 7)));
        field.setBounds(145, y, 180, 28);
        rightSideBar.add(field);
        return field;
    }

    private void createStockButtons() {
        JButton addButton = new JButton("ADD STOCK");
        JButton updateButton = new JButton("UPDATE STOCK");
        JButton deleteButton = new JButton("DELETE STOCK");
        JButton clearButton = new JButton("CLEAR FIELDS");
        JButton refreshButton = new JButton("REFRESH TABLE");

        addButton.setBounds(20, 355, 145, 35);
        updateButton.setBounds(175, 355, 150, 35);
        deleteButton.setBounds(20, 405, 145, 35);
        clearButton.setBounds(175, 405, 150, 35);
        refreshButton.setBounds(20, 455, 305, 35);

        styleButton(addButton, new Color(37, 99, 235));
        styleButton(updateButton, new Color(124, 58, 237));
        styleButton(deleteButton, new Color(220, 38, 38));
        styleButton(clearButton, new Color(71, 85, 105));
        styleButton(refreshButton, new Color(13, 148, 136));

        rightSideBar.add(addButton);
        rightSideBar.add(updateButton);
        rightSideBar.add(deleteButton);
        rightSideBar.add(clearButton);
        rightSideBar.add(refreshButton);

        addButton.addActionListener(e -> addStock());
        updateButton.addActionListener(e -> updateStock());
        deleteButton.addActionListener(e -> deleteStock());
        clearButton.addActionListener(e -> clearStockFields());
        refreshButton.addActionListener(e -> {
            loadStockTable();
            refreshInventoryCost();
        });
    }

    private void styleButton(JButton button, Color color) {
        button.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);
    }

    private void createInventoryCostLabel() {
        inventoryCostLabel = new JLabel("Total Inventory Cost: ₹0");
        inventoryCostLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        inventoryCostLabel.setForeground(new Color(5, 150, 105));
        inventoryCostLabel.setBounds(20, 15, 700, 40);
        lowerBar.add(inventoryCostLabel);
        refreshInventoryCost();
    }

    private void calculateTotalCost() {
        try {
            int price = Integer.parseInt(purchasePriceField.getText().trim());
            int quantity = Integer.parseInt(quantityField.getText().trim());
            totalCostField.setText(String.valueOf(price * quantity));
        } catch (NumberFormatException ex) {
            totalCostField.setText("");
        }
    }

    private void addStock() {
        try {
            String productName = nameField.getText().trim();
            int productId = Integer.parseInt(idField.getText().trim());
            String supplier = supplierField.getText().trim();
            int purchasePrice = Integer.parseInt(purchasePriceField.getText().trim());
            int sellingPrice = Integer.parseInt(sellingPriceField.getText().trim());
            int quantity = Integer.parseInt(quantityField.getText().trim());
            int total = purchasePrice * quantity;

            if (productName.isEmpty() || supplier.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter product name and supplier.");
                return;
            }

            String sql = "INSERT INTO stock " +
                "(product_id, product_name, supplier, purchase_price, selling_price, quantity, total) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (Connection con = getConnection();
                 PreparedStatement check = con.prepareStatement(
                     "SELECT product_id FROM stock WHERE product_id = ?");
                 ) {

                check.setInt(1, productId);
                try (ResultSet rs = check.executeQuery()) {
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(this, "Product with this ID already exists!");
                        return;
                    }
                }

                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setInt(1, productId);
                    ps.setString(2, productName);
                    ps.setString(3, supplier);
                    ps.setInt(4, purchasePrice);
                    ps.setInt(5, sellingPrice);
                    ps.setInt(6, quantity);
                    ps.setInt(7, total);
                    ps.executeUpdate();

/// YEH ADD KIYA HAI 
/// 
                    PreparedStatement stmtpre=con.prepareStatement("select * from product where PRODUCT_ID=?");;
                stmtpre.setInt(1,productId);
                ResultSet result=stmtpre.executeQuery();
                if(!result.next())
                {                   
                    String sql2=" INSERT INTO product VALUES(?,?,?,?,?)";
                    PreparedStatement st=con.prepareStatement(sql2);
                    st.setString(2, productName);
                    st.setInt(1, productId);
                    st.setString(3, supplier);
                    st.setInt(4, purchasePrice);
                    st.setInt(5, sellingPrice);
                    int ress=st.executeUpdate();
                    if(ress>0)
                    {
                        JOptionPane.showMessageDialog(body,"PRODUCT WAS ADDED ");
                    }
                    else{

                        JOptionPane.showMessageDialog(body,"THE PRODUCT WAS NOT ADDED");

                    }
                }
                else{
                    JOptionPane.showMessageDialog(body,"the product cannot be added in product");
                }
                // YAHA TAK
                }
            }
            JOptionPane.showMessageDialog(this, "Stock added successfully.");
            clearStockFields();
            loadStockTable();
            refreshInventoryCost();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Product ID, prices and quantity must be valid integers.");
        } catch (SQLException ex) {
            showDatabaseError("Could not add stock", ex);
        }
    }

    private void updateStock() {
        if (originalProductId == null) {
            JOptionPane.showMessageDialog(this, "Please select a product from the table first.");
            return;
        }

        try {
            String productName = nameField.getText().trim();
            int newProductId = Integer.parseInt(idField.getText().trim());
            String supplier = supplierField.getText().trim();
            int purchasePrice = Integer.parseInt(purchasePriceField.getText().trim());
            int sellingPrice = Integer.parseInt(sellingPriceField.getText().trim());
            int quantity = Integer.parseInt(quantityField.getText().trim());
            int total = purchasePrice * quantity;

            String sql = "UPDATE stock SET product_name=?, product_id=?, supplier=?, " +
                "purchase_price=?, selling_price=?, quantity=?, total=? WHERE product_id=?";

            try (Connection con = getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, productName);
                ps.setInt(2, newProductId);
                ps.setString(3, supplier);
                ps.setInt(4, purchasePrice);
                ps.setInt(5, sellingPrice);
                ps.setInt(6, quantity);
                ps.setInt(7, total);
                ps.setInt(8, Integer.parseInt(originalProductId));

                int updated = ps.executeUpdate();
                if (updated > 0) {
                    JOptionPane.showMessageDialog(this, "Stock updated successfully!");
                    clearStockFields();
                    loadStockTable();
                    refreshInventoryCost();
                } else {
                    JOptionPane.showMessageDialog(this, "No matching product was found.");
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter valid numeric values for ID, prices and quantity.");
        } catch (SQLException ex) {
            showDatabaseError("Could not update stock", ex);
        }
    }

    private void deleteStock() {
        String idText = idField.getText().trim();
        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter or select a Product ID first.");
            return;
        }

        try {
            int productId = Integer.parseInt(idText);
            try (Connection con = getConnection();
                 PreparedStatement ps = con.prepareStatement(
                     "DELETE FROM stock WHERE product_id = ? ")) {
                ps.setInt(1, productId);
                int deleted = ps.executeUpdate();

                if (deleted > 0) {
                    JOptionPane.showMessageDialog(this, "Item deleted successfully.");
                    clearStockFields();
                    loadStockTable();
                    refreshInventoryCost();
                } else {
                    JOptionPane.showMessageDialog(this, "Item not found.");
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Product ID must be an integer.");
        } catch (SQLException ex) {
            showDatabaseError("Could not delete stock", ex);
        }
    }

    private void clearStockFields() {
        nameField.setText("");
        idField.setText("");
        supplierField.setText("");
        purchasePriceField.setText("");
        sellingPriceField.setText("");
        quantityField.setText("");
        totalCostField.setText("");
        originalProductId = null;
        if (stockTable != null) {
            stockTable.clearSelection();
        }
    }

    private void loadStockTable() {
        String sql = "SELECT * FROM stock";

        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            stockModel.setRowCount(0);
            stockModel.setColumnCount(0);

            ResultSetMetaData metadata = rs.getMetaData();
            int columnCount = metadata.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                stockModel.addColumn(metadata.getColumnLabel(i));
            }

            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                stockModel.addRow(row);
            }

        } catch (SQLException ex) {
            showDatabaseError("Error loading stock", ex);
        }
    }

    private void refreshInventoryCost() {
        if (inventoryCostLabel == null) {
            return;
        }

        String sql = "SELECT COALESCE(SUM(total), 0) AS total_inventory_cost FROM stock";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                inventoryCostLabel.setText(
                    "Total Inventory Cost: ₹" + rs.getDouble("total_inventory_cost")
                );
            }
        } catch (SQLException ex) {
            showDatabaseError("Could not calculate inventory cost", ex);
        }
    }

    private String getValue(int row, String columnName) {
        for (int column = 0; column < stockModel.getColumnCount(); column++) {
            if (stockModel.getColumnName(column).equalsIgnoreCase(columnName)) {
                Object value = stockModel.getValueAt(row, column);
                return value == null ? "" : value.toString();
            }
        }
        return "";
    }

    private Connection getConnection() throws SQLException {
        if ("YOUR_MYSQL_PASSWORD".equals(DB_PASSWORD)) {
            throw new SQLException(
                "Set DB_PASSWORD in InventoryFrame.java to your local MySQL password."
            );
        }
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    private void showDatabaseError(String message, SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, message + ": " + ex.getMessage());
    }

    private void showNotImplemented(String section) {
        JOptionPane.showMessageDialog(this, section + " section is not implemented yet.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InventoryFrame::new);
    }
}











