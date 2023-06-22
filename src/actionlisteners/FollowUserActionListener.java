package actionlisteners;

import panels.UserViewPanel;
import minitwitternodes.AppNode;
import minitwitternodes.UserNode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FollowUserActionListener implements ActionListener {

    private final UserNode mainUserNode;
    private final UserViewPanel uViewPanel;

    private final UserNode currentUser;

    public FollowUserActionListener(UserNode currentUser, UserNode mainUserNode, UserViewPanel uViewPanel){
        this.mainUserNode = mainUserNode;
        this.uViewPanel = uViewPanel;
        this.currentUser = currentUser;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String newFollowerID = uViewPanel.getFollowUserTextField().getText();

        for (AppNode appNode : mainUserNode.getUsers()){

            if (newFollowerID.equals(appNode.getNodeID()))
                currentUser.setFollowers(appNode);
        }

        // Clear the text after the Button is clicked
        uViewPanel.getFollowUserTextField().setText("");
    }
}
