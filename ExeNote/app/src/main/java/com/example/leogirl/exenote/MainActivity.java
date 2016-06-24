package com.example.leogirl.exenote;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends ListActivity {

    private static final int DELETE_ID = Menu.FIRST;
    private int mNoteNumber = 1;
    private NotesDbAdapter mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notelist);

        mDbHelper = new NotesDbAdapter (this);
        mDbHelper.open();

        registerForContextMenu(getListView());
        Button addnote = (Button)findViewById(R.id.addnotebutton);
        addnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNote();
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_about:

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("About");
                dialog.setMessage("Hello! I'm Heng, the creator of this application. This application is created based on learning." +
                        " Used it on trading or any others activity that is related to business is strictly forbidden."
                        + "If there is any bug is found please freely e-mail me. " +
                        "\n\tedisonthk@gmail.com");

                dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                dialog.show();
                return true;


            default:
                return super.onOptionsItemSelected(item);

        }

    }


    private void createNote() {

        Intent i = new Intent(this,NoteEdit.class);
        startActivityForResult(i,ACTIVITY_CREATE);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent i = new Intent(this,NoteEdit.class);
        i.putExtra(NotesDbAdapter.KEY_ROWID,id);
        startActivityForResult(i,ACTIVITY_EDIT);
    }

    private void fillData() {

        Cursor notecursor = mDbHelper.fetchAllNotes();
        startManagingCursor(notecursor);


        String[] from = new String[] { NotesDbAdapter.KEY_TITLE ,NotesDbAdapter.KEY_DATE};
        int[] to = new int[] { R.id.text1 ,R.id.date_row};


        SimpleCursorAdapter notes =
                new SimpleCursorAdapter(this, R.layout., notesCursor, from, to);
        setListAdapter(notes);

    }

}
