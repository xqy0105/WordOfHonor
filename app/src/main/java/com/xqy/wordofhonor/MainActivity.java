package com.xqy.wordofhonor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.google.gson.Gson;
import com.xqy.wordofhonor.bean.StarBean;
import com.xqy.wordofhonor.luckfrag.LuckFragment;
import com.xqy.wordofhonor.mefrag.MeFragment;
import com.xqy.wordofhonor.starfrag.StarFragment;
import com.xqy.wordofhonor.utils.AssetsUtils;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    RadioGroup mainRg;
    Fragment starFrag,luckFrag,meFrag;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainRg = findViewById(R.id.main_rg);
        mainRg.setOnCheckedChangeListener(this);
        StarBean infoBean = loadData();

        Bundle bundle = new Bundle();
        bundle.putSerializable("info",infoBean);
//        创建碎片对象
        starFrag = new StarFragment();
        starFrag.setArguments(bundle);
        luckFrag = new LuckFragment();
        luckFrag.setArguments(bundle);
        meFrag = new MeFragment();
        meFrag.setArguments(bundle);

        addFragmentPage();
    }

    private StarBean loadData() {
        String json = AssetsUtils.getJsonFromAssets(this,"xzcontent/xzcontent.json");
        Gson gson = new Gson();
        StarBean infoBean = gson.fromJson(json, StarBean.class);
        AssetsUtils.saveBitmapFromAssets(this,infoBean);
        return infoBean;
    }

    private void addFragmentPage() {
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
//        3.将四个Fragment统一的添加到布局当中
        transaction.add(R.id.main_layout_center,starFrag);
        transaction.add(R.id.main_layout_center,luckFrag);
        transaction.add(R.id.main_layout_center,meFrag);
//        4.隐藏后面的三个
        transaction.hide(luckFrag);
        transaction.hide(meFrag);
//        5.提交碎片改变后的事务
        transaction.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = manager.beginTransaction();
        switch (checkedId) {
            case R.id.main_rb_star:
                transaction.hide(luckFrag);
                transaction.hide(meFrag);
                transaction.show(starFrag);
                break;
            case R.id.main_rb_luck:
                transaction.hide(starFrag);
                transaction.hide(meFrag);
                transaction.show(luckFrag);
                break;
            case R.id.main_rb_me:
                transaction.hide(starFrag);
                transaction.hide(luckFrag);
                transaction.show(meFrag);
                break;
        }
        transaction.commit();
    }
}