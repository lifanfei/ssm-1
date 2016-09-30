package com.elin4it.ssm.mapper;

import com.elin4it.ssm.pojo.News;

import java.util.List;

/**
 * ���ݹ���ƽ̨����ģ��־ò�ӿ�
 * Created by Administrator on 2016/8/31.
 */
public interface NewsMapper {
    /**
     * �����û�IDɾ������
     *
     * @param newsId ����ID
     * @return�Ƿ�ɹ�
     */
    boolean deleteByPrimaryKey(Integer newsId);

    /**
     * �������
     *
     * @param record ������ŵ���Ϣ
     * @return�Ƿ�ɹ�
     */
    boolean insert(News record);

    int insertSelective(News record);

    /**
     * ��������ID��ѯ����
     * @param newsId ����ID
     * @return Ŀ��������Ϣ
     */
    News selectByPrimaryKey(Integer newsId);

    /**
     * ��ѯȫ������
     * @return ȫ�������б�
     */
    List<News> selectAllNews();

    int updateByPrimaryKeySelective(News record);

    /**
     * ��������
     * @param record �������ŵ���Ϣ
     * @return �Ƿ�ɹ�
     */
    boolean updateByPrimaryKey(News record);

    /**
     * ��������Id��ѯ��������
     * @param newsId ����ID
     * @return Ŀ��������������
     */
    String selectDetailByPrimaryKey(Integer newsId);

    /**
     * ����������Ŀ��ѯ����
     * @param newsProgram ������Ŀ
     * @return ��Ӧ�����б�
     */
    List<News> selectNewsByNewsProgram(String newsProgram);

    /**
     * �����������Ͳ�ѯ����
     * @param newsType ��������
     * @return ��Ӧ�����б�
     */
    List<News> selectNewsByNewsType(String newsType);
}