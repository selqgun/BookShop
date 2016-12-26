package cn.tedu.bookshop.activity;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import cn.tedu.bookshop.R;
import cn.tedu.bookshop.entity.User;
import cn.tedu.bookshop.presenter.IRegistPresenter;
import cn.tedu.bookshop.presenter.impl.RegistPresenterImpl;
import cn.tedu.bookshop.view.IRegistView;

public class RegistActivity extends Activity implements IRegistView{

	@ViewInject(R.id.etLoginname)
	private EditText etLoginname;
	@ViewInject(R.id.etPwd)
	private EditText etPwd;
	@ViewInject(R.id.etRealname)
	private EditText etRealname;
	@ViewInject(R.id.etCode)
	private EditText etCode;
	@ViewInject(R.id.ivCode)
	private ImageView ivCode;
	
	private IRegistPresenter presenter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regist);
		
		x.view().inject(this);
		presenter = new RegistPresenterImpl(this);
		presenter.getCode();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.regist, menu);
		return true;
	}

	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.view.IRegistView#registSuccess()
	 */
	@Override
	public void registSuccess() {
		// TODO Auto-generated method stub
		Toast.makeText(this, "注册成功", Toast.LENGTH_LONG).show();
		finish();
		
	}

	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.view.IRegistView#registError(java.lang.String)
	 */
	@Override
	public void registError(String errorMessage) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "注册失败,"+errorMessage, Toast.LENGTH_SHORT).show();
	}

	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.view.IRegistView#showCodeImage(android.graphics.Bitmap)
	 */
	@Override
	public void showCodeImage(Bitmap bitmap) {
		// TODO Auto-generated method stub
		ivCode.setImageBitmap(bitmap);
	}
	
	
	public void regist(View view){
		User user = new User();
		String code = etCode.getText().toString();
		user.setEmail(etLoginname.getText().toString());
		user.setPassword(etPwd.getText().toString());
		user.setNickname(etRealname.getText().toString());
		presenter.regist(user , code);
	}

}
