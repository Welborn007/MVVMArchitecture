package in.kesari.mvvmarchitecture;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "coordinate_table")
public class Coordinates {

    @PrimaryKey(autoGenerate = true)
    private int id;

    double oldLatitude,oldLongitude,newLatitude,newLongitude,priority;

    public Coordinates(double oldLatitude, double oldLongitude, double newLatitude, double newLongitude, double priority) {
        this.oldLatitude = oldLatitude;
        this.oldLongitude = oldLongitude;
        this.newLatitude = newLatitude;
        this.newLongitude = newLongitude;
        this.priority = priority;
    }

    public double getPriority() {
        return priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getOldLatitude() {
        return oldLatitude;
    }

    public double getOldLongitude() {
        return oldLongitude;
    }

    public double getNewLatitude() {
        return newLatitude;
    }

    public double getNewLongitude() {
        return newLongitude;
    }
}
