package com.PatManSystem.main.DTO;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsiderDto implements Serializable {
    private Integer id;
    private Long uliId;
    private Integer considerId;
    private String considerDescription;
    private String detail;
}
