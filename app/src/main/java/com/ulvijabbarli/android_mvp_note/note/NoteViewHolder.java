package com.ulvijabbarli.android_mvp_note.note;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ulvijabbarli.android_mvp_note.R;
import com.ulvijabbarli.android_mvp_note.pojo.Note;

class NoteViewHolder extends RecyclerView.ViewHolder {

    private TextView textViewTitle, textViewContent;

    NoteViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewTitle = itemView.findViewById(R.id.text_title);
        textViewContent = itemView.findViewById(R.id.text_content);
    }

    void onBind(Note note) {
        textViewTitle.setText(note.getTitle());
        textViewContent.setText(note.getContent());
    }
}
