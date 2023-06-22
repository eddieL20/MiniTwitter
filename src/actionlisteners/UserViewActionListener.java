package actionlisteners;

import frames.UserViewFrame;
import minitwitternodes.GroupNode;
import minitwitternodes.UserNode;
import observer.FollowUserObserver;
import observer.Observer;
import panels.UserViewPanel;

import javax.swing.*;
import javax.swing.tree.DefaultTreeSelectionModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserViewActionListener implements ActionListener {

    private final JTree tree;
    private final DefaultTreeSelectionModel selectionModel;
    private final UserNode mainUserNode;

    public UserViewActionListener(JTree tree, DefaultTreeSelectionModel selectionModel, UserNode mainUserNode){
        this.tree = tree;
        this.selectionModel = selectionModel;
        this.mainUserNode = mainUserNode;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        // Return if the selected Node is a group. No User view for a group.
        if (tree.getLastSelectedPathComponent() instanceof GroupNode) return;

        // Get currently selected User in the Tree
        UserNode currentUser = (UserNode) tree.getLastSelectedPathComponent();

        // Create a UserViewFrame that shows "User View: " followed by their ID as the title
        String title = "User View: " + currentUser.getNodeID();
        UserViewFrame uViewFrame = new UserViewFrame(currentUser, mainUserNode); //TODO

        // Set title for frame
        uViewFrame.setTitle(title);

        // Create and subscribe observer to the currently selected user
        // must pass the List model as a parameter when instantiating the FollowUserObserver
        // This updates the JList that shows who the current user is Following
        Observer followingUsersObserver = new FollowUserObserver(uViewFrame.getUViewPanel().getListModel());
        currentUser.subscribe(followingUsersObserver);


    }
}
