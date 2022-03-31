package com.PatManSystem.main.DTO;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewpatientconsultDTO implements Serializable {
    private Long id;
    private Long uliId;
    private LocalDate date;
}
