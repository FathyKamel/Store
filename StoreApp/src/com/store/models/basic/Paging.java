package com.store.models.basic;

public class Paging {
	private int pageIndex;
	private int pageSize;
	private String sortType;

	public String getSortType() {
		return sortType;
	}
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	public Paging (int starty)
	{
		this.pageIndex= starty;
	}
	public Paging(String starty , String county) {
		//		if (starty != null && county != null) {
		try {
			pageIndex = Integer.parseInt(starty);
			pageSize = Integer.parseInt(county);
			if (pageIndex < 0 ) {
				pageIndex = 0;
			}
			if (pageSize < 1 || pageSize > 50) {
				pageSize = 1;
			}
		} catch (NumberFormatException ex) {
			//				throw new BadRequestException("invalid header param values");
			pageIndex = 0;
			pageSize = 1;
		}
	}/* else {
			throw new BadRequestException("missing paging header Params" );
		}*/
	//	}

	public Paging(int starty , int county) {
		this(""+starty, ""+county);
	}

	public boolean isEmpty() {
		return (pageSize == 0);
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
