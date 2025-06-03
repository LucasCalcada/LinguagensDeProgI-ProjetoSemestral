package org.example.screens.prompts;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.sql.Date;
import java.time.LocalDate;

import org.example.objects.Booking;

public class BookingPrompt implements IPrompt<Booking> {
  private final JTextField roomIdField = new JTextField();
  private final JTextField bookerNameField = new JTextField();
  private final JTextField bookerCpfField = new JTextField();
  private final JTextField bookerPhoneField = new JTextField();
  private final JTextField clientCountField = new JTextField();
  private final JTextField bookingStartField = new JTextField();
  private final JTextField bookingEndField = new JTextField();

  @Override
  public JPanel buildPrompt(Booking initialData) {
    JPanel panel = new JPanel(new GridLayout(7, 2));

    if (initialData != null) {
      roomIdField.setText(Integer.toString(initialData.getRoom()));
      bookerNameField.setText(initialData.getBookerName());
      bookerCpfField.setText(initialData.getBookerCpf());
      bookerPhoneField.setText(initialData.getBookerPhone());
      clientCountField.setText(Integer.toString(initialData.getClientCount()));
      bookingStartField.setText(initialData.getBookingStart().toString());
      bookingEndField.setText(initialData.getBookingEnd().toString());
    }

    panel.add(new JLabel("Id do quarto:"));
    panel.add(roomIdField);
    panel.add(new JLabel("Nome:"));
    panel.add(bookerNameField);
    panel.add(new JLabel("CPF:"));
    panel.add(bookerCpfField);
    panel.add(new JLabel("Telefone:"));
    panel.add(bookerPhoneField);
    panel.add(new JLabel("Quantidade de Pessoas:"));
    panel.add(clientCountField);
    panel.add(new JLabel("Data de entrada:"));
    panel.add(bookingStartField);
    panel.add(new JLabel("Data de saída:"));
    panel.add(bookingEndField);

    return panel;
  }

  @Override
  public Booking getData() {
    Booking booking = new Booking();

    int roomId = Integer.parseInt(roomIdField.getText());
    String bookerName = bookerNameField.getText();
    String bookerCpf = bookerCpfField.getText();
    String bookerPhone = bookerPhoneField.getText();
    int clientCount = Integer.parseInt(clientCountField.getText());

    booking.setRoom(roomId);
    booking.setBookerName(bookerName);
    booking.setBookerCpf(bookerCpf);
    booking.setBookerPhone(bookerPhone);
    booking.setClientCount(clientCount);
    Date startDate = Date.valueOf(LocalDate.parse(bookingStartField.getText()));
    booking.setBookingStart(startDate);
    Date endDate = Date.valueOf(LocalDate.parse(bookingEndField.getText()));
    booking.setBookingEnd(endDate);

    return booking;
  }
}
