package pl.dkowalczyk.polsatsportclone.application.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.dkowalczyk.polsatsportclone.application.dto.NewsDTO;
import pl.dkowalczyk.polsatsportclone.application.dto.TagDTO;
import pl.dkowalczyk.polsatsportclone.domain.model.Category;
import pl.dkowalczyk.polsatsportclone.domain.model.News;
import pl.dkowalczyk.polsatsportclone.domain.model.SubCategory;
import pl.dkowalczyk.polsatsportclone.domain.model.Tag;
import pl.dkowalczyk.polsatsportclone.domain.repository.CategoryRepository;
import pl.dkowalczyk.polsatsportclone.domain.repository.NewsRepository;
import pl.dkowalczyk.polsatsportclone.domain.repository.SubCategoryRepository;
import pl.dkowalczyk.polsatsportclone.domain.repository.TagRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class NewsService {

    private final NewsRepository newsRepository;
    private final TagRepository tagRepository;
    private final CategoryRepository categoryRepository;
    private final SubCategoryRepository subCategoryRepository;

    public NewsService(NewsRepository newsRepository, TagRepository tagRepository, CategoryRepository categoryRepository, SubCategoryRepository subCategoryRepository) {
        this.newsRepository = newsRepository;
        this.tagRepository = tagRepository;
        this.categoryRepository = categoryRepository;
        this.subCategoryRepository = subCategoryRepository;
    }


    public List<NewsDTO> getAllNews() {
        List<News> newsList = newsRepository.findAll();
        return NewsMapper.toDTOList(newsList);
    }

    @Transactional
    public NewsDTO createNews(NewsDTO newsDTO) {
        News news = new News();
        news.setTitle(newsDTO.getTitle());
        news.setSlug(newsDTO.getSlug());
        news.setExcerpt(newsDTO.getExcerpt());
        news.setContent(newsDTO.getContent());
        news.setPublishDate(newsDTO.getPublishedDate());
        news.setModificationDate(newsDTO.getModifiedDate());
        news.setUrl(newsDTO.getUrl());
        news.setImageUrl(newsDTO.getImageUrl());
        news.setThumbnailUrl(newsDTO.getThumbnailUrl());
        news.setHot(newsDTO.isHot());
        news.setFeatured(newsDTO.isFeatured());

        // Set Category
        if (newsDTO.getCategory() != null) {
            Category category = categoryRepository.findById(newsDTO.getCategory().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Category not found"));
            news.setCategory(category);
        }

        // Map SubCategory: Lookup subcategory using title and href (or any unique key)
        if (newsDTO.getSubCategory() != null) {
            SubCategory subCategory = subCategoryRepository.findByTitleAndHref(
                            newsDTO.getSubCategory().getTitle(), newsDTO.getSubCategory().getHref())
                    .orElseThrow(() -> new IllegalArgumentException("SubCategory not found"));
            news.setSubCategory(subCategory);
        }

        // Handling Tags (as before)
        List<Tag> tags = newsDTO.getTags().stream()
                .map(tagDTO -> {
                    if (tagDTO.getId() != null) {
                        return tagRepository.findById(tagDTO.getId())
                                .orElseGet(() -> tagRepository.save(new Tag(null, tagDTO.getName())));
                    } else {
                        return tagRepository.findByName(tagDTO.getName())
                                .orElseGet(() -> tagRepository.save(new Tag(null, tagDTO.getName())));
                    }
                })
                .collect(Collectors.toList());
        news.setTags(tags);

        News savedNews = newsRepository.save(news);
        return NewsMapper.toDTO(savedNews);
    }

    @Transactional
    public NewsDTO updateNews(Long id, NewsDTO newsDTO) {
        validateNewsDTO(newsDTO);

        News news = newsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("News with id " + id + " not found"));

        news.setTitle(newsDTO.getTitle());
        news.setSlug(newsDTO.getSlug());
        news.setExcerpt(newsDTO.getExcerpt());
        news.setContent(newsDTO.getContent());
        news.setPublishDate(newsDTO.getPublishedDate());
        news.setModificationDate(newsDTO.getModifiedDate());
        news.setUrl(newsDTO.getUrl());
        news.setImageUrl(newsDTO.getImageUrl());
        news.setThumbnailUrl(newsDTO.getThumbnailUrl());
        news.setHot(newsDTO.isHot());
        news.setFeatured(newsDTO.isFeatured());

        // Update Category
        if (newsDTO.getCategory() != null) {
            Category category = categoryRepository.findById(newsDTO.getCategory().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Category not found"));
            news.setCategory(category);
        }

        // Update SubCategory (lookup by title and href)
        if (newsDTO.getSubCategory() != null) {
            SubCategory subCategory = subCategoryRepository.findByTitleAndHref(
                            newsDTO.getSubCategory().getTitle(), newsDTO.getSubCategory().getHref())
                    .orElseThrow(() -> new IllegalArgumentException("SubCategory not found"));
            news.setSubCategory(subCategory);
        } else {
            news.setSubCategory(null);
        }

        // Handling Tags (as before)
        List<Tag> tags = newsDTO.getTags().stream()
                .map(tagDTO -> {
                    if (tagDTO.getId() != null) {
                        return tagRepository.findById(tagDTO.getId())
                                .orElseGet(() -> tagRepository.save(new Tag(null, tagDTO.getName())));
                    } else {
                        return tagRepository.findByName(tagDTO.getName())
                                .orElseGet(() -> tagRepository.save(new Tag(null, tagDTO.getName())));
                    }
                })
                .collect(Collectors.toList());
        news.setTags(tags);

        News updatedNews = newsRepository.save(news);
        return NewsMapper.toDTO(updatedNews);
    }




    private void mapNewsDTOToEntity(NewsDTO newsDTO, News news) {
        news.setTitle(newsDTO.getTitle());
        news.setSlug(newsDTO.getSlug());
        news.setExcerpt(newsDTO.getExcerpt());
        news.setContent(newsDTO.getContent());
        news.setPublishDate(newsDTO.getPublishedDate());
        news.setModificationDate(newsDTO.getModifiedDate());
        news.setUrl(newsDTO.getUrl());
        news.setImageUrl(newsDTO.getImageUrl());
        news.setThumbnailUrl(newsDTO.getThumbnailUrl());
        news.setHot(newsDTO.isHot());
        news.setFeatured(newsDTO.isFeatured());
    }

    private void validateNewsDTO(NewsDTO newsDTO) {
        if (newsDTO.getCategory() == null || newsDTO.getSubCategory() == null) {
            throw new IllegalArgumentException("Kategoria i subkategoria są wymagane");
        }
        if (newsDTO.getTags() == null || newsDTO.getTags().isEmpty()) {
            throw new IllegalArgumentException("Tagi są wymagane");
        }
    }
}
