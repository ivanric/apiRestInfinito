package com.api.apiRestInfinito.restController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.apiRestInfinito.model.AuthenticationResponse;
import com.api.apiRestInfinito.model.SolicitudItem;
import com.api.apiRestInfinito.service.ISolicitudItemService;

@RequestMapping(value={"/RestSolicitudes"})
@RestController
public class RestSolicitudes {
	
	@Autowired
	private ISolicitudItemService solicitudItemService;
	
	@RequestMapping("/lista1")
	public  Map<?, ?> lista1()throws IOException{
		Map<String, Object> Data = new HashMap<String, Object>();

		try {
			List<SolicitudItem> lista=this.solicitudItemService.getListSolicitudItems();
			Data.put("error", false);
			Data.put("message","Solicitud Completada");
			Data.put("contenido", lista);
		} catch (Exception e) {
			Data.put("error", true);
			Data.put("message","No se pudo completar la transacción");
			Data.put("contenido", null);
		}
		return Data;

	}
	@RequestMapping("/lista")
	public   ResponseEntity<List<SolicitudItem>> lista()throws IOException{
		List<SolicitudItem> lista;
		try {
			lista=this.solicitudItemService.getListSolicitudItems();

		} catch (Exception e) {
			lista=null;
		}
		return new ResponseEntity<List<SolicitudItem>>(lista, HttpStatus.OK);
	}
}
