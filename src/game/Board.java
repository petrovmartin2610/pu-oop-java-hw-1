package game;
import figures.CenterFrogCircle;
import figures.FrogGuard;
import figures.FrogLeader;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/** @author Martin Petrov
 * Board класа, в който се съдържат съответно:
 *      1. игралните фигурки и техните позиции в ArrayList, както и
 *      размер, видимост, заглавие и действие при натискане бутона exit за самата форма, всичко поместено в конструктора на Board;
 *      2. метода paint, който извършва самата визуализация
 *
 */

public class Board extends JFrame {

    private ArrayList<Object> allFigures = new ArrayList<>();

    public Board(){
        this.allFigures.add(new FrogLeader(5,1));
        this.allFigures.add(new FrogLeader(1,5));
        this.allFigures.add(new FrogGuard(1, 1));
        this.allFigures.add(new FrogGuard(1, 2));
        this.allFigures.add(new FrogGuard(1, 3));
        this.allFigures.add(new FrogGuard(1, 4));
        this.allFigures.add(new FrogGuard(5, 2));
        this.allFigures.add(new FrogGuard(5, 3));
        this.allFigures.add(new FrogGuard(5, 4));
        this.allFigures.add(new FrogGuard(5, 5));
        this.allFigures.add(new CenterFrogCircle(3, 3));


        this.setSize(500, 500);
        this.setVisible(true);
        this.setTitle("A game of war");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(int row=0; row<5; row++){
            for(int col=0; col<5; col++){
                Tiles gameTiles = new Tiles(row,col);
                gameTiles.draw(g);

                RedTiles rt1 = new RedTiles(row,col);
                rt1.draw(g);

                BlackTiles bt1 = new BlackTiles(row,col);
                bt1.draw(g);

                GrayTiles gt1 = new GrayTiles(row, col);
                gt1.draw(g);

                FrogLeader fl1 = new FrogLeader(row,col);
                fl1.draw(g);

                FrogGuard fg1 = new FrogGuard(row,col);
                fg1.draw(g);

                CenterFrogCircle cfc1 = new CenterFrogCircle(row,col);
                cfc1.draw(g);
            }

        }
    }
}
