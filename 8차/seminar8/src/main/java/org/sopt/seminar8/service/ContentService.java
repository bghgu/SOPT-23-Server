package org.sopt.seminar8.service;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar8.domain.Content;
import org.sopt.seminar8.model.ContentReq;
import org.sopt.seminar8.model.DefaultRes;
import org.sopt.seminar8.repository.ContentRepository;
import org.sopt.seminar8.utils.ResponseMessage;
import org.sopt.seminar8.utils.StatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by ds on 2018-12-19.
 */

@Slf4j
@Service
public class ContentService {

    private final ContentRepository contentRepository;

    public ContentService(final ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public DefaultRes<List<Content>> findAll() {
        List<Content> contentList = contentRepository.findAll();
        return DefaultRes.res(StatusCode.OK, "조회 성공", contentList);
    }

    @Transactional
    public DefaultRes save(final ContentReq contentReq) {
        try {
            contentRepository.save(contentReq);
            return DefaultRes.res(StatusCode.CREATED, "저장 성공");
        } catch (Exception e) {
            log.info(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }

    @Transactional
    public DefaultRes deleteByContentIdx(final int contentIdx) {
        try {
            contentRepository.deleteById(contentIdx);
            return DefaultRes.res(StatusCode.NO_CONTENT, "삭제 성공");
        } catch (Exception e) {
            log.error(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }
}
