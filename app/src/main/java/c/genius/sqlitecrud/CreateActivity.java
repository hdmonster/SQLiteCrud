package c.genius.sqlitecrud;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import c.genius.sqlitecrud.Helper.DataHelper;

public class CreateActivity extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button save, back;
    EditText nomor, nama, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        getSupportActionBar().setTitle("Add Record");

        dbHelper = new DataHelper(this);
        nomor = (EditText) findViewById(R.id.editText1);
        nama = (EditText) findViewById(R.id.editText2);
        gender = (EditText) findViewById(R.id.editText4);
        save = (Button) findViewById(R.id.button1);
        back = (Button) findViewById(R.id.button2);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into Data(nomor, nama, gender) values('" +
                        nomor.getText().toString() + "','" +
                        nama.getText().toString() + "','" +
                        gender.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Record Added", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
}
