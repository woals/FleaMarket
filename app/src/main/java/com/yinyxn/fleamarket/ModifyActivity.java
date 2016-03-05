package com.yinyxn.fleamarket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.yinyxn.fleamarket.domain.Product;
import com.yinyxn.fleamarket.service.ProductService;

public class ModifyActivity extends AppCompatActivity {

    Button button;
    Spinner spinner;
    private String[] data;
    EditText editTextProductName;
    EditText editTextProductorName;
    EditText editTextProductorPhone;
    EditText editTextProductorDescribe;
    EditText editTextprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);

        data = getResources().getStringArray(R.array.item);
        spinner = (Spinner) findViewById(R.id.spinner1);
        editTextProductName = (EditText) findViewById(R.id.editText_productName1);
        editTextProductorName = (EditText) findViewById(R.id.editText_productorName1);
        editTextProductorPhone = (EditText) findViewById(R.id.editText_productorPhone1);
        editTextProductorDescribe = (EditText) findViewById(R.id.editText_productorDescribe1);
        editTextprice = (EditText) findViewById(R.id.editText_price1);
        editTextProductName.setText(getIntent().getStringExtra(App.EXTRA_MYRELEASEFragment1));
        spinner.setTag(getIntent().getStringExtra(App.EXTRA_MYRELEASEFragment2));
        spinner.setTag(App.EXTRA_MYRELEASEFragment2);
        editTextProductorName.setText(getIntent().getStringExtra(App.EXTRA_MYRELEASEFragment3));
        editTextProductorPhone.setText(getIntent().getStringExtra(App.EXTRA_MYRELEASEFragment4));
        editTextProductorDescribe.setText(getIntent().getStringExtra(App.EXTRA_MYRELEASEFragment5));
        editTextprice.setText(getIntent().getStringExtra(App.EXTRA_MYRELEASEFragment6));

        button = (Button) findViewById(R.id.button8_modify);
        button.setOnClickListener(new ButtonListener());

    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    data = getResources().getStringArray(R.array.item);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            String productName = editTextProductName.getText().toString();
            String productClassify = spinner.getSelectedItem().toString();
            String productorName = editTextProductorName.getText().toString();
            String productorPhone = editTextProductorPhone.getText().toString();
            String productorDescribe = editTextProductorDescribe.getText().toString();
            String productprice = editTextprice.getText().toString();

            Log.d("TAG", productName + "_" + productClassify + "_" + productorName + "_" + productorPhone + "_" + productorDescribe + "_" + productprice);
            ProductService productService = new ProductService(ModifyActivity.this);
            Product product = new Product();
            product.setProductName(productName);
            product.setProductClassify(productClassify);
            product.setProductorName(productorName);
            product.setProductorPhone(productorPhone);
            product.setProductorDescribe(productorDescribe);
            product.setProductprice(productprice);

            long id = getIntent().getLongExtra(String.valueOf(App.EXTRA_MYRELEASEFragment7),0);
            product.setId(id);
            boolean flag = productService.modify(product, id);
            if (flag) {
                Toast.makeText(ModifyActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                editTextProductName.setText("");
                editTextProductorName.setText("");
                editTextProductorPhone.setText("");
                editTextProductorDescribe.setText("");
                editTextprice.setText("");
                App.modify = true;
            }
        }
    }
}

