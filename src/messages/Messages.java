package messages;

import minitwitternodes.UserNode;

import java.util.ArrayList;
import java.util.List;

public class Messages {

    private List<String> messages = new ArrayList<>();


    public List<String> getMessages(){
        return messages;
    }

    public void setMessages(UserNode user, String message){
        message = user.getNodeID() + ": " + message;
        this.messages.add(message);
    }
}
