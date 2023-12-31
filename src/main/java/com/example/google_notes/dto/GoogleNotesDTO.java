package com.example.google_notes.dto;

import com.example.google_notes.model.GoogleNotes;
import com.example.google_notes.model.Labels;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class GoogleNotesDTO {
    private long id;
    private Set<LabelsDTO> labelsDTO = new HashSet<>();

    private String titleName;

    private String notecontent;

    private String color;

    private Boolean isPinned;

    private LocalDateTime timeCreated;

    private LocalDateTime lastModified;


    public GoogleNotesDTO() {
    }

    public GoogleNotesDTO(GoogleNotes googleNotes) {
        this.id = googleNotes.getId();
        this.titleName = googleNotes.getTitleName();
        this.notecontent = googleNotes.getNotecontent();
        this.color = googleNotes.getColor();
        this.isPinned = googleNotes.getPinned();
        this.lastModified = googleNotes.getLastModified();
        this.timeCreated = googleNotes.getTimeCreated();
        for (Labels label : googleNotes.getLabels()) {
            this.labelsDTO.add(new LabelsDTO(label));
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getNotecontent() {
        return notecontent;
    }

    public void setNotecontent(String notecontent) {
        this.notecontent = notecontent;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }
    // added a commment
    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public Boolean getPinned() {
        return isPinned;
    }

    public void setPinned(Boolean pinned) {
        isPinned = pinned;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Set<LabelsDTO> getLabels() {
        return labelsDTO;
    }

    public void setLabels(Set<LabelsDTO> labelsDTO) {
        this.labelsDTO = labelsDTO;
    }
}
