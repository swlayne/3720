public class EditIssueRequest extends ProjectRequest {
	public int m_projectNumber;
	public String[] m_issue;
	
	public EditIssueRequest(int projectNumber, String[] issue) {
		m_projectNumber = projectNumber;
		m_issue = issue;
	}
}