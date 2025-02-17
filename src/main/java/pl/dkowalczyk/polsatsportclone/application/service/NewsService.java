package pl.dkowalczyk.polsatsportclone.application.service;

import org.springframework.stereotype.Service;
import pl.dkowalczyk.polsatsportclone.domain.repository.NewsRepository;

@Service
public class NewsService {
    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }
}
