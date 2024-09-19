package SEP_Backend.SEP.dtos;

import java.util.Map;

import org.springframework.boot.json.BasicJsonParser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Reply {

	private Map<String,Object> session = null;
	private Object data = null;
	private boolean isAllowed = true;
	private String message; 
	private boolean errFlag = false;
	private String errMsg;
	
	public Reply(String userData) {
		this.session = (new BasicJsonParser()).parseMap(userData);
	}
	
	public Reply() {
		
	}
	
	public String getjsonStringFromMap() {
		try {
			return new ObjectMapper().writeValueAsString(session);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Object getAttribute(String key) {
		return session.get(key);
	}
	
	public void setAttribute(String key,Object value) {
		session.put(key,value);
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isAllowed() {
		return isAllowed;
	}

	public void setAllowed(boolean isAllowed) {
		this.isAllowed = isAllowed;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isErrFlag() {
		return errFlag;
	}

	public void setErrFlag(boolean errFlag) {
		this.errFlag = errFlag;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;	
	}

}
