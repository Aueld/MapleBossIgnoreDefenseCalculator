package com.epeld.myapplication;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

public class BossListLayout2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.boss_list_layout2);

        Intent refIntent = this.getIntent();
        float seter = refIntent.getFloatExtra("seter", -1);
        TextView result3 = (TextView)  findViewById(R.id.setString);
        if(seter != -1){
            result3.setText(String.format("%.2f", seter));
        }

        ListView listview ;
        ListViewAdapter adapter;

        adapter = new ListViewAdapter() ;

        listview = (ListView) findViewById(R.id.list);
        listview.setAdapter(adapter);

        float qkd = 0.0f, rhks;
        String text_dpen, text_perdmg;
        text_dpen = "방어율 : ";
        text_perdmg = "% 피해를 입힘";

        // 이지 자쿰
        qkd = 30;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.zak),
                "\n 이지 자쿰\n ", " LV.55\n HP : 2,200,000 (220만)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "반감 없음", "결정석 : 134,455");
        // 노말 자쿰
        qkd = 40;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.zak),
                "\n 노말 자쿰\n ", " LV.110\n HP : 7,000,000 (700만)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감", "결정석 : 411,765");
        // 이지 파풀라투스
        qkd = 50;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.pap),
                "\n 이지\n 파풀라투스\n ", " LV.125\n HP : 400,000,000\n (4억 / 본체 포함)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감", "결정석 : 460,166");
        // 이지 매그너스
        qkd = 50;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.mag),
                "\n 이지\n 매그너스\n ", " LV.110\n HP : 400,000,000 (4억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감", "결정석 : 485,376");
        // 노말 힐라
        qkd = 50;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hil),
                "\n 노말 힐라\n ", " LV.110\n HP : 500,000,000 (5억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감", "결정석 : 537,816");
        // 이지 혼테일
        qkd = 40;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hon),
                "\n 이지 \n 혼테일\n ", " LV.130\n HP : 817,600,000\n (8억1760만 / 모든 부위 포함)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "반감 없음", "결정석 : 592,942");
        // 반반
        qkd = 50;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.banb),
                "\n 반반\n ", " LV.120\n HP : 315,000,000 (3억1500만)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감", "결정석 : 650,756");
        // 피에르
        qkd = 50;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.pie),
                "\n 피에르\n ", " LV.120\n HP : 315,000,000 (3억1500만)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)),"전 속성 반감(특수)", "결정석 : 650,756");
        // 블러디 퀸
        qkd = 50;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.blo),
                "\n 블러디 퀸\n ", " LV.120\n HP : 315,000,000 (3억1500만)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)),"전 속성 반감", "결정석 : 650,756");
        // 벨룸
        qkd = 55;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.bel),
                "\n 벨룸\n ", " LV.130\n HP : 550,000,000 (5억5000만)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감", "결정석 : 650,756");
        // 노말 혼테일
        qkd = 40;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hon),
                "\n 노말 \n 혼테일\n ", " LV.160\n HP : 2,090,000,000\n (20억9000만 / 모든 부위 포함)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "반감 없음", "결정석 : 680,671");
        // 이지 반레온
        qkd = 50;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.leo),
                "\n 이지\n 반레온\n ", " LV.120\n HP : 700,000,000 (7억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "반감 없음", "결정석 : 711,259");
        // 이지 아카이럼
        qkd = 60;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.aca),
                "\n 이지\n 아카이럼\n ", " LV.130\n HP : 2,100,000,000 (21억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "반감 없음", "결정석 : 774,452");
        // 카웅
        qkd = 60;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.car),
                "\n 카웅\n ", " LV.180\n HP : 1,680,000,000 (16억8000만)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감", "결정석 : 840,335");
        // 카오스 혼테일
        qkd = 50;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hon),
                "\n 카오스 \n 혼테일\n ", " LV.180\n HP : 20,000,000,000\n (200억 / 모든 부위 포함)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "반감 없음", "결정석 : 908,906");
        // 노말 핑크빈
        qkd = 70;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.pik),
                "\n 노말\n 핑크빈\n ", " LV.180\n HP : 7,650,000,000\n ( 76억5000만 / 모든 석상 포함)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "번개 제외 반감", "결정석 : 944,200");
        // 노말 반레온
        qkd = 80;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.leo),
                "\n 노말\n 반레온\n ", " LV.130\n HP : 6,300,000,000 (63억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "반감 없음", "결정석 : 980,168");
        // 하드 반레온
        qkd = 100;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.leo),
                "\n 하드\n 반레온\n ", " LV.140\n HP : 10,500,000,000 (105억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "반감 없음", "결정석 : 1,647,058");
        // 노말 아카이럼
        qkd = 90;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.aca),
                "\n 노말\n 아카이럼\n ", " LV.170\n HP : 12,600,000,000 (126억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "반감 없음", "결정석 : 1,694,454");
        // 노말 매그너스
        qkd = 50;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.mag),
                "\n 노말\n 매그너스\n ", " LV.130\n HP : 6,000,000,000 (60억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감", "결정석 : 1,742,519");
        // 노말 파풀라투스
        qkd = 90;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.pap),
                "\n 노말\n 파풀라투스\n ", " LV.155\n HP : 16,600,000,000\n (166억 / 본체 포함)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감", "결정석 : 1,791,259");
    }
    public void onBackPressed() {
        //Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show();
        finish();
        super.onBackPressed();
    }

    private float defenseCalculator(float defense, float seter){
        float ignore = 0.0f;
        ignore = 100 - (defense - (defense * seter / 100));
        if(ignore < 0) {
            ignore = 0f;
        }
        return ignore;
    }

    static double round(double d, int n) {
        return Math.round(d * Math.pow(10, n)) / Math.pow(10, n);
    }
    static String qus(double a) {
        return String.valueOf(a);
    }

}
