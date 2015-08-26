package rrs.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rrs.dao.ReservationDAO;
import rrs.exceptions.AppException;
import rrs.model.Reservation;

@Path("/reservations")
public class ReservationController {

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse getAll() {

		AppResponse resp = new AppResponse();

		try {
			ReservationDAO dao = new ReservationDAO();
			List<Reservation> empList = dao.getAll();
			resp.setPayload(empList);
		} catch (AppException e) {
			e.printStackTrace();
			resp.setStatus(AppResponse.ERROR);
			resp.setMessage(e.getMessage());
		}
		return resp;
	}

	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse getEmployee(@PathParam("id") int empId) {

		AppResponse resp = new AppResponse();

		try {
			ReservationDAO dao = new ReservationDAO();
			Reservation emp = dao.getReservation(empId);
			resp.setPayload(emp);
		} catch (AppException e) {
			e.printStackTrace();
			resp.setStatus(AppResponse.ERROR);
			resp.setMessage(e.getMessage());
		}
		return resp;
	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse addReservation(Reservation emp) {
		AppResponse resp = new AppResponse();

		try {
			ReservationDAO dao = new ReservationDAO();
			emp = dao.addReservation(emp);
			resp.setMessage("Reservation has been added to the system.");
			resp.setPayload(emp);
		} catch (AppException e) {
			e.printStackTrace();
			resp.setStatus(AppResponse.ERROR);
			resp.setMessage(e.getMessage());
		}
		return resp;
	}
	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse deleteReservation(Reservation emp) {
		AppResponse resp = new AppResponse();

		try {
			ReservationDAO dao = new ReservationDAO();
			emp = dao.deleteReservation(emp);
			resp.setMessage("Reservation has been deleted from the system.");
			resp.setPayload(emp);
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
	public AppResponse updateReservation(Reservation emp) {
		AppResponse resp = new AppResponse();

		try {
			ReservationDAO dao = new ReservationDAO();
			emp = dao.updateReservation(emp);
			resp.setMessage("Reservation has been update from the system.");
			resp.setPayload(emp);
		} catch (AppException e) {
			e.printStackTrace();
			resp.setStatus(AppResponse.ERROR);
			resp.setMessage(e.getMessage());
		}
		return resp;
	}		
}
