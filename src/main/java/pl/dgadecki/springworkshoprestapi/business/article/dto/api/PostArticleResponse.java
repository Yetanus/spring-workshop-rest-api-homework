package pl.dgadecki.springworkshoprestapi.business.article.dto.api;

import pl.dgadecki.springworkshoprestapi.business.article.dto.Article;

import java.math.BigDecimal;

public record PostArticleResponse(
        Long id,
        String name,
        String description,
        String producer,
        String eanCode,
        BigDecimal price
) {
    public static PostArticleResponse from(Article article) {
        return new PostArticleResponse(
                article.id(),
                article.name(),
                article.description(),
                article.producer(),
                article.eanCode(),
                article.price()
        );
    }
}
