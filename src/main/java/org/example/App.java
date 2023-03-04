package org.example;

import org.example.system.controller.SystemController;
import org.example.wiseSaying.controller.WiseSayingController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    SystemController systemController = new SystemController();
    WiseSayingController wiseSayingController = new WiseSayingController();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void run() throws IOException {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = br.readLine().trim(); // trim() : 좌우공백 제거

            if (command.equals("종료")) {
                systemController.exit();
                break;
            } else if (command.equals("등록")) {
                wiseSayingController.write();
            } else if (command.equals("목록")) {
                wiseSayingController.show();
            }else if (command.startsWith("삭제")) {
                wiseSayingController.remove(new Rq(command));
            }
        }
    }
}
