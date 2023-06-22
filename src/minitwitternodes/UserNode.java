package minitwitternodes;

import observer.Observer;
import visitors.StatsVisitor;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.List;

public class UserNode extends DefaultMutableTreeNode implements AppNode {

    private String nodeID;
    private List<AppNode> followers = new ArrayList<>();
    private List<AppNode> following = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();
    private List<AppNode> Users = new ArrayList<>();

    public UserNode(String text){
        this.setUserObject(text);
        this.nodeID = text;
    }

    public UserNode(){}


    @Override
    public String getNodeID() { return nodeID; }

    @Override
    public void setNodeID(String nodeID) { this.nodeID = nodeID; }

    public List<AppNode> getFollowers() { return followers; }

    public void setFollowers(AppNode follower) {
        this.followers.add(follower);
        notifyObservers();
    }

    public List<AppNode> getFollowing() {
        notifyObservers();
        return following;
    }

    public void setFollowing(List<AppNode> following) { this.following = following; }

    public List<AppNode> getUsers() {
        return Users;
    }

    public  void setUsers(UserNode userNode) {
        this.Users.add(userNode);
    }

    // Implement Observer Pattern with the following three methods

    @Override
    public void accept(StatsVisitor visitor) { visitor.visitUserTreeNode(this); }

    public void subscribe(Observer observer){
        this.observers.add(observer);
        notifyObservers();
    }

    public void unsubscribe(Observer observer){ this.observers.remove(observer); }

    public void notifyObservers(){ for (Observer observer: observers) observer.update(this); }
}
