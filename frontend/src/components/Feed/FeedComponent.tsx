import styles from "@/pages/Feed/FeedDetail.module.css";
import FavoriteBorderIcon from "@mui/icons-material/FavoriteBorder";
import FavoriteIcon from "@mui/icons-material/Favorite";
import { Grid, Card, CardContent, CardMedia, Typography } from "@mui/material";
import { Link } from "react-router-dom";
import { Dispatch, SetStateAction } from "react";

interface Feed {
  feed: {
    id: number;
    userName: string;
    userImg: string;
    classification: string;
    img: string;
    content: string;
    liked: boolean;
  };
  setDummyFeedList: Dispatch<
    SetStateAction<
      {
        id: number;
        userName: string;
        userImg: string;
        classification: string;
        img: string;
        content: string;
        liked: boolean;
      }[]
    >
  >;
}

const FeedComponent = ({ feed, setDummyFeedList }: Feed) => {
  return (
    <>
      {feed.classification === "게시글" ? (
        <Grid item key={feed.id} paddingBottom={1}>
          <Card style={{ backgroundColor: "inherit" }}>
            <Link to={`../details/feed/${feed.id}`}>
              <CardMedia component="img" height="auto" image={feed.img} alt={feed.userName} />
            </Link>
            <CardContent style={{ backgroundColor: `rgba(40, 40, 50, 0.7)`, padding: "2px" }}>
              <div className={`${styles[`user-profile-container`]}`} style={{ fontSize: "0.8rem", color: "white" }}>
                <div className={`${styles[`user-profile`]}`}>
                  <img src={feed.userImg} className={`${styles[`user-img`]}`}></img>
                  <p>{feed.userName}</p>
                </div>
                {feed.liked ? (
                  <button
                    style={{
                      color: "white",
                      background: "none",
                      border: "none",
                    }}
                    onClick={() => {
                      setDummyFeedList((prevList) =>
                        prevList.map((prevFeed) => {
                          if (prevFeed.id === feed.id) {
                            return { ...prevFeed, liked: !prevFeed.liked };
                          } else {
                            return prevFeed;
                          }
                        }),
                      );
                      // console.log(feed.liked);
                    }}
                  >
                    <FavoriteIcon sx={{ color: "red" }}></FavoriteIcon>
                  </button>
                ) : (
                  <button
                    style={{
                      color: "white",
                      background: "none",
                      border: "none",
                    }}
                    onClick={() => {
                      setDummyFeedList((prevList) =>
                        prevList.map((prevFeed) => {
                          if (prevFeed.id === feed.id) {
                            return { ...prevFeed, liked: !prevFeed.liked };
                          } else {
                            return prevFeed;
                          }
                        }),
                      );
                      // console.log(feed.liked);
                    }}
                  >
                    <FavoriteBorderIcon />
                  </button>
                )}
              </div>
              <Typography variant="body2" color="white" style={{ padding: "3% 5%" }}>
                {feed.content}
              </Typography>
            </CardContent>
          </Card>
        </Grid>
      ) : (
        <Grid item key={feed.id} paddingBottom={1}>
          <Link to={`../details/feed/${feed.id}`} style={{ textDecoration: "none" }}>
            <Card style={{ backgroundColor: "inherit" }}>
              <Link to={`../details/feed/${feed.id}`} style={{ textDecoration: "none" }}></Link>
              <CardContent style={{ backgroundColor: "#3D3D3D", padding: "2px" }}>
                <div className={`${styles[`user-profile-container`]}`} style={{ fontSize: "0.8rem", color: "white" }}>
                  <div className={`${styles[`user-profile`]}`}>
                    <img src={feed.userImg} className={`${styles[`user-img`]}`}></img>
                    <p>{feed.userName}</p>
                  </div>
                  {feed.liked ? (
                    <button
                      style={{
                        color: "white",
                        background: "none",
                        border: "none",
                      }}
                      onClick={() => {
                        setDummyFeedList((prevList) =>
                          prevList.map((prevFeed) => {
                            if (prevFeed.id === feed.id) {
                              return { ...prevFeed, liked: !prevFeed.liked };
                            } else {
                              return prevFeed;
                            }
                          }),
                        );
                        // console.log(feed.liked);
                      }}
                    >
                      <FavoriteIcon sx={{ color: "red" }}></FavoriteIcon>
                    </button>
                  ) : (
                    <button
                      style={{
                        color: "white",
                        background: "none",
                        border: "none",
                      }}
                      onClick={() => {
                        setDummyFeedList((prevList) =>
                          prevList.map((prevFeed) => {
                            if (prevFeed.id === feed.id) {
                              return { ...prevFeed, liked: !prevFeed.liked };
                            } else {
                              return prevFeed;
                            }
                          }),
                        );
                        // console.log(feed.liked);
                      }}
                    >
                      <FavoriteBorderIcon />
                    </button>
                  )}
                </div>
                <Typography variant="body2" color="white" style={{ padding: "3% 5%" }}>
                  {feed.content}
                </Typography>
              </CardContent>
            </Card>
          </Link>
        </Grid>
      )}
    </>
  );
};

export default FeedComponent;