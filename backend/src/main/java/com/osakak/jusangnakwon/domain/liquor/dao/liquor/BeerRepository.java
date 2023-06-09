package com.osakak.jusangnakwon.domain.liquor.dao.liquor;

import com.osakak.jusangnakwon.domain.liquor.dto.LiquorListItemDto;
import com.osakak.jusangnakwon.domain.liquor.entity.liquor.Beer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Long>, BeerQueryRepository {
    /**
     * 전체 맥주 랭킹순 조회
     *
     * @param pageable 페이징 정보
     * @return 페이징 포함 맥주 리스트
     */
    @Query("select new com.osakak.jusangnakwon.domain.liquor.dto.LiquorListItemDto(l.id, l.name, l.img, l.liquorType) " +
            "from Beer l " +
            "order by l.ratingAvg desc , l.name")
    Page<LiquorListItemDto> findListByRatingIsNotLoggedIn(Pageable pageable);

    /**
     * 키워드를 포함하는 술 이름 조회 (다른 주종 동일)
     *
     * @param keyword 사용자 입력 키워드
     * @return 술 객체 리스트
     */
    @Query("select l from Beer l where l.name like :keyword%")
    Optional<List<Beer>> findByKeyword(@Param("keyword") String keyword);

    @Query("select l from  Beer l where l.id in (:id)")
    List<Beer> findByIdList(@Param("id") List<Long> id);

    @Query("select new com.osakak.jusangnakwon.domain.liquor.dto.LiquorListItemDto(w.id,w.name,w.img,w.liquorType,s.scrapped) from Beer w left join Scrap s on s.liquorId = w.id and w.liquorType = s.liquorType and s.user.id = :userId WHERE w.id IN :similarBeerUniqueList ")
    Page<LiquorListItemDto> findById(Set<Long> similarBeerUniqueList, Pageable pageable, @Param("userId") Long userId);

    @Query("select new com.osakak.jusangnakwon.domain.liquor.dto.LiquorListItemDto(l.id, l.name, l.img, l.liquorType, s.scrapped) " +
            "from Beer l " +
            "left join fetch Scrap s " +
            "on l.liquorType=s.liquorType and l.id=s.liquorId and s.user.id=:userId " +
            "order by l.ratingAvg desc, l.name")
    Page<LiquorListItemDto> findListByRatingIsLogin(Pageable pageable, Long userId);
}
