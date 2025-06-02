package org.example.screens.prompts;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

import org.example.objects.Product;

public class ProductPrompt implements IPrompt<Product> {
  private final JTextField nameField = new JTextField();
  private final JTextField priceField = new JTextField();
  private final JCheckBox activeCheckbox = new JCheckBox();

  @Override
  public JPanel buildPrompt(Product initialData) {
    JPanel panel = new JPanel(new GridLayout(3, 3));

    if (initialData != null) {
      nameField.setText(initialData.getProductName());

      double price = initialData.getSellPrice() / 100;
      priceField.setText(Double.toString(price));

      activeCheckbox.setSelected(initialData.isActive());
    }

    panel.add(new JLabel("Nome: "));
    panel.add(nameField);

    panel.add(new JLabel("Valor de venda: "));
    panel.add(priceField);

    panel.add(new JLabel("Ativo: "));
    panel.add(activeCheckbox);
    return panel;
  }

  @Override
  public Product getData() {
    String productName = nameField.getText();

    String priceStr = priceField.getText();
    int price = (int) Double.parseDouble(priceStr) * 100;

    boolean active = activeCheckbox.isSelected();

    return new Product(productName, price, active);
  }
}
