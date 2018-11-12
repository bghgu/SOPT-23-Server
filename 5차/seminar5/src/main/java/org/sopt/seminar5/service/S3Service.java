package org.sopt.seminar5.service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;

/**
 * Created by ds on 2018-11-12.
 */

@Slf4j
@Component
public class S3Service {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final AmazonS3Client amazonS3Client;

    public S3Service(final AmazonS3Client amazonS3Client) {
        this.amazonS3Client = amazonS3Client;
    }

    //S3에 파일을 업로드한다.
    @Transactional
    public void uploadOnS3(final String fileName, final File file) {
        //AWS S3 전송 객체 생성
        final TransferManager transferManager = new TransferManager(this.amazonS3Client);
        //요청 객체 생성
        final PutObjectRequest request = new PutObjectRequest(bucket, fileName, file);
        //업로드 시도
        final Upload upload = transferManager.upload(request);

        try {
            //완료 확인
            upload.waitForCompletion();
        } catch (AmazonClientException amazonClientException) {
            log.error(amazonClientException.getMessage());
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
