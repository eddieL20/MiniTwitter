package messages;

import minitwitternodes.AppNode;
import minitwitternodes.UserNode;
import observer.Observer;
import visitors.StatsVisitor;

import java.util.ArrayList;
import java.util.List;

public class Messages implements AppNode {

    private String nodeID;
    private List<Observer> observers = new ArrayList<>();

    @Override
    public String getNodeID() {
        return null;
    }

    @Override
    public void setNodeID(String nodeID) {

    }

    private List<String> messages = new ArrayList<>();


    public List<String> getMessages(){ return messages; }

    public void setMessages(UserNode user, String message){
        message = user.getNodeID() + ": " + message;
        messages.add(message);
        notifyObservers();
    }

    public void accept(StatsVisitor visitor){ visitor.visitMessages(this);}

    public void subscribe(Observer observer){
        this.observers.add(observer);
        notifyObservers();
    }

    public void unsubscribe(Observer observer){
        this.observers.remove(observer);
    }


    public void notifyObservers(){ for (Observer observer: observers) observer.update(this); }
}
