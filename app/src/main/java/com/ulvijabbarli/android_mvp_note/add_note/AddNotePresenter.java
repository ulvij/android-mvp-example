package com.ulvijabbarli.android_mvp_note.add_note;

import com.ulvijabbarli.android_mvp_note.R;

public class AddNotePresenter implements AddNoteContracter.Presenter, AddNoteCallbackInterface {


    private AddNoteContracter.View addNoteContracterView;

    AddNotePresenter(AddNoteContracter.View addnoteContracterView) {
        this.addNoteContracterView = addnoteContracterView;
        this.addNoteContracterView.setPresenter(this);

    }

    @Override
    public void onSaveClickListener() {
        if (addNoteContracterView != null) {
            if (addNoteContracterView.getNoteTitle().length() == 0 || addNoteContracterView.getNoteContent().length() == 0) {
                addNoteContracterView.showValidationError(addNoteContracterView.getContext().getString(R.string.msg_validation_message));
            } else {
                AddNoteModel addNoteModel = new AddNoteModel(addNoteContracterView.getActivity(), this);
                addNoteModel.insertNote(addNoteContracterView.getNoteTitle(), addNoteContracterView.getNoteContent());
            }
        }
    }

    @Override
    public void onSuccess() {
        addNoteContracterView.onSuccess();
    }

    @Override
    public void onError() {
        addNoteContracterView.showProcessingError(addNoteContracterView.getContext().getString(R.string.msg_processing_error));
    }
}
