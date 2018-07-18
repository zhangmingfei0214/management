package zl.management.controller.MeetingHost;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zl.management.controller.ControllDeal;
import zl.management.controller.Controller;
import zl.management.dao.DAOFactory;
import zl.management.dao.imp.MeetingHostDaoImp;
import zl.management.domain.MeetingHost;

public class ConfirmFindMeetingHostController implements Controller {
	private MeetingHostDaoImp dao = DAOFactory.getMeetingHostDao();
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String meetingName = "%" + request.getParameter("meetingName").trim() + "%";
		String theme = request.getParameter("theme").trim();
		String meetingPlace = request.getParameter("meetingPlace").trim();
		String meetingContact = request.getParameter("meetingContact").trim();
		
		Map<String, Object> params = new HashMap<String, Object> ();
		params.put("meetingName", meetingName);
		params.put("theme", theme);
		params.put("meetingPlace", meetingPlace);
		params.put("meetingContact", meetingContact);
		
		request.getSession().setAttribute("isFind", "1");
		request.getSession().setAttribute("findParams", params);
		ControllDeal.showDomain(request, response, dao, MeetingHost.class, params);
		return "/WEB-INF/jsp/meetingHost/showMeetingHost.jsp";
	}
}
