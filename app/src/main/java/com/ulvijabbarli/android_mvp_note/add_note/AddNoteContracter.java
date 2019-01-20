package com.ulvijabbarli.android_mvp_note.add_note;

import android.app.Activity;
import android.content.Context;

import com.ulvijabbarli.android_mvp_note.BasePresenter;

public interface AddNoteContracter {


    interface Model {

        void insertNote(String title, String content);

    }

    interface View extends BasePresenter<Presenter> {

        Context getContext();

        Activity getActivity();

        String getNoteTitle();

        String getNoteContent();

        void showValidationError(String message);

        void showProcessingError(String message);

        void onSuccess();

    }

    interface Presenter {

        void onSaveClickListener();

    }
}
