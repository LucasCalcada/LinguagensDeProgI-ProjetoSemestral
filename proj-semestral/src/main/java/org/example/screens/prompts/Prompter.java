package org.example.screens.prompts;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.example.objects.DataObject;

public class Prompter {
  public static <T extends DataObject> T promptData(IPrompt<T> prompt, T initialData) {
    JPanel panel = prompt.buildPrompt(initialData);
    int result = JOptionPane.showConfirmDialog(null, panel, "Prompt", JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.PLAIN_MESSAGE);

    if (result == JOptionPane.OK_OPTION) {
      return prompt.getData();
    }
    return null;
  }
}
