package org.example.screens.prompts;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.example.objects.StorageEntry;
import org.example.objects.StorageEntry.EntryType;

import java.awt.GridLayout;

public class StorageEntryPrompt implements IPrompt<StorageEntry> {
  private final JTextField productIdField = new JTextField();
  private final JTextField entryTypeField = new JTextField();
  private final JTextField amountField = new JTextField();

  @Override
  public JPanel buildPrompt(StorageEntry initialData) {
    JPanel panel = new JPanel(new GridLayout(3, 2));

    if (initialData != null) {
      productIdField.setText(Integer.toString(initialData.getProductId()));
      entryTypeField.setText(initialData.getEntryType().toString());
      amountField.setText(Integer.toString(initialData.getAmount()));
    }

    panel.add(new JLabel("Id do produto:"));
    panel.add(productIdField);
    panel.add(new JLabel("Quantidade:"));
    panel.add(amountField);
    panel.add(new JLabel("Operação (IN/OUT):"));
    panel.add(entryTypeField);

    return panel;
  }

  @Override
  public StorageEntry getData() {
    EntryType type = EntryType.valueOf(entryTypeField.getText());
    int id = Integer.parseInt(productIdField.getText());
    int amount = Integer.parseInt(amountField.getText());
    return new StorageEntry(id, type, amount);
  }
}
