package com.ulvijabbarli.android_mvp_note.note;

import com.ulvijabbarli.android_mvp_note.R;
import com.ulvijabbarli.android_mvp_note.pojo.Note;

import java.util.List;

public class NotePresenter implements NoteContracter.Presenter {

    private NoteContracter.View noteContracterView;

    private NoteModel noteModel;

    NotePresenter(NoteContracter.View noteContracterView) {
        this.noteContracterView = noteContracterView;
        this.noteContracterView.setPresenter(this);
        noteModel = new NoteModel(noteContracterView.getActivity());
    }


    @Override
    public void getNoteList() {
        if (noteContracterView != null) {
            noteContracterView.showProgressBar();
            if (noteModel != null) {
                List<Note> noteList = noteModel.getAllNote();
                if (noteList != null) {
                    if (noteList.size() > 0) {
                        noteContracterView.onNoteList(noteList);
                    } else {
                        noteContracterView.showErrorMessage(noteContracterView.getContext().getString(R.string.msg_empty_note_list));
                    }
                } else {
                    noteContracterView.showErrorMessage(noteContracterView.getContext().getString(R.string.msg_unknown_error));
                }
            } else {
                noteContracterView.showErrorMessage(noteContracterView.getContext().getString(R.string.msg_empty_note_list));
            }
            noteContracterView.hideProgress();
        }
    }
}
