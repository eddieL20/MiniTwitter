package frames.panels.actionlisteners;

import compositenodes.AppNode;
import frames.panels.UserGroupPanel;
import compositenodes.GroupNode;
import compositenodes.RootNode;
import compositenodes.UserNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUserListener implements ActionListener {

    private final JTree tree;
    private final UserGroupPanel ugPanel;
    private final DefaultTreeSelectionModel selectionModel;

    private final UserNode mainUserNode;

    public AddUserListener(JTree tree, DefaultTreeSelectionModel selectionModel, UserGroupPanel ugPanel, UserNode mainUserNode){
        this.tree = tree;
        this.selectionModel = selectionModel;
        this.ugPanel = ugPanel;
        this.mainUserNode = mainUserNode;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        // get text from the user text field and assign it to nodeID variable
        String nodeID = ugPanel.getUserTextField().getText();

        // Checks if user is trying to add an ID that is empty or full of spaces
        if (nodeID.matches("^$|\\s+")){
            ugPanel.getUserTextField().setText("");
            return;
        }

        // if new userID is already in the tree, do not add
        for (AppNode userNode: mainUserNode.getUsers()){
            if (nodeID.equals(userNode.getNodeID())){
                ugPanel.getUserTextField().setText("");
                return;
            }
        }

        // Create new userNode and set new user ID
        UserNode newUserNode = new UserNode(nodeID);
        mainUserNode.setUsers(newUserNode);

        // if currently selected node is the Root Node, add new node to Root
        if(tree.getLastSelectedPathComponent() instanceof RootNode){
            RootNode.getInstance().add(newUserNode);

            // if Root is empty set the selected path to Root
            if (RootNode.getInstance().getChildAt(0) == null) {
                TreePath path = new TreePath(newUserNode.getPath());
                tree.expandPath(path);
            }

            // set the selected path to the newly add node
            TreePath path = new TreePath(newUserNode.getPath());
            tree.expandPath(path);
            selectionModel.setSelectionPath(path);

            // else if the currently selected node is a user node, add to parent
        } else if (tree.getLastSelectedPathComponent() instanceof UserNode user) {

            // if not Root Node get parent node and add user, else add to Root Node
            if(!(user.getParent() instanceof RootNode)){
                GroupNode selectedNode = (GroupNode) user.getParent();
                selectedNode.add(newUserNode);
                selectedNode.setUserGroupMembers(newUserNode);

            } else {
                RootNode.getInstance().add(newUserNode);
            }

            // set the selected path to the newly add node
            TreePath path = new TreePath(newUserNode.getPath());
            selectionModel.setSelectionPath(path);

            // else if currently selected is a Group Node, add to that group, else
        } else if (tree.getLastSelectedPathComponent() instanceof GroupNode){
            GroupNode selectedNode = (GroupNode) tree.getLastSelectedPathComponent();
            selectedNode.add(newUserNode);
            selectedNode.setUserGroupMembers(newUserNode);

            // set the selected path to the newly add node
            TreePath path = new TreePath(newUserNode.getPath());
            selectionModel.setSelectionPath(path);

        }

        // update tree and empty the add user text field
        tree.updateUI();
        ugPanel.getUserTextField().setText("");
    }


}
