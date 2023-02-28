package task_1;

import task_1.src_code.Direction;
import task_1.src_code.Point;
import task_1.src_code.RobotMap;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RobotMapSolution extends RobotMap {

    int maxRobots = 5; //где проверяется


    public RobotMapSolution(int n, int m, Integer maxRobots) {
        super(n, m);
        if (n < 0 || m < 0) throw new IllegalArgumentException("Отрицательные значения запрещены");

        this.maxRobots = maxRobots;
    }

    public RobotMapSolution(int n, int m) {
        super(n, m);
        if (n < 0 || m < 0) throw new IllegalArgumentException("Отрицательные значения запрещены");
    }

    @Override
    public Robot createRobot(Point point) {
        if (this.robots.size() == this.maxRobots)
            throw new IllegalStateException("Достигнуто максимальное количество роботов в системе");
        validatePoint(point);
        Robot robot = new RobotSolution(point);
        robots.add(robot);

        return robot;
    }


    class RobotSolution extends Robot {

        public RobotSolution(Point point) {
            super(point);
        }

        public void move(int steps) {
            for (int i = 0; i < steps; i++) {
                try {
                    this.move();
                } catch (Exception r) {
                    System.out.println("Роботу удалось пройти на " + i + " шагов");
                    break;
                }
            }
        }


    }

    public static void main(String[] args) {


        try {
            RobotMap badMap = new RobotMapSolution(-1, 100);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }


        try {
            RobotMap robotMap = new RobotMapSolution(100, 100, 8);
            for (int i = 0; i < 40; i++)
                robotMap.createRobot(new Point(ThreadLocalRandom.current().nextInt(0, 10 + 1),
                        ThreadLocalRandom.current().nextInt(0, 10 + 1)));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }


        RobotMap robotMap = new RobotMapSolution(7, 7, 8);
        RobotSolution robotExtender = (RobotSolution) robotMap.createRobot(new Point(5, 5));
        robotExtender.move(5);


        Robot robot = robotMap.createRobot(new Point(2, 3));
        System.out.println(robot); // [2, 3], [TOP]
        robot.move();
        robot.move();
        robot.move();
        robot.move();
        robot.move();
        System.out.println(robot); // [1, 3], [TOP]
        robot.changeDirection(Direction.BOTTOM);
        robot.move();
//        robot.move(5);
        robot.move(); // [3, 3], [BOTTOM]
        robot.changeDirection(Direction.LEFT);
        robot.move();
        System.out.println(robot); // [3, 2], [LEFT]


    }

}
