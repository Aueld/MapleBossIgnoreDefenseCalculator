package com.epeld.myapplication;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

public class BossListLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        setContentView(R.layout.boss_list_layout);

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

        // 이지 시그너스

        qkd = 100;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.sig),
                "\n 이지\n 시그너스\n ", " LV.140\n HP : 10,500,000,000 (105억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)),"전 속성 반감", "결정석 : 7,495,200");
        // 하드 힐라
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hhil),
                "\n 하드 힐라\n ", " LV.190\n HP : 16,800,000,000 (168억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감", "결정석 : 9,327,550");
        // 카오스 핑크빈
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.pik),
                "\n 카오스\n 핑크빈\n ", " LV.190\n HP : 219,043,332,045\n (약 2200억 / 모든 석상 포함)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감", "결정석 : 10,632,112");
        // 노말 시그너스
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.sig),
                "\n 노말\n 시그너스\n ", " LV.190\n HP : 63,000,000,000 (630억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감", "결정석 : 12,058,353");
        // 카오스 자쿰
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.zak),
                "\n 카오스 자쿰\n ", " LV.180\n HP : 84,000,000,000 (840억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감", "결정석 : 13,311,437");
        // 카오스 반반
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.banb),
                "\n 카오스 반반\n ", " LV.190\n HP : 100,000,000,000 (1000억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감", "결정석 : 13,348,392");
        // 카오스 피에르
        qkd = 80;
        rhks = 100 - (qkd - (qkd * seter / 100));
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.pie),
                "\n 카오스\n 피에르\n ", " LV.190\n HP : 80,000,000,000 (800억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감(특수)", "결정석 : 13,361,860");
        // 카오스 블러디 퀸
        qkd = 120;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.blo),
                "\n 카오스\n 블러디 퀸\n ", " LV.190\n HP : 140,000,000,000 (1400억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감", "결정석 : 13,346,707");
        // 하드 매그너스
        qkd = 120;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.mag),
                "\n 하드\n 매그너스\n ", " LV.190\n HP : 120,000,000,000 (1200억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감", "결정석 : 15,691,487");
        // 카오스 벨룸
        qkd = 200;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.bel),
                "\n 카오스 벨룸\n ", " LV.190\n HP : 200,000,000,000 (2000억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감", "결정석 : 17,245,031");
        // 카오스 파풀라투스
        qkd = 250;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.pap),
                "\n 카오스\n 파풀라투스\n ", " LV.190\n HP : 504,000,000,000\n (5040억 / 본체 포함)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감", "결정석 : 26,661,949");
        // 노말 스우
        qkd = 300;
        rhks = defenseCalculator(qkd, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.suu),
                "\n 노말 스우\n ", " LV.210\n HP : 1,500,000,000,000 (1조5000억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)), "전 속성 반감", "결정석 : 33,571,839");
        // 노말 데미안
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.dem),
                "\n 노말 데미안\n ", " LV.210\n HP : 1,200,000,000,000 (1조2000억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)),"전 속성 반감", "결정석 : 35,006,900");


        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.gas),
                "\n 노말 가디언\n 엔젤 슬라임\n ", " LV.220\n HP : 5,000,000,000,000\n (5조 / 1분마다 +1000억 회복)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)),"전 속성 반감", "결정석 : 41,421,865");


        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.lus),
                "\n 이지 루시드\n ", " LV.230\n HP : 12,000,000,000,000 (12조)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)),"전 속성 반감", "결정석 : 42,375,887");

        // 노말 루시드
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.nlu),
                "\n 노말 루시드\n ", " LV.230\n HP : 24,000,000,000,000 (24조)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)),"전 속성 반감", "결정석 : 49,742,960");
        // 노말 윌
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.wil),
                "\n 노말 윌\n ", " LV.250\n HP : 24,000,000,000,000 (24조)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)),"전 속성 반감", "결정석 : 57,137,935");
        // 노말 더스크
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.dusk),
                "\n 노말 더스크\n ", " LV.255\n HP : 26,000,000,000,000 (26조)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)),"전 속성 반감", "결정석 : 61,081,148");
        // 노말 듄켈
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.diu1),
                "\n 노말 듄켈\n ", " LV.265\n HP : 26,000,000,000,000 (26조)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)),"전 속성 반감", "결정석 : 65,358,369");
        // 하드 스우
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hsuu),
                "\n 하드 스우\n ", " LV.210\n HP : 32,600,000,000,000\n (32조6000억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)),"전 속성 반감", "결정석 : 97,004,422");
        // 하드 데미안
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hdem),
                "\n 하드 데미안\n ", " LV.225\n HP : 36,000,000,000,000 (36조)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)),"전 속성 반감", "결정석 : 92,127,007");
        // 하드 루시드
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hlus),
                "\n 하드 루시드\n ", " LV.230\n HP : 94,700,000,000,000\n (94조7000억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)),"전 속성 반감", "결정석 : 105,665,361");
        // 하드 윌
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hwil),
                "\n 하드 윌\n ", " LV.250\n HP : 110,000,000,000,000 (110조)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)),"전 속성 반감", "결정석 : 116,651,513");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.gas),
                "\n 카오스 가디언\n 엔젤 슬라임\n ", " LV.250\n HP : 115,500,000,000,000\n (115조 5000억 / 1분마다 +2조 3100억 회복)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)),"전 속성 반감", "결정석 : 121,213,982");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.dusk),
                "\n 카오스 더스크\n ", " LV.255\n HP : 114,600,000,000,000 (114조6000억)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)),"전 속성 반감", "결정석 : 124,082,853 ");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.diu1),
                "\n 하드 듄켈\n ", " LV.265\n HP : 127,000,000,000,000 (127조)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)),"전 속성 반감", "결정석 : 130,141,439 ");

        // 하드 진힐라
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.jinhil),
                "\n 하드 진힐라\n ", " LV.250\n HP : 176,000,000,000,000 (176조)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)),"전 속성 반감", "결정석 : 147,879,488");

        qkd = 380;
        rhks = defenseCalculator(qkd, seter);

        // 선택받은 세렌
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.seran),
                "\n 선택받은\n 세렌\n ", " LV.275\n HP : 132,000,000,000,000 + @ (132조+@)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)),"전 속성 반감", "결정석 : 204,437,385");

        qkd = 300;
        rhks = defenseCalculator(qkd, seter);

        // 하드 검은 마법사 1P 창조의 아이온
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.bmi),
                "\n 창조의\n 아이온\n ", " LV.265 파괴의 얄다바오트와 체력 공유\n HP : 65,000,000,000,000 (65조)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)),"전 속성 반감", "결정석 : - ");
        // 하드 검은 마법사 1P 파괴의 얄다바오트
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.bmy),
                "\n 파괴의\n 얄다바오트\n ", " LV.265 창조의 아이온과 체력 공유\n HP : 65,000,000,000,000 (65조)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)),"전 속성 반감", "결정석 : - ");
        // 하드 검은 마법사 2, 3, 4P
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.bm),
                "\n 검은 마법사\n ", " LV.275\n HP : 435,000,000,000,000 (435조)", text_dpen,
                text_perdmg, qus(qkd), qus(round(rhks, 1)),"전 속성 반감", "결정석 : 1,228,367,353");
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