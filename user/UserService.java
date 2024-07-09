package user;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final UserDAO dao = new UserDAO();
    private final List<Long> loggedUsers = new ArrayList<>(); // user의 key로 로그인 상태 관리

    public void signUp(User user){
        String userName = dao.save(user);
        System.out.println(userName + "님, 가입을 환영합니다. 로그인을 진행해주세요.");
    }

    public void signIn(User user) {
        User foundUser = dao.findUserByLoginId(user.getLoginId());
        if(foundUser != null && foundUser.getHalfBaked().equals(user.getHalfBaked())){
            System.out.println(user.getName() + "님, 로그인되었습니다.");
            loggedUsers.add(user.getId());
        }
        else System.out.println("로그인에 실패했습니다. 일치하는 회원 정보가 없습니다.");
    }

    public void logout(User user) {
        System.out.println(user.getName() + "님, 로그아웃되었습니다.");
        loggedUsers.remove(user.getId());
    }

    public void updateUser(User user) {
        System.out.println(dao.update(user));
    }

    public void leaveUser(User user) {
        logout(user);
        System.out.println(dao.delete(user));
    }

    public boolean isLoggedIn(User user){
        return loggedUsers.contains(user.getId());
    }
}
