package actionlisteners;

import messages.Messages;
import messages.PositivePercentage;
import visitors.CountVisitor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PositivePercentageListener implements ActionListener {

    public Messages messages;

    public PositivePercentageListener(Messages messages){
        this.messages = messages;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CountVisitor positivePercentVisitor = new CountVisitor();

        messages.accept(positivePercentVisitor);

        float positivePercentage = positivePercentVisitor.getPositivePercentage();

        String formattedNum = String.format("%.2f", positivePercentage);

        String percentMassage = "Total Positive Messages: " + formattedNum + "%";

        JLabel userMessageLabel = new JLabel(percentMassage);

        JFrame frame = new JFrame("Positive Messages");
        frame.setSize(225, 100);
        frame.setResizable(false);
        frame.setVisible(true);

        frame.add(userMessageLabel);

    }
}
