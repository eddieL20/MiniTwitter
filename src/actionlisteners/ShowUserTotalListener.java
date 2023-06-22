package actionlisteners;

import minitwitternodes.UserNode;
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

        CountVisitor showUserCount = new CountVisitor();

        mainUserNode.accept(showUserCount);

        int count = showUserCount.getUserCount();

        String message = "Total Users: " + count;
        JLabel userMessageLabel = new JLabel(message);

        JFrame frame = new JFrame("Total Users");
        frame.setSize(200, 100);
        frame.setResizable(false);
        frame.setVisible(true);

        frame.add(userMessageLabel);


    }

}
