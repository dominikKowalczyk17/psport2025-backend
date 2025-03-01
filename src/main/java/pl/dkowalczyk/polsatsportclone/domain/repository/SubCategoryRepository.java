package pl.dkowalczyk.polsatsportclone.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dkowalczyk.polsatsportclone.domain.model.SubCategory;

import java.util.Optional;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    Optional<SubCategory> findByTitleAndHref(String title, String href);
}
