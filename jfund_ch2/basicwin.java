import javax.swing.*; // Access JFrame and JPanel
import java.awt.*; // For Color and Container
public class basicwin{
	public static void main(String[] args){
		JFrame win = new JFrame();
		win.setTitle("Basic Window");
		win.setSize(300, 200);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pannel = new JPanel();
		pannel.setBackground(Color.pink);
		Container pane = win.getContentPane();
		pane.add(pannel);
		win.setVisible(true);
	}
}