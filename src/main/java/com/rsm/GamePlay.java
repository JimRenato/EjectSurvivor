package com.rsm;

import javax.swing.*;
import java.util.Random;

class GamePlay {

    private Integer qtyCabin = 4;
    private Integer cabinRandom;
    private Integer qtyPlayerLive;
    private boolean play = true;
    private boolean isEverbodyDie = false;
    private JOptionPane optionPane;
    private JDialog dialog;

    void round(Entrace entrace, Scenario scenario) throws InterruptedException {

        this.qtyPlayerLive = entrace.getQtdPlayer();
        this.isEverbodyDie = false;

        for (int j = 0; j < 3; j++) {
            finalVerify(entrace);
            chooseCabin(entrace);
            moveCharacter(entrace, scenario);
            if (this.qtyCabin == 2) {
                scenario.getNumberR3JL().setVisible(false);
            }
            cabinRandom = randomNumber(this.qtyCabin);
            checkDead(entrace);
            this.qtyCabin = this.qtyCabin - 1;
            disableNames(scenario);
            numberControl(scenario);
            gasControl(scenario);
        }
        finalVerify(entrace);
    }

    private void finalVerify(Entrace entrace) {
        if (this.qtyPlayerLive > 0 && this.qtyCabin < 2) {

            for (int i = 0; i < entrace.getQtdPlayer(); i++) {
                if (entrace.getArrayPlayers()[i].isAlive()) {

                    optionPane = new JOptionPane();
                    optionPane.setMessage(entrace.getArrayPlayers()[i].getName() + " survived!");
                    dialog = optionPane.createDialog(null, "Survivors");
                    dialog.setBounds(795, 600, 350, 130);
                    dialog.setVisible(true);
                }
            }
            if (this.qtyPlayerLive.equals(entrace.getQtdPlayer())) {
                optionPane = new JOptionPane();
                optionPane.setMessage("Congratulations! All survived!");
                dialog = optionPane.createDialog(null, "Survivors");
                dialog.setBounds(795, 600, 350, 130);
                dialog.setVisible(true);
            }
        }
        if (this.qtyPlayerLive == 0 && !this.isEverbodyDie && entrace.getQtdPlayer() == 1) {
            optionPane = new JOptionPane();
            optionPane.setMessage("You died!");
            dialog = optionPane.createDialog(null, "Death");
            dialog.setBounds(795, 600, 350, 130);
            dialog.setVisible(true);
            isEverbodyDie = true;
        }
        if (this.qtyPlayerLive == 0 && !this.isEverbodyDie) {
            optionPane = new JOptionPane();
            optionPane.setMessage("Everybody died!");
            dialog = optionPane.createDialog(null, "Death");
            dialog.setBounds(795, 600, 350, 130);
            dialog.setVisible(true);
            isEverbodyDie = true;
        }
    }

    private void disableNames(Scenario scenario) {
        if (qtyCabin <= 3) {
            scenario.getPlayer1JL().setVisible(false);
            scenario.getPlayer2JL().setVisible(false);
            scenario.getPlayer3JL().setVisible(false);
            scenario.getPlayer4JL().setVisible(false);
        }
    }

    private void chooseCabin(Entrace entrace) {
        for (int i = 0; i < entrace.getQtdPlayer(); i++) {
            if (entrace.getArrayPlayers()[i].isAlive()) {
                try {
                    optionPane = new JOptionPane(
                            entrace.getArrayPlayers()[i].getName() + ", which cabin do you want to enter?");
                    optionPane.setWantsInput(true);
                    dialog = optionPane.createDialog(null, "Choice of Cabin");
                    dialog.setBounds(795, 600, 350, 130);
                    dialog.setVisible(true);
                    Integer option = Integer.parseInt((String) optionPane.getInputValue());

                    if (option >= 1 && option <= this.qtyCabin) {
                        entrace.getArrayPlayers()[i].setCurrentCabin(option);
                    } else {
                        cabinNotExist(entrace, i);
                    }
                } catch (Exception e) {
                    cabinNotExist(entrace, i);
                }
            }
        }
    }

    private void cabinNotExist(Entrace entrace, int i) {
        optionPane = new JOptionPane();
        optionPane.setMessage("Cabin chosen does not exist! You stayed in the current cabin.!");
        dialog = optionPane.createDialog(null, "Choice of Cabin");
        dialog.setBounds(745, 600, 450, 130);
        dialog.setVisible(true);
        entrace.getArrayPlayers()[i].setCurrentCabin(0);
    }

    private Integer randomNumber(Integer maxNumber) {
        Random random = new Random();
        return random.nextInt(maxNumber);
    }

    private void checkDead(Entrace entrace) {
        for (int i = 0; i < entrace.getQtdPlayer(); i++) {
            if (entrace.getArrayPlayers()[i].getCurrentCabin() == (this.cabinRandom + 1)
                    || entrace.getArrayPlayers()[i].getCurrentCabin() == 0
                    && entrace.getArrayPlayers()[i].isAlive()) {
                entrace.getArrayPlayers()[i].setAlive(false);
                entrace.getArrayPlayers()[i].setCurrentCabin(0);
                this.qtyPlayerLive = this.qtyPlayerLive - 1;
            }
        }
    }

    private void numberControl(Scenario scenario) {

        if (this.qtyCabin == 3) {
            scenario.getNumberR1JL().setVisible(false);
            scenario.getNumberR2JL().setVisible(true);
        }
        if (this.qtyCabin == 2) {
            scenario.getNumberR2JL().setVisible(false);
            scenario.getNumberR3JL().setVisible(true);
        }
        scenario.repaint();
    }

    private void gasControl(Scenario scenario) throws InterruptedException {

        if (this.isEverbodyDie) {
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

        if (this.qtyCabin == 3 && !this.isEverbodyDie) {
            Thread.sleep(3000);
            scenario.getGas0JL().setVisible(true);
        }

        if (this.qtyCabin == 2 && !this.isEverbodyDie) {
            Thread.sleep(3000);
            scenario.getGas1JL().setVisible(true);
            scenario.getGas2JL().setVisible(true);
            scenario.getGas3JL().setVisible(true);
            scenario.getGas4JL().setVisible(true);
        }

        if (this.qtyCabin == 1 && !this.isEverbodyDie) {
            Thread.sleep(3000);
            scenario.getGas5JL().setVisible(true);
            scenario.getGas6JL().setVisible(true);
            scenario.getGas7JL().setVisible(true);
        }

        if (this.qtyCabin == 3 && this.cabinRandom == 0) {
            scenario.getGas1JL().setVisible(true);
        } else if (this.qtyCabin == 3 && this.cabinRandom == 1) {
            scenario.getGas2JL().setVisible(true);
        } else if (this.qtyCabin == 3 && this.cabinRandom == 2) {
            scenario.getGas3JL().setVisible(true);
        } else if (this.qtyCabin == 3 && this.cabinRandom == 3) {
            scenario.getGas4JL().setVisible(true);
        }

        if (this.qtyCabin == 2 && this.cabinRandom == 0) {
            scenario.getGas5JL().setVisible(true);
        } else if (this.qtyCabin == 2 && cabinRandom == 1) {
            scenario.getGas6JL().setVisible(true);
        } else if (qtyCabin == 2 && cabinRandom == 2) {
            scenario.getGas7JL().setVisible(true);
        }

        if (qtyCabin == 1 && cabinRandom == 0) {
            scenario.getGas8JL().setVisible(true);
        } else if (qtyCabin == 1 && cabinRandom == 1) {
            scenario.getGas9JL().setVisible(true);
        }
    }

    void playAgain(Scenario scenario, Entrace entrace) {
        String[] options = new String[]{"Yes", "No"};
        optionPane = new JOptionPane("Do you want to play again?");
        optionPane.setOptions(options);
        dialog = optionPane.createDialog(null, "Do you want to play again?");
        dialog.setBounds(795, 600, 350, 130);
        dialog.setVisible(true);

        Object result = optionPane.getValue();
        if (result == options[0]) {
            for (int i = 0; i < entrace.getQtdPlayer(); i++) {
                entrace.getArrayPlayers()[i].setAlive(true);
            }
            qtyCabin = 4;
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
            scenario.getHelloJL().setLocation(755, 420);
            scenario.getEtJL().setLocation(885, 420);
            scenario.getCiclopsJL().setLocation(1005, 420);
            scenario.getRobotJL().setLocation(1125, 420);
            scenario.repaint();
        } else {
            optionPane = new JOptionPane();
            optionPane.setMessage("Thanks for playing and see you next time.");
            dialog = optionPane.createDialog(null, "End");
            dialog.setBounds(795, 600, 350, 130);
            dialog.setVisible(true);
            this.setPlay();
        }
    }

    private void moveCharacter(Entrace entrace, Scenario scenario) {
        for (int i = 0; i < entrace.getQtdPlayer(); i++) {
            if (entrace.getArrayPlayers()[i].isAlive()) {
                if (this.qtyCabin == 4) {
                    if (i == 0 && entrace.getArrayPlayers()[i].getCurrentCabin() == 1) {
                        scenario.getHelloJL().setLocation(725, 340);
                    } else if (i == 0 && entrace.getArrayPlayers()[i].getCurrentCabin() == 2) {
                        scenario.getHelloJL().setLocation(838, 340);
                    } else if (i == 0 && entrace.getArrayPlayers()[i].getCurrentCabin() == 3) {
                        scenario.getHelloJL().setLocation(961, 340);
                    } else if (i == 0 && entrace.getArrayPlayers()[i].getCurrentCabin() == 4) {
                        scenario.getHelloJL().setLocation(1084, 340);
                    }
                    if (i == 1 && entrace.getArrayPlayers()[i].getCurrentCabin() == 1) {
                        scenario.getEtJL().setLocation(747, 340);
                    } else if (i == 1 && entrace.getArrayPlayers()[i].getCurrentCabin() == 2) {
                        scenario.getEtJL().setLocation(870, 340);
                    } else if (i == 1 && entrace.getArrayPlayers()[i].getCurrentCabin() == 3) {
                        scenario.getEtJL().setLocation(993, 340);
                    } else if (i == 1 && entrace.getArrayPlayers()[i].getCurrentCabin() == 4) {
                        scenario.getEtJL().setLocation(1116, 340);
                    }
                    if (i == 2 && entrace.getArrayPlayers()[i].getCurrentCabin() == 1) {
                        scenario.getCiclopsJL().setLocation(773, 340);
                    } else if (i == 2 && entrace.getArrayPlayers()[i].getCurrentCabin() == 2) {
                        scenario.getCiclopsJL().setLocation(896, 340);
                    } else if (i == 2 && entrace.getArrayPlayers()[i].getCurrentCabin() == 3) {
                        scenario.getCiclopsJL().setLocation(1019, 340);
                    } else if (i == 2 && entrace.getArrayPlayers()[i].getCurrentCabin() == 4) {
                        scenario.getCiclopsJL().setLocation(1142, 340);
                    }
                    if (i == 3 && entrace.getArrayPlayers()[i].getCurrentCabin() == 1) {
                        scenario.getRobotJL().setLocation(800, 340);
                    } else if (i == 3 && entrace.getArrayPlayers()[i].getCurrentCabin() == 2) {
                        scenario.getRobotJL().setLocation(923, 340);
                    } else if (i == 3 && entrace.getArrayPlayers()[i].getCurrentCabin() == 3) {
                        scenario.getRobotJL().setLocation(1046, 340);
                    } else if (i == 3 && entrace.getArrayPlayers()[i].getCurrentCabin() == 4) {
                        scenario.getRobotJL().setLocation(1169, 340);
                    }
                }

                if (this.qtyCabin == 3) {
                    if (i == 0 && entrace.getArrayPlayers()[i].getCurrentCabin() == 1) {
                        scenario.getHelloJL().setLocation(775, 245);
                    } else if (i == 0 && entrace.getArrayPlayers()[i].getCurrentCabin() == 2) {
                        scenario.getHelloJL().setLocation(898, 245);
                    } else if (i == 0 && entrace.getArrayPlayers()[i].getCurrentCabin() == 3) {
                        scenario.getHelloJL().setLocation(1023, 245);
                    }
                    if (i == 1 && entrace.getArrayPlayers()[i].getCurrentCabin() == 1) {
                        scenario.getEtJL().setLocation(807, 245);
                    } else if (i == 1 && entrace.getArrayPlayers()[i].getCurrentCabin() == 2) {
                        scenario.getEtJL().setLocation(930, 245);
                    } else if (i == 1 && entrace.getArrayPlayers()[i].getCurrentCabin() == 3) {
                        scenario.getEtJL().setLocation(1055, 245);
                    }
                    if (i == 2 && entrace.getArrayPlayers()[i].getCurrentCabin() == 1) {
                        scenario.getCiclopsJL().setLocation(833, 245);
                    } else if (i == 2 && entrace.getArrayPlayers()[i].getCurrentCabin() == 2) {
                        scenario.getCiclopsJL().setLocation(956, 245);
                    } else if (i == 2 && entrace.getArrayPlayers()[i].getCurrentCabin() == 3) {
                        scenario.getCiclopsJL().setLocation(1081, 245);
                    }
                    if (i == 3 && entrace.getArrayPlayers()[i].getCurrentCabin() == 1) {
                        scenario.getRobotJL().setLocation(860, 245);
                    } else if (i == 3 && entrace.getArrayPlayers()[i].getCurrentCabin() == 2) {
                        scenario.getRobotJL().setLocation(983, 245);
                    } else if (i == 3 && entrace.getArrayPlayers()[i].getCurrentCabin() == 3) {
                        scenario.getRobotJL().setLocation(1108, 245);
                    }
                }

                if (this.qtyCabin == 2) {
                    if (i == 0 && entrace.getArrayPlayers()[i].getCurrentCabin() == 1) {
                        scenario.getHelloJL().setLocation(835, 150);
                    } else if (i == 0 && entrace.getArrayPlayers()[i].getCurrentCabin() == 2) {
                        scenario.getHelloJL().setLocation(962, 150);
                    }
                    if (i == 1 && entrace.getArrayPlayers()[i].getCurrentCabin() == 1) {
                        scenario.getEtJL().setLocation(867, 150);
                    } else if (i == 1 && entrace.getArrayPlayers()[i].getCurrentCabin() == 2) {
                        scenario.getEtJL().setLocation(994, 150);
                    }
                    if (i == 2 && entrace.getArrayPlayers()[i].getCurrentCabin() == 1) {
                        scenario.getCiclopsJL().setLocation(893, 150);
                    } else if (i == 2 && entrace.getArrayPlayers()[i].getCurrentCabin() == 2) {
                        scenario.getCiclopsJL().setLocation(1020, 150);
                    }
                    if (i == 3 && entrace.getArrayPlayers()[i].getCurrentCabin() == 1) {
                        scenario.getRobotJL().setLocation(920, 150);
                    } else if (i == 3 && entrace.getArrayPlayers()[i].getCurrentCabin() == 2) {
                        scenario.getRobotJL().setLocation(1047, 150);
                    }
                }
            }
        }
        scenario.repaint();
    }

    boolean isPlay() {
        return play;
    }

    private void setPlay() {
        this.play = false;
    }
}
