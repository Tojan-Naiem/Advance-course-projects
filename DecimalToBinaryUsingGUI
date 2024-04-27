import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class MyFrame2 extends JFrame {
    JLabel enterLabel,answerLabel;
    JRadioButton r1,r2;
    JTextField txt;
    JButton getAnswerButton;

    public MyFrame2() {
      showFrame();
      this.setLayout(new BorderLayout());
      Panel pane=new Panel();
      pane.setLayout(null);
      pane.setBackground(new Color(247, 239, 228));


      txt=new JTextField();
      txt.setBackground(new Color(247, 239, 228));
      enterLabel=new JLabel("Enter Data");
      enterLabel.setFont(new Font("Arial", Font.BOLD, 15));
      r1=new JRadioButton("Ar");
      r2=new JRadioButton("En");
      r1.setBackground(new Color(247, 239, 228));
      r2.setBackground(new Color(247, 239, 228));
      r1.setFocusPainted(false);
      r2.setFocusPainted(false);
      ButtonGroup btnGroup=new ButtonGroup();
      btnGroup.add(r1);
      btnGroup.add(r2);
      answerLabel=new JLabel();
      getAnswerButton=new JButton("Get Answer");
      getAnswerButton.setFocusPainted(false);
      getAnswerButton.setBackground(new Color(253, 203, 214));
      getAnswerButton.setBorder(BorderFactory.createLineBorder(Color.black,1));
      getAnswerButton.setFont(new Font("Arial", Font.BOLD, 15));
      getAnswerButton.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseEntered(MouseEvent e) {
              getAnswerButton.setBackground(new Color(253, 203, 214));
          }
          public void mouseExited(MouseEvent e) {

              getAnswerButton.setBackground(new Color(247, 239, 228));
          }
      });

      getAnswerButton.addActionListener(new ActionListener(){

          @Override
          public void actionPerformed(ActionEvent e) {
              String s=txt.getText();
              int x=Integer.parseInt(s);
              if(r1.isSelected()){
                  answerLabel.setText("الجواب هو : "+Integer.toBinaryString(x));
              }else answerLabel.setText("The answer is : "+Integer.toBinaryString(x));
          }
      });
      enterLabel.setBounds(70,50,100,30);
      txt.setBounds(190,50,150,30);
      r1.setBounds(150,100,50,30);
      r2.setBounds(200,100,50,30);
      getAnswerButton.setBounds(125,145,170,30);
      answerLabel.setBounds(125,180,180,20);
      pane.add(enterLabel);
      pane.add(txt);
      pane.add(r1);
      pane.add(r2);
      pane.add(getAnswerButton);
      pane.add(answerLabel);


      this.add(pane,BorderLayout.CENTER);



        this.setVisible(true);
    }
    public void showFrame(){
        this.setTitle("Decimal to Binary");
        this.setSize(400,250);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(400,120);
    }


}
