package GUI;
import chess.*;
import chess.piece;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
public class boardGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					boardGUI window = new boardGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the application.
	 */
	public boardGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().setLayout(new GridLayout(8, 8, 1, 1));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		refreshboard();
		
	}
	
	
	
	
	
	
	
	
	
	

	
	
	void refreshboard() {
		String root = "D:\\cs242\\sp20-cs242-assignment1\\cs242-assignment1\\chess\\img\\";
		board board = new board();
		piece[][] chess = board.newboard;
		String path;
		JButton button;
		ImageIcon cur;
		for (int j = 0; j< 8; j++) {
			for (int i = 0; i<8; i++) {
				if (chess[i][j] == null) {
					button = new JButton("");
					if (j%2 ==0) {
						if (i%2 == 0)
						button.setBackground(Color.gray);
						else button.setBackground(Color.white);
					}
					else {
						if (i%2 ==0) 
						button.setBackground(Color.white);
						else
							button.setBackground(Color.gray);
					}
					frame.getContentPane().add(button);
					
				}
				else if (chess[i][j].color == 0) {  // white
					path = root+"white"+chess[i][j].name+".png";
					cur = new ImageIcon(path);
					button = new JButton(cur);
					if (j%2 ==0) {
						if (i%2 == 0)
						button.setBackground(Color.gray);
						else button.setBackground(Color.white);
					}
					else {
						if (i%2 ==0) 
						button.setBackground(Color.white);
						else
							button.setBackground(Color.gray);
					}
					frame.getContentPane().add(button);
					
				}
				else {
					path = root+"black"+chess[i][j].name+".png";
					cur = new ImageIcon(path);
					button = new JButton(cur);
					if (j%2 ==0) {
						if (i%2 == 0)
						button.setBackground(Color.gray);
						else button.setBackground(Color.white);
					}
					else {
						if (i%2 ==0) 
						button.setBackground(Color.white);
						else
							button.setBackground(Color.gray);
					}
					frame.getContentPane().add(button);
				}
				
			}
		}
		

		

		
	}

}
