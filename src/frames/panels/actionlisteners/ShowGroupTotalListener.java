package frames.panels.actionlisteners;

import compositenodes.GroupNode;
import visitors.CountVisitor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowGroupTotalListener implements ActionListener {

    private final GroupNode mainGroupNode;

    public ShowGroupTotalListener(GroupNode mainGroupNode){
        this.mainGroupNode = mainGroupNode;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        // create visitor for the mainGroupNode
        CountVisitor showGroupCount = new CountVisitor();
        mainGroupNode.accept(showGroupCount); // visitor is accepted by the GroupNode that contains all the Groups

        // get the count for all the groups
        int groupCount = showGroupCount.getGroupCount();

        // create a formatted string to give to a new label
        String message = "Total Groups: " + groupCount;
        JLabel groupTotalLabel = new JLabel(message);

        // create new frame and add the message label
        JFrame frame = new JFrame("Total Groups");
        frame.setSize(200, 100);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(groupTotalLabel);

    }


}
