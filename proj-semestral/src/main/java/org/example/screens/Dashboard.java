package org.example.screens;

import org.example.database.entities.DbEntity;
import org.example.database.operations.Operation;
import org.example.objects.DataObject;
import org.example.screens.table.TableView;
import org.example.screens.prompts.*;

import javax.swing.*;
import java.awt.*;

public class Dashboard<T extends DataObject> extends JPanel {
  private JTable table;
  private JScrollPane scrollPane;

  private DbEntity<T>[] data;
  private Class<T> c;

  protected final IPrompt<T> prompt;
  protected final Operation<T> operation;

  public Dashboard(Class<T> c, IPrompt<T> prompt, Operation<T> op) {
    this.c = c;
    this.prompt = prompt;
    this.operation = op;

    setLayout(new BorderLayout());

    this.data = operation.list();

    table = TableView.buildTable(c, data);
    scrollPane = new JScrollPane(table);
    add(scrollPane, BorderLayout.CENTER);

    add(buttonPanel(), BorderLayout.SOUTH);
  }

  protected JPanel buttonPanel() {
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JButton createBtn = new JButton("Criar");
    JButton updateBtn = new JButton("Atualizar");
    JButton deleteBtn = new JButton("Deletar");

    createBtn.addActionListener(e -> create());
    updateBtn.addActionListener(e -> update());
    deleteBtn.addActionListener(e -> delete());

    buttonPanel.add(createBtn);
    buttonPanel.add(updateBtn);
    buttonPanel.add(deleteBtn);

    return buttonPanel;
  }

  private void reloadTable() {
    this.data = operation.list();
    JTable newTable = TableView.buildTable(c, this.data);
    remove(scrollPane);
    table = newTable;
    scrollPane = new JScrollPane(table);
    add(scrollPane, BorderLayout.CENTER);
    revalidate();
    repaint();
  }

  private int promptId() {
    String input = JOptionPane.showInputDialog(null, "Digite o id:");
    return Integer.parseInt(input);
  }

  protected void create() {
    T data = Prompter.promptData(prompt, null);
    if (data == null)
      return;
    operation.create(data);
    reloadTable();
  }

  protected void update() {
    int id = promptId();
    DbEntity<T> initialData = operation.read(id);
    T newData = Prompter.promptData(prompt, initialData.getData());
    operation.update(id, newData);
    reloadTable();
  }

  protected void delete() {
    int id = promptId();
    operation.delete(id);
    reloadTable();
  }
}
