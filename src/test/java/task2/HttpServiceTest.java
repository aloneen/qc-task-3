package task2;



import kz.seisen.task2.HttpService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class HttpServiceTest {

    @Mock
    private HttpClient client;

    @Mock
    private HttpResponse<String> response;

    @InjectMocks
    private HttpService service;

    @Test
    void shouldReturnResponseBody()
            throws IOException, InterruptedException {

        when(response.statusCode()).thenReturn(200);
        when(response.body()).thenReturn("SUCCESS");

        when(client.send(
                any(HttpRequest.class),
                any(HttpResponse.BodyHandler.class)
        )).thenReturn(response);

        String result = service.get("http://localhost");

        assertEquals("SUCCESS", result);

        verify(client).send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class));
        verify(response).statusCode();
    }

    @Test
    void shouldHandleErrorStatus()
            throws IOException, InterruptedException {

        when(response.statusCode()).thenReturn(500);
        when(response.body()).thenReturn("ERROR");

        when(client.<String>send(
                any(HttpRequest.class),
                any(HttpResponse.BodyHandler.class)
        )).thenReturn(response);

        String result = service.get("http://localhost");

        assertEquals("ERROR", result);

        verify(client, times(1)).send(any(), any());
    }
}