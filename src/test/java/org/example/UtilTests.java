package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UtilTests {

    @Test
    @DisplayName("Util.json.jsonToMapFromFile")
    void t1() {
        Map<String, Object> map = Util.json.jsonToMapFromFile("testData/1.json");

        Map<String, Object> expected = Map.of(
                "id", 1L,
                "content", "나의 죽음을 적들에게 알리지 마라",
                "author", "이순신"
        );

        assertThat(map).isEqualTo(expected);
    }

    @Test
    @DisplayName("Util.file.saveToFile, Util.file.readFromFile")
    void t2(){
        Util.file.saveToFile("testData/test.txt", "안녕");
        String rs = Util.file.readFromFile("testData/test.txt", "");
        Util.file.deleteFile("testData/test.txt");

        assertThat(rs).isEqualTo("안녕");
    }

    @Test
    @DisplayName("Util.file.saveNoToFile, Util.file.readNoFromFile")
    void t3(){
        Util.file.saveNoToFile("testData/test.txt", 5);
        long no = Util.file.readNoFromFile("testData/test.txt", 0);
        Util.file.deleteFile("testData/test.txt");

        assertThat(no).isEqualTo(5);
    }

    @Test
    @DisplayName("Util.file.getFileNamesFromDir")
    void t4(){
        List<String> fileNames = Util.file.getFileNamesFromDir("testData");
        assertThat(fileNames).isEqualTo(List.of("1.json"));

    }
}
