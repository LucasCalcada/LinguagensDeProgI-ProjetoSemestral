package org.example.screens;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.example.objects.*;
import org.example.screens.prompts.*;
import org.example.database.operations.*;

public class MainScreen extends JFrame {
  Dashboard<Booking> bookingDash = new Dashboard<Booking>(Booking.class, new BookingPrompt(), new BookingOperations());
  Dashboard<Product> productDash = new Dashboard<Product>(Product.class, new ProductPrompt(), new ProductOperations());
  Dashboard<Room> roomDash = new Dashboard<Room>(Room.class, new RoomPrompt(), new RoomOperations());
  Dashboard<Sale> saleDash = new Dashboard<Sale>(Sale.class, new SalePrompt(), new SaleOperations());
  Dashboard<StorageEntry> storageDash = new Dashboard<StorageEntry>(StorageEntry.class, new StorageEntryPrompt(),
      new StorageOperations());

  public MainScreen() {
    super("Hotel Manager");

    Container panel = getContentPane();
    panel.setLayout(new BorderLayout());

    JPanel cards = new JPanel(new CardLayout());
    cards.add(roomDash, "Quartos");
    cards.add(bookingDash, "Hospedagens");
    cards.add(saleDash, "Vendas");
    cards.add(productDash, "Produtos");
    cards.add(storageDash, "Estoque");

    JComboBox<String> combo = new JComboBox<>(
        new String[] { "Quartos", "Hospedagens", "Vendas", "Produtos", "Estoque" });
    combo.addActionListener(e -> {
      CardLayout cl = (CardLayout) (cards.getLayout());
      cl.show(cards, (String) combo.getSelectedItem());
    });

    panel.add(cards, BorderLayout.CENTER);
    panel.add(combo, BorderLayout.NORTH);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setSize(500, 200);
  }
}
