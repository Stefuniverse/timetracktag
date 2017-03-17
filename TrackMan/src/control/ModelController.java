package control;

import org.json.JSONObject;

public class ModelController {

	/**
	 * Method Stub for model
	 * @return project stub
	 */
	public static JSONObject getProjectsAsJson(){
		return new JSONObject("{\"Arbeit\":[\"Programmieren\",\"Kaffee holen\"], \"Freizeit\":[\"Zocken\"], \"Uni\":[]}");
	}

}
