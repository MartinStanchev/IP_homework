package bg.elsys.ip.rest;

import java.util.ArrayList;
import java.util.List;

public class PagedResponse {
	
	private List<Cars> data = new ArrayList<>();
	
	private int page;
	private int totalPages;
	
	
	public PagedResponse(List<Cars> data, int page, int totalPages) {
		this.data = data;
		this.page = page;
		this.totalPages = totalPages;
	}
	
	public List<Cars> getData() {
		return data;
	}
	public void setData(List<Cars> data) {
		this.data = data;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	
	

}
