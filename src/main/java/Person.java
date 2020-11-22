public class Person {

    private String name;
    private Integer contactNumber;
    private Person secretSanta;

    public Person(String name, Integer contactNumber, Person secretSanta) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.secretSanta = secretSanta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Integer contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Person getSecretSanta() {
        return secretSanta;
    }

    public void setSecretSanta(Person secretSanta) {
        this.secretSanta = secretSanta;
    }
}
