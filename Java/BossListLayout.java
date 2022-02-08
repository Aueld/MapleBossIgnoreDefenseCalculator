package com.epeld.myapplication;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class BossListLayout extends AppCompatActivity {

    boolean check;
    int level;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        setContentView(R.layout.boss_list_layout);

        Intent refIntent = this.getIntent();
        float levelDamage[] = {120, 118, 116, 114, 112, 110, 105.84f, 100.7f, 96.72f, 91.8f, 88, 85, 83, 80, 78, 75, 73, 70, 68, 65, 63, 60, 58, 55, 50, 48, 45, 43, 40, 38, 35, 33, 30, 28, 25, 23, 20, 18, 15, 13, 10, 8, 5, 3, 0};

        float seter = refIntent.getFloatExtra("seter", -1);
        check = refIntent.getBooleanExtra("levelCheck", false);
        int bossLevel = 0;
        level = -1;
        if(check){
            level = refIntent.getIntExtra("level", -1);
        }
        Toast.makeText(this, ""+check+"  " +level, Toast.LENGTH_SHORT).show();

        TextView result3 = (TextView)  findViewById(R.id.setString);
        if(seter != -1){
            result3.setText(String.format("%.2f", seter));
        }

        ListView listview ;
        ListViewAdapter adapter;

        adapter = new ListViewAdapter() ;

        listview = (ListView) findViewById(R.id.list);
        listview.setAdapter(adapter);

        float Dfs = 0.0f, Ign;
        String text_dpen, text_perdmg;
        text_dpen = "방어율 : ";
        text_perdmg = "% 피해를 입힘";

        // 이지 시그너스

        Dfs = 100;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.sig),
                "\n 이지\n 시그너스\n ", " LV.140\n HP : 10,500,000,000 (105억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)),"전 속성 반감", "결정석 : 5,766,335");
        // 하드 힐라
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hhil),
                "\n 하드 힐라\n ", " LV.190\n HP : 16,800,000,000 (168억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)), "전 속성 반감", "결정석 : 7,248,704");
        // 카오스 핑크빈
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.pik),
                "\n 카오스\n 핑크빈\n ", " LV.190\n HP : 219,043,332,045\n (약 2200억 / 모든 석상 포함)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)), "전 속성 반감", "결정석 : 8,277,079");
        // 노말 시그너스
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.sig),
                "\n 노말\n 시그너스\n ", " LV.190\n HP : 63,000,000,000 (630억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)), "전 속성 반감", "결정석 : 9,432,017");
        // 카오스 자쿰
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.zak),
                "\n 카오스 자쿰\n ", " LV.180\n HP : 84,000,000,000 (840억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)), "전 속성 반감", "결정석 : 10,229,381");
        // 카오스 반반
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.banb),
                "\n 카오스 반반\n ", " LV.190\n HP : 100,000,000,000 (1000억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)), "전 속성 반감", "결정석 : 10,293,794");
        // 카오스 피에르
        Dfs = 80;
        Ign = 100 - (Dfs - (Dfs * seter / 100));
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.pie),
                "\n 카오스\n 피에르\n ", " LV.190\n HP : 80,000,000,000 (800억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)), "전 속성 반감(특수)", "결정석 : 10,313,974");
        // 카오스 블러디 퀸
        Dfs = 120;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.blo),
                "\n 카오스\n 블러디 퀸\n ", " LV.190\n HP : 140,000,000,000 (1400억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)), "전 속성 반감", "결정석 : 10,287,243");
        // 하드 매그너스
        Dfs = 120;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.mag),
                "\n 하드\n 매그너스\n ", " LV.190\n HP : 120,000,000,000 (1200억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)), "전 속성 반감", "결정석 : 12,127,081");
        // 카오스 벨룸
        Dfs = 200;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.bel),
                "\n 카오스 벨룸\n ", " LV.190\n HP : 200,000,000,000 (2000억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)), "전 속성 반감", "결정석 : 13,231,251");
        // 카오스 파풀라투스
        Dfs = 250;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.pap),
                "\n 카오스\n 파풀라투스\n ", " LV.190\n HP : 504,000,000,000\n (5040억 / 본체 포함)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)), "전 속성 반감", "결정석 : 26,763,659");
        // 노말 스우
        Dfs = 300;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.suu),
                "\n 노말 스우\n ", " LV.210\n HP : 1,500,000,000,000 (1조5000억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)), "전 속성 반감", "결정석 : 33,961,301");
        // 노말 데미안
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.dem),
                "\n 노말 데미안\n ", " LV.210\n HP : 1,200,000,000,000 (1조2000억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)),"전 속성 반감", "결정석 : 35,513,435");


        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.gas),
                "\n 노말 가디언\n 엔젤 슬라임\n ", " LV.220\n HP : 5,000,000,000,000\n (5조 / 1분마다 +1000억 회복)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)),"전 속성 반감", "결정석 : 46,949,490");


        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.lus),
                "\n 이지 루시드\n ", " LV.230\n HP : 12,000,000,000,000 (12조)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)),"전 속성 반감", "결정석 : 48,060,518");


        // 이지 윌
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.wil),
                "\n 이지 윌\n ", " LV.235\n HP : 16,501,400,000,000 (16조5014억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)),"전 속성 반감", "결정석 : 52,078,505");

        // 노말 루시드
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.nlu),
                "\n 노말 루시드\n ", " LV.230\n HP : 24,000,000,000,000 (24조)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)),"전 속성 반감", "결정석 : 57,409,149");

        // 노말 윌
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.wil),
                "\n 노말 윌\n ", " LV.250\n HP : 25,200,000,000,000 (25조2000억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)),"전 속성 반감", "결정석 : 66,184,350");
        // 노말 더스크
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.dusk),
                "\n 노말 더스크\n ", " LV.255\n HP : 26,000,000,000,000 (26조)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)),"전 속성 반감", "결정석 : 70,910,104");
        // 노말 듄켈
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.diu1),
                "\n 노말 듄켈\n ", " LV.265\n HP : 26,000,000,000,000 (26조)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)),"전 속성 반감", "결정석 : 76,346,334");

        // 하드 데미안
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hdem),
                "\n 하드 데미안\n ", " LV.225\n HP : 36,000,000,000,000 (36조)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)),"전 속성 반감", "결정석 : 111,391,647");
        // 하드 스우
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hsuu),
                "\n 하드 스우\n ", " LV.210\n HP : 32,700,000,000,000\n (32조7000억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)),"전 속성 반감", "결정석 : 117,134,241");
        // 하드 루시드
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hlus),
                "\n 하드 루시드\n ", " LV.230\n HP : 117,368,500,000,000\n (117조3685억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)),"전 속성 반감", "결정석 : 128,865,517");
        // 하드 윌
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hwil),
                "\n 하드 윌\n ", " LV.250\n HP : 126,000,000,000,000 (126조)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)),"전 속성 반감", "결정석 : 142,496,456");
        // 노말 진힐라
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.jinhil),
                "\n 노말 진힐라\n ", " LV.250\n HP : 132,000,000,000,000 (132조)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)),"전 속성 반감", "결정석 : 144,841,428");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.gas),
                "\n 카오스 가디언\n 엔젤 슬라임\n ", " LV.250\n HP : 115,500,000,000,000\n (115조 5000억 / 1분마다 +2조 3100억 회복)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)),"전 속성 반감", "결정석 : 150,492,837");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.dusk),
                "\n 카오스 더스크\n ", " LV.255\n HP : 114,600,000,000,000 (114조6000억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)),"전 속성 반감", "결정석 : 154,253,315");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.diu1),
                "\n 하드 듄켈\n ", " LV.265\n HP : 127,000,000,000,000 (127조)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)),"전 속성 반감", "결정석 : 162,141,614");

        // 하드 진힐라
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.jinhil),
                "\n 하드 진힐라\n ", " LV.250\n HP : 176,000,000,000,000 (176조)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)),"전 속성 반감", "결정석 : 183,366,017");

        Dfs = 380;
        Ign = defenseCalculator(Dfs, seter);

        // 선택받은 세렌
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.seran),
                " 노말\n 선택받은\n 세렌\n ", " LV.275\n HP : 300,640,000,000,000 (300조6400억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)),"전 속성 반감", "결정석 : 188,790,737");

        // 선택받은 세렌
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.serh),
                " 하드\n 선택받은\n 세렌\n ", " LV.275\n HP : 456,000,000,000,000 (456조)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)),"전 속성 반감", "결정석 : 256,269,439");

        Dfs = 300;
        Ign = defenseCalculator(Dfs, seter);

        // 하드 검은 마법사 1P 창조의 아이온
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.bmi),
                "\n 창조의\n 아이온\n ", " LV.265 파괴의 얄다바오트와 체력 공유\n HP : 65,000,000,000,000 (65조)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)),"전 속성 반감", "결정석 : - ");
        // 하드 검은 마법사 1P 파괴의 얄다바오트
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.bmy),
                "\n 파괴의\n 얄다바오트\n ", " LV.265 창조의 아이온과 체력 공유\n HP : 65,000,000,000,000 (65조)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)),"전 속성 반감", "결정석 : - ");
        // 하드 검은 마법사 2, 3, 4P
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.bm),
                "\n 검은 마법사\n ", " LV.275\n HP : 435,000,000,000,000 (435조)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(Calc(Ign, 1)),"전 속성 반감", "결정석 : 1,333,569,255");
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

        if(check){

        }

        return ignore;
    }

    static double Calc(double d, int n) {
        return Math.round(d * Math.pow(10, n)) / Math.pow(10, n);
    }

    static String doubleToString(double a) {
        return String.valueOf(a);
    }

}