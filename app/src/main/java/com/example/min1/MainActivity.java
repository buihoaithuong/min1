package com.example.min1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    database database;
    EditText edt1, edt2;
    CheckBox cb1, cb2, cb3;
    RadioButton rd1, rd2, rd3;
    Button btnThem, btnXem, btnXoa;
    thongtin user = new thongtin();
    String dichVu="";
    String uuTien="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();
        // tạo database
        database = new database(this, "ThongTinKhachHang.sql", null,1);

        // tạo bảng thông tin khách hàng
        database.Querydata("DROP TABLE `thongtinKH`");
        database.Querydata("CREATE TABLE IF NOT EXISTS thongtinKH(Id INTEGER PRIMARY KEY AUTOINCREMENT , TenKH TEXT, sdt TEXT, UuTien TEXT, DichVu TEXT ) ");

        // insert data
        //database.Querydata("INSERT INTO thongtinKH VALUES(null, "" )");

        Them();
        Xem();

    }

    private void anhXa() {
        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        rd1 = (RadioButton) findViewById(R.id.radioButton1);
        rd2 = (RadioButton) findViewById(R.id.radioButton2);
        rd3 = (RadioButton) findViewById(R.id.radioButton3);
        cb1 = (CheckBox) findViewById(R.id.checkBox2);
        cb2 = (CheckBox) findViewById(R.id.checkBox3);
        cb3 = (CheckBox) findViewById(R.id.checkBox);
        btnThem = (Button) findViewById(R.id.button2);
        btnXem = (Button) findViewById(R.id.button3);
        btnXoa = (Button) findViewById(R.id.button);
    }

    // hàm lấy thông tin
    private void getDataTT(){
        Cursor dataThongtin = database.getData("SELECT *FROM thongtinKH ");
        while (dataThongtin.moveToNext()){
            user.setIdKH(Integer.parseInt(dataThongtin.getString(0)));
            user.setTen(dataThongtin.getString(1));
            user.setSdt(dataThongtin.getString(2));
            user.setUuTien(dataThongtin.getString(3));
            user.setDichVu(dataThongtin.getString(4));
        }
    }

    // thêm thông tin
    private void Them(){
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cb1.isChecked()){
                    dichVu = cb1.getText().toString();
                }
                if (cb2.isChecked()){
                    dichVu = cb2.getText().toString();
                }
                if (cb3.isChecked()){
                    dichVu = cb3.getText().toString();
                }

                if (rd1.isChecked()){
                    uuTien = rd1.getText().toString();
                }
                if (rd2.isChecked()){
                    uuTien = rd2.getText().toString();
                }
                if (rd3.isChecked()){
                    uuTien = rd3.getText().toString();
                }

                if (edt1.getText().toString().equals("")||edt2.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Vui lòng điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                }
                if(!edt1.getText().toString().equals(edt1.getText().toString().toUpperCase())){
                    Toast.makeText(MainActivity.this, "Vui lòng viết hoa họ và tên!", Toast.LENGTH_SHORT).show();
                }
                else {
                    user.setTen(edt1.getText().toString());
                    user.setSdt(edt2.getText().toString());
                    database.Querydata("INSERT INTO thongtinKH VALUES (null, '"+ user.getTen() +"', '"+ user.getSdt() +"', '"+ uuTien +"' , '"+ dichVu +"' )");
                    getDataTT();
                   // Toast.makeText(MainActivity.this, "Thêm thành công vào csdl!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Xem(){
        btnXem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor dataTT = database.getData("SELECT *FROM thongtinKH WHERE Id = '"+ 3 +" '");
                while (dataTT.moveToNext()){
                    user.setTen(dataTT.getString(1));
                    user.setSdt(dataTT.getString(2));
                    user.setUuTien(dataTT.getString(3));
                    user.setDichVu(dataTT.getString(4));
                }

                Toast.makeText(MainActivity.this, "THÔNG TIN KHÁCH HÀNG CÓ ID = 3 : \n Ten: "+user.getTen()+" \n Sdt: "+ user.getSdt() +" \n Ưu tiên: '"+ uuTien +"' \n Dịch vụ: '"+ dichVu +"' \n  ", Toast.LENGTH_SHORT).show();
            }
        });
    }


}