package visitors;

import compositenodes.Messages;
import compositenodes.GroupNode;
import compositenodes.RootNode;
import compositenodes.UserNode;

public interface StatsVisitor {

    void visitTreeGroupNode(GroupNode groupNode);

    void visitUserTreeNode(UserNode userNode);

    void visitMessages(Messages messages);

    void visitRoot(RootNode rootNode);
}
