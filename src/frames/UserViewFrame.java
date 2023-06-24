package frames;

import frames.panels.actionlisteners.FollowUserListener;
import frames.panels.actionlisteners.PostMessageListener;
import compositenodes.Messages;
import frames.panels.UserViewPanel;
import compositenodes.UserNode;

import javax.swing.*;
import java.awt.*;

public class UserViewFrame extends JFrame {

    private final UserViewPanel uViewPanel = new UserViewPanel();

    public UserViewFrame(UserNode currentUser, UserNode mainUserNode, Messages messages){

        // set size and appearance of frame
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.setSize(new Dimension(600, 800));
        this.setResizable(false);
        this.setBackground(Color.gray);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //add UserViewPanel object to frame
        this.add(uViewPanel, BorderLayout.CENTER);

        // create Action Listeners
        FollowUserListener followUser = new FollowUserListener(currentUser, mainUserNode, uViewPanel);
        PostMessageListener postMessage = new PostMessageListener(messages, uViewPanel, currentUser);

        // Set Action Listeners to Buttons
        uViewPanel.getFollowUserButton().addActionListener(followUser);
        uViewPanel.getPostMessageButton().addActionListener(postMessage);

    }

    public UserViewPanel getUViewPanel(){ return uViewPanel; }

}
