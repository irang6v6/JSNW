package com.osakak.jusangnakwon.domain.liquor.dao.liquor;

import com.osakak.jusangnakwon.domain.liquor.dto.LiquorListItemDto;
import com.osakak.jusangnakwon.domain.liquor.entity.liquor.Hometender;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface HometenderRepository extends JpaRepository<Hometender, Long>,HometenderQueryRepository {
    /**
     * 전체 커스텀 칵테일 랭킹순 조회
     *
     * @param pageable 페이징 정보
     * @return 페이징 포함 커스텀 칵테일 리스트
     */
    @Query("select new com.osakak.jusangnakwon.domain.liquor.dto.LiquorListItemDto(l.id, l.name, l.img, l.liquorType) " +
            "from Hometender l " +
            "order by l.ratingAvg desc, l.name ")
    Page<LiquorListItemDto> findListByRatingIsNotLoggedIn(Pageable pageable);

    @Query("select l from Hometender l where l.name like :keyword%")
    Optional<List<Hometender>> findByKeyword(@Param("keyword") String keyword);

    /**
     * 칵테일 랜덤 조회
     *
     * @return 랜덤으로 뽑힌 칵테일 반환
     */
    @Query("select l from Hometender l order by FUNCTION('RAND')")
    Page<Hometender> findByRandom(Pageable pageable);

    @Query("select w from Hometender w WHERE w.id IN :similarHometenderUniqueList ")
    Page<Hometender> findById(Set<Long> similarHometenderUniqueList, Pageable pageable);

    @Query("select l from  Hometender l where l.id in (:id)")
    List<Hometender> findByIdList(@Param("id") List<Long> id);

    @Query("select new com.osakak.jusangnakwon.domain.liquor.dto.LiquorListItemDto(l.id, l.name, l.img, l.liquorType, s.scrapped) " +
            "from Hometender l " +
            "left join fetch Scrap s " +
            "on l.liquorType=s.liquorType and l.id=s.liquorId and s.user.id=:userId " +
            "order by l.ratingAvg desc, l.name ")
    Page<LiquorListItemDto> findListByRatingIsLogin(Pageable pageable, Long userId);

    @Query("select l from Hometender l order by l.ratingAvg desc, l.name ")
    Page<Hometender> findByRatingAvg(Pageable pageable);
}
