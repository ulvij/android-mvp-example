package com.ulvijabbarli.android_mvp_note.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.ulvijabbarli.android_mvp_note.db.note.NoteDao;
import com.ulvijabbarli.android_mvp_note.pojo.Note;

@Database(entities = {Note.class},
        version = 1,
        exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase intance;

    public abstract NoteDao noteDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (intance == null) {
            intance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "note_db").fallbackToDestructiveMigration().build();
        }
        return intance;
    }

}
