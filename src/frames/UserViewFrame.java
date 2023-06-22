package frames;

import actionlisteners.FollowUserActionListener;
import observer.FollowUserObserver;
import observer.Observer;
import panels.UserViewPanel;
import minitwitternodes.UserNode;

import javax.swing.*;
import java.awt.*;

public class UserViewFrame extends JFrame {

    private UserNode currentUser;
    private UserViewPanel uViewPanel = new UserViewPanel();

    public UserViewFrame(UserNode currentUser, UserNode mainUserNode){

        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.setSize(new Dimension(600, 700));
        this.setResizable(false);
        this.setBackground(Color.gray);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.add(uViewPanel, BorderLayout.NORTH);

        // create Action Listeners
        FollowUserActionListener followUser = new FollowUserActionListener(currentUser, mainUserNode, uViewPanel);


        // Set Action Listeners to Buttons
        uViewPanel.getFollowUserButton().addActionListener(followUser);

    }

    public UserViewPanel getUViewPanel(){
        return uViewPanel;
    }

}
