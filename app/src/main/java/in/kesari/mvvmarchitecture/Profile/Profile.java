package in.kesari.mvvmarchitecture.Profile;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

@Entity(tableName = "profile_table")
public class Profile {

	@PrimaryKey(autoGenerate = true)
	private int id;

	private String detail;
	private String status;

	public Profile(String detail, String status) {
		this.detail = detail;
		this.status = status;
		storedStringToMyObjects(detail);
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getDetail() {
		return detail;
	}

	public String getStatus() {
		return status;
	}

	@TypeConverter
	public static List<Detail> storedStringToMyObjects(String data) {
		Gson gson = new Gson();
		if (data == null) {
			return Collections.emptyList();
		}
		Type listType = new TypeToken<List<Detail>>() {}.getType();
		return gson.fromJson(data, listType);
	}

	@TypeConverter
	public static String myObjectsToStoredString(List<Detail> myObjects) {
		Gson gson = new Gson();
		return gson.toJson(myObjects);
	}
}
