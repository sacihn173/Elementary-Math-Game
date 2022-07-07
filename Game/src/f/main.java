package f;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

public class main extends JFrame{

    public main() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        JFrame frame = new JFrame();
        JLabel label = new JLabel("Welcome Swarnika");
        JLabel label2 = new JLabel("How are you feeling today?");
        JLabel label3 = new JLabel("Lets Play");

        String intro = "intro.wav";
        AudioInputStream audioInputStream1 = AudioSystem.getAudioInputStream(new File(intro).getAbsoluteFile());
        Clip clip1 = AudioSystem.getClip();
        clip1.open(audioInputStream1);


        // labels at top
        label2.setVerticalTextPosition(JLabel.TOP);
        label2.setHorizontalTextPosition(JLabel.CENTER);
        label2.setFont(new Font("Sans", Font.PLAIN, 29));
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setFont(new Font("Sans", Font.PLAIN, 35));
        label3.setVerticalTextPosition(JLabel.TOP);
        label3.setHorizontalTextPosition(JLabel.CENTER);
        label3.setFont(new Font("Sans", Font.PLAIN, 30));


        // border panels and central panel
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();   // for buttons


        p1.setBackground(Color.LIGHT_GRAY);
        p2.setBackground(Color.LIGHT_GRAY);
        p3.setBackground(Color.LIGHT_GRAY);
        p4.setBackground(Color.LIGHT_GRAY);
        p1.setPreferredSize(new Dimension(30, 30));
        p2.setPreferredSize(new Dimension(30, 30));
        p3.setPreferredSize(new Dimension(30, 30));
        p4.setPreferredSize(new Dimension(30, 30));

        // 3 buttons
        JButton addition = new JButton();
        JButton subtraction = new JButton();
        JButton multiplication = new JButton();

        // buttons editing
        addition.setText("Do Addition");
        subtraction.setText("Do Subtraction");
        multiplication.setText("Do Tables");

        addition.setForeground(Color.BLACK);
        subtraction.setForeground(Color.BLACK);
        multiplication.setForeground(Color.BLACK);

        addition.setBackground(Color.LIGHT_GRAY);
        multiplication.setBackground(Color.LIGHT_GRAY);
        subtraction.setBackground(Color.LIGHT_GRAY);

        addition.setFocusable(false);
        subtraction.setFocusable(false);
        multiplication.setFocusable(false);
        addition.setFont(new Font("Sans", Font.PLAIN, 18));
        subtraction.setFont(new Font("Sans", Font.PLAIN, 18));
        multiplication.setFont(new Font("Sans", Font.PLAIN, 18));
        addition.setPreferredSize(new Dimension(250, 60));
        subtraction.setPreferredSize(new Dimension(250, 60));
        multiplication.setPreferredSize(new Dimension(250, 60));

        // panels editing

        p5.setPreferredSize(new Dimension(50, 50));
        p5.setBackground(Color.PINK);
        p5.setBounds(50, 50, 100, 100);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setTitle("Lets Play");
        frame.setVisible(true);

        // adding to frame
        frame.add(p1, BorderLayout.NORTH);
        frame.add(p2, BorderLayout.WEST);
        frame.add(p3, BorderLayout.EAST);
        frame.add(p4, BorderLayout.SOUTH);
        frame.add(p5);

        // central layout
        p5.setLayout(new FlowLayout(FlowLayout.CENTER, 900, 30));
        p5.add(label);
        p5.add(label2);
        p5.add(label3);
        p5.add(addition);
        p5.add(multiplication);
        p5.add(subtraction);


        addition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    addition_page add = new addition_page();
                    clip1.start();
                } catch (LineUnavailableException | UnsupportedAudioFileException | IOException lineUnavailableException) {
                    lineUnavailableException.printStackTrace();
                }
                frame.dispose();
            }
        });
        subtraction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    substraction_page sbb = new substraction_page();
                    clip1.start();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                    unsupportedAudioFileException.printStackTrace();
                } catch (LineUnavailableException lineUnavailableException) {
                    lineUnavailableException.printStackTrace();
                }
                frame.dispose();
            }
        });
        multiplication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    multiplication_page mul = new multiplication_page();
                    clip1.start();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (LineUnavailableException lineUnavailableException) {
                    lineUnavailableException.printStackTrace();
                } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                    unsupportedAudioFileException.printStackTrace();
                }
                frame.dispose();
            }
        });

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JFrame f1 = (JFrame) e.getSource();
                f1.dispose();
            }
        });



    }
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        main t = new main();
    }
}
