/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eightqueenproblem;

import java.util.LinkedList;

/**
 *
 * @author Biplav
 */
public class EightQueenProblem {

    static final int MATRIXSIZE = 8;
    static final int QUEENSIZE = MATRIXSIZE;

    static Cell[] CELL = new Cell[MATRIXSIZE * MATRIXSIZE];
    static LinkedList<Cell> QUEENLIST = new LinkedList();
    static LinkedList<Double> doub = new LinkedList();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        initialize();
        findQueenPosition();
        displayQueen();        
    }

    public static void initialize() {
        for (int i = 0; i < MATRIXSIZE * MATRIXSIZE; i++) {
            CELL[i] = new Cell(i/MATRIXSIZE,i%MATRIXSIZE);
        }
    }

    public static void findQueenPosition() {
        if (QUEENLIST.size() == QUEENSIZE || QUEENSIZE > MATRIXSIZE) {
            return;
        }
        boolean effect;
        for (Cell cell : CELL) {
            effect = false;
            for (Cell queen : QUEENLIST) {
                if (cell.isEffectedBy(queen)) {
                    effect = true;
                    break;
                }
            }
            if (!effect) {
                QUEENLIST.add(cell);
                findQueenPosition();
                if (QUEENLIST.size() == QUEENSIZE) {
                    return;
                }
            }
        }
        if (QUEENLIST.size() < QUEENSIZE && !QUEENLIST.isEmpty()) {
            QUEENLIST.removeLast();
        }
    }

    public static void displayQueen() {
        if (QUEENLIST.isEmpty()) {
            System.out.println("No solution found");
            return;
        }
        System.out.println("Queens : ");
        QUEENLIST.forEach((cell) -> {
            System.out.println(cell.getX() + ", " + cell.getY());
        });
    }

}
