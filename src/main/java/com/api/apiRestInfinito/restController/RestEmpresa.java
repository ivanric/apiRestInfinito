package com.api.apiRestInfinito.restController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.apiRestInfinito.service.IEmpresaService;

@RequestMapping(value={"/RestEmpresa"})
@RestController
public class RestEmpresa {
	
	@Autowired
	private IEmpresaService empresaService;
	
	@RequestMapping("/lista")
	public  Map<?, ?> lista()throws IOException{
		Map<String, Object> Data = new HashMap<String, Object>();

		try {
			List<?> lista=this.empresaService.ListEmpresas();
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
}
