package co.za.mtn.pulsechecklist.data;

import java.io.Serializable;

public class DeviceFeature implements Serializable {
    private String name;
    private int imageReference;
    private int points;
    private Class aClass;

    public DeviceFeature(String name, int imageReference, int points, Class aClass) {
        this.name = name;
        this.imageReference = imageReference;
        this.points = points;
        this.aClass = aClass;
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }
}
