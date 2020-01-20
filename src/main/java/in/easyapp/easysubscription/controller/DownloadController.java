package in.easyapp.easysubscription.controller;
import org.springframework.web.bind.annotation.*;

import in.easyapp.easysubscription.exception.AppServiceException;
import in.easyapp.easysubscription.response.MenuItemResponse;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class DownloadController {

    @RequestMapping(value = "/downloadMenus", method = RequestMethod.GET)
    public List<MenuItemResponse> getDownloadMenuItems(@RequestParam(name = "depth", defaultValue = "0") String depth){
        List<MenuItemResponse> menuItems = new ArrayList<MenuItemResponse>();
        MenuItemResponse menuItem1 = new MenuItemResponse();
        MenuItemResponse menuItem2 = new MenuItemResponse();

        menuItem1.setMenuName("Widgets");
        menuItem1.setMenuId("widget");
        menuItem1.setSDK(false);
        menuItem1.setWidget(false);
        menuItems.add(menuItem1);

        menuItem2.setMenuName("SDKs");
        menuItem2.setMenuId("sdk");
        menuItem2.setSDK(false);
        menuItem2.setWidget(false);
        menuItems.add(menuItem2);

        if(Integer.parseInt(depth) >0){
            List<MenuItemResponse> submenus1 = new ArrayList<>();
            menuItem1.setSubMenus(submenus1);

            MenuItemResponse menuItem1_1 = new MenuItemResponse();
            menuItem1_1.setMenuName("Chat Widget");
            menuItem1_1.setMenuId("cWidget");
            menuItem1_1.setSDK(false);
            menuItem1_1.setWidget(true);
            submenus1.add(menuItem1_1);

            MenuItemResponse menuItem1_2 = new MenuItemResponse();
            menuItem1_2.setMenuName("Message Widget");
            menuItem1_2.setMenuId("mWidget");
            menuItem1_2.setSDK(false);
            menuItem1_2.setWidget(true);
            submenus1.add(menuItem1_2);

            MenuItemResponse menuItem1_3 = new MenuItemResponse();
            menuItem1_3.setMenuName("Mail Widget");
            menuItem1_3.setMenuId("mlWidget");
            menuItem1_3.setSDK(false);
            menuItem1_3.setWidget(true);
            submenus1.add(menuItem1_3);

            List<MenuItemResponse> submenus2 = new ArrayList<>();
            menuItem2.setSubMenus(submenus2);

            MenuItemResponse menuItem2_1 = new MenuItemResponse();
            menuItem2_1.setMenuName("Message SDK");
            menuItem2_1.setMenuId("mSdk");
            menuItem2_1.setSDK(true);
            menuItem2_1.setWidget(false);
            submenus2.add(menuItem2_1);

            MenuItemResponse menuItem2_2 = new MenuItemResponse();
            menuItem2_2.setMenuName("Mail SDK");
            menuItem2_2.setMenuId("mlSdk");
            menuItem2_2.setSDK(true);
            menuItem2_2.setWidget(false);
            submenus2.add(menuItem2_2);
        }

        return menuItems;
    }

    @RequestMapping(value = "/downloadMenus/{menuId}", method = RequestMethod.GET)
    public MenuItemResponse getDownloadMenuItemById(@RequestParam(name = "depth", defaultValue = "0") String depth,
                                                  @PathVariable("menuId") String menuId){
        if(menuId.equals("widget")){
            MenuItemResponse menuItem1 = new MenuItemResponse();
            menuItem1.setMenuName("Widgets");
            menuItem1.setMenuId("widget");
            menuItem1.setSDK(false);
            menuItem1.setWidget(false);
            List<MenuItemResponse> submenus1 = new ArrayList<>();
            menuItem1.setSubMenus(submenus1);

            MenuItemResponse menuItem1_1 = new MenuItemResponse();
            menuItem1_1.setMenuName("Chat Widget");
            menuItem1_1.setMenuId("cWidget");
            menuItem1_1.setSDK(false);
            menuItem1_1.setWidget(true);
            submenus1.add(menuItem1_1);

            MenuItemResponse menuItem1_2 = new MenuItemResponse();
            menuItem1_2.setMenuName("Message Widget");
            menuItem1_2.setMenuId("mWidget");
            menuItem1_2.setSDK(false);
            menuItem1_2.setWidget(true);
            submenus1.add(menuItem1_2);

            MenuItemResponse menuItem1_3 = new MenuItemResponse();
            menuItem1_3.setMenuName("Mail Widget");
            menuItem1_3.setMenuId("mlWidget");
            menuItem1_3.setSDK(false);
            menuItem1_3.setWidget(true);
            submenus1.add(menuItem1_3);

            return menuItem1;
        }else if (menuId.equals("sdk")){
            MenuItemResponse menuItem2 = new MenuItemResponse();
            menuItem2.setMenuName("SDKs");
            menuItem2.setMenuId("sdk");
            menuItem2.setSDK(false);
            menuItem2.setWidget(false);
            List<MenuItemResponse> submenus2 = new ArrayList<>();
            menuItem2.setSubMenus(submenus2);

            MenuItemResponse menuItem2_1 = new MenuItemResponse();
            menuItem2_1.setMenuName("Message SDK");
            menuItem2_1.setMenuId("mSdk");
            menuItem2_1.setSDK(true);
            menuItem2_1.setWidget(false);
            submenus2.add(menuItem2_1);

            MenuItemResponse menuItem2_2 = new MenuItemResponse();
            menuItem2_2.setMenuName("Mail SDK");
            menuItem2_2.setMenuId("mlSdk");
            menuItem2_2.setSDK(true);
            menuItem2_2.setWidget(false);
            submenus2.add(menuItem2_2);

            return menuItem2;
        }else {
             throw new AppServiceException(404);
        }

    }

    @RequestMapping(value = "/downloadMenus/{menuId}/submenus", method = RequestMethod.GET)
    public List<MenuItemResponse> getSubMenusOfItemId(@RequestParam(name = "depth", defaultValue = "0") String depth,
                                              @PathVariable("menuId") String menuId){
        if(menuId.equals("widget")){
            List<MenuItemResponse> submenus1 = new ArrayList<>();

            MenuItemResponse menuItem1_1 = new MenuItemResponse();
            menuItem1_1.setMenuName("Chat Widget");
            menuItem1_1.setMenuId("cWidget");
            menuItem1_1.setSDK(false);
            menuItem1_1.setWidget(true);
            submenus1.add(menuItem1_1);

            MenuItemResponse menuItem1_2 = new MenuItemResponse();
            menuItem1_2.setMenuName("Message Widget");
            menuItem1_2.setMenuId("mWidget");
            menuItem1_2.setSDK(false);
            menuItem1_2.setWidget(true);
            submenus1.add(menuItem1_2);

            MenuItemResponse menuItem1_3 = new MenuItemResponse();
            menuItem1_3.setMenuName("Mail Widget");
            menuItem1_3.setMenuId("mlWidget");
            menuItem1_3.setSDK(false);
            menuItem1_3.setWidget(true);
            submenus1.add(menuItem1_3);

            return submenus1;
        }else if (menuId.equals("sdk")){
            List<MenuItemResponse> submenus2 = new ArrayList<>();

            MenuItemResponse menuItem2_1 = new MenuItemResponse();
            menuItem2_1.setMenuName("Message SDK");
            menuItem2_1.setMenuId("mSdk");
            menuItem2_1.setSDK(true);
            menuItem2_1.setWidget(false);
            submenus2.add(menuItem2_1);

            MenuItemResponse menuItem2_2 = new MenuItemResponse();
            menuItem2_2.setMenuName("Mail SDK");
            menuItem2_2.setMenuId("mlSdk");
            menuItem2_2.setSDK(true);
            menuItem2_2.setWidget(false);
            submenus2.add(menuItem2_2);

            return submenus2;
        }else {
            throw new AppServiceException(404);
        }
    }

    @RequestMapping(value = "/downloadMenus/{menuId}/submenus/{submenuId}", method = RequestMethod.GET)
    public MenuItemResponse getSubMenuById(@RequestParam(name = "depth", defaultValue = "0") String depth,
                                   @PathVariable("menuId") String menuId, @PathVariable("submenuId") String submenuId){
        if(menuId.equals("widget")){
            MenuItemResponse menuItem = new MenuItemResponse();
            menuItem.setSDK(false);
            menuItem.setWidget(true);

            switch (submenuId) {
                case "cWidget":
                    menuItem.setMenuName("Chat Widget");
                    menuItem.setMenuId("cWidget");
                    menuItem.setMainPageUrl("https://www.bitrix24.com/uses/free-chat-widget-for-website.php");
                    break;
                case "mWidget":
                    menuItem.setMenuName("Message Widget");
                    menuItem.setMenuId("mWidget");
                    menuItem.setMainPageUrl("https://apkpure.com/messaging-widget-messenger/com.abstractwombat.messengerwidget");
                    break;
                case "mlWidget":
                    menuItem.setMenuName("Mail Widget");
                    menuItem.setMenuId("mlWidget");
                    menuItem.setMainPageUrl("https://wordpress.org/plugins/icegram-rainmaker/");
                    break;
                default:
                    throw new AppServiceException(404);
            }
            return menuItem;
        }else if (menuId.equals("sdk")){
            MenuItemResponse menuItem = new MenuItemResponse();
            menuItem.setSDK(false);
            menuItem.setWidget(true);

            switch (submenuId) {
                case "mSdk":
                    menuItem.setMenuName("Message SDK");
                    menuItem.setMenuId("mSdk");
                    menuItem.setMainPageUrl("https://docs.sendbird.com/javascript?_ga=2.123955593.280754429.1573930539-1805070576.1573930539");
                    break;
                case "mlSdk":
                    menuItem.setMenuName("Mail SDK");
                    menuItem.setMenuId("mlSdk");
                    menuItem.setMainPageUrl("https://pepipost.com/features/email-api/");
                    break;
                default:
                    throw new AppServiceException(404);
            }
            return menuItem;
        }else {
            throw new AppServiceException(404);
        }
    }
}
