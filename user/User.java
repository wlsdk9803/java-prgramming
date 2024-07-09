package user;

public class User {
    private long id;
    private String loginId;
    private String halfBaked; // password
    private String name;

    public User(){}

    public User(String loginId, String halfBaked, String name){
        this.loginId = loginId;
        this.halfBaked = halfBaked;
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setHalfBaked(String halfBaked) {
        this.halfBaked = halfBaked;
    }

    public String getHalfBaked() {
        return halfBaked;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAll(String loginId, String halfBaked, String name) {
        this.loginId = loginId;
        this.halfBaked = halfBaked;
        this.name = name;
    }
}
