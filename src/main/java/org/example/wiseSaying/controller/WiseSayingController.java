package org.example.wiseSaying.controller;

import org.example.Rq;
import org.example.wiseSaying.entity.WiseSaying;
import org.example.wiseSaying.service.WiseSayingService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class WiseSayingController {
    WiseSayingService wiseSayingService = new WiseSayingService();
    private final BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

    public void write() throws IOException {
        System.out.print("명언 : ");
        String content = br.readLine().trim();
        System.out.print("작가 : ");
        String author = br.readLine().trim();
        long id = wiseSayingService.write(author, content);

        System.out.println(id + "번 명언이 등록되었습니다.");
    }

    public void show() {
        List<WiseSaying> list = wiseSayingService.findAll();
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(20));
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }

    public void remove(Rq rq) {
        long id = rq.getIntParam("id", -1);
        if (id == -1) {
            System.out.println("id(정수)를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = wiseSayingService.findById(id);

        if (wiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        wiseSayingService.remove(wiseSaying);
        System.out.printf(id + "번 명언이 삭제되었습니다.\n");
    }

    public void modify(Rq rq) throws IOException {
        long id = rq.getIntParam("id", -1);

        if (id == -1) {
            System.out.println("id(정수)를 입력해주세요.");
            return;
        }

        // 입력된 id와 일치하는 명언객체 찾기
        WiseSaying wiseSaying = wiseSayingService.findById(id);

        if (wiseSaying == null) {
            System.out.printf(id + "번 명언은 존재하지 않습니다.\n");
            return;
        }

        System.out.println("명언(기존) : " + wiseSaying.getContent());
        System.out.print("명언 : ");
        String content = br.readLine().trim();

        System.out.println("작가(기존) : " + wiseSaying.getAuthor());
        System.out.print("작가 : ");
        String author = br.readLine().trim();

        wiseSayingService.modify(wiseSaying, content, author);
        System.out.printf("%d번 명언이 수정되었습니다.\n", id);
    }
}
