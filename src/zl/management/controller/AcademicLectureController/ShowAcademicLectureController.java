package zl.management.controller.AcademicLectureController;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zl.management.controller.ControllDeal;
import zl.management.controller.Controller;
import zl.management.dao.DAOFactory;
import zl.management.dao.imp.AcademicLectureDaoImp;
import zl.management.domain.AcademicLecture;

public class ShowAcademicLectureController implements Controller {
	private static AcademicLectureDaoImp dao = DAOFactory.getAcademicLectureDao();
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> params = ControllDeal.judgeIsFind(request, response);
		ControllDeal.showDomain(request, response, dao, AcademicLecture.class, params);
		return "/WEB-INF/jsp/academicLecture/showAcademicLecture.jsp";
	}

}
