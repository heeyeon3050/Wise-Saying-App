package org.example.wiseSaying.controller;

import org.example.Rq;
import org.example.wiseSaying.entity.WiseSaying;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WiseSayingController {
    private final BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    private long id = 1;
    private final List<WiseSaying> list = new ArrayList<>();

    public void write() throws IOException {
        System.out.print("명언 : ");
        String content = br.readLine().trim();
        System.out.print("작가 : ");
        String authorName = br.readLine().trim();

        WiseSaying wiseSaying = new WiseSaying(id, content, authorName);
        list.add(wiseSaying);

        System.out.println(id++ + "번 명언이 등록되었습니다.");
    }

    public void show() {
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

        WiseSaying wiseSaying = findById(id);
        list.remove(wiseSaying);

        System.out.printf(id + "번 명언이 삭제되었습니다.\n");
    }

    private WiseSaying findById(long id) {
        for (WiseSaying wiseSaying : list) {
            if (wiseSaying.getId() == id) {
                return wiseSaying;
            }
        }

        return null;
    }
}
