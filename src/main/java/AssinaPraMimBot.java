import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.api.objects.*;
import org.telegram.telegrambots.api.methods.send.SendMessage;

import java.util.ArrayList;
import java.util.List;

public class AssinaPraMimBot extends TelegramLongPollingBot {


    public void onUpdateReceived(Update update) {
//        manda1(update);
        manda2(update);
//        numerico(update);
        botao(update);
    }

    public Integer botao(Update update){
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            if (true) {
                SendMessage message = new SendMessage() // Create a message object object
                        .setChatId(chat_id)
                        .setText("You send /start");
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<List<InlineKeyboardButton>>();
                List<InlineKeyboardButton> rowInline = new ArrayList<InlineKeyboardButton>();
                rowInline.add(new InlineKeyboardButton().setText("Materia 1").setCallbackData("ae"));
                rowInline.add(new InlineKeyboardButton().setText("Materia 2").setCallbackData("mahoeh"));
                rowInline.add(new InlineKeyboardButton().setText("Materia 3").setCallbackData("aeaeae"));
                rowInline.add(new InlineKeyboardButton().setText("Materia 4").setCallbackData("uepa"));
                rowInline.add(new InlineKeyboardButton().setText("Materia 5").setCallbackData("HA"));
                rowInline.add(new InlineKeyboardButton().setText("Materia 6").setCallbackData("ALAMANO"));
                // Set the keyboard to the markup
                rowsInline.add(rowInline);
                // Add it to the message
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else {

            }

        } else if (update.hasCallbackQuery()) {}
        return 0;
    }

    public Integer numerico(Update update) {

        ReplyKeyboardMarkup keyBoardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<KeyboardRow>();
        KeyboardRow row = new KeyboardRow();
        for (int i = 1; i < 10; i++) {
            row.add(Integer.valueOf(i).toString());
            if (i % 3 == 0) {
                keyboard.add(row);
                row = new KeyboardRow();
            }
        }
        row.add("0");
        keyboard.add(row);
        keyBoardMarkup.setKeyboard(keyboard);
        keyBoardMarkup.setResizeKeyboard(true);
        Message message = update.getMessage();
        SendMessage msgrequest = new SendMessage();
        msgrequest.setChatId(message.getChatId());
//        msgrequest.setText(message.getText());
        msgrequest.setReplyMarkup(keyBoardMarkup);
        try {
            sendMessage(msgrequest); //at the end, so some magic and send the message ;)
        } catch (TelegramApiException e) {
            //do some error handling
        }
        return 0;
    }

    public Integer manda1(Update update){
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
                }
            }
        }
        return 0;
    }

    public Integer manda2(Update update){
        //check if the update has a message
        if (update.hasMessage() && update.getMessage().hasText()) {

            //String message_text = update.getMessage().getText();
            //String message_text = update.getMessage().getChatId().toString();
            String message_text = "UEPA";
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
        return 0;
    }

    public String getBotUsername() {
        return "Tonias";
    }

    public String getBotToken() {
        return "771756087:AAGV5irFeIYnq0-amtP2f0SkITc4NRoqRXo";
    }
}