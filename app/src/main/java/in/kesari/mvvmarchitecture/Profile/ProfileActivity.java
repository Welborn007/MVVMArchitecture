package in.kesari.mvvmarchitecture.Profile;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import in.kesari.mvvmarchitecture.R;
import in.kesari.mvvmarchitecture.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {

    ActivityProfileBinding activityProfileBinding;
    private UserProfileViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityProfileBinding = DataBindingUtil.setContentView(this, R.layout.activity_profile);

        viewModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Profile");

        //get viewModel using ViewModelProviders and then tech data
        viewModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);

        //livedata
        viewModel.getProfile(this).observe(this, coupon -> {
            activityProfileBinding.nameUser.setText(viewModel.getProfile(this).getValue().getDetail().getList().get(0).getName());
            activityProfileBinding.phoneNumber.setText(viewModel.getProfile(this).getValue().getDetail().getList().get(0).getPhone());
            activityProfileBinding.Email.setText(viewModel.getProfile(this).getValue().getDetail().getList().get(0).getEmail());
            activityProfileBinding.dni.setText(viewModel.getProfile(this).getValue().getDetail().getList().get(0).getDni());
            activityProfileBinding.career.setText(viewModel.getProfile(this).getValue().getDetail().getList().get(0).getCareer());
            activityProfileBinding.campus.setText(viewModel.getProfile(this).getValue().getDetail().getList().get(0).getCampus());
            activityProfileBinding.city.setText(viewModel.getProfile(this).getValue().getDetail().getList().get(0).getCity());
            activityProfileBinding.address.setText(viewModel.getProfile(this).getValue().getDetail().getList().get(0).getAddress());
            activityProfileBinding.codeBar.setText(viewModel.getProfile(this).getValue().getDetail().getList().get(0).getCodebar());

        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
