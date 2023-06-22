package observer;

import messages.Messages;
import minitwitternodes.AppNode;
import minitwitternodes.UserNode;

import javax.swing.*;
import java.awt.*;


public class UserViewObserver implements Observer{

    private DefaultListModel listModel;
    private TextArea messageFeed;

    public UserViewObserver(DefaultListModel listModel, TextArea messageFeed){
        this.listModel = listModel;
        this.messageFeed = messageFeed;
    }

    public void update(AppNode uNode) {
        if(uNode instanceof UserNode){
            listModel.clear();
            for (AppNode follower: ((UserNode) uNode).getFollowers()){
                listModel.addElement(follower);
            }
        } else if (uNode instanceof Messages){
            String content = String.join("\n", ((Messages) uNode).getMessages());
            messageFeed.setText(content);
        }
    }
}
