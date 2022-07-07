package f;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

public class substraction_page {

    double start_time;
    int correct = 0, done = 5;

    public substraction_page() throws IOException, UnsupportedAudioFileException, LineUnavailableException {

        String win = "win.wav";
        AudioInputStream audioInputStream1 = AudioSystem.getAudioInputStream(new File(win).getAbsoluteFile());
        Clip clip1 = AudioSystem.getClip();
        clip1.open(audioInputStream1);



        String loose = "loose.wav";
        AudioInputStream audioInputStream2 = AudioSystem.getAudioInputStream(new File(loose).getAbsoluteFile());
        Clip clip2 = AudioSystem.getClip();
        clip2.open(audioInputStream2);

        JLabel l1 = new JLabel("Complete " + done + " more subtractions !");
        //        JLabel l2 = new JLabel("+");
        JLabel l3 = new JLabel("Enter Answer here");
        JLabel num1 = new JLabel();
        JLabel num2 = new JLabel();
        JLabel result = new JLabel("");
        JLabel time = new JLabel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();

        Random ran = new Random();
        int second = ran.nextInt(10);
        int first = ran.nextInt(20-second) + second;

        start_time = System.currentTimeMillis();

        num1.setText(String.valueOf(first) + " - " + String.valueOf(second));
        num1.setSize(new Dimension(400, 40));
        num2.setSize(new Dimension(400, 40));
        num1.setFont(new Font("Sans", Font.BOLD, 30));
        num2.setFont(new Font("Sans", Font.BOLD, 30));
        num1.setForeground(Color.RED);
        num2.setForeground(Color.RED);

        p1.setBackground(Color.LIGHT_GRAY);
        p2.setBackground(Color.LIGHT_GRAY);
        p3.setBackground(Color.LIGHT_GRAY);
        p4.setBackground(Color.LIGHT_GRAY);
        p5.setBackground(Color.LIGHT_GRAY);
        p1.setPreferredSize(new Dimension(20, 20));
        p2.setPreferredSize(new Dimension(20, 20));
        p3.setPreferredSize(new Dimension(20, 20));
        p4.setPreferredSize(new Dimension(20, 20));

        l1.setSize(new Dimension(400, 40));
        l3.setSize(new Dimension(400, 40));
        time.setSize(new Dimension(400, 40));
        l1.setFont(new Font("MV Boli", Font.PLAIN, 25));
        time.setFont(new Font("MV Boli", Font.PLAIN, 25));
        l3.setFont(new Font("MV Boli", Font.PLAIN, 25));

        TextField t1 = new TextField("");
        TextField t2 = new TextField("");
        TextField ans = new TextField("");
        JButton go_back = new JButton();
        JButton check_ans = new JButton();
        JButton try_again = new JButton();

        // textfields
        result.setForeground(Color.RED);
        result.setPreferredSize(new Dimension(400, 40));
        result.setFont(new Font("Sans", Font.BOLD, 25));
        ans.setPreferredSize(new Dimension(150, 35));
        ans.setFont(new Font("MV Boli", Font.BOLD, 25));
        t1.setPreferredSize(new Dimension(400, 40));
        t2.setPreferredSize(new Dimension(400, 40));
        t1.setFont(new Font("MV Boli", Font.BOLD, 25));
        t2.setFont(new Font("MV Boli", Font.BOLD, 25));

        // buttons
        go_back.setPreferredSize(new Dimension(320, 50));
        check_ans.setPreferredSize(new Dimension(130, 50));
        check_ans.setFont(new Font("Sans", Font.BOLD, 15));
        go_back.setFont(new Font("Sans", Font.BOLD, 15));
        try_again.setFont(new Font("Sans", Font.BOLD, 15));
        check_ans.setText("Check Answer");
        try_again.setText("Next");
        try_again.setPreferredSize(new Dimension(150, 50));
        go_back.setText("Practice Tables or Addition");

        JFrame frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);


        frame.add(p1, BorderLayout.NORTH);
        frame.add(p2, BorderLayout.EAST);
        frame.add(p3, BorderLayout.WEST);
        frame.add(p4, BorderLayout.SOUTH);

        frame.add(p5);
        p5.setLayout(new FlowLayout(FlowLayout.CENTER, 900, 18));
        p5.add(l1);
        p5.add(num1);
        p5.add(num2);
        p5.add(l3);
        p5.add(ans);
        p5.add(check_ans);
        p5.add(result);

        p5.add(try_again);

        p5.add(go_back);
        p5.add(time);

        try_again.setVisible(false);
        go_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clip1.stop();
                clip2.stop();
                try {
                    main m = new main();
                } catch (LineUnavailableException lineUnavailableException) {
                    lineUnavailableException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                    unsupportedAudioFileException.printStackTrace();
                }
                frame.dispose();
            }
        });

        check_ans.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                if (ans.getText().equals(""))
                    try {
                        throw new Exception("Enter valid input");
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                if(!ans.getText().equals("")) {

                    // no input error
                    int flag = 1;
                    String ss = ans.getText();
                    for(int i = 0; i < ss.length(); i++) {
                        if(ss.charAt(i) < 48 || ss.charAt(i) > 57) {
                            flag = -1;
                            break;
                        }
                    }

                    // other than number entered error
                    if(flag == -1) {
                        try {
                            throw new Exception("Input given not valid !");
                        }   catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }

                    if(flag == 1) {
                        try_again.setVisible(true);

                        check_ans.setVisible(false);
                        done--;
                        String s = num1.getText();
                        int b = 0, c= 0;
                        int a = Integer.parseInt(ans.getText());
                        int temp1 = Integer.parseInt(String.valueOf(s.charAt(0)));
                        if(s.charAt(2) == '-') {
                            b = temp1;
                            c += Integer.parseInt(String.valueOf(s.charAt(4)));
                            if(s.length() == 6) c += Integer.parseInt(String.valueOf(s.charAt(5)));
                        }
                        else {
                            b = temp1 * 10 + Integer.parseInt(String.valueOf(s.charAt(1)));
                            c += Integer.parseInt(String.valueOf(s.charAt(5)));
                            if(s.length() == 7) c += Integer.parseInt(String.valueOf(s.charAt(6)));
                        }
                        if(a == (b - c)) {
                            correct++;
                            result.setForeground(new Color(0, 100, 0));
                            result.setText(" WOW ! Your answer is Correct !");
                        }
                        else {
                            result.setForeground(Color.RED);
                            result.setText("   Sorry, Correct answer is " + (b - c) + " !");
                        }

                        double curr_time = System.currentTimeMillis();
                        float time_taken_curr = (float) ((curr_time - start_time) / 60000.0);

                        DecimalFormat dfff = new DecimalFormat();
                        dfff.setMaximumFractionDigits(2);
                        time.setVisible(true);
                        time.setText("Time Gone : " + dfff.format(time_taken_curr) + " minutes");


                        long stop_time;
                        float time_taken;
                        if(done == 0) {
                            l1.setText(" Finished");
                            if(correct <= 2) {
                                clip2.start();
                                num1.setForeground(Color.RED);
                                num1.setText("Poor Performance !");
                            }
                            else if(correct == 5)
                            {
                                clip1.start();
                                num1.setForeground(Color.GREEN);
                                num1.setText("Congratulations ! Excellent Performance !");
                            }
                            else   {
                                clip1.start();
                                num1.setForeground(Color.BLUE);
                                num1.setText("Good Performance !");
                            }
                            ans.setVisible(false);
                            try_again.setVisible(false);
                            check_ans.setVisible(false);
                            go_back.setText("Try Again !");

                            stop_time = System.currentTimeMillis();
                            time_taken = (float) ((stop_time - start_time) / 60000.0);
                            result.setText("            Correct : " + correct + " of 5");
                            time.setForeground(Color.RED);

                            DecimalFormat df = new DecimalFormat();
                            df.setMaximumFractionDigits(2);
                            time.setText("Time taken : " + df.format(time_taken) + " minutes");
                        }
                    }
                }
            }
        });

        try_again.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                time.setVisible(false);
                check_ans.setVisible(true);
                l1.setText("Complete " + done + " more subtractions !");
                int c = ran.nextInt(10);
                int b = ran.nextInt(20-c) + c;
                num1.setText(String.valueOf(b) + " - " + String.valueOf(c));
                result.setText("");
                ans.setText("");
                time.setText("");
                try_again.setVisible(false);
            }
        });
    }
}
