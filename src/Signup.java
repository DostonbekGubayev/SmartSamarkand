import login.DbConnect;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;

public class Signup extends JFrame {
    private JPanel contentPane;
    private JTextField name;
    private JTextField username;
    private JTextField password;
    private JTextField conifrompass;
    private JTextField home;
    private JLabel orqaFon,passLabel,confiLabel,registerLabel;
    Connection connection=null;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Signup signup=new Signup();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    public Signup(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        connection= DbConnect.dataConnector();
        setBounds(100,100,1500,800);
        contentPane=new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        orqaFon=new JLabel("");
        orqaFon.setBounds(0,0,1500,800);
        orqaFon.setIcon(new ImageIcon("osmon.jpg"));
        contentPane.add(orqaFon);

        passLabel=new JLabel("Password:");
        orqaFon.add(passLabel);
        passLabel.setForeground(Color.WHITE);
        passLabel.setBounds(334,610,63,14);

        confiLabel=new JLabel("Conifrom Password");
        orqaFon.add(confiLabel);
       confiLabel.setForeground(Color.WHITE);
       confiLabel.setBounds(334,640,200,14);

       registerLabel=new JLabel("Register");
       registerLabel.setFont(new Font("Tahoma",Font.BOLD,15));
       orqaFon.add(registerLabel);
       registerLabel.setForeground(Color.WHITE);
       registerLabel.setBounds(465,515,110,20);

       name=new JTextField();
       orqaFon.add(name);
       name.setBounds(new Rectangle(465,550,86,20));
       name.setColumns(10);

       home=new JTextField();
       orqaFon.add(home);
       home.setBounds(465,670,56,20);
       home.setColumns(10);

       conifrompass=new JTextField();
       orqaFon.add(conifrompass);
        name.setBounds(new Rectangle(465,640,86,20));
        name.setColumns(10);

        password=new JTextField();
        orqaFon.add(password);
        password.setBounds(new Rectangle(465,610,86,20));
        password.setColumns(10);


    }


    public void show() {
    }
}
