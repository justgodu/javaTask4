package ge.btu.nika_goduadze.repository;

import ge.btu.nika_goduadze.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
