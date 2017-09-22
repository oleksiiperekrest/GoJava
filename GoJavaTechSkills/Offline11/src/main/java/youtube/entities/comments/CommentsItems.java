package youtube.entities.comments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentsItems {
    public CommentsSnippet snippet;
}
