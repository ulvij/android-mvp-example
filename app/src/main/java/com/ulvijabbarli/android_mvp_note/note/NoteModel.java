package com.ulvijabbarli.android_mvp_note.note;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;

import com.ulvijabbarli.android_mvp_note.db.note.NoteViewModel;
import com.ulvijabbarli.android_mvp_note.pojo.Note;

import java.util.List;

public class NoteModel implements NoteContracter.Model {

    private NoteViewModel noteViewModel;

    NoteModel(Activity activity) {
        noteViewModel = ViewModelProviders.of((FragmentActivity) activity).get(NoteViewModel.class);
    }

    @Override
    public List<Note> getAllNote() {
        return noteViewModel.getAllNote();
    }
}
