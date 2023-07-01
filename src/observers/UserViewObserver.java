package observers;

import compositenodes.Messages;
import compositenodes.AppNode;
import compositenodes.UserNode;
import frames.panels.UserViewPanel;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;


public class UserViewObserver implements Observer{

    private final DefaultListModel listModel;
    private final UserNode currentUser;
    private final Messages messages;
    private final UserViewPanel userViewPanel;

    public UserViewObserver(DefaultListModel listModel, UserViewPanel userViewPanel, UserNode currentUser, Messages messages){
        this.listModel = listModel;
        this.userViewPanel = userViewPanel;
        this.currentUser = currentUser;
        this.messages = messages;
    }

    public void update(AppNode uNode) {
        TextArea messageFeed = userViewPanel.getMessageFeed();

        if(uNode instanceof UserNode){
            // clear the list
            listModel.clear();

            // add all the users being followed by current user
            for (AppNode following: ((UserNode) uNode).getFollowing()){
                listModel.addElement(following);
            }

            List<String> filteredMessages = new ArrayList<>(); // filtered messages that belong to followed users
            Set<String> desiredUsers = new HashSet<>(); // set containing followed users

            desiredUsers.add(currentUser.getNodeID()); // add current user to the set

            for (AppNode following: currentUser.getFollowing()) {
                desiredUsers.add(following.getNodeID()); // add followed users to set
            }
            for (String message: messages.getMessages()){
                String userName = message.substring(0, message.indexOf(":")); // get userID from message
                if (desiredUsers.contains(userName)){
                    filteredMessages.add(message); // if current message belongs to follower add to filtered messages
                }
            }

            String content = String.join("\n", filteredMessages); // join messages with newline at the end
            messageFeed.setText(content); // display content to the message feed

        } else if (uNode instanceof Messages){
            List<String> filteredMessages = new ArrayList<>();
            Set<String> desiredUsers = new HashSet<>();

            desiredUsers.add(currentUser.getNodeID());

            for (AppNode following: currentUser.getFollowing()) {
                desiredUsers.add(following.getNodeID());
            }
            for (String message: ((Messages) uNode).getMessages()){
                String userName = message.substring(0, message.indexOf(":"));
                if (desiredUsers.contains(userName)){
                    filteredMessages.add(message);
                }
            }

            String content = String.join("\n", filteredMessages);
            messageFeed.setText(content);

            // Update the Last Updated Time Label for all the followers
            Date date = new Date(currentUser.getLastUpdatedTime());
            userViewPanel.getLastUpdatedLabel().setText(
                    "<html>Last Updated:<br>"  + date.toString() + "</html>"
            );
        }
    }
}
