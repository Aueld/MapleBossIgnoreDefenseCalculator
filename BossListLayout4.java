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

    boolean check;
    int level;
    float levelDamage[] = {1.2f, 1.18f, 1.16f, 1.14f, 1.12f, 1.10f, 1.0584f, 1.007f, 0.9672f, 0.918f, 0.88f, 0.85f, 0.83f, 0.80f, 0.78f, 0.75f, 0.73f, 0.70f, 0.68f, 0.65f, 0.63f, 0.60f, 0.58f, 0.55f, 0.50f, 0.48f, 0.45f, 0.43f, 0.40f, 0.38f, 0.35f, 0.33f, 0.30f, 0.28f, 0.25f, 0.23f, 0.20f, 0.18f, 0.15f, 0.13f, 0.10f, 0.8f, 0.5f, 0.3f, 0};

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.boss_list_layout4);

        Intent refIntent = this.getIntent();
        float seter = refIntent.getFloatExtra("seter", -1);
        check = refIntent.getBooleanExtra("levelCheck", false);
        level = -1;
        if(check){
            level = refIntent.getIntExtra("level", -1);
        }

        TextView result3 = (TextView)  findViewById(R.id.setString);
        if(seter != -1){
            result3.setText(String.format("%.2f", seter));
        }

        ListView listview ;
        ListViewAdapter4 adapter;

        adapter = new ListViewAdapter4() ;

        listview = (ListView) findViewById(R.id.list);
        listview.setAdapter(adapter);

        float Dfs = 0.0f, Ign;
        String text_dpen, text_perdmg;
        text_dpen = "방어율 : ";
        text_perdmg = "% 피해를 입힘";

        // 00_1 허수아비
        Dfs = 50;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.husu),
                "\n 볏짚\n 허수아비\n ", " LV.100 ~ 275\n HP : 21,000,000,000,000 (21조)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(Ign, 1)), "반감 없음", "소환시간: 15분");
        // 00_2 반감 허수아비
        Dfs = 300;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.husub),
                "\n 참나무\n 허수아비\n ", " LV.100 ~ 275\n HP : 21,000,000,000,000 (21조)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(Ign, 1)), "전 속성 반감", "소환시간: 15분");
        // 불꽃 늑대
        Dfs = 90;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.qn),
                "\n 불꽃늑대\n ", " LV.1\n HP : 600,000,000,000 (6000억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 1), 1)), "전 속성 반감", "");
        // 우르스
        Dfs = 10;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.urs),
                "\n 우르스\n ", " LV.139\n HP : 2,625,223,624,000\n(약 2조6000억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 139), 1)), "반감 없음", "");

        //아르카누스 1단계
        Dfs = 50;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.arkanus),
                "\n 아르카누스\n 1단계", " LV.101 /누적: 60억\n HP : 6,000,000,000\n(60억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 101), 1)), "전 속성 반감", "");

        //아르카누스 2단계
        Dfs = 100;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.arkanus),
                "\n 아르카누스\n 2단계", " LV.101 /누적: 210억\n HP : 150,000,000,000\n(150억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 101), 1)), "전 속성 반감", "");

        //아르카누스 3단계
        Dfs = 150;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.arkanus),
                "\n 아르카누스\n 3단계", " LV.101 /누적: 1710억\n HP : 1,500,000,000,000\n(1500억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 101), 1)), "전 속성 반감", "");

        //아르카누스 4단계
        Dfs = 200;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.arkanus),
                "\n 아르카누스\n 4단계", " LV.101 /누적: 1조6710억\n HP : 15,000,000,000,000\n(1조5000억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 101), 1)), "전 속성 반감", "");

        //아르카누스 5단계
        Dfs = 250;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.arkanus),
                "\n 아르카누스\n 5단계", " LV.101 /누적: 12조1710억\n HP : 105,000,000,000,000\n(10조5000억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 101), 1)), "전 속성 반감", "");

        //아르카누스 6단계
        Dfs = 300;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.arkanus),
                "\n 아르카누스\n 6단계", " LV.101 /누적: 912조1710억\n HP : 9,000,000,000,000,000\n(900조)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 101), 1)), "전 속성 반감", "");



        // 검은 기사 모카딘
        Dfs = 20;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.moca),
                "\n 검은기사\n 모카딘\n ", " LV.140 ~ 275\n HP : 필드몹 레벨 비례 체력 * 750", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(Ign, 1)), "반감 없음", "공무");
        // 미친마법사 카리아인
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.cria),
                "\n 미친마법사\n 카리아인\n ", " LV.140 ~ 275\n HP : 필드몹 레벨 비례 체력 * 750", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(Ign, 1)), "반감 없음", "마무");
        // 인간사냥꾼 줄라이
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.jur),
                "\n 인간사냥꾼\n 줄라이\n ", " LV.140 ~ 275\n HP : 필드몹 레벨 비례 체력 * 750", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(Ign, 1)), "반감 없음", "허약");
        //  돌격형 CQ57
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.cq57),
                "\n 돌격형\n CQ57\n ", " LV.140 ~ 275\n HP : 필드몹 레벨 비례 체력 * 750", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(Ign, 1)), "반감 없음", "넉백");
        // 싸움꾼 플레드
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.pled),
                "\n 싸움꾼\n 플레드\n ", " LV.140 ~ 275\n HP : 필드몹 레벨 비례 체력 * 750", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(Ign, 1)), "반감 없음", "하드스킨");
        // 거대 거미
        Dfs = 50;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.thes),
                "\n 거대거미\n ", " LV.129\n HP : 400,000,000 (4억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 129), 1)), "반감 없음", "웹 페네트레이터");
        // 양철 나무꾼
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.thed),
                "\n 양철\n 나무꾼\n ", " LV.150\n HP : 1,000,000,000 (10억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 150), 1)), "반감 없음", "아이언 멜터");
        // 겁에 질린 사자
        Dfs = 80;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.thet),
                "\n 겁에 질린\n 사자\n ", " LV.170\n HP : 6,300,000,000 (63억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 170), 1)), "반감 없음", "라이언 체이서");
        // 허수아비
        Dfs = 800;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.theg),
                "\n 허수아비\n ", " LV.190\n HP : 1,500,000,000 (15억)(특수)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 190), 1)), "반감 없음", "헤이 버너");
        // 도로시
        Dfs = 250;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.dor),
                "\n 도로시\n ", " LV.210\n HP : 840,000,000,000 (8400억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 210), 1)), "반감 없음", "도로시 챌린저");
        // me
            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.mef),
                    "\n 청은명월\n ", " LV.258\n", "감사합니다.",
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

    private double levelDamageCal(double re, int lev) {
        double result;
        int resultLevel, index = 0;

        if (check) {
            resultLevel = level - lev;

            if(resultLevel <= -40)
                index = 44;
            else if(resultLevel >= 5)
                index = 0;
            else
                index = (resultLevel * -1) + 5;

            result = re * (levelDamage[index]);

        } else {
            result = re;
        }
        return result;
    }

    static double calc(double d, int n) {
        return Math.round(d * Math.pow(10, n)) / Math.pow(10, n);
    }

    static String doubleToString(double a) {
        return String.valueOf(a);
    }

}
