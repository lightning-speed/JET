package jet.app.ui;

import jet.app.internal.Core;
import jet.app.util.FileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppView extends JPanel {
    public static JTextArea log_area = new JTextArea();
    public AppView(){
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        JPanel topP = new JPanel();
        topP.setBounds(0,0,450,70);
        topP.setLayout(null);
        add(topP);

        JLabel top = new JLabel(" JET - Bat to Exe");
        top.setFont(FontManger.getFont("fonts/Roboto/Roboto-Regular.ttf",24));
        top.setBounds(0,0,450,70);
        topP.add(top);
        repaint();

        JLabel bat_label = new JLabel("Batch File: ");
        bat_label.setBounds(10,100,120,20);
        add(bat_label);

        JTextField bat_field = new JTextField("");
        bat_field.setBounds(80,98,340,25);
        add(bat_field);

        JLabel output_label = new JLabel("Output File: ");
        output_label.setBounds(10,140,120,20);
        add(output_label);

        JTextField output_field = new JTextField("");
        output_field.setBounds(80,138,340,25);
        add(output_field);

        JLabel icon_label = new JLabel("Icon File: ");
        icon_label.setBounds(10,180,120,20);
        add(icon_label);

        JTextField icon_field = new JTextField("");
        icon_field.setBounds(80,178,340,25);
        add(icon_field);

        JButton build_btn = new JButton("Build");
        build_btn.setBounds(10,218,70,25);
        build_btn.setBackground(new Color(235,235,235));
        build_btn.setBackground(new Color(100,200,100));
        build_btn.setForeground(Color.WHITE);
        add(build_btn);

        log_area.setBorder(BorderFactory.createLineBorder(new Color(110,100,200),3));
        log_area.setBackground(new Color(235,235,235));
        log_area.setBounds(10,258,410,100);
        add(log_area);

        build_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Core.setConfig(bat_field.getText(),output_field.getText(),icon_field.getText());
                Core.Build();
            }
        });
        String config = FileManager.read("data/user_data");
        try {
            bat_field.setText(config.split("\n")[0]);
            output_field.setText(config.split("\n")[1]);
            icon_field.setText(config.split("\n")[2]);
        }
        catch (Exception e){}
    }
}
