package frames.panels.actionlisteners;

import validationcommands.*;
import compositenodes.AppNode;
import compositenodes.GroupNode;
import compositenodes.UserNode;
import frames.panels.UserGroupPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ValicationActionListener implements ActionListener {


    private final AppNode mainUserNode;
    private final AppNode mainGroupNode;
    private final UserGroupPanel ugPanel;

    public ValicationActionListener(UserNode mainUserNode, GroupNode mainGroupNode, UserGroupPanel ugPanel){
        this.mainUserNode = mainUserNode;
        this.mainGroupNode = mainGroupNode;
        this.ugPanel = ugPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // String result of all the validation
        String validateMessage = "";

        // create Validate objects for both the mainUserNode and mainGroupNode
        Validate validateUsers = new Validate(mainUserNode);
        Validate validateGroups = new Validate(mainGroupNode);

        // set commands for the mainUserNode
        Command spacesCommand = new checkEmptySpaces(validateUsers);
        Command duplicateCommand = new checkDuplicates(validateUsers);

        // execute user commands to get the resulting message. If all users are valid, then they return empty.
        validateMessage += spacesCommand.execute();
        validateMessage += duplicateCommand.execute();

        // set commands to the mainGroupNode Validate objects
        spacesCommand = new checkEmptySpaces(validateGroups);
        duplicateCommand = new checkDuplicates(validateGroups);

        // execute group commands to get the resulting message. If all users are valid, then they return empty.
        validateMessage += spacesCommand.execute();
        validateMessage += duplicateCommand.execute();

        // set text to the text area in the UserGroupPanel
        ugPanel.getValidateTextArea().setText(validateMessage);

    }

}
