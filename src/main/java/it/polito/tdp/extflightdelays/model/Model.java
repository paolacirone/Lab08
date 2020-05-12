package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {

	private SimpleWeightedGraph<Airport, DefaultWeightedEdge> grafo;
	private List<Airport> aereoporti;
	private ExtFlightDelaysDAO dao;
	private Map<Integer, Airport> idMap;

	public Model() {
		this.idMap = new HashMap<Integer, Airport>();
		dao = new ExtFlightDelaysDAO();
	    aereoporti= dao.loadAllAirports();
		//(idMap);
		//dao.loadAllAirports(idMap);
	}

	public void creaGrafo(int distanza) {

		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		// this.aereoporti= new ArrayList<>();

		for (Airport r : aereoporti) {
			idMap.put(r.getId(), r);
		}

		// aggiungo i vertici
	
		Graphs.addAllVertices(this.grafo, this.aereoporti);

		List<Rotta> rotte = dao.getRotte(idMap, distanza);

		for (Rotta r : rotte) {
			Graphs.addEdge(grafo, r.getP(), r.getA(), r.getPeso());
		}

	}

	public int nVertici() {
		return this.grafo.vertexSet().size();
	}

	public int nArchi() {
		return this.grafo.edgeSet().size();
	}

	public String rotte(int distanza) {
		String s = "";
		for(Rotta r: dao.getRotte(idMap, distanza)) {
			s+= r.toString()+ "\n";
		}
		return s;
	}
}
