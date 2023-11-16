package pl.dgadecki.springworkshoprestapi.business.article.dto.api;

import pl.dgadecki.springworkshoprestapi.business.article.dto.Article;

import java.util.List;

public record GetAllArticleResponse(
        List<ArticleResponse> articles
) {
    public static GetAllArticleResponse from(List<Article> articles) {
        List<ArticleResponse> articleResponse = articles.stream()
                .map(ArticleResponse::fromArticle)
                .toList();

        return new GetAllArticleResponse(articleResponse);


    }
}
