import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.api.methods.send.*;
import org.telegram.telegrambots.api.objects.*;

public class AssinaPraMimBot extends TelegramLongPollingBot {
    int num;
    public void onUpdateReceived(Update update) {


        if(update.hasMessage()){
            Message message = update.getMessage();

            //check if the message has text. it could also  contain for example a location ( message.hasLocation() )
            if(message.hasText()){

                //create a object that contains the information to send back the message
                SendMessage sendMessageRequest = new SendMessage();
                sendMessageRequest.setChatId(message.getChatId().toString()); //who should get the message? the sender from which we got the message...
                sendMessageRequest.setText("you said: " + message.getText());
                try {
                    sendMessage(sendMessageRequest); //at the end, so some magic and send the message ;)
                } catch (TelegramApiException e) {
                    //do some error handling
                }//end catch()
            }//end if()
        }//end  if()

        //check if the update has a message
        if (update.hasMessage() && update.getMessage().hasText()) {

            //String message_text = update.getMessage().getText();
            //String message_text = update.getMessage().getChatId().toString();
            String message_text = "Vai tomar no seu cu";
            long chat_id = update.getMessage().getChatId();

            SendMessage message = new SendMessage() // Create a message object object
                    .setChatId(chat_id)
                    .setText(message_text);
            try {
                execute(message); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }


    public String getBotUsername() {
        return "Tonias";
    }

    public String getBotToken() {
        return "771756087:AAGV5irFeIYnq0-amtP2f0SkITc4NRoqRXo";
    }


}
