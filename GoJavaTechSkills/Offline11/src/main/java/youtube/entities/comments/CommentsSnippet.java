package youtube.entities.comments;

/**
 * Должно быть выведено:
 Имя автора
 Текст сообщения
 Кол-во лайков
 Дата последнего изменения
 Был ли комментарий отредактирован (true/false)
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentsSnippet {
    public String authorDisplayName, textOriginal, publishedAt, updatedAt;
    public int likeCount;
}
