package com.nguyenthanhnam.ailatrieuphu;

import android.app.Dialog;
import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Nam on 7/29/2016.
 */
public class Dialog_Audience extends Dialog implements View.OnClickListener {
    private TextView mTxtPhanTramA, mTxtPhanTramB, mTxtPhanTramC, mTxtPhanTramD;
    private TextView mTxtCotA, mTxtCotB, mTxtCotC, mTxtCotD;
    private TextView[] mArrColum;
    private TextView[] mArrPercent;
    private int mTrueCase;
    private Context mContext;
    private CountDownTimer timer;
    private int index1, index2, index3, index4;
    private int valuePercent1, valuePercent2, valuePercent3, valuePercent4;
    private Button mBtnDong;

    public Dialog_Audience(Context context, int trueCase) {
        super(context);
        mContext = context;
        mTrueCase = trueCase;

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_audience);

        setCancelable(false);
        setCanceledOnTouchOutside(false);

        findViewBys();
        init();
        setEvent();
    }

    private void findViewBys() {
        mTxtPhanTramA = (TextView) findViewById(R.id.txt_phantramA);
        mTxtPhanTramB = (TextView) findViewById(R.id.txt_phantramB);
        mTxtPhanTramC = (TextView) findViewById(R.id.txt_phantramC);
        mTxtPhanTramD = (TextView) findViewById(R.id.txt_phantramD);

        mTxtCotA = (TextView) findViewById(R.id.txt_cotA);
        mTxtCotB = (TextView) findViewById(R.id.txt_cotB);
        mTxtCotC = (TextView) findViewById(R.id.txt_cotC);
        mTxtCotD = (TextView) findViewById(R.id.txt_cotD);

        mArrColum = new TextView[]{mTxtCotA, mTxtCotB, mTxtCotC, mTxtCotD};
        mArrPercent = new TextView[]{mTxtPhanTramA, mTxtPhanTramB, mTxtPhanTramC, mTxtPhanTramD};

        mBtnDong = (Button) findViewById(R.id.btn_dongKG);
    }

    private void init() {
        Random random = new Random();
        index1 = mTrueCase - 1;
        valuePercent1 = random.nextInt(30) + 50;
        int so1 = 100 - valuePercent1 - 20;
        valuePercent2 = random.nextInt(so1)+10;

        int so2 = 100 - (valuePercent1 + valuePercent2)-10;
        valuePercent3 = random.nextInt(so2)+10;

        valuePercent4 = 100-(valuePercent1+valuePercent2+valuePercent3);
        int[] timVT2 = new int[3];
        if (index1 == 0) {
            timVT2[0] = 1;
            timVT2[1] = 2;
            timVT2[2] = 3;
        } else if (index1 == 1) {
            timVT2[0] = 0;
            timVT2[1] = 2;
            timVT2[2] = 3;
        } else if (index1 == 2) {
            timVT2[0] = 0;
            timVT2[1] = 1;
            timVT2[2] = 3;
        } else if (index1 == 3) {
            timVT2[0] = 0;
            timVT2[1] = 1;
            timVT2[2] = 2;
        }
        index2 = timVT2[random.nextInt(3)];

        for (int i = 0; i < 4; i++) {
            if (i != index1 && i != index2) {
                index3 = i;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (i != index1 && i != index2 && i != index3) {
                index4 = i;
            }
        }

        timer = new CountDownTimer(10000, 1) {
            int count = 0;

            @Override
            public void onTick(long millisUntilFinished) {
                count++;
                if (count <= valuePercent1) {
                    if (valuePercent1 != 0) {
                        mArrPercent[index1].setText(count + "%");
                        mArrPercent[index1].setPadding(0, 0, 0, count + 50);
                        mArrColum[index1].setPadding(0, 0, 0, count + 10);
                    } else {
                        mArrPercent[index1].setText(0 + "%");
                        mArrColum[index1].setPadding(0, 0, 0, -50);
                    }

                }
                if (count <= valuePercent2) {
                    if (valuePercent2 != 0) {
                        mArrPercent[index2].setText(count + "%");
                        mArrPercent[index2].setPadding(0, 0, 0, count + 50);
                        mArrColum[index2].setPadding(0, 0, 0, count + 10);
                    } else {
                        mArrPercent[index2].setText(0 + "%");
                        mArrColum[index2].setPadding(0,0,0,-50);
                    }

                }

                if (count <= valuePercent3) {
                    if (valuePercent3 != 0) {
                        mArrPercent[index3].setText(count + "%");
                        mArrPercent[index3].setPadding(0,0,0,count+50);
                        mArrColum[index3].setPadding(0,0,0,count + 10);
                    } else {
                        mArrPercent[index3].setText(0 + "%");
                        mArrColum[index3].setPadding(0, 0, 0,-50);
                    }

                }
                if (count <= valuePercent4) {
                    if (valuePercent1 != 0) {
                        mArrPercent[index4].setText(count + "%");
                        mArrPercent[index4].setPadding(0, 0, 0, count + 50);
                        mArrColum[index4].setPadding(0, 0, 0, count + 10);
                    } else {
                        mArrPercent[index4].setText(0+"%");
                        mArrColum[index4].setPadding(0, 0,0, -50);
                    }

                }

            }

            @Override
            public void onFinish() {

            }
        };
        timer.start();
    }

    private void setEvent() {
        mBtnDong.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.dismiss();
    }
}
