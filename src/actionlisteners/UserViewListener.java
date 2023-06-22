package actionlisteners;

import frames.UserViewFrame;
import messages.Messages;
import minitwitternodes.GroupNode;
import minitwitternodes.RootNode;
import minitwitternodes.UserNode;
import observer.UserViewObserver;
import observer.Observer;

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

        Observer followingUsersObserver = new UserViewObserver(defaultListModel, messageFeed, currentUser, messages);
        currentUser.subscribe(followingUsersObserver);
        messages.subscribe(followingUsersObserver);

    }
}
