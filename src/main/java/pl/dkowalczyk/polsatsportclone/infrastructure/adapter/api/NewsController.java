package pl.dkowalczyk.polsatsportclone.infrastructure.adapter.api;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dkowalczyk.polsatsportclone.application.dto.NewsDTO;
import pl.dkowalczyk.polsatsportclone.application.service.NewsService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
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

    @PostMapping
    public ResponseEntity<NewsDTO> createNews(@Valid @RequestBody NewsDTO newsDTO) {
        NewsDTO savedNews = newsService.createNews(newsDTO);
        return ResponseEntity.ok(savedNews);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsDTO> updateNews(@PathVariable Long id, @Valid @RequestBody NewsDTO newsDTO) {
        // Aktualizacja newsa
        NewsDTO updatedNews = newsService.updateNews(id, newsDTO);
        // Zwrócenie odpowiedzi
        return ResponseEntity.ok(updatedNews);
    }
}
