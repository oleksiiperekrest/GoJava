package youtube.entities.commentThreads;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentThreadsResponse {

    public List<CommentThreadsItems> items;
}
