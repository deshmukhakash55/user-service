package com.xperphile.userservice.constants;

public class UserConstants {

    public static final String USER_CONTROLLER_MAPPING = "/user";
    public static final String USER_MGMT_CONTROLLER_MAPPING = "/user/mgmt";
    public static final String USER_MSG_CONTROLLER_MAPPING = "/user/msg";

    public static final String ADD_USER = "/add";
    public static final String REMOVE_USER = "/remove/{id}";
    public static final String UPDATE_USER = "/update";
    public static final String GET_USER = "/get/{id}";
    public static final String SEARCH_USERS = "/search/{search_name}";

    public static final String FOLLOW_USER = "/follow";
    public static final String UNFOLLOW_USER = "/unfollow/{id}";
    public static final String GET_FOLLOWERS = "/followers/{user_id}";
    public static final String GET_FOLLOWINGS = "/followings/{follower_id}";
    public static final String BLOCK_USER = "/block/{user_id}/{block_id}";
    public static final String UNBLOCK_USER = "/unblock/{id}";
    public static final String GET_BLOCKED_USERS = "/get/blocked_users/{user_id}";

    public static final String ADD_USER_FAV = "/add/fav";
    public static final String REMOVE_USER_FAV = "/remove/fav";
    public static final String GET_USER_FAVS = "/get/favs/{user_id}";

    public static final String ADD_MSG = "/add";

    public static final String DELIMITER = ",";

    public static final String MESSAGE_TO_MAPPING_FILE = "message_to_mapping.json";
    public static final String USERMESSAGE_TO_FUNNELMESSAGE_FILE = "usermessage_to_funnelmessage.json";
    public static final String USERMESSAGE_TO_FUNNELMETHOD_FILE = "usermessage_to_funnelmethod.json";

}
