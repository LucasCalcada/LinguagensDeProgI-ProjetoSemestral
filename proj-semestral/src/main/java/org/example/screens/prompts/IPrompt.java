package org.example.screens.prompts;

import javax.swing.JPanel;

import org.example.objects.DataObject;

public interface IPrompt<T extends DataObject> {
  JPanel buildPrompt(T initialData);

  public T getData();
}
