package rrs.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rrs.dao.SettingsDAO;
import rrs.exceptions.AppException;
import rrs.model.Settings;

@Path("/settings")
public class SettingsController {

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse getAll() {

		AppResponse resp = new AppResponse();

		try {
			SettingsDAO dao = new SettingsDAO();
			List<Settings> empList = dao.getAll();
			resp.setPayload(empList);
		} catch (AppException e) {
			e.printStackTrace();
			resp.setStatus(AppResponse.ERROR);
			resp.setMessage(e.getMessage());
		}
		return resp;
	}

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse addSettings(Settings emp) {
		AppResponse resp = new AppResponse();

		try {
			SettingsDAO dao = new SettingsDAO();
			emp = dao.updateSettings(emp);
			resp.setMessage("Settings has been updated");
			resp.setPayload(emp);
		} catch (AppException e) {
			e.printStackTrace();
			resp.setStatus(AppResponse.ERROR);
			resp.setMessage(e.getMessage());
		}
		return resp;
	}
}
