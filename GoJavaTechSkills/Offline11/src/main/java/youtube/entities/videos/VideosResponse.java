package youtube.entities.videos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VideosResponse {

    public List<VideosItems> items;
}
