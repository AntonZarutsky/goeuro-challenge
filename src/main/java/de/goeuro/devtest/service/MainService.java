package de.goeuro.devtest.service;

import de.goeuro.devtest.dto.ReportDto;
import de.goeuro.devtest.util.ModelUtil;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.google.common.base.Preconditions.checkNotNull;


@Slf4j
@Service
public class MainService {

    @Autowired
    private GoEuroClient goEuroClient;

    @Autowired
    private ReportWriter csvReportWriter;

    // specify component contracts is a good practice for application development.
    public void suggest(@Nonnull String cityName) {
        // by using preconditions, like checkNotNull, etc
        checkNotNull(cityName);

        log.info("Getting data from GoEuro API and prepare for report generation");
        List<ReportDto> data =
            goEuroClient.getSuggestions(cityName)
                        .stream()
                        .map(ModelUtil::toReportDto)
                        .collect(Collectors.toList());

//      generate and save report
        csvReportWriter.write(data);
    }
}
