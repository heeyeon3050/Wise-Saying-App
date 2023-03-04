package org.example.wiseSaying.repository;

import org.example.wiseSaying.entity.WiseSaying;
import org.example.wiseSaying.table.WiseSayingTable;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    private WiseSayingTable wiseSayingTable = new WiseSayingTable();
    private long lastWiseSayingId;
    private final List<WiseSaying> wiseSayings;

    public WiseSayingRepository() {
        lastWiseSayingId = 0;
        wiseSayings = new ArrayList<>();
    }

    public List<WiseSaying> findAll() {
        return wiseSayingTable.findAll();
    }

    public WiseSaying findById(long id) {
        return wiseSayingTable.findById(id);
    }

    public long write(String content, String author) {
        long id = wiseSayingTable.getLastId() + 1;
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        return wiseSayingTable.save(wiseSaying);
    }

    public void remove(WiseSaying wiseSaying) {
        wiseSayingTable.remove(wiseSaying);
    }

    public void modify(WiseSaying wiseSaying, String content, String author) {
        wiseSayingTable.modify(wiseSaying, content, author);
    }
}