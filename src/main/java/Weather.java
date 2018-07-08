import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Weather {
    public static String getWeather() throws IOException {
        Document doc = Jsoup.connect("https://www.gismeteo.kz/weather-karaganda-5168/").get();
        Element weather = doc.select(".js_value.tab-weather__value_l").first();

        return weather.text();
    }
}
