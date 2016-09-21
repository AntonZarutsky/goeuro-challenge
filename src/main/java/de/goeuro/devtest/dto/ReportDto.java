package de.goeuro.devtest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.concurrent.Immutable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportDto {

    @JsonProperty("_id")
    private Long id;

    private String name;

    private String type;

    private Double latitude;

    private Double longitude;

}
