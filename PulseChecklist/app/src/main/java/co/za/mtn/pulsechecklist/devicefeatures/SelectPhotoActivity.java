package co.za.mtn.pulsechecklist.devicefeatures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import co.za.mtn.pulsechecklist.R;


public class SelectPhotoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private String[] scaleType = new String[] {
            ImageView.ScaleType.CENTER_CROP.name(),
            ImageView.ScaleType.CENTER_INSIDE.name(),
            ImageView.ScaleType.FIT_CENTER.name(),
            ImageView.ScaleType.FIT_END.name(),
            ImageView.ScaleType.FIT_XY.name(),
            ImageView.ScaleType.MATRIX.name(),
            ImageView.ScaleType.CENTER.name()
    };

    private ImageView imageView;
    private Bitmap selectedImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_photo);

        imageView = findViewById(R.id.imageView);
        Spinner dropdown = findViewById(R.id.scaleType);
        Button button = findViewById(R.id.capture);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, scaleType);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectPicture();
            }
        });
    }

    private void selectPicture() {
        Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickPhoto , 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED) {
            if (requestCode == 0) {
                Uri selectedImage =  data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                if (selectedImage != null) {
                    Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                    if (cursor != null) {
                        cursor.moveToFirst();

                        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                        String picturePath = cursor.getString(columnIndex);
                        imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                        cursor.close();
                    }
                }
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(selectedImage == null) {
            return;
        }

        imageView.setScaleType(ImageView.ScaleType.valueOf(scaleType[i]));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}