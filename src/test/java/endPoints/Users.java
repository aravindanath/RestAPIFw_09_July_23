package endPoints;

public class Users {



    public enum addUser_endPoint{
        ADD_USER_END_POINT("users");
        String value;
        addUser_endPoint(String users) {
            value = users;
        }
        public String toString(){
            return value;
        }
    }

    public enum getUserProfile_endPoint{
        GET_USER_PROFILE_END_POINT("users/me");
        String value;
        getUserProfile_endPoint(String users) {
            value = users;
        }
        public String toString(){
            return value;
        }
    }

    public enum updateUser_endPoint{
        UPDATE_USER__END_POINT("users/me");
        String value;
        updateUser_endPoint(String users) {
            value = users;
        }
        public String toString(){
            return value;
        }
    }

    public enum logOutUser_endPoint{
        LOG_OUT_USER_END_POINT("users/logout");
        String value;
        logOutUser_endPoint(String users) {
            value = users;
        }
        public String toString(){
            return value;
        }
    }

    public enum logInUser_endPoint{
        LOG_IN_USER_END_POINT("users/login");
        String value;
        logInUser_endPoint(String users) {
            value = users;
        }
        public String toString(){
            return value;
        }
    }

    public enum delUser_endPoint{
        DEL_USER_END_POINT("users/me");
        String value;
        delUser_endPoint(String users) {
            value = users;
        }
        public String toString(){
            return value;
        }
    }
}
