package com.game.ejectSurvivor.views;

import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Scenario extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;

	private Music music = new Music();
	private boolean enter = false;

	private String player1S;
	private String player2S;
	private String player3S;
	private String player4S;

	private JLabel titleJL;
	private JLabel autorJL;
	private JLabel pressEnterJL;
	private JLabel space1JL;
	private JLabel naveJL;
	private JLabel helloJL;
	private JLabel etJL;
	private JLabel ciclopsJL;
	private JLabel robotJL;
	private JLabel fire1JL;
	private JLabel fire2JL;
	private JLabel player1JL;
	private JLabel player2JL;
	private JLabel player3JL;
	private JLabel player4JL;
	private JLabel gas0JL;
	private JLabel gas1JL;
	private JLabel gas2JL;
	private JLabel gas3JL;
	private JLabel gas4JL;
	private JLabel gas5JL;
	private JLabel gas6JL;
	private JLabel gas7JL;
	private JLabel gas8JL;
	private JLabel gas9JL;
	private JLabel numberR1JL;
	private JLabel numberR2JL;
	private JLabel numberR3JL;

	private Icon spaceI = new ImageIcon("views/images/space.gif");
	private Icon space1I = new ImageIcon("views/images/space1.gif");
	private Icon titleI = new ImageIcon("views/images/title.png");
	private Icon autorI = new ImageIcon("views/images/autor.png");
	private Icon pressEnterI = new ImageIcon("views/images/pressEnters.gif");
	private Icon naveI = new ImageIcon("views/images/nave.png");
	private Icon helloI = new ImageIcon("views/images/hello.gif");
	private Icon etI = new ImageIcon("views/images/et.gif");
	private Icon ciclopsI = new ImageIcon("views/images/ciclops.gif");
	private Icon robotI = new ImageIcon("views/images/robot.gif");
	private Icon fireI = new ImageIcon("views/images/fire.gif");
	private Icon gas0I = new ImageIcon("views/images/gas0.gif");
	private Icon gas1I = new ImageIcon("views/images/gas1.gif");
	private Icon numberR1I = new ImageIcon("views/images/numberR1.png");
	private Icon numberR2I = new ImageIcon("views/images/numberR2.png");
	private Icon numberR3I = new ImageIcon("views/images/numberR3.png");

	public Scenario() {

		super("Eject Survivor");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new JLabel(spaceI));
		getContentPane();
		setSize(1366, 768);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		space1JL = new JLabel(space1I);
		space1JL.setSize(1366, 768);
		space1JL.setLocation(0, 0);
		space1JL.setVisible(true);

		titleJL = new JLabel(titleI);
		titleJL.setSize(800, 200);
		titleJL.setLocation(300, 150);
		titleJL.setVisible(true);

		autorJL = new JLabel(autorI);
		autorJL.setSize(300, 20);
		autorJL.setLocation(760, 340);
		autorJL.setVisible(true);

		pressEnterJL = new JLabel(pressEnterI);
		pressEnterJL.setSize(200, 20);
		pressEnterJL.setLocation(575, 540);
		pressEnterJL.setVisible(true);

		naveJL = new JLabel(naveI);
		naveJL.setSize(800, 600);
		naveJL.setLocation(300, 80);
		naveJL.setVisible(false);

		helloJL = new JLabel(helloI);
		helloJL.setSize(60, 60);
		helloJL.setLocation(480, 420);
		helloJL.setVisible(false);

		etJL = new JLabel(etI);
		etJL.setSize(60, 60);
		etJL.setLocation(610, 420);
		etJL.setVisible(false);

		ciclopsJL = new JLabel(ciclopsI);
		ciclopsJL.setSize(60, 60);
		ciclopsJL.setLocation(730, 420);
		ciclopsJL.setVisible(false);

		robotJL = new JLabel(robotI);
		robotJL.setSize(60, 60);
		robotJL.setLocation(850, 420);
		robotJL.setVisible(false);

		fire1JL = new JLabel(fireI);
		fire1JL.setSize(100, 50);
		fire1JL.setLocation(340, 620);
		fire1JL.setVisible(false);

		fire2JL = new JLabel(fireI);
		fire2JL.setSize(100, 50);
		fire2JL.setLocation(955, 620);
		fire2JL.setVisible(false);

		gas0JL = new JLabel(gas0I);
		gas0JL.setSize(483, 78);
		gas0JL.setLocation(455, 420);
		gas0JL.setVisible(false);

		gas1JL = new JLabel(gas1I);
		gas1JL.setSize(115, 80);
		gas1JL.setLocation(455, 330);
		gas1JL.setVisible(false);

		gas2JL = new JLabel(gas1I);
		gas2JL.setSize(115, 80);
		gas2JL.setLocation(575, 330);
		gas2JL.setVisible(false);

		gas3JL = new JLabel(gas1I);
		gas3JL.setSize(115, 80);
		gas3JL.setLocation(700, 330);
		gas3JL.setVisible(false);

		gas4JL = new JLabel(gas1I);
		gas4JL.setSize(115, 80);
		gas4JL.setLocation(825, 330);
		gas4JL.setVisible(false);

		gas5JL = new JLabel(gas1I);
		gas5JL.setSize(115, 80);
		gas5JL.setLocation(515, 235);
		gas5JL.setVisible(false);

		gas6JL = new JLabel(gas1I);
		gas6JL.setSize(115, 80);
		gas6JL.setLocation(640, 235);
		gas6JL.setVisible(false);

		gas7JL = new JLabel(gas1I);
		gas7JL.setSize(115, 80);
		gas7JL.setLocation(762, 235);
		gas7JL.setVisible(false);

		gas8JL = new JLabel(gas1I);
		gas8JL.setSize(115, 80);
		gas8JL.setLocation(580, 140);
		gas8JL.setVisible(false);

		gas9JL = new JLabel(gas1I);
		gas9JL.setSize(115, 80);
		gas9JL.setLocation(705, 140);
		gas9JL.setVisible(false);

		numberR1JL = new JLabel(numberR1I);
		numberR1JL.setSize(485, 81);
		numberR1JL.setLocation(455, 330);
		numberR1JL.setVisible(true);

		numberR2JL = new JLabel(numberR2I);
		numberR2JL.setSize(371, 81);
		numberR2JL.setLocation(510, 235);
		numberR2JL.setVisible(false);

		numberR3JL = new JLabel(numberR3I);
		numberR3JL.setSize(254, 81);
		numberR3JL.setLocation(568, 140);
		numberR3JL.setVisible(false);

	}

	public void start() throws InterruptedException {
//		music.playMusic();
		addItens();
		pressEnter();
		setVisible(true);
	}

	public void addItens() {
		add(titleJL);
		add(autorJL);
		add(gas0JL);
		add(gas1JL);
		add(gas2JL);
		add(gas3JL);
		add(gas4JL);
		add(gas5JL);
		add(gas6JL);
		add(gas7JL);
		add(gas8JL);
		add(gas9JL);
		add(helloJL);
		add(etJL);
		add(ciclopsJL);
		add(robotJL);
	}

	public void addPlayers(Integer qtdPlayer) {
		player1JL = new JLabel(player1S);
		player1JL.setSize(100, 20);
		player1JL.setLocation(485, 480);
		player1JL.setVisible(false);
		add(player1JL);

		player2JL = new JLabel(player2S);
		player2JL.setSize(100, 20);
		player2JL.setLocation(615, 480);
		player2JL.setVisible(false);
		add(player2JL);

		player3JL = new JLabel(player3S);
		player3JL.setSize(100, 20);
		player3JL.setLocation(735, 480);
		player3JL.setVisible(false);
		add(player3JL);

		player4JL = new JLabel(player4S);
		player4JL.setSize(100, 20);
		player4JL.setLocation(855, 480);
		player4JL.setVisible(false);
		add(player4JL);

		if (qtdPlayer == 1) {
			helloJL.setVisible(true);
			player1JL.setVisible(true);
		} else if (qtdPlayer == 2) {
			helloJL.setVisible(true);
			etJL.setVisible(true);
			player1JL.setVisible(true);
			player2JL.setVisible(true);
		} else if (qtdPlayer == 3) {
			helloJL.setVisible(true);
			etJL.setVisible(true);
			ciclopsJL.setVisible(true);
			player1JL.setVisible(true);
			player2JL.setVisible(true);
			player3JL.setVisible(true);
		} else if (qtdPlayer == 4) {
			helloJL.setVisible(true);
			etJL.setVisible(true);
			ciclopsJL.setVisible(true);
			robotJL.setVisible(true);
			player1JL.setVisible(true);
			player2JL.setVisible(true);
			player3JL.setVisible(true);
			player4JL.setVisible(true);
		}
		add(fire1JL);
		add(fire2JL);
		add(numberR1JL);
		add(numberR2JL);
		add(numberR3JL);
		add(naveJL);
		add(space1JL);
		repaint();
	}

	public void pressEnter() {
		TextField t = new TextField("");
		add(t);
		t.addKeyListener(this);
	}

	public boolean isEnter() {
		return enter;
	}

	public void setEnter(boolean enter) {
		this.enter = enter;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_ENTER && this.isEnter() == false) {
			this.setEnter(true);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	public String getPlayer1S() {
		return player1S;
	}

	public void setPlayer1S(String player1s) {
		player1S = player1s;
	}

	public String getPlayer2S() {
		return player2S;
	}

	public void setPlayer2S(String player2s) {
		player2S = player2s;
	}

	public String getPlayer3S() {
		return player3S;
	}

	public void setPlayer3S(String player3s) {
		player3S = player3s;
	}

	public String getPlayer4S() {
		return player4S;
	}

	public void setPlayer4S(String player4s) {
		player4S = player4s;
	}

	public JLabel getTitleJL() {
		return titleJL;
	}

	public JLabel getAutorJL() {
		return autorJL;
	}

	public JLabel getPressEnterJL() {
		return pressEnterJL;
	}

	public JLabel getNaveJL() {
		return naveJL;
	}

	public JLabel getSpace1JL() {
		return space1JL;
	}

	public JLabel getPlayer1JL() {
		return player1JL;
	}

	public void setPlayer1JL(JLabel player1jl) {
		player1JL = player1jl;
	}

	public JLabel getPlayer2JL() {
		return player2JL;
	}

	public void setPlayer2JL(JLabel player2jl) {
		player2JL = player2jl;
	}

	public JLabel getPlayer3JL() {
		return player3JL;
	}

	public void setPlayer3JL(JLabel player3jl) {
		player3JL = player3jl;
	}

	public JLabel getPlayer4JL() {
		return player4JL;
	}

	public void setPlayer4JL(JLabel player4jl) {
		player4JL = player4jl;
	}

	public JLabel getFire1JL() {
		return fire1JL;
	}

	public JLabel getFire2JL() {
		return fire2JL;
	}

	public JLabel getGas0JL() {
		return gas0JL;
	}

	public JLabel getGas1JL() {
		return gas1JL;
	}

	public JLabel getGas2JL() {
		return gas2JL;
	}

	public JLabel getGas3JL() {
		return gas3JL;
	}

	public JLabel getGas4JL() {
		return gas4JL;
	}

	public JLabel getGas5JL() {
		return gas5JL;
	}

	public JLabel getGas6JL() {
		return gas6JL;
	}

	public JLabel getGas7JL() {
		return gas7JL;
	}

	public JLabel getGas8JL() {
		return gas8JL;
	}

	public JLabel getGas9JL() {
		return gas9JL;
	}

	public JLabel getHelloJL() {
		return helloJL;
	}

	public void setHelloJL(JLabel helloJL) {
		this.helloJL = helloJL;
	}

	public JLabel getEtJL() {
		return etJL;
	}

	public void setEtJL(JLabel etJL) {
		this.etJL = etJL;
	}

	public JLabel getCiclopsJL() {
		return ciclopsJL;
	}

	public void setCiclopsJL(JLabel ciclopsJL) {
		this.ciclopsJL = ciclopsJL;
	}

	public JLabel getRobotJL() {
		return robotJL;
	}

	public void setRobotJL(JLabel robotJL) {
		this.robotJL = robotJL;
	}

	public JLabel getNumberR1JL() {
		return numberR1JL;
	}

	public JLabel getNumberR2JL() {
		return numberR2JL;
	}

	public JLabel getNumberR3JL() {
		return numberR3JL;
	}

}
