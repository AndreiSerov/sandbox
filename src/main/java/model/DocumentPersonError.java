package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentPersonError {
    private Error error;
}

