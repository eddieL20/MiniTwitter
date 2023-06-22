package actionlisteners;

import messages.Messages;
import visitors.CountVisitor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowMessageTotalListener implements ActionListener {

    private Messages messages;

    public ShowMessageTotalListener(Messages messages){
        this.messages = messages;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Create visitor to get message count
        CountVisitor messageTotalVisitor = new CountVisitor();

        // Message object accepts visitor
        messages.accept(messageTotalVisitor);

        int messageCount = messageTotalVisitor.getMessageCount();

        String message = "Total Messages: " + messageCount;
        JLabel userMessageLabel = new JLabel(message);

        JFrame frame = new JFrame("Total Users");
        frame.setSize(200, 100);
        frame.setResizable(false);
        frame.setVisible(true);

        frame.add(userMessageLabel);
    }
}
