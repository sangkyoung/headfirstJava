package chp14;

import java.awt.*;

import javax.sound.midi.*;
import javax.swing.*;

// A class that creates a GUI window and plays MIDI music
public class MiniMusicPlayer3 {
    JFrame frame;
    MyDrawPanel drawPanel;
    public static void main(String[] args) {
        MiniMusicPlayer3 mini = new MiniMusicPlayer3();
        mini.go();
    }
    public void go() {
        //initiate settings
        setupGui();
        setupMidi();
    }
    // A method to create a MIDI sequencer, add MIDI events, and play the music
    public void setupMidi() {
        try {
            // make a sequencer, sequence and track
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            // add listener to sequencer
            player.addControllerEventListener(drawPanel, new int[] {127});

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

    // A method to create the GUI window and add the MyDrawPanel to it
    public void setupGui() {
        frame = new JFrame("My first music video");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawPanel = new MyDrawPanel();
        frame.getContentPane().add(drawPanel);
        frame.setBounds(30, 30, 300, 300);
        frame.setVisible(true);
    }

    class MyDrawPanel extends JPanel implements ControllerEventListener{
        boolean msg = false;
        @Override
        protected void paintComponent(Graphics g) {
            if(msg){
                //set color
                int red = (int) (Math.random() * 250);
                int green = (int) (Math.random() * 250);
                int blue = (int) (Math.random() * 250);
                Color color = new Color(red, green, blue);
                g.setColor(color);
    
                //set size
                int height = (int) ((Math.random() * 120) + 10);
                int width = (int) ((Math.random() * 120) + 10);
                int x = (int) ((Math.random() * 50) + 10);
                int y = (int) ((Math.random() * 50) + 10);
                g.fillRect(x,y,width,height);

                msg = false;
            }
        }

        @Override
        public void controlChange(ShortMessage event) {
            msg = true;
            repaint();
        }
    }
}
