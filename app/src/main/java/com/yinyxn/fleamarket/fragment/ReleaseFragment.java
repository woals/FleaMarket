package com.yinyxn.fleamarket.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.yinyxn.fleamarket.App;
import com.yinyxn.fleamarket.R;
import com.yinyxn.fleamarket.domain.Product;
import com.yinyxn.fleamarket.service.ProductService;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReleaseFragment extends Fragment {

    Spinner spinner;
    private String[] data;
    Button button;
    EditText editTextProductName;
    EditText editTextProductorName;
    EditText editTextProductorPhone;
    EditText editTextProductorDescribe;
    EditText editTextprice;
//    ImageView imageView1;
//    ImageView imageView2;
//    ImageView imageView3;

    public ReleaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_release, container, false);

        initView(view);

        return view;
    }

    private void initView(View view) {
        data = getResources().getStringArray(R.array.item);
        spinner = (Spinner) view.findViewById(R.id.spinner);
        button = (Button) view.findViewById(R.id.button_releaseProduct);
        editTextProductName = (EditText) view.findViewById(R.id.editText_productName);
        editTextProductorName = (EditText) view.findViewById(R.id.editText_productorName1);
        editTextProductorPhone = (EditText) view.findViewById(R.id.editText_productorPhone);
        editTextProductorDescribe = (EditText) view.findViewById(R.id.editText_productorDescribe1);
        editTextprice = (EditText) view.findViewById(R.id.editText_price);
//        imageView1 = (ImageView) view.findViewById(R.id.imageView);
//        imageView2 = (ImageView) view.findViewById(R.id.imageView1);
//        imageView3 = (ImageView) view.findViewById(R.id.imageView2);

        spinner.setOnItemSelectedListener(new SpinnerListener());
        button.setOnClickListener(new ButtonListener());
    }

    private class SpinnerListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            data = getResources().getStringArray(R.array.item);
            String info = data[position];
            Log.d("TAG", info);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String productName = editTextProductName.getText().toString();
            String productClassify = spinner.getSelectedItem().toString();
            String productorName = editTextProductorName.getText().toString();
            String productorPhone = editTextProductorPhone.getText().toString();
            String productorDescribe = editTextProductorDescribe.getText().toString();
            String productprice = editTextprice.getText().toString();

            Log.d("TAG", productName + "_" + productClassify + "_" + productorName + "_" + productorPhone + "_" + productorDescribe + "_" + productprice);
            ProductService productService = new ProductService(getContext());
            Product product = new Product();
            product.setProductName(productName);
            product.setProductClassify(productClassify);
            product.setProductorName(productorName);
            product.setProductorPhone(productorPhone);
            product.setProductorDescribe(productorDescribe);
            product.setProductprice(productprice);
            if(productName.isEmpty()){
                Toast.makeText(getContext(), "产品名不能为空", Toast.LENGTH_SHORT).show();
            }else if (productorPhone.isEmpty()){
                Toast.makeText(getContext(), "手机号不能为空", Toast.LENGTH_SHORT).show();
            }else if (App.flag) {
                String productorkey = App.KEY;
                product.setProductkey(productorkey);
                boolean flag = productService.release(product);
                if (flag) {
                    Toast.makeText(getContext(), "发布成功", Toast.LENGTH_SHORT).show();
                    editTextProductName.setText("");
                    editTextProductorName.setText("");
                    editTextProductorPhone.setText("");
                    editTextProductorDescribe.setText("");
                    editTextprice.setText("");
                }
            } else {
                boolean flag = productService.release(product);
                if (flag) {
                    Toast.makeText(getContext(), "发布成功", Toast.LENGTH_SHORT).show();
                    editTextProductName.setText("");
                    editTextProductorName.setText("");
                    editTextProductorPhone.setText("");
                    editTextProductorDescribe.setText("");
                    editTextprice.setText("");
                }
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("TAG", "onStart");
        if (App.modify) {
            initView(getView());
        }
    }
}
