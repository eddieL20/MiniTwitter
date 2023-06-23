package compositenodes;

import visitors.StatsVisitor;

public interface AppNode {

    String getNodeID();

    void accept(StatsVisitor visitor);

    void setNodeID(String nodeID);
}
