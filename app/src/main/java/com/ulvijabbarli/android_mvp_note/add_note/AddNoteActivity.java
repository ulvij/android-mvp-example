package com.ulvijabbarli.android_mvp_note.add_note;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ulvijabbarli.android_mvp_note.R;

public class AddNoteActivity extends AppCompatActivity implements AddNoteContracter.View {

    private EditText editTextNoteTitle;
    private EditText editTextNoteContent;
    AddNoteContracter.Presenter addNotePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        new AddNotePresenter(this);
        editTextNoteTitle = findViewById(R.id.text_note_title);
        editTextNoteContent = findViewById(R.id.text_note_content);
        Button buttonSaveNote = findViewById(R.id.button_note_save);
        buttonSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNotePresenter.onSaveClickListener();
            }
        });
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
    public String getNoteTitle() {
        return editTextNoteTitle.getText().toString().trim();
    }

    @Override
    public String getNoteContent() {
        return editTextNoteContent.getText().toString().trim();
    }

    @Override
    public void showValidationError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProcessingError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSuccess() {
        finish();
    }

    @Override
    public void setPresenter(AddNoteContracter.Presenter presenter) {
        this.addNotePresenter = presenter;
    }
}
