import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {

    public static void main(String[] args){
        MyPanel field = new MyPanel(Color.black);

        JFrame frame = new JFrame();
        frame.setSize(720, 640);
        frame.setLayout(new BorderLayout());


        /////////////////////////////тут кнопки>>>>>>
        JPanel buttons = new JPanel();
        JButton dotss = new JButton("Dots");
        dotss.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.listner.drawingMode =0;
            }
        });
        JButton line1 = new JButton("Line1");
        line1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.listner.drawingMode =1;
            }
        });

        JButton line2 = new JButton("Line2");
        line2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.listner.drawingMode =3;
            }
        });
        JButton rectangle = new JButton("Rectangle");
        rectangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.listner.drawingMode =2;
            }
        });
        JButton circle = new JButton("Circle");
        circle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.listner.drawingMode =4;
            }
        });

        ///////////////////////////////////////////////////фигня с сохранением и чтением
        JButton open = new JButton("open");
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)   {
                FileDialog openDialog = new FileDialog((Frame) null);
                openDialog.setVisible(true);                  // Показали окно и данный вызов не завершиться, пока пользователь не выберет файл или не закроет окно
                String directory = openDialog.getDirectory(); // Узнали папку выбранную пользователем (может быть null)
                String filename = openDialog.getFile();       // Узнали файл выбранный пользователем (может быть null)
                openDialog.dispose();                         // Сказали что все ресурсы связанные с диалоговым окном можно освободить
                if (directory == null || filename == null) {
                    System.out.println("Файл не выбран!");
                    return;
                }
                String path = directory + filename;       // Сложив папку и название файла - получает полный путь к файлу
                System.out.println("Выбранный файл: " + path);
                try{
                    FileInputStream fstream = new FileInputStream(path);
                    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                    String strLine;
                    String typeOf = "";
                   // MyLine line = new MyLine();
                    while ((strLine = br.readLine()) != null){
                        if (strLine.charAt(0)=='E'){
                            typeOf="";
                        }
                        switch(typeOf) {
                            case "Rectangles":
                                field.listner.objectOfPaints.add(new MyRectangle(strLine));
                                break;
                            case "Circle":
                                field.listner.objectOfPaints.add(new MyCircle(strLine));
                                break;
                            case "Dots":
                                field.listner.objectOfPaints.add(new Dot(strLine));
                                break;
                            /*case "Lines":
                                field.listner.objectOfPaints.get(field.listner.objectOfPaints.size()-1).segments.add(new MyLine.Segment(strLine));
                                break;*/
                        }
                        switch(strLine.charAt(0)) {
                            case 'R':
                                typeOf="Rectangles";
                                break;
                            case 'C':
                                typeOf="Circle";
                                break;
                            case 'D':
                                typeOf="Dots";
                                break;
                            /*case 'L':
                                typeOf="Lines";
                                field.listner.objectOfPaints.add(line);
                                break;*/
                        }

                    }
                }catch (IOException k){
                    System.out.println("Ошибка");
                }




            }
        });
        FileDialog saveDialog = new FileDialog((Frame) null);


        JButton save = new JButton("Save");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveDialog.setVisible(true);
                String directory = saveDialog.getDirectory(); // Узнали папку выбранную пользователем (может быть null)
                saveDialog.dispose();
                File file = new File(directory+"Untitled.txt");
                PrintWriter fout = null;
                try {
                    fout = new PrintWriter(file);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }

                for (int i =  0 ; i< field.listner.objectOfPaints.size();i++){
                    //field.listner.objectOfPaints.size()==
                }
                fout.close();
            }
        });
        //////////////////////////////////////////////////////////////////конец фигни с сохранением и чтением


        JButton colors = new JButton("Colors");
        JColorChooser colorChooser = new JColorChooser();
        colorChooser.getSelectionModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                field.chengeColor(colorChooser.getColor());
                colors.setBackground(colorChooser.getColor());
            }
        });
        class ColorDialog extends JDialog {
            public ColorDialog(JFrame owner, String title) {
                super(owner, title, true);
                add(colorChooser);
                setSize(500, 300);
            }
        }
        colors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ColorDialog coldi = new ColorDialog(frame, "Choose colour");
                coldi.setVisible(true);
            }
        });

        JPanel ofFill= new JPanel();
        ofFill.setLayout(new GridLayout(0,2));





        JButton fill = new JButton("Fill color");
        JColorChooser colorChooser1 = new JColorChooser();
        colorChooser1.getSelectionModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                field.chengeFillColor(colorChooser1.getColor());
                fill.setBackground(colorChooser1.getColor());
            }
        });
        class ColorDialog1 extends JDialog {
            public ColorDialog1(JFrame owner, String title) {
                super(owner, title, true);
                add(colorChooser1);
                setSize(500, 300);
            }
        }
        fill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ColorDialog1 coldi1 = new ColorDialog1(frame, "Choose colour");
                coldi1.setVisible(true);
            }
        });


        Color standart = dotss.getBackground();
        JButton offFill = new JButton("Off fill");
        offFill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.chengeFillColor(null);
                fill.setBackground(standart);
            }
        });



        ofFill.add(offFill);
        ofFill.add(fill);

        buttons.setLayout(new GridLayout(9,1));
        buttons.add(dotss);
        buttons.add(line1);
        buttons.add(line2);
        buttons.add(rectangle);
        buttons.add(circle);
        buttons.add(open);
        buttons.add(save);
        buttons.add(colors);
        buttons.add(ofFill);


        //////////////////////////////////конец кнопок<<<<<<<<<<<

        frame.add(field,BorderLayout.CENTER);
        frame.add(buttons,BorderLayout.EAST);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

        while (true){
           frame.repaint();
        }
    }
}