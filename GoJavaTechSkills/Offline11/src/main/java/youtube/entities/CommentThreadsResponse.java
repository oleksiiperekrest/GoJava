package youtube.entities;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentThreadsResponse {

    public List<CommentTHreadsItems> items;
}
