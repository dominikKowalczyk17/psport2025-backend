package pl.dkowalczyk.polsatsportclone.application.service;

import pl.dkowalczyk.polsatsportclone.application.dto.*;
import pl.dkowalczyk.polsatsportclone.domain.model.News;
import pl.dkowalczyk.polsatsportclone.domain.model.NewsQuote;

import java.util.List;
import java.util.stream.Collectors;

public class NewsMapper {
    public static NewsDTO toDTO(News news) {
        // Mapowanie kategorii
        CategoryDTO categoryDTO = (news.getCategory() != null) ? CategoryMapper.toDTO(news.getCategory()) : null;

        // Mapowanie subkategorii
        SubCategoryDTO subCategoryDTO = (news.getSubCategory() != null) ? new SubCategoryDTO(news.getSubCategory().getTitle(), news.getSubCategory().getHref()) : null;

        // Mapowanie autora
        AuthorDTO authorDTO = (news.getAuthor() != null) ? new AuthorDTO(news.getAuthor().getId(), news.getAuthor().getName(), news.getAuthor().getAvatar()) : null;

        // Mapowanie tags
        List<TagDTO> tagDTO = (news.getTags() != null) ?
                news.getTags().stream().map(tag -> new TagDTO(tag.getId(), tag.getName())).toList() : null;

        // Mapowanie galerii
        List<GalleryDTO> galleryDTOs = (news.getGallery() != null) ?
                news.getGallery().stream().map(image -> new GalleryDTO(image.getThumbnail(), image.getFull(), image.getCaption())).toList() : null;
        // Mapowanie qutoes
        List<QuoteDTO> quoteDTO = (news.getQuotes() != null) ?
                news.getQuotes().stream().map(quote -> new QuoteDTO( quote.getText(), quote.getAuthor(), quote.getPosition() )).toList(): null;

        return new NewsDTO(
                news.getId(),
                news.getTitle(),
                news.getSlug(),
                news.getExcerpt(),
                news.getContent(),
                news.getPublishDate(),
                news.getModificationDate(),
                authorDTO,
                categoryDTO,
                subCategoryDTO,
                news.getUrl(),
                news.getImageUrl(),
                news.getThumbnailUrl(),
                tagDTO,
                news.isHot(),
                news.isFeatured(),
                galleryDTOs,
                quoteDTO
        );
    }

    public static List<NewsDTO> toDTOList(List<News> newsList) {
        return newsList.stream()
                .map(NewsMapper::toDTO)
                .collect(Collectors.toList());
    }
}
