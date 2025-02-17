package pl.dkowalczyk.polsatsportclone.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dkowalczyk.polsatsportclone.domain.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByName(String name);
}
