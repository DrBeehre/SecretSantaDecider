import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SecretSanter {

//    private static TwilioAuth twilioAuth;

    public static void main(String[] args) {

        String Account_sid = args[0];
        String Account_token = args[1];

        Twilio.init(Account_sid, Account_token);

        Message message = Message.creator(new PhoneNumber("+64278484379"), new PhoneNumber("+15042084202"),
                "This is a test text from ward's computer all done using code. Please text me on 0278484379 to let me know if this worked. Cheers!")
                .create();

        System.out.println(message.getSid());
    }
}
