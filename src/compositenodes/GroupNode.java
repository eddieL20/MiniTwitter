package compositenodes;

import visitors.StatsVisitor;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.List;

public class GroupNode extends DefaultMutableTreeNode implements AppNode {

    private String nodeID;
    private final List<AppNode> userGroupMembers = new ArrayList<>();
    private final List<AppNode> Groups = new ArrayList<>();
    private long creationTime;

    public GroupNode(String text){
        this.setUserObject(text);
        this.nodeID = text;
        setCreationTime(); // set creation time when constructor is used
    }


    public GroupNode(){
        setCreationTime(); // set creation time when constructor is used
    }

    // used to render the folder icon on the tree
    public boolean isLeaf(){ return false; }

    // method used to accept visitors
    @Override
    public void accept(StatsVisitor visitor) { visitor.visitTreeGroupNode(this); }

    @Override
    public String getNodeID() { return nodeID; }

    @Override
    public void setNodeID(String nodeID) {
        this.nodeID = nodeID;
    }

    public void setUserGroupMembers(AppNode appNode) {
        this.userGroupMembers.add(appNode);
    }

    public List<AppNode> getGroups() {
        return Groups;
    }

    public void setGroups(GroupNode group) {
        Groups.add(group);
    }

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime() {
        this.creationTime = System.currentTimeMillis();
    }
}
