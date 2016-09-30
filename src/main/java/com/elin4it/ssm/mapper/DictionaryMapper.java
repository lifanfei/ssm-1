package com.elin4it.ssm.mapper;

import com.elin4it.ssm.pojo.Dictionary;

import java.util.List;
/**
 * ���ݹ���ƽ̨�ֵ�ģ��־ò�
 * Created by Administrator on 2016/8/31.
 */
public interface DictionaryMapper {
    int deleteByPrimaryKey(Integer dictId);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    /**
     * ��ѯ�ֵ�����
     * @return �ֵ������б�
     */
    List<Dictionary> selectDictionary();

    Dictionary selectByPrimaryKey(Integer dictId);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);
}