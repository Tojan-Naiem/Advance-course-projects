import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Snake extends JFrame {
    int xS=100,yS=100,flag=4,flagPrint=0,z=0;
    int randomX=50,randomY=150,totalScore=0;
    boolean runGame=true;
    int time=100;
    Frame f=new Frame();
    Random random=new Random();
    int spaceX=0,spaceY=0;
    ArrayList<XY> list=new ArrayList<XY>();
    public Snake(){

        showFrame();
        JPanel panel=new JPanel();
        list.add(new XY(10,10));


        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_UP&&flag!=2){
                    flag=1;
                }
                else if(e.getKeyCode()==KeyEvent.VK_DOWN&&flag!=1){
                    flag=2;
                }
                else if(e.getKeyCode()==KeyEvent.VK_LEFT&&flag!=4){
                    flag=3;
                }
                else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&flag!=3){
                    flag=4;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {


            }
        });
        Timer t=new Timer(time, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  if(runGame){
                    if (flag == 1){
                        yS-=10;

                    }
                    else if (flag == 2){
                        yS+=10;
                    }
                    else if (flag == 3) {
                        xS-=10;

                    }
                    else if (flag == 4){
                        xS+=10;
                    }
                for (int i = list.size() - 1; i > 0; i--) {
                    list.get(i).setX(list.get(i - 1).getX());
                    list.get(i).setY(list.get(i - 1).getY());
                }
                list.get(0).setX(xS);
                list.get(0).setY(yS);

                Rectangle movingRect = new Rectangle(xS, yS, 20, 20);
                Rectangle balRect = new Rectangle(randomX, randomY, 20, 20);

                if (movingRect.intersects(balRect)) {
                    totalScore += 10;
                    randomX = (int) (1 + Math.random() * 26) * 20;
                    randomY = (int) (1 + Math.random() * 26) * 20;
                    list.add(new XY(list.get(list.size() - 1).getX(), list.get(list.size() - 1).getY()));
                }
                gameOver();
                if(totalScore>=50)time=10;
                    repaint();


            }}
        });
        t.start();

        panel.setBackground(Color.black);
        this.setLayout(new BorderLayout());
        this.add(panel,BorderLayout.CENTER);
        this.setVisible(true);

    }
    public void paint(Graphics g){
        super.paint(g);

        g.setColor(Color.green);

        for (XY xy : list) {
            g.fillRoundRect(xy.getX(), xy.getY(), 20, 20, 5, 5);
        }


        g.setColor(Color.red);
        g.fillOval(randomX,randomY,10,10);
        g.setColor(Color.white);
        g.drawString("Score :"+totalScore,getWidth()-100,50);


    }
    public void showFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setLocation(400,100);
        this.setResizable(false);

    }
    public void gameOver(){
        if(yS>getHeight()-30||yS<35||xS<15||xS>getWidth()-30){
            runGame=false;
            showDialog();
        }
    }
    public void showDialog(){
        f.setSize(200,200);
        f.setLocation(700,300);
        JOptionPane.showMessageDialog(null,"GAME OVER");
    }

}
