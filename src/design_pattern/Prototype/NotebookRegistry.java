package design_pattern.Prototype;

import java.util.HashMap;
import java.util.Map;

public class NotebookRegistry {
    Map<String, Notebook> notebookMap = new HashMap<>();
    public void registerNoteBook(String name, Notebook notebook) {
        notebookMap.put(name, notebook);
    }

    public Notebook getNotebook(String name) {
        return notebookMap.get(name).clone();
    }
}
