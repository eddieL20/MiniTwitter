package observer;

import messages.Messages;
import minitwitternodes.AppNode;
import minitwitternodes.UserNode;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class UserViewObserver implements Observer{

    private DefaultListModel listModel;
    private TextArea messageFeed;
    private UserNode currentUser;
    private Messages messages;

    public UserViewObserver(DefaultListModel listModel, TextArea messageFeed, UserNode currentUser, Messages messages){
        this.listModel = listModel;
        this.messageFeed = messageFeed;
        this.currentUser = currentUser;
        this.messages = messages;
    }

    public void update(AppNode uNode) {
        if(uNode instanceof UserNode){
            listModel.clear();
            for (AppNode following: ((UserNode) uNode).getFollowing()){

                listModel.addElement(following);


            }

            List<String> filteredMessages = new ArrayList<>();
            Set<String> desiredUsers = new HashSet<>();

            desiredUsers.add(currentUser.getNodeID());
            for (AppNode following: currentUser.getFollowing()) {
                desiredUsers.add(following.getNodeID());
//                messageFeed.setText(content);
            }
            for (String message: messages.getMessages()){
                String userName = message.substring(0, message.indexOf(":"));
                if (desiredUsers.contains(userName)){
                    filteredMessages.add(message);
                }
            }

            String content = String.join("\n", filteredMessages);
            messageFeed.setText(content);

        } else if (uNode instanceof Messages){
            List<String> filteredMessages = new ArrayList<>();
            Set<String> desiredUsers = new HashSet<>();

            desiredUsers.add(currentUser.getNodeID());
            for (AppNode following: currentUser.getFollowing()) {
                desiredUsers.add(following.getNodeID());
//                messageFeed.setText(content);
            }
            for (String message: ((Messages) uNode).getMessages()){
                String userName = message.substring(0, message.indexOf(":"));
                if (desiredUsers.contains(userName)){
                    filteredMessages.add(message);
                }
            }

            String content = String.join("\n", filteredMessages);
            messageFeed.setText(content);
        }
    }
}
