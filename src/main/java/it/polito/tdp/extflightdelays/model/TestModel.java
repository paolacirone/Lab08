package it.polito.tdp.extflightdelays.model;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();

		ExtFlightDelaysDAO dao = new ExtFlightDelaysDAO();

		// System.out.println(dao.loadAllAirports().size());
		model.creaGrafo(500);
		System.out.println(model.nVertici());
		System.out.println(model.nArchi());

	}

}
