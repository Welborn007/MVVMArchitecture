package in.kesari.mvvmarchitecture;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

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
