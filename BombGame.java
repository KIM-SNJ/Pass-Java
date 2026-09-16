import java.util.Scanner;

class TimerThread extends Thread {

    public static boolean isDefused = false;

    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            if (isDefused) {
                return;
            }

            System.out.println("[타이머] 남은 시간: " + i + "초");

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                System.out.println("타이머 오류");
            }
        }

        if (!isDefused) {
            System.out.println("\n폭탄이 터졌습니다. 게임 오버!");
            System.exit(0);
        }
    }
}

public class BombGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("시한폭탄 해제 게임");
        System.out.println("10초 안에 아래 나오는 해제 코드를 정확히 타이핑하세요!");
        System.out.println("해제 코드: [ public static void main ]\n");

        TimerThread timer = new TimerThread();
        timer.start();

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("public static void main")) {
                TimerThread.isDefused = true;
                System.out.println("\n폭탄 해제 성공! 당신이 세상을 구했습니다!");
                break;
            } else {
                System.out.println("코드가 틀렸습니다! 서두르세요!");
            }
        }

        scanner.close();
    }
}
