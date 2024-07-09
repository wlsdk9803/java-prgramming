package user;

public class User {
    private long id;
    private String loginId;
    private String halfBaked; // password
    private String name;

    public User(){}

    public User(String loginId, String halfBaked, String name){
        if (loginId.isEmpty() || halfBaked.isEmpty() || name.isEmpty()) {
            throw new IllegalArgumentException("아이디, 비밀번호, 이름은 모두 필수 입력 사항입니다.");
        }
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

}
