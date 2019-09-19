package models.Pet;

import java.util.ArrayList;
import java.util.List;

public class Pet {

    private int id;
    private String name;
    private String status;

    private ArrayList<String> photoUrls = new ArrayList<>();
    private ArrayList<Tags> tags = new ArrayList<>();

    private Category categoryObject;

    // Getter Methods
    public float getId() {
        return id;
    }

    public Category getCategory() {
        return categoryObject;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    // Setter Methods

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(Category categoryObject) {
        this.categoryObject = categoryObject;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPhotoUrls(ArrayList<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public void setTags(ArrayList<Tags> tags) {
        this.tags = tags;
    }

    public ArrayList<String> getPhotoUrls() {
        return photoUrls;
    }

    public ArrayList<Tags> getTags() {
        return tags;
    }



    public static Pet createDefaultPet() {

        ArrayList<String> urlPhoto = new ArrayList<>();
        ArrayList<Tags> tags = new ArrayList<>();

        urlPhoto.add("https://pbs.twimg.com/profile_images/429645944754159616/jzY41c_k.png");
        tags.add(new Tags(12, "TagName1"));

        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("Vincent");
        pet.setStatus("available");
        pet.setPhotoUrls(urlPhoto);
        pet.setTags(tags);

        Category category = new Category();
        category.setId(1);
        category.setName("category");

        pet.setCategory(category);

        return pet;
    }

}

