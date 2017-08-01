/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eightqueenproblem;

/**
 *
 * @author Biplav
 */
public class Cell {

    private int x;
    private int y;
    private boolean hasQueen;

    public Cell() {
        x = -1;
        y = -1;
        hasQueen = false;
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;        
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean hasQueen() {
        return hasQueen;
    }

    public void setHasQueen(boolean hasQueen) {
        this.hasQueen = hasQueen;
    }

    public int gradient(Cell a) {
        int grad = 1;

        int delx = x - a.x;
        int dely = y - a.y;

        if (delx == 0 || dely == 0 || delx == dely || delx == -dely) {
            grad = 0;
        }

        return grad;
    }    

    public boolean isEffectedBy(Cell a) {
        int delx = x - a.x;
        int dely = y - a.y;

        return delx == 0 || dely == 0 || delx == dely || delx == -dely;
    }
}
