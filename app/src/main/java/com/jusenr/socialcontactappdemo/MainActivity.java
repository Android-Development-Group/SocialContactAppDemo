package com.jusenr.socialcontactappdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.widget.ImageView;

import com.jusenr.socialcontactappdemo.controller.ActivityManager;
import com.jusenr.socialcontactappdemo.controller.BasicFragmentActivity;
import com.jusenr.socialcontactappdemo.view.select.TabBar;
import com.jusenr.socialcontactappdemo.view.select.TabItem;

import static com.jusenr.socialcontactappdemo.R.id.tb_index_tab;
import static com.jusenr.socialcontactappdemo.R.id.vp_content;

public class MainActivity extends BasicFragmentActivity<BasicApplication> {
    public static final String EVENT_SHOW_BLUR_VIEW = "EVENT_SHOW_BLUR_VIEW";
    public static final String TERMINAL_ACTIVITY = "terminal";
    public static boolean isNotRefreshUserInfo = false;
    public static int i = 1;

    private TabBar mTb_index_tab;
    private TabItem mTi_index_companion;
    private TabItem mTi_index_store;
    private TabItem mTi_index_discovery;
    private TabItem mTi_index_me;
    private ViewPager mVp_content;
    private ImageView mIvBlur;

    private SparseArray<Fragment> mFragments;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewCreatedFinish(Bundle saveInstanceState) {
        mTb_index_tab = (TabBar) findViewById(tb_index_tab);
        mTi_index_companion = (TabItem) findViewById(R.id.ti_index_companion);
        mTi_index_store = (TabItem) findViewById(R.id.ti_index_store);
        mTi_index_discovery = (TabItem) findViewById(R.id.ti_index_discovery);
        mTi_index_me = (TabItem) findViewById(R.id.ti_index_me);
        mVp_content = (ViewPager) findViewById(vp_content);
        mIvBlur = (ImageView) findViewById(R.id.ivBlur);



        addFragments();

        ActivityManager.getInstance().popOtherActivity(MainActivity.class);

        checkoutTerminalClass(getIntent());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * 添加Fragment
     */
    private void addFragments() {
        mFragments = new SparseArray<>();
        mFragments.put(0, Fragment.instantiate(mContext, ItemFragment.class.getName()));//陪伴
        mFragments.put(1, Fragment.instantiate(mContext, ItemFragment.class.getName()));//产品
        mFragments.put(2, Fragment.instantiate(mContext, ItemFragment.class.getName()));//我
    }

    @Override
    protected String[] getRequestUrls() {
        return new String[0];
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        checkoutTerminalClass(intent);
    }

    private void checkoutTerminalClass(Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            Class terminalClass = (Class) bundle.getSerializable(TERMINAL_ACTIVITY);
            bundle.putSerializable(TERMINAL_ACTIVITY, null);
            if (terminalClass != null) {
                startActivity(terminalClass, bundle);
            }
        }
    }

    /**
     * 返回键
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            stopService(new Intent(GlobalApplication.ACTION_PUSH_SERVICE));
            return exit();
        }
        return super.onKeyDown(keyCode, event);
    }

}
