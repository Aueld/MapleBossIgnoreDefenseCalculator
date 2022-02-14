package com.epeld.myapplication;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

public class BossListLayout2 extends AppCompatActivity {

    boolean check;
    int level;
    float levelDamage[] = {1.2f, 1.18f, 1.16f, 1.14f, 1.12f, 1.10f, 1.0584f, 1.007f, 0.9672f, 0.918f, 0.88f, 0.85f, 0.83f, 0.80f, 0.78f, 0.75f, 0.73f, 0.70f, 0.68f, 0.65f, 0.63f, 0.60f, 0.58f, 0.55f, 0.50f, 0.48f, 0.45f, 0.43f, 0.40f, 0.38f, 0.35f, 0.33f, 0.30f, 0.28f, 0.25f, 0.23f, 0.20f, 0.18f, 0.15f, 0.13f, 0.10f, 0.8f, 0.5f, 0.3f, 0};

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.boss_list_layout2);

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
        ListViewAdapter2 adapter;

        adapter = new ListViewAdapter2() ;

        listview = (ListView) findViewById(R.id.list);
        listview.setAdapter(adapter);

        float Dfs = 0.0f, Ign;
        String text_dpen, text_perdmg;
        text_dpen = "방어율 : ";
        text_perdmg = "% 피해를 입힘";

        // 이지 자쿰
        Dfs = 30;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.zak),
                "\n 이지 자쿰\n ", " LV.55\n HP : 2,200,000 (220만)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 55), 1)), "반감 없음", "결정석 : 123,560");
        // 노말 자쿰
        Dfs = 40;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.zak),
                "\n 노말 자쿰\n ", " LV.110\n HP : 7,000,000 (700만)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 110), 1)), "전 속성 반감", "결정석 : 378,401");
        // 이지 파풀라투스
        Dfs = 50;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.pap),
                "\n 이지\n 파풀라투스\n ", " LV.125\n HP : 400,000,000\n (4억 / 본체 포함)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 125), 1)), "전 속성 반감", "결정석 : 422,881");
        // 이지 매그너스
        Dfs = 50;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.mag),
                "\n 이지\n 매그너스\n ", " LV.110\n HP : 400,000,000 (4억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 110), 1)), "전 속성 반감", "결정석 : 446,049");
        // 노말 힐라
        Dfs = 50;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hil),
                "\n 노말 힐라\n ", " LV.110\n HP : 500,000,000 (5억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 110), 1)), "전 속성 반감", "결정석 : 494,240");
        // 이지 혼테일
        Dfs = 40;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hon),
                "\n 이지 \n 혼테일\n ", " LV.130\n HP : 817,600,000\n (8억1760만 / 모든 부위 포함)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 130), 1)), "반감 없음", "결정석 : 544,899");
        // 반반
        Dfs = 50;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.banb),
                "\n 반반\n ", " LV.120\n HP : 315,000,000 (3억1500만)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 120), 1)), "전 속성 반감", "결정석 : 598,028");
        // 피에르
        Dfs = 50;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.pie),
                "\n 피에르\n ", " LV.120\n HP : 315,000,000 (3억1500만)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 120), 1)),"전 속성 반감(특수)", "결정석 : 598,028");
        // 블러디 퀸
        Dfs = 50;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.blo),
                "\n 블러디 퀸\n ", " LV.120\n HP : 315,000,000 (3억1500만)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 120), 1)),"전 속성 반감", "결정석 : 598,028");
        // 벨룸
        Dfs = 55;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.bel),
                "\n 벨룸\n ", " LV.130\n HP : 550,000,000 (5억5000만)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 130), 1)), "전 속성 반감", "결정석 : 598,028");
        // 노말 혼테일
        Dfs = 40;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hon),
                "\n 노말 \n 혼테일\n ", " LV.160\n HP : 2,090,000,000\n (20억9000만 / 모든 부위 포함)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 160), 1)), "반감 없음", "결정석 : 625,520");
        // 이지 반레온
        Dfs = 50;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.leo),
                "\n 이지\n 반레온\n ", " LV.120\n HP : 700,000,000 (7억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 120), 1)), "반감 없음", "결정석 : 653,629");
        // 이지 아카이럼
        Dfs = 60;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.aca),
                "\n 이지\n 아카이럼\n ", " LV.130\n HP : 2,100,000,000 (21억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 130), 1)), "반감 없음", "결정석 : 711,701");
        // 카웅
        Dfs = 60;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.car),
                "\n 카웅\n ", " LV.180\n HP : 1,680,000,000 (16억8000만)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 180), 1)), "전 속성 반감", "결정석 : 772,247");
        // 카오스 혼테일
        Dfs = 50;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hon),
                "\n 카오스 \n 혼테일\n ", " LV.180\n HP : 20,000,000,000\n (200억 / 모든 부위 포함)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 180), 1)), "반감 없음", "결정석 : 835,262");
        // 노말 핑크빈
        Dfs = 70;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.pik),
                "\n 노말\n 핑크빈\n ", " LV.180\n HP : 7,650,000,000\n ( 76억5000만 / 모든 석상 포함)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 180), 1)), "번개 제외 반감", "결정석 : 867,696");
        // 노말 반레온
        Dfs = 80;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.leo),
                "\n 노말\n 반레온\n ", " LV.130\n HP : 6,300,000,000 (63억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 130), 1)), "반감 없음", "결정석 : 900,750");
        // 하드 반레온
        Dfs = 100;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.leo),
                "\n 하드\n 반레온\n ", " LV.140\n HP : 10,500,000,000 (105억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 140), 1)), "반감 없음", "결정석 : 1,513,606");
        // 노말 아카이럼
        Dfs = 90;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.aca),
                "\n 노말\n 아카이럼\n ", " LV.170\n HP : 12,600,000,000 (126억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 170), 1)), "반감 없음", "결정석 : 1,557,161");
        // 노말 매그너스
        Dfs = 50;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.mag),
                "\n 노말\n 매그너스\n ", " LV.130\n HP : 6,000,000,000 (60억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 130), 1)), "전 속성 반감", "결정석 : 1,601,331");
        // 노말 파풀라투스
        Dfs = 90;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.pap),
                "\n 노말\n 파풀라투스\n ", " LV.155\n HP : 16,600,000,000\n (166억 / 본체 포함)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 155), 1)), "전 속성 반감", "결정석 : 1,646,121");
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
