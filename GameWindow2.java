package ru.geekbrains.catch_the_drop_2;

import javax.swing.*; //библиотека для создания окна
import java.awt.*;

public class GameWindow extends JFrame { //наследуем класс GameWindow от класса JFrame
    //чтобы создать окно

    private static GameWindow game_window; //объявили переменную (ссылочную) для хранения объекта окна

    public static void main(String[] args) { // Создаем в данном методе наше окно
        game_window = new GameWindow(); // создали объект класса GameWindow
        //  и поместили его в переменную game_window
        game_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //настроили окно так, чтобы при закрытии
        // программа завершалась
        game_window.setLocation(200,100); // начальное расположение окна по оси x=200 px, по оси y=100px
        game_window.setSize(906,478); // размер нашего окна, длина и ширина в пикселях
        game_window.setResizable(false); //запрет на изменение размеров окна
        GameFields game_field = new GameFields(); //создаем панель для рисовани
        game_window.add(game_field);// добавляем панель для рисования на созданное нами окно
        game_window.setVisible(true); // делаем окно видимым (по умолчанию оно невидимо.)

    }

    private static void onRepaint(Graphics g) { // метод для создания возможности рисовать в окне

        //g.fillOval(10,10,200,100); // рисуем на панели овал в точке x=10 y=10 длина 200px ширина 100px
        g.drawLine(10,10,200,10);
    }

    private static class GameFields extends JPanel { //класс панели, метод для вывода пенелей для рисования



        //изменяем поведение метода paintComponent, который расположен в классе JPanel
        // на свое поведение
        // метод paintComponent вызывается с параметром Graphics, когда отрисовывается какой-либо объект

        @Override // переопределение метода
        protected void paintComponent(Graphics g){ // теперь вместо метода paintComponent,
            // расположенного в классе JPanel, будет вызван  paintComponent
            //который написан здесь.
            super.paintComponents(g); //получаем доступ к методу paintComponent, который находится в
            // классе JPanel и отрисовываем панель. Впеременной g содержится
            // объект класса Graphics

            onRepaint(g); // вызываем метод onRepaint и передаем в него переменную g
        }
    }
}