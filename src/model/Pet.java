package model;

/**
 * @author Rodrigo Dias Soares
 */
public class Pet {
    private int id;
    private String name;
    private String breed;
    private String animalType;
    private int petOwner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public int getPetOwner() {
        return petOwner;
    }

    public void setPetOwner(int petOwner) {
        this.petOwner = petOwner;
    }
    
    
}
