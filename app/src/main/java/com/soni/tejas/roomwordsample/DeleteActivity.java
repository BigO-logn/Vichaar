package com.soni.tejas.roomwordsample;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public final class DeleteActivity extends AppCompatActivity {
    Button delete;
    EditText vichaar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        vichaar = findViewById(R.id.etDelete_Vichaar);


        final WordRoomDatabase db= Room.databaseBuilder(getApplicationContext(),WordRoomDatabase.class,"word_database")
                .allowMainThreadQueries()
                .build();

        delete=findViewById(R.id.btnDelete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dV = vichaar.getText().toString();
        //        Log.d("DeleteActivity","dV hai "+dV+" what now");
                db.wordDao().deleteOne(dV);
                Toast.makeText(DeleteActivity.this, "'"+dV+"' Hata Diya!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(DeleteActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}

