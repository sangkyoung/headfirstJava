package chp13;

import javax.sound.midi.*;

public class MusicTest1 {
    
    //play midi
    public void play() {
        try {

            //get player and open ;sequencer
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            System.out.println("We got a sequencer");
            
            //create new sequence
            Sequence sequence = new Sequence(Sequence.PPQ,4);

            // create a track, add a midi event
            Track track = sequence.createTrack();

            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 44, 100);
            MidiEvent myMidiEvent = new MidiEvent(a, 1);
            track.add(myMidiEvent);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 44, 100);
            MidiEvent myMidiEvent2 = new MidiEvent(b, 16);
            track.add(myMidiEvent2);

            //set sequence to player, start playing
            sequencer.setSequence(sequence);
            sequencer.start();

        }catch(MidiUnavailableException ex) {
            System.out.println("MidiUnavailableException");
        }catch(InvalidMidiDataException ex) {
            System.out.println("InvalidMidiDataException");
        }
    }
    public static void main(String[] args) {
        MusicTest1 mt = new MusicTest1();
        mt.play();
    }
}
