package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void run() throws IOException {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = br.readLine().trim(); // trim() : 혹시 있을지 모를 좌우공백제거된 버전으로 주세요.

            if (command.equals("종료")) {
                break;
            } else if (command.equals("등록")) {
                System.out.print("명언 : ");
                String content = br.readLine().trim();
                System.out.print("작가 : ");
                String authorName = br.readLine().trim();

                System.out.println("1번 명언이 등록되었습니다.");
            }
        }
    }
}
