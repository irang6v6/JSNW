import styles from "./Logout.module.css";
import { useDispatch } from "react-redux";
import { useNavigate } from "react-router-dom";
import { removeCookieToken } from "@/utils/cookies";
import { loginUserActions } from "@/slices/loginUserSlice";

const Logout = () => {
  const navigate = useNavigate();
  const dispatch = useDispatch();

  const handleLogout = () => {
    console.log("로그아웃");
    // user Info 삭제
    // deleteInfo(userEmail).payload
    //     .then((res) => {
    //         const status = res.status
    //         if ( status === 200 ){
    //             // refresh 토큰 삭제

    // refresh token 삭제
    // removeCookieToken();
    // 유저정보 삭제
    dispatch(loginUserActions.deleteLoginUserInfo(null))

    alert("로그아웃 성공");
    // logout 시 login 창으로
    navigate("/");
    //         }
    //     })
    //     .catch((err) => {
    //         console.log(err)
    //         .catch((err) => alert(t('A network error has occurred. The request has failed.')));
    //     })
    // }
  };

  return (
    <div className={`${styles[`footer`]}`}>
      <div onClick={handleLogout}>로그아웃</div>
    </div>
  );
};

export default Logout;
