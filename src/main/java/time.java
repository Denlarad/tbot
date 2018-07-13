import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class time {
    public static String getTime() throws IOException {
        Document doc = Jsoup.connect("https://www.timeserver.ru/cities/kz/karaganda").get();
        Element element = doc.select(".timeview-data").first();

        return element.text();

    }
}
