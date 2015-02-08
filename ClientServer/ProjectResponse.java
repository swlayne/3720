public class ProjectResponse {

	  protected boolean isSuccess;

	  protected String errorMsg;
	  
	  public ProjectResponse() {
	    isSuccess = true;
	  }
	  
	  public ProjectResponse(String errorMsg) {
	    isSuccess = false;
	    this.errorMsg = errorMsg;
	  }
	  
	  public boolean isSuccess() {
	    return isSuccess;
	  }
	  
	  public void setSuccess(boolean isSuccess) {
	    this.isSuccess = isSuccess;
	  }
	  
	  public String getErrorMsg() {
	    return errorMsg;
	  }
	  
	  public void setErrorMsg(String errorMsg) {
	    this.errorMsg = errorMsg;
	  }	  
}
