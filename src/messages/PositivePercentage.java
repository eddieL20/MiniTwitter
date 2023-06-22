package messages;

import java.util.List;

public class PositivePercentage {

    private float percentage;

    private List<String> positiveKeywords = List.of("awesome", "great", "cool", "liked");

    public  float getPercentage(Messages messages){

        float totalMessages = (float) messages.getMessages().size();
        float positiveCount = 0;

        for (String message: messages.getMessages()){
            for (String keyword: positiveKeywords){
                if (message.contains(keyword)){
                    positiveCount++;
                }
            }
        }
        percentage = (positiveCount / totalMessages) * 100;
        return percentage;
    }
}
