package compositenodes;

import observers.Observer;
import visitors.StatsVisitor;

import java.util.ArrayList;
import java.util.List;

public class Messages implements AppNode {

    private String nodeID;
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public String getNodeID() {
        return nodeID;
    }

    @Override
    public void setNodeID(String nodeID) {
        this.nodeID = nodeID;
    }

    private final List<String> messages = new ArrayList<>();


    public List<String> getMessages(){ return messages; }

    public void setMessages(UserNode user, String message){
        message = user.getNodeID() + ": " + message; // formats message as "userID: message..."
        messages.add(message);

        user.setLastUpdatedTime(); // new update time for user that posted message

        for (AppNode follower: user.getFollowers()){
            ((UserNode) follower).setLastUpdatedTime(); // new update time for all the followers
        }

        notifyObservers(); // notify any observers
    }

    public void accept(StatsVisitor visitor){ visitor.visitMessages(this);}

    // used for observers to get added as subscribers
    public void subscribe(Observer observer){
        this.observers.add(observer);
        notifyObservers();
    }


    // Notifies all te observers
    public void notifyObservers(){ for (Observer observer: observers) observer.update(this); }
}
