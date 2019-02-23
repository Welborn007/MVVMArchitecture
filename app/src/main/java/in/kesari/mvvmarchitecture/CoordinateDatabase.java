package in.kesari.mvvmarchitecture;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

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
