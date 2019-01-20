package com.ulvijabbarli.android_mvp_note.note;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ulvijabbarli.android_mvp_note.R;
import com.ulvijabbarli.android_mvp_note.pojo.Note;

import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    private List<Note> noteList;
    NoteListAdapter(List<Note> noteList) {
        this.noteList = noteList;
    }


    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_note_list, viewGroup, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder noteViewHolder, int i) {
        noteViewHolder.onBind(noteList.get(i));
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }
}
