package com.example.albertln.editdoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DocActivity extends AppCompatActivity {

    public static final int EDIT_TITLE = 0;
    public static final int EDIT_BODY = 1;
    //model
    private String title = "Title", doc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    private TextView title_view;
    private TextView doc_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);

        title_view = findViewById(R.id.title_view);
        doc_view = findViewById(R.id.doc_view);

        title_view.setText(title);
        doc_view.setText(doc);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.doc_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.option_edit_title: {

                Intent intent = new Intent(this, EditActivity.class);
                intent.putExtra("text", title);
                startActivityForResult(intent, EDIT_TITLE);

                break;
            }

            case R.id.option_edit_body:

                Intent intent = new Intent(this, EditActivity.class);
                intent.putExtra("text", doc);
                startActivityForResult(intent, EDIT_BODY);

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case EDIT_TITLE:

                if (resultCode == RESULT_OK) {
                    title = data.getStringExtra("text");
                    title_view.setText(title);
                }

                break;

            case EDIT_BODY:

                if (resultCode == RESULT_OK){
                    doc = data.getStringExtra("text");
                    doc_view.setText(doc);
                }

            default:

                super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
