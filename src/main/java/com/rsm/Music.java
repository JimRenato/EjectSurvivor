package com.rsm;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.*;
import java.io.File;

class Music {

    void playMusic() {
        String musicPath = "src/main/resources/music/i-put-a-spell-on-you.mid";
        try {
            Sequencer player = MidiSystem.getSequencer();
            Sequence music = MidiSystem.getSequence(new File(musicPath));
            player.open();
            player.setSequence(music);
            int repeat = 10;
            player.setLoopCount(repeat);
            player.start();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error playing the music: " + musicPath);
        }
    }
}
