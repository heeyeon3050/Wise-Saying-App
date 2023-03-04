package org.example.wiseSaying.service;

import org.example.Util;
import org.example.wiseSaying.entity.WiseSaying;
import org.example.wiseSaying.repository.WiseSayingRepository;

import java.util.List;
import java.util.stream.Collectors;

public class WiseSayingService {
    private WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();

    public List<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }

    public WiseSaying findById(long id) {
        return wiseSayingRepository.findById(id);
    }

    public long write(String content, String authorName) {
        return wiseSayingRepository.write(content, authorName);
    }

    public void remove(WiseSaying wiseSaying) {
        wiseSayingRepository.remove(wiseSaying);
    }

    public void modify(WiseSaying wiseSaying, String content, String authorName) {
        wiseSayingRepository.modify(wiseSaying, content, authorName);
    }

    public void build() {
        List<WiseSaying> wiseSayings = wiseSayingRepository.findAll();

        Util.file.mkdir("prodBuild");

        String json = "[" + wiseSayings
                .stream()
                .map(wiseSaying -> wiseSaying.toJson())
                .collect(Collectors.joining(",\n")) + "]";

        Util.file.saveToFile("prodBuild/data.json", json);
    }
}

