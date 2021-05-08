package co.edu.eci.ieti.android.network.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import co.edu.eci.ieti.android.network.data.LoginWrapper;

@Dao
public interface LoginWrapperDAO {
    @Insert
    public void insertLoginWrapper(LoginWrapper loginWrapper);

    @Query("SELECT * FROM loginwrapper")
    public LoginWrapper[] loadAllLoginWrappers();
}
