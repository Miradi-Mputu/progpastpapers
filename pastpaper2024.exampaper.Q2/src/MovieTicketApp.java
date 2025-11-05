import javax.swing.*;
import java.awt.*;
//these last two imports are for the buttons, one listens to the instruction and the other makes the action happen
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

//Must always add extends JFrame
public class MovieTicketApp extends JFrame {

    //declaring all components that will be displayed to the user
    private JComboBox<String> MovieBox;
    private JTextField TicketNumberField;
    private JTextField TicketPriceField;
    private JTextArea OutputArea;

    //declaring the buttons that will perform actions
    private JButton GenerateButton;
    private JButton SaveButton;
    private JButton ClearButton;

    //this will store the generated report temporarily
    private String currentReport = "";

    //we create an object of our MovieTickets class to use its methods

    public MovieTicketApp() {
        //this is for the format of the page
        setTitle("Movie Ticket Application");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        //this is the panel for the frame to hold all the text boxes, labels, and combo box
        JPanel InputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        InputPanel.setBorder(BorderFactory.createTitledBorder("Enter Movie Details"));

        //adding labels and input components
        InputPanel.add(new JLabel("Select Movie"));
        MovieBox = new JComboBox<>(new String[]{"Napoleon", "Oppenheimer"});
        //what ever the user landes on or selects will be put into the input of the movieBox selection
        //it is treated like the normal user input but instead of a text box it is a list option
        InputPanel.add(MovieBox);

        InputPanel.add(new JLabel("Number of Tickets"));
        TicketNumberField = new JTextField();
        InputPanel.add(TicketNumberField);

        InputPanel.add(new JLabel("Ticket Price (R)"));
        TicketPriceField = new JTextField();
        InputPanel.add(TicketPriceField);

        //creating the buttons and adding them to a separate panel
        JPanel ButtonPanel = new JPanel(new FlowLayout());
        GenerateButton = new JButton("Generate Report");
        SaveButton = new JButton("Save to File");
        ClearButton = new JButton("Clear");

        ButtonPanel.add(GenerateButton);
        ButtonPanel.add(SaveButton);
        ButtonPanel.add(ClearButton);

        //output area to display the report
        OutputArea = new JTextArea();
        OutputArea.setEditable(false);
        OutputArea.setBorder(BorderFactory.createTitledBorder("Movie Ticket Report"));
        JScrollPane scrollPane = new JScrollPane(OutputArea);

        //adding components to the frame
        add(InputPanel, BorderLayout.NORTH);
        add(ButtonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);


        //Generate Button: calculate total and display report
        GenerateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String movieName = (String) MovieBox.getSelectedItem();
                    int numberOfTickets = Integer.parseInt(TicketNumberField.getText());
                    double ticketPrice = Double.parseDouble(TicketPriceField.getText());
                    MovieTickets movieTickets = new MovieTickets(movieName, numberOfTickets, ticketPrice);

                    //call validation method from MovieTickets class
                    if (!movieTickets.validateData(movieName, numberOfTickets, ticketPrice)) {
                        JOptionPane.showMessageDialog(null, "Please enter valid data for all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    //calculate total including VAT using MovieTickets class
                    double totalPrice = movieTickets.CalculateTotalTicketPrice(numberOfTickets, ticketPrice);

                    //generate the report text
                    currentReport = "MOVIE NAME: " + movieName +
                            "\nMOVIE TICKET PRICE: R " + ticketPrice +
                            "\nNUMBER OF TICKETS: " + numberOfTickets +
                            "\nTOTAL TICKET PRICE (incl. VAT): R " + totalPrice;

                    OutputArea.setText(currentReport);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers for price and tickets.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //Save Button: write the report to a file
        SaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (currentReport.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No report to save. Please generate a report first.", "Save Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    MovieTickets movieTickets = new MovieTickets();
                    movieTickets.saveReportToFile(currentReport);

                    JOptionPane.showMessageDialog(null, "Report saved to report.txt successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error saving the file.", "File Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //Clear Button: reset all input fields and output
        ClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MovieBox.setSelectedIndex(0);
                TicketNumberField.setText("");
                TicketPriceField.setText("");
                OutputArea.setText("");
                currentReport = "";
            }
        });
    }

    //main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MovieTicketApp().setVisible(true);
        });
    }
}
