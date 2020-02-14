package GUI;

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
		ImageIcon br = new ImageIcon("D:\\cs242\\sp20-cs242-assignment1\\cs242-assignment1\\chess\\img\\blackRook.png");
		ImageIcon bb= new ImageIcon("D:\\cs242\\sp20-cs242-assignment1\\cs242-assignment1\\chess\\img\\blackBishop.png");
		ImageIcon bking= new ImageIcon("D:\\cs242\\sp20-cs242-assignment1\\cs242-assignment1\\chess\\img\\blackKing.png");
		ImageIcon bknight= new ImageIcon("D:\\cs242\\sp20-cs242-assignment1\\cs242-assignment1\\chess\\img\\blackKnight.png");
		ImageIcon bp= new ImageIcon("D:\\cs242\\sp20-cs242-assignment1\\cs242-assignment1\\chess\\img\\blackPawn.png");
		ImageIcon bq= new ImageIcon("D:\\cs242\\sp20-cs242-assignment1\\cs242-assignment1\\chess\\img\\blackQueen.png");
		
		ImageIcon wr= new ImageIcon("D:\\cs242\\sp20-cs242-assignment1\\cs242-assignment1\\chess\\img\\whiteRook.png");
		ImageIcon wb= new ImageIcon("D:\\cs242\\sp20-cs242-assignment1\\cs242-assignment1\\chess\\img\\whiteBishop.png");
		ImageIcon wking= new ImageIcon("D:\\cs242\\sp20-cs242-assignment1\\cs242-assignment1\\chess\\img\\whiteKing.png");
		ImageIcon wknight= new ImageIcon("D:\\cs242\\sp20-cs242-assignment1\\cs242-assignment1\\chess\\img\\whiteKnight.png");
		ImageIcon wp= new ImageIcon("D:\\cs242\\sp20-cs242-assignment1\\cs242-assignment1\\chess\\img\\whitePawn.png");
		ImageIcon wq= new ImageIcon("D:\\cs242\\sp20-cs242-assignment1\\cs242-assignment1\\chess\\img\\whiteQueen.png");
		
		ImageIcon[] blackIconArr=new ImageIcon[32];
		blackIconArr[0]=br;
		blackIconArr[1]=bb;
		blackIconArr[2]=bq;
		blackIconArr[3]=bknight;
		blackIconArr[4]=bp;
		blackIconArr[5]=bp;
		blackIconArr[6]=bp;
		blackIconArr[7]=bp;
		blackIconArr[24]=wp;
		blackIconArr[25]=wp;
		blackIconArr[26]=wp;
		blackIconArr[27]=wp;
		blackIconArr[28]=wknight;
		blackIconArr[29]=wking;
		blackIconArr[30]=wb;
		blackIconArr[31]=wr;
		
		ImageIcon[] whiteIconArr=new ImageIcon[32];
		whiteIconArr[0]=bknight;
		whiteIconArr[1]=bking;
		whiteIconArr[2]=bb;
		whiteIconArr[3]=br;
		whiteIconArr[4]=bp;
		whiteIconArr[5]=bp;
		whiteIconArr[6]=bp;
		whiteIconArr[7]=bp;
		whiteIconArr[24]=wp;
		whiteIconArr[25]=wp;
		whiteIconArr[26]=wp;
		whiteIconArr[27]=wp;
		whiteIconArr[28]=wr;
		whiteIconArr[29]=wb;
		whiteIconArr[30]=wq;
		whiteIconArr[31]=wknight;
		
		
		JButton[] blackButtons = new JButton[32];
		JButton[] whiteButtons = new JButton[32];

		for(int i = 0; i < blackButtons.length; i++)
		{	
			ImageIcon ic=blackIconArr[i];
			if (ic==null)
				blackButtons[i] = new JButton("");
			else
				blackButtons[i] = new JButton(ic);
		    blackButtons[i].setBackground(Color.GRAY);
		    //blackButtons[i].setFont(new Font("Arial", Font.PLAIN, 40));
		    
		}
		for(int i = 0; i < whiteButtons.length; i++)
		{
			ImageIcon ic=whiteIconArr[i];
			if (ic==null)
				whiteButtons[i] = new JButton("");
			else
				whiteButtons[i] = new JButton(ic);
		    whiteButtons[i].setBackground(Color.WHITE);
		    //blackButtons[i].setFont(new Font("Arial", Font.PLAIN, 40));
		}
		
		// add buttons
		for (int i = 0; i < 8; i++) {
		    if (i % 2 == 0) {
		        for (int j = 0; j < 4; j++) {
		            frame.getContentPane().add(blackButtons[4 * i + j]);
		            frame.getContentPane().add(whiteButtons[4 * i + j]);
		        }
		    } else {
		        for (int j = 0; j < 4; j++) {
		            frame.getContentPane().add(whiteButtons[4 * i + j]);
		            frame.getContentPane().add(blackButtons[4 * i + j]);
		        }
		    }
		}
	}

}
