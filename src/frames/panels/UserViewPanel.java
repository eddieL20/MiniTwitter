package frames.panels;

import javax.swing.*;
import java.awt.*;

public class UserViewPanel extends JPanel {

    private final TextField followUserTextField = new TextField(25);
    private final JButton followUserButton = new JButton("Follow User");
    private final DefaultListModel<String> listModel = new DefaultListModel<>(); // Used for JList
    private final TextArea messageTextArea = new TextArea(5, 20);
    private final JButton postMessageButton = new JButton("Post Tweet");
    private final TextArea messageFeed = new TextArea();
    private final JLabel creationTimeLabel = new JLabel();
    private final JLabel lastUpdatedLabel = new JLabel();

    public UserViewPanel(){
        this.setSize(new Dimension(450, 790));
        this.setLayout(new GridBagLayout()); // allows for grid layout
        this.setBackground(Color.GRAY);

        GridBagConstraints c = new GridBagConstraints(); // needed to set constrains for components


        c.gridx = 0; // sets column value
        c.gridy = 0; // sets row value
        c.fill = GridBagConstraints.RELATIVE; // fills in space available
        c.insets = new Insets(0, 0, 5, 0); // sets padding
        c.gridwidth = 1; // width is set to one column size

        this.add(creationTimeLabel, c);

        c.gridx = 1;
        this.add(lastUpdatedLabel, c);

        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0, 5, 5, 5); // sets padding
        this.add(followUserTextField, c); // add component with constraints

        // Same process for all the components

        c.gridx = 1;
        this.add(followUserButton, c);

        c.gridx = 0;
        c.gridy = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.insets = new Insets(1, 0, 1, 1);
        JLabel currentFollowingLabel = new JLabel("Currently Following");
        this.add(currentFollowingLabel, c);

        JList<String> followersList = new JList<>(listModel);
        followersList.setPreferredSize(new Dimension(475, 250));
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 10, 0);
        this.add(followersList, c);

        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        c.insets = new Insets(1, 0, 1, 1);
        JLabel createMessageLabel = new JLabel("Create Message");
        this.add(createMessageLabel, c);

        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 10, 0);
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(messageTextArea, c);

        c.gridx = 1;
        c.fill = GridBagConstraints.BASELINE;
        this.add(postMessageButton, c);

        c.gridx = 0;
        c.gridy = 6;
        c.insets = new Insets(1, 0, 1, 1);
        c.fill = GridBagConstraints.HORIZONTAL;
        JLabel messageFeedLabel = new JLabel("Message Feed");
        this.add(messageFeedLabel, c);

        messageFeed.setPreferredSize(new Dimension(475, 250));
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 2;
        messageFeed.setEditable(false);
        this.add(new JScrollPane(messageFeed), c);

    }

    public TextField getFollowUserTextField() { return followUserTextField; }

    public JButton getFollowUserButton() { return followUserButton; }

    public DefaultListModel<String> getListModel() { return listModel; }

    public TextArea getMessageTextArea() {
        return messageTextArea;
    }

    public JButton getPostMessageButton() {
        return postMessageButton;
    }

    public TextArea getMessageFeed() { return messageFeed; }

    public JLabel getCreationTimeLabel() {
        return creationTimeLabel;
    }

    public JLabel getLastUpdatedLabel() {
        return lastUpdatedLabel;
    }
}
