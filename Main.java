import java.awt.*;
import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BMI Calcukator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        JPanel page1 = new JPanel();
        page1.setLayout(new  BorderLayout());
        page1.setBackground(Color.CYAN);

        JLabel welcomLabel = new JLabel("Welcome to BMI Calculatore");
        welcomLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JTextField namField = new JTextField(15);
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter your name: "));
        inputPanel.add(namField);

        JButton starButton = new JButton("Start");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(starButton);

        page1.add(welcomLabel, BorderLayout.NORTH);
        page1.add(inputPanel, BorderLayout.CENTER);
        page1.add(buttonPanel, BorderLayout.SOUTH);

        JPanel page2 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        page2.setBackground(Color.GREEN);

        JLabel heightLabel = new  JLabel("Height(m):");
        JTextField heightField = new JTextField(10);
        JLabel weightLabel = new  JLabel("weight(kg):");
        JTextField weightField = new JTextField(10);

        JLabel genderLabel = new JLabel("Gender: ");
        String[] genders = {"Male", "Female"};
        JComboBox<String> genderCombo = new  JComboBox<>(genders);

        JButton calculateButton = new JButton("Calculate BMI");
        JLabel statusLabel = new JLabel("");
        statusLabel.setForeground(Color.RED);

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0; gbc.gridy =0; page2.add(heightLabel, gbc);
        gbc.gridx = 1; gbc.gridy =0; page2.add(heightField, gbc);
        gbc.gridx = 0; gbc.gridy =1; page2.add(weightLabel, gbc);
        gbc.gridx = 1; gbc.gridy =1; page2.add(weightField, gbc);
        gbc.gridx = 0; gbc.gridy =2; page2.add(genderLabel, gbc);
        gbc.gridx = 1; gbc.gridy =2; page2.add(genderCombo, gbc);
        gbc.gridx = 0; gbc.gridy =3; gbc.gridwidth = 2; page2.add(calculateButton, gbc);
        gbc.gridx = 0; gbc.gridy =4; page2.add(statusLabel, gbc);

        mainPanel.add(page1, "page1");
        mainPanel.add(page2, "page2");

        frame.add(mainPanel);
        frame.setVisible(true);

        starButton.addActionListener(e -> {
            if(namField.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(frame, "enter your name");  }
            else{
                cardLayout.show(mainPanel, "page2");
            }    
        
        });
        calculateButton.addActionListener(e -> {
            try{
                double height = Double.parseDouble(heightField.getText().trim());
                double weight = Double.parseDouble(weightField.getText().trim());
                String gender = (String) genderCombo.getSelectedItem();
                double bmi = BMILogic.calculateBMI(height, weight);
                String status = BMILogic.getStatuse(bmi, gender);

                

                statusLabel.setText(namField.getText() + ", your BMI is " 
                + String.format("%.2f", bmi) + " ( " +status + ")");
                statusLabel.setForeground(Color.BLUE);}
                catch (NumberFormatException ex ){
                    statusLabel.setText("enter valid height and weight");
                    statusLabel.setForeground(Color.RED);
                }


            });
        }
    }

