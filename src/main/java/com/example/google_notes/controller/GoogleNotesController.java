package com.example.google_notes.controller;

import com.example.google_notes.dto.GoogleNotesDTO;
import com.example.google_notes.dto.LabelsDTO;
import com.example.google_notes.model.Labels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import com.example.google_notes.model.GoogleNotes;
import com.example.google_notes.service.GoogleNotesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class GoogleNotesController {

    @Autowired
    private GoogleNotesService googleNotesService;

    // get all google notes
    @GetMapping("/google-notes")
    public List<GoogleNotesDTO> getAllGoogleNotes() {
        List<GoogleNotes> listofnotes = googleNotesService.getAllGoogleNotes();
        List<GoogleNotesDTO> googleNotesDTOs = new ArrayList<GoogleNotesDTO>();

        for (GoogleNotes googleNotes : listofnotes) {
            GoogleNotesDTO googleNotesDTO = new GoogleNotesDTO(googleNotes);
            googleNotesDTOs.add(googleNotesDTO);
        }

        return googleNotesDTOs;
    }

    // create google notes rest api
    @PostMapping("/google-notes")
    public GoogleNotes createGoogleNote(@RequestBody GoogleNotes googleNotes) {
        return googleNotesService.createGoogleNote(googleNotes);
    }

    // get googleNotes by id rest api
    @GetMapping("/google-notes/{id}")
    public ResponseEntity<GoogleNotesDTO> getGoogleNoteById(@PathVariable Long id) {
        GoogleNotes googleNotes = googleNotesService.getGoogleNoteById(id);
        GoogleNotesDTO googleNotesDTO = new GoogleNotesDTO(googleNotes);
        return ResponseEntity.ok(googleNotesDTO);
    }

    // update googleNotes rest api
    @PutMapping("/google-notes/{id}")
    public ResponseEntity<GoogleNotesDTO> updateGoogleNote(
            @PathVariable Long id, @RequestBody GoogleNotes googleNotesDetails) {
        GoogleNotes googleNotes = googleNotesService.updateGoogleNote(id, googleNotesDetails);
        GoogleNotesDTO googleNotesDTO = new GoogleNotesDTO(googleNotes);
        return ResponseEntity.ok(googleNotesDTO);
    }
    @PutMapping("/google-notes/labels/{id}")
    public ResponseEntity<GoogleNotesDTO> updateGoogleNoteLabels(
            @PathVariable Long id, @RequestBody GoogleNotes googleNotesDetails) {
        GoogleNotes googleNotes = googleNotesService.updateGoogleNoteLabels(id, googleNotesDetails);
        GoogleNotesDTO googleNotesDTO = new GoogleNotesDTO(googleNotes);
        return ResponseEntity.ok(googleNotesDTO);
    }
    // delete google notes rest api
    @DeleteMapping("/google-notes/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteGoogleNote(@PathVariable Long id) {
        googleNotesService.deleteGoogleNoteById(id);
        Map<String, Boolean> response = new HashMap<>();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
}
