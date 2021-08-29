package by.wadikk.persistence.dto;

import by.wadikk.persistence.entities.Article;
import by.wadikk.persistence.entities.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreDto extends AbstractDto {

    private String name;
    private String description;
    private List<ArticleDto> articleList;
}
