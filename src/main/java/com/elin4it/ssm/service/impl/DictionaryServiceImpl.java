package com.elin4it.ssm.service.impl;

import com.elin4it.ssm.mapper.DictionaryMapper;
import com.elin4it.ssm.pojo.Dictionary;
import com.elin4it.ssm.service.DictionaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ���ݹ���ƽ̨�ֵ�ģ��ҵ���ʵ����
 * Created by Administrator on 2016/9/1.
 */
@Service
public class DictionaryServiceImpl implements DictionaryService{
    @Resource
    private DictionaryMapper dictionaryMapper;

    /**
     * ��ѯ�ֵ�����
     * @return �ֵ������б�
     */
    public List<Dictionary> findDictionary() {
        return dictionaryMapper.selectDictionary();
    }
}
