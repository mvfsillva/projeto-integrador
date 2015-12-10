package org.doando.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.doando.entity.AddressEntity;
import org.json.JSONObject;

public class PostalCodeService {

	private static final String ERROR = "erro";
	private static final String COMPLEMENT = "complemento";
	private static final String STATE = "uf";
	private static final String CITY = "localidade";
	private static final String NEIGHBORHOOD = "bairro";
	private static final String STREET_NAME = "logradouro";
	private static final String POSTAL_CODE = "cep";
	private AddressEntity address;

	public PostalCodeService() {
		address = new AddressEntity();
	}

	public PostalCodeService(String cep) throws Exception {
		this.find(cep);
	}

	public final void find(String postalCode) throws Exception {

		String url = "http://viacep.com.br/ws/" + postalCode + "/json/";

		JSONObject obj = new JSONObject(this.get(url));

		if (!obj.has(ERROR)) {
			address.setPostalCode(obj.getString(POSTAL_CODE));
			address.setStreet(obj.getString(STREET_NAME));
			address.setComplement(obj.getString(COMPLEMENT));
			address.setNeighborhood(obj.getString(NEIGHBORHOOD));
			address.setCity(obj.getString(CITY));
			address.setState(obj.getString(STATE));
		} else {
			throw new Exception("Can not find the postal code");
		}
	}

	public AddressEntity getAddress() {
		return this.address;
	}

	public final String get(String urlToRead) throws Exception {
		StringBuilder result = new StringBuilder();

		try {
			URL url = new URL(urlToRead);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}

		} catch (MalformedURLException | ProtocolException ex) {
			throw new Exception(ex.getMessage());
		} catch (IOException ex) {
			throw new Exception(ex.getMessage());
		}

		return result.toString();
	}
}
