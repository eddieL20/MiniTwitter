package frames.panels.actionlisteners;

import compositenodes.AppNode;
import compositenodes.UserNode;
import frames.panels.UserGroupPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class LastUpdatedActionListener implements ActionListener {

    private AppNode mainUserNode;
    private UserGroupPanel userGroupPanel;

    public LastUpdatedActionListener(AppNode mainUserNode, UserGroupPanel userGroupPanel){ //TODO
        this.mainUserNode = mainUserNode;
        this.userGroupPanel = userGroupPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        AppNode lastUpdatedUser = null;
        long lastUpdatedTime = 0;


        for (AppNode user: ((UserNode) mainUserNode).getUsers()){

            long userUpdateTime = ((UserNode) user).getLastUpdatedTime();

            if (lastUpdatedTime < userUpdateTime){
                lastUpdatedTime = userUpdateTime;
                lastUpdatedUser = user;
           }
        }

        Date lastUpdate = new Date(lastUpdatedTime);

        userGroupPanel.getValidateTextArea().setText(
                "Last Updated User:\n" + lastUpdatedUser.getNodeID() + "\n\n" +
                        "Time:\n" + lastUpdate.toString()
        );

    }
}
