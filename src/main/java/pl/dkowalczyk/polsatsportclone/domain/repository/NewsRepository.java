package pl.dkowalczyk.polsatsportclone.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dkowalczyk.polsatsportclone.domain.model.News;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findByTitle(String title);
    List<News> findByTags_NameContaining(String tagName);
    List<News> findByIsHotTrue();
}
