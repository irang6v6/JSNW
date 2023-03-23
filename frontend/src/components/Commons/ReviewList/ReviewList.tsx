import React from "react";
import styles from "./ReviewList.module.css";
import CreateIcon from "@mui/icons-material/Create";
import ReviewListItem from "./ReviewListItem";

const reviewList = [
  {
    id: 1,
    ratings: 4,
    date: "2023.12.23",
    img: "https://picsum.photos/300/300/?random",
    explan: "드디어 먹어봄 진짜 레전드 존맛탱 담주에 또 해먹어야지~",
  },
  {
    id: 2,
    ratings: 1,
    date: "2023.12.23",
    img: "https://picsum.photos/300/300/?random",
    explan: "윽 별로",
  },
  {
    id: 3,
    ratings: 3,
    date: "2023.12.23",
    img: "https://picsum.photos/300/300/?random",
    explan: "드디어 먹어봄 진짜 레전드 존맛탱 담주에 또 해먹어야지~",
  },
];

const ReviewList = () => {
  return (
    <>
      <div className={`${styles[`title`]}`}>
        <h1>리뷰 모아보기</h1>
        <button>
          내 리뷰 작성하기
          <CreateIcon />
        </button>
      </div>
      {reviewList.map((review, index) => {
        return <ReviewListItem key={index} review={review}></ReviewListItem>;
      })}
    </>
  );
};

export default ReviewList;
