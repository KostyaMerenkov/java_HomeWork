import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleField extends JPanel {
    private GameWindow gameWindow;
    private int mode;
    private int fieldSize;
    private int winningLength;

    private boolean isInit;

    private int cellWidth;
    private int cellHeight;

    private int strokeSize = 3;

    public BattleField(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                clickBattleField(e);
            }
        });
    }

    private void clickBattleField(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        if(!Logic.isFinished){
            Logic.humanTurn(cellX, cellY);
            if(Logic.isFinished) {
                repaint();
                winMessage(Logic.winner);
            }
        }

        repaint();


    }


    public void startNewGame(int mode, int fieldSize, int winningLength) {
        this.mode = mode;
        this.fieldSize = fieldSize;
        this.winningLength = winningLength;

        isInit = true;

        repaint();

    }

    static public void winMessage(int who_won){
        JPanel myRootPane = new JPanel();
        if (who_won == Logic.human_won) {
            JOptionPane.showMessageDialog(myRootPane, "Человек победил!", "Игра закончена", JOptionPane.DEFAULT_OPTION );
        }
        else if (who_won == Logic.pc_won) {
            JOptionPane.showMessageDialog(myRootPane, "Компьютер победил!", "Игра закончена", JOptionPane.DEFAULT_OPTION );
        }
        else {
            JOptionPane.showMessageDialog(myRootPane, "Ничья!", "Игра закончена", JOptionPane.DEFAULT_OPTION );
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSize;
        cellWidth = panelWidth / fieldSize;

        g.setColor(Color.BLACK);

        for (int i = 0; i < fieldSize; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSize; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (Logic.map[i][j] == Logic.DOT_X) {
                    drawX(g, j, i);
                }
                if (Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g, j, i);
                }
            }
        }
    }

    private void drawX(Graphics g, int x, int y) {
        ((Graphics2D) g).setStroke(new BasicStroke(strokeSize));
        g.setColor(Color.RED);
        g.drawLine(cellWidth * x, cellHeight * y, cellWidth * (x + 1), cellHeight * (y + 1));
        g.drawLine(cellWidth * x, cellHeight * (y+1), cellWidth * (x + 1), cellHeight * y);
    }

    private void drawO(Graphics g, int x, int y) {
        ((Graphics2D) g).setStroke(new BasicStroke(strokeSize));
        g.setColor(Color.BLUE);
        g.drawOval(cellWidth * x, cellHeight * y, cellWidth, cellHeight);
    }
}
