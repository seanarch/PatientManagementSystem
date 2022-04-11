package com.PatManSystem.main.DTO;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagementDTO implements Serializable {
    private Integer id;
    private Long uliId;
    private LocalDate date;
    private Integer interventionId;
    private String detail;

	public ManagementDTO(Integer id, LocalDate date, Integer interventionId, String detail) {
		this.id = id;
		this.date = date;
		this.interventionId = interventionId;
		this.detail = detail;
	}
}
