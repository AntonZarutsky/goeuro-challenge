package de.goeuro.devtest.util;

import de.goeuro.devtest.domain.Suggestion;
import de.goeuro.devtest.dto.ReportDto;
import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkNotNull;

public final class ModelUtil {

    private ModelUtil() { }

    @Nonnull
    public static ReportDto toReportDto(@Nonnull Suggestion s){
        checkNotNull(s);

         ReportDto.ReportDtoBuilder builder
                = ReportDto.builder()
                            .id(s.getId())
                            .name(s.getName())
                            .type(s.getType());

        // could happens that API will not provide geo position for this poi.
        if (s.getGeoPosition() != null){
            builder.latitude(s.getGeoPosition().getLatitude());
            builder.longitude(s.getGeoPosition().getLongitude());
        }

        return builder.build();
    }

}
