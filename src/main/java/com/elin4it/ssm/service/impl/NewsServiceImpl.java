package com.elin4it.ssm.service.impl;

import com.elin4it.ssm.mapper.NewsMapper;
import com.elin4it.ssm.pojo.News;
import com.elin4it.ssm.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ���ݹ���ƽ̨����ģ��ҵ���ʵ����
 * Created by Administrator on 2016/8/31.
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Resource
    private NewsMapper newsMapper;

    /**
     * �������
     *
     * @param news ��ӵ�������Ϣ
     * @return �Ƿ�ɹ�
     */
    public boolean addNews(News news) {
        if (newsMapper.insert(news))
            return true;
        return false;
    }

    /**
     * ��������IDɾ������
     *
     * @param newsId ����ID
     * @return �Ƿ�ɹ�
     */
    public boolean delNewsById(Integer newsId) {
        if (newsMapper.deleteByPrimaryKey(newsId))
            return true;
        return false;
    }

    /**
     * ��������
     *
     * @param news �������ŵ���Ϣ
     * @return �Ƿ�ɹ�
     */
    public boolean updateNews(News news) {
        if (newsMapper.updateByPrimaryKey(news))
            return true;
        else
            return false;
    }

    /**
     * ��������ID��ѯ����
     *
     * @param NewsId ����ID
     * @return Ŀ��������Ϣ
     */
    public News findNewsById(Integer NewsId) {
        return newsMapper.selectByPrimaryKey(NewsId);
    }

    /**
     * ��ѯȫ������
     * @return ȫ�������б�
     */
    public List<News> findAllNews() {
        List<News> news = newsMapper.selectAllNews();
        return news;
    }

    /**
     * ��������IDɾ������
     * @param NewsId ����ID
     * @return �Ƿ�ɹ�
     */
    public String findDetailById(Integer NewsId) {
        return newsMapper.selectDetailByPrimaryKey(NewsId);
    }

    /**
     * ����������Ŀ��ѯ����
     * @param newsProgram ������Ŀ
     * @return ��Ӧ�����б�
     */
    public List<News> findNewsByNewsProgram(String newsProgram) {
        List<News> news = newsMapper.selectNewsByNewsProgram(newsProgram);
        return news;
    }

    /**
     * �����������Ͳ�ѯ����
     * @param newsType ��������
     * @return ��Ӧ�����б�
     */
    public List<News> findNewsByNewsType(String newsType) {
        List<News> news = newsMapper.selectNewsByNewsType(newsType);
        return news;
    }
}

