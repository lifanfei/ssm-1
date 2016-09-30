package com.elin4it.ssm.service;

import com.elin4it.ssm.pojo.News;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ���ݹ���ƽ̨�ֵ�ģ��ҵ���ӿ�
 * Created by Administrator on 2016/8/31.
 */
@Service
public interface NewsService {
    /**
     * ��������
     * @param news ��ӵ�������Ϣ
     * @return �Ƿ�ɹ�
     */
    boolean addNews(News news);

    /**
     * ����IDɾ������
     * @param newsId ����ID
     * @return �Ƿ�ɹ�
     */
    boolean delNewsById(Integer newsId);

    /**
     * ��������
     * @param news �������ŵ���Ϣ
     * @return �Ƿ�ɹ�
     */
    boolean updateNews(News news);

    /**
     * ����ID��ѯ����
     * @param newsId ����ID
     * @return Ŀ��������Ϣ
     */
    News findNewsById(Integer newsId);

    /**
     * ��ѯ��������
     * @return ���������б�
     */
    List<News> findAllNews();

    /**
     * ����ID��ѯ��������
     * @param newsId ����ID
     * @return Ŀ����������
     */
    String findDetailById(Integer newsId);

    /**
     * ����������Ŀ��ѯ����
     * @param newsProgram ������Ŀ
     * @return ��Ӧ�����б�
     */
    List<News> findNewsByNewsProgram(String newsProgram);

    /**
     * �����������Ͳ�ѯ����
     * @param newsType ��������
     * @return ��Ӧ�����б�
     */
    List<News> findNewsByNewsType(String newsType);
}
