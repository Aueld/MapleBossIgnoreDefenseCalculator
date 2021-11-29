package com.epeld.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;

    float ap;
    boolean as;
    String textSave = "";
    //String textSave[] = new String[9];

    public void rtt ( int i){

        switch(i){
            case 1:
                Toast.makeText(getApplicationContext(), "리부트 서버의 결정석 가격은\n일반 서버 결정석 가격의 3배입니다.", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(getApplicationContext(), "컬렉터의 주간 결정석 구매 횟수는\n매주 목요일 0시마다 초기화됩니다.", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(getApplicationContext(), "스택형 방어율 버프, 디버프는 스택당 합연산입니다\n(최종적으로 적용될때는 곱연산이므로)\n(계산기 추가 방무에 적으시면 됩니다.)\nex. 제로-아머스플릿 5중첩시 50%", Toast.LENGTH_LONG).show();
                break;
            case 4:
                Toast.makeText(getApplicationContext(), "방어율 디버프들은 곱연산으로 중첩 적용됩니다. \n추가 방어율 무시에 각각 입력하면 되겠습니다.", Toast.LENGTH_LONG).show();
                break;
            case 5:
                Toast.makeText(getApplicationContext(), "몬스터와의 레벨 차이도\n데미지에 증감을 줍니다.", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "레벨차이\n+20이상시 데미지 120%\n-20시 데미지 50%\n-40이하시 데미지 0%", Toast.LENGTH_LONG).show();
                break;
            case 6:
                Toast.makeText(getApplicationContext(), "2021. 11. 01 기준 정보 입니다.", Toast.LENGTH_SHORT).show();
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auto_saving(as);
        initLayout();
        calculate();
        bossActivity1(); // weekly Boss
        bossActivity2(); // Daily Boss
        bossActivity3(); // mulun Boss
        bossActivity4(); // other Boss
    }

    private void auto_saving(boolean save) {
        View vd = findViewById(R.id.amc);
        SharedPreferences sharedPreferences = getSharedPreferences( "save", 0);

        as = sharedPreferences.getBoolean("saver", as);
        if(as){

            EditText ed[] = new EditText[9];
            SharedPreferences sharedPreferencesA[] = new SharedPreferences[9];
            String sa[] = new String[9];

            ed[0] = (EditText) vd.findViewById(R.id.fnum);
            ed[1] = (EditText) vd.findViewById(R.id.addnum1);
            ed[2] = (EditText) vd.findViewById(R.id.addnum2);
            ed[3] = (EditText) vd.findViewById(R.id.addnum3);
            ed[4] = (EditText) vd.findViewById(R.id.addnum4);
            ed[5] = (EditText) vd.findViewById(R.id.addnum5);
            ed[6] = (EditText) vd.findViewById(R.id.addnum6);
            ed[7] = (EditText) vd.findViewById(R.id.addnum7);
            ed[8] = (EditText) vd.findViewById(R.id.addnum8);


            for(int i = 0; i < 9; i++)
                sharedPreferencesA[i] = getSharedPreferences(textSave, 0);
            sa[0] = sharedPreferencesA[0].getString("saveText0", "");
            sa[1] = sharedPreferencesA[1].getString("saveText1", "");
            sa[2] = sharedPreferencesA[2].getString("saveText2", "");
            sa[3] = sharedPreferencesA[3].getString("saveText3", "");
            sa[4] = sharedPreferencesA[4].getString("saveText4", "");
            sa[5] = sharedPreferencesA[5].getString("saveText5", "");
            sa[6] = sharedPreferencesA[6].getString("saveText6", "");
            sa[7] = sharedPreferencesA[7].getString("saveText7", "");
            sa[8] = sharedPreferencesA[8].getString("saveText8", "");
            for(int i = 0; i < 9; i++)
                ed[i].setText(sa[i]);
            Toast.makeText(getApplicationContext(), "불러오기 성공", Toast.LENGTH_LONG).show();
        }
        else {
            //Toast.makeText(getApplicationContext(), "Off", Toast.LENGTH_LONG).show();
        }
    }

    private void bossActivity1() { // weekly Boss
        final View bd = findViewById(R.id.amc);

        final Button bossButton1 = (Button) bd.findViewById(R.id.button);

        bossButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), BossListLayout.class);

                intent3.putExtra("seter", ap);
                Random rn2 = new Random();
                int randp2 = rn2.nextInt(8);
                if(randp2 == 7) {
                    Toast.makeText(getApplicationContext(), "주간 보스 페이지로 이동합니다.", Toast.LENGTH_SHORT).show();
                }
                else if(randp2 == 0) {
                    Toast.makeText(getApplicationContext(), "주간 보스의 입장 횟수는 매주 목요일 0시마다 초기화됩니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    rtt(randp2);
                }
                startActivity(intent3);
                onStop();


            }
        });
    }
    private void bossActivity2() { // Daily Boss
        final View bd = findViewById(R.id.amc);

        final Button bossButton2 = (Button) bd.findViewById(R.id.button2);

        bossButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), BossListLayout2.class);

                intent2.putExtra("seter", ap);

                Random rn = new Random();
                int randp = rn.nextInt(6);

                if(randp == 0)
                    Toast.makeText(getApplicationContext(), "일일 보스 페이지로 이동합니다.", Toast.LENGTH_SHORT).show();
                else
                    rtt(randp);

                startActivity(intent2);
                onStop();
           }
        });
    }
    private void bossActivity3() { // mulun Boss
        final View bd = findViewById(R.id.amc);

        final Button bossButton3 = (Button) bd.findViewById(R.id.button3);

        bossButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), BossListLayout3.class);

                intent1.putExtra("seter", ap);

                Random rn0 = new Random();
                int randp0 = rn0.nextInt(6);

                switch (randp0){

                    case 0:
                        Toast.makeText(getApplicationContext(),"무릉도장 보스컷 층수는 절대적인 지표가 아니며\n대략적인 지표는 솔플은 15~20분, 파티격은 3인 기준 입니다.",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(),"무릉도장에서는 최종 데미지가 1/10 으로 적용됩니다.",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),"캐릭터의 직업과 컨트롤에 따라\n최고 층수에 큰 차이가 있습니다.",Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(),"미기재된 정보는 정보 공개시 추가 될 예정입니다.",Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(getApplicationContext(),"누적 체력은 통찰력의 속성내성 무시(5%)를\n 반영한 비반감 기준 누적 체력으로 표시했습니다.",Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(getApplicationContext(),"+~%는 이전 층과 비교한 누적 체력의 상승량으로 소수점은 반올림 처리했습니다.\n",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }


                startActivity(intent1);
                onStop();
            }
        });
    }
    private void bossActivity4() { // other Boss
        final View bd = findViewById(R.id.amc);

        final Button bossButton4 = (Button) bd.findViewById(R.id.button4);

        bossButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getApplicationContext(), BossListLayout4.class);
                intent4.putExtra("seter", ap);

                Random rn4 = new Random();
                int randp4 = rn4.nextInt(9);
                if(randp4 == 1)
                    Toast.makeText(getApplicationContext(),"우르스의 폭탄은 최대 체력의 200% 데미지를 줍니다 \n하지만 맞는 인원수만큼\n데미지가 분산 되기 때문에 3인 이상이서 나눠 맞으면 삽니다.",Toast.LENGTH_LONG).show();
                else if( randp4 == 2)
                    Toast.makeText(getApplicationContext(),"더 시드는 보스를 잡는것보다 \n탑을 내려가는 과정이 더 힘듭니다.",Toast.LENGTH_SHORT).show();
                else if( randp4 == 3)
                    Toast.makeText(getApplicationContext(),"불꽃늑대를 바인드 상태로 잡을시 \n마을로 귀환하지 않고 \n즉시 재소환 되어 다시 잡을 수 있습니다.",Toast.LENGTH_LONG).show();
                else if( randp4 == 0)
                    Toast.makeText(getApplicationContext(),"건의사항은 개발자의 지메일 또는 리뷰로 부탁드립니다.",Toast.LENGTH_LONG).show();
                else if( randp4 == 4)
                    Toast.makeText(getApplicationContext(),"샤레니안의 지하수로 보스 아르카누스는 \n버그로 가끔 두마리 이상 존재 할 수 있으나 \n점수에는 한마리의 딜만 들어갑니다.",Toast.LENGTH_LONG).show();
                else if( randp4 == 5)
                    Toast.makeText(getApplicationContext(),"엘리트 보스는 본인레벨 +-20 구간의 사냥터에서만\n 소환 시킬 수 있습니다.",Toast.LENGTH_LONG).show();
                else if( randp4 == 6)
                    Toast.makeText(getApplicationContext(),"엘리트몬스터를 잡을시\n1~15회까진 ~이곳을 음산하게~,\n16~19회에선 ~곧 무슨일이~\n라고 알림이 뜹니다. (곧무?)",Toast.LENGTH_LONG).show();
                else if( randp4 == 7)
                    Toast.makeText(getApplicationContext(),"엘리트몬스터의 체력은\n노란색 검 : 필드몹 레벨 비례 체력 * 15\n주황색 검 : 필드몹 레벨 비례 체력 * 20\n빨간색 검 : 필드몹 레벨 비례 체력 * 30\n입니다.",Toast.LENGTH_LONG).show();
                else if( randp4 == 8)
                    Toast.makeText(getApplicationContext(),"엘리트몬스터를 19회 잡은 후\n다음 엘리트 몬스터 타이밍에는\n엘리트보스가 소환됩니다.",Toast.LENGTH_LONG).show();

                startActivity(intent4);
                onStop();

            }
        });
    }

    private void calculate() {
        final View bd = findViewById(R.id.amc);

        final Button cal = (Button) bd.findViewById(R.id.asmd);

        cal.setOnClickListener(new View.OnClickListener() {

            float n;

            float nArr[] = new float[] {0, 0, 0, 0, 0, 0, 0, 0};

            int MAX = 8;

            TextView result = (TextView) bd.findViewById(R.id.result);
            TextView result2 = (TextView) bd.findViewById(R.id.result2);

            EditText numArr[] = new EditText[MAX];
            EditText fnum = (EditText) bd.findViewById(R.id.fnum);

            @Override
            public void onClick(View v) {

                numArr[0] = (EditText) bd.findViewById(R.id.addnum1);
                numArr[1] = (EditText) bd.findViewById(R.id.addnum2);
                numArr[2] = (EditText) bd.findViewById(R.id.addnum3);
                numArr[3] = (EditText) bd.findViewById(R.id.addnum4);
                numArr[4] = (EditText) bd.findViewById(R.id.addnum5);
                numArr[5] = (EditText) bd.findViewById(R.id.addnum6);
                numArr[6] = (EditText) bd.findViewById(R.id.addnum7);
                numArr[7] = (EditText) bd.findViewById(R.id.addnum8);

                for(int i = 0; i < MAX; i++){
                    if(numArr[i].length() != 0)
                        nArr[i] = Float.parseFloat(numArr[i].getText().toString());
                    else
                        nArr[i] = 0;
                }

                if(fnum.length() == 0){
                    return;
                }

                if(fnum.length() != 0)
                    n = Float.parseFloat(fnum.getText().toString());
                else
                    n = 0;

                if(n >= 100){
                    fnum.requestFocus();
                    Toast.makeText(getApplicationContext(), "표기 방어력 무시에는\n100 미만의 숫자를 입력해 주세요. ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(n < 0){
                    fnum.requestFocus();
                    Toast.makeText(getApplicationContext(), "표기 방어력 무시에는\n0 이상의 숫자를 입력해 주세요. ", Toast.LENGTH_SHORT).show();
                    return;
                }

                ap = (1 - (100 - n) / 100 * (100 - nArr[0]) / 100 * (100 - nArr[1]) / 100 * (100 - nArr[2]) / 100 * (100 - nArr[3]) / 100 * (100 - nArr[4]) / 100 * (100 - nArr[5]) / 100 * (100 - nArr[6]) / 100 * (100 - nArr[7]) / 100) * 100;

                result.setText(String.format("%.2f", ap));


                if(ap * 100 % 1 == 0)
                    result2.setText(String.format("%.2f", ap));
                else
                    result2.setText(String.format("%.2f", ap + 0.01));

                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                assert imm != null;
                imm.hideSoftInputFromWindow(cal.getWindowToken(), 0);

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        View vdd = findViewById(R.id.amc);

        Boolean saveAs = as;
        SharedPreferences sharedPreferences = getSharedPreferences("save", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("saver", saveAs);
        editor.commit();

        if(as){
            SharedPreferences sharedPreferencesA[] = new SharedPreferences[9];
            SharedPreferences.Editor editorA[] = new SharedPreferences.Editor[9];
            EditText edd[] = new EditText[9];
            String value[] = new String[9];


            for(int i = 0; i < 9; i++) {
                sharedPreferencesA[i] = getSharedPreferences(textSave, 0);
                editorA[i] = sharedPreferencesA[i].edit();
            }

            edd[0] = vdd.findViewById(R.id.fnum);
            edd[1] = vdd.findViewById(R.id.addnum1);
            edd[2] = vdd.findViewById(R.id.addnum2);
            edd[3] = vdd.findViewById(R.id.addnum3);
            edd[4] = vdd.findViewById(R.id.addnum4);
            edd[5] = vdd.findViewById(R.id.addnum5);
            edd[6] = vdd.findViewById(R.id.addnum6);
            edd[7] = vdd.findViewById(R.id.addnum7);
            edd[8] = vdd.findViewById(R.id.addnum8);

            for(int i = 0; i < 9; i++)
                value[i] = edd[i].getText().toString();
            editorA[0].putString("saveText0", value[0]);
            editorA[1].putString("saveText1", value[1]);
            editorA[2].putString("saveText2", value[2]);
            editorA[3].putString("saveText3", value[3]);
            editorA[4].putString("saveText4", value[4]);
            editorA[5].putString("saveText5", value[5]);
            editorA[6].putString("saveText6", value[6]);
            editorA[7].putString("saveText7", value[7]);
            editorA[8].putString("saveText8", value[8]);
            for(int i = 0; i < 9; i++)
                editorA[i].commit();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.auto_save && !as) {
            item.setIcon(R.drawable.hm);
            as = true;
//            Toast.makeText(this, "최근 내용 자동 저장 활성화", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "최근 기록 불러오기 활성화", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.auto_save && as) {
            item.setIcon(R.drawable.pik);
            as = false;
            Toast.makeText(this, "최근 기록 불러오기 비활성화", Toast.LENGTH_SHORT).show();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

    private void initLayout() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_launcher);

        drawerLayout = (DrawerLayout) findViewById(R.id.dl_main_drawer_root);
        navigationView = (NavigationView) findViewById(R.id.nv_main_navigation_root);
        drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close
        );
        drawerLayout.addDrawerListener(drawerToggle);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}