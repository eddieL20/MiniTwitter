package actionlisteners;

import messages.Messages;
import minitwitternodes.UserNode;
import panels.UserViewPanel;

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

        String currentMessage = userViewPanel.getMessageTextArea().getText();
        messages.setMessages(currentUser, currentMessage);

        userViewPanel.getMessageTextArea().setText("");
    }
}
