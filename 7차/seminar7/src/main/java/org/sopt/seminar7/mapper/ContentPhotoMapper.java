package org.sopt.seminar7.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.sopt.seminar7.dto.ContentPhoto;

import java.util.List;

/**
 * Created by ds on 2018-12-06.
 */

@Mapper
public interface ContentPhotoMapper {

    /**
     * 컨텐츠 사진 조회
     * @param contentIdx 컨텐츠 고유 번호
     * @return 사진 리스트
     */
    @Select("SELECT * FROM contentPhoto WHERE contentIdx = #{contentIdx}")
    List<ContentPhoto> findAllByContentIdx(@Param("contentIdx") final int contentIdx);

    /**
     * 사진 저장
     *
     * @param contentIdx 컨텐츠 고유 번호
     * @param photoUrl   사진 경로
     */
    @Insert("INSERT INTO contentPhoto(contentIdx, photoUrl) VALUES(#{contentIdx}, #{photoUrl})")
    void save(@Param("contentIdx") final int contentIdx, @Param("photoUrl") final String photoUrl);
}
