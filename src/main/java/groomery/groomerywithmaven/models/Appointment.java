package groomery.groomerywithmaven.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Appointment {
    private static AtomicInteger idGenerator = new AtomicInteger(1);
    private Integer id = idGenerator.getAndIncrement();
    private Integer dogId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime time;
    private Treatment treatment;
    private Boolean isStay;


    public Appointment() {
    }

    public Appointment(Integer dogId, LocalDateTime time, Treatment treatment, Boolean isStay) {
        this.dogId = dogId;
        this.time = time;
        this.treatment = treatment;
        this.isStay = isStay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDogId() {
        return dogId;
    }

    public void setDogId(Integer dogId) {
        this.dogId = dogId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public Boolean getStay() {
        return isStay;
    }

    public void setStay(Boolean stay) {
        isStay = stay;
    }
    public Boolean getIsStay() {
        return isStay;
    }

    public void setIsStay(Boolean stay) {
        isStay = stay;
    }
}
