package co.edu.eci.ieti.android.network.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import co.edu.eci.ieti.android.network.data.Task;

@Dao
public interface TaskDAO {
    @Insert
    public void insertTask(Task task);

    @Query("SELECT * FROM task")
    public Task[] loadAllTasks();

    @Query("DELETE FROM task")
    public void deleteAll();
}
