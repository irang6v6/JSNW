package com.osakak.jusangnakwon.domain.feed.api;

import com.osakak.jusangnakwon.common.response.ResponseDto;
import com.osakak.jusangnakwon.domain.feed.api.request.CreateCommentRequest;
import com.osakak.jusangnakwon.domain.feed.api.request.CreateFeedRequest;
import com.osakak.jusangnakwon.domain.feed.api.request.UpdateLikeRequest;
import com.osakak.jusangnakwon.domain.feed.application.FeedService;
import com.osakak.jusangnakwon.domain.feed.dto.CommentDto;
import com.osakak.jusangnakwon.domain.feed.dto.FeedDto;
import com.osakak.jusangnakwon.domain.feed.dto.RatingDto;
import com.osakak.jusangnakwon.domain.feed.mapper.FeedDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class FeedController {

    private final FeedService feedService;

    private final FeedDtoMapper feedDtoMapper = Mappers.getMapper(FeedDtoMapper.class);


    /**
     * [POST] /api/feed : 피드 작성
     *
     * @return FeedResponse : 작성된 피드 상세내용
     */
    @PostMapping("/api/feed/{id}")
    public ResponseEntity<ResponseDto> createFeed(@PathVariable Long id,
            @RequestBody @Valid CreateFeedRequest createFeedRequest) {
        FeedDto requestFeedDto = feedDtoMapper.createFeedRequestToFeedDto(createFeedRequest);
        RatingDto requestRatingDto = feedDtoMapper.createFeedRequestToRatingDto(createFeedRequest);
        FeedDto feedDto = feedService.createFeed(id, requestFeedDto, requestRatingDto);
        return ResponseEntity.ok(ResponseDto.builder().success(true)
                .body(feedDtoMapper.feedDtoToFeedResponse(feedDto)).build());
    }

    /**
     * [GET] /api/feed/list : 최신 피드 목록 조회 - 리뷰글과 질문글 모두
     *
     * @return 조회한 피드 목록
     */
    @GetMapping("/api/feed/list/{id}")
    public ResponseEntity<ResponseDto> getFeedList(@PathVariable Long id) {
        List<FeedDto> feeds = feedService.getFeedList(id);
        return ResponseEntity.ok(ResponseDto.builder().success(true)
                .body(feeds.stream().map(feedDtoMapper::feedDtoToFeedListResponse)
                        .collect(Collectors.toList())).build());
    }

    /**
     * [GET] /api/feed/list/{type} : 최신 피드 목록 필터링 조회 - 리뷰글만 or 질문글만
     *
     * @return 조회한 피드 목록
     */
    @GetMapping("/api/feed/list/{type}/{id}")
    public ResponseEntity<ResponseDto> getFeedListByType(@PathVariable Long id,
            @PathVariable String type) {
        List<FeedDto> feeds = feedService.getFeedListByType(id, type);
        return ResponseEntity.ok(ResponseDto.builder().success(true)
                .body(feeds.stream().map(feedDtoMapper::feedDtoToFeedListResponse)
                        .collect(Collectors.toList())).build());
    }

    /**
     * [GET] /api/feed/list/{type} : 피드 상세내용 조회
     *
     * @return FeedResponse : 조회한 피드 상세내용
     */
    @GetMapping("/api/feed/{feedId}/{id}")
    public ResponseEntity<ResponseDto> getFeedDetail(@PathVariable Long id,
            @PathVariable Long feedId) {
        FeedDto feedDto = feedService.getFeedDetail(id, feedId);
        return ResponseEntity.ok(ResponseDto.builder().success(true)
                .body(feedDtoMapper.feedDtoToFeedResponse(feedDto)).build());
    }

    /**
     * [POST] /api/comment : 댓글 작성
     *
     * @return 댓글이 작성된 피드의 전체 댓글목록
     */
    @PostMapping("/api/comment/{id}")
    public ResponseEntity<ResponseDto> createComment(@PathVariable Long id,
            @RequestBody @Valid CreateCommentRequest createCommentRequest) {
        CommentDto requestCommentDto = feedDtoMapper.createCommentRequestToCommentDto(
                createCommentRequest);
        List<CommentDto> comments = feedService.createComment(id, requestCommentDto);
        return ResponseEntity.ok(ResponseDto.builder().success(true)
                .body(comments.stream().map(feedDtoMapper::commentDtoToCommentResponse)
                        .collect(Collectors.toList())).build());
    }

    /**
     * [POST] /api/feed/like/{feed_id} : 좋아요 업데이트
     */
    @PutMapping("/api/feed/like/{feedId}/{id}")
    public ResponseEntity<ResponseDto> updateLike(@PathVariable Long id, @PathVariable Long feedId,
            @RequestBody @Valid UpdateLikeRequest updateLikeRequest) {
        feedService.updateLike(id, feedId, updateLikeRequest.getIsLiked());
        return ResponseEntity.ok(ResponseDto.builder().success(true).body(null).build());
    }


}
