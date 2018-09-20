package c.genius.sqlitecrud;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import c.genius.sqlitecrud.Helper.DataHelper;

public class ReadActivity extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton2;
    TextView nomor, nama, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        getSupportActionBar().setTitle("Data Info");

        //retrieve data
        dbHelper = new DataHelper(this);
        nomor = (TextView) findViewById(R.id.txtNomor);
        nama = (TextView) findViewById(R.id.txtNama);
        gender = (TextView) findViewById(R.id.txtGender);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM Data WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            nomor.setText(cursor.getString(0).toString());
            nama.setText(cursor.getString(1).toString());
            gender.setText(cursor.getString(2).toString());
        }
        ton2 = (Button) findViewById(R.id.button1);
        ton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
}
