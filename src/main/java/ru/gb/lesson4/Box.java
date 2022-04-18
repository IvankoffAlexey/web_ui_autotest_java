package ru.gb.lesson4;

public class Box {
    private int ballsCount;
    public Box() {
        this.ballsCount = 0;
    }

    public int getBallsCount() {
        return ballsCount;
    }

    public void addBall() {
        ballsCount++;
    }
    public void deleteBall() throws BoxIsAlreadyEmptyExeptions {
        if(ballsCount == 0) {
            throw new BoxIsAlreadyEmptyExeptions();
        }
        ballsCount--;
    }
    public void shuffleBalls() throws NullPointerException {
        if(ballsCount == 0) {
            throw new NullPointerException();
        }
        System.out.println("Перемешали мячи");
    }
}
