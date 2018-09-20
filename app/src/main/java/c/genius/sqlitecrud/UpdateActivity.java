package c.genius.sqlitecrud;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import c.genius.sqlitecrud.Helper.DataHelper;

public class UpdateActivity extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button update, back;
    TextView id;
    EditText nama, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        getSupportActionBar().setTitle("Update Record");

        dbHelper = new DataHelper(this);
        id = (TextView) findViewById(R.id.editText1);
        nama = (EditText) findViewById(R.id.editText2);
        gender = (EditText) findViewById(R.id.editText3);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM Data WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            id.setText(cursor.getString(0).toString());
            nama.setText(cursor.getString(1).toString());
            gender.setText(cursor.getString(2).toString());
        }
        update = (Button) findViewById(R.id.button1);
        back = (Button) findViewById(R.id.button2);
        // daftarkan even onClick pada btnSimpan
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update Data set nama='"+
                        nama.getText().toString()+"', gender='"+
                        gender.getText().toString() + "' where nomor='" +
                        id.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Record Has Been Updated", Toast.LENGTH_LONG).show();
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
