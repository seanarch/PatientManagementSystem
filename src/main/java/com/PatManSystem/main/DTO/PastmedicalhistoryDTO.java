package com.PatManSystem.main.DTO;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PastmedicalhistoryDTO implements Serializable {
    private Integer id;
    private Long uliId;
    private String dx;
    private String genDx;
}
