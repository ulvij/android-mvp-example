package com.ulvijabbarli.android_mvp_note.note;

import android.app.Activity;
import android.content.Context;

import com.ulvijabbarli.android_mvp_note.BasePresenter;
import com.ulvijabbarli.android_mvp_note.pojo.Note;

import java.util.List;

public interface NoteContracter {


    interface Model {

        List<Note> getAllNote();

    }

    interface View extends BasePresenter<Presenter> {

        Context getContext();

        Activity getActivity();

        void showProgressBar();

        void hideProgress();

        void showErrorMessage(String message);

        void onNoteList(List<Note> noteList);

    }

    interface Presenter {

        void getNoteList();

    }
}
