package frames.panels.actionlisteners;

import compositenodes.AppNode;
import compositenodes.Messages;
import compositenodes.UserNode;
import frames.panels.UserViewPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PostMessageListener implements ActionListener {

    private Messages messages;
    private UserViewPanel userViewPanel;
    private UserNode currentUser;

    public PostMessageListener(Messages messages, UserViewPanel userViewPanel, UserNode currentUser){
       this.messages = messages;
       this.userViewPanel = userViewPanel;
       this.currentUser = currentUser;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // get current message from message text area
        String currentMessage = userViewPanel.getMessageTextArea().getText();

        // if message is empty string or just spaces reset message text area and return
        if (currentMessage.matches("^$|\\s+")){
            userViewPanel.getMessageTextArea().setText("");
            return;
        }

        // set message to message object, then clear message text area
        messages.setMessages(currentUser, currentMessage);
        userViewPanel.getMessageTextArea().setText("");
    }
}
