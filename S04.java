import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public static class S04 {
}

 void main(String[] args) {

    JFrame frame = new JFrame("S04: Modelo Vista Controlador (MVC) - Parte 01");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 400);

    JTabbedPane tabbedPane = new JTabbedPane();
    frame.getContentPane().add(tabbedPane);
    tabbedPane.setFocusable(false);

    JPanel newEvent = new JPanel(new GridLayout(10, 2));
    tabbedPane.add("Nuevo evento", newEvent);

    JLabel eventLabel = new JLabel("Descripción del evento");
    JTextField eventField = new JTextField(20);
    JLabel emailLabel = new JLabel("Reenviar correo electrónico");
    JTextField emailField = new JTextField(20);
    JLabel date = new JLabel("Fecha");
    JTextField dateField = new JTextField(20);
    JLabel freqLabel = new JLabel ("Frecuencia");
    JRadioButton daily = new JRadioButton("Diario");
    JRadioButton weekly = new JRadioButton("Semanalmente");
    JRadioButton monthly = new JRadioButton("Mensualmente");
    ButtonGroup freqGroup = new ButtonGroup();
    freqGroup.add(daily);
    freqGroup.add(weekly);
    freqGroup.add(monthly);
    JCheckBox alarmBox = new JCheckBox("Alarma");
    JButton saveButton = new JButton("Guardar");
    JButton clearButton = new JButton("Borrar");

    newEvent.add(eventLabel);
    newEvent.add(eventField);
    newEvent.add(emailLabel);
    newEvent.add(emailField);
    newEvent.add(date);
    newEvent.add(dateField);
    newEvent.add(freqLabel);
    newEvent.add(daily);
    newEvent.add(weekly);
    newEvent.add(monthly);
    newEvent.add(alarmBox);
    newEvent.add(saveButton);
    newEvent.add(clearButton);

    JPanel tableEvents = new JPanel();
    tabbedPane.add("Eventos", tableEvents);

    DefaultTableModel tableEventsModel = new DefaultTableModel();
    tableEventsModel.addColumn("Fecha");
    tableEventsModel.addColumn("Descripción");
    tableEventsModel.addColumn("Frecuencia");
    tableEventsModel.addColumn("E-mail");
    tableEventsModel.addColumn("Alarma");
    JTable eventsTable = new JTable(tableEventsModel);
    JScrollPane scrollPane = new JScrollPane(eventsTable);
    tableEvents.add(scrollPane);

    saveButton.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {

          String descripcion = eventField.getText();
          String fecha = dateField.getText();
          String frecuencia = "";
          if (daily.isSelected()) {
             frecuencia = "Diario";
          } else if (weekly.isSelected()) {
             frecuencia = "Semanalmente";
          } else if (monthly.isSelected()) {
             frecuencia = "Mensualmente";
          }
          String email = emailField.getText();
          String alarma = alarmBox.isSelected() ? "Sí" : "No";

          tableEventsModel.addRow(new Object[]{fecha, descripcion, frecuencia, email, alarma});

       }
    });

    frame.setVisible(true);
 }


