public class Person {

    private int id;
    private String name;
    private String contactNumber;
    private Integer secretSantaId;
    private Person secretSanta;
    private String email;
    private Boolean exclude;
    private String preAssignedSS;
    private Integer preAssignedSSID;

    public Person(int id, String name, String contactNumber, String email, Boolean exclude, String preAssignedSS) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.exclude = exclude;
        this.preAssignedSS = preAssignedSS;
        this.preAssignedSSID = null;
    }

    public Integer getPreAssignedSSID() {
        return preAssignedSSID;
    }

    public void setPreAssignedSSID(Integer preAssignedSSID) {
        this.preAssignedSSID = preAssignedSSID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getExclude() {
        return exclude;
    }

    public void setExclude(Boolean exclude) {
        this.exclude = exclude;
    }

    public String getPreAssignedSS() {
        return preAssignedSS;
    }

    public void setPreAssignedSS(String preAssignedSS) {
        this.preAssignedSS = preAssignedSS;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", secretSantaId=" + secretSantaId +
                ", secretSanta=" + secretSanta +
                ", email='" + email + '\'' +
                ", exclude=" + exclude +
                ", preAssignedSS='" + preAssignedSS + '\'' +
                ", preAssignedSSID=" + preAssignedSSID +
                '}';
    }
}
