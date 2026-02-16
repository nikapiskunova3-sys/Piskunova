import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreboardApp {
    private int scoreMilan = 0;
    private int scoreMadrid = 0;
    private JLabel resultLabel;
    private JLabel lastScorerLabel;
    private JLabel winnerLabel;

    public ScoreboardApp() {
        JFrame frame = new JFrame("Football Scoreboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JButton milanBtn = new JButton("AC Milan");
        JButton madridBtn = new JButton("Real Madrid");

        resultLabel = new JLabel("Result: 0 X 0");
        lastScorerLabel = new JLabel("Last Scorer: N/A");
        winnerLabel = new JLabel("Winner: DRAW");

        milanBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                scoreMilan++;
                updateLabels("AC Milan");
            }
        });

        madridBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                scoreMadrid++;
                updateLabels("Real Madrid");
            }
        });

        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5,5,5,5);
        frame.add(milanBtn, c);

        c.gridx = 1;
        frame.add(madridBtn, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        frame.add(resultLabel, c);

        c.gridy = 2;
        frame.add(lastScorerLabel, c);

        c.gridy = 3;
        frame.add(winnerLabel, c);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void updateLabels(String lastScorer) {
        resultLabel.setText("Result: " + scoreMilan + " X " + scoreMadrid);
        lastScorerLabel.setText("Last Scorer: " + lastScorer);
        if (scoreMilan > scoreMadrid) {
            winnerLabel.setText("Winner: AC Milan");
        } else if (scoreMadrid > scoreMilan) {
            winnerLabel.setText("Winner: Real Madrid");
        } else {
            winnerLabel.setText("Winner: DRAW");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ScoreboardApp();
            }
        });
    }
}
