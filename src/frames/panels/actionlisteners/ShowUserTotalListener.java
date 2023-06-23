package frames.panels.actionlisteners;

import compositenodes.UserNode;
import visitors.CountVisitor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowUserTotalListener implements ActionListener {

    private final UserNode mainUserNode;

    public ShowUserTotalListener(UserNode mainUserNode){
        this.mainUserNode = mainUserNode;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        // create visitor to get user node count
        CountVisitor showUserCount = new CountVisitor();
        mainUserNode.accept(showUserCount); // main UserNode that contains all the users accept the visitor

        // get count from visitor
        int count = showUserCount.getUserCount();

        // create formatted string that will be displayed
        String message = "Total Users: " + count;
        JLabel userMessageLabel = new JLabel(message); // set string to new label

        // create frame and add label to frame
        JFrame frame = new JFrame("Total Users");
        frame.setSize(200, 100);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(userMessageLabel);
    }

}
