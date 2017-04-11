package eg.edu.guc.yugioh.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Phase;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.ChangeOfHeart;
import eg.edu.guc.yugioh.cards.spells.MagePower;
import eg.edu.guc.yugioh.cards.spells.MonsterReborn;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;

public class GUI extends JFrame implements MouseListener {

	// // 23ml sac list f deck buttons mouse click we 23mlha makan yzhr fi
	// monsters chosen to sacrifice

	int x;

	private boolean firstMons;

	JButton reStart;

	JLabel sacMSize;

	JLabel cardImage1;
	JLabel cardImage2;

	Board b = new Board();

	JLabel numbers;

	Component frame = null;

	Player pInfo1; // / player 1
	Player pInfo2; // / player 2

	private boolean trueAttack = true;
	private boolean sacrifice = true;
	private boolean activateSpell = true;
	private boolean switchIt = true;
	ArrayList<MonsterCard> sacM;

	JButton AorD;
	JButton sac;
	JButton addSpell;
	JButton switchCard;

	MonsterCard p1A;
	MonsterCard p2A;

	String pname1;
	String pname2;

	JLabel lPoints1;
	JLabel lPoints2;

	JLabel phaseP1;
	JLabel phaseP2;

	JLabel pgImage;

	JLabel infoLabel;

	JPanel pE;
	JLabel gO; // game Over picture
	JLabel winner;

	Font font;
	// //////////////////////////
	JPanel pS; // /theStart

	JButton playMusic;

	JLabel l1;
	JLabel l2;
	JTextField t1;
	JTextField t2;

	JButton b1;
	JButton b2;
	// //////////////////
	JPanel pG; // / the game
	JLabel mill;

	JPanel show;

	JButton eT; // /end Turn
	JButton eP; // /end Phase

	JPanel p1; // /player 1 Area

	JLabel pN1; // /playerName 1

	JPanel pD1;
	JPanel pG1;
	JPanel pH1;
	JPanel pM1;
	JPanel pS1;

	JButton[] deck1;
	JButton[] graveYard1;
	JButton[] hand1;
	JButton[] monsterArea1;
	JButton[] spellArea1;
	// //
	JPanel p2; // /player 2 Area

	JLabel pN2; // /playerName 2

	JPanel pD2;
	JPanel pG2;
	JPanel pH2;
	JPanel pM2;
	JPanel pS2;

	JButton[] deck2;
	JButton[] graveYard2;
	JButton[] hand2;
	JButton[] monsterArea2;
	JButton[] spellArea2;

	// ////////////////////////
	public GUI() {
		super();

		x = 0;

		font = new Font("Brush Script Mt Italic", font.ITALIC, 26);

		this.setLayout(null);
		this.setVisible(true);
		this.setSize(800, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Game Of Gods");

		pS = new JPanel();
		pS.setLayout(null);
		pS.setBounds(0, 0, 1000, 1000);
		this.getContentPane().add(pS);
		pS.setVisible(true);

		playMusic = new JButton("Play");
		playMusic.setBounds(100, 700, 200, 100);
		pS.add(playMusic);
		playMusic.addMouseListener(this);

		pE = new JPanel();
		pE.setLayout(null);
		pE.setBounds(0, 0, 1500, 1000);
		// pE.setBackground(Color.cyan);
		this.getContentPane().add(pE);
		pE.setVisible(false);

		gO = new JLabel();
		gO.setBounds(0, 0, 1500, 1000);
		gO.setIcon(new ImageIcon("winneris.jpg"));
		pE.add(gO);

		reStart = new JButton("restart");
		reStart.setBounds(100, 100, 100, 100);
		reStart.addMouseListener(this);
		reStart.setContentAreaFilled(true);
		reStart.setBorderPainted(true);
		gO.add(reStart);

		winner = new JLabel();
		winner.setBounds(950, 50, 1000, 1000);
		winner.setFont(new Font("", Font.BOLD, 45));
		winner.setForeground(Color.gray);
		gO.add(winner);

		l1 = new JLabel();
		l1.setBounds(90, 50, 100, 50);
		l1.setBackground(Color.black);
		l1.setFont(new Font("Brush Script MT Italic", font.ITALIC, 28));
		l1.setText("Player 1");
		pS.add(l1);

		l2 = new JLabel();
		l2.setBounds(90, 150, 100, 50);
		l2.setBackground(Color.black);
		l2.setFont(new Font("Brush Script MT Italic", font.ITALIC, 28));
		l2.setText("Player 2");
		pS.add(l2);

		t1 = new JTextField();
		t1.setBounds(200, 50, 500, 50);
		t1.setVisible(true);
		t1.setFont(font);
		pS.add(t1);

		t2 = new JTextField();
		t2.setBounds(200, 150, 500, 50);
		t2.setVisible(true);
		t2.setFont(font);
		pS.add(t2);

		b1 = new JButton();
		b1.setBounds(200, 300, 100, 50);
		b1.setVisible(true);
		b1.setText("Start");
		b1.addMouseListener(this);
		pS.add(b1);

		b2 = new JButton("Cancel");
		b2.setBounds(500, 300, 100, 50);
		b2.setVisible(true);
		b2.addMouseListener(this);
		pS.add(b2);

		pG = new JPanel();
		pG.setLayout(null);
		pG.setBounds(0, 0, 1500, 1000);
		this.getContentPane().add(pG);
		pG.setVisible(false);
		pG.setBackground(Color.LIGHT_GRAY);

		infoLabel = new JLabel();
		infoLabel.setBounds(1100, 200, 400, 400);
		infoLabel.setBackground(Color.red);
		infoLabel.setFont(font);
		pG.add(infoLabel);

		pgImage = new JLabel();
		pgImage.setIcon(new ImageIcon("backGround.jpg"));
		pgImage.setBounds(0, 0, 1000, 1000);
		pG.add(pgImage);

		sacMSize = new JLabel();
		sacMSize.setBounds(1100, 0, 100, 100);
		sacMSize.setFont(font);
		pG.add(sacMSize);

		pN1 = new JLabel();
		pN1.setBounds(1100, 0, 500, 250);
		pN1.setBackground(Color.black);
		pN1.setFont(font);
		pG.add(pN1);

		lPoints1 = new JLabel("8000");
		lPoints1.setBounds(1100, 50, 500, 250);
		lPoints1.setFont(font);
		pG.add(lPoints1);

		pN2 = new JLabel();
		pN2.setBounds(1100, 600, 500, 250);
		pN2.setBackground(Color.black);
		pN2.setFont(font);
		pG.add(pN2);

		lPoints2 = new JLabel("8000");
		lPoints2.setBounds(1100, 650, 500, 250);
		lPoints2.setFont(font);
		pG.add(lPoints2);

		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBounds(0, 0, 1000, 400);
		p1.setOpaque(false);
		// p1.setBackground(Color.red);
		pgImage.add(p1);
		p1.setVisible(false);

		cardImage1 = new JLabel();
		cardImage1.setBounds(800, 100, 150, 222);
		p1.add(cardImage1);

		phaseP1 = new JLabel("Main1");
		phaseP1.setBounds(150, 100, 400, 350);
		phaseP1.setFont(font);
		p1.add(phaseP1);

		pD1 = new JPanel();
		pD1.setBounds(50, 100, 54, 77);
		pD1.setLayout(null);
		p1.add(pD1);

		deck1 = new JButton[20];
		for (int i = 0; i < deck1.length; i++) {
			deck1[i] = new JButton();
			deck1[i].setBounds(0, 0, 54, 77);
			deck1[i].setIcon(new ImageIcon("Back.png"));
			deck1[i].addMouseListener(this);
			pD1.add(deck1[i]);
		}
		deck1[0].setHorizontalTextPosition(JButton.CENTER);
		deck1[0].setVerticalTextPosition(JButton.CENTER);
		deck1[0].setForeground(Color.white);
		deck1[0].setFont(font);

		pG1 = new JPanel();
		pG1.setBounds(50, 200, 54, 77);
		pG1.setLayout(null);
		p1.add(pG1);

		graveYard1 = new JButton[20];
		for (int i = 0; i < graveYard1.length; i++) {
			graveYard1[i] = new JButton();
			graveYard1[i].setBounds(0, 0, 54, 77);
			graveYard1[i].setIcon(new ImageIcon("BG.jpg"));
			graveYard1[i].addMouseListener(this);
			pG1.add(graveYard1[i]);

		}

		pH1 = new JPanel();
		pH1.setBounds(150, 10, 800, 77);
		pH1.setLayout(new GridLayout(1, 20));
		p1.add(pH1);

		hand1 = new JButton[20];
		for (int i = 0; i < hand1.length; i++) {
			hand1[i] = new JButton();
			hand1[i].setIcon(new ImageIcon("BG.jpg"));
			hand1[i].addMouseListener(this);
			pH1.add(hand1[i]);
		}

		pM1 = new JPanel();
		pM1.setBounds(400, 120, 270, 77);
		pM1.setLayout(new GridLayout(1, 5));
		p1.add(pM1);

		monsterArea1 = new JButton[5];

		for (int i = 0; i < monsterArea1.length; i++) {

			monsterArea1[i] = new JButton();
			monsterArea1[i].setIcon(new ImageIcon("BG.jpg"));
			monsterArea1[i].addMouseListener(this);
			pM1.add(monsterArea1[i]);

			numbers = new JLabel();
			numbers.setBounds(420 + x, 30, 150, 150);
			numbers.setText(i + "");
			numbers.setForeground(Color.yellow);
			p1.add(numbers);
			x += 55;

		}

		pS1 = new JPanel();
		pS1.setBounds(400, 220, 270, 77);
		pS1.setLayout(new GridLayout(1, 5));
		p1.add(pS1);

		spellArea1 = new JButton[5];
		for (int i = 0; i < monsterArea1.length; i++) {
			spellArea1[i] = new JButton();
			spellArea1[i].setIcon(new ImageIcon("BG.jpg"));
			spellArea1[i].addMouseListener(this);
			pS1.add(spellArea1[i]);
		}

		p2 = new JPanel();
		p2.setLayout(null);
		p2.setBounds(0, 565, 1000, 400);
		p2.setOpaque(false);
		// p2.setBackground(Color.yellow);
		pgImage.add(p2);
		p2.setVisible(false);

		cardImage2 = new JLabel();
		cardImage2.setBounds(800, 0, 150, 222);
		p2.add(cardImage2);

		phaseP2 = new JLabel("Main1");
		phaseP2.setBounds(150, 0, 400, 200);
		phaseP2.setFont(font);
		p2.add(phaseP2);

		pD2 = new JPanel();
		pD2.setBounds(50, 200, 54, 77);
		pD2.setLayout(null);
		p2.add(pD2);

		deck2 = new JButton[20];
		for (int i = 0; i < deck2.length; i++) {
			deck2[i] = new JButton();
			deck2[i].setBounds(0, 0, 54, 77);
			deck2[i].setIcon(new ImageIcon("Back.png"));
			deck2[i].addMouseListener(this);
			pD2.add(deck2[i]);
		}
		deck2[0].setHorizontalTextPosition(JButton.CENTER);
		deck2[0].setVerticalTextPosition(JButton.CENTER);
		deck2[0].setForeground(Color.white);
		deck2[0].setFont(font);

		pG2 = new JPanel();
		pG2.setBounds(50, 100, 54, 77);
		pG2.setLayout(null);
		p2.add(pG2);

		graveYard2 = new JButton[20];
		for (int i = 0; i < graveYard2.length; i++) {
			graveYard2[i] = new JButton();
			graveYard2[i].setBounds(0, 0, 54, 77);
			graveYard2[i].setIcon(new ImageIcon("BG.jpg"));
			graveYard2[i].addMouseListener(this);
			pG2.add(graveYard2[i]);
			if (graveYard2[i] == graveYard2[graveYard2.length - 1]) {

				graveYard2[i].setIcon(new ImageIcon(""));
			}
		}

		pH2 = new JPanel();
		pH2.setBounds(150, 313, 800, 77);
		pH2.setLayout(new GridLayout(1, 20));
		p2.add(pH2);

		hand2 = new JButton[20];
		for (int i = 0; i < hand2.length; i++) {
			hand2[i] = new JButton();
			hand2[i].setIcon(new ImageIcon("BG.jpg"));
			hand2[i].addMouseListener(this);
			pH2.add(hand2[i]);
		}

		pM2 = new JPanel();
		pM2.setBounds(400, 200, 270, 77);
		pM2.setLayout(new GridLayout(1, 5));
		p2.add(pM2);

		monsterArea2 = new JButton[5];
		for (int i = 0; i < monsterArea2.length; i++) {
			monsterArea2[i] = new JButton();
			monsterArea2[i].setIcon(new ImageIcon("BG.jpg"));
			monsterArea2[i].addMouseListener(this);
			pM2.add(monsterArea2[i]);

			numbers = new JLabel();
			numbers.setBounds(140 + x, 220, 150, 150);
			numbers.setText(i + "");
			numbers.setForeground(Color.yellow);
			p2.add(numbers);
			x += 55;
		}

		pS2 = new JPanel();
		pS2.setBounds(400, 100, 270, 77);
		pS2.setLayout(new GridLayout(1, 5));
		p2.add(pS2);

		spellArea2 = new JButton[5];
		for (int i = 0; i < monsterArea2.length; i++) {
			spellArea2[i] = new JButton();
			spellArea2[i].setIcon(new ImageIcon("BG.jpg"));
			spellArea2[i].addMouseListener(this);
			pS2.add(spellArea2[i]);
		}

		show = new JPanel();
		show.setBounds(0, 400, 1000, 200);
		show.setLayout(null);
		show.setOpaque(false);
		// show.setBackground(Color.cyan);
		pgImage.add(show);

		eT = new JButton();
		eT.setBounds(50, 70, 100, 50);
		eT.setVisible(true);
		eT.setText("End Turn");
		eT.setForeground(Color.white);
		eT.setContentAreaFilled(false);
		eT.setBorderPainted(false);
		eT.addMouseListener(this);
		show.add(eT);

		eP = new JButton();
		eP.setBounds(200, 100, 100, 50);
		eP.setVisible(true);
		eP.setText("End Phase");
		eP.setForeground(Color.white);
		eP.setContentAreaFilled(false);
		eP.setBorderPainted(false);
		eP.addMouseListener(this);
		show.add(eP);

		AorD = new JButton();
		AorD.setBounds(200, 20, 100, 50);
		AorD.setVisible(true);
		AorD.setText("inAttack");
		AorD.setForeground(Color.white);
		AorD.setContentAreaFilled(false);
		AorD.setBorderPainted(false);
		AorD.addMouseListener(this);
		show.add(AorD);

		sac = new JButton();
		sac.setBounds(400, 70, 150, 50);
		sac.setVisible(true);
		sac.setText("Sacrifice On");
		sac.setForeground(Color.white);
		sac.setContentAreaFilled(false);
		sac.setBorderPainted(false);
		sac.addMouseListener(this);
		show.add(sac);

		addSpell = new JButton();
		addSpell.setBounds(600, 70, 150, 50);
		addSpell.setVisible(true);
		addSpell.setForeground(Color.white);
		addSpell.setContentAreaFilled(false);
		addSpell.setBorderPainted(false);
		addSpell.setText("Activate the %$^@");
		addSpell.addMouseListener(this);
		show.add(addSpell);

		switchCard = new JButton();
		switchCard.setBounds(800, 70, 150, 50);
		switchCard.setVisible(true);
		switchCard.setText("switch On");
		switchCard.setForeground(Color.white);
		switchCard.setContentAreaFilled(false);
		switchCard.setBorderPainted(false);
		switchCard.addMouseListener(this);
		show.add(switchCard);

		this.validate();
		this.repaint();
	}

	public void refreshIt() {

		monsterArea1[0].setIcon(new ImageIcon("BG.jpg"));
		monsterArea1[1].setIcon(new ImageIcon("BG.jpg"));
		monsterArea1[2].setIcon(new ImageIcon("BG.jpg"));
		monsterArea1[3].setIcon(new ImageIcon("BG.jpg"));
		monsterArea1[4].setIcon(new ImageIcon("BG.jpg"));
		monsterArea2[0].setIcon(new ImageIcon("BG.jpg"));
		monsterArea2[1].setIcon(new ImageIcon("BG.jpg"));
		monsterArea2[2].setIcon(new ImageIcon("BG.jpg"));
		monsterArea2[3].setIcon(new ImageIcon("BG.jpg"));
		monsterArea2[4].setIcon(new ImageIcon("BG.jpg"));
		spellArea1[0].setIcon(new ImageIcon("BG.jpg"));
		spellArea1[1].setIcon(new ImageIcon("BG.jpg"));
		spellArea1[2].setIcon(new ImageIcon("BG.jpg"));
		spellArea1[3].setIcon(new ImageIcon("BG.jpg"));
		spellArea1[4].setIcon(new ImageIcon("BG.jpg"));
		spellArea2[0].setIcon(new ImageIcon("BG.jpg"));
		spellArea2[1].setIcon(new ImageIcon("BG.jpg"));
		spellArea2[2].setIcon(new ImageIcon("BG.jpg"));
		spellArea2[3].setIcon(new ImageIcon("BG.jpg"));
		spellArea2[4].setIcon(new ImageIcon("BG.jpg"));

		for (int i = 0; i < pInfo1.getField().getHand().size(); i++) {

			for (int j = pInfo1.getField().getHand().size(); j < hand1.length; j++) {

				hand1[j].setIcon(new ImageIcon("BG.jpg"));

			}
			hand1[i].setIcon(new ImageIcon(pInfo1.getField().getHand().get(i)
					.getName()
					+ ".png"));

		}
		for (int i = 0; i < pInfo2.getField().getHand().size(); i++) {

			for (int j = pInfo2.getField().getHand().size(); j < hand2.length; j++) {

				hand2[j].setIcon(new ImageIcon("BG.jpg"));

			}

			hand2[i].setIcon(new ImageIcon(pInfo2.getField().getHand().get(i)
					.getName()
					+ ".png"));
		}

		for (int i = 0; i < pInfo1.getField().getMonstersArea().size(); i++) {
			monsterArea1[i].setIcon(new ImageIcon("BG.jpg"));
			monsterArea1[i].setBackground(null);
			if (pInfo1.getField().getMonstersArea().get(i).getMode() == Mode.ATTACK) {
				monsterArea1[i].setBackground(null);
				monsterArea1[i].setIcon(new ImageIcon(pInfo1.getField()
						.getMonstersArea().get(i).getName()
						+ ".png"));
			} else {

				monsterArea1[i].setIcon(new ImageIcon("Back.png"));

			}

		}
		for (int i = 0; i < pInfo2.getField().getMonstersArea().size(); i++) {
			monsterArea2[i].setIcon(new ImageIcon("BG.jpg"));
			monsterArea2[i].setBackground(null);
			if (pInfo2.getField().getMonstersArea().get(i).getMode() == Mode.ATTACK) {
				monsterArea2[i].setIcon(new ImageIcon(pInfo2.getField()
						.getMonstersArea().get(i).getName()
						+ ".png"));
			} else {

				monsterArea2[i].setIcon(new ImageIcon("Back.png"));

			}
		}

		for (int i = 0; i < pInfo1.getField().getSpellArea().size(); i++) {
			spellArea1[i].setIcon(new ImageIcon("BG.jpg"));
			spellArea1[i].setBackground(null);
			if (pInfo1.getField().getSpellArea().get(i).isHidden() == false) {
				spellArea1[i].setIcon(new ImageIcon(pInfo1.getField()
						.getSpellArea().get(i).getName()
						+ ".png"));
			} else {
				spellArea1[i].setIcon(new ImageIcon("Back.png"));
			}
		}
		for (int i = 0; i < pInfo2.getField().getSpellArea().size(); i++) {
			spellArea2[i].setIcon(new ImageIcon("BG.jpg"));
			spellArea2[i].setBackground(null);
			if (pInfo2.getField().getSpellArea().get(i).isHidden() == false) {
				spellArea2[i].setIcon(new ImageIcon(pInfo2.getField()
						.getSpellArea().get(i).getName()
						+ ".png"));
			} else {
				spellArea2[i].setIcon(new ImageIcon("Back.png"));
			}
		}
		for (int i = 0; i < pInfo1.getField().getGraveyard().size(); i++) {
			graveYard1[0].setIcon(new ImageIcon(pInfo1.getField()
					.getGraveyard().get(i).getName()
					+ ".png"));
		}

		for (int i = 0; i < pInfo2.getField().getGraveyard().size(); i++) {
			graveYard2[0].setIcon(new ImageIcon(pInfo2.getField()
					.getGraveyard().get(i).getName()
					+ ".png"));
		}

		if (b.getWinner() != null) {

			pG.setVisible(false);
			pE.setVisible(true);

			if (b.getWinner() == pInfo1) {

				winner.setText(pname1);
			} else {

				winner.setText(pname2);
			}
		}

		lPoints1.setText(pInfo1.getLifePoints() + "");

		lPoints2.setText(pInfo2.getLifePoints() + "");

		phaseP1.setText(pInfo1.getField().getPhase() + "");

		phaseP2.setText(pInfo2.getField().getPhase() + "");

		if (pInfo1 == b.getActivePlayer()) {
			if (pname1 == "") {
				pN1.setText("Player 1" + "'s turn");

			} else
				pN1.setText(pname1 + "'s turn");

			phaseP1.setVisible(true);
			pH2.setVisible(false);
			pH1.setVisible(true);
			phaseP2.setVisible(false);
			cardImage2.setVisible(false);

			cardImage1.setVisible(true);
		} else {
			pN1.setText(pname1);
			if (pname2 == "") {
				pN2.setText("Player 2" + "'s turn");

			} else
				pN2.setText(pname2 + "'s turn");

			phaseP1.setVisible(false);
			pH2.setVisible(true);
			pH1.setVisible(false);
			phaseP2.setVisible(true);
			cardImage1.setVisible(false);

			cardImage2.setVisible(true);

		}
		if (pInfo1.getField().getDeck().getDeck().size() == 0) {
			deck1[0].setIcon(new ImageIcon("BG.jpg"));
		}
		if (pInfo2.getField().getDeck().getDeck().size() == 0) {
			deck2[0].setIcon(new ImageIcon("BG.jpg"));
		}

		deck1[0].setText(pInfo1.getField().getDeck().getDeck().size() + "");
		deck2[0].setText(pInfo2.getField().getDeck().getDeck().size() + "");

		this.validate();
		this.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == playMusic) {
			// startBGMusic();

		}
		if (e.getSource() == reStart) {

			this.setVisible(false);
			GUI g = new GUI();

		}
		if (e.getSource() == b1) {
			pS.setVisible(false);
			pG.setVisible(true);
			p1.setVisible(true);
			show.setVisible(true);
			p2.setVisible(true);
			this.setSize(1500, 1000);

			if (pInfo1 == b.getActivePlayer()) {

				pN2.setText(pname2);
			} else {

				pN1.setText(pname1);
			}

			try {
				pInfo1 = new Player(t1.getText());
			} catch (IOException | UnexpectedFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				pInfo2 = new Player(t2.getText());
			} catch (IOException | UnexpectedFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			b.startGame(pInfo1, pInfo2);

			this.refreshIt();

		} else if (e.getSource() == b2) {

			System.exit(0);
		}
		if (e.getSource() == eT) { // /end turn

			b.getActivePlayer().endTurn();
			if (pInfo1 == b.getActivePlayer()) {
				pN1.setText(pN1.getText() + "'s turn");

				pN2.setText(pname2);
				refreshIt();
			} else {
				pN2.setText(pN2.getText() + "'s turn");

				pN1.setText(pname1);

				refreshIt();
			}
			sacM = null;
			refreshIt();
		}
		if (e.getSource() == eP) { // /end Phase

			b.getActivePlayer().endPhase();
			if (b.getActivePlayer().getField().getPhase() == Phase.MAIN1) {
				if (pInfo1 == b.getActivePlayer()) {
					pN1.setText(pN1.getText() + "'s turn");

					pN2.setText(pname2);
				} else {
					pN2.setText(pN2.getText() + "'s turn");

					pN1.setText(pname1);
				}
			}
			refreshIt();
		}

		// / From Hand to (monster or spell) area Player one
		for (int i = 0; i < pInfo1.getField().getHand().size(); i++) {
			if (e.getSource() == hand1[i] && b.getActivePlayer() == pInfo1) {

				if (pInfo1.getField().getPhase() == Phase.BATTLE) {
					JOptionPane
							.showMessageDialog(frame,
									"Can't add a CARD in battle phase please change to Main2 or end turn");
					break;
				}
				if (pInfo1.getField().getHand().get(i) instanceof MonsterCard) {

					if (pInfo1.getField().getMonstersArea().size() > 4) {
						JOptionPane.showMessageDialog(frame, "no enough space");
						break;
					}
					if (pInfo1.addedMonsterThisTurn) {
						JOptionPane.showMessageDialog(frame,
								"can't add more than one monster");
						break;
					}
					MonsterCard mons = (MonsterCard) pInfo1.getField()
							.getHand().get(i);
					if (mons.getLevel() <= 4) {
						if (isTrueAttack() == false) {
							pInfo1.setMonster(mons);
						} else if (isTrueAttack() == true) {
							pInfo1.summonMonster(mons);

						}
					} else if (mons.getLevel() <= 6 && mons.getLevel() > 4) {
						if (pInfo1.getField().getMonstersArea().size() > 0) {
							String s = JOptionPane
									.showInputDialog("choose one monster to sacrifice");
							sacM = null;
							switch (s) {
							case "0":
								sacM.add(pInfo1.getField().getMonstersArea()
										.get(0));
								if (isTrueAttack() == false) {
									pInfo1.setMonster(mons, sacM);
								} else if (isTrueAttack() == true) {
									pInfo1.summonMonster(mons, sacM);

								}

								refreshIt();
							case "1":
								if (isTrueAttack() == false) {
									pInfo1.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo1.summonMonster(mons);

								}
								pInfo1.getField().removeMonsterToGraveyard(
										pInfo1.getField().getMonstersArea()
												.get(1));
								refreshIt();
							case "2":
								if (isTrueAttack() == false) {
									pInfo1.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo1.summonMonster(mons);

								}
								pInfo1.getField().removeMonsterToGraveyard(
										pInfo1.getField().getMonstersArea()
												.get(2));
								refreshIt();
							case "3":
								if (isTrueAttack() == false) {
									pInfo1.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo1.summonMonster(mons);

								}
								pInfo1.getField().removeMonsterToGraveyard(
										pInfo1.getField().getMonstersArea()
												.get(3));
								refreshIt();
							case "4":
								if (isTrueAttack() == false) {
									pInfo1.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo1.summonMonster(mons);

								}
								pInfo1.getField().removeMonsterToGraveyard(
										pInfo1.getField().getMonstersArea()
												.get(4));
								refreshIt();
							default:
								JOptionPane.showMessageDialog(frame,
										"wrong number");
							}

						}

						else {

							JOptionPane
									.showMessageDialog(frame,
											"No enough monsters in monsters area to sacrifice");
						}

					} else if (mons.getLevel() <= 8 && mons.getLevel() > 6) {

						if (pInfo1.getField().getMonstersArea().size() > 1) {

							String s = JOptionPane
									.showInputDialog("choose two monsters to sacrifice , smaller number first ex: 01 not 10");
							switch (s) {
							case "01":

								pInfo1.getField().removeMonsterToGraveyard(
										pInfo1.getField().getMonstersArea()
												.get(1));

								pInfo1.getField().removeMonsterToGraveyard(
										pInfo1.getField().getMonstersArea()
												.get(0));

								if (isTrueAttack() == false) {
									pInfo1.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo1.summonMonster(mons);

								}
								refreshIt();
							case "02":

								pInfo1.getField().removeMonsterToGraveyard(
										pInfo1.getField().getMonstersArea()
												.get(2));
								pInfo1.getField().removeMonsterToGraveyard(
										pInfo1.getField().getMonstersArea()
												.get(0));
								if (isTrueAttack() == false) {
									pInfo1.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo1.summonMonster(mons);

								}
								refreshIt();
							case "03":

								pInfo1.getField().removeMonsterToGraveyard(
										pInfo1.getField().getMonstersArea()
												.get(3));
								pInfo1.getField().removeMonsterToGraveyard(
										pInfo1.getField().getMonstersArea()
												.get(0));
								if (isTrueAttack() == false) {
									pInfo1.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo1.summonMonster(mons);

								}

								refreshIt();
							case "04":

								pInfo1.getField().removeMonsterToGraveyard(
										pInfo1.getField().getMonstersArea()
												.get(4));
								pInfo1.getField().removeMonsterToGraveyard(
										pInfo1.getField().getMonstersArea()
												.get(0));
								if (isTrueAttack() == false) {
									pInfo1.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo1.summonMonster(mons);

								}
								refreshIt();
							case "12":

								pInfo1.getField().removeMonsterToGraveyard(
										pInfo1.getField().getMonstersArea()
												.get(2));
								pInfo1.getField().removeMonsterToGraveyard(
										pInfo1.getField().getMonstersArea()
												.get(1));
								if (isTrueAttack() == false) {
									pInfo1.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo1.summonMonster(mons);

								}

								refreshIt();
							case "13":

								pInfo1.getField().removeMonsterToGraveyard(
										pInfo1.getField().getMonstersArea()
												.get(3));
								pInfo1.getField().removeMonsterToGraveyard(
										pInfo1.getField().getMonstersArea()
												.get(1));
								if (isTrueAttack() == false) {
									pInfo1.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo1.summonMonster(mons);

								}

								refreshIt();
							case "14":

								pInfo1.getField().removeMonsterToGraveyard(
										pInfo1.getField().getMonstersArea()
												.get(4));
								pInfo1.getField().removeMonsterToGraveyard(
										pInfo1.getField().getMonstersArea()
												.get(1));
								if (isTrueAttack() == false) {
									pInfo1.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo1.summonMonster(mons);

								}

								refreshIt();
							case "23":

								pInfo1.getField().removeMonsterToGraveyard(
										pInfo1.getField().getMonstersArea()
												.get(3));
								pInfo1.getField().removeMonsterToGraveyard(
										pInfo1.getField().getMonstersArea()
												.get(2));
								if (isTrueAttack() == false) {
									pInfo1.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo1.summonMonster(mons);

								}

								refreshIt();
							case "24":

								pInfo1.getField().removeMonsterToGraveyard(
										pInfo1.getField().getMonstersArea()
												.get(4));
								pInfo1.getField().removeMonsterToGraveyard(
										pInfo1.getField().getMonstersArea()
												.get(2));
								if (isTrueAttack() == false) {
									pInfo1.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo1.summonMonster(mons);

								}

								refreshIt();
							case "34":

								pInfo1.getField().removeMonsterToGraveyard(
										pInfo1.getField().getMonstersArea()
												.get(4));
								pInfo1.getField().removeMonsterToGraveyard(
										pInfo1.getField().getMonstersArea()
												.get(3));
								if (isTrueAttack() == false) {
									pInfo1.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo1.summonMonster(mons);

								}

								refreshIt();
							default:
								JOptionPane.showMessageDialog(frame,
										"wrong number");
							}

						} else {
							JOptionPane
									.showMessageDialog(frame,
											"No enough monsters in monsters area to sacrifice");
						}
					}

				} else if (pInfo1.getField().getHand().get(i) instanceof SpellCard) {

					// spellArea1[i].setIcon(new ImageIcon("BG.jpg"));

					SpellCard spell = (SpellCard) pInfo1.getField().getHand()
							.get(i);
					if (isActivateSpell() == true) {

						if (spell instanceof ChangeOfHeart) {
							String s = JOptionPane
									.showInputDialog("Please choose the monster's number (0,1,2,3,4)");

							switch (s) {
							case "0":
								pInfo1.activateSpell(spell, pInfo2.getField()
										.getMonstersArea().get(0));
							case "1":
								pInfo1.activateSpell(spell, pInfo2.getField()
										.getMonstersArea().get(1));
							case "2":
								pInfo1.activateSpell(spell, pInfo2.getField()
										.getMonstersArea().get(2));
							case "3":
								pInfo1.activateSpell(spell, pInfo2.getField()
										.getMonstersArea().get(3));
							case "4":
								pInfo1.activateSpell(spell, pInfo2.getField()
										.getMonstersArea().get(4));
							default:
								JOptionPane.showMessageDialog(frame,
										"wrong number");
							}
						} else if (spell instanceof MagePower) {
							String s = JOptionPane
									.showInputDialog("Please choose the monster's number (0,1,2,3,4)");

							switch (s) {
							case "0":
								pInfo1.activateSpell(spell, pInfo1.getField()
										.getMonstersArea().get(0));
							case "1":
								pInfo1.activateSpell(spell, pInfo1.getField()
										.getMonstersArea().get(1));
							case "2":
								pInfo1.activateSpell(spell, pInfo1.getField()
										.getMonstersArea().get(2));
							case "3":
								pInfo1.activateSpell(spell, pInfo1.getField()
										.getMonstersArea().get(3));
							case "4":
								pInfo1.activateSpell(spell, pInfo1.getField()
										.getMonstersArea().get(4));
							default:
								JOptionPane.showMessageDialog(frame,
										"wrong number");
							}
						} else if (spell instanceof MonsterReborn) {
							if (pInfo1.getField().getGraveyard().size() > 0) {
								for (int a = 0; a < pInfo1.getField()
										.getGraveyard().size(); a++) {
									if (pInfo1.getField().getGraveyard().get(a) instanceof MonsterCard) {
										setFirstMons(true);
										break;
									}
									setFirstMons(false);
								}
								if (isFirstMons() == true) {
									pInfo1.activateSpell(spell, null);
								} else {
									JOptionPane.showMessageDialog(frame,
											"No Monster's to revive");
								}
							} else {
								JOptionPane.showMessageDialog(frame,
										"No Monster's to revive");
							}

						} else {
							pInfo1.activateSpell(spell, null);
						}

					} else {
						if (pInfo1.getField().getSpellArea().size() > 4) {
							JOptionPane.showMessageDialog(frame,
									"no enough space");
							break;
						}
						pInfo1.getField().addSpellToField(spell, null, true);
					}

				}

			}
			refreshIt();
		}

		// / From Hand to (monster or spell) area Player 2
		for (int i = 0; i < pInfo2.getField().getHand().size(); i++) {

			if (e.getSource() == hand2[i] && pInfo2 == b.getActivePlayer()) {
				if (pInfo2.getField().getPhase() == Phase.BATTLE) {
					JOptionPane
							.showMessageDialog(frame,
									"Can't add a CARD in battle phase please change to Main2 or end turn");
					break;
				}
				if (pInfo2.getField().getHand().get(i) instanceof MonsterCard) {

					// monsterArea2[i].setIcon(new ImageIcon("BG.jpg"));
					if (pInfo2.getField().getMonstersArea().size() > 4) {
						JOptionPane.showMessageDialog(frame, "no enough space");
						break;
					}
					if (pInfo2.addedMonsterThisTurn) {
						JOptionPane.showMessageDialog(frame,
								"can't add more than one monster");
						break;
					}
					MonsterCard mons = (MonsterCard) pInfo2.getField()
							.getHand().get(i);
					if (mons.getLevel() <= 4) {
						if (isTrueAttack() == false) {
							pInfo2.setMonster(mons);
						} else if (isTrueAttack() == true) {
							pInfo2.summonMonster(mons);
						}
					} else if (mons.getLevel() <= 6 && mons.getLevel() > 4) {
						if (pInfo2.getField().getMonstersArea().size() > 0) {
							String s = JOptionPane
									.showInputDialog("choose one monster to sacrifice");
							switch (s) {
							case "0":
								if (isTrueAttack() == false) {
									pInfo2.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo2.summonMonster(mons);
								}
								pInfo2.getField().removeMonsterToGraveyard(
										pInfo2.getField().getMonstersArea()
												.get(0));
								refreshIt();
							case "1":
								if (isTrueAttack() == false) {
									pInfo2.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo2.summonMonster(mons);
								}
								pInfo2.getField().removeMonsterToGraveyard(
										pInfo2.getField().getMonstersArea()
												.get(1));
								refreshIt();
							case "2":
								if (isTrueAttack() == false) {
									pInfo2.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo2.summonMonster(mons);
								}
								pInfo2.getField().removeMonsterToGraveyard(
										pInfo2.getField().getMonstersArea()
												.get(2));
								refreshIt();
							case "3":
								if (isTrueAttack() == false) {
									pInfo2.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo2.summonMonster(mons);
								}
								pInfo2.getField().removeMonsterToGraveyard(
										pInfo2.getField().getMonstersArea()
												.get(3));
								refreshIt();
							case "4":
								if (isTrueAttack() == false) {
									pInfo2.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo2.summonMonster(mons);
								}
								pInfo2.getField().removeMonsterToGraveyard(
										pInfo2.getField().getMonstersArea()
												.get(4));
								refreshIt();
							default:
								JOptionPane.showMessageDialog(frame,
										"wrong number");
							}

						}

						else {

							JOptionPane
									.showMessageDialog(frame,
											"No enough monsters in monsters area to sacrifice");
						}
					} else if (mons.getLevel() <= 8 && mons.getLevel() > 6) {

						if (pInfo2.getField().getMonstersArea().size() > 1) {
							String s = JOptionPane
									.showInputDialog("choose two monsters to sacrifice , smaller number first ex: 01 not 10");
							switch (s) {
							case "01":

								pInfo2.getField().removeMonsterToGraveyard(
										pInfo2.getField().getMonstersArea()
												.get(1));

								pInfo2.getField().removeMonsterToGraveyard(
										pInfo2.getField().getMonstersArea()
												.get(0));

								if (isTrueAttack() == false) {
									pInfo2.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo2.summonMonster(mons);

								}
								refreshIt();
							case "02":

								pInfo2.getField().removeMonsterToGraveyard(
										pInfo2.getField().getMonstersArea()
												.get(2));
								pInfo2.getField().removeMonsterToGraveyard(
										pInfo2.getField().getMonstersArea()
												.get(0));
								if (isTrueAttack() == false) {
									pInfo2.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo2.summonMonster(mons);

								}
								refreshIt();
							case "03":

								pInfo2.getField().removeMonsterToGraveyard(
										pInfo2.getField().getMonstersArea()
												.get(3));
								pInfo2.getField().removeMonsterToGraveyard(
										pInfo2.getField().getMonstersArea()
												.get(0));
								if (isTrueAttack() == false) {
									pInfo2.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo2.summonMonster(mons);

								}

								refreshIt();
							case "04":

								pInfo2.getField().removeMonsterToGraveyard(
										pInfo2.getField().getMonstersArea()
												.get(4));
								pInfo2.getField().removeMonsterToGraveyard(
										pInfo2.getField().getMonstersArea()
												.get(0));
								if (isTrueAttack() == false) {
									pInfo2.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo2.summonMonster(mons);

								}
								refreshIt();
							case "12":

								pInfo2.getField().removeMonsterToGraveyard(
										pInfo2.getField().getMonstersArea()
												.get(2));
								pInfo2.getField().removeMonsterToGraveyard(
										pInfo2.getField().getMonstersArea()
												.get(1));
								if (isTrueAttack() == false) {
									pInfo2.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo2.summonMonster(mons);

								}

								refreshIt();
							case "13":

								pInfo2.getField().removeMonsterToGraveyard(
										pInfo2.getField().getMonstersArea()
												.get(3));
								pInfo2.getField().removeMonsterToGraveyard(
										pInfo2.getField().getMonstersArea()
												.get(1));
								if (isTrueAttack() == false) {
									pInfo2.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo2.summonMonster(mons);

								}

								refreshIt();
							case "14":

								pInfo2.getField().removeMonsterToGraveyard(
										pInfo2.getField().getMonstersArea()
												.get(4));
								pInfo2.getField().removeMonsterToGraveyard(
										pInfo2.getField().getMonstersArea()
												.get(1));
								if (isTrueAttack() == false) {
									pInfo2.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo2.summonMonster(mons);

								}

								refreshIt();
							case "23":

								pInfo2.getField().removeMonsterToGraveyard(
										pInfo2.getField().getMonstersArea()
												.get(3));
								pInfo2.getField().removeMonsterToGraveyard(
										pInfo2.getField().getMonstersArea()
												.get(2));
								if (isTrueAttack() == false) {
									pInfo2.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo2.summonMonster(mons);

								}

								refreshIt();
							case "24":

								pInfo2.getField().removeMonsterToGraveyard(
										pInfo2.getField().getMonstersArea()
												.get(4));
								pInfo2.getField().removeMonsterToGraveyard(
										pInfo2.getField().getMonstersArea()
												.get(2));
								if (isTrueAttack() == false) {
									pInfo2.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo2.summonMonster(mons);

								}

								refreshIt();
							case "34":

								pInfo2.getField().removeMonsterToGraveyard(
										pInfo2.getField().getMonstersArea()
												.get(4));
								pInfo2.getField().removeMonsterToGraveyard(
										pInfo2.getField().getMonstersArea()
												.get(3));
								if (isTrueAttack() == false) {
									pInfo2.setMonster(mons);
								} else if (isTrueAttack() == true) {
									pInfo2.summonMonster(mons);

								}

								refreshIt();
							default:
								JOptionPane.showMessageDialog(frame,
										"wrong number");
							}
						} else {
							JOptionPane
									.showMessageDialog(frame,
											"No enough monsters in monsters area to sacrifice");
						}
					}

				} else if (pInfo2.getField().getHand().get(i) instanceof SpellCard) {

					// spellArea2[i].setIcon(new ImageIcon("BG.jpg"));
					// monsterArea2[i].setIcon(new ImageIcon("BG.jpg"));

					SpellCard spell = (SpellCard) pInfo2.getField().getHand()
							.get(i);
					if (isActivateSpell() == true) {

						if (spell instanceof ChangeOfHeart) {
							String s = JOptionPane
									.showInputDialog("Please choose the monster's number (0,1,2,3,4)");

							switch (s) {
							case "0":
								pInfo2.activateSpell(spell, pInfo1.getField()
										.getMonstersArea().get(0));
							case "1":
								pInfo2.activateSpell(spell, pInfo1.getField()
										.getMonstersArea().get(1));
							case "2":
								pInfo2.activateSpell(spell, pInfo1.getField()
										.getMonstersArea().get(2));
							case "3":
								pInfo2.activateSpell(spell, pInfo1.getField()
										.getMonstersArea().get(3));
							case "4":
								pInfo2.activateSpell(spell, pInfo1.getField()
										.getMonstersArea().get(4));
							default:
								JOptionPane.showMessageDialog(frame,
										"wrong number");
							}
						} else if (spell instanceof MagePower) {
							String s = JOptionPane
									.showInputDialog("Please choose the monster's number (0,1,2,3,4)");

							switch (s) {
							case "0":
								pInfo2.activateSpell(spell, pInfo2.getField()
										.getMonstersArea().get(0));
							case "1":
								pInfo2.activateSpell(spell, pInfo2.getField()
										.getMonstersArea().get(1));
							case "2":
								pInfo2.activateSpell(spell, pInfo2.getField()
										.getMonstersArea().get(2));
							case "3":
								pInfo2.activateSpell(spell, pInfo2.getField()
										.getMonstersArea().get(3));
							case "4":
								pInfo2.activateSpell(spell, pInfo2.getField()
										.getMonstersArea().get(4));
							default:
								JOptionPane.showMessageDialog(frame,
										"wrong number");
								refreshIt();

							}
						} else if (spell instanceof MonsterReborn) {
							if (pInfo2.getField().getGraveyard().size() > 0) {
								for (int a = 0; a < pInfo2.getField()
										.getGraveyard().size(); a++) {
									if (pInfo2.getField().getGraveyard().get(a) instanceof MonsterCard) {
										setFirstMons(true);
										break;
									}
									setFirstMons(false);
								}
								if (isFirstMons() == true) {
									pInfo2.activateSpell(spell, null);
								} else {
									JOptionPane.showMessageDialog(frame,
											"No Monster's to revive");
								}
							} else {
								JOptionPane.showMessageDialog(frame,
										"No Monster's to revive");
							}

						} else {
							pInfo2.activateSpell(spell, null);
							refreshIt();
						}

					} else {
						if (pInfo2.getField().getSpellArea().size() > 4) {
							JOptionPane.showMessageDialog(frame,
									"no enough space");
							break;
						}
						pInfo2.getField().addSpellToField(spell, null, true);
					}

				}

			}
			refreshIt();

		}
		// //////////////////////////////////////////////////////////////////////////////////////////////
		// // player 1 monster area
		for (int i = 0; i < pInfo1.getField().getMonstersArea().size(); i++) {

			if (e.getSource() == monsterArea1[i]
					&& b.getActivePlayer() == pInfo1) {
				monsterArea1[i].setIcon(null);
				monsterArea1[i].setBackground(Color.yellow);
				if (isSacrifice() == false) {
					if (pInfo1.getField().getMonstersArea().get(i).getMode() == Mode.ATTACK) {

						if (switchIt == true
								&& pInfo1.getField().getMonstersArea().get(i)
										.isSwitchedMode() == false) {
							pInfo1.switchMonsterMode(pInfo1.getField()
									.getMonstersArea().get(i));

						} else {
							if (pInfo1.getField().getPhase() == Phase.BATTLE) {
								if (pInfo1.getField().getMonstersArea().get(i)
										.isAttacked() == true) {
									JOptionPane
											.showMessageDialog(frame,
													"can't attack more than once with this monster");
									break;
								}
								if (pInfo2.getField().getMonstersArea().size() == 0) {
									pInfo1.declareAttack(pInfo1.getField()
											.getMonstersArea().get(i));
									refreshIt();

								} else {
									p1A = pInfo1.getField().getMonstersArea()
											.get(i);

									String s = JOptionPane
											.showInputDialog("Please choose the monster's number");
									monsterArea1[i].setIcon(new ImageIcon(
											"BG.jpg"));
									switch (s) {
									case "0":

										pInfo1.declareAttack(p1A, pInfo2
												.getField().getMonstersArea()
												.get(0));
										monsterArea2[0].setIcon(new ImageIcon(
												"BG.jpg"));
										refreshIt();
										break;
									case "1":
										pInfo1.declareAttack(p1A, pInfo2
												.getField().getMonstersArea()
												.get(1));
										monsterArea2[1].setIcon(new ImageIcon(
												"BG.jpg"));
										refreshIt();
										break;
									case "2":
										pInfo1.declareAttack(p1A, pInfo2
												.getField().getMonstersArea()
												.get(2));
										monsterArea2[2].setIcon(new ImageIcon(
												"BG.jpg"));
										refreshIt();
										break;
									case "3":
										pInfo1.declareAttack(p1A, pInfo2
												.getField().getMonstersArea()
												.get(3));
										monsterArea2[3].setIcon(new ImageIcon(
												"BG.jpg"));
										refreshIt();
										break;
									case "4":
										pInfo1.declareAttack(p1A, pInfo2
												.getField().getMonstersArea()
												.get(4));
										monsterArea2[4].setIcon(new ImageIcon(
												"BG.jpg"));
									default:
										JOptionPane.showMessageDialog(frame,
												"wrong number");
										refreshIt();
										break;

									}

									monsterArea1[i].setIcon(new ImageIcon(
											"BG.jpg"));

									refreshIt();

								}
							} else {
								JOptionPane.showMessageDialog(frame,
										"Only Attacks in battle phase");
								break;
							}
						}
					} else {
						if (switchIt == true
								&& pInfo1.getField().getMonstersArea().get(i)
										.isSwitchedMode() == false) {
							pInfo1.switchMonsterMode(pInfo1.getField()
									.getMonstersArea().get(i));

						} else if (switchIt == true
								&& pInfo1.getField().getMonstersArea().get(i)
										.isSwitchedMode() == true) {
							JOptionPane.showMessageDialog(frame,
									"already switched this turn");
							break;
						}
					}
				} else {
					JOptionPane
							.showMessageDialog(frame,
									"choose either to switch or to sacrifice but not both");
				}

			}
			refreshIt();
		}
		// //////////////////////////////////////////////////////////////////////////////////////////
		// /// player 2 monster area
		for (int i = 0; i < pInfo2.getField().getMonstersArea().size(); i++) {

			if (e.getSource() == monsterArea2[i]
					&& pInfo2 == b.getActivePlayer()) {
				monsterArea2[i].setIcon(null);
				monsterArea2[i].setBackground(Color.yellow);

				if (isSacrifice() == false) {
					if (pInfo2.getField().getMonstersArea().get(i).getMode() == Mode.ATTACK) {

						if (switchIt == true
								&& pInfo2.getField().getMonstersArea().get(i)
										.isSwitchedMode() == false) {
							pInfo2.switchMonsterMode(pInfo2.getField()
									.getMonstersArea().get(i));

						} else {
							if (pInfo2.getField().getPhase() == Phase.BATTLE) {
								if (pInfo2.getField().getMonstersArea().get(i)
										.isAttacked() == true)
									JOptionPane
											.showMessageDialog(frame,
													"can't attack more than once with this monster");

								if (pInfo1.getField().getMonstersArea().size() == 0) {

									pInfo2.declareAttack(pInfo2.getField()
											.getMonstersArea().get(i));

								} else {
									p2A = pInfo2.getField().getMonstersArea()
											.get(i);
									String s = JOptionPane
											.showInputDialog("Please choose the monster's number");
									monsterArea2[i].setIcon(new ImageIcon(
											"BG.jpg"));

									switch (s) {

									case "0":
										pInfo2.declareAttack(p2A, pInfo1
												.getField().getMonstersArea()
												.get(0));

										monsterArea1[0].setIcon(new ImageIcon(
												"BG.jpg"));
										refreshIt();
										break;

									case "1":
										pInfo2.declareAttack(p2A, pInfo1
												.getField().getMonstersArea()
												.get(1));
										monsterArea1[1].setIcon(new ImageIcon(
												"BG.jpg"));
										refreshIt();
										break;
									case "2":
										pInfo2.declareAttack(p2A, pInfo1
												.getField().getMonstersArea()
												.get(2));
										monsterArea1[2].setIcon(new ImageIcon(
												"BG.jpg"));
										refreshIt();
										break;
									case "3":
										pInfo2.declareAttack(p2A, pInfo1
												.getField().getMonstersArea()
												.get(3));
										monsterArea1[3].setIcon(new ImageIcon(
												"BG.jpg"));
										refreshIt();
										break;
									case "4":
										pInfo2.declareAttack(p2A, pInfo1
												.getField().getMonstersArea()
												.get(4));
										monsterArea1[4].setIcon(new ImageIcon(
												"BG.jpg"));
										refreshIt();
										break;

									default:
										JOptionPane.showMessageDialog(frame,
												"wrong number");
										refreshIt();

									}

								}
							} else {
								JOptionPane.showMessageDialog(frame,
										"Only Attacks in battle phase");
							}
						}
					} else {
						if (switchIt == true
								&& pInfo2.getField().getMonstersArea().get(i)
										.isSwitchedMode() == false) {
							pInfo2.switchMonsterMode(pInfo2.getField()
									.getMonstersArea().get(i));
						} else if (switchIt == true
								&& pInfo2.getField().getMonstersArea().get(i)
										.isSwitchedMode() == true) {
							JOptionPane.showMessageDialog(frame,
									"already switched this turn");
						}
					}
				} else if (isSacrifice() == true && isSwitchIt() == false) {
					sacM.add(pInfo2.getField().getMonstersArea().get(i));
				} else {
					JOptionPane
							.showMessageDialog(frame,
									"choose either to switch or to sacrifice but not both");
				}

			}
			refreshIt();
		}

		// /player one spell area
		for (int i = 0; i < pInfo1.getField().getSpellArea().size(); i++) {

			if (e.getSource() == spellArea1[i] && b.getActivePlayer() == pInfo1) {
				spellArea1[i].setIcon(null);
				spellArea1[i].setBackground(Color.yellow);
				pInfo1.getField().getSpellArea().get(i).setHidden(false);
				SpellCard spell = pInfo1.getField().getSpellArea().get(i);
				if (spell instanceof ChangeOfHeart) {
					String s = JOptionPane
							.showInputDialog("Please choose the monster's number (0,1,2,3,4)");

					switch (s) {
					case "0":
						pInfo1.activateSpell(spell, pInfo2.getField()
								.getMonstersArea().get(0));
						refreshIt();

					case "1":
						pInfo1.activateSpell(spell, pInfo2.getField()
								.getMonstersArea().get(1));
						refreshIt();
					case "2":
						pInfo1.activateSpell(spell, pInfo2.getField()
								.getMonstersArea().get(2));
						refreshIt();
					case "3":
						pInfo1.activateSpell(spell, pInfo2.getField()
								.getMonstersArea().get(3));
						refreshIt();
					case "4":
						pInfo1.activateSpell(spell, pInfo2.getField()
								.getMonstersArea().get(4));
						refreshIt();

					default:
						JOptionPane.showMessageDialog(frame, "wrong number");
					}

				} else if (spell instanceof MagePower) {
					String s = JOptionPane
							.showInputDialog("Please choose the monster's number (0,1,2,3,4)");

					switch (s) {
					case "0":
						pInfo1.activateSpell(spell, pInfo1.getField()
								.getMonstersArea().get(0));
						refreshIt();
					case "1":
						pInfo1.activateSpell(spell, pInfo1.getField()
								.getMonstersArea().get(1));
						refreshIt();
					case "2":
						pInfo1.activateSpell(spell, pInfo1.getField()
								.getMonstersArea().get(2));
						refreshIt();
					case "3":
						pInfo1.activateSpell(spell, pInfo1.getField()
								.getMonstersArea().get(3));
						refreshIt();
					case "4":
						pInfo1.activateSpell(spell, pInfo1.getField()
								.getMonstersArea().get(4));
						refreshIt();

					default:
						JOptionPane.showMessageDialog(frame, "wrong number");
					}
				} else {
					if (spell instanceof MonsterReborn) {
						if (pInfo1.getField().getGraveyard().size() > 0) {
							pInfo1.activateSpell(spell, null);
						}

					} else {
						pInfo1.activateSpell(spell, null);
						refreshIt();
					}
				}
				refreshIt();
			}

		}
		// /player 2 spell area
		for (int i = 0; i < pInfo2.getField().getSpellArea().size(); i++) {

			if (e.getSource() == spellArea2[i] && b.getActivePlayer() == pInfo2) {
				spellArea2[i].setIcon(null);
				spellArea2[i].setBackground(Color.yellow);
				pInfo2.getField().getSpellArea().get(i).setHidden(false);
				SpellCard spell = pInfo2.getField().getSpellArea().get(i);
				if (spell instanceof ChangeOfHeart) {
					String s = JOptionPane
							.showInputDialog("Please choose the monster's number (0,1,2,3,4)");

					switch (s) {
					case "0":
						pInfo2.activateSpell(spell, pInfo1.getField()
								.getMonstersArea().get(0));
						refreshIt();
					case "1":
						pInfo2.activateSpell(spell, pInfo1.getField()
								.getMonstersArea().get(1));
						refreshIt();
					case "2":
						pInfo2.activateSpell(spell, pInfo1.getField()
								.getMonstersArea().get(2));
						refreshIt();
					case "3":
						pInfo2.activateSpell(spell, pInfo1.getField()
								.getMonstersArea().get(3));
						refreshIt();
					case "4":
						pInfo2.activateSpell(spell, pInfo1.getField()
								.getMonstersArea().get(4));
						refreshIt();

					default:
						JOptionPane.showMessageDialog(frame, "wrong number");
					}

				} else if (spell instanceof MagePower) {
					String s = JOptionPane
							.showInputDialog("Please choose the monster's number (0,1,2,3,4)");

					switch (s) {
					case "0":
						pInfo2.activateSpell(spell, pInfo2.getField()
								.getMonstersArea().get(0));
						refreshIt();
					case "1":
						pInfo2.activateSpell(spell, pInfo2.getField()
								.getMonstersArea().get(1));
						refreshIt();
					case "2":
						pInfo2.activateSpell(spell, pInfo2.getField()
								.getMonstersArea().get(2));
						refreshIt();
					case "3":
						pInfo2.activateSpell(spell, pInfo2.getField()
								.getMonstersArea().get(3));
						refreshIt();
					case "4":
						pInfo2.activateSpell(spell, pInfo2.getField()
								.getMonstersArea().get(4));
						refreshIt();

					default:
						JOptionPane.showMessageDialog(frame, "wrong number");
					}
				} else {

					if (spell instanceof MonsterReborn) {
						if (pInfo2.getField().getGraveyard().size() > 0) {
							pInfo2.activateSpell(spell, null);
							refreshIt();
						}

					} else {
						pInfo2.activateSpell(spell, null);
						refreshIt();
					}

				}
				refreshIt();
			}

		}

		if (e.getSource() == AorD) {
			if (isTrueAttack() == true) {

				setTrueAttack(false);
				AorD.setText("inDefense");

			} else {
				setTrueAttack(true);
				AorD.setText("inAttack");

			}
		}
		if (e.getSource() == sac) {
			if (isSacrifice() == true) {

				setSacrifice(false);
				sac.setText("Sacrifice Off");

			} else {
				setSacrifice(true);
				sac.setText("Sacrifice On");

			}
		}

		if (e.getSource() == addSpell) {
			if (isActivateSpell() == true) {

				setActivateSpell(false);
				addSpell.setText("Just Add Spell");

			} else {
				setActivateSpell(true);
				addSpell.setText("Activate the %$^@");

			}
		}
		if (e.getSource() == switchCard) {
			if (isSwitchIt() == true) {

				setSwitchIt(false);
				switchCard.setText("switch Off");

			} else {
				setSwitchIt(true);
				switchCard.setText("switch On");

			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {

		if (e.getSource() == b1) {
			pname1 = t1.getText();
			if (pname1.equals("")) {

				pname1 = "Player 1";
			} else {
				pN1.setText(pname1);
			}

			pname2 = t2.getText();
			if (pname2.equals("")) {
				pname2 = "Player 2";
			} else {
				pN2.setText(pname2);
			}
		}

		if (hand1.length != 0) {
			for (int i = 0; i < hand1.length; i++) {
				if (e.getSource() == hand1[i]) {
					if (i < pInfo1.getField().getHand().size()
							&& b.getActivePlayer() == pInfo1) {
						if (pInfo1.getField().getHand().get(i) instanceof MonsterCard) {
							MonsterCard m = (MonsterCard) pInfo1.getField()
									.getHand().get(i);
							infoLabel.setText("<html>" + "<br> Name: "
									+ m.getName() + "<br>" + "<br>"
									+ m.getDescription() + "<br>" + "<br> AP: "
									+ m.getAttackPoints() + "<br>"
									+ "<br> DP: " + m.getDefensePoints()
									+ "<br>" + "<br> Lvl: " + m.getLevel()
									+ "<html>");
							cardImage1.setIcon(new ImageIcon(m.getName()
									+ "1.png"));
						} else {

							SpellCard m = (SpellCard) pInfo1.getField()
									.getHand().get(i);
							infoLabel.setText("<html>" + "<br> Name: "
									+ m.getName() + "<br>" + "<br>"
									+ m.getDescription() + "<html>");

							cardImage1.setIcon(new ImageIcon(m.getName()
									+ "1.png"));
						}

					}

				}
			}
		}
		if (hand2.length != 0) {
			for (int i = 0; i < hand2.length; i++) {
				if (e.getSource() == hand2[i]) {
					if (i < pInfo2.getField().getHand().size()
							&& b.getActivePlayer() == pInfo2) {
						if (pInfo2.getField().getHand().get(i) instanceof MonsterCard) {
							MonsterCard m = (MonsterCard) pInfo2.getField()
									.getHand().get(i);
							infoLabel.setText("<html>" + "<br> Name: "
									+ m.getName() + "<br>" + "<br>"
									+ m.getDescription() + "<br>" + "<br> AP: "
									+ m.getAttackPoints() + "<br>"
									+ "<br> DP: " + m.getDefensePoints()
									+ "<br>" + "<br> Lvl: " + m.getLevel()
									+ "<html>");
							cardImage2.setIcon(new ImageIcon(m.getName()
									+ "1.png"));
						} else {

							SpellCard m = (SpellCard) pInfo2.getField()
									.getHand().get(i);
							infoLabel.setText("<html>" + "<br> Name: "
									+ m.getName() + "<br>" + "<br>"
									+ m.getDescription() + "<html>");
							cardImage2.setIcon(new ImageIcon(m.getName()
									+ "1.png"));
						}
					}
				}

			}
		}
		if (monsterArea1.length != 0) {
			for (int i = 0; i < monsterArea1.length; i++) {
				if (e.getSource() == monsterArea1[i]) {
					if (i < pInfo1.getField().getMonstersArea().size()) {
						MonsterCard m = (MonsterCard) pInfo1.getField()
								.getMonstersArea().get(i);
						if ((b.getActivePlayer() == pInfo2 && m.getMode() == Mode.ATTACK)
								|| b.getActivePlayer() == pInfo1) {
							infoLabel.setText("<html>" + "<br> Name: "
									+ m.getName() + "<br>" + "<br>"
									+ m.getDescription() + "<br>" + "<br> AP: "
									+ m.getAttackPoints() + "<br>"
									+ "<br> DP: " + m.getDefensePoints()
									+ "<br>" + "<br> Lvl: " + m.getLevel()
									+ "<html>");
							cardImage1.setVisible(true);
							cardImage1.setIcon(new ImageIcon(m.getName()
									+ "1.png"));

						}
					}
				}
			}
		}
		if (monsterArea2.length != 0) {
			for (int i = 0; i < monsterArea2.length; i++) {
				if (e.getSource() == monsterArea2[i]) {
					if (i < pInfo2.getField().getMonstersArea().size()) {
						MonsterCard m = (MonsterCard) pInfo2.getField()
								.getMonstersArea().get(i);
						if ((b.getActivePlayer() == pInfo1 && m.getMode() == Mode.ATTACK)
								|| b.getActivePlayer() == pInfo2) {
							infoLabel.setText("<html>" + "<br> Name: "
									+ m.getName() + "<br>" + "<br>"
									+ m.getDescription() + "<br>" + "<br> AP: "
									+ m.getAttackPoints() + "<br>"
									+ "<br> DP: " + m.getDefensePoints()
									+ "<br>" + "<br> Lvl: " + m.getLevel()
									+ "<html>");
							cardImage2.setVisible(true);
							cardImage2.setIcon(new ImageIcon(m.getName()
									+ "1.png"));
						}
					}
				}
			}
		}
		if (spellArea1.length != 0) {
			for (int i = 0; i < spellArea1.length; i++) {
				if (e.getSource() == spellArea1[i]) {
					if (i < pInfo1.getField().getSpellArea().size()
							&& b.getActivePlayer() == pInfo1) {
						SpellCard m = (SpellCard) pInfo1.getField()
								.getSpellArea().get(i);
						infoLabel.setText("<html>" + "<br> Name: "
								+ m.getName() + "<br>" + "<br>"
								+ m.getDescription() + "<html>");

						cardImage1
								.setIcon(new ImageIcon(m.getName() + "1.png"));

					}
				}
			}
		}
		if (spellArea2.length != 0) {
			for (int i = 0; i < spellArea2.length; i++) {
				if (e.getSource() == spellArea2[i]) {
					if (i < pInfo2.getField().getSpellArea().size()
							&& b.getActivePlayer() == pInfo2) {
						SpellCard m = (SpellCard) pInfo2.getField()
								.getSpellArea().get(i);
						infoLabel.setText("<html>" + "<br> Name: "
								+ m.getName() + "<br>" + "<br>"
								+ m.getDescription() + "<html>");

						cardImage2
								.setIcon(new ImageIcon(m.getName() + "1.png"));

					}
				}
			}
		}

		if (graveYard1.length != 0) {
			if (e.getSource() == graveYard1[0]) {
				if (pInfo1.getField().getGraveyard().size() > 0) {
					int x = (pInfo1.getField().getGraveyard().size() - 1);

					Card c = pInfo1.getField().getGraveyard().get(x);

					cardImage1.setVisible(true);
					if (c instanceof SpellCard) {
						infoLabel.setText("<html>" + "<br> Name: "
								+ c.getName() + "<br>" + "<br>"
								+ c.getDescription() + "<html>");
					} else {
						infoLabel.setText("<html>" + "<br> Name: "
								+ c.getName() + "<br>" + "<br>"
								+ c.getDescription() + "<br>" + "<br> AP: "
								+ ((MonsterCard) c).getAttackPoints() + "<br>"
								+ "<br> DP: "
								+ ((MonsterCard) c).getDefensePoints() + "<br>"
								+ "<br> Lvl: " + ((MonsterCard) c).getLevel()
								+ "<html>");

						cardImage1
								.setIcon(new ImageIcon(c.getName() + "1.png"));
					}
				}
			}
		}
		if (graveYard2.length != 0) {
			if (e.getSource() == graveYard2[0]) {
				if (pInfo2.getField().getGraveyard().size() > 0) {
					int x = (pInfo2.getField().getGraveyard().size() - 1);

					Card c = pInfo2.getField().getGraveyard().get(x);

					cardImage2.setVisible(true);
					if (c instanceof SpellCard) {
						infoLabel.setText("<html>" + "<br> Name: "
								+ c.getName() + "<br>" + "<br>"
								+ c.getDescription() + "<html>");
					} else {
						infoLabel.setText("<html>" + "<br> Name: "
								+ c.getName() + "<br>" + "<br>"
								+ c.getDescription() + "<br>" + "<br> AP: "
								+ ((MonsterCard) c).getAttackPoints() + "<br>"
								+ "<br> DP: "
								+ ((MonsterCard) c).getDefensePoints() + "<br>"
								+ "<br> Lvl: " + ((MonsterCard) c).getLevel()
								+ "<html>");

						cardImage2
								.setIcon(new ImageIcon(c.getName() + "1.png"));
					}
				}
			}
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public boolean isTrueAttack() {
		return trueAttack;
	}

	public void setTrueAttack(boolean trueAttack) {
		this.trueAttack = trueAttack;
	}

	public boolean isSacrifice() {
		return sacrifice;
	}

	public void setSacrifice(boolean sacrifice) {
		this.sacrifice = sacrifice;
	}

	public boolean isActivateSpell() {
		return activateSpell;
	}

	public void setActivateSpell(boolean activateSpell) {
		this.activateSpell = activateSpell;
	}

	public boolean isSwitchIt() {
		return switchIt;
	}

	public void setSwitchIt(boolean switchIt) {
		this.switchIt = switchIt;
	}

	public static void main(String[] args) {

		GUI Gogo = new GUI();

	}

	public boolean isFirstMons() {
		return firstMons;
	}

	public void setFirstMons(boolean firstMons) {
		this.firstMons = firstMons;
	}

}
