import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import youtube.entities.CommentThreadsResponse;
import youtube.entities.CommentsResponse;
import youtube.entities.CommentTHreadsItems;
import youtube.entities.VideosResponse;

import java.io.IOException;

/**
 * Задание 1
 * Консольное приложение принимает на вход массив videoIds.
 * Программа должна загрузить для всех видео комментарии под ними, распарсить в объекты и вывести в консоль.
 * <p>
 * Должно быть выведено:
 * Имя автора
 * Текст сообщения
 * Кол-во лайков
 * Дата последнего изменения
 * Был ли комментарий отредактирован (true/false)
 * Комментарии должны быть сгруппированы в разделы. Один раздел = одно видео. Должно быть выведено имя видео.
 */

public class Program {

    public static void main(String[] args) throws UnirestException {

        initApplication();

        final String APIKEY = "AIzaSyCDZEaKGePlUXS5L-do-hREZ_BiRrdSk5Q";
//        String videoID = "Aa_gwkOZd5s";
        String[] videoIDs = new String[]{
                "Aa_gwkOZd5s", "xcrxNBlqrbM", "zr4MdqXbk7c", "croWDsDhgPo"
        };

        CommentThreadsResponse commentThreadsResponse;
        CommentsResponse commentsResponse;
        for (String videoID : videoIDs) {

            HttpResponse<VideosResponse> videosResponseHttpResponse =
                    Unirest.get("https://www.googleapis.com/youtube/v3/videos")
                    .queryString("part", "snippet")
                    .queryString("id", videoID)
                    .queryString("key", APIKEY)
                    .asObject(VideosResponse.class);

            VideosResponse videosResponse = videosResponseHttpResponse.getBody();

            System.out.println("Video title:\n" + videosResponse.items.get(0).snippet.title);
            System.out.println();

            HttpResponse<CommentThreadsResponse> commentThreadsResponseHttpResponse =
                    Unirest.get("https://www.googleapis.com/youtube/v3/commentThreads")
                            .queryString("part", "id")
                            .queryString("videoId", videoID)
                            .queryString("key", APIKEY)
                            .asObject(CommentThreadsResponse.class);

            commentThreadsResponse = commentThreadsResponseHttpResponse.getBody();


            for (CommentTHreadsItems item : commentThreadsResponse.items) {
                HttpResponse<CommentsResponse> commentsResponseHttpResponse =
                        Unirest.get("https://www.googleapis.com/youtube/v3/comments")
                                .queryString("part", "id,snippet")
                                .queryString("id", item.id)
                                .queryString("key", APIKEY)
                                .asObject(CommentsResponse.class);
                commentsResponse = commentsResponseHttpResponse.getBody();

                System.out.println("Author:\n" + commentsResponse.items.get(0).snippet.authorDisplayName);
                System.out.println("Text:\n" + commentsResponse.items.get(0).snippet.textOriginal);
                System.out.println("Likes:\n" + commentsResponse.items.get(0).snippet.likeCount);
                System.out.println("Updated at:\n" + commentsResponse.items.get(0).snippet.updatedAt);
                System.out.println("Modified:\n" + (commentsResponse.items.get(0).snippet.updatedAt.equals(
                        commentsResponse.items.get(0).snippet.publishedAt) ? "No" : "Yes")
                );
                System.out.println();
            }
            System.out.println("\n\n\n");
        }


//        HttpResponse response = Unirest.get("https://www.googleapis.com/youtube/v3/commentThreads")
//                .queryString("part", "id")
//                .queryString("videoId", videoID)
//                .queryString("key", APIKEY)
//                .asString();
//
//        System.out.println(response.getStatus());
//        System.out.println(response.getBody().toString());


//        HttpResponse stringHttpResponse = Unirest.get("https://www.googleapis.com/youtube/v3/comments")
//                .queryString("part", "id,snippet")
//                .queryString("id", "z220s1salpvovz5i104t1aokgm4anr43hlv5kuw25vhnrk0h00410")
//                .queryString("key", APIKEY)
//                .asString();
//
//        System.out.println(stringHttpResponse.getStatus());
//        System.out.println(stringHttpResponse.getBody().toString());

//
//        HttpResponse<CommentThreadsResponse> commentThreadsResponseHttpResponse =
//                Unirest.get("https://www.googleapis.com/youtube/v3/commentThreads")
//                .queryString("part", "id")
//                .queryString("videoId", videoID)
//                .queryString("key", APIKEY)
//                .asObject(CommentThreadsResponse.class);
//
//        CommentThreadsResponse commentThreadsResponse = commentThreadsResponseHttpResponse.getBody();
//
//        System.out.println(commentThreadsResponse.items.get(0).id);


//        HttpResponse<CommentsResponse> commentsResponseHttpResponse = Unirest.get("https://www.googleapis.com/youtube/v3/comments")
//                .queryString("part", "id,snippet")
//                .queryString("id", "z220s1salpvovz5i104t1aokgm4anr43hlv5kuw25vhnrk0h00410")
//                .queryString("key", APIKEY)
//                .asObject(CommentsResponse.class);
//        CommentsResponse commentsResponse = commentsResponseHttpResponse.getBody();
//
//        System.out.println("Author: " + commentsResponse.items.get(0).snippet.authorDisplayName);
//        System.out.println("Text: " + commentsResponse.items.get(0).snippet.textOriginal);
//        System.out.println("Likes: " + commentsResponse.items.get(0).snippet.likeCount);
//        System.out.println("Updated at: " + commentsResponse.items.get(0).snippet.updatedAt);
//        System.out.println("Modified: " + (commentsResponse.items.get(0).snippet.updatedAt.equals(
//                commentsResponse.items.get(0).snippet.publishedAt) ? "No" : "Yes")
//        );
    }

    private static void initApplication() {
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
