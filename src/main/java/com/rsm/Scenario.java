package com.rsm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

    Scenario() {
        super("Eject Survivor");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Icon spaceI = new ImageIcon("src/main/resources/images/space.gif");
        setContentPane(new JLabel(spaceI));
        getContentPane();
        setSize(1920, 1080);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        Icon space1I = new ImageIcon("src/main/resources/images/space1.gif");
        space1JL = new JLabel(space1I);
        space1JL.setSize(1920, 1080);
        space1JL.setLocation(0, 0);
        space1JL.setVisible(false);

        Icon titleI = new ImageIcon("src/main/resources/images/title.png");
        titleJL = new JLabel(titleI);
        titleJL.setSize(800, 200);
        titleJL.setLocation(580, 150);
        titleJL.setVisible(true);

        Icon autorI = new ImageIcon("src/main/resources/images/autor.png");
        autorJL = new JLabel(autorI);
        autorJL.setSize(300, 20);
        autorJL.setLocation(1040, 340);
        autorJL.setVisible(true);

        Icon pressEnterI = new ImageIcon("src/main/resources/images/pressEnters.gif");
        pressEnterJL = new JLabel(pressEnterI);
        pressEnterJL.setSize(200, 20);
        pressEnterJL.setLocation(575, 540);
        pressEnterJL.setVisible(true);

        Icon naveI = new ImageIcon("src/main/resources/images/nave.png");
        naveJL = new JLabel(naveI);
        naveJL.setSize(800, 600);
        naveJL.setLocation(575, 80);
        naveJL.setVisible(false);

        Icon helloI = new ImageIcon("src/main/resources/images/hello.gif");
        helloJL = new JLabel(helloI);
        helloJL.setSize(60, 60);
        helloJL.setLocation(755, 420);
        helloJL.setVisible(false);

        Icon etI = new ImageIcon("src/main/resources/images/et.gif");
        etJL = new JLabel(etI);
        etJL.setSize(60, 60);
        etJL.setLocation(885, 420);
        etJL.setVisible(false);

        Icon ciclopsI = new ImageIcon("src/main/resources/images/ciclops.gif");
        ciclopsJL = new JLabel(ciclopsI);
        ciclopsJL.setSize(60, 60);
        ciclopsJL.setLocation(1005, 420);
        ciclopsJL.setVisible(false);

        Icon robotI = new ImageIcon("src/main/resources/images/robot.gif");
        robotJL = new JLabel(robotI);
        robotJL.setSize(60, 60);
        robotJL.setLocation(1125, 420);
        robotJL.setVisible(false);

        Icon fireI = new ImageIcon("src/main/resources/images/fire.gif");
        fire1JL = new JLabel(fireI);
        fire1JL.setSize(100, 50);
        fire1JL.setLocation(615, 620);
        fire1JL.setVisible(false);

        fire2JL = new JLabel(fireI);
        fire2JL.setSize(100, 50);
        fire2JL.setLocation(1230, 620);
        fire2JL.setVisible(false);

        Icon gas0I = new ImageIcon("src/main/resources/images/gas0.gif");
        gas0JL = new JLabel(gas0I);
        gas0JL.setSize(483, 78);
        gas0JL.setLocation(730, 420);
        gas0JL.setVisible(false);

        Icon gas1I = new ImageIcon("src/main/resources/images/gas1.gif");
        gas1JL = new JLabel(gas1I);
        gas1JL.setSize(115, 80);
        gas1JL.setLocation(730, 330);
        gas1JL.setVisible(false);

        gas2JL = new JLabel(gas1I);
        gas2JL.setSize(115, 80);
        gas2JL.setLocation(850, 330);
        gas2JL.setVisible(false);

        gas3JL = new JLabel(gas1I);
        gas3JL.setSize(115, 80);
        gas3JL.setLocation(975, 330);
        gas3JL.setVisible(false);

        gas4JL = new JLabel(gas1I);
        gas4JL.setSize(115, 80);
        gas4JL.setLocation(1100, 330);
        gas4JL.setVisible(false);

        gas5JL = new JLabel(gas1I);
        gas5JL.setSize(115, 80);
        gas5JL.setLocation(790, 235);
        gas5JL.setVisible(false);

        gas6JL = new JLabel(gas1I);
        gas6JL.setSize(115, 80);
        gas6JL.setLocation(915, 235);
        gas6JL.setVisible(false);

        gas7JL = new JLabel(gas1I);
        gas7JL.setSize(115, 80);
        gas7JL.setLocation(1037, 235);
        gas7JL.setVisible(false);

        gas8JL = new JLabel(gas1I);
        gas8JL.setSize(115, 80);
        gas8JL.setLocation(855, 140);
        gas8JL.setVisible(false);

        gas9JL = new JLabel(gas1I);
        gas9JL.setSize(115, 80);
        gas9JL.setLocation(980, 140);
        gas9JL.setVisible(false);

        Icon numberR1I = new ImageIcon("src/main/resources/images/numberR1.png");
        numberR1JL = new JLabel(numberR1I);
        numberR1JL.setSize(485, 81);
        numberR1JL.setLocation(730, 330);
        numberR1JL.setVisible(true);

        Icon numberR2I = new ImageIcon("src/main/resources/images/numberR2.png");
        numberR2JL = new JLabel(numberR2I);
        numberR2JL.setSize(371, 81);
        numberR2JL.setLocation(785, 235);
        numberR2JL.setVisible(false);

        Icon numberR3I = new ImageIcon("src/main/resources/images/numberR3.png");
        numberR3JL = new JLabel(numberR3I);
        numberR3JL.setSize(254, 81);
        numberR3JL.setLocation(843, 140);
        numberR3JL.setVisible(false);
    }

    void start() {
        music.playMusic();
        addItens();
        pressEnter();
        setVisible(true);
    }

    private void addItens() {
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

    void addPlayers(Integer qtdPlayer) {
        player1JL = new JLabel(player1S);
        player1JL.setSize(100, 20);
        player1JL.setLocation(760, 480);
        player1JL.setVisible(false);
        add(player1JL);

        player2JL = new JLabel(player2S);
        player2JL.setSize(100, 20);
        player2JL.setLocation(890, 480);
        player2JL.setVisible(false);
        add(player2JL);

        player3JL = new JLabel(player3S);
        player3JL.setSize(100, 20);
        player3JL.setLocation(1010, 480);
        player3JL.setVisible(false);
        add(player3JL);

        player4JL = new JLabel(player4S);
        player4JL.setSize(100, 20);
        player4JL.setLocation(1130, 480);
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

    private void pressEnter() {
        TextField t = new TextField("");
        add(t);
        t.addKeyListener(this);
    }

    boolean isEnter() {
        return enter;
    }

    private void setEnter() {
        this.enter = true;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_ENTER && !this.isEnter()) {
            this.setEnter();
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    void setPlayer1S(String player1s) {
        player1S = player1s;
    }

    void setPlayer2S(String player2s) {
        player2S = player2s;
    }

    void setPlayer3S(String player3s) {
        player3S = player3s;
    }

    void setPlayer4S(String player4s) {
        player4S = player4s;
    }

    JLabel getTitleJL() {
        return titleJL;
    }

    JLabel getAutorJL() {
        return autorJL;
    }

    JLabel getPressEnterJL() {
        return pressEnterJL;
    }

    JLabel getNaveJL() {
        return naveJL;
    }

    JLabel getSpace1JL() {
        return space1JL;
    }

    JLabel getPlayer1JL() {
        return player1JL;
    }

    JLabel getPlayer2JL() {
        return player2JL;
    }

    JLabel getPlayer3JL() {
        return player3JL;
    }

    JLabel getPlayer4JL() {
        return player4JL;
    }

    JLabel getFire1JL() {
        return fire1JL;
    }

    JLabel getFire2JL() {
        return fire2JL;
    }

    JLabel getGas0JL() {
        return gas0JL;
    }

    JLabel getGas1JL() {
        return gas1JL;
    }

    JLabel getGas2JL() {
        return gas2JL;
    }

    JLabel getGas3JL() {
        return gas3JL;
    }

    JLabel getGas4JL() {
        return gas4JL;
    }

    JLabel getGas5JL() {
        return gas5JL;
    }

    JLabel getGas6JL() {
        return gas6JL;
    }

    JLabel getGas7JL() {
        return gas7JL;
    }

    JLabel getGas8JL() {
        return gas8JL;
    }

    JLabel getGas9JL() {
        return gas9JL;
    }

    JLabel getHelloJL() {
        return helloJL;
    }

    JLabel getEtJL() {
        return etJL;
    }

    JLabel getCiclopsJL() {
        return ciclopsJL;
    }

    JLabel getRobotJL() {
        return robotJL;
    }

    JLabel getNumberR1JL() {
        return numberR1JL;
    }

    JLabel getNumberR2JL() {
        return numberR2JL;
    }

    JLabel getNumberR3JL() {
        return numberR3JL;
    }

}
