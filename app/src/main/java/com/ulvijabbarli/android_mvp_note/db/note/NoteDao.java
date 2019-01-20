package com.ulvijabbarli.android_mvp_note.db.note;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.ulvijabbarli.android_mvp_note.pojo.Note;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    void insertNote(Note note);

    @Query("select * from note")
    List<Note> getAllNote();

    @Query("select * from note where id=:id")
    Note getNote(int id);

}
