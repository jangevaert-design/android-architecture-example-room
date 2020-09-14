package edu.cnm.deepdive.architectureexample;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private NoteViewModel noteViewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
    noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
      @Override
      public void onChanged(List<Note> notes) {
        // update RecyclerView
        Toast.makeText(MainActivity.this, "onChanged", Toast.LENGTH_SHORT).show();
      }
    });
  }
}