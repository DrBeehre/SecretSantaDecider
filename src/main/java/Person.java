public class Person {

    private int id;
    private String name;
    private String contactNumber;
    private Integer secretSantaId;
    private Person secretSanta;

    public Person(int id, String name, String contactNumber, Integer secretSantaId) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.secretSantaId = secretSantaId;
    }

    public void setSecretSantaId(Integer secretSantaId) {
        this.secretSantaId = secretSantaId;
    }

    public Person getSecretSanta() {
        return secretSanta;
    }

    public void setSecretSanta(Person secretSanta) {
        this.secretSanta = secretSanta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSecretSantaId() {
        return secretSantaId;
    }

    public void setSecretSantaId(int secretSantaId) {
        this.secretSantaId = secretSantaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

}
