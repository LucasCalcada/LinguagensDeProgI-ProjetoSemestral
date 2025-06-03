package org.example.screens.prompts;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

import org.example.objects.Room;

public class RoomPrompt implements IPrompt<Room> {
  private final JTextField roomNameField = new JTextField();
  private final JTextField dailyRateField = new JTextField();
  private final JTextField singleBedCountField = new JTextField();
  private final JTextField doubleBedCountField = new JTextField();
  private final JTextField statusField = new JTextField();

  @Override
  public JPanel buildPrompt(Room initialData) {
    JPanel panel = new JPanel(new GridLayout(5, 2));

    if (initialData != null) {
      roomNameField.setText(initialData.getRoomName());
      dailyRateField.setText(Integer.toString(initialData.getDailyRate()));
      singleBedCountField.setText(Integer.toString(initialData.getSingleBedCount()));
      doubleBedCountField.setText(Integer.toString(initialData.getDoubleBedCount()));
      statusField.setText(initialData.getStatus().toString());
    }

    panel.add(new JLabel("Nome do quarto:"));
    panel.add(roomNameField);
    panel.add(new JLabel("Diária:"));
    panel.add(dailyRateField);
    panel.add(new JLabel("Camas de Solteiro:"));
    panel.add(singleBedCountField);
    panel.add(new JLabel("Camas de Casal:"));
    panel.add(doubleBedCountField);
    panel.add(new JLabel("Status do Quarto(FREE,OCCUPIED,MAINTENANCE):"));
    panel.add(statusField);

    return panel;
  }

  @Override
  public Room getData() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getData'");
  }

}
