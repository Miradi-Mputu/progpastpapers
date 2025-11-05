import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

//Must always add extends JFrame
public class EstateAgentReportApp extends JFrame {

    //Declaring all components that will be displayed to the user
    private JComboBox<String> LocationBox;
    private JTextField AgentNameField;
    private JTextField PropertyPriceField;
    private JTextField CommissionField;
    private JTextArea ReportArea;

    //Menu items
    private JMenuItem ExitItem;
    private JMenuItem ProcessItem;
    private JMenuItem ClearItem;
    private JMenuItem SaveItem;
    private JMenuItem ReadItem;

    public EstateAgentReportApp() {

        //This is for the format of the page
        setTitle("Estate Agent Report");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        //Panel to hold all input components
        JPanel InputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        InputPanel.setBorder(BorderFactory.createTitledBorder("Enter Estate Agent Details"));

        //Adding labels and text fields
        InputPanel.add(new JLabel("AGENT LOCATION:"));
        LocationBox = new JComboBox<>(new String[]{"", "Cape Town", "Durban", "Pretoria"});
        InputPanel.add(LocationBox);

        InputPanel.add(new JLabel("ESTATE AGENT NAME:"));
        AgentNameField = new JTextField();
        InputPanel.add(AgentNameField);

        InputPanel.add(new JLabel("PROPERTY PRICE:"));
        PropertyPriceField = new JTextField();
        InputPanel.add(PropertyPriceField);

        InputPanel.add(new JLabel("COMMISSION PERCENTAGE:"));
        CommissionField = new JTextField();
        InputPanel.add(CommissionField);

        //Text area to display report
        ReportArea = new JTextArea();
        ReportArea.setEditable(false);
        ReportArea.setBorder(BorderFactory.createTitledBorder("ESTATE AGENT REPORT"));
        JScrollPane scrollPane = new JScrollPane(ReportArea);

        //Creating menu bar
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        ExitItem = new JMenuItem("Exit");
        fileMenu.add(ExitItem);

        JMenu toolsMenu = new JMenu("Tools");
        ProcessItem = new JMenuItem("Process Report");
        ClearItem = new JMenuItem("Clear");
        SaveItem = new JMenuItem("Save Report");
        ReadItem = new JMenuItem("Read Report");
        toolsMenu.add(ProcessItem);
        toolsMenu.add(ClearItem);
        toolsMenu.add(SaveItem);
        toolsMenu.add(ReadItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        //Adding components to frame
        add(InputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        //Action listeners for menu items
        ExitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        ProcessItem.addActionListener(new ActionListener() {
            //Here the report is being formated 
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String location = (String) LocationBox.getSelectedItem();
                    String agentName = AgentNameField.getText();
                    String propertyPriceText = PropertyPriceField.getText();
                    String commissionText = CommissionField.getText();

                    EstateAgent agent = new EstateAgent(location, agentName, propertyPriceText, commissionText);

                    if (agent.ValidateData()) {
                        double commission = agent.CalculateCommission();
                        String report = "AGENT LOCATION: " + location +
                                "\nAGENT NAME: " + agentName +
                                "\nPROPERTY PRICE: R " + propertyPriceText +
                                "\nCOMMISSION PERCENTAGE: " + commissionText + "%" +
                                "\nCALCULATED COMMISSION: R " + commission;
                        ReportArea.setText(report);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please fill in all fields correctly!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error processing report!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        SaveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //here we have called the file writer and everything will be writen to a file
                try {
                    FileWriter writer = new FileWriter("report.txt");
                    writer.write("ESTATE AGENT REPORT\n*******************************\n" + ReportArea.getText());
                    writer.close();
                    JOptionPane.showMessageDialog(null, "Report successfully saved to report.txt", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error saving file!", "File Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        ReadItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //here it is taking what ever data was placed into the file or is in the file and displays it in the GUI
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("report.txt"));
                    ReportArea.read(reader, null);
                    reader.close();
                    JOptionPane.showMessageDialog(null, "Report successfully loaded from report.txt", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error reading file!", "File Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        ClearItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocationBox.setSelectedIndex(0);
                AgentNameField.setText("");
                PropertyPriceField.setText("");
                CommissionField.setText("");
                ReportArea.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EstateAgentReportApp().setVisible(true);
        });
    }
}