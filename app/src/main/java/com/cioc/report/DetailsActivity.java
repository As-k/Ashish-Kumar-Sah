package com.cioc.report;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;


import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class DetailsActivity extends Activity {
    private RecyclerView mRecyclerView;
    private List<String> listOfImagesPath;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    public static ArrayList imagesList;

    Integer REQUEST_CODE_DOC = 101;
    public static final int CAMERA_REQUEST = 102;
    private int REQUEST_CODE_GALLERY = 103;
    ImageButton uploadfile, camera, gallery;
    public static Bitmap bitmapUploadfile, bitmapCamera, bitmapGallery;

    AutoCompleteTextView categories, vendor, amount;
    EditText date;
    int c_yr, c_month, c_day;

    Button save_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mRecyclerView = findViewById(R.id.recycler_view);
        Integer[] images = {R.drawable.bag2, R.drawable.bag3, R.drawable.bag5};
        imagesList = new ArrayList(Arrays.asList(images));

//        if (bitmapCamera != null) {
//            ByteArrayOutputStream bout = new ByteArrayOutputStream();
//            bitmapCamera.compress(Bitmap.CompressFormat.JPEG,100,bout);
//            byte image[] = bout.toByteArray();
//            imagesList.add(image);
//        }


        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Initialize a new instance of RecyclerView Adapter instance
        mAdapter = new CardAdapter(this, imagesList);
        // Set the adapter for RecyclerView
        mRecyclerView.setAdapter(mAdapter);
        // Specify the position
        int position = 0;
        imagesList.add(position);
        mAdapter.notifyItemInserted(position);
        mRecyclerView.scrollToPosition(position);

        findAllId();
        save_details = findViewById(R.id.save_details);

        Calendar c = Calendar.getInstance();
        c_yr = c.get(Calendar.YEAR);
        c_month = c.get(Calendar.MONTH);
        c_day = c.get(Calendar.DAY_OF_MONTH);
        clickOnView();
}

    private void findAllId() {
        // import image from gallery
        // take a picture
        // upload a PDF
        uploadfile = findViewById(R.id.uploadfile);
        camera = findViewById(R.id.camera);
        gallery = findViewById(R.id.gallery);

        categories = findViewById(R.id.categories);
        vendor = findViewById(R.id.vendor);
        amount = findViewById(R.id.amount);
        date = findViewById(R.id.date);
    }

    private void clickOnView(){
        uploadfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Intent.ACTION_GET_CONTENT);
                intent2.setType("*/*");
                startActivityForResult(intent2,REQUEST_CODE_DOC);
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,CAMERA_REQUEST);
            }
        });

        gallery.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick (View view){
                Intent i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(i, "Select Picture"), REQUEST_CODE_GALLERY);
//                if (Build.VERSION.SDK_INT <19){

//                    Intent intent = new Intent();
//                    intent.setType("image/jpeg");
//                    intent.setAction(Intent.ACTION_GET_CONTENT);
//                    startActivityForResult(Intent.createChooser(intent,
//                            getResources().getString(android.R.string.ok)),REQUEST_CODE_GALLERY);

//                }else{
//
//                    Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
//                    intent.addCategory(Intent.CATEGORY_OPENABLE);
//                    intent.setType("image/jpeg");
//                    startActivityForResult(intent, GALLERY_KITKAT_INTENT_CALLED);
//                }
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dpd = new DatePickerDialog(DetailsActivity.this, android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                },c_yr,c_month,c_day);
                DatePicker dp = dpd.getDatePicker();
//                dp.setMinDate(System.currentTimeMillis()-10*24*60*60*1000);
//                dp.setMaxDate(System.currentTimeMillis());
                dpd.show();
            }
        });
    }

    public void saveDetails(View v){
        String category = categories.getText().toString().trim();
        String vendor_name = vendor.getText().toString().trim();
        String c_date = date.getText().toString().trim();
        String amount_price = amount.getText().toString().trim();
        if (category.isEmpty()){
            categories.setError("Error");
            categories.requestFocus();
        } else {
            if (vendor_name.isEmpty()){
                vendor.setError("Error");
                vendor.requestFocus();
            } else {
                if (c_date.isEmpty()){
                    date.setError("Error");
                    date.requestFocus();
                } else {
                    if (amount_price.isEmpty()){
                        amount.setError("Error");
                        amount.requestFocus();
                    } else {
                        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(DetailsActivity.this, NewEditorActivity.class);
                        i.putExtra("categories",category);
                        i.putExtra("vendor",vendor_name);
                        i.putExtra("date",c_date);
                        i.putExtra("amount",amount_price);
                        startActivity(i);
                        finish();
                    }
                }
            }
        }
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_DOC) {
            if(resultCode == RESULT_OK){
                String PathHolder = data.getData().getPath();
                Toast.makeText(this, PathHolder , Toast.LENGTH_LONG).show();
            }
        }

        if (requestCode == CAMERA_REQUEST) {
            if (resultCode == RESULT_OK) {
                bitmapCamera = (Bitmap) data.getExtras().get("data");
                Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show();
//            imageView.setImageBitmap(bitmap);
            }
        }

        if (requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();
            try{
                bitmapGallery = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}




