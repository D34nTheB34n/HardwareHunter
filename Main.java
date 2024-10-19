import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        new Website();
    }
}

class Website extends JFrame implements ActionListener {
    JToggleButton jCPU_Button, jGPU_Button, jMotherboard_Button,
            jRAM_Button, jPSU_Button, jCooling_Button,
            jHDD_Button, jSSD_Button, jPCCase_Button;

    JTextField jCPU_Check_Text, jGPU_Check_Text, jMotherboard_Check_Text,
            jRAM_Check_Text, jPSU_Check_Text, jCooling_Check_Text,
            jHDD_Check_Text, jSSD_Check_Text, jPCCase_Check_Text;


    public Website() {
        this.setVisible(true);
        this.setTitle("Hardware Hunter");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1920, 1080);
        this.setResizable(true);

        jCPU_Button = new JToggleButton("CPU");
        jGPU_Button = new JToggleButton("GPU");
        jMotherboard_Button = new JToggleButton("Motherboard");
        jRAM_Button = new JToggleButton("RAM");
        jPSU_Button = new JToggleButton("PSU");
        jCooling_Button = new JToggleButton("Cooling");
        jHDD_Button = new JToggleButton("HDD");
        jSSD_Button = new JToggleButton("SSD");
        jPCCase_Button = new JToggleButton("PC Case");

        JToggleButton[] buttons = new JToggleButton[]{jCPU_Button, jGPU_Button, jMotherboard_Button,
                jRAM_Button, jPSU_Button, jCooling_Button,
                jHDD_Button, jSSD_Button, jPCCase_Button};

        for (JToggleButton button : buttons) {
            button.addActionListener(this);
        }

        jCPU_Check_Text = new JTextField("CPU ✓");
        jGPU_Check_Text = new JTextField("GPU ✓");
        jMotherboard_Check_Text = new JTextField("Motherboard ✓");
        jRAM_Check_Text = new JTextField("RAM ✓");
        jPSU_Check_Text = new JTextField("PSU ✓");
        jCooling_Check_Text = new JTextField("Cooling ✓");
        jHDD_Check_Text = new JTextField("HDD ✓");
        jSSD_Check_Text = new JTextField("SSD ✓");
        jPCCase_Check_Text = new JTextField("PC Case ✓");

        //Adding all TextFields to an ArrayList in order to efficiently set properties to text fields as needed.
        List<JTextField> CheckFields = new ArrayList<>(Arrays.asList(
                jCPU_Check_Text, jGPU_Check_Text, jMotherboard_Check_Text,
                jRAM_Check_Text, jPSU_Check_Text, jCooling_Check_Text,
                jHDD_Check_Text, jSSD_Check_Text, jPCCase_Check_Text
        ));

        for (JTextField field : CheckFields) {
            field.setVisible(false);
            field.setEditable(false);
            field.setColumns(10);
        }

        GridLayout grid = new GridLayout(0,1);

        JPanel topPanel = new JPanel();
        JPanel leftPanel = new JPanel(grid);

        for (JToggleButton button : buttons) {
            topPanel.add(button);
        }

        for (JTextField field : CheckFields) {
            leftPanel.add(field);
        }

        add(topPanel, BorderLayout.NORTH);
        add(leftPanel, BorderLayout.WEST);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jCPU_Button) {
            if (jCPU_Button.isSelected()){
                jCPU_Button.setForeground(Color.BLUE);
            } else {
                jCPU_Button.setForeground(Color.BLACK);
            }
            jCPU_Check_Text.setVisible(jCPU_Button.isSelected());
            System.out.println("CPU toggled: " + jCPU_Button.isSelected());
        }
        else if (e.getSource() == jGPU_Button) {
            if (jGPU_Button.isSelected()){
                jGPU_Button.setForeground(Color.BLUE);
            } else {
                jGPU_Button.setForeground(Color.BLACK);
            }
            jGPU_Check_Text.setVisible(jGPU_Button.isSelected());
            System.out.println("GPU toggled: " + jGPU_Button.isSelected());
        }
        else if (e.getSource() == jMotherboard_Button) {
            if (jMotherboard_Button.isSelected()){
                jMotherboard_Button.setForeground(Color.BLUE);
            } else {
                jMotherboard_Button.setForeground(Color.BLACK);
            }
            jMotherboard_Check_Text.setVisible(jMotherboard_Button.isSelected());
            System.out.println("Motherboard toggled: " + jMotherboard_Button.isSelected());
        }
        else if (e.getSource() == jRAM_Button) {
            if (jRAM_Button.isSelected()){
                jRAM_Button.setForeground(Color.BLUE);
            } else {
                jRAM_Button.setForeground(Color.BLACK);
            }
            jRAM_Check_Text.setVisible(jRAM_Button.isSelected());
            System.out.println("RAM toggled: " + jRAM_Button.isSelected());
        }
        else if (e.getSource() == jPSU_Button) {
            if (jPSU_Button.isSelected()){
                jPSU_Button.setForeground(Color.BLUE);
            } else {
                jPSU_Button.setForeground(Color.BLACK);
            }
            jPSU_Check_Text.setVisible(jPSU_Button.isSelected());
            System.out.println("PSU toggled: " + jPSU_Button.isSelected());
        }
        else if (e.getSource() == jCooling_Button) {
            if (jCooling_Button.isSelected()){
                jCooling_Button.setForeground(Color.BLUE);
            } else {
                jCooling_Button.setForeground(Color.BLACK);
            }            jCooling_Check_Text.setVisible(jCooling_Button.isSelected());
            System.out.println("Cooling toggled: " + jCooling_Button.isSelected());
        }
        else if (e.getSource() == jHDD_Button) {
            if (jHDD_Button.isSelected()){
                jHDD_Button.setForeground(Color.BLUE);
            } else {
                jHDD_Button.setForeground(Color.BLACK);
            }            jHDD_Check_Text.setVisible(jHDD_Button.isSelected());
            System.out.println("HDD toggled: " + jHDD_Button.isSelected());
        }
        else if (e.getSource() == jSSD_Button) {
            if (jSSD_Button.isSelected()){
                jSSD_Button.setForeground(Color.BLUE);
            } else {
                jSSD_Button.setForeground(Color.BLACK);
            }            jSSD_Check_Text.setVisible(jSSD_Button.isSelected());
            System.out.println("SSD toggled: " + jSSD_Button.isSelected());
        }
        else if (e.getSource() == jPCCase_Button) {
            if (jPCCase_Button.isSelected()){
                jPCCase_Button.setForeground(Color.BLUE);
            } else {
                jPCCase_Button.setForeground(Color.BLACK);
            }            jPCCase_Check_Text.setVisible(jPCCase_Button.isSelected());
            System.out.println("PC Case toggled: " + jPCCase_Button.isSelected());
        }
        else {
            System.out.println("Invalid Button");
        }

        revalidate();
        repaint();
    }
}

