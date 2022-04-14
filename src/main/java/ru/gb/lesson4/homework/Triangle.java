package ru.gb.lesson4.homework;

public class Triangle {
    private String type;
    public Triangle(String type) {
        this.type = type;

    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return " Треугольник ";
    }


}