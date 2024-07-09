package user;

import java.util.Scanner;

public class UserMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();

        User user = new User();

        boolean flag = true;
        while (flag) {
            System.out.println("1: 회원가입 / 2: 로그인 / 3: 회원정보 수정 / 4: 탈퇴 / 5: 로그아웃 / 0: 종료");
            System.out.print("입력: ");
            int choice = scanner.nextInt(); scanner.nextLine();
            String loginId = "";
            String halfBaked = "";
            String name = "";

            switch (choice) {
                case 1: // 회원가입
                    if(userService.isLoggedIn(user)){
                        System.out.println("로그인 된 유저는 회원가입을 진행할 수 없습니다.");
                        break;
                    }
                    System.out.print("아이디: ");
                    loginId = scanner.nextLine();

                    System.out.print("비밀번호: ");
                    halfBaked = scanner.nextLine();

                    System.out.print("이름: ");
                    name = scanner.nextLine();

                    user.setAll(loginId, halfBaked, name);
                    userService.signUp(user);
                    break;
                case 2: // 로그인
                    System.out.print("아이디: ");
                    loginId = scanner.nextLine();
                    user.setLoginId(loginId);

                    System.out.print("비밀번호: ");
                    halfBaked = scanner.nextLine();
                    user.setHalfBaked(halfBaked);

                    userService.signIn(user);
                    break;
                case 3: // 회원정보 수정
                    if(!userService.isLoggedIn(user)){
                        System.out.println("로그인을 먼저 해주세요.");
                        break;
                    }
                    System.out.print("비밀번호를 변경하시겠습니까? (y/n)");
                    String isChangeHalfBaked = scanner.nextLine();
                    if (isChangeHalfBaked.equals("y") || isChangeHalfBaked.equals("Y") ) {
                        System.out.print("새 비밀번호: ");
                        halfBaked = scanner.nextLine();
                        user.setHalfBaked(halfBaked);
                    }
                    System.out.print("이름을 변경하시겠습니까? (y/n)");
                    String isChangeName = scanner.nextLine();
                    if(isChangeName.equals("y") || isChangeName.equals(("Y"))){
                        System.out.print("새 이름: ");
                        name = scanner.nextLine();
                        user.setName(name);
                    }
                    userService.updateUser(user);
                    break;
                case 4: // 회원 탈퇴
                    if(!userService.isLoggedIn(user)){
                        System.out.println("로그인을 먼저 해주세요.");
                        break;
                    }
                    userService.leaveUser(user);
                    break;
                case 5: // 로그아웃
                    if(!userService.isLoggedIn(user)){
                        System.out.println("로그인이 되어 있지 않습니다.");
                        break;
                    }
                    userService.logout(user);
                    break;
                case 0:
                    flag = false;
                    System.out.println("종료합니다.");
                    break;
                default:
                    System.out.println("다시 입력해주세요.");
                    break;
            }
        }
    }
}
