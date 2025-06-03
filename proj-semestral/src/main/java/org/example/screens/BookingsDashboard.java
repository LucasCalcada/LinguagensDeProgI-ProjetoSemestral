package org.example.screens;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.example.database.operations.BookingOperations;
import org.example.database.operations.ExtraOperations;
import org.example.database.operations.ExtraOperations.BookingSummary;
import org.example.objects.Booking;
import org.example.screens.etc.BookingSummaryPopup;
import org.example.screens.prompts.BookingPrompt;

public class BookingsDashboard extends Dashboard<Booking> {
  private ExtraOperations extraOps = new ExtraOperations();

  public BookingsDashboard() {
    super(Booking.class, new BookingPrompt(), new BookingOperations());
  }

  @Override
  protected JPanel buttonPanel() {
    JPanel buttons = super.buttonPanel();

    JButton summaryBtn = new JButton("Resumo hospedagem");
    summaryBtn.addActionListener(e -> bookingSummary());
    buttons.add(summaryBtn);

    return buttons;
  }

  private void bookingSummary() {
    int id = promptId();
    BookingSummary summary = extraOps.getBookingSummary(id);
    new BookingSummaryPopup(null, summary);
  }
}
