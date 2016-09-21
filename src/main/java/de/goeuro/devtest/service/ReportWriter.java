package de.goeuro.devtest.service;

import de.goeuro.devtest.dto.ReportDto;
import java.io.Writer;
import java.util.List;
import javax.annotation.Nonnull;


public interface ReportWriter {
    void write(@Nonnull List<ReportDto> data);

    void write(@Nonnull List<ReportDto> data, @Nonnull Writer writer);
}
