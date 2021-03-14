package com.jessica.verdugo.textapi;

import com.jessica.verdugo.textapi.model.OutputModel;
import com.jessica.verdugo.textapi.service.TextService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TextServiceTests {

    @Autowired
    TextService textService;

    @Test
    void organiseTextOutPutTest() throws IOException {

        OutputModel map = textService.outputModelCreate(new URL("https://janelwashere.com/files/bible_daily.txt"));
        assertThat(map.getWordsLength().size()).isEqualTo(19);
        assertThat(map.getWordCount().equals(793826));
        assertThat(map.getFrequency().size()).isEqualTo(1);

    }




}
