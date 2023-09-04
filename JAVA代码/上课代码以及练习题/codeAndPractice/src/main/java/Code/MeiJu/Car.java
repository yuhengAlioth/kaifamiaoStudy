package Code.MeiJu;

public enum Car {
    FLL("法拉利","红色");
    private String name;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    Car(String name, String color) {
        this.name = name;
        this.color = color;
    }
}
