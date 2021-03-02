package com.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main {
    // Action
    static JFrame jFrame = getFrame(); // наша форма
    static JPanel jPanel = new JPanel(); // наша панель

    public static void main(String[] args) {
        // Action
        jFrame.add(jPanel); // добавляем панель
        JButton jButton = new JButton(new MyAction()); // создаем кнопку с действием
        jButton.setText("Hello");
        jPanel.add(jButton);

        // Action + KeyStroke
        AbstractAction myAction = new MyAction(); // наше действие
        KeyStroke keyStroke = KeyStroke.getKeyStroke("ctrl B"); // сочетание клавиш

        // список ключей и их наименований доставаемых из панели
        //когда в фокусе определённый элемент JComponent.WHEN_FOCUSED,
        // когда в фокусе окно JComponent.WHEN_IN_FOCUSED_WINDOW
        InputMap inputMap = jPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(keyStroke, "changeColor");

        // список действий
        ActionMap actionMap = jPanel.getActionMap();
        actionMap.put("changeColor", myAction); // действие соответвующей названию ключа
    }

    // Action
    static class MyAction extends AbstractAction{

        MyAction(){ // Действие при наведении, подсказки
            putValue(AbstractAction.SHORT_DESCRIPTION, "my small action");
        }

        @Override // действие
        public void actionPerformed(ActionEvent e) {
            jPanel.setBackground(Color.BLUE); // покрасить в синий цвет
        }
    }

    // Action
    static JFrame getFrame(){
        JFrame jFrame = new JFrame(); // создается форма
        jFrame.setVisible(true); // влючаем видимость
        jFrame.setBounds(750,250,500,500); // размеры
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // выход
        return jFrame;
    }
}
