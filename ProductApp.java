/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.datalogger;

/**
 *
 * @author leeto
 */
import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class ProductApp extends JFrame {
    

    private static final String[] PRODUCTS = {
        "Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"
    };

    
    private final JTextField txtCustomerName = new JTextField();
    private final JComboBox<String> cmbProduct = new JComboBox<>(PRODUCTS);
    private final JTextField txtPrice = new JTextField();

    
    public ProductApp() {
        super("Product App");
        buildMenu();
        buildForm();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(480, 300);
        setLocationRelativeTo(null);
    }
    

    //  File and exit tool
    private void buildMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        processItem.addActionListener(e -> processSale()); // same logic as the button
        JMenuItem clearItem = new JMenuItem("Clear");
        clearItem.addActionListener(e -> clearForm());
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);
    }

    
    //Text boxes
    private void buildForm() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 20));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JButton btnProcess = new JButton("PROCESS");
        btnProcess.addActionListener(e -> processSale());

        panel.add(new JLabel("Customer Name:"));
        panel.add(txtCustomerName);
        panel.add(new JLabel("Select Product:"));
        panel.add(cmbProduct);
        panel.add(new JLabel("Enter Price:"));
        panel.add(txtPrice);
        panel.add(new JLabel(""));
        panel.add(btnProcess);

        add(panel);
    }

    // Calculate, displaying and saving the menu
    private void processSale() {
        String customerName = txtCustomerName.getText().trim();
        String product = (String) cmbProduct.getSelectedItem();

        if (customerName.isEmpty()) {
            showError("Please enter the customer name.");
            return;
        }

        double price;
        try {
            price = Double.parseDouble(txtPrice.getText().trim());
        } catch (NumberFormatException ex) {
            showError("Please enter a valid numeric price.");
            return;
        }
        if (price <= 0) {
            showError("The price must be greater than zero.");
            return;
        }

        IProductCalculations calculate = new ProductCalculations(price);
        String summary = "Customer Name: " + customerName
                + "\nProduct: " + product
                + "\nVAT: R " + calculate.GetVat()
                + "\nCOMMISSION: R " + calculate.GetCommission()
                + "\nTOTAL: R " + calculate.GetTotal();

        JOptionPane.showMessageDialog(this, summary);

        try {
            DataLogger.main(summary);
        } catch (IOException ex) {
            showError("Could not save to data.txt: " + ex.getMessage());
        }
    }

    // Clear menu: empty the text boxes and reset the combo box to index 0
    private void clearForm() {
        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductApp().setVisible(true));
    }
}

