package pl.dkowalczyk.polsatsportclone.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dkowalczyk.polsatsportclone.domain.model.Tag;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Optional<Tag> findByName(String name);
}