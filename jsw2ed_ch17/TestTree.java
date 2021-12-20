//TestTree.java
//A simple test to see how we can build a tree and populate import junit.framework.TestCase;
//
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;

public class TestTree extends JFrame{

	JTree tree;
	DefaultTreeModel treeModel;

	public TestTree(){
		super("Tree Test Example");
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void init(){
		//Build up a bunch of TreeNodes. We use DefaultMutableTreeNode because the
		//DefaultTreeModel can use it to build a complete tree.
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
		DefaultMutableTreeNode subroot = new DefaultMutableTreeNode("SubRoot");
		DefaultMutableTreeNode leaf1 = new DefaultMutableTreeNode("Leaf 1");
		DefaultMutableTreeNode leaf2 = new DefaultMutableTreeNode("Leaf 2");
		//Build our tree model starting at the root node, and then make a JTree out
		// of it.
		treeModel = new DefaultTreeModel(root);
		tree = new JTree(treeModel);

		//Build the tree up from the nodes we created.
		treeModel.insertNodeInto(subroot, root, 0);
		//Or, more succinctly:
		subroot.add(leaf1);
		root.add(leaf2);

		//Display it.
		getContentPane().add(tree, BorderLayout.CENTER);

		//Create and add our message label for the selection output.
		final JLabel messageLabel = new JLabel("Nothing selected.");
		add(messageLabel, BorderLayout.SOUTH);

		//Add our selection listener and have it report to
		//our messageLabel.
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent tse){
				TreePath tp = tse.getNewLeadSelectionPath();
				messageLabel.setText("Selected: " + tp.getLastPathComponent() );
			}
		});
	}

	public static void main(String args[]){
		TestTree tt = new TestTree();
		tt.init();
		tt.setVisible(true);
	}
}