package chp14;

import javax.sound.midi.*;

public class MiniMusicPlayer1 implements ControllerEventListener {
    
    public static void main(String[] args) {
        MiniMusicPlayer1 mini = new MiniMusicPlayer1();
        mini.go();
    }
    public void go() {
        //test play
        try {
            // make a sequencer, sequence and track
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            // add listener to sequencer
            player.addControllerEventListener(this, new int[] {127});

            // make some MidiEvents and add them to the track
            for(int i = 15; i <71; i+=4){
                track.add(makeEvent(144,1,i,100,i));

                // add event to make controller event
                track.add(makeEvent(176, 1, 127, 0, i));

                track.add(makeEvent(128,1,i,100,i+2));
            }

            //play
            player.setSequence(seq);
            player.setTempoInBPM(150);
            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // make MidiEvent and return it
    public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }

    @Override
    public void controlChange(ShortMessage event) {
        System.out.println("la");
    }
}
