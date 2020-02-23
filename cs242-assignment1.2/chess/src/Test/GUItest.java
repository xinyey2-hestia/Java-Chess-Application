package Test;
import GUI.*;
import static org.junit.Assert.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.Test;

public class GUItest {

	@Test
	public void test() {
		boardGUI gt=new boardGUI();
		JPanel p=new JPanel();
		gt.refreshboard(p);
		
		JFrame frame = new JFrame();
		gt.initialize();
		
		gt.newGame(frame);
		gt.undo();
		gt.forfeit(frame);
	}

}
