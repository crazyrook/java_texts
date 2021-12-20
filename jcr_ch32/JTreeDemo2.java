//Demonstrate JTree
import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;
import javax.swing.tree.*;

public class JTreeDemo2{

	public JTreeDemo2(){

		//Set up the JFrame. Use default BorderLayout.
		JFrame jfrm = new JFrame("JTreeDemo");
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setSize(200, 250);

		//Create subtree of tree.
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("Options");

		//Create subtree of "A".
		top.add(new DefaultMutableTreeNode("A"));
		DefaultMutableTreeNode a = top.getLastLeaf();
		DefaultMutableTreeNode a1 = new DefaultMutableTreeNode("A1");
		a.add(a1);
		DefaultMutableTreeNode a2 = new DefaultMutableTreeNode("A2");
		a.add(a2);

		//Create subtree of "B".
		top.add(new DefaultMutableTreeNode("B") );
		DefaultMutableTreeNode b = top.getLastLeaf();
		DefaultMutableTreeNode b1 = new DefaultMutableTreeNode("B11");
		b.add(b1);
		DefaultMutableTreeNode b2 = new DefaultMutableTreeNode("B22");
		b.add(b2);
		DefaultMutableTreeNode b3 = new DefaultMutableTreeNode("B33");
		b.add(b3);

		// Create the tree.
		JTree tree = new JTree(top);

		//Add the tree to a scroll pane.
		JScrollPane jsp = new JScrollPane(tree);

		//Add the scroll pane to the content pane.
		jfrm.add(jsp);

		//Add the label to the content pane.
		JLabel jlab = new JLabel();
		jfrm.add(jlab, BorderLayout.SOUTH);

		//B's fix
		//class bfix extends TreeSelectionListener{
		//	public void valueChange(TreeSelectionEvent tse) {
		//		jlab.setText("Selection is " + tse.getPath() );
		//	}
		//}

		//Handle tree selection events.
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent tse) {
				jlab.setText("Selection is " + tse.getPath() );
			}
		});

		//tree.addTreeSelectionListener(new bfix() );

		//Display the frame.
		jfrm.setVisible(true);
	}

	public static void main(String[] args){
		//Create the frame on the event dispatching thread.

		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new JTreeDemo2();
			}
		});
	}
}