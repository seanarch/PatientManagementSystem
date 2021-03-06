package com.PatManSystem.main.DTO;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsiderDTO implements Serializable {
    private Integer id;
    private Long uliId;
    private Integer considerId;
    private String detail;

	public ConsiderDTO(Integer id, Integer considerId, String detail) {
        this.id = id;
        this.considerId = considerId;
        this.detail = detail;
	}
}
