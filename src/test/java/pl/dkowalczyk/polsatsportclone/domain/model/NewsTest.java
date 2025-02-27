package pl.dkowalczyk.polsatsportclone.domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NewsTest {

    @Test
    void testLombokGetterSetter() {
        News news = new News();
        news.setTitle("Test");

        assertEquals("Test", news.getTitle());
    }
}
