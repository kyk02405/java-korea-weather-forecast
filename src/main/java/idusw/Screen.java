package idusw;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Screen {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Util util = new Util();

    public void screenMain() throws IOException {
        while (true) {
            System.out.println("------------------------");
            System.out.println("기상청 단기 예보 안내");
            System.out.println("------------------------");

            System.out.println("1. 예보 확인 / 0. 종료");

            int select = Integer.parseInt(reader.readLine());

            if (select == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            switch (select) {
                case 1:
                    screenForecast();
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private void screenForecast() throws IOException {
        System.out.println("1차 행정구역 입력: ");

        String firstDist = reader.readLine();

        System.out.println("2차 행정구역 입력: ");

        String secondDist = reader.readLine();

        System.out.println("3차 행정구역 입력: ");

        String thirdDist = reader.readLine();


    }
}
