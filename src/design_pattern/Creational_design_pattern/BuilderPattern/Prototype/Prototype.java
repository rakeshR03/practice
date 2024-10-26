package design_pattern.Prototype;

import java.util.ArrayList;
import java.util.List;

public class Prototype {
    public static void main(String[] args) {
        NotebookRegistry notebookRegistry = new NotebookRegistry();
        notebookRegistry.registerNoteBook("a4_120_plane",
                new Notebook(Pagetype.A4, 120, Ruletype.PLANE));
        notebookRegistry.registerNoteBook("a4_120_rule",
                new Notebook(Pagetype.A4, 120, Ruletype.RULE));
        notebookRegistry.registerNoteBook("a3_120_plane",
                new Notebook(Pagetype.A3, 120, Ruletype.PLANE));

        List<String> list = List.of("a4_120_plane", "a4_120_rule", "a3_120_plane");

        List<Notebook> notebookList = new ArrayList<>();

        for(String name : list) {
            Notebook notebook = notebookRegistry.getNotebook(name);
            notebook.setFrontPage(new FrontPage());
            notebook.setBackPage(new BackPage());
            notebookList.add(notebook);
        }

        notebookList.stream().forEach( e -> System.out.println(e));

    }
}
