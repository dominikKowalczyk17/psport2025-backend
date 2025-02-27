package pl.dkowalczyk.polsatsportclone.infrastructure.adapter.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dkowalczyk.polsatsportclone.application.dto.NewsDTO;
import pl.dkowalczyk.polsatsportclone.application.service.NewsService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/news")
public class NewsController {

    public final NewsService newsService;

    public NewsController(final NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public ResponseEntity<List<NewsDTO>> getNews() {
        List<NewsDTO> newsDTOS = newsService.getAllNews();

        if (newsDTOS.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(newsDTOS);
    }
}
