package java2.lesson24;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class MyMainWindow extends JFrame {

    private final Vector<String> userList = new Vector<>();
    private final JList jl = new JList();
    private final JTextArea jta = new JTextArea();
    private final JTextField jtf = new JTextField();
    private final String myName = "Дмитрий";

    public MyMainWindow() {
        setTitle("Мой чат");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        //JList
        userList.add("Пользовтель1");
        userList.add("Пользовтель2");
        userList.add("Пользовтель3");
        jl.setListData(userList);
        jl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //JTextArea
        jta.setEditable(false);

        //JButton
        JButton jb = new JButton("Отправить");
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        //JTextField
        jtf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        //Window Layout
        JPanel jp1 = new JPanel();
        jp1.setLayout(new GridLayout());
        jp1.add(jtf);
        jp1.add(jb);

        JScrollPane jsp1 = new JScrollPane(jl);
        JScrollPane jsp2 = new JScrollPane(jta);
        jsp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jsp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        setLayout(new BorderLayout());
        add(jp1, BorderLayout.SOUTH);
        add(jsp1, BorderLayout.WEST);
        add(jsp2, BorderLayout.CENTER);

        setVisible(true);
    }

    public void sendMessage() {
        String text = jtf.getText();
        if(!text.isEmpty()) {
            jta.append(String.format("%s:%s\n", myName, text));
            if(jl.getSelectedIndex() >= 0) {
                jta.append(String.format("%s:%s\n", jl.getSelectedValue(), text));
            }
        }
        jtf.setText("");
    }
}
