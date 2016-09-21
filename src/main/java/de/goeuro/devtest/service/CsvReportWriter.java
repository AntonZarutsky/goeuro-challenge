package de.goeuro.devtest.service;


import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import de.goeuro.devtest.dto.ReportDto;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import javax.annotation.Nonnull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkNotNull;

@Component
@Slf4j
public class CsvReportWriter implements ReportWriter {

    @Value("${app.report.fileName}.csv")
    private String fileName;

    private CsvMapper csvMapper = new CsvMapper();

    private CsvSchema schema = csvMapper.schemaFor(ReportDto.class)
                                        .withHeader()
                                        .sortedBy("_id");

    @Override
    public void write(@Nonnull List<ReportDto> data) {
        try (Writer writer = new FileWriter(fileName)) {

            write(data, writer);
            log.info("You can find suggestions in file: {}", fileName);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void write(@Nonnull List<ReportDto> data, @Nonnull Writer writer) {
        checkNotNull(data);
        checkNotNull(writer);

        try {
            csvMapper.writer()
                     .with(schema)
                     .writeValue(writer, data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
