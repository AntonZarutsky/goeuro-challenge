package de.goeuro.devtest;

import de.goeuro.devtest.domain.GeoPosition;
import de.goeuro.devtest.domain.Suggestion;
import de.goeuro.devtest.dto.ReportDto;

import static com.google.common.collect.ImmutableMap.of;

// It's handy to have all heavy test data in separate class(es) and resource files and reuse them in different tests if it's needed.
public class ModelStubs {

    public static final Suggestion s1(){
        return Suggestion.builder()
                        .id(425326)
                        .key("test-key")
                        .name("Bernau bei Berlin")
                        .fullName("Bernau bei Berlin, Germany")
                        .iataAirportCode("TXL")
                        .type("location")
                        .country("Germany")
                        .geoPosition(new GeoPosition(52.67982, 13.58708))
                        .locationId(124669)
                        .inEurope(true)
                        .countryId(56)
                        .countryCode("DE")
                        .coreCountry(true)
                        .distance(1000)
                        .names(of("de","Bernau",
                                  "zh","柏林附近贝尔瑙",
                                  "ru","Бернау"))
                        .alternativeNames(of("de","a-Bernau",
                                             "zh","a-柏林附近贝尔瑙",
                                             "ru","a-Бернау"))
                        .build();
    }
    public static final Suggestion s1_no_geo(){
        return Suggestion.builder()
                        .id(425326)
                        .key("test-key")
                        .name("Bernau bei Berlin")
                        .fullName("Bernau bei Berlin, Germany")
                        .iataAirportCode("TXL")
                        .type("location")
                        .country("Germany")
                        .locationId(124669)
                        .inEurope(true)
                        .countryId(56)
                        .countryCode("DE")
                        .coreCountry(true)
                        .distance(1000)
                        .names(of("de","Bernau",
                                "zh","柏林附近贝尔瑙",
                                "ru","Бернау"))
                        .alternativeNames(of("de","a-Bernau",
                                "zh","a-柏林附近贝尔瑙",
                                "ru","a-Бернау"))
                        .build();
    }
    public static final ReportDto s_empty_report_dto(){
        return ReportDto.builder()
                        .build();
    }

    public static final ReportDto s1_report_dto(){
        return ReportDto.builder()
                        .id(425326l)
                        .name("Bernau bei Berlin")
                        .type("location")
                        .latitude(52.67982)
                        .longitude(13.58708)
                        .build();
    }

    public static final ReportDto s2_report_dto(){
        return ReportDto.builder()
                        .id(455336l)
                        .name("Something else bei Berlin")
                        .type("location")
                        .latitude(51.67682)
                        .longitude(14.57708)
                        .build();
    }

    public static final ReportDto s3_report_dto(){
        return ReportDto.builder()
                        .id(425328l)
                        .name("Tegel bei Berlin")
                        .type("location")
                        .latitude(59.67982)
                        .longitude(12.58708)
                        .build();
    }

    public static final ReportDto s1_no_geo_report_dto(){
        return ReportDto.builder()
                        .id(425326l)
                        .name("Bernau bei Berlin")
                        .type("location")
                        .build();
    }
}