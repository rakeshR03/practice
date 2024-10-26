package design_pattern.Creational_design_pattern.BuilderPattern.Prototype;

public class Notebook {
    private Pagetype pagetype;
    private int pageCount;
    private Ruletype ruletype;
    private FrontPage frontPage;

    public FrontPage getFrontPage() {
        return frontPage;
    }

    public void setFrontPage(FrontPage frontPage) {
        this.frontPage = frontPage;
    }

    public BackPage getBackPage() {
        return backPage;
    }

    public void setBackPage(BackPage backPage) {
        this.backPage = backPage;
    }

    private BackPage backPage;

    Notebook(){}

    Notebook(Pagetype pagetype, int pageCount, Ruletype ruletype) {
        this.pagetype = pagetype;
        this.pageCount = pageCount;
        this.ruletype = ruletype;
    }

    public Notebook clone(){
        Notebook newNotebook = new Notebook();
        newNotebook.pagetype = this.pagetype;
        newNotebook.pageCount = this.pageCount;
        newNotebook.ruletype = this.ruletype;
        return newNotebook;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "pagetype=" + pagetype +
                ", pageCount=" + pageCount +
                ", ruletype=" + ruletype +
                ", frontPage=" + frontPage +
                ", backPage=" + backPage +
                '}';
    }
}
