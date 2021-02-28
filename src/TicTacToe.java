
/**
 * Tic Tac Toe game
 * @author Julie 
 * Start Date : May 14, 2020
 * 
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TicTacToe extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btn1;
	private JButton btn9;
	private JButton btn8;
	private JButton btn7;
	private JButton btn6;
	private JButton btn5;
	private JButton btn4;
	private JButton btn3;
	private JButton btn2;
	private JButton btnStart;
	String player = "X";
	String[][] table;
	private JLabel lblPlayer;
	private JLabel lblNewLabel;
	private JList<String> lstResult;
	private JButton btnNew;
	DefaultListModel<String> list = new DefaultListModel<String>();
	private boolean firstRec = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToe frame = new TicTacToe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void init() {
		table = new String[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				table[i][j] = "";
			}
		}
		btn1.setText(table[0][0]);
		btn2.setText(table[0][1]);
		btn3.setText(table[0][2]);
		btn4.setText(table[1][0]);
		btn5.setText(table[1][1]);
		btn6.setText(table[1][2]);
		btn7.setText(table[2][0]);
		btn8.setText(table[2][1]);
		btn9.setText(table[2][2]);
	}

	public void checkWinner() {
		table[0][0] = btn1.getText();
		table[0][1] = btn2.getText();
		table[0][2] = btn3.getText();
		table[1][0] = btn4.getText();
		table[1][1] = btn5.getText();
		table[1][2] = btn6.getText();
		table[2][0] = btn7.getText();
		table[2][1] = btn8.getText();
		table[2][2] = btn9.getText();
		boolean win = false;
		for (int i = 0; i < 3; i++) {
			int j = 0;
			if (table[i][j] != "" && table[i][j].equals(table[i][j + 1]) && table[i][j].equals(table[i][j + 2])) {
				JOptionPane.showMessageDialog(null, "Player " + player + " is a Winner");
				lblPlayer.setText("");
				win = true;
			}

			if (table[j][i] != "" && table[j][i].equals(table[j + 1][i]) && table[j][i].equals(table[j + 2][i])) {
				JOptionPane.showMessageDialog(null, "Player " + player + " is a Winner");
				lblPlayer.setText("");
				win = true;
			}
		}
		if (table[0][0] != "" && table[0][0].equals(table[1][1]) && table[0][0].equals(table[2][2])) {
			JOptionPane.showMessageDialog(null, "Player " + player + " is a Winner");
			lblPlayer.setText("");
			win = true;
		}

		if (table[0][2] != "" && table[0][2].equals(table[1][1]) && table[2][0].equals(table[1][1])) {
			JOptionPane.showMessageDialog(null, "Player " + player + " is a Winner");
			lblPlayer.setText("");
			win = true;
		}

		if(win!=true) {
			int count = 0;
			for (int i = 0; i <= 2; i++) {
				for (int j = 0; j <= 2; j++) {
					if (!table[i][j].isEmpty())
						count++;
				}
			}
			if (count == 9) {
				JOptionPane.showMessageDialog(null, "Tie game. Plase start the game again");
				lblPlayer.setText("");
			}
				
		}

	}

	public void playGame(JButton btn) {

		if (firstRec) {
			if (btn.getText() == "") {
				if (player.equals("X")) {
					btn.setText("X");
					checkWinner();
					player = "O";
					lblPlayer.setText("Player 2");
				} else if (player.equals("O")) {
					btn.setText("O");
					checkWinner();
					player = "X";
					lblPlayer.setText("Player 1");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Already selected");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Plase click the 'Start Game' button");
		}

	}

	public void createEvents() {
		init();
		player = "X";

		list.addElement("Let's play Tic Tac Toe");
		list.addElement("Plase click the start button");
		lstResult.setModel(list);

		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				firstRec = true;
				list.removeAllElements();
				list.addElement("Player 1 : X ");
				list.addElement("Player 2 : O ");
				list.addElement("Player 1 starts first");
			}
		});

		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int answer = JOptionPane.showConfirmDialog(null, "Do you really want to a new game?");
				if (answer == 0) {
					init();
					player = "X";
					list.clear();
					list.addElement("Player 1 : X ");
					list.addElement("Player 2 : O ");
					list.addElement("Player 1 starts first");
					lblPlayer.setText("Player 1");
				}
			}
		});

		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playGame(btn1);
			}
		});
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playGame(btn2);
			}
		});
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playGame(btn3);
			}
		});

		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playGame(btn4);
			}
		});

		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playGame(btn5);
			}
		});

		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playGame(btn6);
			}
		});

		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playGame(btn7);
			}
		});

		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playGame(btn8);
			}
		});

		btn9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playGame(btn9);
			}
		});

	}

	public void setUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 908, 612);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		btnStart = new JButton("Start Game");

		JLabel lblPlayerInfo = new JLabel("Player : ");

		lblPlayer = new JLabel("Player");

		lblNewLabel = new JLabel("Player 1 VS Player 2");

		JScrollPane scrollPane = new JScrollPane();

		btnNew = new JButton("New Game");

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(72)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE).addGap(39)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblPlayerInfo)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblPlayer, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(64, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(99)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel).addGap(42)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblPlayerInfo).addComponent(lblPlayer))
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
								.addGap(28)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 54,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 54,
												GroupLayout.PREFERRED_SIZE)))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(208, Short.MAX_VALUE)));

		lstResult = new JList();
		scrollPane.setViewportView(lstResult);

		btn1 = new JButton("");

		buttonGroup.add(btn1);

		btn2 = new JButton("");

		buttonGroup.add(btn2);

		btn3 = new JButton("");

		buttonGroup.add(btn3);

		btn7 = new JButton("");

		buttonGroup.add(btn7);

		btn8 = new JButton("");

		buttonGroup.add(btn8);

		btn9 = new JButton("");

		buttonGroup.add(btn9);

		btn4 = new JButton("");

		buttonGroup.add(btn4);

		btn5 = new JButton("");

		buttonGroup.add(btn5);

		btn6 = new JButton("");

		buttonGroup.add(btn6);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel.createSequentialGroup().addGap(35)
										.addGroup(gl_panel
												.createParallelGroup(
														Alignment.TRAILING)
												.addGroup(gl_panel.createSequentialGroup()
														.addComponent(btn7, GroupLayout.PREFERRED_SIZE, 80,
																GroupLayout.PREFERRED_SIZE)
														.addGap(45)
														.addComponent(btn8, GroupLayout.PREFERRED_SIZE, 80,
																GroupLayout.PREFERRED_SIZE)
														.addGap(43).addComponent(
																btn9, GroupLayout.PREFERRED_SIZE, 80,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(
														gl_panel.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_panel.createSequentialGroup()
																		.addComponent(btn4, GroupLayout.PREFERRED_SIZE,
																				80, GroupLayout.PREFERRED_SIZE)
																		.addGap(45)
																		.addComponent(btn5, GroupLayout.PREFERRED_SIZE,
																				80, GroupLayout.PREFERRED_SIZE)
																		.addGap(43)
																		.addComponent(btn6, GroupLayout.PREFERRED_SIZE,
																				80, GroupLayout.PREFERRED_SIZE))
																.addGroup(gl_panel.createSequentialGroup()
																		.addComponent(btn1, GroupLayout.PREFERRED_SIZE,
																				80, GroupLayout.PREFERRED_SIZE)
																		.addGap(45)
																		.addComponent(btn2, GroupLayout.PREFERRED_SIZE,
																				80, GroupLayout.PREFERRED_SIZE)
																		.addGap(43).addComponent(btn3,
																				GroupLayout.PREFERRED_SIZE, 80,
																				GroupLayout.PREFERRED_SIZE))))
										.addGap(38)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(40)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btn3, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn2, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
						.addGap(41)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btn4, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn5, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn6, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
						.addGap(47)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btn7, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn8, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn9, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(161, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	public TicTacToe() {
		setTitle("Let's play Tic Tac Toe");
		setUp();
		createEvents();
	}
}
