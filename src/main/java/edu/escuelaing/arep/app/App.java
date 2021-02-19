package edu.escuelaing.arep.app;

import java.io.*;
import java.net.*;
import spark.*;
import static spark.Spark.*;
import org.json.*;

public class App {
	public static void main(String[] args) {
		port(getPort());
		get("/", (req, res) -> inputDataPage(req, res));
		get("/results", (req, res) -> resultsPage(req, res));
	}

	private static String inputDataPage(Request req, Response res) {
		String pageContent = "<!DOCTYPE html>" + "<html>" + "<body>" + "<h2>BIENVENIDO A SERVICIO</h2>"
				+ "<form action=\"/results\">"
				+ "  Ingrese los valores a calcular como cos, sin, tan seguidos de '=' y el numero para realizar la operacion<br>"
				+ "  <input type=\"text\" name=\"numero\" >" + "  <br><br>"
				+ "  <input type=\"submit\" value=\"Submit\">" + "</form>" + "</body>" + "</html>";
		return pageContent;
	}

	private static JSONObject resultsPage(Request req, Response res) throws MalformedURLException, IOException {
		String[] listar = req.queryParams("numero").split("=");

		double number = Double.parseDouble(listar[1]);
		String query = "";

		if (listar[0].equals("cos"))query = "cos=" + number;// para presentar llegar bien al serivicio
		if (listar[0].equals("sin"))query = "sin=" + number;
		if (listar[0].equals("tan"))query = "tan=" + number;

		URL miServicio = new URL("https://limitless-headland-32240.herokuapp.com/results?numero=" + query);
		URLConnection conexion = miServicio.openConnection();

		BufferedReader entrada = null;
		entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		BufferedReader ent = new BufferedReader(new InputStreamReader(System.in));
		
		String read;
		JSONObject conversion = new JSONObject();

		while ((read = entrada.readLine()) != null) {
			String aux = read.replace("{\"El resultado de su operacion es\":", "").replace("}", "");
			conversion.put("El resultado de su operacion es", aux);
		}

		entrada.close();
		ent.close();
		res.header("Content-Type", "application/json");
		return conversion;
	}

	static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}

		return 4567; // returns default port if heroku-port isn't set(i.e. on localhost) }
	}
}