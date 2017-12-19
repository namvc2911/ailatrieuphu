package com.nguyenthanhnam.ailatrieuphu;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

/**
 * Created by Nam on 7/19/2016.
 */
public class Fragment_Menu extends Fragment implements View.OnClickListener, Animation.AnimationListener {

    private Button btnBatDau, btnDiemCao, btnBinhChon, btnGameKhac;
    private Dialog_Confirm dialog_confirm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_menu_select, container, false);
        btnBatDau = (Button) rootView.findViewById(R.id.btnBatDau);
        btnDiemCao = (Button) rootView.findViewById(R.id.btnDiemCao);
        btnBinhChon = (Button) rootView.findViewById(R.id.btnBinhChon);
        btnGameKhac = (Button) rootView.findViewById(R.id.btnGạmeKhac);
        setEvent();
        initAnimation();
        return rootView;

    }

    private void setEvent() {
        btnBatDau.setOnClickListener(this);
        btnDiemCao.setOnClickListener(this);
        btnGameKhac.setOnClickListener(this);
        btnBinhChon.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.button_zoom_out);
        animation.setAnimationListener(this);
        switch (v.getId()) {
            case R.id.btnBatDau:
                btnBatDau.startAnimation(animation);
              //  hideButton();
                break;
            case R.id.btnDiemCao:
                break;
            case R.id.btnBinhChon:
                break;
            case R.id.btnGạmeKhac:
                break;
            default:
                break;
        }
    }

    private void initAnimation() {
        Animation animationLeft = AnimationUtils.loadAnimation(getActivity(), R.anim.anim_button_menu_left_start);
        btnBatDau.startAnimation(animationLeft);
        btnBinhChon.startAnimation(animationLeft);

        Animation animationRight = AnimationUtils.loadAnimation(getActivity(), R.anim.anim_button_menu_right_start);
        btnDiemCao.startAnimation(animationRight);
        btnGameKhac.startAnimation(animationRight);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        MainActivity activity=(MainActivity) getActivity();
        dialog_confirm = new Dialog_Confirm(activity);
        dialog_confirm.show();


    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
