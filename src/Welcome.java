import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import login.Login;

public class Welcome extends JFrame {
    private JPanel contentPane;
    int x=0;
    Timer timer;
    JLabel label;
    String list[]={
            "Image/osmon.jpg",
            "Image/registon.jpg",
            "Image/b.png.jpg",
            "Image/phone.jpg"
    };

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               try{
                   Welcome welcome=new Welcome();
                   welcome.setVisible(true);
               }catch (Exception e){
                   e.printStackTrace();
               }
            }
        });
    }
    public Welcome(){
       setTitle("Smart City");
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setBounds(100,100,1500,800);
       setLocationRelativeTo(null);
       contentPane=new JPanel();
       contentPane.setBackground(Color.BLACK);
       contentPane.setBorder(new EmptyBorder(5,5,5,5));
       contentPane.setLayout(null);
       setContentPane(contentPane);
       setBackground(Color.BLACK);
       label=new JLabel();
       label.setBounds(0,0,1500,750);
       label.setVisible(true);

       JLabel label1=new JLabel("");
       label1.setFont(new Font("Serif",Font.BOLD,18));
       label1.setForeground(Color.WHITE);
       label1.add(label);

       timer=new Timer(2000, new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               setImageSize(x);
               x+=1;
               if (x>=list.length)
                   x=0;
           }
       });
       timer.start();

       label.setBounds(0,50,1500,750);
       contentPane.add(label);
       JButton btnLogin=new JButton("Login");
       btnLogin.setForeground(Color.BLACK);
       btnLogin.setBackground(Color.WHITE);
       contentPane.add(btnLogin);
       btnLogin.setBounds(1120,11,89,23);

       JButton signupButton=new JButton("Signup");
        signupButton.setForeground(Color.BLACK);
        signupButton.setBackground(Color.WHITE);
       contentPane.add(signupButton);
        signupButton.setBounds(1219,11,89,23);

       JLabel textLabel=new JLabel("SMART SAMRKAND");
       contentPane.add(textLabel);
       textLabel.setFont(new Font("Serif",Font.BOLD,18));
       textLabel.setForeground(Color.WHITE);
       textLabel.setBounds(10,7,300,25);
       signupButton.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {

           }
       });
        signupButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Signup signup=new Signup();
               signup.show();
           }
       });
        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login=new Login();
                login.setVisible(true);
            }
        });
    }

    private void setImageSize(int i) {
        ImageIcon icon=new ImageIcon(list[i]);
        Image image=icon.getImage();
        Image newImg=image.getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon newImgIcon=new ImageIcon(newImg);
        label.setIcon(newImgIcon);
    }
}
