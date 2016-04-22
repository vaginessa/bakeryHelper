package uk.co.o_247a.android.bakeryhelper.Database;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by a247a01 on 21/04/16.
 */
public class DbHelper extends SQLiteOpenHelper {
    private static final int mDbVersion = 1;
    private static String getDbPath(Context aContext){
        return "Database.db";
    }
    public DbHelper(Context aContext, SQLiteDatabase.CursorFactory aFactory) {
        super(aContext, getDbPath(aContext), aFactory, mDbVersion);
    }

    @TargetApi(11)
    public DbHelper(Context aContext, String name, SQLiteDatabase.CursorFactory aFactory, DatabaseErrorHandler aErrorHandler) {
        super(aContext, getDbPath(aContext), aFactory, mDbVersion, aErrorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
