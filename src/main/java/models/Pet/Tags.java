package models.Pet;

public class Tags {

    private long id;
    private String name;

    public Tags() {
        id = (int)(Math.random()*1000);
        name = "TestTagName1";
    }

    // Getter Methods

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Setter Methods

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tags tags = (Tags) o;

        if (id != tags.id) return false;
        return name.equals(tags.name);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        return result;
    }

}
