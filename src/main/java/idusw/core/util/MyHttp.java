package idusw.core.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MyHttp {
    private static HttpClient httpClient = HttpClient.newHttpClient();

    public static String get(String uri, String serviceKey, String baseDate, String baseTime, String nx, String ny) throws IOException, InterruptedException {

        String uriAndParams = "$uri?serviceKey=$serviceKey&base_date=$baseDate&base_time=$baseTime&nx=$nx&ny=$ny&dataType=json&pageNo=1&numOfRows=1000"
                .replace("$uri", uri)
                .replace("$serviceKey", serviceKey)
                .replace("$baseDate", baseDate)
                .replace("$baseTime", baseTime)
                .replace("$nx", nx)
                .replace("$ny", ny);

        System.out.println(uriAndParams);

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(uriAndParams))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();
    }
}
