package zl.management.controller.PatentResultsController;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zl.management.controller.ControllDeal;
import zl.management.controller.Controller;
import zl.management.dao.DAOFactory;
import zl.management.dao.imp.PatentResultsDaoImp;
import zl.management.domain.PatentResults;

public class ShowPatentResultsController implements Controller {
	private static PatentResultsDaoImp dao = DAOFactory.getPatentResultsDao();
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> params = ControllDeal.judgeIsFind(request, response);
		ControllDeal.showDomain(request, response, dao, PatentResults.class, params);
		return "/WEB-INF/jsp/patentResults/showPatentResults.jsp";
	}
}
