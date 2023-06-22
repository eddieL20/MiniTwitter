package panels;

import javax.swing.*;
import java.awt.*;

public class UserViewPanel extends JPanel {

    private TextField followUserTextField = new TextField(25);
    private JButton followUserButton = new JButton("Follow User");
    private DefaultListModel<String> listModel = new DefaultListModel<>(); // Used for JList
    private JList<String> followersList = new JList<>(listModel);
    private TextArea messageTextArea = new TextArea(5, 20);
    private JButton postMessageButton = new JButton("Post Tweet");
    private TextArea messageFeed = new TextArea();
    public UserViewPanel(){
        this.setSize(new Dimension(550, 660));
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.GRAY);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.insets = new Insets(5, 5, 5, 5);
        this.add(followUserTextField, c);

        c.gridx = 1;
        this.add(followUserButton, c);

        followersList.setPreferredSize(new Dimension(475, 250));
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        this.add(followersList, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        this.add(messageTextArea, c);

        c.gridx = 1;
        this.add(postMessageButton, c);

        messageFeed.setPreferredSize(new Dimension(475, 250));
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        messageFeed.setEditable(false);
        this.add(new JScrollPane(messageFeed), c);

    }

    public TextField getFollowUserTextField() { return followUserTextField; }

    public void setFollowUserTextField(TextField followUserTextField) { this.followUserTextField = followUserTextField; }

    public JButton getFollowUserButton() { return followUserButton; }

    public void setFollowUserButton(JButton followUserButton) {
        this.followUserButton = followUserButton;
    }

    public JList<String> getFollowersList() { return followersList; }

    public void setFollowersList(JList<String> followersList) {
        this.followersList = followersList;
    }

    public DefaultListModel<String> getListModel() { return listModel; }

    public void setListModel(DefaultListModel<String> listModel) { this.listModel = listModel; }

    public TextArea getMessageTextArea() {
        return messageTextArea;
    }

    public void setMessageTextArea(TextArea messageTextArea) {
        this.messageTextArea = messageTextArea;
    }

    public JButton getPostMessageButton() {
        return postMessageButton;
    }

    public void setPostMessageButton(JButton postMessageButton) {
        this.postMessageButton = postMessageButton;
    }

    public TextArea getMessageFeed() { return messageFeed; }

    public void setMessageFeed(TextArea messageFeed) { this.messageFeed = messageFeed; }
}
