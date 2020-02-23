package GUI;
import javax.swing.JMenuBar;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import chess.*;
import chess.Position;

import chess.Piece;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JToggleButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class boardGUI {
	private boolean undoable = false;
	private JFrame frame;
	private int whiteScore = 0;
	private int blackScore = 0;
	private int turn = 0;
	private String previousName;
	JLabel wscoreLabel = new JLabel("  0");
	JLabel bscoreLabel = new JLabel("  0");
	Rule rule = new Rule();
	Board board = new Board();
	Piece[][] chess = board.newboard;
	test t = new test();
	JButton[][] buttonBoard = new JButton[8][8];
	JPanel boardPanel = new JPanel();

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
		//ActionListener pressedButton = 
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * set up panels for main board and player
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		boardPanel.setLayout(new GridLayout(8, 8, 1, 1));
		refreshboard(boardPanel);
		frame.getContentPane().add(boardPanel,BorderLayout.CENTER);
		
		JMenuBar startMenu = new JMenuBar();
		frame.setJMenuBar(startMenu);
		JMenu mnGame = new JMenu("Game");
		mnGame.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		startMenu.add(mnGame);
		
		JMenuItem mntmRestart = new JMenuItem("Restart");
		mntmRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restart(frame);} } );
			
		mntmRestart.setFont(new Font("Segoe UI", Font.PLAIN, 28));
		mnGame.add(mntmRestart);
		
		JMenuItem mforfeit = new JMenuItem("Forfeit");
		mforfeit.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						forfeit(frame);} }
				);
		mforfeit.setFont(new Font("Segoe UI", Font.PLAIN, 28));
		mnGame.add(mforfeit);
		
		JMenuItem mnewGame = new JMenuItem("New Game");
		mnewGame.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						newGame(frame);} }
				);
		mnewGame.setFont(new Font("Segoe UI", Font.PLAIN, 28));
		mnGame.add(mnewGame);
		
		JMenuItem mundo = new JMenuItem("Undo");
		mundo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				undo();} } );
			
		mundo.setFont(new Font("Segoe UI", Font.PLAIN, 28));
		mnGame.add(mundo);
		
		JPanel left = new JPanel();
		frame.getContentPane().add(left,BorderLayout.WEST);
		left.setLayout(new GridLayout(4,1,1,1));
		leftsetup(left);
		
		
		JPanel right = new JPanel();
		frame.getContentPane().add(right,BorderLayout.EAST);
		right.setLayout(new GridLayout(4,1,1,1));
		rightsetup(right);
		
		// white score
		
		
	}
	
	
	
	
	// white player socre panel
	void leftsetup(JPanel p) {
		JLabel lblNewLabel = new JLabel("  White :");
		p.add(lblNewLabel);
		
		JLabel nameOne = new JLabel("  Player white ");
		p.add(nameOne);
		
		
		JLabel scoretextLabel = new JLabel("  score :");
		p.add(scoretextLabel);		
		p.add(wscoreLabel);	
	}
	
	//black player panel
	void rightsetup(JPanel p) {
		JLabel lblNewLabel = new JLabel("  Black :");
		p.add(lblNewLabel);
		

		JLabel nameTwo = new JLabel("  Player black ");
		p.add(nameTwo);
		
		JLabel scoretextLabel = new JLabel("  score :");
		p.add(scoretextLabel);
		p.add(bscoreLabel);
		
	}
	
	
	

	
	// re initialize the board to original look
public	void refreshboard(JPanel panel) {
		String root = "D:\\cs242\\sp20-cs242-assignment1\\cs242-assignment1\\chess\\img\\";
		Board board = new Board();
		Piece[][] chess = board.newboard;
		String path;
		JButton button;
		ImageIcon cur;
		for (int j = 0; j< 8; j++) {
			for (int i = 0; i<8; i++) {
				if (chess[i][j] == null) {
					button = new JButton("");
					button.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							actionRule(e);
						}
					});
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
					panel.add(button);
					button.putClientProperty("x", i);
					button.putClientProperty("y", j);
					buttonBoard[i][j] = button;
					
					
				}
				else if (chess[i][j].color == 0) {  // white
					path = root+"white"+chess[i][j].name+".png";
					cur = new ImageIcon(path);
					button = new JButton(cur);
					button.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							actionRule(e);
						}
					});
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
					panel.add(button);
					button.putClientProperty("x", i);
					button.putClientProperty("y", j);
					buttonBoard[i][j] = button;
					
				}
				else {
					path = root+"black"+chess[i][j].name+".png";
					cur = new ImageIcon(path);
					button = new JButton(cur);
					button.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							actionRule(e);
						}
					});
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
					panel.add(button);
					button.putClientProperty("x", i);
					button.putClientProperty("y", j);
					buttonBoard[i][j] = button;
				}
				
			}
		}
}

// same as refresh.
	public void restart(JFrame frame) {
		JPanel newboardpanel=new JPanel();
		newboardpanel.setLayout(new GridLayout(8, 8, 1, 1));
		refreshboard(newboardpanel);
	    frame.getContentPane().remove(boardPanel);
	    frame.getContentPane().add(newboardpanel, BorderLayout.CENTER); 
	    boardPanel=newboardpanel;
	    frame.getContentPane().revalidate();
	    board=new Board();
	    rule=new Rule();
	    chess=board.newboard;
	    turn=0;
	}
	
	// resart and clean records
	public void newGame(JFrame frame) {
		whiteScore =0;
		blackScore =0;
		wscoreLabel.setText(""+whiteScore);
		bscoreLabel.setText(""+blackScore);
		restart(frame);
	}
	
	// quit game and loose
	
	public void forfeit(JFrame frame) {
		if (turn == 1) {
			whiteScore++;
			wscoreLabel.setText(""+whiteScore);
		}
		else {
			blackScore++;
			bscoreLabel.setText(""+blackScore);
		}
		restart(frame);
		
	}
	
	private JButton moved = null;
	private int xfrom;
	private int yfrom;
	ImageIcon fromImage = new ImageIcon();
	ImageIcon toImage = new ImageIcon();
	
	private int xto;
	private int yto;
	
	// cnacel last movement in ones turn
	public void undo() {
		if (!undoable) {
			return;
		}
		else {
			Piece piece = chess[xto][yto];
			piece.position.setx(xfrom);
			piece.position.sety(yfrom);
			chess[xfrom][yfrom] = piece;
			if (piece.name == "pawn" && (piece.position.gety()==1||piece.position.gety()==6)) {
				Pawn paw = (Pawn) piece;
				paw.ifmoved = false;
				
			}
			buttonBoard[xfrom][yfrom].setIcon(toImage);
			if(fromImage!= null) {
				buttonBoard[xto][yto].setIcon(fromImage);
				t.add(chess,Math.abs(turn),previousName,xto,yto);
			}
			else {
				chess[xto][yto] = null;
				buttonBoard[xto][yto].setIcon(null);
			}
			// set image icon and then add to board
	
			//
			turn = Math.abs(turn-1);
			
			
			
			//
		}
	}
	

	
	private void actionRule(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		int cur_x = (int)button.getClientProperty("x");
		int cur_y = (int)button.getClientProperty("y");
		
		if (moved == null) { // this is the piece to move
			if (chess[cur_x][cur_y]== null||turn!=chess[cur_x][cur_y].color)
				return;
			else {
				moved = button;
				xfrom = cur_x;
				yfrom = cur_y;
			}
		}
		else {
			xto = cur_x;
			yto = cur_y;
			if (button == moved)
				return;
			if (chess[xto][yto]!=null)
				previousName = chess[xto][yto].name;
			int res = rule.moveto(chess[xfrom][yfrom], chess, xto, yto);
			if (res == 1) {
				// add pic
				ImageIcon cur = (ImageIcon) moved.getIcon();
				toImage = (ImageIcon) moved.getIcon();
				fromImage = (ImageIcon)button.getIcon();
				button.setIcon(cur);
				moved.setIcon(null);
				moved = null;
				turn = Math.abs(turn-1);
				undoable = true;
				
				return;
			}
			else if (res == 2) {
				previousName = null;
				if (turn==1) {
					blackScore++;
					bscoreLabel.setText(""+blackScore);
				}
				else {
					whiteScore++;
					wscoreLabel.setText(""+whiteScore);
				}
				System.out.println(blackScore);
				restart(frame);
			}
			else {
				previousName = null;
				showMessageDialog(null, "illegal move");
				moved = null;
				return;
			}
		}
		
	}
}
