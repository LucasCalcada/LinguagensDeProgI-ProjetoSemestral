package org.example.screens.prompts;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

import org.example.objects.Sale;

public class SalePrompt implements IPrompt<Sale> {
  private final JTextField productIdField = new JTextField();
  private final JTextField amountField = new JTextField();
  private final JTextField priceField = new JTextField();
  private final JTextField bookingIdField = new JTextField();

  @Override
  public JPanel buildPrompt(Sale initialData) {
    JPanel panel = new JPanel(new GridLayout(4, 2));

    if (initialData != null) {
      productIdField.setText(Integer.toString(initialData.getProductId()));
      amountField.setText(Integer.toString(initialData.getAmount()));
      priceField.setText(Integer.toString(initialData.getPrice()));
      bookingIdField.setText(Integer.toString(initialData.getBookingId()));
    }

    panel.add(new JLabel("Id do produto:"));
    panel.add(productIdField);
    panel.add(new JLabel("Quantidade vendida:"));
    panel.add(amountField);
    panel.add(new JLabel("Valor vendido:"));
    panel.add(priceField);
    panel.add(new JLabel("Id da Reserva:"));
    panel.add(bookingIdField);

    return panel;
  }

  @Override
  public Sale getData() {
    int productId = Integer.parseInt(productIdField.getText());
    int amount = Integer.parseInt(amountField.getText());
    int price = Integer.parseInt(priceField.getText());
    int bookingId = Integer.parseInt(bookingIdField.getText());
    return new Sale(productId, amount, price, bookingId);
  }
}
