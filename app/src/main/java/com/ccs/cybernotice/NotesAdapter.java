package com.ccs.cybernotice;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {
    private List<Note> notes;

    public NotesAdapter(List<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.noteTitle.setText(note.getTitle());
        holder.noteContent.setText(note.getContent());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
        holder.noteDate.setText(sdf.format(note.getDateCreated()));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public static class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView noteTitle, noteContent, noteDate;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            noteTitle = itemView.findViewById(R.id.noteTitle);
            noteContent = itemView.findViewById(R.id.noteContent);
            noteDate = itemView.findViewById(R.id.noteDate);
            itemView.setBackgroundResource(R.drawable.note_border);
        }
    }
}
