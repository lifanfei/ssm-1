package com.elin4it.ssm.controller;

import com.elin4it.ssm.pojo.News;
import com.elin4it.ssm.service.NewsService;
import com.elin4it.ssm.util.JSONResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * ���ݹ���ƽ̨����ģ����Ʋ�
 * Created by Administrator on 2016/8/31.
 */
@Controller
@RequestMapping("/**/news")
public class NewsController {
    @Resource
    private NewsService newsService;
    /**
     * �������
     *
     * @param request ������ӵ�������Ϣ
     * @return ��ӳɹ������Ϣ
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public JSONResult addNews(HttpServletRequest request) {
        JSONResult result;
        String NewsAuthor = request.getParameter("NewsAuthor");
        String NewsContent = request.getParameter("NewsContent");
        String NewsTitle = request.getParameter("NewsTitle");
        String NewsType = request.getParameter("NewsType");
        String NewsProgram = request.getParameter("NewsProgram");
        News news = new News();
        news.setNewsAuthor(NewsAuthor);
        news.setNewsContent(NewsContent);
        news.setNewsTitle(NewsTitle);
        news.setNewsType(NewsType);
        news.setNewsProgram(NewsProgram);
        if (newsService.addNews(news)) {
            result = new JSONResult(news);
            result.setMessage("sucess");
        } else
            result = new JSONResult();
        return result;
    }

    /**
     * ��������IDɾ������
     *
     * @param request Ŀ������ID
     * @return �ɹ������Ϣ
     */
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public JSONResult delNewsById(HttpServletRequest request) {
        JSONResult result = new JSONResult();
        int NewsId = Integer.parseInt(request.getParameter("NewsId"));
        if (!newsService.delNewsById(NewsId))
            result.setMessage("error");
        return result;
    }

    /**
     * ��������ID��������
     *
     * @param request Ŀ������ID
     * @return �ɹ������Ϣ
     */
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public JSONResult updateNews(HttpServletRequest request) {
        JSONResult result;
        int NewsId = Integer.parseInt(request.getParameter("NewsId"));
        String NewsAuthor = request.getParameter("NewsAuthor");
        String NewsContent = request.getParameter("NewsContent");
        String NewsTitle = request.getParameter("NewsTitle");
        String NewsType = request.getParameter("NewsType");
        String NewsProgram = request.getParameter("NewsProgram");
        News news = new News();
        news.setNewsId(NewsId);
        news.setNewsAuthor(NewsAuthor);
        news.setNewsContent(NewsContent);
        news.setNewsTitle(NewsTitle);
        news.setNewsType(NewsType);
        news.setNewsProgram(NewsProgram);
        if (newsService.updateNews(news)) {
            result = new JSONResult(news);
            result.setMessage("success");
        } else {
            result = new JSONResult();
            result.setMessage("error");
        }
        return result;
    }

    /**
     * ��������ID������ѯ����
     *
     * @param request Ŀ������ID
     * @return Ŀ��������Ϣ
     */
    @RequestMapping(value = "/findNewsById", method = RequestMethod.GET)
    @ResponseBody
    public JSONResult findNewsById(HttpServletRequest request) {
        JSONResult result;
        int NewsId = Integer.parseInt(request.getParameter("NewsId"));
        News news = newsService.findNewsById(NewsId);
        result = new JSONResult(news);
        return result;
    }

    /**
     * ����������Ŀ��ѯ����
     *
     * @param request ������Ŀ
     * @return ������Ŀ��Ӧ�������б�
     */
    @RequestMapping(value = "/findNewsByProgram", method = RequestMethod.GET)
    @ResponseBody
    public JSONResult findNewsByProgram(HttpServletRequest request) {
        String NewsProgram = request.getParameter("NewsProgram");
        List<News> news = newsService.findNewsByNewsProgram(NewsProgram);
        return new JSONResult(news);
    }

    /**
     * �����������Ͳ�ѯ����
     *
     * @param request ��������
     * @return �������Ͷ�Ӧ�������б�
     */
    @RequestMapping(value = "/findNewsByType", method = RequestMethod.GET)
    @ResponseBody
    public JSONResult findNewsByType(HttpServletRequest request) {
        String NewsType = request.getParameter("NewsType");
        List<News> news = newsService.findNewsByNewsType(NewsType);
        return new JSONResult(news);
    }

    /**
     * ��ѯ��������
     *
     * @return ���������б�
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public JSONResult findAllNews() {
        List<News> news = newsService.findAllNews();
        return new JSONResult(news);
    }

    /**
     * ��������ID��ѯ��������
     *
     * @param request ����ID
     * @return Ŀ����������
     */
    @RequestMapping(value = "/findDetail", method = RequestMethod.GET)
    @ResponseBody
    public JSONResult findDetail(HttpServletRequest request) {
        int NewsId = Integer.parseInt(request.getParameter("NewsId"));
        String newsContent = newsService.findDetailById(NewsId);
        return new JSONResult(newsContent);
    }


    /**
     * ��������δ����������
     *
     * @return �ɹ������Ϣ
     */
    @RequestMapping(value = "/publishNews", method = RequestMethod.PUT)
    @ResponseBody
    public JSONResult publishAllNews() {
        JSONResult result = new JSONResult();
        List<News> news = newsService.findAllNews();
        for (News news1 : news) {
            if (news1.getNewsStatus().equals("0")) {
                news1.setNewsStatus("1");
                newsService.updateNews(news1);
            }
        }
        result.setMessage("success");
        return result;
    }
}