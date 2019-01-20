package com.ulvijabbarli.android_mvp_note.db.note;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import com.ulvijabbarli.android_mvp_note.pojo.Note;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private NoteRepository noteRepository;


    public NoteViewModel(Application application) {
        super(application);
        noteRepository = new NoteRepository(application);
    }

    public void insertNote(Note note) {
        noteRepository.insertNote(note);
    }

    public List<Note> getAllNote() {
        return noteRepository.getAllNote();
    }

    public Note getNoteById(int id) {
        return noteRepository.getNoteById(id);
    }
}
