package frames;

import compositenodes.GroupNodeRenderer;
import frames.panels.actionlisteners.*;
import compositenodes.Messages;
import compositenodes.*;
import frames.panels.UserGroupPanel;

import javax.swing.*;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreePath;
import java.awt.*;

public class MySingletonFrame extends JFrame {

    private static MySingletonFrame pointer;

    public static void getInstance(){
        if (pointer == null) {
            pointer = new MySingletonFrame();
        }
    }

    private MySingletonFrame() {

        this.setTitle("Mini Twitter"); // set frame title
        this.setLayout(new BorderLayout()); // border layout lets you add components to edges and center
        this.setSize(670, 450);
        this.setVisible(true); // make frame  visible
        this.setResizable(false); // frame cannot be resized
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // terminate when closed

        // get the only Root Node and set it to the tree
        RootNode.getInstance().setUserObject("Root");
        JTree tree = new JTree(RootNode.getInstance());

        // Selection Model is used to set the current selected node as the one that was added
        DefaultTreeSelectionModel selectionModel = new DefaultTreeSelectionModel();
        TreePath path = new TreePath(RootNode.getInstance().getPath());
        selectionModel.setSelectionPath(path);
        tree.setSelectionModel(selectionModel);
        tree.setPreferredSize(new Dimension(200, 400));
        tree.setCellRenderer(new GroupNodeRenderer());

        // Create Message Object
        Messages messages = new Messages();

        // create instance of User/Group Panel
        UserGroupPanel ugPanel = new UserGroupPanel();

        // add tree and User/Group Panel to frame. tree to the left and ugPanel to the right
        this.add(tree, BorderLayout.WEST);
        this.add(ugPanel, BorderLayout.EAST);

        // Create instance of the main Group and User Node. These nodes contain all groups and users
        GroupNode mainGroupNode = new GroupNode();
        UserNode mainUserNode = new UserNode();

        // Create Action Listeners
        AddUserListener addUser = new AddUserListener(tree, selectionModel, ugPanel, mainUserNode);
        AddGroupListener addGroup = new AddGroupListener(tree, selectionModel, ugPanel, mainGroupNode);
        UserViewListener userView = new UserViewListener(tree, selectionModel, mainUserNode, messages);
        ShowUserTotalListener userTotal = new ShowUserTotalListener(mainUserNode);
        ShowGroupTotalListener groupTotal = new ShowGroupTotalListener(mainGroupNode);
        ShowMessageTotalListener messageTotal = new ShowMessageTotalListener(messages);
        PositivePercentageListener positivePercent = new PositivePercentageListener(messages);

        // Set Action Listeners to Buttons
        ugPanel.getAddUserButton().addActionListener(addUser);
        ugPanel.getAddGroupButton().addActionListener(addGroup);
        ugPanel.getOpenUserViewButton().addActionListener(userView);
        ugPanel.getShowUserTotalButton().addActionListener(userTotal);
        ugPanel.getShowGroupTotalButton().addActionListener(groupTotal);
        ugPanel.getShowMessagesTotalButton().addActionListener(messageTotal);
        ugPanel.getShowPositivePercentageButton().addActionListener(positivePercent);




    }


}
