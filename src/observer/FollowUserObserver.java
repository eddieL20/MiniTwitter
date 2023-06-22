package observer;

import minitwitternodes.AppNode;
import minitwitternodes.UserNode;

import javax.swing.*;
import java.awt.*;


public class FollowUserObserver implements Observer{

    private DefaultListModel listModel;

    public FollowUserObserver(DefaultListModel listModel){
        this.listModel = listModel;
    }

    public void update(AppNode uNode) {
        if(uNode instanceof UserNode){
            listModel.clear();
            for (AppNode follower: ((UserNode) uNode).getFollowers()){
                listModel.addElement(follower);
            }
        }
    }
}
