package com.example.ck_thuhien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.VpnManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.Timer;
import java.util.TimerTask;



public class MainActivity extends AppCompatActivity {

    GridView GV_01,GV_02;
    private ViewPager VP_IMAGE;


    String names[] = {"Nạp Tiền", "Rút Tiền", "Chuyển Tiền", "Yêu cầu chuyển tiền",
            "Mua vé xem phim", "Du lịch - đi lại", "Mua hộ vé số", "Now - Ship", "Đặt đồ ăn online",
            "Mã Thanh Toán", "Quét mã", "Nạp tiền điện thoại", "Thanh toán hóa đơn"
    };
    int images[] = {R.drawable.naptien, R.drawable.ruttien, R.drawable.chuyentien, R.drawable.ycct,
            R.drawable.xemphim, R.drawable.dl, R.drawable.ve, R.drawable.icon_delivery,
            R.drawable.mathanhtoan, R.drawable.quetma, R.drawable.ntdt, R.drawable.tthd,
    };
    String[] names1 = {"Hoàn tiền 100% với giao dịch đầu tiền từ momo", "Tặng ngay 20% vào ngày 11.11.2020", "Hoàn tiền 50% duy nhất ngày 1.11.2020", "Tặng ngay 20% ngày 08.03.2020", "800 giải thưởng duy nhất ngày 1.11", "Săn đủ 12 con giáp nhập hội tỷ phú momo"};
    int[] images1 = {R.drawable.m1, R.drawable.m2, R.drawable.m3, R.drawable.m4, R.drawable.m5, R.drawable.m6};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView() {

        GV_01 = findViewById(R.id.GV_01);
        VP_IMAGE = findViewById(R.id.VP_IMAGE);
        GV_02= findViewById(R.id.GV_02);


    }

    private void initListener() {
        VP_Adapter_Now_Slides viewPagerAdapter = new VP_Adapter_Now_Slides(this);
        VP_IMAGE.setAdapter(viewPagerAdapter);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 1000, 2000);

        List_Menu_Adapter List_Menu_Adapter = new List_Menu_Adapter(names, images, this);
        GV_01.setAdapter(List_Menu_Adapter);

        List_Collection_Adapter List_Collection_Adapter = new List_Collection_Adapter(names1, images1, this);
        GV_02.setAdapter(List_Collection_Adapter);

        GV_02.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedName = names1[position];
                int selectImage = images1[position];
                startActivity(new Intent(MainActivity.this, click_item_collection.class).putExtra("name1", selectedName).putExtra("image1", selectImage));
            }

        });


    }

    public class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (VP_IMAGE.getCurrentItem() == 0) {
                        VP_IMAGE.setCurrentItem(1);
                    } else if (VP_IMAGE.getCurrentItem() == 1) {
                        VP_IMAGE.setCurrentItem(2);
                    } else if (VP_IMAGE.getCurrentItem() == 2) {
                        VP_IMAGE.setCurrentItem(3);
                    } else if (VP_IMAGE.getCurrentItem() == 3) {
                        VP_IMAGE.setCurrentItem(4);
                    } else if (VP_IMAGE.getCurrentItem() == 4) {
                        VP_IMAGE.setCurrentItem(5);
                    } else if (VP_IMAGE.getCurrentItem() == 5) {
                        VP_IMAGE.setCurrentItem(6);
                    } else {
                        VP_IMAGE.setCurrentItem(0);
                    }
                }
            });
        }
    }

}