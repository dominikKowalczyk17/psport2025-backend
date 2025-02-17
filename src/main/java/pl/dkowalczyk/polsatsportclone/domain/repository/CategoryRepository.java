package pl.dkowalczyk.polsatsportclone.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dkowalczyk.polsatsportclone.domain.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByTitle(String title);


}
