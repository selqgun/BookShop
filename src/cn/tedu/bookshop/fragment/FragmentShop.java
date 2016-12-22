/**
 * Created by lijunjie on 2016年12月21日
 */
package cn.tedu.bookshop.fragment;

import java.util.List;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import cn.tedu.bookshop.R;
import cn.tedu.bookshop.activity.BookDetailActivity;
import cn.tedu.bookshop.adapter.StoreBookListAdapter;
import cn.tedu.bookshop.entity.Book;
import cn.tedu.bookshop.presenter.IStorePresenter;
import cn.tedu.bookshop.presenter.impl.StorePresenter;
import cn.tedu.bookshop.util.GlobalConsts;
import cn.tedu.bookshop.view.IStoreView;

/**
 * @author lijunjie
 *
 */
public class FragmentShop extends Fragment implements IStoreView{
	
	@ViewInject(R.id.etSearch)
	private EditText etSearch;
	@ViewInject(R.id.gvRecommend)
	private GridView gvRecommend;
	@ViewInject(R.id.gvNew)
	private GridView gvNew;
	@ViewInject(R.id.gvHot)
	private GridView gvHot;
	
	
	private IStorePresenter storePresenter;
	
	
	private List<Book> reCommendBooks;
	private StoreBookListAdapter recommendAdapter;

	private List<Book> hotBooks;
	private StoreBookListAdapter hotAdapter;

	private List<Book> newBooks;
	private StoreBookListAdapter newAdapter;
	
	
	public FragmentShop() {
		storePresenter = new StorePresenter(this);
	}
	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_shop, null);
		
		x.view().inject(this, view);
		//清除自动聚焦
		etSearch.clearFocus();
		storePresenter.loadBooks(GlobalConsts.BOOK_LIST_TYPE_RECOMMEND);
		storePresenter.loadBooks(GlobalConsts.BOOK_LIST_TYPE_HOT);
		storePresenter.loadBooks(GlobalConsts.BOOK_LIST_TYPE_NEW);
		
		//给gridView添加监听
		setListeners();
		return view;
	}
	/**
	 * 
	 */
	private void setListeners() {
		// TODO Auto-generated method stub
		gvRecommend.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int i, long arg3) {
				// TODO Auto-generated method stub
				Book book = reCommendBooks.get(i);
				Intent intent = new Intent(getActivity(), BookDetailActivity.class);
				intent.putExtra("book", book);
				startActivity(intent);
			}
		});
		
		gvNew.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int i, long arg3) {
				// TODO Auto-generated method stub
				Book book = newBooks.get(i);
				Intent intent = new Intent(getActivity(), BookDetailActivity.class);
				intent.putExtra("book", book);
				startActivity(intent);
			}
		});
		
		gvHot.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int i, long arg3) {
				// TODO Auto-generated method stub
				Book book = hotBooks.get(i);
				Intent intent = new Intent(getActivity(), BookDetailActivity.class);
				intent.putExtra("book", book);
				startActivity(intent);
			}
		});
	}
	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.view.IStoreView#updateBooksView(java.util.List, int)
	 */
	@Override
	public void updateBooksView(List<Book> books, int type) {
		// TODO Auto-generated method stub
		switch (type) {
		case GlobalConsts.BOOK_LIST_TYPE_RECOMMEND:
			
			this.reCommendBooks = books;
			recommendAdapter = new StoreBookListAdapter(getActivity(), this.reCommendBooks);
			gvRecommend.setAdapter(recommendAdapter);
			break;
		
		case GlobalConsts.BOOK_LIST_TYPE_HOT:
			
			this.hotBooks = books;
			hotAdapter = new StoreBookListAdapter(getActivity(), this.hotBooks);
			gvHot.setAdapter(hotAdapter);
			break;
		case GlobalConsts.BOOK_LIST_TYPE_NEW:
			
			this.newBooks = books;
			newAdapter = new StoreBookListAdapter(getActivity(), this.newBooks);
			gvNew.setAdapter(newAdapter);
			break;

		default:
			break;
		}
		
	}
	
	
}
