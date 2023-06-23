package frames.panels.actionlisteners;

import compositenodes.Messages;
import visitors.CountVisitor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PositivePercentageListener implements ActionListener {

    public Messages messages;

    public PositivePercentageListener(Messages messages){
        this.messages = messages;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // create visitor to get positive message percentage
        CountVisitor positivePercentVisitor = new CountVisitor();

        // give visitor to message object
        messages.accept(positivePercentVisitor);

        // get the float value of the percentage
        float positivePercentage = positivePercentVisitor.getPositivePercentage();

        // format the percentage float to two decimal places
        String formattedNum = String.format("%.2f", positivePercentage);

        // create the string variable that will be displayed
        String percentMassage = "Total Positive Messages: " + formattedNum + "%";

        // set the string to the label that will be displayed
        JLabel userMessageLabel = new JLabel(percentMassage);

        // create frame to display message
        JFrame frame = new JFrame("Positive Messages");
        frame.setSize(225, 100);
        frame.setResizable(false);
        frame.setVisible(true);

        // add label to message
        frame.add(userMessageLabel);

    }
}
