package idusw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Util 클래스
 * @author Ki-Chang Kim
 */

public class Util {
    private static HttpClient httpClient = HttpClient.newHttpClient();

    /**
     * 공공 데이터 API에 대한 Get 요청을 수행한다.
     *
     * @throws java.io.IOException 입출력 예외 처리
     * @throws java.lang.InterruptedException 잘못된 입력 예외 처리
     *
     * @param uri 서비스 요청 URI
     * @param serviceKey 공공 데이터 API 서비스키
     * @param baseDate 예보 날짜
     * @param baseTime 예보 시각
     * @param xCoord X좌표 값
     * @param yCoord Y좌표 값
     *
     * @return 기상청 예보 데이터
     */
    public static String getFromApi(String uri, String serviceKey, String baseDate, String baseTime, String xCoord, String yCoord) throws IOException, InterruptedException {
        String uriAndParams = "$uri?serviceKey=$serviceKey&base_date=$baseDate&base_time=$baseTime&nx=$nx&ny=$ny&dataType=json&pageNo=1&numOfRows=1000"
                .replace("$uri", uri)
                .replace("$serviceKey", serviceKey)
                .replace("$baseDate", baseDate)
                .replace("$baseTime", baseTime)
                .replace("$xCoord", xCoord)
                .replace("$yCoord", yCoord);

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
