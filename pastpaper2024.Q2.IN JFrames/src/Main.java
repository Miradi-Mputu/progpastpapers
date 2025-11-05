import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JFrame {
    private JTextField VehicleTypeField;
    private JTextField CityField;
    private JTextField AccidentTotalField;
    private JTextArea OutPutArea;

    private JButton SaveButton;
    private JButton ReadButton;
    private JButton ReportButton;

    public Main() {
        setTitle("Accident Report Application");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));

        JPanel InputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        InputPanel.setBorder(BorderFactory.createTitledBorder("Enter road accident Details"));

        InputPanel.add(new JLabel("VehicleType"));
        VehicleTypeField = new JTextField();
        InputPanel.add(VehicleTypeField);

        InputPanel.add(new JLabel("City"));
        CityField = new JTextField();
        InputPanel.add(CityField);

        InputPanel.add(new JLabel("AccidentTotal"));
        AccidentTotalField = new JTextField();
        InputPanel.add(AccidentTotalField);


    JPanel ButtonPanel = new JPanel(new FlowLayout());
    ReportButton = new JButton("Generate report");
    SaveButton = new JButton("Save to file");
    ReadButton = new JButton("Read from file");

      ButtonPanel.add(ReportButton);
      ButtonPanel.add(SaveButton);
      ButtonPanel.add(ReadButton);

    OutPutArea = new JTextArea();
      OutPutArea.setEditable(false);
      OutPutArea.setBorder(BorderFactory.createTitledBorder("Output"));
    JScrollPane scrollPane = new JScrollPane(OutPutArea);

    add(InputPanel, BorderLayout.NORTH);
    add(ButtonPanel, BorderLayout.CENTER);
    add(OutPutArea, BorderLayout.SOUTH);

        ReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String VehicleType = VehicleTypeField.getText();
                    String City = CityField.getText();
                    int AccidentTotal = Integer.parseInt(AccidentTotalField.getText());

                    RoadAccidentReport roadAccidentReport = new RoadAccidentReport(VehicleType, City, AccidentTotal);
                    OutPutArea.setText(roadAccidentReport.printAccidentReport());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "PLease enter a valid number for runs.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        SaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String VehicleType = VehicleTypeField.getText();
                    String City = CityField.getText();
                    int AccidentTotal = Integer.parseInt(AccidentTotalField.getText());

                    RoadAccidentReport roadAccidentReport = new RoadAccidentReport(VehicleType, City, AccidentTotal);
                    roadAccidentReport.savetothefile();
                    JOptionPane.showMessageDialog(null, "Data successfully saved to ");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "PLease enter a valid number for runs.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        ReadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String VehicleType = VehicleTypeField.getText();
                    String City = CityField.getText();
                    int AccidentTotal = Integer.parseInt(AccidentTotalField.getText());

                    RoadAccidentReport roadAccidentReport = new RoadAccidentReport(VehicleType, City, AccidentTotal);
                    roadAccidentReport.readfromfile();
                    JOptionPane.showMessageDialog(null, "Data successfully saved to ");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "PLease enter a valid number for runs.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->{
            new Main().setVisible(true);
        });
    }
}
