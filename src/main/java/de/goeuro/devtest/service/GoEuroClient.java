package de.goeuro.devtest.service;

import com.google.common.collect.ImmutableList;
import de.goeuro.devtest.domain.Suggestion;
import de.goeuro.devtest.util.ProcessingException;
import java.util.List;
import javax.annotation.Nonnull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.ImmutableMap.of;


@Slf4j
@Component
public class GoEuroClient {

    @Value("${app.goeuro.api.v2.baseUrl}")
    private String baseUrl;

    @Value("${app.goeuro.api.v2.suggestion}")
    private String suggestionUrlPath;

    @Autowired
    private RestTemplate restTemplate;

    @Nonnull
    @Retryable
    public List<Suggestion> getSuggestions(@Nonnull String cityName) {
        checkNotNull(cityName);

        ResponseEntity<Suggestion[]> result = restTemplate.getForEntity(
                url(suggestionUrlPath),
                Suggestion[].class,
                of("cityName", cityName));

        if (result.getStatusCode() != HttpStatus.OK) {
            throw new ProcessingException("GoEuro API respond with not proper status code");
        }

        return ImmutableList.copyOf(result.getBody());
    }

    private String url(String path) {
        return baseUrl + path;
    }

}
