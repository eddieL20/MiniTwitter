package frames.panels;

import javax.swing.*;
import java.awt.*;

public class UserGroupPanel extends JPanel {

    private final JButton addGroupButton = new JButton("Add Group");
    private final JButton addUserButton = new JButton("Add User");
    private final JTextField userTextField = new JTextField(20);
    private final JTextField groupTextField = new JTextField(20);
    private final JButton openUserViewButton = new JButton("Open User View");
    private final JButton showUserTotalButton = new JButton("Show User Total" );
    private final JButton showGroupTotalButton = new JButton("Show Group Total");
    private final JButton showMessagesTotalButton = new JButton("Show Messages Total");
    private final JButton showPositivePercentageButton = new JButton("Show Positive Percentage");
    public UserGroupPanel(){

        // needed to set the grid location of components
        GridBagConstraints c = new GridBagConstraints();

        this.setSize(400, 200);
        this.setLayout(new GridBagLayout());

        this.setBackground(Color.GRAY);
        this.setSize(400, 200);
        c.gridx = 1; // sets the column value
        c.gridy = 0; // sets the row value
        c.fill = GridBagConstraints.HORIZONTAL; // fills in the space available
        c.insets = new Insets(5, 5, 5, 5); // sets padding
        this.add(addUserButton, c); // add component to panel with the constraints

        // same process for all the components

        c.gridy = 1;
        this.add(addGroupButton, c);

        c.gridx = 0;
        c.gridy = 0;
        this.add(userTextField, c);

        c.gridx = 0;
        c.gridy = 1;
        this.add(groupTextField, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.insets = new Insets(5, 5, 10, 5);
        this.add(openUserViewButton, c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.RELATIVE;
        c.insets = new Insets(20, 5, 5, 5);
        this.add(showUserTotalButton, c);

        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        c.insets = new Insets(20, 5, 5, 5);
        this.add(showGroupTotalButton, c);

        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        c.insets = new Insets(5, 5, 5, 5);
        this.add(showMessagesTotalButton, c);

        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 1;
        c.insets = new Insets(5, 5, 5, 5);
        this.add(showPositivePercentageButton, c);

    }

    public JButton getAddGroupButton() {
        return addGroupButton;
    }

    public JButton getAddUserButton() {
        return addUserButton;
    }

    public JTextField getUserTextField() {
        return userTextField;
    }

    public JTextField getGroupTextField() {
        return groupTextField;
    }

    public JButton getOpenUserViewButton() {
        return openUserViewButton;
    }

    public JButton getShowUserTotalButton() {
        return showUserTotalButton;
    }

    public JButton getShowGroupTotalButton() {
        return showGroupTotalButton;
    }

    public JButton getShowMessagesTotalButton() {
        return showMessagesTotalButton;
    }

    public JButton getShowPositivePercentageButton() {
        return showPositivePercentageButton;
    }

}
