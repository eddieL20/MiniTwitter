package visitors;

import messages.Messages;
import messages.PositivePercentage;
import minitwitternodes.GroupNode;
import minitwitternodes.RootNode;
import minitwitternodes.UserNode;

public class CountVisitor implements StatsVisitor {

    private static int userCount;

    private static int groupCount;

    private static int messageCount;

    private static int percentage;

    @Override
    public void visitTreeGroupNode(GroupNode groupNode) {
        groupCount = groupNode.getGroups().size();
    }

    @Override
    public void visitUserTreeNode(UserNode userNode) {
        userCount = userNode.getUsers().size();
    }

    @Override
    public void visitMessages(Messages messages) {
        messageCount = messages.getMessages().size();
    }

    @Override
    public void visitShowPositivePercentage(PositivePercentage positivePercentage) {

    }

    public int getUserCount() {
        return userCount;
    }

    public int getGroupCount() {
        return groupCount;
    }

    public int getPercentage() {
        return percentage;
    }

    @Override
    public void visitRoot(RootNode rootNode) {

    }
}
