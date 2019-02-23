package in.kesari.mvvmarchitecture;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface CoordinateDao {

    @Insert
    void insert(Coordinates coordinates);

    @Update
    void update(Coordinates coordinates);

    @Delete
    void delete(Coordinates coordinates);

    @Query("DELETE FROM coordinate_table")
    void deleteAllNotes();

    @Query("SELECT * FROM coordinate_table ORDER BY priority DESC")
    LiveData<List<Coordinates>> getallCoordinates();
}
