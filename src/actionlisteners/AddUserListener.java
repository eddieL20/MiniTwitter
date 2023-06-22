package actionlisteners;

import panels.UserGroupPanel;
import minitwitternodes.GroupNode;
import minitwitternodes.RootNode;
import minitwitternodes.UserNode;

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
        String nodeID = ugPanel.getUserTextField().getText();

        UserNode newUserNode = new UserNode(nodeID);
        // UserTreeNode.setAllUsers(newUserNode);
        mainUserNode.setUsers(newUserNode);

        if(tree.getLastSelectedPathComponent() instanceof RootNode){

            RootNode.getInstance().add(newUserNode);
            if (RootNode.getInstance().getChildAt(0) == null) {
                TreePath path = new TreePath(newUserNode.getPath());
                tree.expandPath(path);
            }

            TreePath path = new TreePath(newUserNode.getPath());
            tree.expandPath(path);
            selectionModel.setSelectionPath(path);
        } else if (tree.getLastSelectedPathComponent() instanceof UserNode user) {

            if(!(user.getParent() instanceof RootNode)){
                GroupNode selectedNode = (GroupNode) user.getParent();
                selectedNode.add(newUserNode);
                selectedNode.setUserGroupMembers(newUserNode);

            } else {
                RootNode.getInstance().add(newUserNode);
            }

            TreePath path = new TreePath(newUserNode.getPath());
            selectionModel.setSelectionPath(path);
        } else if (tree.getLastSelectedPathComponent() instanceof GroupNode){

            GroupNode selectedNode = (GroupNode) tree.getLastSelectedPathComponent();
            selectedNode.add(newUserNode);
            selectedNode.setUserGroupMembers(newUserNode);

            TreePath path = new TreePath(newUserNode.getPath());
            selectionModel.setSelectionPath(path);

        }

        tree.updateUI();
        ugPanel.getUserTextField().setText("");
    }


}
