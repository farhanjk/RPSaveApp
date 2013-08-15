package com.rpsave.app.async;

import android.net.Uri;
import android.util.Log;
import com.rpsave.app.entities.RPObject;
import com.rpsave.app.utils.Disassembler;

/**
 */
public class SaveTask extends Task {

    RPObject rpObject;
    Disassembler d;
    Uri uri;

    public SaveTask(Disassembler d, RPObject rpObject, Uri uri)
    {
        this.rpObject = rpObject;
        this.d = d;
        this.uri = uri;
    }

    //THIS IS WHERE ALL THE SAVING LOGIC GOES. ONE FOR ALL, AND ALL FOR ONE!
    @Override
    void execute() {

        //TODO:Save RPObject by pushing the JSON to the remote server
        //This is where we need to make changes if the server changes

        String JSONRepresentation = d.disassemble(rpObject);

        //TODO:...Save to server the JSON representation of comment
        //Use uri for web

        Log.d("Yayyy.....", "I just saved it");
    }

}
