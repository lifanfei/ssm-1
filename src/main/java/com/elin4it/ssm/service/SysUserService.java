package com.elin4it.ssm.service;

import com.elin4it.ssm.pojo.SysUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ���ݹ���ƽ���û�ģ��ҵ���ӿ�
 * Created by Administrator on 2016/8/25.
 */
@Service
public interface SysUserService {
    /**
     * �����û��˻���ѯ�û�
     * @param yhzh �û��˻�
     * @return ��Ӧ�û���Ϣ
     */
    SysUser findUserByYhzh(String yhzh) ;

    /**
     * �����û�ID��ѯ�û�
     * @param yhId �û�ID
     * @return ��Ӧ�û���Ϣ
     * @throws Exception
     */
    SysUser findUserById(Integer yhId)throws Exception;

    /**
     * ��ѯȫ���û�
     * @return �û��б�
     * @throws Exception
     */
    List<SysUser> findAll() throws Exception;

    /**
     * �����û�IDɾ���û�
     * @param yhid �û�ID
     * @return �Ƿ�ɹ�
     */
    boolean delUserById(Integer yhid);

    /**
     * ����û�
     * @param user ����û�����Ϣ
     * @return�Ƿ�ɹ�
     */
    boolean addUser(SysUser user);

    /**
     * �����û�
     * @param user ���µ��û�����Ϣ
     * @return �Ƿ�ɹ�
     */
    boolean updateUser(SysUser user);
}
