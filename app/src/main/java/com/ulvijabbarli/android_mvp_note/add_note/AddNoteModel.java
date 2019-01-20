package com.ulvijabbarli.android_mvp_note.add_note;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;

import com.ulvijabbarli.android_mvp_note.db.note.NoteViewModel;
import com.ulvijabbarli.android_mvp_note.pojo.Note;

public class AddNoteModel implements AddNoteContracter.Model {

    private NoteViewModel noteViewModel;
    private AddNoteCallbackInterface addNoteCallbackInterface;

    AddNoteModel(Activity activity, AddNoteCallbackInterface addNoteCallbackInterface) {
        noteViewModel = ViewModelProviders.of((FragmentActivity) activity).get(NoteViewModel.class);
        this.addNoteCallbackInterface = addNoteCallbackInterface;
    }


    @Override
    public void insertNote(String title, String content) {
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        noteViewModel.insertNote(note);
        addNoteCallbackInterface.onSuccess();
    }
}
