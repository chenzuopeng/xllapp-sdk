package com.xllapp.sdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;
import org.xllapp.sdk.core.ApiClient;
import org.xllapp.sdk.core.ApiResponse;
import org.xllapp.sdk.core.JsonPostApiRequest;

/**
 * 获取配置的请求.
 *
 * @author dylan.chen Nov 10, 2014
 *
 */
public class ConfigRequest extends JsonPostApiRequest{

	private String[] groups;

	private String[] keys;

	public ConfigRequest(ApiClient apiClient) {
		super(apiClient);
	}

	public String[] getGroups() {
		return groups;
	}

	public void setGroups(String[] groups) {
		this.groups = groups;
	}

	public String[] getKeys() {
		return keys;
	}

	public void setKeys(String[] keys) {
		this.keys = keys;
	}

	@Override
	public String getUri() {
		return "/xllapp-api-client/config";
	}

	@Override
	public String[] getSignItems() {
        List<String> items=new ArrayList<String>();
        items.add(getImsi());
        items.add(getImei());
        if(null != this.groups){
           items.addAll(Arrays.asList(this.getGroups()));
        }
        if(null != this.keys){
           items.addAll(Arrays.asList(this.getKeys()));
        }
		return items.toArray(new String[0]);
	}

	@Override
	public ApiResponse<?> getResponse(JSONObject jsonObject) {
		return new ConfigResponse(jsonObject);
	}

	public static class ConfigResponse extends ApiResponse<ConfigResponseData[]> {

		public ConfigResponse(JSONObject jsonObject) {
			super(jsonObject);
		}

	}

	public static class ConfigResponseData {

		private Integer id;

		private String group;

		private String key;

		private String value;

		public Integer getId() {
			return this.id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getGroup() {
			return this.group;
		}

		public void setGroup(String group) {
			this.group = group;
		}

		public String getKey() {
			return this.key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return this.value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

}
