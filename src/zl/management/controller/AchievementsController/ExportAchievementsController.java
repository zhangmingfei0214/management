package zl.management.controller.AchievementsController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zl.management.controller.ControllDeal;
import zl.management.controller.Controller;
import zl.management.dao.DAOFactory;
import zl.management.dao.imp.AchievementsDaoImp;
import zl.management.domain.Achievements;

public class ExportAchievementsController implements Controller {
	private static AchievementsDaoImp dao = DAOFactory.getAchievementsDao();

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String[] headers = { "著作名称", "第一作者类型", "第一作者", "所属单位", "教研室", "参编作者", "第一作者职工号", "出版单位", "出版单位类型", "出版时间",
				"出版地", "著作类别", "学科门类", "一级学科", "项目来源", "总字数", "是否译成外文", "学校署名", "语种", "ISBN号", "简介", "审核状态" };
		String fileName = "著作成果一览表";
		ControllDeal.exportExcel(request, response, dao, fileName, Achievements.class, headers);
		return null;
	}

}
