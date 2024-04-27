import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpPage extends JFrame {
    JLabel fstNameLbl, mdlNameLbl, lstNameLbl, emailLbl, passwordLbl, confPasswordLbl, mobilLbl, outputLbl;
    JTextField fstNameTxt, mdlNameTxt, lstNameTxt, emailTxt, passwordTxt, confPasswordTxt, mobilTxt;
    JButton signUpBtn, clearAllBtn;

    JPanel panel1, panel2, panel3, panel4, panel5, panel6;
    Border border=BorderFactory.createLineBorder(Color.white); // To change the color of the border *To make the design looks good *
    Font font=new  Font("Tahoma",Font.BOLD,12); // change the font

    public SignUpPage() {

        showFrame();//Method in the same class that contains the size , location and the title for the Frame

        this.setBackground(new Color(153, 217, 217)); // change frame color

        this.setLayout(new GridLayout(6, 1));// add the layout
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();


        // change the color of the panel

        panel1.setBackground(new Color(153, 217, 217));
        panel2.setBackground(new Color(153, 217, 217));
        panel3.setBackground(new Color(153, 217, 217));
        panel4.setBackground(new Color(153, 217, 217));
        panel5.setBackground(new Color(153, 217, 217));
        panel6.setBackground(new Color(153, 217, 217));


        //******************* Here we add the components to the panels *************************************************



        //The first Panel that contains the names

        panel1.setLayout(new GridLayout(3, 3));
        panel1.setBorder(BorderFactory.createTitledBorder(border,"Name"));//creat the border and give it color


        fstNameLbl = new JLabel("First name");
        mdlNameLbl = new JLabel("Middle name");
        lstNameLbl = new JLabel("Last name");
        fstNameTxt = new JTextField();
        mdlNameTxt = new JTextField();
        lstNameTxt = new JTextField();

        // set font to the label and textField


        fstNameLbl.setFont(font);
        mdlNameLbl.setFont(font);
        lstNameLbl.setFont(font);
        fstNameTxt.setFont(font);
        mdlNameTxt.setFont(font);
        lstNameTxt.setFont(font);

        // Add all the components to the first panel in order

        panel1.add(fstNameLbl);
        panel1.add(fstNameTxt);
        panel1.add(mdlNameLbl);
        panel1.add(mdlNameTxt);
        panel1.add(lstNameLbl);
        panel1.add(lstNameTxt);





        //The second Panel that contain the email


        panel2.setLayout(new GridLayout(1, 2));
        panel2.setBorder(BorderFactory.createTitledBorder(border,"Email address"));


        emailLbl = new JLabel("Email address");
        emailTxt = new JTextField();

        // Add font for the email label and txtField

        emailLbl.setFont(font);
        emailTxt.setFont(font);

       // Add both of them into the second panel

        panel2.add(emailLbl);
        panel2.add(emailTxt);


        //******************* here the event for this panel*********************************

        emailTxt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (checkEmail(emailTxt.getText())){   // checkEmail is a method write in the down of the page, check if the email is valid or not
                    outputLbl.setText("Valid Email");
                    outputLbl.setForeground(Color.black);//change the color into black
                }
                else {
                    outputLbl.setText("Invalid Email");
                    outputLbl.setForeground(Color.red);//change it into red if it false
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (checkEmail(emailTxt.getText())){
                    outputLbl.setText("Valid Email");
                    outputLbl.setForeground(Color.black);
                }
                else {
                    outputLbl.setText("Invalid Email");
                    outputLbl.setForeground(Color.red);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });


        //The Third Panel that contains the Password


        panel3.setLayout(new GridLayout(2, 2));
        panel3.setBorder(BorderFactory.createTitledBorder(border,"Password"));


        passwordLbl = new JLabel("Password");
        passwordTxt = new JTextField();
        confPasswordLbl = new JLabel("Confirm Password");
        confPasswordTxt = new JTextField();

        //change the font
        passwordLbl.setFont(font);
        confPasswordLbl.setFont(font);


        panel3.add(passwordLbl);
        panel3.add(passwordTxt);
        panel3.add(confPasswordLbl);
        panel3.add(confPasswordTxt);

        //************* here the event for this panel************************

        passwordTxt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (checkPassword(passwordTxt.getText())){// checkPassword is a method write in the down of the page to check the password strong or weak
                    outputLbl.setText("Strong Password");
                    outputLbl.setForeground(Color.black);
                }
                else {
                    outputLbl.setText("Weak Password");
                    outputLbl.setForeground(Color.red);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (checkPassword(passwordTxt.getText())){
                    outputLbl.setText("Strong Password");
                    outputLbl.setForeground(Color.black);
                }
                else {
                    outputLbl.setText("Weak Password");
                    outputLbl.setForeground(Color.red);
                }

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        confPasswordTxt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (checkMatchPassword(confPasswordTxt.getText(), passwordTxt.getText())){ //checkMatchPassword to check if the both of them are equal or not
                    outputLbl.setText("Correct password");
                    outputLbl.setForeground(Color.black);
                }

                else {
                    outputLbl.setText("Wrong password");
                    outputLbl.setForeground(Color.red);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (checkMatchPassword(confPasswordTxt.getText(), passwordTxt.getText())){
                    outputLbl.setText("Correct password");
                    outputLbl.setForeground(Color.black);
                }

                else {
                    outputLbl.setText("Wrong password");
                    outputLbl.setForeground(Color.red);
                }


            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });


        //The Fourth Panel that contains the Mobile number


        panel4.setLayout(new GridLayout(0, 2));
        panel4.setBorder(BorderFactory.createTitledBorder(border,"Mobile number"));


        mobilLbl = new JLabel("Mobile number");
        mobilTxt = new JTextField();

        //change the font

        mobilLbl.setFont(font);


        panel4.add(mobilLbl);
        panel4.add(mobilTxt);

    //extra *************************************************************************


        mobilTxt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (checkValidMobileNumber(mobilTxt.getText())) {
                    outputLbl.setText("Valid mobile number");
                    outputLbl.setForeground(Color.black);
                }
                else {
                    outputLbl.setText("Invalid mobile number");
                    outputLbl.setForeground(Color.red);
                }

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (checkValidMobileNumber(mobilTxt.getText())) {
                    outputLbl.setText("Valid mobile number");
                    outputLbl.setForeground(Color.black);
                }
                else {
                    outputLbl.setText("Invalid mobile number");
                    outputLbl.setForeground(Color.red);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        //The five Panel that contains the Actions


        panel5.setLayout(new GridLayout(0, 2));
        panel5.setBorder(BorderFactory.createTitledBorder(border,"Actions"));



        signUpBtn = new JButton("Sign-up");
        clearAllBtn = new JButton("Clear all");

        signUpBtn.setBackground(new Color(9, 85, 135));
        clearAllBtn.setBackground(new Color(9, 85, 135));

        //change the font and more things...

        signUpBtn.setFont(font);
        clearAllBtn.setFont(font);
        signUpBtn.setForeground(Color.white);
        clearAllBtn.setForeground(Color.white);
        signUpBtn.setFocusPainted(false);
        clearAllBtn.setFocusPainted(false);


        panel5.add(signUpBtn);
        panel5.add(clearAllBtn);

        //*******************The event in this panel************************

        signUpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fstNameTxt.getText().isEmpty()||lstNameTxt.getText().isEmpty()||
                        mobilTxt.getText().isEmpty()||passwordTxt.getText().isEmpty()||confPasswordTxt.getText().isEmpty()
                ||emailTxt.getText().isEmpty()){
                    outputLbl.setText("Please make sure to provide all information");
                }
                else if(!checkEmail(emailTxt.getText()))outputLbl.setText("You email is invalid");
                else if(!checkPassword(passwordTxt.getText()))outputLbl.setText("Your password is weak");
                else if(!checkMatchPassword(passwordTxt.getText(),confPasswordTxt.getText()))outputLbl.setText("Your password does not match");
                else if(!checkValidMobileNumber(mobilTxt.getText()))outputLbl.setText("Invalid mobile number");
                else outputLbl.setText("Successful sign-up "+"First name : "+fstNameTxt.getText()+" Middle Name :"+mdlNameTxt.getText()+" last name :"+lstNameTxt.getText()+" Email :"+emailTxt.getText()+" Password :"+passwordTxt.getText());
            }
        });

        // To clear all the info after click to clear button



        clearAllBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fstNameTxt.setText("");
                mdlNameTxt.setText("");
                lstNameTxt.setText("");
                emailTxt.setText("");
                passwordTxt.setText("");
                confPasswordTxt.setText("");
                mobilTxt.setText("");
                outputLbl.setText("");
                outputLbl.setBackground(Color.black);
            }
        });


        //The six Panel that contains the output


        panel6.setLayout(new GridLayout(1, 0));
        panel6.setBorder(BorderFactory.createTitledBorder(border,"Output"));
        outputLbl = new JLabel();

        outputLbl.setFont(font);

        panel6.add(outputLbl);


        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
        this.add(panel5);
        this.add(panel6);

        this.setVisible(true);
    }

    private void showFrame() {
        this.setSize(500, 600);
        this.setTitle("Sign-UP form");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(400, 120);
    }

    public boolean checkPassword(String s) {//To check the password


        int lowerCaseLtr = 0;
        int upperCaseLtr = 0;
        int digits = 0;
        int spcChar = 0;

        if (s.length() < 8) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90) upperCaseLtr++;
            else if (s.charAt(i) <= 122 && s.charAt(i) >= 97) lowerCaseLtr++;
            else if (s.charAt(i) >= 48 && s.charAt(i) <= 57) digits++;
            else spcChar++;
        }
        if (upperCaseLtr >= 1 && lowerCaseLtr >= 1 && digits >= 1 && spcChar >= 1) return true;
        return false;

    }

    public boolean checkEmail(String s) {


        if (s.indexOf('@') == -1 || s.indexOf('.') == -1) return false;  // it means that if there's no @ or . in the email


        // ********   firstString @ secondString . domain ***************

        String firstString = s.substring(0, s.indexOf('@'));

        String secondString = s.substring(s.indexOf('@') + 1, s.indexOf('.'));

        String domain = s.substring(s.indexOf('.') + 1);

        int checkString = 0;

        //To check if there's no char such as @ . , $ in the both of them

        for (int i = 0; i < secondString.length(); i++) {
            if (!(Character.isLetter(secondString.charAt(i)) || Character.isDigit(secondString.charAt(i))))
                checkString++;

        }
        for (int i = 0; i < firstString.length(); i++) {
            if (!(Character.isLetter(firstString.charAt(i)) || Character.isDigit(firstString.charAt(i)))) checkString++;

        }

        if ((checkString != 0)) return false;


        // here i add a condition if  the length of the string is more than 2 we can call it a string

        if (firstString.length() >= 2 && secondString.length() >= 2 && (domain.equals("com") || domain.equals("edu")))
            return true;
        return false;


    }

    public boolean checkMatchPassword(String s, String s2) { // To check if the password match
        if (s.equals(s2)) return true;
        return false;
    }

    public boolean checkValidMobileNumber(String number) { // check valid mobile number

        int count = 0;//to check if there's a character in the mobile number

        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) count++;
        }
        // the phone number must have 10 number - i guess-

        if (number.charAt(0) == '0' && number.length() == 10 && count == 0) return true;
        return false;
    }






}
