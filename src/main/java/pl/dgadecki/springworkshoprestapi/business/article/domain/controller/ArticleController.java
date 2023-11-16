package pl.dgadecki.springworkshoprestapi.business.article.domain.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.dgadecki.springworkshoprestapi.business.article.domain.service.ArticleService;
import pl.dgadecki.springworkshoprestapi.business.article.dto.Article;
import pl.dgadecki.springworkshoprestapi.business.article.dto.api.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleResponse findArticleById(@PathVariable("id") Long id) {
        return ArticleResponse.fromArticle(articleService.fetchArticleById(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public GetAllArticleResponse findAllArticles() {
        return GetAllArticleResponse.from(articleService.findAllArticles());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PostArticleResponse createArticle(@RequestBody PostArticleRequest postArticleRequest) {
        Article createdArticle = articleService.saveArticle(postArticleRequest.toArticle());
        return PostArticleResponse.from(createdArticle);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public void deleteArticle(@PathVariable("id") Long id) {
        articleService.deleteArticle(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UpdateArticleResponse updateArticle(@PathVariable("id") Long id, @RequestBody UpdateArticleRequest updateArticleRequest) {
        Article updatedArticle = articleService.updateArticle(id, updateArticleRequest.toArticle());
        return UpdateArticleResponse.from(updatedArticle);
    }

}
