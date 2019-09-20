package models.Pet;

import java.util.ArrayList;

public class Pet {

    private long id;
    private String name;
    private String status;

    private ArrayList<String> photoUrls = new ArrayList<>();
    private ArrayList<Tags> tags = new ArrayList<>();

    private Category categoryObject;

    // Getter Methods
    public long getId() {
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

    public void setId(long id) {
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
        tags.add(new Tags());

        Pet pet = new Pet();
        pet.setId((int)(Math.random()*1000));
        pet.setName("Vincent");
        pet.setStatus("available");
        pet.setPhotoUrls(urlPhoto);
        pet.setTags(tags);

        Category category = new Category();
        category.setId((int)(Math.random()*1000));
        category.setName("category");

        pet.setCategory(category);

        return pet;
    }

}

