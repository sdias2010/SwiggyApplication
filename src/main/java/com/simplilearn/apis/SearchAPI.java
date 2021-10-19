package com.simplilearn.apis;

public class SearchAPI {

    public static String getSearchApiUrl(String name){

        String searchRestaurantNameUrl = "https://www.swiggy.com/dapi/restaurants/search/v2_2?lat=28.6862738&lng=77.2217831&trackingId=ae7e6bd1-6d76-457b-baa2-213a65fdc938&str="+
               name +"&withMenuItems=true&sld=false&non_partner_search=false&submitAction=SUGGESTION&metadata={\"type\":\"suggestV1_tag_V1\",\"data\":{\"subType\":\"DISH\",\"vegIdentifier\":\"NA\",\"cloudinaryId\":\"isaihr9c3lyyf7ml7opi\",\"dishFamilyId\":\"846647\"}}";

//        String searchRestaurantNameUrl = "https://www.swiggy.com/dapi/restaurants/search/v2_2?lat=28.6862738&lng=77.2217831&trackingId=0610ace6-fa0c-3e2f-c64f-cfed41537606&str="+
//                name +"&withMenuItems=true&sld=false&non_partner_search=false&submitAction=ENTER";

        return searchRestaurantNameUrl;
    }

}
