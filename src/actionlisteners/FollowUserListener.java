package actionlisteners;

import frames.UserViewFrame;
import panels.UserViewPanel;
import minitwitternodes.AppNode;
import minitwitternodes.UserNode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FollowUserListener implements ActionListener {

    private final UserNode mainUserNode;
    private final UserViewPanel uViewPanel;

    private final UserNode currentUser;

    public FollowUserListener(UserNode currentUser, UserNode mainUserNode, UserViewPanel uViewPanel){
        this.mainUserNode = mainUserNode;
        this.uViewPanel = uViewPanel;
        this.currentUser = currentUser;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String newFollowerID = uViewPanel.getFollowUserTextField().getText();
        String currentUserID = currentUser.getNodeID();

        // Check if users arr trying to add themselves.
        // If so, clear the text field and return
        if(currentUserID.equals(newFollowerID)){
            uViewPanel.getFollowUserTextField().setText("");
            return;
        }

        // Check if users are trying to follow a another user that is already being followed
        // If so, clear the text field and return
        for (AppNode appNode: currentUser.getFollowers()){
            if (newFollowerID.equals(appNode.getNodeID())){
                uViewPanel.getFollowUserTextField().setText("");
                return;
            }
        }

        // Check if the new user trying to be added is in the current list of users
        // If so, add to followers of current user
        for (AppNode appNode : mainUserNode.getUsers()){
            if (newFollowerID.equals(appNode.getNodeID()))
                currentUser.setFollowers(appNode);
        }

        // Clear the text after the Button is clicked
        uViewPanel.getFollowUserTextField().setText("");
    }
}