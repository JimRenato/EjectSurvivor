package com.rsm;

import javax.swing.*;

class Entrace {

    private Integer qtdPlayer;
    private Player[] arrayPlayers = new Player[4];
    private boolean pressEnter = true;
    private JOptionPane optionPane;
    private JDialog dialog;

    private Integer setPlayer() {

        try {
            optionPane = new JOptionPane("How many players will play? (1, 2, 3 or 4)");
            optionPane.setWantsInput(true);
            dialog = optionPane.createDialog(null, "Number of Players");
            dialog.setBounds(795, 600, 350, 130);
            dialog.setVisible(true);
            qtdPlayer = Integer.parseInt((String) optionPane.getInputValue());

            if (qtdPlayer >= 1 && qtdPlayer <= 4) {
                return qtdPlayer;
            } else {
                return invalidValue();
            }
        } catch (Exception e) {
            return invalidValue();
        }
    }

    private Integer invalidValue() {
        optionPane = new JOptionPane();
        optionPane.setMessage("Invalid value! Try again!");
        dialog = optionPane.createDialog(null, "Number of Players");
        dialog.setBounds(795, 600, 350, 130);
        dialog.setVisible(true);
        return setPlayer();
    }

    private void setNamePlayer(Integer qtdPlayer, Scenario scenario) {

        String name;
        if (qtdPlayer == 1) {

            optionPane = new JOptionPane("What is your name?");
            optionPane.setWantsInput(true);
            dialog = optionPane.createDialog(null, "Type your name:");
            dialog.setBounds(795, 600, 350, 130);
            dialog.setVisible(true);
            name = ((String) optionPane.getInputValue());

            if (name.equals("") || name.equals(" ")) {
                name = "Player 1";
            }
            Player player = new Player(name);
            arrayPlayers[0] = player;
            scenario.setPlayer1S(name);
            scenario.addPlayers(qtdPlayer);

        } else if (qtdPlayer > 1) {

            StringBuilder fullName = new StringBuilder(" ");
            String array[];

            for (int i = 0; i < qtdPlayer; i++) {

                optionPane = new JOptionPane("Enter the player's name " + (i + 1) + ":");
                optionPane.setWantsInput(true);
                dialog = optionPane.createDialog(null, "Defining Players' Name");
                dialog.setBounds(795, 600, 350, 130);
                dialog.setVisible(true);
                name = ((String) optionPane.getInputValue());

                if (name.equals("") || name.equals(" ")) {
                    name = "Player " + (i + 1);
                }
                Player player = new Player(name);
                arrayPlayers[i] = player;
                fullName.append(";").append(name);
            }

            array = fullName.toString().split(";");

            if (qtdPlayer == 2) {
                scenario.setPlayer1S(array[1]);
                scenario.setPlayer2S(array[2]);
                scenario.addPlayers(qtdPlayer);
            } else if (qtdPlayer == 3) {
                scenario.setPlayer1S(array[1]);
                scenario.setPlayer2S(array[2]);
                scenario.setPlayer3S(array[3]);
                scenario.addPlayers(qtdPlayer);
            } else if (qtdPlayer == 4) {
                scenario.setPlayer1S(array[1]);
                scenario.setPlayer2S(array[2]);
                scenario.setPlayer3S(array[3]);
                scenario.setPlayer4S(array[4]);
                scenario.addPlayers(qtdPlayer);
            }
        }
        scenario.getFire1JL().setVisible(true);
        scenario.getFire2JL().setVisible(true);
        scenario.getNaveJL().setVisible(true);
    }

    void waitEnter(Scenario scenario) {
        while (pressEnter) {
            if (scenario.isEnter()) {
                scenario.getSpace1JL().setVisible(true);
                qtdPlayer = setPlayer();
                setNamePlayer(qtdPlayer, scenario);
                pressEnter = false;
                scenario.getTitleJL().setVisible(false);
                scenario.getAutorJL().setVisible(false);
                scenario.getPressEnterJL().setVisible(false);
            } else {
                System.out.print("");
            }
        }
    }

    Integer getQtdPlayer() {
        return qtdPlayer;
    }

    Player[] getArrayPlayers() {
        return arrayPlayers;
    }

}
