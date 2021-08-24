package by.wadikk.persistence.dto;

import by.wadikk.persistence.entities.Article;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StoreDTO {

    private Long id;
    private String name;
    private String description;
    private List<Article> articleList;
}
