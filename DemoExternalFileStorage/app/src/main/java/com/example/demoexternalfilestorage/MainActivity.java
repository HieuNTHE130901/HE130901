package com.example.demoexternalfilestorage;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_WRITE_EXTERNAL_STORAGE = 1;
    private static final int REQUEST_READ_EXTERNAL_STORAGE = 2;
    private TextView textView;


    /* STEP 2: Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        boolean isWritable = Environment.MEDIA_MOUNTED.equals(state);
        if (!isWritable) {
            Toast.makeText(this, "External storage is not writable.", Toast.LENGTH_SHORT).show();
        }
        return isWritable;
    }

    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        boolean isReadable = Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
        if (!isReadable) {
            Toast.makeText(this, "External storage is not readable.", Toast.LENGTH_SHORT).show();
        }
        return isReadable;
    }


    private void writeDataToExternalStorage() {
        if (isExternalStorageWritable()) {
            // Get the text from the EditText widget
            EditText editText = findViewById(R.id.editText);
            String textToWrite = editText.getText().toString();

            // Check if the text is empty
            if (textToWrite.isEmpty()) {
                Toast.makeText(this, "Text is empty. Please enter some text.", Toast.LENGTH_SHORT).show();
                return;
            }

            //STEP 3: Get the app's external files directory
            File externalFilesDir = getExternalFilesDir(null);

            if (externalFilesDir != null) {
                //STEP 4: Create a file in the external storage directory
                File myFile = new File(externalFilesDir, "my_external_data.txt");

                try {
                    // Write the text to the file
                    FileOutputStream fos = new FileOutputStream(myFile);
                    fos.write(textToWrite.getBytes());
                    fos.close();
                    Toast.makeText(this, "Data written to external storage.", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Error writing data to external storage.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "External storage is not available.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "External storage is not writable.", Toast.LENGTH_SHORT).show();
        }
    }



    private void readDataFromExternalStorage() {
        if (isExternalStorageReadable()) {

            /* STEP 3: Access a public (or private) external storage directory */
            File externalFilesDir = getExternalFilesDir(null);

            if (externalFilesDir != null) {
                /* STEP 4: Read a file to external storage*/
                File myFile = new File(externalFilesDir, "my_external_data.txt");
                try {
                    //Read string from txt file created.
                    FileInputStream fis = new FileInputStream(myFile);
                    int size = fis.available();
                    byte[] buffer = new byte[size];
                    fis.read(buffer);
                    fis.close();
                    String data = new String(buffer);
                    //Set textView to String read from txt file.
                    textView.setText(data);
                    Toast.makeText(this, "Data read from external storage.", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(this, "Error reading data from external storage.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "External storage is not available.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "External storage is not readable.", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteFileFromExternalStorage() {
        if (isExternalStorageWritable()) {
            File externalFilesDir = getExternalFilesDir(null);

            if (externalFilesDir != null) {
                File myFile = new File(externalFilesDir, "my_external_data.txt");

                if (myFile.exists()) {

                    // delete the file.
                    boolean deleted = myFile.delete();
                    if (deleted) {
                        Toast.makeText(this, "File deleted from external storage.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Error deleting file from external storage.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "File does not exist.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "External storage is not available.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "External storage is not writable.", Toast.LENGTH_SHORT).show();
        }
    }







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        Button writeButton = findViewById(R.id.writeButton);
        Button readButton = findViewById(R.id.readButton);
        Button deleteButton = findViewById(R.id.deleteButton);

        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeDataToExternalStorage();
            }
        });

        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readDataFromExternalStorage();
            }
        });


        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteFileFromExternalStorage();
            }
        });


    }



}
