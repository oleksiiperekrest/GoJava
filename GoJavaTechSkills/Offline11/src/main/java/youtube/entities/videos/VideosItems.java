package youtube.entities.videos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VideosItems {

    public VideosSnippet snippet;
}
