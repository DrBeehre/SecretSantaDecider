import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecretSanterSMS {

    public static void main(String[] args) throws IOException {

        String Account_sid = null;
        String Account_token = null;

        List<Person> persons = new ArrayList<>();
        int personIdCounter = 0;

        if(args.length > 0){
            for(int i = 0; i < args.length; i++){

                // Get Creds
                if(args[i].equals("-auth-id")){
                    Account_sid = args[i+1];
                    i++;
                }
                if(args[i].equals("-auth-token")){
                    Account_token = args[i+1];
                    i++;
                }

                if(args[i].equals("-person")){
                    String[] personsDetails = args[i+1].split(",");

                    //persons.add(new Person(personIdCounter, personsDetails[0], personsDetails[1], null));
                    personIdCounter++;
                }
            }
        }

        validateCreds(Account_sid, Account_token);

//        Twilio.init(Account_sid, Account_token);

        assignSecretSantas(persons);

//        Message message = Message.creator(new PhoneNumber("+64278484379"), new PhoneNumber("+15042084202"),
//                "This is a test text from ward's computer all done using code. Please text me on 0278484379 to let me know if this worked. Cheers!")
//                .create();
//
//        System.out.println(message.getSid());
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

    private static void validateCreds(String account_sid, String account_token) throws IOException {
        if(account_sid == null|| account_token == null){
            throw new IOException("Account_sid or Account_token wasn't provided. Please use -auth-id and -auth-token to set these.");
        }
    }
}
