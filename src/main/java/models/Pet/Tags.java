package models.Pet;

public class Tags {

    private int id;
    private String name;

    public Tags(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter Methods

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Setter Methods

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
