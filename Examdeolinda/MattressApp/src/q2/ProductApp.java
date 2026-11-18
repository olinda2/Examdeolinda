package q2;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductApp extends JFrame {
    private final JTextField txtName = new JTextField(20);
    private final JComboBox<String> cboProduct = new JComboBox<>(new String[]{
            "Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"});
    private final JTextField txtPrice = new JTextField(20);
    private final JButton btnProcess = new JButton("PROCESS");

    public ProductApp() {
        super("Product App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 8, 8));

        // Menu: File > Exit ; Tools > Process, Clear
        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        file.add(exit);
        JMenu tools = new JMenu("Tools");
        JMenuItem process = new JMenuItem("Process");
        JMenuItem clear = new JMenuItem("Clear");
        tools.add(process);
        tools.add(clear);
        bar.add(file);
        bar.add(tools);
        setJMenuBar(bar);

        add(new JLabel("Customer Name:")); add(txtName);
        add(new JLabel("Select Product:")); add(cboProduct);
        add(new JLabel("Enter Price:"));    add(txtPrice);
        add(new JLabel());                  add(btnProcess);

        btnProcess.addActionListener(e -> processSale());
        process.addActionListener(e -> processSale());   // same logic as button
        clear.addActionListener(e -> {
            txtName.setText("");
            txtPrice.setText("");
            cboProduct.setSelectedIndex(0);
        });
        exit.addActionListener(e -> System.exit(0));

        setSize(450, 250);
        setLocationRelativeTo(null);
    }

    private void processSale() {
        String name = txtName.getText().trim();
        String product = (String) cboProduct.getSelectedItem();
        double price;
        try {
            price = Double.parseDouble(txtPrice.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the customer name.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        IProductCalculations calc = new ProductCalculations(price);
        double vat = calc.GetVat(), commission = calc.GetCommission(), total = calc.GetTotal();

        JOptionPane.showMessageDialog(this,
                "Customer Name: " + name + "\n"
                + "Product: " + product + "\n"
                + "VAT: R " + vat + "\n"
                + "COMMISSION: R " + commission + "\n"
                + "TOTAL: R " + total,
                "Message", JOptionPane.INFORMATION_MESSAGE);

        try (PrintWriter out = new PrintWriter(new FileWriter("data.txt", true))) {
            out.println("DATA LOG");
            out.println("*".repeat(40));
            out.println("Customer Name: " + name);
            out.println("Product: " + product);
            out.println("VAT: R " + vat);
            out.println("COMMISSION: R " + commission);
            out.println("TOTAL: R " + total);
            out.println("*".repeat(40));
            out.println();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not write to data.txt",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductApp().setVisible(true));
    }
}
