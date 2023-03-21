package chp16;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import static javax.sound.midi.ShortMessage.*;
public class BeatBox {

    private ArrayList<JCheckBox> checkBoxList;
    private Sequencer sequencer;
    private Sequence sequence;
    private Track track;
    //instrument names
    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat"
    , "Acoustic Snare", "Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo"
    , "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap", "Low-mid Tom"
    , "High Agogo", "Open Hi Conga"};
    // instrument sounds
    int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};
    // checkboxStates
    boolean[] checkboxStates = new boolean[256];
    //frame
    JFrame frame;

    public static void main(String[] args) {
        BeatBox gui = new BeatBox();
        gui.buildGui();
        gui.setUpMidi();
    }
    public void buildGui() {
        // create frame
        frame = new JFrame("Cyber BeatBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // create panel
        JPanel backgroundPanel = new JPanel(new BorderLayout());
        backgroundPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // create buttonBox
        Box buttonBox = new Box(BoxLayout.Y_AXIS);
        // create button start, stop, tempoUp, tempoDown
        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");
        JButton tempoUp = new JButton("Tempo Up");
        JButton tempoDown = new JButton("Tempo Down");
        start.addActionListener(e -> buildTrackAndStart());
        stop.addActionListener(e -> sequencer.stop());
        tempoUp.addActionListener(e -> changeTempo(1.03f));
        tempoDown.addActionListener(e -> changeTempo(0.97f));
        buttonBox.add(start);
        buttonBox.add(stop);
        buttonBox.add(tempoUp);
        buttonBox.add(tempoDown);
        // create button serializeIt, restore
        JButton serializeIt = new JButton("serializeIt");
        JButton restore = new JButton("restore");
        serializeIt.addActionListener(e -> writeFile());
        restore.addActionListener(e -> readFile());
        buttonBox.add(serializeIt);
        buttonBox.add(restore);

        // create nameBox
        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for(String instrumentName : instrumentNames) {
            JLabel label = new JLabel(instrumentName);
            label.setBorder(BorderFactory.createEmptyBorder(4, 1, 4, 1));
            nameBox.add(label);
        }

        // add to backgroundPanel and frame
        backgroundPanel.add(BorderLayout.EAST, buttonBox);
        backgroundPanel.add(BorderLayout.WEST, nameBox);
        frame.getContentPane().add(backgroundPanel);

        // create 16*16 grid and JCheckBoxs
        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);
        JPanel mainPanel = new JPanel(grid);
        checkBoxList = new ArrayList<>();
        for(int i = 0; i < 256; i++) {
            JCheckBox checkBox = new JCheckBox();
            checkBox.setSelected(false);
            checkBoxList.add(checkBox);
            mainPanel.add(checkBox);
        }
        // add to backgroundPanel
        backgroundPanel.add(BorderLayout.CENTER, mainPanel);

        // set frame visible
        frame.setBounds(50, 50, 300, 300);
        frame.pack();
        frame.setVisible(true);
    }
    public void setUpMidi() {
        try {
            // get sequencer and open
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            // get sequence and track
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            // set tempo
            sequencer.setTempoInBPM(120);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void buildTrackAndStart() {
        int[] trackList;
        sequence.deleteTrack(track);
        track = sequence.createTrack();

        // turn checkbox state into MIDI events
        // do for each of the 16 rows
        for(int i=0;i<16;i++){
            trackList = new int[16];
            // set key to instruments
            int key = instruments[i];
            // do for each of the 16 columns
            for(int j=0;j<16;j++){
                JCheckBox jc = checkBoxList.get(j + (16*i));
                if(jc.isSelected()) {
                    trackList[j] = key;
                } else {
                    trackList[j] = 0;
                }
            }
            makeTracks(trackList);
            track.add(makeEvent(CONTROL_CHANGE, 1, 127, 0, 16));
        }
        track.add(makeEvent(PROGRAM_CHANGE, 9, 1, 0, 15));

        // sequencer start
        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
            sequencer.setTempoInBPM(120);
            sequencer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void makeTracks(int[] list) {
        for(int i=0;i<16;i++) {
            int key = list[i];
            if(key != 0) {
                track.add(makeEvent(NOTE_ON, 9, key, 100, i));
                track.add(makeEvent(NOTE_OFF, 9, key, 100, i+1));
            }
        }
    }
    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
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
    public void changeTempo(float factor) {
        float tempoFactor = sequencer.getTempoFactor();
        sequencer.setTempoFactor((float) (tempoFactor * factor));
    }
    public File selectFile() {
        //create JFileChooser
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(frame);
        return chooser.getSelectedFile();
    }
    public void writeFile() {
        int i = 0;
        for(JCheckBox checkBox : checkBoxList){
            checkboxStates[i++] = checkBox.isSelected();
        }
        //create file
        File file = selectFile();
        //create objectOutputStream
        try (
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))
        ) {
            objectOutputStream.writeObject(checkboxStates);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readFile() {
        //create file
        File file = selectFile();
        //create ObjectInputStream
        try (
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))
        ) {
            checkboxStates = (boolean[]) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int i = 0;
        for(boolean checked : checkboxStates){
            checkBoxList.get(i++).setSelected(checked);
        }

        //stop currently playing, and rebuild sequence
        sequencer.stop();
        buildTrackAndStart();
    }
}
