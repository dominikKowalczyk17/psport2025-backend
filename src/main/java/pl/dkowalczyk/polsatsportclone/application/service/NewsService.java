package pl.dkowalczyk.polsatsportclone.application.service;

import org.springframework.stereotype.Service;
import pl.dkowalczyk.polsatsportclone.application.dto.NewsDTO;
import pl.dkowalczyk.polsatsportclone.domain.model.News;
import pl.dkowalczyk.polsatsportclone.domain.repository.NewsRepository;

import java.util.List;

@Service
public class NewsService {
    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<NewsDTO> getAllNews() {
        List<News> newsList = newsRepository.findAll();
        return NewsMapper.toDTOList(newsList);
    }
}
