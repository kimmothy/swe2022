package yhtommik.Todo;

import java.io.Serializable;
import java.util.Scanner;

public class TodoTheme implements Serializable{
    private enum Color {BLUE, RED, PURPLE, GREEN, SKY_BLUE};
    private enum Image {MOUNTAINS, BEACH, CABIN, FLIGHT, CITY, PLAIN};

    private Color color;
    private Image image;

    public TodoTheme(){
        this.color = Color.BLUE;
        this.image = Image.MOUNTAINS;
    }

    public void setTheme(){
        this.setColor();
        this.setImage();
    }

    private void setColor() {
        for (Color color : Color.values()){//사용자에게 정렬 기준의 목록을 보여주고 선택받음
            System.out.println(color);
        }
        System.out.println(("무엇으로?"));
        Scanner scanner = new Scanner(System.in);
        String color = scanner.nextLine().toUpperCase();

        this.color = Color.valueOf(color);
    }

    private void setImage() {
        for (Image image : Image.values()){//사용자에게 정렬 기준의 목록을 보여주고 선택받음
            System.out.println(image);
        }
        System.out.println(("무엇으로?"));
        Scanner scanner = new Scanner(System.in);
        String image = scanner.nextLine().toUpperCase();

        this.image = Image.valueOf(image);
    }

}
