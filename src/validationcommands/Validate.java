package validationcommands;

import compositenodes.AppNode;
import compositenodes.GroupNode;
import compositenodes.UserNode;

import java.util.HashSet;
import java.util.Set;

public class Validate {

    AppNode appNode;

    public Validate(AppNode appNode){
        this.appNode = appNode;
    }

    public String checkSpace(){

        if (appNode instanceof UserNode){
            for (AppNode node: ((UserNode) appNode).getUsers()){
                if (node.getNodeID().contains(" ")){
                    return "Invalid User(s): Contains Spaces\n";
                }
            }
        } else if (appNode instanceof GroupNode){
            for (AppNode node: ((GroupNode)appNode).getGroups()){
                if(node.getNodeID().contains(" ")){
                    return "Invalid Group(s): Contains Spaces\n";
                }
            }
        }
        return "";
    }

    public String checkDuplicate(){
        Set<String> uniqueElements = new HashSet<>();

        if (appNode instanceof UserNode){
            for (AppNode node: ((UserNode) appNode).getUsers()){
                if (uniqueElements.contains(node.getNodeID())){
                    return "Invalid User(s): Contains Duplicates\n";
                }
                uniqueElements.add(node.getNodeID());
            }
        } else if (appNode instanceof GroupNode){
            for (AppNode node: ((GroupNode) appNode).getGroups()){
                if (uniqueElements.contains(node.getNodeID())){
                    return "Invalid Group(s): Contains Duplicates\n";
                }
                uniqueElements.add(node.getNodeID());
            }
        }
        return "";
    }
}
