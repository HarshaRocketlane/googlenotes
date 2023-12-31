package com.example.google_notes.dto;

import com.example.google_notes.model.Labels;

import java.time.LocalDateTime;


public class LabelsDTO {

    private long id;
    private LocalDateTime timeCreated;
    private String name;


    public LabelsDTO(long id, LocalDateTime timeCreated, String name) {
        this.id = id;
        this.timeCreated = timeCreated;
        this.name = name;
    }

    public LabelsDTO(Labels label) {
        this.id = label.getId();
        this.timeCreated = label.getTimeCreated();
        this.name = label.getName();
    }
    public LabelsDTO() {

    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

