package frames.panels.actionlisteners;

import compositenodes.AppNode;
import compositenodes.GroupNode;
import compositenodes.RootNode;
import compositenodes.UserNode;
import frames.panels.UserGroupPanel;

import javax.swing.*;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddGroupListener implements ActionListener {

    private final JTree tree;
    private final UserGroupPanel ugPanel;
    private final DefaultTreeSelectionModel selectionModel;
    private final GroupNode mainGroupNode;

    public AddGroupListener(JTree tree, DefaultTreeSelectionModel selectionModel, UserGroupPanel ugPanel, GroupNode mainGroupNode) {
        this.tree = tree;
        this.selectionModel = selectionModel;
        this.ugPanel = ugPanel;
        this.mainGroupNode = mainGroupNode;
    }

        @Override
    public void actionPerformed(ActionEvent actionEvent) {

        // get ID from text Group Text Field
        String nodeID = ugPanel.getGroupTextField().getText();

        // Checks if user is trying to add an ID that is empty or full of spaces
        if (nodeID.matches("^$|\\s+")){
            ugPanel.getGroupTextField().setText("");
            return;
        }

        // create new group and set the group ID
        GroupNode newGroupNode = new GroupNode(nodeID);
        mainGroupNode.setGroups(newGroupNode);

        // if currently selected node is the Root Node, add group node
        if(tree.getLastSelectedPathComponent() instanceof RootNode) {
            RootNode.getInstance().add(newGroupNode);
            TreePath path = new TreePath(newGroupNode.getPath());
            selectionModel.setSelectionPath(path);

        // else if currently selected node is a user node
        } else if (tree.getLastSelectedPathComponent() instanceof UserNode user) {

            // if the parent node is not the Root Node, set new group node to its parent
            if (!(user.getParent() instanceof RootNode)){
                GroupNode selectedNode = (GroupNode) user.getParent();
                selectedNode.add(newGroupNode);
                selectedNode.setUserGroupMembers(newGroupNode);

            // else if parent node is the Root Node, set new group node to parent
            } else {
                RootNode.getInstance().add(newGroupNode);
            }

            // set the selected path to the newly add node
            TreePath path = new TreePath(newGroupNode.getPath());
            selectionModel.setSelectionPath(path);
        } else if (tree.getLastSelectedPathComponent() instanceof GroupNode){
            GroupNode selectedNode = (GroupNode) tree.getLastSelectedPathComponent();
            selectedNode.add(newGroupNode);
            selectedNode.setUserGroupMembers(newGroupNode);
        }

        // update tree and empty the add user text field
        tree.updateUI();
        ugPanel.getGroupTextField().setText("");
    }
}
