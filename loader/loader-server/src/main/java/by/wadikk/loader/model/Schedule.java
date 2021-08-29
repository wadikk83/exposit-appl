package by.wadikk.loader.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class Schedule {
    private String directory;
    private LocalDateTime time;

    public void setTime(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime formatDateTime = LocalDateTime.parse(time, formatter);
        this.time = formatDateTime;
    }
}

