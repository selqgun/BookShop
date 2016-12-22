package cn.tedu.bookshop.activity;

import java.util.ArrayList;
import java.util.List;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import cn.tedu.bookshop.R;
import cn.tedu.bookshop.fragment.FragmentCart;
import cn.tedu.bookshop.fragment.FragmentMy;
import cn.tedu.bookshop.fragment.FragmentShop;

public class MainActivity extends FragmentActivity {

	@ViewInject(R.id.viewPager)
	private ViewPager mViewPager;
	@ViewInject(R.id.rgGroup)
	private RadioGroup rgGroup;
	@ViewInject(R.id.rbShop)
	private RadioButton rbShop;
	@ViewInject(R.id.rbCart)
	private RadioButton rbCart;
	@ViewInject(R.id.rbMine)
	private RadioButton rbMine;
	
	private List<Fragment> fragments;
	private MainPagerAdapter pagerAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//xuitls注入
		x.view().inject(this);
		
		//设置adapter
		setAdapter();
		
		//设置监听
		setlistener();
		
	}

	/**
	 * 设置监听
	 */
	private void setlistener() {
		// TODO Auto-generated method stub
		rgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int i) {
				// TODO Auto-generated method stub
				switch (i) {
				case R.id.rbShop:
					rbShop.setTextColor(Color.WHITE);
					mViewPager.setCurrentItem(0);
					break;
				case R.id.rbCart:
					rbCart.setTextColor(Color.WHITE);
					mViewPager.setCurrentItem(1);
					break;
				case R.id.rbMine:
					rbMine.setTextColor(Color.WHITE);
					mViewPager.setCurrentItem(2);
					break;
				}
			}
		});
		
		mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int i) {
				// TODO Auto-generated method stub
				switch (i) {
				case 0:
					rbShop.setChecked(true);
					break;

				case 1:
					rbCart.setChecked(true);
					break;
					
				case 2:
					rbMine.setChecked(true);
					break;
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	/**
	 * 设置adapter
	 */
	private void setAdapter() {
		// TODO Auto-generated method stub
		fragments = new ArrayList<Fragment>();
		fragments.add(new FragmentShop());
		fragments.add(new FragmentCart());
		fragments.add(new FragmentMy());
		pagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), fragments);
		mViewPager.setAdapter(pagerAdapter);
		mViewPager.setOffscreenPageLimit(3);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
