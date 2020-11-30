import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecretSanta {

    private static Double DEFAULT_PRICE_CAP = 100.00;

    public static void main(String[] args) {

        //Here we set the properties needed to send an email
        // We need the username and password to be passed in as arguements when running this app
        // makes shit safer
        String username = null;
        String password = null;

//        String to = args[2];
//        String from = args[3];
//        String subject = args[4];
//        String bodyText = args[5];
//
//        SecretSanterEmail secretSanterEmail = new SecretSanterEmail(username, password);
//        secretSanterEmail.createEmail(to, from, subject, bodyText);
//        secretSanterEmail.sendEmail();



        List<Person> persons = new ArrayList<>();
        int personIdCounter = 0;

        if(args.length > 0){
            for(int i = 0; i < args.length; i++){
                if(args[i].equals("-gmail-username")){
                    username = args[i+1];
                    i++;
                }else if(args[i].equals("-gmail-password")){
                    password = args[i+1];
                    i++;
                } else if(args[i].equals("-person")){
                    String[] personsDetails = args[i+1].split(",");

                    persons.add(new Person(personIdCounter, personsDetails[0], personsDetails[1], personsDetails[2], personsDetails[3], personsDetails[4], Double.parseDouble(personsDetails[5]), personsDetails[6]));
                    personIdCounter++;
                }
            }
        }

        assignSecretSantas(persons);

//        printOut(persons);

//        testAssignment(persons);

        // Time to do emailing baby
//        sendEmail(username, password, persons);
        sendTestEmail(username, password, persons);
    }

    private static void sendTestEmail(String username, String password, List<Person> persons) {
        for (Person person : persons) {

            if(person.getPriceCapOverride().equals(0.0)){
                person.setPriceCapOverride(DEFAULT_PRICE_CAP);
            }

            String to = person.getEmail();
            String from = "wardbeehre@gmail.com";
            String subject = "Test - SECRET SANTA - Please reply to confirm this worked";
            String bodyText = "This is a test to see if this email has worked. \n" +
                    "\nPlease reply!\n" +
                    "\nCheers, Ward";

            SecretSanterEmail secretSanterEmail = new SecretSanterEmail(username, password);
            secretSanterEmail.createEmail(to, from, subject, bodyText);
            secretSanterEmail.sendEmail();

        }
    }

    private static void sendEmail(String username, String password, List<Person> persons) {
        for (Person person : persons) {

            if(person.getPriceCapOverride().equals(0.0)){
                person.setPriceCapOverride(DEFAULT_PRICE_CAP);
            }

            String to = person.getEmail();
            String from = "wardbeehre@gmail.com";
            String subject = "SECRET SANTA - 24 Days - Be careful who you let see inside!";
            String bodyText = String.format("Good Morning %s %n", person.getName())
                    .concat(String.format("%nYou are the Secret Santa for %s %n", person.getSecretSanta().getName()))
                    .concat(String.format("%nYour limit is $%.2f %n", person.getPriceCapOverride()))
                    .concat(String.format("%nYou are free to get anything appropriate as your gift(s), but please try" +
                            " aim for around the limit, price wise.%n " +
                            "Your secret person has provided you with the following hint if you are stuck looking for " +
                            "ideas for what to get them.%n" +
                            "Hint: %s", person.getHint())) // This is where the hint goes
                    .concat(String.format("%n%nCheers!%nWard"));

            SecretSanterEmail secretSanterEmail = new SecretSanterEmail(username, password);
            secretSanterEmail.createEmail(to, from, subject, bodyText);
            secretSanterEmail.sendEmail();

        }
    }

    private static List<Person> assignSecretSantas(List<Person> persons) {

        assignPreAssignedSecretSantasId(persons);

        assignExcludionId(persons);

        randomizeSecretSantas(persons);

        for(int i = 0; i < persons.size(); i++){
            persons.get(i).setSecretSantaId(i);
        }

        for (Person person: persons) {
            person.setSecretSanta(persons.stream()
                    .filter(p -> p.getId() == person.getSecretSantaId())
                    .findFirst()
                    .get()
            );

            System.out.println(person.getName() + " has the secret santa of " + person.getSecretSanta().getName());
        }

        return persons;
    }

    private static void assignExcludionId(List<Person> persons){
        for (Person person : persons) {
            if(!person.getExclude().equals("null")){
                person.setExcludeId(persons.stream()
                        .filter(p -> p.getName().equals(person.getExclude()))
                        .findFirst()
                        .get()
                        .getId());
            }
        }
    }

    private static void assignPreAssignedSecretSantasId(List<Person> persons){
        for (Person person : persons) {
            if(!person.getPreAssignedSS().equals("null")){
                person.setPreAssignedSSID(persons.stream()
                        .filter(p -> p.getName().equals(person.getPreAssignedSS()))
                        .findFirst()
                        .get()
                        .getId());
            }
        }
    }

    private static void randomizeSecretSantas(List<Person> persons) {
        while(true){
            Collections.shuffle(persons);

            boolean badsort = false;
            for(int i = 0; i < persons.size(); i++){
                if(persons.get(i).getId() == i
                        || (persons.get(i).getPreAssignedSSID()!= null && persons.get(i).getPreAssignedSSID() != i)
                        || (persons.get(i).getExcludeId() != null && persons.get(i).getExcludeId() == i)){
                    badsort = true;
                    break;
                }
            }

            if(!badsort){
                break;
            }
        }
    }

    private static void printOut(List<Person> persons){
        for (Person person : persons) {
            System.out.println(person.toString());
        }
    }

//    private static void testAssignment(List<Person> persons){
//        for(int i = 0; i < 10; i++){
//            System.out.println("------------------------------------");
//            assignSecretSantas(persons);
//            printOut(persons);
//            System.out.println("------------------------------------");
//        }
//    }
}
