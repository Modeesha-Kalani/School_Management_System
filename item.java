package add.item;

public class item {
	private int itemNo;
	private String itemname;
	private String itemcode;
	private String category;
	private String description;
	private String status;
	private String date;
	
	public item(int itemNo,String itemname, String itemcode, String category, String description, String status, String date) {
		
		this.itemNo=itemNo;
		this.itemname = itemname;
		this.itemcode = itemcode;
		this.category = category;
		this.description = description;
		this.status = status;
		this.date = date;
	}
	
	public int getItemNo() {
		return itemNo ;
	}

	public String getItemname() {
		return itemname;
	}

	

	public String getItemcode() {
		return itemcode;
	}

	
	public String getCategory() {
		return category;
	}

	
	public String getDescription() {
		return description;
	}

	
	public String getStatus() {
		return status;
	}

	

	public String getDate() {
		return date;
	}

	
	
	
	
	
	
	
	

}
