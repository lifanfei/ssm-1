package com.elin4it.ssm.mapper;

import com.elin4it.ssm.pojo.SysUser;

import java.util.List;

/**
 * ���ݹ���ƽ̨�û�ģ��־ò�
 * Created by Administrator on 2016/8/31.
 */
public interface SysUserMapper {
    /**
     * ��������IDɾ���û�
     * @param yhId �û�ID
     * @return �Ƿ�ɹ�
     */
    boolean deleteByPrimaryKey(Integer yhId);

    /**
     * ����û�
     * @param record ����û�����Ϣ
     * @return �Ƿ�ɹ�
     */
    boolean insert(SysUser record);

    int insertSelective(SysUser record);

    /**
     * �����û�ID��ѯ�û�
     * @param yhId �û�ID
     * @return Ŀ���û���Ϣ
     */
    SysUser selectByPrimaryKey(Integer yhId);

    /**
     * ����ȫ���û�
     * @return �û��б�
     */
    List<SysUser> selectAll();

    /**
     * �����û��˻���ѯ�û�
     * @param yhzh �û��˻�
     * @return ��Ӧ�û���Ϣ
     */
    SysUser selectByYhzh(String yhzh);

    int updateByPrimaryKeySelective(SysUser record);

    /**
     * �����û�
     * @param record �����û�����Ϣ
     * @return �Ƿ�ɹ�
     */
    boolean updateByPrimaryKey(SysUser record);
}