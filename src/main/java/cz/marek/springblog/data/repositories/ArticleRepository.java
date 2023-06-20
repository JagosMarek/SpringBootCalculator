package cz.marek.springblog.data.repositories;

import cz.marek.springblog.data.entities.ArticleEntity;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<ArticleEntity, Long> {
}
