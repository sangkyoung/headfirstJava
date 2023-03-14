package chp13;

import javax.sound.midi.*;

public class MiniMusicCmd {
    public void play(int instrument, int note) {
        try {
            // get player and open sequencer
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            // create new sequence
            Sequence sequence = new Sequence(Sequence.PPQ, 4);

            // create a track, add a midi event
            Track track = sequence.createTrack();

            ShortMessage a = new ShortMessage();
            a.setMessage(192, 1, instrument, 0);
            MidiEvent changeInstrument = new MidiEvent(a, 1);
            track.add(changeInstrument);

            ShortMessage b = new ShortMessage();
            b.setMessage(144, 1, note, 100);
            MidiEvent noteOn = new MidiEvent(b,1);
            track.add(noteOn);

            ShortMessage c = new ShortMessage();
            c.setMessage(128, 1, note, 100);
            MidiEvent noteOff = new MidiEvent(c, 16);
            track.add(noteOff);

            // set sequence to player, start playing
            sequencer.setSequence(sequence);
            sequencer.start();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("Don't forget the instrument and note args");
        } else {
            int instrument = Integer.parseInt(args[0]);
            int note = Integer.parseInt(args[1]);
            MiniMusicCmd mini = new MiniMusicCmd();
            mini.play(instrument, note);
        }
    }
}
