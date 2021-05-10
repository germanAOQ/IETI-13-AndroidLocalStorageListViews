package co.edu.eci.ieti.android.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import co.edu.eci.ieti.android.network.DAO.LoginWrapperDAO;
import co.edu.eci.ieti.android.network.DAO.TaskDAO;
import co.edu.eci.ieti.android.network.data.LoginWrapper;
import co.edu.eci.ieti.android.network.data.Task;

@Database(entities = {Task.class, LoginWrapper.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "app_db";
    private static AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract TaskDAO taskDAO();
    public abstract LoginWrapperDAO loginWrapperDAO();
}
