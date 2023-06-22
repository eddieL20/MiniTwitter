package frames;

import actionlisteners.FollowUserListener;
import actionlisteners.PostMessageListener;
import messages.Messages;
import panels.UserViewPanel;
import minitwitternodes.UserNode;

import javax.swing.*;
import java.awt.*;

public class UserViewFrame extends JFrame {

    private UserNode currentUser;
    private UserViewPanel uViewPanel = new UserViewPanel();

    public UserViewFrame(UserNode currentUser, UserNode mainUserNode, Messages messages){

        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.setSize(new Dimension(600, 700));
        this.setResizable(false);
        this.setBackground(Color.gray);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.add(uViewPanel, BorderLayout.NORTH);

        // create Action Listeners
        FollowUserListener followUser = new FollowUserListener(currentUser, mainUserNode, uViewPanel);
        PostMessageListener postMessage = new PostMessageListener(messages, uViewPanel, currentUser);


        // Set Action Listeners to Buttons
        uViewPanel.getFollowUserButton().addActionListener(followUser);
        uViewPanel.getPostMessageButton().addActionListener(postMessage); //TODO

    }

    public UserViewPanel getUViewPanel(){
        return uViewPanel;
    }

}
