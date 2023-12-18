package DecisionGame.System;

import DecisionGame.View.*;
import java.awt.BorderLayout;
import java.util.Random;
import javax.swing.*;
import java.sql.*;
import java.util.TimerTask;
import java.util.Timer;

public class GameLogic {
    private static String MYSQL_JDBC_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static String MYSQL_DB_URL = "jdbc:mysql://localhost:3306/decisiongame_nyusahin";
    private static String MYSQL_DB_USER = "root";
    private static String MYSQL_DB_USER_PASSWORD = "";
    
    static GameStruct tree = new GameStruct();
    static Timer timer = new Timer();
    static int enemy;
    static int value = 5, level = 1, reset = 7, resetcount = 0;
    static String Nama;
    
    public void Main() {
        JFrame frame = new JFrame("Countdown");
        frame.setSize(200, 150);
        frame.setLayout(new BorderLayout());

        JLabel countdownLabel = new JLabel("Hitung mundur belum dimulai");
        countdownLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(countdownLabel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setVisible(true);

        Thread countdownThread = new Thread(() -> {
            for (int i = 5; i > 0; i--) {
                final int count = i;
                SwingUtilities.invokeLater(() -> countdownLabel.setText("Starting in: " + count));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            SwingUtilities.invokeLater(() -> {
                frame.dispose();
                play(); // Memulai aktivitas bermain setelah hitung mundur selesai
            });
        });
        countdownThread.start();
    }

    static void regist(){
        try {
            Connection conn = DriverManager.getConnection(MYSQL_DB_URL, MYSQL_DB_USER, MYSQL_DB_USER_PASSWORD);
            String query = "SELECT Nama FROM user ORDER BY id DESC LIMIT 1";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                Nama = resultSet.getString("Nama");
                tree.Sign(Nama, value);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void play(){
        if(tree.Start == null) regist();
        tree.addOp(Nama);
        enemy = numgen();
        Timer();
        SwingUtilities.invokeLater(() -> {
            Game.knightLabel.setText(tree.Start.name + ": " + tree.Start.value);
            Game.leftLabel.setText(tree.Left.ope + " " + tree.Left.value);
            Game.rightLabel.setText(tree.Right.ope + " " + tree.Right.value);
            Game.enemyLabel.setText("pow: " + String.valueOf(enemy));
            Game.resetLabel.setText("Reset Chance: " + reset);
            Game.levelLabel.setText("Level: " + level);
        });
    }
    
    static int numgen() {
        Random random = new Random();
        int Range = 0;
        while (true){ if(Range != -1) break; }
        if(tree.Start.value >= 1 && tree.Start.value <= 10) Range = random.nextInt(5,15);
        else if(tree.Start.value >= 11 && tree.Start.value <= 20) Range = random.nextInt(10,30);
        else if(tree.Start.value >= 21 && tree.Start.value <= 50) Range = random.nextInt(15,55);
        else if(tree.Start.value >= 51 && tree.Start.value <= 70) Range = random.nextInt(30,100);
        else if(tree.Start.value >= 71 && tree.Start.value <= 100) Range = random.nextInt(60,175);
        else if(tree.Start.value >= 101 && tree.Start.value <= 200) Range = random.nextInt(120,270);
        else if(tree.Start.value >= 201 && tree.Start.value <= 300) Range = random.nextInt(200,500);
        else if(tree.Start.value >= 301 && tree.Start.value <= 400) Range = random.nextInt(300,700);
        else if(tree.Start.value >= 401 && tree.Start.value <= 500) Range = random.nextInt(400,900);
        else Range = random.nextInt(700,1250);
        return Range;
    }
    
    public static void leftChoice(){
        switch (tree.Left.ope) {
            case '-' -> {
                tree.Start.value = tree.Start.value - tree.Left.value;
                tree.Start.value = tree.Start.value - enemy;
                Condition();
            }
            case '+' -> {
                tree.Start.value = tree.Start.value + tree.Left.value;
                tree.Start.value = tree.Start.value - enemy;
                Condition();
            }
            case '/' -> {
                tree.Start.value = tree.Start.value / tree.Left.value;
                tree.Start.value = tree.Start.value - enemy;
                Condition();
            }
            case '*' -> {
                tree.Start.value = tree.Start.value * tree.Left.value;
                tree.Start.value = tree.Start.value - enemy;
                Condition();
            }
            default -> {
            }
        }
        resetTimer();
    }

    public static void rightChoice(){
        switch (tree.Right.ope) {
            case '-' -> {
                tree.Start.value = tree.Start.value - tree.Right.value;
                tree.Start.value = tree.Start.value - enemy;
                Condition();
            }
            case '+' -> {
                tree.Start.value = tree.Start.value + tree.Right.value;
                tree.Start.value = tree.Start.value - enemy;
                Condition();
            }
            case '/' -> {
                tree.Start.value = tree.Start.value / tree.Right.value;
                tree.Start.value = tree.Start.value - enemy;
                Condition();
            }
            case '*' -> {
                tree.Start.value = tree.Start.value * tree.Right.value;
                tree.Start.value = tree.Start.value - enemy;
                Condition();
            }
            default -> {
            }
        }
        resetTimer();
    }
    
    static void Condition(){
        if(tree.Start.value > 0 && level <=20){
            level++;
            play();
        }
        else if(tree.Start.value > 0 && level > 20){
            JOptionPane.showMessageDialog(null, "You Reaches Finish Line");
            isOver();
        }
        else {
            JOptionPane.showMessageDialog(null, "Game Over");
            isOver();
        }
    }

    public static void Reset(){
        reset--;
        resetcount++;
            if(reset != 0){
                play();
            } 
            else{
                JOptionPane.showMessageDialog(null, "Reset chance empty\ngame over");
                tree.Start.value = -100;
                isOver();
            }
        resetTimer();
    }
    
    public static void Timer(){
        if (timer != null) {
            timer.cancel();
        }

        timer = new Timer();
        TimerTask task = new TimerTask() {
            int counter = 10;

            @Override
            public void run() {
                if (counter > 0) {
                    Game.timerLabel.setText("00.0" + counter);
                    counter--;
                } 
                else if(Game.val == true){
                    timer.cancel();
                } 
                else {
                    JOptionPane.showMessageDialog(null, "Times up\ngame over");
                    timer.cancel();
                    isOver();
                }
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000);    
    }
    
    public static void resetTimer() {
        Timer();
    }
    
    public static void Surender(){
        tree.Start.value = -100;
        isOver();
    }

    public static void isOver(){
        try {
            Connection conn = DriverManager.getConnection(MYSQL_DB_URL, MYSQL_DB_USER, MYSQL_DB_USER_PASSWORD);

            String selectIdQuery = "SELECT MAX(id) AS max_id FROM user";

            Statement idStatement = conn.createStatement();
            ResultSet idResultSet = idStatement.executeQuery(selectIdQuery);

            int lastUserId = 0;
            if (idResultSet.next()) {
                lastUserId = idResultSet.getInt("max_id");
            }
            
            idResultSet.close();
            idStatement.close();

            int playerValue = tree.Start.value;
            int highlv = level;
            int resetAtm = resetcount;

            String insertScoreQuery = "INSERT INTO skor (id, level, jumlah_reset, skor) VALUES (?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(insertScoreQuery);
            pstmt.setInt(1, lastUserId);
            pstmt.setInt(2, highlv);
            pstmt.setInt(3, resetAtm);
            pstmt.setInt(4, playerValue);
            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        timer.cancel();
        Game.val = true;
        Game.gameExit();
        Leaderboard ranking = new Leaderboard();
        ranking.setLocationRelativeTo(null);
        ranking.setVisible(true);
        tree.Start = null;
        reset = 7;
        level = 1;
    }

}