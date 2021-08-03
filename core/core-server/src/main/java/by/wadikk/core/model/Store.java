package by.wadikk.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@AllArgsConstructor
public class Store {
    private Long id;
    private @NonNull String name;
    private String description;
    private List<Article> articleList;
}
