package user;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final UserDAO dao = new UserDAO();
    private final List<String> loggedUsers = new ArrayList<>(); // user의 loginId로 로그인 상태 관리

    public void signUp(User user) {
        if (dao.findUserByLoginId(user.getLoginId()) != null) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }
        String userName = dao.save(user);
        System.out.println(userName + "님, 가입을 환영합니다. 로그인을 진행해주세요.");
    }

    public User signIn(String loginId, String halfBaked) {
        User foundUser = dao.findUserByLoginId(loginId);

        if(foundUser != null && halfBaked.equals(foundUser.getHalfBaked())){
            System.out.println(foundUser.getName() + "님, 로그인되었습니다.");
            loggedUsers.add(loginId);
            return foundUser;
        }
        else {
            throw new IllegalArgumentException("로그인에 실패했습니다. 일치하는 회원 정보가 없습니다.");
        }
    }

    public void logout(User user) {
        System.out.println(user.getName() + "님, 로그아웃되었습니다.");
        loggedUsers.remove(user.getLoginId());
    }

    public void updateUser(User user) {
        System.out.println(dao.update(user));
    }

    public void leaveUser(User user) {
        loggedUsers.remove(user.getLoginId());
        System.out.println(dao.delete(user));
    }

    public boolean isLoggedIn(User user){
        return loggedUsers.contains(user.getLoginId());
    }
}
