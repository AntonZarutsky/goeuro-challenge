package de.goeuro.devtest.service;

import com.google.common.collect.ImmutableList;
import de.goeuro.devtest.ResourceLoader;
import de.goeuro.devtest.dto.ReportDto;
import java.io.StringWriter;
import java.util.List;
import lombok.val;
import org.junit.Test;

import static de.goeuro.devtest.ModelStubs.s1_report_dto;
import static de.goeuro.devtest.ModelStubs.s2_report_dto;
import static de.goeuro.devtest.ModelStubs.s3_report_dto;
import static de.goeuro.devtest.ModelStubs.s_empty_report_dto;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CsvReportWriterTest {

    CsvReportWriter csvWriter = new CsvReportWriter();

    @Test
    public void writeToCsvStructure() throws Exception {
        List<ReportDto> data = ImmutableList.of(s1_report_dto(), s2_report_dto(), s3_report_dto());
        val expected = ResourceLoader.resource("report.csv");

        val actual = toCsvFormat(data);

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void writeEmptyListToCsvStructure() throws Exception {
        List<ReportDto> data = ImmutableList.of();
        val expected = ResourceLoader.resource("report_header.csv");

        val actual = toCsvFormat(data);

        assertThat(actual, equalTo(expected));
    }

    private String toCsvFormat(List<ReportDto> data) {
        val stringWriter = new StringWriter();
        csvWriter.write(data, stringWriter);

        return stringWriter.toString();
    }

    @Test
    public void writeEmptyReportDtoCsvStructure() throws Exception {
        List<ReportDto> data = ImmutableList.of(s_empty_report_dto());
        val expected = ResourceLoader.resource("report_with_one_empty_dto.csv");

        val actual = toCsvFormat(data);

        assertThat(actual, equalTo(expected));
    }
}