package com.min.mygreendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


import com.min.mygreendao.db.gen.DaoMaster;
import com.min.mygreendao.db.gen.TestDao;
import com.min.mygreendao.db.gen.UserDao;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Administrator on 2017/9/13.
 *
 * @des 数据库升级
 */
public class MySQLiteOpenHelper extends DaoMaster.OpenHelper {
    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }
    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {

            @Override
            public void onCreateAllTables(Database db, boolean ifNotExists) {
                DaoMaster.createAllTables(db, ifNotExists);
            }

            @Override
            public void onDropAllTables(Database db, boolean ifExists) {
                DaoMaster.dropAllTables(db, ifExists);
            }
        }, UserDao.class,TestDao.class);//, UserDao.class
    }
}
