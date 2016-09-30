package com.elin4it.ssm.service.impl;

import com.elin4it.ssm.mapper.SysUserMapper;
import com.elin4it.ssm.pojo.SysUser;
import com.elin4it.ssm.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ���ݹ���ƽ̨�û�ģ��ҵ���ʵ����
 * Created by Administrator on 2016/8/31.
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper userMapper;

    /**
     * �����û�ID��ѯ�û�
     * @param yhId �û�ID
     * @return Ŀ���û���Ϣ
     * @throws Exception
     */
    public SysUser findUserById(Integer yhId) throws Exception {
        SysUser users = userMapper.selectByPrimaryKey(yhId);
        return users;
    }

    /**
     * ��ѯȫ���û�
     * @return ȫ���û��б�
     * @throws Exception
     */
    public List<SysUser> findAll() throws Exception {
        List<SysUser> users = userMapper.selectAll();
        return users;
    }

    /**
     * �����û��˻���ѯ�û�
     * @param yhzh �û��˻�
     * @return ��Ӧ�û���Ϣ
     */
    public SysUser findUserByYhzh(String yhzh) {
        SysUser users = userMapper.selectByYhzh(yhzh);
        return users;
    }

    /**
     * �����û�IDɾ���û�
     * @param yhId
     * @return �Ƿ�ɹ�
     */
    public boolean delUserById(Integer yhId) {
        if (userMapper.deleteByPrimaryKey(yhId))
            return true;
        else
            return false;
    }

    /**
     * ����û�
     * @param user ����û�����Ϣ
     * @return �Ƿ�ɹ�
     */
    public boolean addUser(SysUser user) {
        if (userMapper.insert(user))
            return true;
        else
            return false;
    }

    /**
     * �����û�
     * @param user ���µ��û�����Ϣ
     * @return �Ƿ�ɹ�
     */
    public boolean updateUser(SysUser user) {
        if (userMapper.updateByPrimaryKey(user))
            return true;
        else
            return false;
    }
}
