package testing.lib.library;

/**
 * Created by yun.li on 1/17/17.
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Design Snake Game
 *
 *         Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.
 *
 *         The snake is initially positioned at the top left corner (0,0) with length = 1 unit.
 *
 *         You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.
 *
 *         Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.
 *
 *         When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.
 *
 *         Example:
 *         Given width = 3, height = 2, and food = [[1,2],[0,1]].
 *
 *         Snake snake = new Snake(width, height, food);
 *
 *         Initially the snake appears at position (0,0) and the food at (1,2).
 *
 *         |S| | |
 *         | | |F|
 *
 *         snake.move("R"); -> Returns 0
 *
 *         | |S| |
 *         | | |F|
 *
 *         snake.move("D"); -> Returns 0
 *
 *         | | | |
 *         | |S|F|
 *
 *         snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )
 *
 *         | |F| |
 *         | |S|S|
 *
 *         snake.move("U"); -> Returns 1
 *
 *         | |F|S|
 *         | | |S|
 *
 *         snake.move("L"); -> Returns 2 (Snake eats the second food)
 *
 *         | |S|S|
 *         | | |S|
 *
 *         snake.move("U"); -> Returns -1 (Game over because snake collides with border)
 */
public class SnakeGame {

    HashSet<String> occupied;
    Queue<int[]> foods;
    LinkedList<int[]> snake;
    int C;
    int R;
    int len;

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        R = height;
        C = width;
        len = 0;
        foods = new LinkedList<>();
        snake = new LinkedList<>();
        occupied = new HashSet<>();
        for (int[] f : food) {
            foods.add(f);
        }
        snake.add(new int[]{0, 0});
        occupied.add("0:0");
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] head = snake.getFirst();

        int[] newP = new int[2];
        switch(direction) {
            case "U":
                newP = new int[]{head[0] - 1, head[1]};
                if (newP[0] < 0) {
                    return -1;
                }
                break;
            case "D":
                newP = new int[]{head[0] + 1, head[1]};
                if (newP[0] >= R) {
                    return -1;
                }
                break;
            case "L":
                newP = new int[]{head[0], head[1] - 1};
                if (newP[1] < 0) {
                    return -1;
                }
                break;
            case "R":
                newP = new int[]{head[0], head[1] + 1};
                if (newP[1] >= C) {
                    return -1;
                }
                break;
            default:
                break;
        }
        String newS = newP[0] + ":" + newP[1];

        if (!foods.isEmpty() && newP[0] == foods.peek()[0] && newP[1] == foods.peek()[1]) {
            int[] food = foods.poll();
            snake.addFirst(food);
            occupied.add(food[0] + ":" + food[1]);
            len++;
        } else {
            int[] last = snake.removeLast();
            occupied.remove(last[0] + ":" + last[1]);

            if (occupied.contains(newS)) {
                return -1;
            }

            snake.addFirst(newP);
            occupied.add(newP[0] + ":" + newP[1]);
        }
        return len;
    }
}
