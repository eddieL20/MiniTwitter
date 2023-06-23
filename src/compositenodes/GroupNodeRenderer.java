package compositenodes;

import compositenodes.GroupNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class GroupNodeRenderer extends DefaultTreeCellRenderer {

    private Icon folderIcon;

    public GroupNodeRenderer() {
        folderIcon = UIManager.getIcon("Tree.closedIcon"); // sets the folder icon
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
                                                  boolean leaf, int row, boolean hasFocus) {

        super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);

        // Check if the node is an instance of GroupNode
        if (value instanceof GroupNode) {
            setIcon(folderIcon); // Set the folder icon for GroupNode
        }

        return this;
    }
}
