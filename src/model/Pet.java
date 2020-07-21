package model;

/**
 * @author Rodrigo Dias Soares
 */
public class Pet {
    
    private String name;
    private String breed;
    private String animalType;
    private Client petOwner;

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

    public Client getPetOwner() {
        return petOwner;
    }

    public void setPetOwner(Client petOwner) {
        this.petOwner = petOwner;
    }
    
    
}
