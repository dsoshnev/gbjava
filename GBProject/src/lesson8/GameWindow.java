package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    public JButton[] jbs;

    public GameWindow(Game game) {
        setBounds(500,500,400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jbs = new JButton[game.GAME_SIZE*game.GAME_SIZE];
        setLayout(new GridLayout(game.GAME_SIZE, game.GAME_SIZE));
        game.setWindow(this);
        game.initGame();

        for (int i = 0; i < jbs.length; i++) {
            JButton button = new JButton();
            String name = (i/game.GAME_SIZE+1) + ":" + (i%game.GAME_SIZE+1);
            button.setName(name);
            button.setText(String.valueOf(game.get(name)));
            button.setFont(new Font(null,1,20));
            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    GameWindow window = (GameWindow) button.getTopLevelAncestor();
                    if(game.set(game.CELL_X, button.getName())) {
                        button.setEnabled(false);
                        game.botMove(game.CELL_O);
                    }

                    for (JButton c : window.jbs) {
                        c.setText(String.valueOf(game.get(c.getName())));
                    }
                }

            });
            jbs[i] = button;
            add(jbs[i]);
        }
        setVisible(true);
    }

}
