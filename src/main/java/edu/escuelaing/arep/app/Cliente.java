package edu.escuelaing.arep.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;

public class Cliente {

	public static void main(String[] args) throws IOException {
		

		URL miFachada = new URL("https://lit-crag-29952.herokuapp.com/results?numero=tan=45");

		URLConnection conexion = miFachada.openConnection();
		BufferedReader entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		BufferedReader ent = new BufferedReader(new InputStreamReader(System.in));
		
		String read;
		JSONObject conversion = new JSONObject();

		while ((read = entrada.readLine()) != null) {
			String res = read.replace("{\"El resultado de su operacion es\":", "").replace("}", "");
			conversion.put("El resultado de su operacion es", res);
		}
		System.out.println(conversion);
		entrada.close();
		ent.close();
	}

}