import styles from "./DrinkDetail.module.css";
import { useParams } from "react-router-dom";
import Rating from "@mui/material/Rating";
import BookmarkBorderIcon from "@mui/icons-material/BookmarkBorder";
import Ingredients from "@/components/Commons/Ingredients/Ingredients";
import ReviewList from "@/components/Commons/ReviewList/ReviewList";

const DrinkDetail = () => {
  const params = useParams();

  const drink = {
    id: 1,
    type: "l6",
    user_id: 3,
    name: "달콤한와인",
    userName: "hojung",
    ratings: 4,
    userImg: "https://picsum.photos/30/30/?random",
    img: "https://picsum.photos/300/300/?random",
    writer: "스펩한이",
    ingredients: ["딸기", "소주", "사이다"],
    taste: ["단맛", "신맛", "쓴맛", "짠맛"],
    explan: "크렌베리 + 딸기향, 상큼달콤하지만 도수가 높음",
  };

  return (
    <>
      <div className={`${styles[`drink-img-box`]}`}>
        <img src={drink.img} className={`${styles[`drink-img`]}`}></img>
        {/* 일반 술이랑 공통 컴포로 쓰려면 업로드유저(user_id) 있는지 판별  */}
        {drink.user_id ? (
          <div className={`${styles[`user-profile-container-abs`]}`}>
            <div className={`${styles[`user-profile`]}`}>
              <img src={drink.userImg} className={`${styles[`user-img`]}`}></img>
              <p>{drink.userName}</p>
            </div>
          </div>
        ) : null}
      </div>
      <div className={`${styles[`drink-content-container`]}`}>
        <div className={`${styles[`drink-title-box`]}`}>
          <div className={`${styles[`drink-title`]}`}>
            <div>{drink.name}</div>
            <Rating name="read-only" value={drink.ratings} readOnly />
          </div>
          <BookmarkBorderIcon />
        </div>
        <Ingredients ingredients={drink.ingredients}></Ingredients>
        <Ingredients ingredients={drink.taste}></Ingredients>

        <p>{drink.explan}</p>
        <button className={`${styles[`drink-detail-content-btn`]}`}>더보기</button>
      <ReviewList></ReviewList>
      </div>
    </>
  );
};

export default DrinkDetail;