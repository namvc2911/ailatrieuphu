package com.nguyenthanhnam.ailatrieuphu;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    private Fragment_PlayGame fragment_playGame;
    private Fragment_Menu fragment_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewBys();
        init();
        setEnvent();
    }

    private void findViewBys() {


    }

    private void init() {
        fragment_menu = new Fragment_Menu();
        fragment_playGame = new Fragment_PlayGame();


        showMenu_Fragment();
    }

    private void setEnvent() {

    }

    public void showMenu_Fragment() {
        getFragmentManager().beginTransaction()
                .replace(R.id.ln_act, fragment_menu).addToBackStack("One").commit();
    }

    public void showPlayGame_Fragment() {

        getFragmentManager().beginTransaction()
        .replace(R.id.ln_act, fragment_playGame).addToBackStack("Two").commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        new DataBaseManager(this).closeDB();
    }

}
