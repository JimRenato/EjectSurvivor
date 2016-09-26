package com.game.ejectSurvivor.controller;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.game.ejectSurvivor.model.Player;
import com.game.ejectSurvivor.views.Scenario;

public class Entrace {

	private Integer qtdPlayer;
	private Player[] arrayPlayers = new Player[4];
	private boolean pressEnter = true;
	private String name = " ";
	private JOptionPane optionPane;
	private JDialog dialog;

	public Integer setPlayer(Scenario scenario) {

		try {
			optionPane = new JOptionPane("Quantos jogadores irão jogar? (1, 2, 3 ou 4)");
			optionPane.setWantsInput(true);
			dialog = optionPane.createDialog(null, "Quantidade de Jogadores");
			dialog.setBounds(520, 550, 350, 130);
			dialog.setVisible(true);
			qtdPlayer = Integer.parseInt((String) optionPane.getInputValue());

			if (qtdPlayer >= 1 && qtdPlayer <= 4) {
				return qtdPlayer;
			} else {
				optionPane = new JOptionPane("Valor inválido! Tente novamente!");
				optionPane.setMessage("Valor inválido! Tente novamente!");
				dialog = optionPane.createDialog(null, "Quantidade de Jogadores");
				dialog.setBounds(520, 550, 350, 130);
				dialog.setVisible(true);
				return setPlayer(scenario);
			}
		} catch (Exception e) {
			optionPane = new JOptionPane();
			optionPane.setMessage("Valor inválido! Tente novamente!");
			dialog = optionPane.createDialog(null, "Quantidade de Jogadores");
			dialog.setBounds(520, 550, 350, 130);
			dialog.setVisible(true);
			return setPlayer(scenario);
		}
	}

	public void setNamePlayer(Integer qtdPlayer, Scenario scenario) {

		if (qtdPlayer == 1) {

			optionPane = new JOptionPane("Qual é o seu nome?");
			optionPane.setWantsInput(true);
			dialog = optionPane.createDialog(null, "Digite seu nome:");
			dialog.setBounds(520, 550, 350, 130);
			dialog.setVisible(true);
			name = ((String) optionPane.getInputValue());

			if (name.equals("") || name.equals(" ") || name == null) {
				name = "Jogador 1";
			}
			Player player = new Player(name);
			arrayPlayers[0] = player;
			scenario.setPlayer1S(name);
			scenario.addPlayers(qtdPlayer);

		} else if (qtdPlayer > 1) {

			String fullName = " ";
			String array[] = new String[5];

			for (int i = 0; i < qtdPlayer; i++) {

				optionPane = new JOptionPane("Digite o nome do jogador " + (i + 1) + ":");
				optionPane.setWantsInput(true);
				dialog = optionPane.createDialog(null, "Defindo nome dos Jogadores");
				dialog.setBounds(520, 550, 350, 130);
				dialog.setVisible(true);
				name = ((String) optionPane.getInputValue());

				if (name.equals("") || name.equals(" ") || name == null) {
					name = "Jogador " + (i + 1);
				}
				Player player = new Player(name);
				arrayPlayers[i] = player;
				fullName = fullName + ";" + name;
			}

			array = fullName.split(";");

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

	public void waitEnter(Scenario scenario) {
		while (pressEnter) {
			if (scenario.isEnter() == true) {
				scenario.getSpace1JL().setVisible(true);
				qtdPlayer = setPlayer(scenario);
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

	public Integer getQtdPlayer() {
		return qtdPlayer;
	}

	public void setQtdPlayer(Integer qtdPlayer) {
		this.qtdPlayer = qtdPlayer;
	}

	public Player[] getArrayPlayers() {
		return arrayPlayers;
	}

	public void setArrayPlayers(Player[] arrayPlayers) {
		this.arrayPlayers = arrayPlayers;
	}
}
