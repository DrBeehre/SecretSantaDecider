import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecretSanta {
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

                    persons.add(new Person(personIdCounter, personsDetails[0], personsDetails[1], personsDetails[2], Boolean.getBoolean(personsDetails[3]), personsDetails[4]));
                    personIdCounter++;
                }
            }
        }

        assignSecretSantas(persons);
    }

    private static List<Person> assignSecretSantas(List<Person> persons) {
        randomizeSecretSantas(persons);

        for(int i = 0; i < persons.size(); i++){
            persons.get(i).setSecretSantaId(i);
        }

        for (Person person: persons) {
            person.setSecretSanta(persons.stream().filter(p -> p.getId() == person.getSecretSantaId()).findFirst().get());

            System.out.println(person.getName() + " has the secret santa of " + person.getSecretSanta().getName());
        }

        return persons;
    }

    private static void randomizeSecretSantas(List<Person> persons) {
        while(true){
            Collections.shuffle(persons);

            boolean badsort = false;
            for(int i = 0; i < persons.size(); i++){
                if(persons.get(i).getId() == i){
                    badsort = true;
                    break;
                }
            }

            if(!badsort){
                break;
            }
        }
    }
}