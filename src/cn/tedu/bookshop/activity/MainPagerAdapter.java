/**
 * Created by lijunjie on 2016年12月21日
 */
package cn.tedu.bookshop.activity;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * @author lijunjie
 *
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

	List<Fragment> fragments; 
	/**
	 * @param fm
	 */
	public MainPagerAdapter(FragmentManager fm,List<Fragment> fragments) {
		super(fm);
		this.fragments = fragments;
	}

	/* (non-Javadoc)
	 * @see android.support.v4.app.FragmentPagerAdapter#getItem(int)
	 */
	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return fragments.get(arg0);
	}

	/* (non-Javadoc)
	 * @see android.support.v4.view.PagerAdapter#getCount()
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return fragments.size();
	}

}
