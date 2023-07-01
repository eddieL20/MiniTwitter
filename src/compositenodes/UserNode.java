package compositenodes;

import observers.Observer;
import visitors.StatsVisitor;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.List;

public class UserNode extends DefaultMutableTreeNode implements AppNode {

    private String nodeID;
    private final List<AppNode> following = new ArrayList<>();
    private final List<AppNode> followers = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();
    private final List<AppNode> Users = new ArrayList<>();
    private long creationTime;
    private long lastUpdatedTime;

    public UserNode(String text){
        this.setUserObject(text);
        this.nodeID = text;
        setCreationTime(); // set creation time when constructor is used
    }

    public UserNode(){
        setCreationTime(); // set creation time when constructor is used
    }


    @Override
    public String getNodeID() { return nodeID; }

    @Override
    public void setNodeID(String nodeID) { this.nodeID = nodeID; }

    public List<AppNode> getFollowing() {
        return following;
    }

    public void setFollowing(AppNode following) {
        this.following.add(following);
        notifyObservers();
    }

    public List<AppNode> getFollowers() { return followers; }

    public void setFollowers(AppNode node){ this.followers.add(node); }

    public List<AppNode> getUsers() { return Users; }

    public boolean isLeaf(){ return true; }

    public  void setUsers(UserNode userNode) { this.Users.add(userNode); }

    // Implement Observer Pattern with the following three methods

    @Override
    public void accept(StatsVisitor visitor) { visitor.visitUserTreeNode(this); }

    public void subscribe(Observer observer){
        this.observers.add(observer);
        notifyObservers();
    }

    public void notifyObservers(){ for (Observer observer: observers) observer.update(this); }

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime() {
        this.creationTime = System.currentTimeMillis();
        setLastUpdatedTime(); // set initial lastUpdatedTime to the creation time
    }

    public long getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime() {
        this.lastUpdatedTime = System.currentTimeMillis();
    }
}
