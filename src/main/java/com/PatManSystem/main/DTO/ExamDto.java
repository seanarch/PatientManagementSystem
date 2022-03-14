package com.PatManSystem.main.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamDto implements Serializable {
    private Integer id;
    private Integer abdoId;
    private String abdoDescription;
    private Integer uliId;
    private LocalDate date;
    private Integer cnsId;
    private Integer lungId;
    private Integer hnId;
    private Integer oralId;
    private Integer cardiacId;
    private Integer mskId;
    private Integer peripheralId;
    private String abnormal;
    private Integer supineId;
    private Integer breathId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAbdoId() {
        return abdoId;
    }

    public void setAbdoId(Integer abdoId) {
        this.abdoId = abdoId;
    }

    public String getAbdoDescription() {
        return abdoDescription;
    }

    public void setAbdoDescription(String abdoDescription) {
        this.abdoDescription = abdoDescription;
    }

    public Integer getUliId() {
        return uliId;
    }



    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getCnsId() {
        return cnsId;
    }

    public void setCnsId(Integer cnsId) {
        this.cnsId = cnsId;
    }

    public Integer getLungId() {
        return lungId;
    }

    public void setLungId(Integer lungId) {
        this.lungId = lungId;
    }

    public Integer getHnId() {
        return hnId;
    }

    public void setHnId(Integer hnId) {
        this.hnId = hnId;
    }

    public Integer getOralId() {
        return oralId;
    }

    public void setOralId(Integer oralId) {
        this.oralId = oralId;
    }

    public Integer getCardiacId() {
        return cardiacId;
    }

    public void setCardiacId(Integer cardiacId) {
        this.cardiacId = cardiacId;
    }

    public Integer getMskId() {
        return mskId;
    }

    public void setMskId(Integer mskId) {
        this.mskId = mskId;
    }

    public Integer getPeripheralId() {
        return peripheralId;
    }

    public void setPeripheralId(Integer peripheralId) {
        this.peripheralId = peripheralId;
    }

    public String getAbnormal() {
        return abnormal;
    }

    public void setAbnormal(String abnormal) {
        this.abnormal = abnormal;
    }

    public Integer getSupineId() {
        return supineId;
    }

    public void setSupineId(Integer supineId) {
        this.supineId = supineId;
    }

    public Integer getBreathId() {
        return breathId;
    }

    public void setBreathId(Integer breathId) {
        this.breathId = breathId;
    }
}
