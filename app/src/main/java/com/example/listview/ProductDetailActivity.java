package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProductDetailActivity extends AppCompatActivity {

    EditText etID, etName, etQuantity, etPrice, etMaker;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_product_detail);

        etID = findViewById(R.id.txtID);
        etName = findViewById(R.id.txtName);
        etQuantity = findViewById(R.id.txtQuantity);
        etPrice = findViewById(R.id.txtPrice);
        etMaker = findViewById(R.id.txtMaker);
        btnBack = findViewById(R.id.btnBack);

        Product product = getIntent().getParcelableExtra("product");

        etID.setText(Integer.toString(product.id));
        etName.setText(product.name);
        etQuantity.setText(Integer.toString(product.quatity));
        etPrice.setText(Integer.toString(product.price));
        etMaker.setText(product.maker);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                setResult(RESULT_OK, intent);

                finish();
            }
        });
    }
}