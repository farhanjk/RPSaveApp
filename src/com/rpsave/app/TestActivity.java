package com.rpsave.app;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.rpsave.app.Helper.RPCommentDisassembler;
import com.rpsave.app.async.SaveTask;
import com.rpsave.app.entities.RPComment;


/*
Test Activity
Calls the saving logic for RPComment object
 */

public class TestActivity extends Activity implements View.OnClickListener {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button bTest = (Button) findViewById(R.id.bTest);
        bTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //Create a dummy RPComment object
        RPComment rpComment=new RPComment();
        rpComment.addPair("Hello", "World");

        //this is a disassembler for RPComment to JSON
        RPCommentDisassembler d = new RPCommentDisassembler();

        //Create a runnable to do the saving
        SaveTask saveTask = new SaveTask(d, rpComment, Uri.EMPTY);

        //And here we go!!
        //Not putting too much stress on async threading model
        Thread t = new Thread(saveTask);
        t.start();
    }
}
