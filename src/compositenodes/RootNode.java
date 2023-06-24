package compositenodes;

import visitors.StatsVisitor;

import javax.swing.tree.DefaultMutableTreeNode;

public class RootNode extends DefaultMutableTreeNode implements AppNode {

    private static RootNode pointer;
    private String nodeID;

    // Creates only one instance of RootNode "Singleton Pattern"
    public static RootNode getInstance(){
        if (pointer == null){
            synchronized (RootNode.class){
                if (pointer == null){ pointer = new RootNode(); }
            }
        }
        return pointer;
    }

    private RootNode(){}

    @Override
    public void accept(StatsVisitor visitor) {
        visitor.visitRoot(this);
    }

    @Override
    public String getNodeID() {
        return nodeID;
    }

    @Override
    public void setNodeID(String nodeID) {
        this.nodeID = nodeID;
    }

}
