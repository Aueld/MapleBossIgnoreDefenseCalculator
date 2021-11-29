package com.epeld.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint("Registered")
public class BossListLayout4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.boss_list_layout4);

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

        // 00_1 허수아비
        qkd = 50;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.husu),
                "\n 볏짚\n 허수아비\n ", " LV.100 ~ 275\n HP : 21,000,000,000,000 (21조)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "반감 없음", "소환시간: 15분");
        // 00_2 반감 허수아비
        qkd = 300;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.husub),
                "\n 참나무\n 허수아비\n ", " LV.100 ~ 275\n HP : 21,000,000,000,000 (21조)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감", "소환시간: 15분");
        // 불꽃 늑대
        qkd = 90;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.qn),
                "\n 불꽃늑대\n ", " LV.1\n HP : 600,000,000,000 (6000억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감", "");
        // 우르스
        qkd = 10;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.urs),
                "\n 우르스\n ", " LV.139\n HP : 2,625,223,624,000\n(약 2조6000억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "반감 없음", "");

        //아르카누스 1단계
        qkd = 50;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.arkanus),
                "\n 아르카누스\n 1단계", " LV.101 /누적: 60억\n HP : 6,000,000,000\n(60억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감", "");

        //아르카누스 2단계
        qkd = 100;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.arkanus),
                "\n 아르카누스\n 2단계", " LV.101 /누적: 210억\n HP : 150,000,000,000\n(150억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감", "");

        //아르카누스 3단계
        qkd = 150;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.arkanus),
                "\n 아르카누스\n 3단계", " LV.101 /누적: 1710억\n HP : 1,500,000,000,000\n(1500억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감", "");

        //아르카누스 4단계
        qkd = 200;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.arkanus),
                "\n 아르카누스\n 4단계", " LV.101 /누적: 1조6710억\n HP : 15,000,000,000,000\n(1조5000억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감", "");

        //아르카누스 5단계
        qkd = 250;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.arkanus),
                "\n 아르카누스\n 5단계", " LV.101 /누적: 12조1710억\n HP : 105,000,000,000,000\n(10조5000억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감", "");

        //아르카누스 6단계
        qkd = 300;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.arkanus),
                "\n 아르카누스\n 6단계", " LV.101 /누적: 912조1710억\n HP : 9,000,000,000,000,000\n(900조)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감", "");



        // 검은 기사 모카딘
        qkd = 20;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.moca),
                "\n 검은기사\n 모카딘\n ", " LV.140 ~ 275\n HP : 필드몹 레벨 비례 체력 * 750", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "반감 없음", "공무");
        // 미친마법사 카리아인
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.cria),
                "\n 미친마법사\n 카리아인\n ", " LV.140 ~ 275\n HP : 필드몹 레벨 비례 체력 * 750", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "반감 없음", "마무");
        // 인간사냥꾼 줄라이
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.jur),
                "\n 인간사냥꾼\n 줄라이\n ", " LV.140 ~ 275\n HP : 필드몹 레벨 비례 체력 * 750", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "반감 없음", "허약");
        //  돌격형 CQ57
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.cq57),
                "\n 돌격형\n CQ57\n ", " LV.140 ~ 275\n HP : 필드몹 레벨 비례 체력 * 750", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "반감 없음", "넉백");
        // 싸움꾼 플레드
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.pled),
                "\n 싸움꾼\n 플레드\n ", " LV.140 ~ 275\n HP : 필드몹 레벨 비례 체력 * 750", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "반감 없음", "하드스킨");
        // 거대 거미
        qkd = 50;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.thes),
                "\n 거대거미\n ", " LV.129\n HP : 400,000,000 (4억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "반감 없음", "웹 페네트레이터");
        // 양철 나무꾼
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.thed),
                "\n 양철\n 나무꾼\n ", " LV.150\n HP : 1,000,000,000 (10억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "반감 없음", "아이언 멜터");
        // 겁에 질린 사자
        qkd = 80;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.thet),
                "\n 겁에 질린\n 사자\n ", " LV.170\n HP : 6,300,000,000 (63억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "반감 없음", "라이언 체이서");
        // 허수아비
        qkd = 800;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.theg),
                "\n 허수아비\n ", " LV.190\n HP : 1,500,000,000 (15억)(특수)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "반감 없음", "헤이 버너");
        // 도로시
        qkd = 250;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.dor),
                "\n 도로시\n ", " LV.210\n HP : 840,000,000,000 (8400억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "반감 없음", "도로시 챌린저");
        // me
            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.mev),
                    "\n 청은명월\n ", " LV.255\n", "감사합니다.",
                    "", "", "", "제로", "베라");

    }
    public void onBackPressed() {
        //        //Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show();
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
