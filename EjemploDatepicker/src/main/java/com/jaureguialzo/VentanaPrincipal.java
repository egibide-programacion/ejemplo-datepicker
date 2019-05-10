package com.jaureguialzo;

import com.github.lgooddatepicker.components.DateTimePicker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class VentanaPrincipal {
    private DateTimePicker dateTimePicker1;
    private JPanel panel;
    private JButton ahoraButton;
    private JButton leerButton;
    private JLabel etiqueta;

    public VentanaPrincipal() {

        ahoraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dateTimePicker1.setDateTimePermissive(LocalDateTime.now());
            }
        });

        leerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ZonedDateTime fecha = dateTimePicker1.getDateTimePermissive().atZone(ZoneId.systemDefault());
                    etiqueta.setText(fecha.format(DateTimeFormatter
                            .ofLocalizedDateTime(FormatStyle.FULL)
                            .withLocale(Locale.forLanguageTag("es-ES")
                            )));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "No has seleccionado fecha/hora.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(new VentanaPrincipal().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
