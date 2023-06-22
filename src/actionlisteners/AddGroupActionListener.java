package actionlisteners;

import minitwitternodes.GroupNode;
import minitwitternodes.RootNode;
import minitwitternodes.UserNode;
import panels.UserGroupPanel;

import javax.swing.*;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddGroupActionListener implements ActionListener {

    private final JTree tree;
    private final UserGroupPanel ugPanel;
    private final DefaultTreeSelectionModel selectionModel;
    private final GroupNode mainGroupNode;

    public AddGroupActionListener(JTree tree, DefaultTreeSelectionModel selectionModel, UserGroupPanel ugPanel, GroupNode mainGroupNode) {
        this.tree = tree;
        this.selectionModel = selectionModel;
        this.ugPanel = ugPanel;
        this.mainGroupNode = mainGroupNode;
    }

        @Override
    public void actionPerformed(ActionEvent actionEvent) {

        // get ID from text Group Text Field
        String nodeID = ugPanel.getGroupTextField().getText();
        GroupNode newGroupNode = new GroupNode(nodeID);
        mainGroupNode.setGroups(newGroupNode);


        if(tree.getLastSelectedPathComponent() instanceof RootNode) {
            RootNode.getInstance().add(newGroupNode);
            TreePath path = new TreePath(newGroupNode.getPath());
            selectionModel.setSelectionPath(path);
        } else if (tree.getLastSelectedPathComponent() instanceof UserNode user) {
            if (!(user.getParent() instanceof RootNode)){
                GroupNode selectedNode = (GroupNode) user.getParent();
                selectedNode.add(newGroupNode);
                selectedNode.setUserGroupMembers(newGroupNode);
            } else {
                RootNode.getInstance().add(newGroupNode);
            }
            TreePath path = new TreePath(newGroupNode.getPath());
            selectionModel.setSelectionPath(path);
        } else if (tree.getLastSelectedPathComponent() instanceof GroupNode){
            GroupNode selectedNode = (GroupNode) tree.getLastSelectedPathComponent();
            selectedNode.add(newGroupNode);
            selectedNode.setUserGroupMembers(newGroupNode);
        }

        tree.updateUI();
        ugPanel.getGroupTextField().setText("");
    }
}
