package c.genius.sqlitecrud.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Haydar Dzaky S on 3/20/2018.
 */

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Crud_SQLite";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(Context context){
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table Data(nomor integer primary key, nama text null, gender text null);";
        Log.d("Data", "onCreate:" +sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }
}
