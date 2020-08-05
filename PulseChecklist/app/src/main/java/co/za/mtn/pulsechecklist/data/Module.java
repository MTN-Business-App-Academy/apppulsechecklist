package co.za.mtn.pulsechecklist.data;

public class Module {
    private String name;
    private int imageReference;
    private String label;

    public Module(String name, int imageReference) {
        this.name = name;
        this.imageReference = imageReference;
    }

    public Module(String name, int imageReference, String label) {
        this.name = name;
        this.imageReference = imageReference;
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageReference() {
        return imageReference;
    }

    public void setImageReference(int imageReference) {
        this.imageReference = imageReference;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
