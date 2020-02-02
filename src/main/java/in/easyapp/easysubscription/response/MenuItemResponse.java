package in.easyapp.easysubscription.response;

import java.util.List;


public class MenuItemResponse implements EasyResponse {
	 private String menuId;
	    private String menuName;
	    private List<MenuItemResponse> subMenus;
	    private String sortDescn;
	    private String mainPageUrl;
	    private boolean isSDK;
	    private boolean isWidget;

	    public String getMenuId() {
	        return menuId;
	    }

	    public void setMenuId(String menuId) {
	        this.menuId = menuId;
	    }

	    public String getMenuName() {
	        return menuName;
	    }

	    public void setMenuName(String menuName) {
	        this.menuName = menuName;
	    }

	    public List<MenuItemResponse> getSubMenus() {
	        return subMenus;
	    }

	    public void setSubMenus(List<MenuItemResponse> subMenus) {
	        this.subMenus = subMenus;
	    }

	    public String getSortDescn() {
	        return sortDescn;
	    }

	    public void setSortDescn(String sortDescn) {
	        this.sortDescn = sortDescn;
	    }

	    public String getMainPageUrl() {
	        return mainPageUrl;
	    }

	    public void setMainPageUrl(String mainPageUrl) {
	        this.mainPageUrl = mainPageUrl;
	    }

	    public boolean isSDK() {
	        return isSDK;
	    }

	    public void setSDK(boolean SDK) {
	        isSDK = SDK;
	    }

	    public boolean isWidget() {
	        return isWidget;
	    }

	    public void setWidget(boolean widget) {
	        isWidget = widget;
	    }
	}
