package com.game.ejectSurvivor.controller;

import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.game.ejectSurvivor.views.Scenario;

public class GamePlay {

	private Integer qtdCabin = 4;
	private Integer cabinRandom;
	private Integer qtdPlayerLive;
	private boolean play = true;
	private boolean everbodyDie = false;
	private JOptionPane optionPane;
	private JDialog dialog;

	public void round(Entrace entrace, Scenario scenario) throws InterruptedException {

		this.qtdPlayerLive = entrace.getQtdPlayer();
		this.everbodyDie = false;

		for (int j = 0; j < 3; j++) {
			finalVerify(entrace, scenario);
			chooseCabin(entrace);
			moveCharacter(entrace, scenario);
			if (this.qtdCabin == 2) {
				scenario.getNumberR3JL().setVisible(false);
			}
			cabinRandom = randomNumber(this.qtdCabin);
			checkDead(entrace);
			this.qtdCabin = this.qtdCabin - 1;
			desableNames(scenario);
			numberControl(scenario);
			gasControl(scenario);
		}
		finalVerify(entrace, scenario);
	}

	public void finalVerify(Entrace entrace, Scenario scenario) {
		if (this.qtdPlayerLive > 0 && this.qtdCabin < 2) {

			for (int i = 0; i < entrace.getQtdPlayer(); i++) {
				if (entrace.getArrayPlayers()[i].isAlive() == true) {

					optionPane = new JOptionPane();
					optionPane.setMessage(entrace.getArrayPlayers()[i].getName() + " sobreviveu!");
					dialog = optionPane.createDialog(null, "Sobreviventes");
					dialog.setBounds(560, 550, 280, 130);
					dialog.setVisible(true);
				}
			}
			if (this.qtdPlayerLive == entrace.getQtdPlayer()) {
				optionPane = new JOptionPane();
				optionPane.setMessage("Parabéns! Todos sobreviveram!");
				dialog = optionPane.createDialog(null, "Sobreviventes");
				dialog.setBounds(560, 550, 280, 130);
				dialog.setVisible(true);
			}
		}
		if (this.qtdPlayerLive == 0 && this.everbodyDie == false && entrace.getQtdPlayer() == 1) {
			optionPane = new JOptionPane();
			optionPane.setMessage("Você morreu!");
			dialog = optionPane.createDialog(null, "Morte");
			dialog.setBounds(560, 550, 280, 130);
			dialog.setVisible(true);
			everbodyDie = true;
		}
		if (this.qtdPlayerLive == 0 && this.everbodyDie == false) {
			optionPane = new JOptionPane();
			optionPane.setMessage("Todos morreram!");
			dialog = optionPane.createDialog(null, "Morte");
			dialog.setBounds(560, 550, 280, 130);
			dialog.setVisible(true);
			everbodyDie = true;
		}
	}

	public void desableNames(Scenario scenario) {
		if (qtdCabin <= 3) {
			scenario.getPlayer1JL().setVisible(false);
			scenario.getPlayer2JL().setVisible(false);
			scenario.getPlayer3JL().setVisible(false);
			scenario.getPlayer4JL().setVisible(false);
		}
	}

	public void chooseCabin(Entrace entrace) {
		for (int i = 0; i < entrace.getQtdPlayer(); i++) {
			if (entrace.getArrayPlayers()[i].isAlive() == true) {
				try {

					optionPane = new JOptionPane(
							entrace.getArrayPlayers()[i].getName() + ", em qual cabine você deseja entrar?");
					optionPane.setWantsInput(true);
					dialog = optionPane.createDialog(null, "Escolha de Cabine");
					dialog.setBounds(560, 550, 280, 130);
					dialog.setVisible(true);
					Integer option = Integer.parseInt((String) optionPane.getInputValue());

					if (option >= 1 && option <= this.qtdCabin) {
						entrace.getArrayPlayers()[i].setCurrentCabin(option);
					} else {
						optionPane = new JOptionPane();
						optionPane.setMessage("Cabine escolhida não existe! Você ficou na cabine atual!");
						dialog = optionPane.createDialog(null, "Escolha de Cabine");
						dialog.setBounds(560, 550, 280, 130);
						dialog.setVisible(true);
						entrace.getArrayPlayers()[i].setCurrentCabin(0);
					}
				} catch (Exception e) {
					optionPane = new JOptionPane();
					optionPane.setMessage("Cabine escolhida não existe! Você ficou na cabine atual!");
					dialog = optionPane.createDialog(null, "Escolha de Cabine");
					dialog.setBounds(560, 550, 280, 130);
					dialog.setVisible(true);
					entrace.getArrayPlayers()[i].setCurrentCabin(0);
				}
			}
		}
	}

	public Integer randomNumber(Integer maxNumber) {
		Random random = new Random();
		Integer numberRandom = random.nextInt(maxNumber);
		return numberRandom;
	}

	public void checkDead(Entrace entrace) {
		for (int i = 0; i < entrace.getQtdPlayer(); i++) {
			if (entrace.getArrayPlayers()[i].getCurrentCabin() == (this.cabinRandom + 1)
					|| entrace.getArrayPlayers()[i].getCurrentCabin() == 0
							&& entrace.getArrayPlayers()[i].isAlive() == true) {
				entrace.getArrayPlayers()[i].setAlive(false);
				entrace.getArrayPlayers()[i].setCurrentCabin(0);
				this.qtdPlayerLive = this.qtdPlayerLive - 1;
			}
		}
	}

	public void numberControl(Scenario scenario) {

		if (this.qtdCabin == 3) {
			scenario.getNumberR1JL().setVisible(false);
			scenario.getNumberR2JL().setVisible(true);
		}
		if (this.qtdCabin == 2) {
			scenario.getNumberR2JL().setVisible(false);
			scenario.getNumberR3JL().setVisible(true);
		}
		scenario.repaint();
	}

	public void gasControl(Scenario scenario) throws InterruptedException {

		if (this.everbodyDie == true) {
			scenario.getGas0JL().setVisible(true);
			scenario.getGas1JL().setVisible(true);
			scenario.getGas2JL().setVisible(true);
			scenario.getGas3JL().setVisible(true);
			scenario.getGas4JL().setVisible(true);
			scenario.getGas5JL().setVisible(true);
			scenario.getGas6JL().setVisible(true);
			scenario.getGas7JL().setVisible(true);
			scenario.getGas8JL().setVisible(true);
			scenario.getGas9JL().setVisible(true);
		}

		if (this.qtdCabin == 3 && this.everbodyDie == false) {
			Thread.sleep(3000);
			scenario.getGas0JL().setVisible(true);
		}

		if (this.qtdCabin == 2 && this.everbodyDie == false) {
			Thread.sleep(3000);
			scenario.getGas1JL().setVisible(true);
			scenario.getGas2JL().setVisible(true);
			scenario.getGas3JL().setVisible(true);
			scenario.getGas4JL().setVisible(true);
		}

		if (this.qtdCabin == 1 && this.everbodyDie == false) {
			Thread.sleep(3000);
			scenario.getGas5JL().setVisible(true);
			scenario.getGas6JL().setVisible(true);
			scenario.getGas7JL().setVisible(true);
		}

		if (this.qtdCabin == 3 && this.cabinRandom == 0) {
			scenario.getGas1JL().setVisible(true);
		} else if (this.qtdCabin == 3 && this.cabinRandom == 1) {
			scenario.getGas2JL().setVisible(true);
		} else if (this.qtdCabin == 3 && this.cabinRandom == 2) {
			scenario.getGas3JL().setVisible(true);
		} else if (this.qtdCabin == 3 && this.cabinRandom == 3) {
			scenario.getGas4JL().setVisible(true);
		}

		if (this.qtdCabin == 2 && this.cabinRandom == 0) {
			scenario.getGas5JL().setVisible(true);
		} else if (this.qtdCabin == 2 && cabinRandom == 1) {
			scenario.getGas6JL().setVisible(true);
		} else if (qtdCabin == 2 && cabinRandom == 2) {
			scenario.getGas7JL().setVisible(true);
		}

		if (qtdCabin == 1 && cabinRandom == 0) {
			scenario.getGas8JL().setVisible(true);
		} else if (qtdCabin == 1 && cabinRandom == 1) {
			scenario.getGas9JL().setVisible(true);
		}
	}

	public void playAgain(ActionEvent eventButton, Scenario scenario, Entrace entrace) {

		optionPane = new JOptionPane("Deseja jogar novamente?");
		optionPane.setOptions(new Object[] { new JButton("Sim"), new JButton("Não") });
		dialog = optionPane.createDialog(null, "Deseja jogar novamente?");
		dialog.setBounds(560, 550, 280, 130);
		dialog.setVisible(true);
		// TODO Terminar menu
		Integer playAgain = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?");

		if (playAgain == JOptionPane.YES_OPTION) {

			for (int i = 0; i < entrace.getQtdPlayer(); i++) {
				entrace.getArrayPlayers()[i].setAlive(true);
			}

			qtdCabin = 4;
			scenario.getGas0JL().setVisible(false);
			scenario.getGas1JL().setVisible(false);
			scenario.getGas2JL().setVisible(false);
			scenario.getGas3JL().setVisible(false);
			scenario.getGas4JL().setVisible(false);
			scenario.getGas5JL().setVisible(false);
			scenario.getGas6JL().setVisible(false);
			scenario.getGas7JL().setVisible(false);
			scenario.getGas8JL().setVisible(false);
			scenario.getGas9JL().setVisible(false);
			scenario.getPlayer1JL().setVisible(true);
			scenario.getPlayer2JL().setVisible(true);
			scenario.getPlayer3JL().setVisible(true);
			scenario.getPlayer4JL().setVisible(true);
			scenario.getNumberR1JL().setVisible(true);
			scenario.getNumberR2JL().setVisible(false);
			scenario.getNumberR3JL().setVisible(false);
			scenario.getHelloJL().setLocation(480, 420);
			scenario.getEtJL().setLocation(610, 420);
			scenario.getCiclopsJL().setLocation(730, 420);
			scenario.getRobotJL().setLocation(850, 420);
			scenario.repaint();

		} else {
			JOptionPane.showMessageDialog(null, "Obrigado por jogar e até a próxima!!");
			this.setPlay(false);
		}
	}

	public void moveCharacter(Entrace entrace, Scenario scenario) {

		for (int i = 0; i < entrace.getQtdPlayer(); i++) {
			if (entrace.getArrayPlayers()[i].isAlive() == true) {
				if (this.qtdCabin == 4) {
					if (i == 0 && entrace.getArrayPlayers()[i].getCurrentCabin() == 1) {
						scenario.getHelloJL().setLocation(440, 340);
					} else if (i == 0 && entrace.getArrayPlayers()[i].getCurrentCabin() == 2) {
						scenario.getHelloJL().setLocation(563, 340);
					} else if (i == 0 && entrace.getArrayPlayers()[i].getCurrentCabin() == 3) {
						scenario.getHelloJL().setLocation(686, 340);
					} else if (i == 0 && entrace.getArrayPlayers()[i].getCurrentCabin() == 4) {
						scenario.getHelloJL().setLocation(809, 340);
					}
					if (i == 1 && entrace.getArrayPlayers()[i].getCurrentCabin() == 1) {
						scenario.getEtJL().setLocation(472, 340);
					} else if (i == 1 && entrace.getArrayPlayers()[i].getCurrentCabin() == 2) {
						scenario.getEtJL().setLocation(595, 340);
					} else if (i == 1 && entrace.getArrayPlayers()[i].getCurrentCabin() == 3) {
						scenario.getEtJL().setLocation(718, 340);
					} else if (i == 1 && entrace.getArrayPlayers()[i].getCurrentCabin() == 4) {
						scenario.getEtJL().setLocation(841, 340);
					}
					if (i == 2 && entrace.getArrayPlayers()[i].getCurrentCabin() == 1) {
						scenario.getCiclopsJL().setLocation(498, 340);
					} else if (i == 2 && entrace.getArrayPlayers()[i].getCurrentCabin() == 2) {
						scenario.getCiclopsJL().setLocation(621, 340);
					} else if (i == 2 && entrace.getArrayPlayers()[i].getCurrentCabin() == 3) {
						scenario.getCiclopsJL().setLocation(744, 340);
					} else if (i == 2 && entrace.getArrayPlayers()[i].getCurrentCabin() == 4) {
						scenario.getCiclopsJL().setLocation(867, 340);
					}
					if (i == 3 && entrace.getArrayPlayers()[i].getCurrentCabin() == 1) {
						scenario.getRobotJL().setLocation(525, 340);
					} else if (i == 3 && entrace.getArrayPlayers()[i].getCurrentCabin() == 2) {
						scenario.getRobotJL().setLocation(648, 340);
					} else if (i == 3 && entrace.getArrayPlayers()[i].getCurrentCabin() == 3) {
						scenario.getRobotJL().setLocation(771, 340);
					} else if (i == 3 && entrace.getArrayPlayers()[i].getCurrentCabin() == 4) {
						scenario.getRobotJL().setLocation(894, 340);
					}
				}

				if (this.qtdCabin == 3) {
					if (i == 0 && entrace.getArrayPlayers()[i].getCurrentCabin() == 1) {
						scenario.getHelloJL().setLocation(500, 245);
					} else if (i == 0 && entrace.getArrayPlayers()[i].getCurrentCabin() == 2) {
						scenario.getHelloJL().setLocation(623, 245);
					} else if (i == 0 && entrace.getArrayPlayers()[i].getCurrentCabin() == 3) {
						scenario.getHelloJL().setLocation(748, 245);
					}
					if (i == 1 && entrace.getArrayPlayers()[i].getCurrentCabin() == 1) {
						scenario.getEtJL().setLocation(532, 245);
					} else if (i == 1 && entrace.getArrayPlayers()[i].getCurrentCabin() == 2) {
						scenario.getEtJL().setLocation(655, 245);
					} else if (i == 1 && entrace.getArrayPlayers()[i].getCurrentCabin() == 3) {
						scenario.getEtJL().setLocation(780, 245);
					}
					if (i == 2 && entrace.getArrayPlayers()[i].getCurrentCabin() == 1) {
						scenario.getCiclopsJL().setLocation(558, 245);
					} else if (i == 2 && entrace.getArrayPlayers()[i].getCurrentCabin() == 2) {
						scenario.getCiclopsJL().setLocation(681, 245);
					} else if (i == 2 && entrace.getArrayPlayers()[i].getCurrentCabin() == 3) {
						scenario.getCiclopsJL().setLocation(806, 245);
					}
					if (i == 3 && entrace.getArrayPlayers()[i].getCurrentCabin() == 1) {
						scenario.getRobotJL().setLocation(585, 245);
					} else if (i == 3 && entrace.getArrayPlayers()[i].getCurrentCabin() == 2) {
						scenario.getRobotJL().setLocation(708, 245);
					} else if (i == 3 && entrace.getArrayPlayers()[i].getCurrentCabin() == 3) {
						scenario.getRobotJL().setLocation(833, 245);
					}
				}

				if (this.qtdCabin == 2) {
					if (i == 0 && entrace.getArrayPlayers()[i].getCurrentCabin() == 1) {
						scenario.getHelloJL().setLocation(560, 150);
					} else if (i == 0 && entrace.getArrayPlayers()[i].getCurrentCabin() == 2) {
						scenario.getHelloJL().setLocation(687, 150);
					}
					if (i == 1 && entrace.getArrayPlayers()[i].getCurrentCabin() == 1) {
						scenario.getEtJL().setLocation(592, 150);
					} else if (i == 1 && entrace.getArrayPlayers()[i].getCurrentCabin() == 2) {
						scenario.getEtJL().setLocation(719, 150);
					}
					if (i == 2 && entrace.getArrayPlayers()[i].getCurrentCabin() == 1) {
						scenario.getCiclopsJL().setLocation(618, 150);
					} else if (i == 2 && entrace.getArrayPlayers()[i].getCurrentCabin() == 2) {
						scenario.getCiclopsJL().setLocation(745, 150);
					}
					if (i == 3 && entrace.getArrayPlayers()[i].getCurrentCabin() == 1) {
						scenario.getRobotJL().setLocation(645, 150);
					} else if (i == 3 && entrace.getArrayPlayers()[i].getCurrentCabin() == 2) {
						scenario.getRobotJL().setLocation(772, 150);
					}
				}
			}
		}
		scenario.repaint();
	}

	public boolean isPlay() {
		return play;
	}

	public void setPlay(boolean play) {
		this.play = play;
	}
}
