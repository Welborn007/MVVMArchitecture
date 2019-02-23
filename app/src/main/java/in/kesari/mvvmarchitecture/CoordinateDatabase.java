package in.kesari.mvvmarchitecture;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Coordinates.class}, version = 1)
public abstract class CoordinateDatabase extends RoomDatabase {

    private static CoordinateDatabase instance;

    public abstract CoordinateDao noteDao();

    public static synchronized CoordinateDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    CoordinateDatabase.class, "coordinate_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
