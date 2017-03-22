package com.blanink.activity.order;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.view.NoScrollListview;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * 来单添加产品
 */
public class ComeOrderAddProductActivity extends AppCompatActivity {

    @BindView(R.id.come_order_detail_tv_seek)
    TextView comeOrderDetailTvSeek;
    @BindView(R.id.come_order_add_product_iv_last)
    ImageView comeOrderAddProductIvLast;
    @BindView(R.id.come_order_add_product_rl)
    RelativeLayout comeOrderAddProductRl;
    @BindView(R.id.tv_company_name)
    TextView tvCompanyName;
    @BindView(R.id.tv_order)
    TextView tvOrder;
    @BindView(R.id.tv_order_number)
    TextView tvOrderNumber;
    @BindView(R.id.come_order_add_product_rl_company)
    LinearLayout comeOrderAddProductRlCompany;
    @BindView(R.id.tv_customer)
    TextView tvCustomer;
    @BindView(R.id.come_order_add_product_sp_customer)
    Spinner comeOrderAddProductSpCustomer;
    @BindView(R.id.tv_zrr)
    TextView tvZrr;
    @BindView(R.id.edt_person_liable)
    EditText edtPersonLiable;
    @BindView(R.id.tv_priority)
    TextView tvPriority;
    @BindView(R.id.come_order_add_product_sp_priority)
    Spinner comeOrderAddProductSpPriority;
    @BindView(R.id.tv_number)
    TextView tvNumber;
    @BindView(R.id.edt_number)
    EditText edtNumber;
    @BindView(R.id.tv_hand_date)
    TextView tvHandDate;
    @BindView(R.id.tv_hand_date_time)
    TextView tvHandDateTime;
    @BindView(R.id.rl)
    RelativeLayout rl;
    @BindView(R.id.tv_same_order)
    TextView tvSameOrder;
    @BindView(R.id.rb_yes)
    RadioButton rbYes;
    @BindView(R.id.rb_no)
    RadioButton rbNo;
    @BindView(R.id.tv_product_no)
    TextView tvProductNo;
    @BindView(R.id.et_product_no)
    EditText etProductNo;
    @BindView(R.id.lv_guan_jian_zi)
    NoScrollListview lvGuanJianZi;
    @BindView(R.id.tv_note)
    TextView tvNote;
    @BindView(R.id.et_note)
    EditText etNote;
    @BindView(R.id.lv_other_product)
    NoScrollListview lvOtherProduct;
    @BindView(R.id.come_order_add_product_ll)
    LinearLayout comeOrderAddProductLl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_come_order_add_product);
        ButterKnife.bind(this);
    }
}
