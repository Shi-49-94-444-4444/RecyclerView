package com.example.listview;

import  androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Product> listProduct;
    ProductAdapter  productAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listProduct = new ArrayList<>();
        listProduct.add(new Product(1, "Iphone 6", 500, 1000000, "Shi"));
        listProduct.add(new Product(2, "Iphone 7", 700, 2000000, "Shi"));
        listProduct.add(new Product(3, "Sony Abc", 800, 3000000, "Shi"));
        listProduct.add(new Product(4, "Samsung XYZ", 900, 8000000, "Shi"));
        listProduct.add(new Product(5, "SP 5", 500, 4000000, "Shi"));
        listProduct.add(new Product(6, "SP 6", 700, 5000000, "Shi"));
        listProduct.add(new Product(7, "SP 7", 800, 6000000, "Shi"));
        listProduct.add(new Product(8, "SP 8", 900, 7000000, "Shi"));

        productAdapter  = new ProductAdapter(listProduct);

        recyclerView = findViewById(R.id.listproduct);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(productAdapter);

    }

    class Product {
        int id;
        String name;
        int quatity;
        int price;
        String maker;

        public Product(int id, String name, int quatity, int price, String maker) {
            this.id = id;
            this.name = name;
            this.quatity = quatity;
            this.price = price;
            this.maker = maker;
        }
    }

    class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

        final ArrayList<Product> listProduct;

        public ProductAdapter(ArrayList<Product> listProduct) {
            this.listProduct = listProduct;
        }

        @Override
        public ProductViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
            View viewProduct = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_view, parent, false);
            return new ProductViewHolder(viewProduct);
        }

        @Override
        public void onBindViewHolder(ProductViewHolder holder, int position) {
            Product product = listProduct.get(position);
            holder.textViewId.setText(String.format("ID = %d", product.id));
            holder.textViewName.setText(String.format("Tên SP : %s", product.name));
            holder.textViewQuatity.setText(String.format("Số lượng = %d", product.quatity));
            holder.textViewPrice.setText(String.format("Giá %d", product.price));
            holder.textViewMaker.setText(String.format("Maker : %s", product.maker));
        }

        @Override
        public int getItemCount() {
            return listProduct.size();
        }

        class ProductViewHolder extends RecyclerView.ViewHolder {
            TextView textViewId, textViewName, textViewQuatity, textViewPrice, textViewMaker;

            ProductViewHolder(View itemView) {
                super(itemView);
                textViewId = itemView.findViewById(R.id.idproduct);
                textViewName = itemView.findViewById(R.id.nameproduct);
                textViewQuatity = itemView.findViewById(R.id.quatityproduct);
                textViewPrice = itemView.findViewById(R.id.priceproduct);
                textViewMaker = itemView.findViewById(R.id.makerproduct);
            }
        }
    }
}