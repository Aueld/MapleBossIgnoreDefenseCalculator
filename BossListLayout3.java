package com.epeld.myapplication;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

public class BossListLayout3 extends AppCompatActivity {

    boolean check;
    int level;
    float levelDamage[] = {1.2f, 1.18f, 1.16f, 1.14f, 1.12f, 1.10f, 1.0584f, 1.007f, 0.9672f, 0.918f, 0.88f, 0.85f, 0.83f, 0.80f, 0.78f, 0.75f, 0.73f, 0.70f, 0.68f, 0.65f, 0.63f, 0.60f, 0.58f, 0.55f, 0.50f, 0.48f, 0.45f, 0.43f, 0.40f, 0.38f, 0.35f, 0.33f, 0.30f, 0.28f, 0.25f, 0.23f, 0.20f, 0.18f, 0.15f, 0.13f, 0.10f, 0.8f, 0.5f, 0.3f, 0};

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.boss_list_layout3);

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
        ListViewAdapter3 adapter;

        adapter = new ListViewAdapter3() ;

        listview = (ListView) findViewById(R.id.list);
        listview.setAdapter(adapter);

        float Dfs = 0.0f, Ign;
        String text_dpen, text_perdmg;
        text_dpen = "방어율 : ";
        text_perdmg = "% 피해를 입힘";

        Dfs = 50;
        Ign = defenseCalculator(Dfs, seter);

        // 01 마노
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m01mano),
                "\n 1층\n 마노\n ", " LV.100 /누적: 520만(-)\n HP : 5,200,000 (520만)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 100), 1)), "반감 없음", "");
        // 02 머쉬맘
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m02mush),
                "\n 2층\n 머쉬맘\n ", " LV.102 /누적: 1094만800(+110%)\n HP : 5,740,800 (574만800)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 102), 1)), "반감 없음", "");
        // 03 스텀피
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m03stum),
                "\n 3층\n 스텀피\n ", " LV.104 /누적: 1724만8000(+58%)\n HP : 6,307,200 (630만7200)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 104), 1)), "반감 없음", "");
        // 04 블루 머쉬맘
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m04blue),
                "\n 4층\n 블루 머쉬맘\n ", " LV.106 /누적: 2417만8000(+40%)\n HP : 6,930,000 (693만)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 106), 1)), "반감 없음", "");
        // 05 좀비 머쉬맘
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m05zumb),
                "\n 5층\n 좀비 머쉬맘\n ", " LV.108 /누적: 3172만7200(+31%)\n HP : 7,549,200 (754만9200)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 108), 1)), "반감 없음", "");
        // 06 킹 슬라임
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m06king),
                "\n 6층\n 킹슬라임\n ", " LV.110 /누적: 4406만9200(+39%)\n HP : 12,342,000 (1234만2000)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 110), 1)), "반감 없음", "");
        // 07 다일
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m07dyle),
                "\n 7층\n 다일\n ", " LV.113 /누적: 5799만2200(+32%)\n HP : 13,923,000 (1392만3000)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 113), 1)), "반감 없음", "");
        // 08 킹크랑
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m08king),
                "\n 8층\n 킹크랑\n ", " LV.115 /누적: 7309만7200(+26%)\n HP : 15,105,000 (1510만5000)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 115), 1)), "반감 없음", "");
        // 09 파우스트
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m09paus),
                "\n 9층\n 파우스트\n ", " LV.118 /누적: 8994만3200(+23%)\n HP : 16,846,000 (1684만6000)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 118), 1)), "반감 없음 / 무적", "");
        // 10 반레온
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.leo),
                "\n 10층\n 반레온\n ", " LV.120 /누적: 2억8041만9390(+212%)\n HP : 100,000,000 (1억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 120), 1)), "전 속성 반감", "");
        // 11 메탈 골렘
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m11meta),
                "\n 11층\n 메탈 골렘\n ", " LV.120 /누적: 3억2124만3390(+15%)\n HP : 40,824,000 (4082만4000)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 120), 1)), "반감 없음", "");
        // 12 엘리쟈/포장마차
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m18snac),
                "\n 12층\n 포장마차\n ", " LV.123 /누적: 3억6664만7940(+14%)\n HP : 45,404,550 (4540만4550)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 123), 1)), "반감 없음", "");
        // 13 주니어 발록
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m13jrni),
                "\n 13층\n 주니어 발록\n ", " LV.125 /누적: 4억1524만1190(+13%)\n HP : 48,593,250 (4859만3250)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 125), 1)), "반감 없음 / 무적", "");
        // 14 구미호/엘리쟈
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m12eliz),
                "\n 14층\n 엘리쟈\n ", " LV.128 /누적: 4억7059만1190(+13%)\n HP : 55,350,000 (5535만)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 128), 1)), "반감 없음", "");
        // 15 데우/크림슨발록
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m29krim),
                "\n 15층\n 크림슨 발록\n ", " LV.130 /누적: 5억5319만1690(+13%)\n HP : 61,600,500 (6160만500)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 130), 1)), "반감 없음 / 무적", "");
        // 16 제노/설산의 마녀
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m16ss),
                "\n 16층\n 설산의 마녀\n ", " LV.132 /누적: 6억31만2690(+13%)\n HP : 68,121,000 (6812만1000)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 132), 1)), "반감 없음", "");
        // 17 타이머/세르프
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m17serf),
                "\n 17층\n 세르프\n ", " LV.135 /누적: 6억7915만2690(+13%)\n HP : 78,840,000 (7884만)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 135), 1)), "반감 없음", "");
        // 18 포장마차/데우
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m15deo),
                "\n 18층\n 데우\n ", " LV.138 /누적: 7억6916만3940(+13%)\n HP : 90,011,250 (9001만1250)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 138), 1)), "반감 없음", "");
        // 19 태륜/파파픽시
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m21papa),
                "\n 19층\n 파파픽시\n ", " LV.140 /누적: 8억6706만5940(+13%)\n HP : 97,902,000 (9790만2000)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 140), 1)), "반감 없음", "");
        // 20 힐라
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hil),
                "\n 20층\n 힐라\n ", " LV.143 /누적: 37억2420만8798(+330%)\n HP : 1,500,000,000 (15억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 143), 1)), "전 속성 반감", "이지 시그 솔플컷");
        // 21 파파픽시//디트와 로이
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m24deet),
                "\n 21층\n 디트&로이\n ", " LV.145 /누적: 38억5474만4798(+4%)\n HP : 130,636,000 (1억3063만6000)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 145), 1)), "반감 없음", "");
        // 22 알리샤르//키메라
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m26kime),
                "\n 22층\n 키메라\n ", " LV.148 /누적: 40억1388만2798(+4%)\n HP : 159,138,000 (1억5913만8000)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 148), 1)), "반감 없음", "");
        // 23 데비존//프랑켄로이드
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m25fran),
                "\n 23층\n 프랑켄로이드\n ", " LV.150 /누적: 42억0423만2798(+5%)\n HP : 190,350,000 (1억9035만)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 150), 1)), "반감 없음", "");
        // 24 디트와 로이//차우
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m24cau),
                "\n 24층\n 차우\n ", " LV.153 /누적: 44억4665만6798(+6%)\n HP : 242,424,000 (2억4242만4000)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 153), 1)), "반감 없음", "");
        // 25 프랑켄로이드//에피테아
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m43epin),
                "\n 25층\n 에피네아\n ", " LV.155 /누적: 48억5216만0798(+9%)\n HP : 405,504,000 (4억550만4000)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 155), 1)), "반감 없음 / 유혹", "");
        // 26 키메라//롬바드
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m26rom),
                "\n 26층\n 롬바드\n ", " LV.158 /누적: 53억4920만0798(+10%)\n HP : 497,040,000 (4억9704만)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 158), 1)), "반감 없음", "");
        // 27 포이즌 골렘//타이머
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m17time),
                "\n 27층\n 타이머\n ", " LV.160 /누적: 59억4569만6798(+11%)\n HP : 596,496,000 (5억9649만6000)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 160), 1)), "반감 없음", "카핑 솔플컷");
        // 28 요괴선사//마스터 스펙터
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m28masts),
                "\n 28층\n 마스터스펙터\n ", " LV.163 /누적: 66억5187만2798(+12%)\n HP : 706,176,000 (7억617만6000)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 163), 1)), "반감 없음", "노말 시그 파티컷");
        // 29 크림슨발록//마스터 버크
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m29mastb),
                "\n 29층\n 마스터 버크\n ", " LV.165 /누적: 74억7612만8798(+12%)\n HP : 824,256,000 (8억2425만6000)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 165), 1)), "반감 없음", "카쿰, 3루타 파티컷");
        // 30 아카이럼
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.aca),
                "\n 30층\n 아카이럼\n ", " LV.168 /누적: 131억9041만4512(+76%)\n HP : 3,000,000,000 (30억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 168), 1)), "전 속성 반감 / 공반", "공무, 마무");
        // 31 마뇽
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m31manu),
                "\n 31층\n 마뇽\n ", " LV.170 /누적: 174억689만4512(+32%)\n HP : 2,108,240,000 (21억824만)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 170), 1)), "반감 없음 / 두마리", "");
        // 32 그리프
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m32grip),
                "\n 32층\n 그리프\n ", " LV.175 /누적: 224억5993만4512(+29%)\n HP : 2,526,520,000 (25억2652만)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 175), 1)), "반감 없음 / 두마리", "노말 시그 솔플컷");
        // 33 스노우맨//크세르크세스
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m44kser),
                "\n 33층\n 크세르크세스\n ", " LV.180 /누적: 284억1193만4512(+26%)\n HP : 2,976,000,000 (29억7600만)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 180), 1)), "반감 없음 / 두마리", "카쿰 솔플컷");
        // 34 파풀라투스
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.pap),
                "\n 34층\n 파풀라투스\n ", " LV.185 /누적: 353억4177만4512(+24%)\n HP : 3,464,920,000 (34억6492만)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 185), 1)), "반감 없음 / 두마리", "3루타 솔플컷");
        // 35 교도관 아니//알리샤르
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m22alis),
                "\n 35층\n 알리샤르\n ", " LV.190 /누적: 433억1505만4512(+23%)\n HP : 3,986,640,000 (39억8664만)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 190), 1)), "반감 없음 / 두마리", "카벨 파티컷");
        // 36 레비아탄//스노우맨
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m33snow),
                "\n 36층\n 스노우맨\n ", " LV.195 /누적: 524억1705만4512(+21%)\n HP : 4,551,000,000 (45억5100만)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 195), 1)), "반감 없음 / 두마리", "하드 매그 솔플컷");
        // 37 도도//리치
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m37rich),
                "\n 37층\n 리치\n ", " LV.200 /누적: 627억1657만4512(+20%)\n HP : 5,149,760,000 (51억4976만)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 200), 1)), "반감 없음 / 두마리", "카벨 솔플컷");
        // 38 릴리노흐//아니
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m35ani),
                "\n 38층\n 교도관 아니\n ", " LV.205 /누적: 821억4145만4512(+31%)\n HP : 6,474,960,000 (64억7496만)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 205), 1)), "반감 없음 / 세마리", "노말 스우 파티컷");
        // 39 라이카//마스터 오맨
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m41mast),
                "\n 39층\n 마스터 오멘\n ", " LV.210 /누적: 1060억5697만4512(+29%)\n HP : 7,971,840,000 (79억7184만)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 210), 1)), "반감 없음 / 세마리", "");
        // 40 매그너스
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.mag),
                "\n 40층\n 매그너스\n ", " LV.215 /누적: 1212억9506만9750(+14%)\n HP : 8,000,000,000 (80억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 215), 1)), "전 속성 반감 / 밀격", "노말 데미안 파티컷");
        // 41 마스터 오멘//타르가
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m45targ),
                "\n 41층\n 타르가\n ", " LV.220 /누적: 1632억9506만9750(+35%)\n HP : 40,000,000,000 (400억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 220), 1)), "반감 없음", "카파풀 솔플컷");
        // 42 게오르크//스칼리온
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m46scar),
                "\n 42층\n 스칼리온\n ", " LV.220 /누적: 2262억9506만9750(+39%)\n HP : 64,000,000,000 (640억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 220), 1)), "반감 없음", "노말 스우 솔플컷");
        // 43 에피네아//요괴선사
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m28king),
                "\n 43층\n 요괴선사\n ", " LV.220 /누적: 3102억9506만9750(+37%)\n HP : 84,000,000,000 (840억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 220), 1)), "반감 없음 / 텔포", "노말 데미안 솔플컷");
        // 44 크세르크세스//데비존
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m23debi),
                "\n 44층\n 데비존\n ", " LV.220 /누적: 4152억9506만9750(+34%)\n HP : 105,000,000,000 (1050억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 220), 1)), "반감 없음 / 돌진", "");
        // 45 타르가//라바나
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m47raba),
                "\n 45층\n 라바나\n ", " LV.220 /누적: 5202억9506만9750(+25%)\n HP : 105,000,000,000 (1050억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 220), 1)), "반감 없음 / 텔포,무적", "이지 루시드 파티컷");
        // 46 스칼리온//레비아탄
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m36lavi),
                "\n 46층\n 레비아탄\n ", " LV.230 /누적: 7302억9506만9750(+40%)\n HP : 210,000,000,000 (2100억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 230), 1)), "반감 없음 / 돌진", "");
        // 47 라바나//도도
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m37dodo),
                "\n 47층\n 도도\n ", " LV.230 /누적: 1조452억9506만9750(+43%)\n HP : 315,000,000,000 (3150억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 230), 1)), "반감 없음", "노말 루시드 파티컷");
        // 48 타란튤로스//릴리노흐
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m38lili),
                "\n 48층\n 릴리노흐\n ", " LV.230 /누적: 1조4652억9506만9750(+40%)\n HP : 420,000,000,000 (4200억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 230), 1)), "반감 없음 / 텔포", "노말 윌 파티컷");
        // 49 드래고니카//라이카
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m39lica),
                "\n 49층\n 라이카\n ", " LV.230 /누적: 1조9902억9506만9750(+36%)\n HP : 525,000,000,000 (5250억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 230), 1)), "반감 없음 / 유혹", "하드 스데 파티컷");
        // 50 드래곤라이더//핑크빈
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.pik),
                "\n 50층\n 핑크빈\n ", " LV.230 /누적: 2조9902억9506만9750(+50%)\n HP : 525,000,000,000 (5250억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 230), 1)), "전 속성 반감 / 공반", "하드 루시드 파티컷");
        // 51 호크아이//락 스피릿
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m51rok),
                "\n 51층\n 락 스피릿\n ", " LV.240 /누적: 3조36202억9506만9750(+21%)\n HP : 630,000,000,000 (6300억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 240), 1)), "반감 없음 / 스턴", "노말 루시드 솔플컷");
        // 52 이카르트//타란튤로스
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m48tara),
                "\n 52층\n 타란튤로스\n ", " LV.240 /누적: 4조3552억9506만9750(+20%)\n HP : 840,000,000,000 (8400억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 240), 1)), "반감 없음 / 석화", "노말 윌 솔플컷");
        // 53 이리나//드래고니카
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m49drag),
                "\n 53층\n 드래고니카\n ", " LV.240 /누적: 5조1952억9506만9750(+19%)\n HP : 840,000,000,000 (8400억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 240), 1)), "반감 없음 / 텔포", "하드 진힐라 파티컷");
        // 54 오즈//드래곤 라이더
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m50drag),
                "\n 54층\n 드래곤라이더\n ", " LV.240 /누적: 6조1402억9506만9750(+18%)\n HP : 945,000,000,000 (9450억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 240), 1)), "반감 없음 / 텔포", "");
        // 55 미하일//호크아이
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m51hoke),
                "\n 55층\n 호크아이\n ", " LV.240 /누적: 7조1902억9506만9750(+17%)\n HP : 1,050,000,000,000 (1조500억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 240), 1)), "반감 없음 / 밀격", "");
        // 56 시그너스//이카르트
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m52ikar),
                "\n 56층\n 이카르트\n ", " LV.245 /누적: 8조3452억9506만9750(+16%)\n HP : 1,155,000,000,000 (1조1550억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 245), 1)), "반감 없음 / 텔포", "");
        // 57 아랑//이리나
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m53irin),
                "\n 57층\n 이리나\n ", " LV.245 /누적: 9조6052억9506만9750(+15%)\n HP : 1,260,000,000,000 (1조2600억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 245), 1)), "반감 없음 / 실명", "노말 듄켈 솔플컷");
        // 58 봉선//오즈
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m54oz),
                "\n 58층\n 오즈\n ", " LV.245 /누적: 10조9702억9506만9750(+14%)\n HP : 1,365,000,000,000 (1조3650억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 245), 1)), "반감 없음 / 봉인", "");
        // 59 오공//미하일
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m55miha),
                "\n 59층\n 미하일\n ", " LV.245 /누적: 12조4402억9506만9750(+13%)\n HP : 1,470,000,000,000 (1조4700억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 245), 1)), "반감 없음 / 암흑", "");
        // 60 송달//시그너스
        Dfs = 100;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.sig),
                "\n 60층\n 시그너스\n ", " LV.245 /누적: 15조4402억9506만9750(+24%)\n HP : 1,575,000,000,000 (1조5750억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 245), 1)), "전 속성 반감 / 공반", "");
        // 61 황룡//피아누스
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m61pia),
                "\n 61층\n 피아누스\n ", " LV.250 /누적: 17조1202억9506만9750(+11%)\n HP : 1,680,000,000,000 (1조6800억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 250), 1)), "반감 없음", "1/1");
        // 62 적호//렉스
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m62rex),
                "\n 62층\n 렉스\n ", " LV.250 /누적: 18조9052억9506만9750(+10%)\n HP : 1,785,000,000,000 (1조7850억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 250), 1)), "반감 없음", "");
        // 63 무공//카웅
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.car),
                "\n 63층\n 카웅\n ", " LV.250 /누적: 20조7952억9506만9750(+10%)\n HP : 1,890,000,000,000 (1조8900억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 250), 1)), "반감 없음", "");
        // 64 변형된 스텀피
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m64stup),
                "\n 64층\n 변형된스텀피\n ", " LV.250 /누적: 22조7062억9506만9750(+9%)\n HP : 1,995,000,000,000 (1조9950억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 250), 1)), "반감 없음", "6연타");
        // 65 하늘 수호령
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m65sky),
                "\n 65층\n 하늘 수호령\n ", " LV.250 /누적: 24조6382억9506만9750(+9%)\n HP : 2,100,000,000,000 (2조1000억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 250), 1)), "반감 없음", "");
        // 66 게오르크
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m42demo),
                "\n 66층\n 게오르크\n ", " LV.255 /누적: 26조5912억9506만9750(+8%)\n HP : 2,205,000,000,000 (2조2050억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 255), 1)), "반감 없음", "");
        // 67 타락마족 강화늑대기수
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m67wolf),
                "\n 67층\n 타락마족\n 강화늑대기수\n ", " LV.255 /누적: 28조5652억9506만9750(+7%)\n HP : 2,310,000,000,000 (2조3100억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 255), 1)), "반감 없음", "");
        // 68 아르마
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m68arma),
                "\n 68층\n 아르마\n ", " LV.255 /누적: 30조5602억9506만9750(+7%)\n HP : 2,415,000,000,000 (2조4150억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 255), 1)), "반감 없음", "HP50%고정뎀");
        // 69 츄릅나무
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m69tree),
                "\n 69층\n 츄릅나무\n ", " LV.255 /누적: 32조5762억9506만9750(+7%)\n HP : 2,520,000,000,000 (2조5200억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 255), 1)), "반감 없음", "");
        // 70 스우
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.suu),
                "\n 70층\n 스우\n ", " LV.255 /누적: 36조5762억9506만9750(+12%)\n HP : 2,100,000,000,000 (2조1000억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 255), 1)), "전 속성 반감", "");
        // 71 클리너
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m71cleen),
                "\n 71층\n 클리너\n ", " LV.260 /누적: 38조8862억9506만9750(+6%)\n HP : 2,310,000,000,000 (2조3100억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 260), 1)), "반감 없음", "");
        // 72 악화된 조화의 정령
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m72far),
                "\n 72층\n 악화된\n 조화의정령\n ", " LV.260 /누적: 41조5112억9506만9750(+7%)\n HP : 2,625,000,000,000 (2조6250억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 260), 1)), "반감 없음", "");
        // 73 증발하는 에르다스
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m73erda),
                "\n 73층\n 증발하는\n 에르다스\n ", " LV.260 /누적: 44조4512억9506만9750(+7%)\n HP : 2,940,000,000,000 (2조9400억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 260), 1)), "반감 없음", "");
        // 74 아랑
        Dfs = 150;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m57aran),
                "\n 74층\n 아랑\n ", " LV.260 /누적: 47조7062억9506만9750(+7%)\n HP : 3,255,000,000,000 (3조2550억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 260), 1)), "반감 없음", "");
        // 75 봉선
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m58bong),
                "\n 75층\n 봉선\n ", " LV.260 /누적: 51조2762억9506만9750(+8%)\n HP : 3,570,000,000,000 (3조57000억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 260), 1)), "반감 없음", "");
        // 76 오공
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m59ogon),
                "\n 76층\n 오공\n ", " LV.260 /누적: 55조1912억9506만9750(+8%)\n HP : 3,915,000,000,000 (3조9150억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 260), 1)), "반감 없음", "");
        // 77 송달
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m60song),
                "\n 77층\n 송달\n ", " LV.260 /누적: 59조4012억9506만9750(+8%)\n HP : 4,210,000,000,000 (4조2100억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 260), 1)), "반감 없음", "");
        // 78 황룡
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m61hwan),
                "\n 78층\n 황룡\n ", " LV.260 /누적: 63조9362억9506만9750(+7%)\n HP : 4,535,000,000,000 (4조5350억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 260), 1)), "반감 없음", "");
        // 79 적호
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m62juck),
                "\n 79층\n 적호\n ", " LV.260 /누적: 68조7932억9506만9750(+7%)\n HP : 4,857,000,000,000 (4조8570억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 260), 1)), "반감 없음", "");
        // 80 무공
        Dfs = 200;
        Ign = defenseCalculator(Dfs, seter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.m63mogon),
                "\n 80층\n 무공\n ", " LV.260 /누적: 69조1935억9506만9750(+8%)\n HP : 5,257,300,000,000 (5조2573억)", text_dpen,
                text_perdmg, doubleToString(Dfs), doubleToString(calc(levelDamageCal(Ign, 260), 1)), "전 속성 반감", "KMS 최고격파층");


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
