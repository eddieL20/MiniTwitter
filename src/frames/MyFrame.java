package frames;

import actionlisteners.*;
import messages.Messages;
import minitwitternodes.GroupNode;
import minitwitternodes.GroupNodeRenderer;
import minitwitternodes.RootNode;
import minitwitternodes.UserNode;
import panels.UserGroupPanel;

import javax.swing.*;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreePath;
import java.awt.*;

public class MyFrame extends JFrame {

    private static MyFrame pointer;

    public static void getInstance(){
        if (pointer == null) {
            pointer = new MyFrame();
        }
    }

    private MyFrame() {

        this.setTitle("Mini Twitter");

        this.setLayout(new BorderLayout());
        this.setSize(670, 450);

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

        // make frame  visible
        this.setVisible(true);
        // frame cannot be resized
        this.setResizable(false);
        // terminate when closed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }


}
