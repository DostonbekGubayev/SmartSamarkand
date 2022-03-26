package login;

import cityes.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class City extends JFrame {
    private JList cityList;
    private DefaultListModel listArray;
    private JPanel contentPane;
    private JButton btnCancel,subBtn;
    private JTextField text;
    private JLabel back;
    JLabel pic,disp1,disp2,disp3,disp4;

    String cityes[]={"Samarqand","Jambay","Dahbet","Bulvar"};

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    City city=new City();
                    city.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    public String store;
    Registan registan=new Registan();
    Jambay jambay=new Jambay();
    Dahbet dahbet=new Dahbet();
    Bulvar bulvar=new Bulvar();

    private JLabel view;
    public void addList(){
        listArray.addElement("Registan");
        listArray.addElement("Jambay");
        listArray.addElement("Dahbet");
        listArray.addElement("Bulvar");
        contentPane.add(view);
        this.add(text);

        pic.add(subBtn);
        SubmitHandler submit=new SubmitHandler();
        subBtn.addActionListener(submit);
    }

    class  SubmitHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (store.equals("Registan")){
                registan.show();
            } else if (store.equals("Jambay")) {
                jambay.show();
            }else if (store.equals("Dahbet")) {
               dahbet.show();
            }else if (store.equals("Bulvar")) {
                bulvar.show();
            }
        }
    }
    private JComboBox comboBox;
    public City(){
        setTitle("Choose City");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100,100,1500,800);
        setLocationRelativeTo(null);
        setVisible(true);
        contentPane=new JPanel();
        contentPane.setBackground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(null);
        setContentPane(contentPane);
        setBackground(Color.BLACK);

        pic=new JLabel();
        pic.setBounds(0,0,1500,750);
        pic.setVisible(true);
        contentPane.add(pic);disp1=new JLabel();

        disp1.setBounds(10,130,240,150);
        disp1.setVisible(true);
        pic.add(disp1);
        StImageSze(disp1,new ImageIcon("D:/Rasmlar/registon.jpg"));

        disp2=new JLabel();
        disp2.setBounds(290,130,240,150);
        disp2.setVisible(true);
        pic.add(disp2);
        StImageSze(disp2,new ImageIcon("D:/Rasmlar/osmon.jpg"));

        disp3=new JLabel();
        disp3.setBounds(570,130,240,150);
        disp3.setVisible(true);
        pic.add(disp3);
        StImageSze(disp3,new ImageIcon("D:/Rasmlar/a.png.jpg"));

        disp4=new JLabel();
        disp4.setBounds(850,130,240,150);
        disp4.setVisible(true);
        pic.add(disp4);
        StImageSze(disp4,new ImageIcon("D:/Rasmlar/b.png.jpg"));

        String text1="Registon bu qadimiy obidalar ichidagi eng go'zal maqbara bo'lib uni Temuriylar avlodi davomchilari qurdirgan";
        JTextArea textArea1=new JTextArea();
        JTextArea textArea2=new JTextArea();
        JTextArea textArea3=new JTextArea();
        JTextArea textArea4=new JTextArea();
        JTextArea textArea5=new JTextArea();

        String text2="Jambay this region of city Samarkand I'm from of Jambay region I'm intersted programming languages this is my hobbi";
        textArea2.setBackground(Color.white);
        textArea2.setText(text2);
        JScrollPane scrollPane2=new JScrollPane(textArea1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pic.add(scrollPane2);
        scrollPane2.setBounds(290,300,240,150);
        textArea2.setCaretPosition(0);
        textArea2.setLineWrap(true);
        textArea2.setWrapStyleWord(true);
        textArea2.setEditable(false);

        String text3="Dahbet is new City in Samarkand ";
        textArea3.setBackground(Color.white);
        textArea3.setText(text3);
        JScrollPane scrollPane3=new JScrollPane(textArea1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pic.add(scrollPane3);
        scrollPane3.setBounds(570,300,240,150);
        textArea3.setCaretPosition(0);
        textArea3.setLineWrap(true);
        textArea3.setWrapStyleWord(true);
        textArea3.setEditable(false);

        textArea4.setBackground(Color.white);
        textArea4.setText(text1);
        JScrollPane scrollPane4=new JScrollPane(textArea1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pic.add(scrollPane4);
        scrollPane4.setBounds(850,300,240,150);
        textArea4.setCaretPosition(0);
        textArea4.setLineWrap(true);
        textArea4.setWrapStyleWord(true);
        textArea4.setEditable(false);

        listArray=new DefaultListModel();
        text=new JTextField(15);
        subBtn=new JButton("Submit");
        subBtn.setBackground(Color.WHITE);
        subBtn.setForeground(Color.BLACK);
        subBtn.setBounds(575,650,80,25);
        subBtn.setVisible(true);

        btnCancel=new JButton("Close");
        view=new JLabel("Select a City");
        view.setFont(getFont());
        view.setForeground(Color.WHITE);

        comboBox=new JComboBox();
        comboBox.setBounds(550,500,189,41);
        view.setBounds(575,450,200,40);
        view.setVisible(true);

        int count=0;
        for (int i = 0; i < cityes.length; i++) {
            comboBox.addItem(cityes[count++]);
        }

        subBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        subBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected=(String) comboBox.getSelectedItem();
                switch (selected){
                    case "Registan": registan.show();
                    break;
                    case "Jambay": jambay.show();
                    break;
                    case "Dahbet": dahbet.show();
                    break;
                    case "Bulvar": bulvar.show();
                    break;
                }
            }
        });
        getContentPane().setLayout(null);

        JLabel newLabel=new JLabel("Choose a City");
        contentPane.add(newLabel);
        newLabel.setFont(new Font("Arial",Font.BOLD,18));
        newLabel.setForeground(Color.WHITE);
        newLabel.setBounds(10,7,300,25);
        contentPane.add(pic);
        contentPane.add(view);
        contentPane.add(comboBox);
        comboBox.setVisible(true);
        pic.add(subBtn);
       // setVisible(true);

    }

    private void StImageSze(JLabel disp1, ImageIcon imageIcon) {
        back=new JLabel();
        pic.add(back);
        ImageIcon icon=new ImageIcon("D:/Rasmlar/registon.jpg");
        Image image=icon.getImage();
        Image newImage=image.getScaledInstance(pic.getWidth(),pic.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon newImIcon=new ImageIcon(newImage);
        back.setIcon(newImIcon);


    }

}
