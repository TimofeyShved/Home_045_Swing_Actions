package com.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main {

    static JFrame jFrame = getFrame(); // наша форма
    static JPanel jPanel = new JPanel(); // наша панель

    public static void main(String[] args) {
        jFrame.add(jPanel); // добавляем панель
        JButton jButton = new JButton(new MyAction()); // создаем кнопку с действием
        jButton.setText("Hello");
        jPanel.add(jButton);
    }

    static class MyAction extends AbstractAction{

        MyAction(){ // Действие при наведении, подсказки
            putValue(AbstractAction.SHORT_DESCRIPTION, "my small action");
        }

        @Override // действие
        public void actionPerformed(ActionEvent e) {
            jPanel.setBackground(Color.BLUE); // покрасить в синий цвет
        }
    }

    static JFrame getFrame(){
        JFrame jFrame = new JFrame(); // создается форма
        jFrame.setVisible(true); // влючаем видимость
        jFrame.setBounds(750,250,500,500); // размеры
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // выход
        return jFrame;
    }
}
