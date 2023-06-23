package frames.panels.actionlisteners;

import frames.UserViewFrame;
import compositenodes.Messages;
import compositenodes.GroupNode;
import compositenodes.RootNode;
import compositenodes.UserNode;
import observers.UserViewObserver;
import observers.Observer;

import javax.swing.*;
import javax.swing.tree.DefaultTreeSelectionModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserViewListener implements ActionListener {

    private final JTree tree;
    private final DefaultTreeSelectionModel selectionModel;
    private final UserNode mainUserNode;
    private Messages messages;

    public UserViewListener(JTree tree, DefaultTreeSelectionModel selectionModel, UserNode mainUserNode, Messages messages){
        this.tree = tree;
        this.selectionModel = selectionModel;
        this.mainUserNode = mainUserNode;
        this.messages = messages;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        // Return if the selected Node is a group or root. No User view for a group.
        if (tree.getLastSelectedPathComponent() instanceof GroupNode ||
                tree.getLastSelectedPathComponent() instanceof RootNode) {
            return;
        }

        // Get currently selected User in the Tree
        UserNode currentUser = (UserNode) tree.getLastSelectedPathComponent();

        // Create a UserViewFrame that shows "User View: " followed by their ID as the title
        String title = "User View: " + currentUser.getNodeID();
        UserViewFrame uViewFrame = new UserViewFrame(currentUser, mainUserNode, messages); //TODO

        // Set title for frame
        uViewFrame.setTitle(title);

        // Create and subscribe observer to the currently selected user
        // must pass the List model as a parameter when instantiating the UserViewObserver
        // This updates the JList that shows who the current user is Following
        DefaultListModel defaultListModel = uViewFrame.getUViewPanel().getListModel();
        TextArea messageFeed = uViewFrame.getUViewPanel().getMessageFeed();

        // create observer to update the users being followed and the message feed
        Observer followingUsersObserver = new UserViewObserver(defaultListModel, messageFeed, currentUser, messages);
        currentUser.subscribe(followingUsersObserver); // subscribe observer to current user object
        messages.subscribe(followingUsersObserver); // subscribe observer to messages object

    }
}
