import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class BashUtil {
    public static String getJoke() throws IOException {
        Document doc = Jsoup.connect("http://bashorg.org/casual").get();

        Element q = doc.select(".q").first();

        if (q == null) {
           return  "Ups!";
        }

        Element joke = q.select("div").last();

        return joke.text();

    }
}
