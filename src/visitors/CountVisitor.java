package visitors;

import compositenodes.Messages;
import compositenodes.GroupNode;
import compositenodes.RootNode;
import compositenodes.UserNode;

import java.util.List;

public class CountVisitor implements StatsVisitor {

    private static int userCount;

    private static int groupCount;

    private Messages messages;

    private static int messageCount;

    private static float percentage;

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
        this.messages = messages;
        messageCount = messages.getMessages().size();
    }

    public float getPositivePercentage() {

        // list of words to check for each messages to count as a positive overall message
        List<String> positiveKeywords = List.of("awesome", "great", "cool", "like", "amazing");

        float positiveCount = 0; // keeps count of positive messages

        // check each message to see if it contains any of the keywords
        for (String message: messages.getMessages()){
            for (String keyword: positiveKeywords){
                if (message.contains(keyword)){
                    positiveCount++;
                }
            }
        }

        // format the result and return
        percentage = (positiveCount / messageCount) * 100;
        return percentage;
    }

    public int getUserCount() { return userCount; }

    public int getGroupCount() { return groupCount; }

    public int getMessageCount(){ return messageCount; }

    @Override
    public void visitRoot(RootNode rootNode) {

    }
}
