package com.ulvijabbarli.android_mvp_note.db.note;

import android.app.Application;
import android.os.AsyncTask;

import com.ulvijabbarli.android_mvp_note.db.AppDatabase;
import com.ulvijabbarli.android_mvp_note.pojo.Note;

import java.util.List;
import java.util.concurrent.ExecutionException;

class NoteRepository {

    private NoteDao noteDao;

    NoteRepository(Application application) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        this.noteDao = appDatabase.noteDao();
    }

    void insertNote(Note note) {
        new InsertNoteTask(noteDao).execute(note);
    }

    List<Note> getAllNote() {
        try {
            return new GetAllNotesTask(noteDao).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    Note getNoteById(int id) {
        try {
            return new GetNoteByIdTask(noteDao).execute(id).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }


    private class InsertNoteTask extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        private InsertNoteTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insertNote(notes[0]);
            return null;
        }
    }

    private class GetAllNotesTask extends AsyncTask<Void, Void, List<Note>> {

        private final NoteDao noteDao;

        private GetAllNotesTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected List<Note> doInBackground(Void... voids) {
            return noteDao.getAllNote();
        }
    }

    private class GetNoteByIdTask extends AsyncTask<Integer, Void, Note> {

        private final NoteDao noteDao;

        private GetNoteByIdTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Note doInBackground(Integer... ids) {
            return noteDao.getNote(ids[0]);
        }
    }
}
