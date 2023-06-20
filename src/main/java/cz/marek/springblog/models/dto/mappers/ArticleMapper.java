package cz.marek.springblog.models.dto.mappers;

import cz.marek.springblog.data.entities.ArticleEntity;
import cz.marek.springblog.models.dto.ArticleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    ArticleEntity toEntity(ArticleDTO source); // převede dto na záznam
    ArticleDTO toDTO(ArticleEntity source); //převede záznam na dto
    void updateArticleDTO(ArticleDTO source, @MappingTarget ArticleDTO target);
    void updateArticleEntity(ArticleDTO source, @MappingTarget ArticleEntity target);

}
