package zl.management.controller.AttendMeetingController;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zl.management.controller.ControllDeal;
import zl.management.controller.Controller;
import zl.management.dao.DAOFactory;
import zl.management.dao.imp.AttendMeetingDaoImp;
import zl.management.domain.AttendMeeting;

public class DropAttendMeetingController implements Controller {
	private AttendMeetingDaoImp dao = DAOFactory.getAttendMeetingDao();

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String resultPath = "showAttendMeeting?pageNumber=" + request.getParameter("pageNumber") + "&jump=1";
		;
		ControllDeal.dropDomain(request, response, dao, AttendMeeting.class);
		try {
			response.sendRedirect(resultPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
