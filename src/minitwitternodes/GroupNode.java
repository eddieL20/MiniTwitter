package minitwitternodes;

import visitors.StatsVisitor;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.List;

public class GroupNode extends DefaultMutableTreeNode implements AppNode {

    private String nodeID;
    private List<AppNode> userGroupMembers = new ArrayList<>();

    private final List<AppNode> Groups = new ArrayList<>();

    public GroupNode(String text){
        this.setUserObject(text);
        this.nodeID = text;
    }

    public boolean isLeaf(){
        return false;
    }

    public GroupNode(){}

    @Override
    public void accept(StatsVisitor visitor) {
        visitor.visitTreeGroupNode(this);
    }

    @Override
    public String getNodeID() {
        return nodeID;
    }

    @Override
    public void setNodeID(String nodeID) {
        this.nodeID = nodeID;
    }

    public List<AppNode> getUserGroupMembers() {
        return userGroupMembers;
    }

    public void setUserGroupMembers(AppNode appNode) {
        this.userGroupMembers.add(appNode);
    }

    public void setUserGroupMembers(List<AppNode> userGroupMembers) {
        this.userGroupMembers = userGroupMembers;
    }

    public List<AppNode> getGroups() {
        return Groups;
    }

    public void setGroups(GroupNode group) {
        Groups.add(group);
    }
}
