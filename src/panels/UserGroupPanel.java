package panels;

import javax.swing.*;
import java.awt.*;

public class UserGroupPanel extends JPanel {

    private JButton addGroupButton = new JButton("Add Group");
    private JButton addUserButton = new JButton("Add User");
    private JTextField userTextField = new JTextField(20);
    private JTextField groupTextField = new JTextField(20);
    private JButton openUserViewButton = new JButton("Open User View");
    private JButton showUserTotalButton = new JButton("Show User Total" );
    private JButton showGroupTotalButton = new JButton("Show Group Total");
    private JButton showMessagesTotalButton = new JButton("Show Messages Total");
    private JButton showPositivePercentageButton = new JButton("Show Positive Percentage");
    public UserGroupPanel(){
        GridBagConstraints c = new GridBagConstraints();

        this.setSize(400, 200);
        this.setLayout(new GridBagLayout());

        this.setBackground(Color.GRAY);
        this.setSize(400, 200);
        c.gridx = 1;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);
        this.add(addUserButton, c);

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

    public void setAddGroupButton(JButton addGroupButton) {
        this.addGroupButton = addGroupButton;
    }

    public JButton getAddUserButton() {
        return addUserButton;
    }

    public void setAddUserButton(JButton addUserButton) {
        this.addUserButton = addUserButton;
    }

    public JTextField getUserTextField() {
        return userTextField;
    }

    public void setUserTextField(JTextField userTextField) {
        this.userTextField = userTextField;
    }

    public JTextField getGroupTextField() {
        return groupTextField;
    }

    public void setGroupTextField(JTextField groupTextField) {
        this.groupTextField = groupTextField;
    }

    public JButton getOpenUserViewButton() {
        return openUserViewButton;
    }

    public void setOpenUserViewButton(JButton openUserViewButton) {
        this.openUserViewButton = openUserViewButton;
    }

    public JButton getShowUserTotalButton() {
        return showUserTotalButton;
    }

    public void setShowUserTotalButton(JButton showUserTotalButton) {
        this.showUserTotalButton = showUserTotalButton;
    }

    public JButton getShowGroupTotalButton() {
        return showGroupTotalButton;
    }

    public void setShowGroupTotalButton(JButton showGroupTotalButton) {
        this.showGroupTotalButton = showGroupTotalButton;
    }

    public JButton getShowMessagesTotalButton() {
        return showMessagesTotalButton;
    }

    public void setShowMessagesTotalButton(JButton showMessagesTotalButton) {
        this.showMessagesTotalButton = showMessagesTotalButton;
    }

    public JButton getShowPositivePercentageButton() {
        return showPositivePercentageButton;
    }

    public void setShowPositivePercentageButton(JButton showPositivePercentageButton) {
        this.showPositivePercentageButton = showPositivePercentageButton;
    }
}
