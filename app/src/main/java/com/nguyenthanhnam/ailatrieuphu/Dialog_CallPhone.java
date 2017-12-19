package com.nguyenthanhnam.ailatrieuphu;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Nam on 7/21/2016.
 */
public class Dialog_CallPhone extends Dialog implements View.OnClickListener {

    private LinearLayout mLnBacSy, mLnKySu, mLnGiaoVien, mLnPhongVien;
    private Context mContext;
    private int data;
    private Dialog mDiaLogSelect;
    private int mTrueCase;

    public Dialog_CallPhone(Context context, int trueCase) {
        super(context);
        mContext = context;
        mTrueCase = trueCase;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_hoichuyengia);

        setCanceledOnTouchOutside(false);
        setCancelable(false);

        findViewBys();
        init();
        setEvent();
    }

    private void findViewBys() {
        mLnBacSy = (LinearLayout) findViewById(R.id.ln_bacsy);
        mLnGiaoVien = (LinearLayout) findViewById(R.id.ln_giaovien);
        mLnKySu = (LinearLayout) findViewById(R.id.ln_kysu);
        mLnPhongVien = (LinearLayout) findViewById(R.id.ln_phongvien);
    }

    private void init() {

    }

    private void initDialogSelect(int image, String tenCG) {
        ImageView mImageCG;
        TextView mTxtName;
        TextView mTxtCauTl;
        Button mBtnClose;
        String dapAn[]={"A","B","C","D"};
        mDiaLogSelect = new Dialog(mContext, android.R.style.Theme_DeviceDefault_Dialog_NoActionBar_MinWidth);
        mDiaLogSelect.setContentView(R.layout.dialog_cautlcuachuyengia);
        mDiaLogSelect.show();

        mImageCG = (ImageView) mDiaLogSelect.findViewById(R.id.ima_cg_choose);
        mTxtName = (TextView) mDiaLogSelect.findViewById(R.id.tv_tenCG);
        mTxtCauTl = (TextView) mDiaLogSelect.findViewById(R.id.tvDapAn);
        mBtnClose = (Button) mDiaLogSelect.findViewById(R.id.btn_dongCG);

        mImageCG.setImageResource(image);
        mTxtName.setText(tenCG);
        mTxtCauTl.setText("Theo toi cau tra loi dung la:" + dapAn[mTrueCase-1]);
        mBtnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDiaLogSelect.dismiss();
            }
        });
    }

    private void setEvent() {
        mLnPhongVien.setOnClickListener(this);
        mLnKySu.setOnClickListener(this);
        mLnGiaoVien.setOnClickListener(this);
        mLnBacSy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ln_bacsy:
                this.dismiss();
                initDialogSelect(R.drawable.atp__activity_player_layout_help_call_bacsi,"Bac Sỹ");
                break;
            case R.id.ln_giaovien:
                dismiss();
                initDialogSelect(R.drawable.atp__activity_player_layout_help_call_giaovien,"Giao Viên");
                break;
            case R.id.ln_kysu:
                this.dismiss();
                initDialogSelect(R.drawable.atp__activity_player_layout_help_call_kysu,"Kỹ Sư");
                break;
            case R.id.ln_phongvien:
                this.dismiss();
                initDialogSelect(R.drawable.atp__activity_player_layout_help_call_phongvien,"Phóng Viên");
                break;

        }
    }
}
