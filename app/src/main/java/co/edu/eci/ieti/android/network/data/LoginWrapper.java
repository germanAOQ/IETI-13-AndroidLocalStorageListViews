package co.edu.eci.ieti.android.network.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Fts4;
import androidx.room.PrimaryKey;

/**
 * @author Santiago Carrillo
 * 4/23/19.
 */

@Entity
public class LoginWrapper
{
    @PrimaryKey
    @NonNull
    public final String email;

    public final String password;

    public LoginWrapper( String email, String password )
    {
        this.email = email;
        this.password = password;
    }
}
