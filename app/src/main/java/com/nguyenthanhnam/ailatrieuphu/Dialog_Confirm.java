package com.nguyenthanhnam.ailatrieuphu;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by Nam on 7/18/2016.
 */
public class Dialog_Confirm extends Dialog implements View.OnClickListener {

    private Button mBtnCancel, mBtnOk;
    private LinearLayout lnSelect;
    private Context mContext;

    public Dialog_Confirm(Context context) {
        super(context);
        mContext = context;

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_confirm);

        setCanceledOnTouchOutside(false);
        setCancelable(false);

        findViewBys();
        init();
        setEvent();
    }

    private void findViewBys() {
        mBtnOk = (Button) findViewById(R.id.btnOK);
        mBtnCancel = (Button) findViewById(R.id.btnCancel);
        lnSelect = (LinearLayout) findViewById(R.id.ln_select);
    }

    private void init() {

    }

    private void setEvent() {
        mBtnOk.setOnClickListener(this);
        mBtnCancel.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnOK:
                showLayout((MainActivity)mContext);
                dismiss();
                break;
            case R.id.btnCancel:
               dismiss();
                break;
            default:
                break;
        }
    }

    private void showLayout(MainActivity activity) {
        activity.showPlayGame_Fragment();

    }

}
