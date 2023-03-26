package com.osakak.jusangnakwon.domain.liquor.api;

import com.osakak.jusangnakwon.common.response.ResponseDto;
import com.osakak.jusangnakwon.domain.liquor.api.response.LiquorListMainResponse;
import com.osakak.jusangnakwon.domain.liquor.api.response.LiquorSearchResponse;
import com.osakak.jusangnakwon.domain.liquor.application.LiquorCommonService;
import com.osakak.jusangnakwon.domain.liquor.application.LiquorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Tag(name = "liquor", description = "공통 술 api")
@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class LiquorController {
    private final LiquorCommonService liquorCommonService;

    /**
     * 홈텐더 랜덤 추천
     * user state: logged in / not logged in
     *
     * @return 홈텐더 1개 추천
     */
    @GetMapping("rd/hometender")
    @ApiOperation(value = "랜덤 홈텐더 추천", notes = "홈텐더 칵테일 중 하나를 랜덤으로 추천합니다")
    @ApiResponses(
            @ApiResponse(code = 200, message = "성공")
    )
    @Tag(name = "liquor")
    public ResponseEntity<ResponseDto> randHometender() {

        return ResponseEntity.ok(ResponseDto.builder().build());
    }

    /**
     * 술 이름으로 검색
     *
     * @param keyword: 술 이름
     * @return 술 이름 조회 결과
     */
    @GetMapping("search/{keyword}/{curpage}")
    @Tag(name = "liquor")
    public ResponseEntity<ResponseDto> searchLiquor(@PathVariable String keyword, @PathVariable(value = "curpage") int curPage) {
        LiquorListMainResponse liquorSearchResponse = liquorCommonService.searchLiquorByKeyword(curPage, keyword);

        ResponseDto responseDto = ResponseDto.builder()
                .body(liquorSearchResponse)
                .success(true).build();
        return ResponseEntity.ok(responseDto);
    }
}
