package login;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class Login extends JFrame {
    private JPanel contentPane;
    private JTextField usernameText;
    private JTextField passwordText;
    Connection connection=null;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Login frame=new Login();
                   frame.setVisible(true);
                   frame.setBackground(Color.BLACK);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    public Login(){
        setTitle("Login");
        DbConnect dbConnect=new DbConnect();
        connection=dbConnect.dataConnector();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100,100,1500,800);
        contentPane=new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(null);
        contentPane.setBackground(Color.BLACK);
        setContentPane(contentPane);
        setLocationRelativeTo(null);

        JLabel orqaFon=new JLabel("");
        orqaFon.setIcon(new ImageIcon("D:/Rasmlar/registon.jpg"));
        orqaFon.setBounds(0,0,1500,800);
        contentPane.add(orqaFon);

        JLabel usernameLabel=new JLabel("Username");
        orqaFon.add(usernameLabel);
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setBounds(454,570,63,14);

        JLabel passwordLabel=new JLabel("Password");
        orqaFon.add(passwordLabel);
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(454,617,63,14);

        JButton btnLogin=new JButton("Login");
        orqaFon.add(btnLogin);
        orqaFon.setBackground(Color.BLACK);
        btnLogin.setBounds(700,590,86,25);

        usernameText=new JTextField();
        orqaFon.add(usernameText);
        usernameText.setBounds(561,570,86,20);
        usernameText.setColumns(10);

        passwordText=new JTextField();
       orqaFon.add(passwordText);
       passwordText.setBounds(561,617,86,20);
       passwordText.setColumns(10);

       JLabel labelPlease=new JLabel("Please login");
       orqaFon.add(labelPlease);
       labelPlease.setFont(new Font("Tahoma",Font.BOLD,18));
       labelPlease.setForeground(Color.WHITE);
       labelPlease.setBounds(510,524,162,20);

       btnLogin.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               try {
                   String query="INSERT INTO `mexmonlarjadvali`(`Username`, `Password`) VALUES (?,?)";
                   connection= DriverManager.getConnection("jdbc:mysql://localhost/mehmonlar","root","");
                   PreparedStatement pst=connection.prepareStatement(query);
                   pst.setString(1,usernameText.getText());
                   pst.setString(2,passwordText.getText());
                  // ResultSet resultSet=pst.executeQuery();
                   pst.executeUpdate();

                   int count=0;

                   count++;
                   if (count==1){
                       dispose();
                       int t = 0;
                      JOptionPane.showMessageDialog(null,"Login Successful!");
                      if (t==JOptionPane.OK_OPTION) {

                          City city = new City();
                          city.setVisible(true);
                      }
                   }else
                       JOptionPane.showMessageDialog(null,"Wrong Username or Password");
                   //resultSet.close();
                   pst.close();
               } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,ex.getMessage());
               }
           }
       });
       btnLogin.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {

           }
       });
    }

}
