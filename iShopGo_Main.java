package TC_WEB_ECOMMERCIAL;

/**
 * Created by Nam on 8/11/2018.
 */
public class iShopGo_Main {

    public static Client_Home client;
    public static Admin admin;
    public static CollectionManagement coll = new CollectionManagement();

    public static void main(String[] args)
    {
        //client.Home_Search();
        //client.AfterTest();

        admin.Admin_Management();
        admin.Admin_Access();
        admin.Admin_Login();
        for (int i = 0; i < coll.groupCategoryNames.length ; i++) {
            admin.Admin_Create_Group_Category(coll.groupCategoryNames[i]);
        }
        //admin.Admin_Create_Category();
        //admin.Admin_Create_Product();
        admin.Calculate_Time();
        //admin.AfterTest();
    }
}
