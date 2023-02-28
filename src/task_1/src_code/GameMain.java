package task_1.src_code;

public class GameMain {

    public static void main(String[] args) {

        RobotMap map = new RobotMap(5, 5);

        RobotMap.Robot robot = map.createRobot(new Point(2, 3));
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
