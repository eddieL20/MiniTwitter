package visitors;

import messages.Messages;
import messages.PositivePercentage;
import minitwitternodes.GroupNode;
import minitwitternodes.RootNode;
import minitwitternodes.UserNode;

public interface StatsVisitor {

    void visitTreeGroupNode(GroupNode groupNode);

    void visitUserTreeNode(UserNode userNode);

    void visitMessages(Messages messages);

    void visitShowPositivePercentage(PositivePercentage positivePercentage);

    void visitRoot(RootNode rootNode);
}
