package zl.management.controller.ResearchReportController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zl.management.controller.ControllDeal;
import zl.management.controller.Controller;
import zl.management.dao.DAOFactory;
import zl.management.dao.imp.ResearchReportDaoImp;
import zl.management.domain.ResearchReport;

public class ExportResearchReportController implements Controller {
	private static ResearchReportDaoImp dao = DAOFactory.getResearchReportDao();

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String[] headers = { "备注", "报告题目", "第一作者类型", "第一作者", "所属单位", "单位类型", "采纳单位", "采纳时间", "是否被采纳", "合作单位", "转发成果",
				"学科门类", "一级学科", "项目来源", "教研室", "所有作者", "第一作者职工号", "学校署名", "字数", "审核状态" };
		String fileName = "研究报告一览表";
		ControllDeal.exportExcel(request, response, dao, fileName, ResearchReport.class, headers);
		return null;
	}

}
