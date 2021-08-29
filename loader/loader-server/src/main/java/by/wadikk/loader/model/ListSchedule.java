package by.wadikk.loader.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "schedule")
public class ListSchedule {
    private List<Schedule> listSchedule;
}
