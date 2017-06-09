package com.qishui.zhou.rv2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.qishui.zhou.rv2.dialog.DepthPageTransformer;
import com.qishui.zhou.rv2.dialog.MyItHeiMaDialog;

public class ThriedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thired);

        final String url1 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1497030226348&di=6ec62de4ff25d9d015b701fe4deb09f2&imgtype=0&src=http%3A%2F%2Fimage.tianjimedia.com%2FuploadImages%2F2015%2F204%2F22%2FYMG9CAUWUM15.jpg";
        final String url2 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1497030227637&di=f5abdcaa2264dffe29ff9127c1a760ad&imgtype=0&src=http%3A%2F%2Fuserimage7.360doc.com%2F16%2F0123%2F23%2F6622010_201601232355360953727142.jpg";

        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyItHeiMaDialog.getInstance()
                        .setImages(url1, R.mipmap.image2, R.mipmap.image1, url2)
                        .setRoundSize(20)
                        .setPageTransformer(new DepthPageTransformer())
                        .show(getSupportFragmentManager());
            }
        });

    }
}
