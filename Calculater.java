/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculaterapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// calculater app 

public class Calculater extends JFrame implements ActionListener {
    
    JButton button,plus,multiply,subtraction,division;
    JTextField t;
    JButton arr[]=new JButton[10];
    int a=0,b=0,c=0,d=1,j=0;
    char ch=' ';
    JPanel panel;
    int counter=0;
    JLabel label,l1;
    

    public Calculater()
    {
        this.setTitle("Calculater");
        this.setSize(250,290);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for(int i=0;i<arr.length;i++)
        {
            arr[i]=new JButton(Integer.toString(i));
        }

      
        panel=new JPanel();
  
        button=new JButton("=");
        plus=new JButton("+");
        multiply=new JButton("x");
        subtraction=new JButton("-");
        division=new JButton("/");
        t=new JTextField();


        

        this.add(panel,BorderLayout.CENTER);




   


     
        panel.setLayout(null);

         int x=10,y=50,h=40,w=40,count=0;
   
         for(int i=1;i<arr.length;i++)
        {
            if(i==1||i==4||i==7){x=10;
            }
            else x+=w+10;
            arr[i].setBounds(x, y, w, h);
            count++;
            if(count==3)
            {
                count=0;
                y+=h+10;
            }
            
        }
        arr[0].setBounds(60, 200, 40, 40);
      
        plus.setBounds(170,50,50,40);
        multiply.setBounds(170,95,50,40);
        
        subtraction.setBounds(170,140,50,40);
        division.setBounds(170,185,50,40);
        plus.setBackground(Color.WHITE);
        button.setBounds(110, 200, 45, 40);

        panel.add(plus);

        for(int i=0;i<arr.length;i++)
        {
            panel.add(arr[i]);
        }

     
        panel.add(button);
        panel.setBackground(Color.gray);
        panel.add(multiply);
        multiply.setBackground(Color.WHITE);
        panel.add(subtraction);
        panel.add(division);
        subtraction.setBackground(Color.WHITE);
        division.setBackground(Color.WHITE);

        label=new JLabel("Enter two number : ");
        label.setBounds(20, 10, 120, 20);
        t.setBounds(150, 10, 80, 20);
        panel.add(t);
        label.setFont(new Font(getName(), 20, 12));
        label.setForeground(Color.WHITE);
        panel.add(label);
        l1=new JLabel("    ");
        l1.setBounds(150, 10, 50,20);
        panel.add(l1);
     
        arr[0].addActionListener(this);
        arr[1].addActionListener(this);
        arr[2].addActionListener(this);
        arr[3].addActionListener(this);
        arr[4].addActionListener(this);
        arr[5].addActionListener(this);
        arr[6].addActionListener(this);
        arr[7].addActionListener(this);
        arr[8].addActionListener(this);
        arr[9].addActionListener(this);
        plus.addActionListener(this);
        multiply.addActionListener(this);
        button.addActionListener(this);

        for(int i=0;i<arr.length;i++)
        {
            arr[i].setBackground(Color.WHITE);
        }

        button.setBackground(Color.WHITE);
        

        






    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==plus)
        {j++;d=1;counter=0;ch='+';
        }
        else if(e.getSource()==multiply)
        {
            j++;d=1;counter=0;
            ch='*';
        }
        else if(e.getSource()==button)
        {
            double sum=0;
            switch (ch) {
                case '+':
                {
                    sum=a+b;break;
                }
                case '-':
                {
                    sum=a-b;break;
                }
                case '/':
                {
                    sum=a/b;break;
                }

                default:
                {
                    sum=a*b;break;
                }
                    
            }
            
            
            l1.setText(Double.toString(sum));
        }

       else if(j==0)
        {
            for(int i=0;i<arr.length;i++)
            {
                if(e.getSource()==arr[i])
                {a=(a*d)+(i);
                   if(counter==0) d=10;
                }
            }
            counter++;
        
            
            
        }else  {
         
            for(int i=0;i<arr.length;i++)
            {
                if(e.getSource()==arr[i]){
                    b=(b*d)+(i);
                   
                    if(counter==0) d=10;
                }
              

            }
            counter++;
           
           
        }

       



        
    
       
        
    }
    

    
    
}

