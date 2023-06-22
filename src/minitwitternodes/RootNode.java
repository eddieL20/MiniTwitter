package minitwitternodes;

import visitors.StatsVisitor;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.List;

public class RootNode extends DefaultMutableTreeNode implements AppNode {

    private static RootNode pointer;
    private String nodeID;
    private List<GroupNode> groups = new ArrayList<>();
    private List<UserNode> users = new ArrayList<>();

    public static RootNode getInstance(){
        if (pointer == null){ pointer = new RootNode(); }
        return pointer;
    }

    private RootNode(){}

    @Override
    public void accept(StatsVisitor visitor) {
        visitor.visitRoot(this);
    }

    public void setText(String text){
        this.setUserObject(text);
    }

    @Override
    public String getNodeID() {
        return nodeID;
    }

    @Override
    public void setNodeID(String nodeID) {
        this.nodeID = nodeID;
    }

    public List<GroupNode> getGroups() {
        return groups;
    }

    public void setGroups(GroupNode group) {
        this.groups.add(group);
    }

    public List<UserNode> getUsers() {
        return users;
    }

    public void setUsers(UserNode user) {
        this.users.add(user);
    }
}
