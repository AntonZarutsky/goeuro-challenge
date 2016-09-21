package de.goeuro.devtest.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.goeuro.devtest.ModelStubs;
import de.goeuro.devtest.ResourceLoader;
import java.io.IOException;
import lombok.val;
import org.junit.Test;

import static de.goeuro.devtest.ModelStubs.s1;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SuggestionDeserializationTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void parseCorrectSuggestion() throws IOException {

        val actual = objectMapper.readValue(ResourceLoader.resource("suggestion.json"), Suggestion.class);

        val expected = s1();

        assertThat(actual, equalTo(expected));

    }

    @Test
    public void parseSuggestionWithExtraFields() throws IOException {

        val actual = objectMapper.readValue(ResourceLoader.resource("suggestion.json"), Suggestion.class);

        val expected = s1();

        assertThat(actual, equalTo(expected));

    }

}
