package com.ulvijabbarli.android_mvp_note.note;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ulvijabbarli.android_mvp_note.R;
import com.ulvijabbarli.android_mvp_note.add_note.AddNoteActivity;
import com.ulvijabbarli.android_mvp_note.pojo.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteActivity extends AppCompatActivity implements NoteContracter.View {

    private ProgressBar progressBar;
    private NoteContracter.Presenter noteContracterPresenter;
    private List<Note> noteList;
    private NoteListAdapter noteListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressbar);
        Button buttonAddNote = findViewById(R.id.button_add_note);
        RecyclerView recyclerViewNoteList = findViewById(R.id.recycler_notes);
        recyclerViewNoteList.setLayoutManager(new LinearLayoutManager(this));
        noteList = new ArrayList<>();
        noteListAdapter = new NoteListAdapter(noteList);
        recyclerViewNoteList.setAdapter(noteListAdapter);
        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NoteActivity.this, AddNoteActivity.class));
            }
        });
        new NotePresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        noteContracterPresenter.getNoteList();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNoteList(List<Note> notes) {
        noteList.clear();
        noteList.addAll(notes);
        noteListAdapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(NoteContracter.Presenter presenter) {
        this.noteContracterPresenter = presenter;
    }
}
