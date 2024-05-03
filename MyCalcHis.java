import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyCalcHis extends JFrame {
    JLabel firstLbl,secondLbl,ansLbl;
    JTextField txtVal1,txtVal2;
    JTextArea textArea;
    JButton btn;
    JScrollPane scrollPane;

    public MyCalcHis(){
        showFrame();
        this.setLayout(new GridLayout(3,1));

        // The first Panel

        JPanel paneData=new JPanel();
        paneData.setLayout(new GridLayout(2,2));
        paneData.setBorder(BorderFactory.createTitledBorder("Input Data"));
        firstLbl=new JLabel("First Number");
        secondLbl=new JLabel("Second Number");
        txtVal1=new JTextField();
        txtVal2=new JTextField();

        txtVal2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                printTextArea("txt2---->insert number : "+secondLbl.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                printTextArea("txt2---->remove number : "+secondLbl.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        txtVal1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                printTextArea("txt1---->insert number : "+firstLbl.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                printTextArea("txt1---->remove number : "+firstLbl.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });


        paneData.add(firstLbl);paneData.add(txtVal1);
        paneData.add(secondLbl);paneData.add(txtVal2);


        //The second Panel


        JPanel paneAns=new JPanel();
        paneAns.setLayout(new GridLayout(1,2));
        paneAns.setBorder(BorderFactory.createTitledBorder("Calculation"));
        btn=new JButton("Answer");
        ansLbl=new JLabel("");
        ansLbl.setOpaque(true);


        btn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ansLbl.setText(Double.toString(Double.parseDouble(txtVal1.getText())+(Double.parseDouble(txtVal2.getText()))));
                printTextArea("Mouse click----->"+ansLbl.getText());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                ansLbl.setBackground(Color.green);
                printTextArea("Mouse entered-----> lbl bg change to Green");

            }

            @Override
            public void mouseExited(MouseEvent e) {

                ansLbl.setBackground(Color.white);
                printTextArea("Mouse exited-----> lbl bg change to White");
            }
        });
        paneAns.add(btn);
        paneAns.add(ansLbl);

        //The Third Panel



        textArea=new JTextArea();
        scrollPane =new JScrollPane(textArea);




        this.add(paneData);
        this.add(paneAns);
        this.add(scrollPane);
        this.setVisible(true);

    }
    void showFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setLocation(400,300);
    }
    void printTextArea(String s){
        textArea.append("*********************************");
        textArea.append(s);
    }
}
