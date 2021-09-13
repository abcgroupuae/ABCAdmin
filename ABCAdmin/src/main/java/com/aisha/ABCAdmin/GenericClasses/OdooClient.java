package com.aisha.ABCAdmin.GenericClasses;



import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.springframework.stereotype.Component;

@Component
public class OdooClient {
	final static String url = "https://abcprojectwll.odoo.com",
            db = "abcprojectwll-abcqatar-production-116225",
      username = "deliverysajja@gmail.com",
      password = "abc123$";
	
	public static List<Object> OdooValuesFetching(int barcode) {
		try {
			final XmlRpcClient client = new XmlRpcClient();
			
			final XmlRpcClientConfigImpl common_config = new XmlRpcClientConfigImpl();
			common_config.setServerURL(
			    new URL(String.format("%s/xmlrpc/2/common", url)));
			 
			 int uid = (int)client.execute(
					    common_config, "authenticate", Arrays.asList(
					        db, username, password, Collections.emptyMap()));
			 final XmlRpcClient models = new XmlRpcClient(); 
			 models.setConfig(new XmlRpcClientConfigImpl() {/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

			{setServerURL(new URL(String.format("%s/xmlrpc/2/object", url)));}});
			 
			 return Arrays.asList((Object[])models.execute("execute_kw", Arrays.asList(
					    db, uid, password,
					    "product.product", "search_read",
					    Arrays.asList(Arrays.asList(
					    		Arrays.asList("barcode", "=", barcode))),
					    new HashMap() {/**
							 * 
							 */
							private static final long serialVersionUID = 1L;

						{
					        put("fields", Arrays.asList("id", "forecasted_qty", "name","default_code","product_brand_id"));
					        put("limit", 5);
					    }}
					)));
			
		}catch(XmlRpcException e) {
			System.out.println(e);
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		return Collections.emptyList();
		
	}

}
