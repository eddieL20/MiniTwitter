package actionlisteners;

import minitwitternodes.GroupNode;
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
        CountVisitor showGroupCount = new CountVisitor();

        mainGroupNode.accept(showGroupCount);

        int groupCount = showGroupCount.getGroupCount();

        String message = "Total Groups: " + groupCount;
        JLabel groupTotalLabel = new JLabel(message);

        JFrame frame = new JFrame("Total Groups");
        frame.setSize(200, 100);
        frame.setResizable(false);
        frame.setVisible(true);


        frame.add(groupTotalLabel);

    }


}
