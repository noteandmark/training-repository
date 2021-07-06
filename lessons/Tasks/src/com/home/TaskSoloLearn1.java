package com.home;

import java.util.Scanner;

abstract class Shape {
    int width;
    Shape (int w) {
        width = w;
    }

    abstract void area();
}

 class Square extends Shape {
    Square (int width) {
        super (width);
    }

     @Override
     void area() {
         System.out.println(this.width * this.width);
     }
 }

class Circle extends Shape {
    public Circle(double width) {
        super((int) width);
    }

    @Override
    void area() {
        System.out.println(Math.PI*width*width);
    }
}

public class TaskSoloLearn1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        Square a = new Square(x);
        Circle b = new Circle(y);
        a.area();
        b.area();

    }

}
