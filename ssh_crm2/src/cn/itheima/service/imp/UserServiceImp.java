package cn.itheima.service.imp;

import cn.itheima.dao.UserDao;
import cn.itheima.domain.User;
import cn.itheima.service.UserService;

public class UserServiceImp implements UserService{

	private UserDao ud;
	
	@Override
	public User getUserByCodePassword(User u) {
			//1 ���ݵ�½���Ʋ�ѯ��½�û�
			User existU = ud.getByUserCode(u.getUser_code());
			//2 �ж��û��Ƿ����.������=>�׳��쳣,��ʾ�û���������
			if(existU==null){
				throw new RuntimeException("�û���������!");
			}
			//3 �ж��û������Ƿ���ȷ=>����ȷ=>�׳��쳣,��ʾ�������
			if(!existU.getUser_password().equals(u.getUser_password())){
				throw new RuntimeException("�������!");
			}
			//4 ���ز�ѯ�����û�����
		
		return existU;
	}

	@Override
	public void saveUser(User u) {
		ud.save(u);
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

}
