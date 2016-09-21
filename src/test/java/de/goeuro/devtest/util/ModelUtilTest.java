package de.goeuro.devtest.util;

import lombok.val;
import org.junit.Test;

import static de.goeuro.devtest.ModelStubs.s1;
import static de.goeuro.devtest.ModelStubs.s1_no_geo;
import static de.goeuro.devtest.ModelStubs.s1_no_geo_report_dto;
import static de.goeuro.devtest.ModelStubs.s1_report_dto;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ModelUtilTest {


    @Test
    public void transformToReportDto(){

        val actual = ModelUtil.toReportDto(s1());

        val expected = s1_report_dto();

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void transformToReportDtoWithoutGeoPosition(){

        val actual = ModelUtil.toReportDto(s1_no_geo());

        val expected = s1_no_geo_report_dto();

        assertThat(actual, equalTo(expected));
    }

}