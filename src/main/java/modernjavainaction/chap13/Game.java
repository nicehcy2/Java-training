package modernjavainaction.chap13;

import java.util.Arrays;
import java.util.List;

public class Game {

    public static void main(String[] args) {
        List<Resizable> resizableShapes =
                Arrays.asList(new Square(), new Rectangle(), new Ellipse());
        Utils.paint(resizableShapes);

        Monster monster = new Monster(); // 생성자는 내부적으로 좌표, 높이, 너비, 기본 각도를 설정한다.
        monster.rotateBy(180);
        System.out.println("몬스터의 각도: " + monster.getRotationAngle());
        monster.moveVertically(10);
        System.out.println("몬스터의 좌표: (" + monster.getY() + ", " + monster.getX() + ")");
    }
}
