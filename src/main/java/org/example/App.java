package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class App {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<WiseSaying> list = new ArrayList<>();

    public void run() throws IOException {

        System.out.println("== 명언 앱 ==");
        long id = 1;

        while (true) {
            System.out.print("명령) ");
            String command = br.readLine().trim(); // trim() : 혹시 있을지 모를 좌우공백제거된 버전으로 주세요.

            if (command.equals("종료")) {
                break;
            } else if (command.equals("등록")) {
                System.out.print("명언 : ");
                String content = br.readLine().trim();
                System.out.print("작가 : ");
                String author = br.readLine().trim();

                WiseSaying wiseSaying = new WiseSaying(id, content, author);
                list.add(wiseSaying);

                System.out.println(id++ + "번 명언이 등록되었습니다.");
            } else if (command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("-".repeat(20));

                for (int i = list.size() - 1; i >= 0; i--) {
                    System.out.println(list.get(i));
                }
            }
        }
    }
}
