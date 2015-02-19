package com.xllapp.sdk;

import org.json.JSONObject;
import org.xllapp.sdk.core.ApiClient;
import org.xllapp.sdk.core.ApiResponse;
import org.xllapp.sdk.core.JsonPostApiRequest;
import org.xllapp.sdk.core.util.ToStringBuilder;

/**
 * 记录用户行为的请求.
 *
 * @author dylan.chen Nov 13, 2014
 *
 */
public class UserActionRequest extends JsonPostApiRequest {

	private UserAction[] actions;

	public UserActionRequest(ApiClient apiClient) {
		super(apiClient);
	}

	public UserAction[] getActions() {
		return this.actions;
	}

	public void setActions(UserAction[] actions) {
		this.actions = actions;
	}

	@Override
	public String getUri() {
		return "/xllapp-api-client/user-action-log";
	}

	@Override
	public String[] getSignItems() {
		return null;
	}

	@Override
	public ApiResponse<?> getResponse(JSONObject jsonObject) {
		return new UserActionResponse(jsonObject);
	}

	public static class UserActionResponse extends ApiResponse<Object> {

		public UserActionResponse(JSONObject jsonObject) {
			super(jsonObject);
		}

	}

	public static class UserAction {

		/**
		 * 动作类型
		 */
		private String actionType;

		/**
		 * 动作发生区域Id
		 */
		private String areaId;

		/**
		 * 动作目标的类型
		 */
		private String itemType;

		/**
		 * 动作目标的Id
		 */
		private String itemId;

		/**
		 * 动作目标的子Id
		 */
		private String subItemId;

		/**
		 * 动作说明
		 */
		private String description;

		/**
		 * 附件信息1
		 */
		private String field1;

		/**
		 * 附件信息2
		 */
		private String field2;

		/**
		 * 动作发生时间
		 */
		private String actionTime;

		public String getActionType() {
			return this.actionType;
		}

		public void setActionType(String actionType) {
			this.actionType = actionType;
		}

		public String getAreaId() {
			return this.areaId;
		}

		public void setAreaId(String areaId) {
			this.areaId = areaId;
		}

		public String getItemType() {
			return this.itemType;
		}

		public void setItemType(String itemType) {
			this.itemType = itemType;
		}

		public String getItemId() {
			return this.itemId;
		}

		public void setItemId(String itemId) {
			this.itemId = itemId;
		}

		public String getSubItemId() {
			return this.subItemId;
		}

		public void setSubItemId(String subItemId) {
			this.subItemId = subItemId;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getActionTime() {
			return this.actionTime;
		}

		public void setActionTime(String actionTime) {
			this.actionTime = actionTime;
		}

		public String getField1() {
			return this.field1;
		}

		public void setField1(String field1) {
			this.field1 = field1;
		}

		public String getField2() {
			return this.field2;
		}

		public void setField2(String field2) {
			this.field2 = field2;
		}

		@Override
		public String toString() {
			return ToStringBuilder.toString(this);
		}

	}

}
