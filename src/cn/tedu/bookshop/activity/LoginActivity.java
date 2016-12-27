/**
 * Created by lijunjie on 2016年12月26日
 */
package cn.tedu.bookshop.activity;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import cn.tedu.bookshop.MyApplication;
import cn.tedu.bookshop.R;
import cn.tedu.bookshop.entity.User;
import cn.tedu.bookshop.presenter.ILoginPresenter;
import cn.tedu.bookshop.presenter.impl.LoginPresenterImpl;
import cn.tedu.bookshop.view.ILoginView;

/**
 * @author lijunjie
 *
 */
public class LoginActivity extends Activity implements ILoginView {
	
	@ViewInject(R.id.etLoginname)
	private EditText etLoginname;
	@ViewInject(R.id.etPwd)
	private EditText etPwd;
	@ViewInject(R.id.tvNewAccount)
	private TextView tvToRegist;
	@ViewInject(R.id.tvModifyPwd)
	private TextView tvModifyPwd;
	@ViewInject(R.id.btnLogin)
	private Button btnLogin;
	private ILoginPresenter presenter;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		//注入控件   初始化
		x.view().inject(this);
		
		setListener();
		
		presenter = new LoginPresenterImpl(this);
		
	}

	
	/**
	 * 
	 */
	private void setListener() {
		// TODO Auto-generated method stub
		LoginViewListener listener = new LoginViewListener();
		tvToRegist.setOnClickListener(listener);
		btnLogin.setOnClickListener(listener);
	}


	class LoginViewListener implements View.OnClickListener{
		public void onClick(View view) {
			switch (view.getId()){
				case R.id.tvNewAccount://新用户注册
					Intent i = new Intent(LoginActivity.this, RegistActivity.class);
					startActivity(i);
					break;
				case R.id.btnLogin:
					String name=etLoginname.getText().toString();
					String pwd=etPwd.getText().toString();
					if(name.equals("") || pwd.equals("")){
						Toast.makeText(LoginActivity.this,"请输入账号或密码",Toast.LENGTH_SHORT).show();
						return;
					}
					presenter.login(name, pwd);
					break;
			}
		}
	}


	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.view.ILoginView#loginSuccess()
	 */
	@Override
	public void loginSuccess() {
		// TODO Auto-generated method stub
		//User user = MyApplication.getApp().getCurrentUser();
		Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
		setResult(RESULT_OK);
		finish();
		
	}


	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.view.ILoginView#loginFailed(java.lang.String)
	 */
	@Override
	public void loginFailed(String errorMessage) {
		// TODO Auto-generated method stub
		Toast.makeText(this,errorMessage,Toast.LENGTH_SHORT).show();
	}

}
