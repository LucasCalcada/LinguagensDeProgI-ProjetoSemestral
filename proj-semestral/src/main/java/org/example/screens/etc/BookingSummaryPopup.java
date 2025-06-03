package org.example.screens.etc;

import org.example.database.operations.ExtraOperations.BookingSummary;
import org.example.objects.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.temporal.ChronoUnit;

public class BookingSummaryPopup extends JDialog {

  public BookingSummaryPopup(Frame owner, BookingSummary summary) {
    super(owner, "Resumo da Hospedagem", true);
    setSize(600, 500);
    setLayout(new BorderLayout());

    Booking booking = summary.booking;

    long days = ChronoUnit.DAYS.between(
        booking.getBookingStart().toLocalDate(),
        booking.getBookingEnd().toLocalDate());

    if (days <= 0)
      days = 1;

    double totalStay = days * summary.room.getDailyRate();

    double totalSales = summary.roomSales.stream()
        .mapToInt(sale -> sale.getAmount() * sale.getPrice())
        .sum();

    double total = (totalStay + totalSales) / 100.0;

    JPanel infoPanel = new JPanel(new GridLayout(0, 1));
    infoPanel.add(new JLabel("Nome do responsável: " + booking.getBookerName()));
    infoPanel.add(new JLabel("CPF: " + booking.getBookerCpf()));
    infoPanel.add(new JLabel("Telefone: " + booking.getBookerPhone()));
    infoPanel.add(new JLabel("Clientes: " + booking.getClientCount()));
    infoPanel.add(new JLabel("Início da estadia: " + booking.getBookingStart()));
    infoPanel.add(new JLabel("Fim da estadia: " + booking.getBookingEnd()));
    infoPanel.add(new JLabel("Dias de estadia: " + days));
    infoPanel.add(new JLabel("Preço da diária: R$" + summary.room.getDailyRate() / 100.0));
    infoPanel.add(new JLabel("Total estadia: R$" + totalStay / 100.0));
    add(infoPanel, BorderLayout.NORTH);

    String[] columns = { "Produto ID", "Quantidade", "Preço Unitário", "Total" };
    DefaultTableModel model = new DefaultTableModel(columns, 0);
    for (Sale sale : summary.roomSales) {
      int saleTotal = sale.getAmount() * sale.getPrice();
      model.addRow(new Object[] {
          sale.getProductId(),
          sale.getAmount(),
          sale.getPrice() / 100.0,
          saleTotal / 100.0
      });
    }

    JTable salesTable = new JTable(model);
    JScrollPane tableScroll = new JScrollPane(salesTable);
    add(tableScroll, BorderLayout.CENTER);

    JPanel footer = new JPanel(new BorderLayout());
    JLabel totalLabel = new JLabel("Total geral (estadia + vendas): R$" + total);
    totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
    totalLabel.setHorizontalAlignment(SwingConstants.CENTER);
    footer.add(totalLabel, BorderLayout.CENTER);

    JButton closeBtn = new JButton("Fechar");
    closeBtn.addActionListener(e -> dispose());
    footer.add(closeBtn, BorderLayout.SOUTH);

    add(footer, BorderLayout.SOUTH);

    setLocationRelativeTo(owner);
    setVisible(true);
  }
}
