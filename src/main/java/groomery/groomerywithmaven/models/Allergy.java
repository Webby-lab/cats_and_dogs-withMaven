package groomery.groomerywithmaven.models;

public enum Allergy {
    GYÓGYSZER("gyógyszer"), BŐR("bőr"), ÉLELMISZER("élelmiszer"), NÖVÉNY("növény"), TISZTÍTÓ_TERMÉKEK("tisztítók");
    private String text;

    Allergy() {
    }

    Allergy(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
